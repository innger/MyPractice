package com.ryl.learn.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * 自定义mybastis
 * Created on 16/9/28 10:52.
 */
@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
		@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class PageHelper implements Interceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(PageHelper.class);
	
	public static final ThreadLocal<Page> localPage = new ThreadLocal<Page>();
	
	public static void startPage(int pageNum, int pageSize) {
		localPage.set(new Page(pageNum, pageSize));
	}
	
	public static Page endPage() {
		Page page = localPage.get();
		localPage.remove();
		return page;
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (localPage.get() == null) {
			return invocation.proceed();
		}
		if (invocation.getTarget() instanceof StatementHandler) {
			StatementHandler handler = (StatementHandler) invocation.getTarget();
			MetaObject metaObject = SystemMetaObject.forObject(handler);
			// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
			while (metaObject.hasGetter("h")) {
				Object object = metaObject.getValue("h");
				metaObject = SystemMetaObject.forObject(object);
			}
			while (metaObject.hasGetter("target")) {
				Object object = metaObject.getValue("target");
				metaObject = SystemMetaObject.forObject(object);
			}
			MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
			Page page = localPage.get();
			BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
			String sql = boundSql.getSql();
			String pageSql = buildPageSql(sql, page);
			logger.info("PageHelper pageSql={}", pageSql);
			metaObject.setValue("delegate.boundSql.sql", pageSql);
			Connection connection = (Connection) invocation.getArgs()[0];
			setPageParameter(sql, connection, mappedStatement, boundSql, page);
			return invocation.proceed();
		} else if (invocation.getTarget() instanceof ResultSetHandler) {
			Object result = invocation.proceed();
			Page page = localPage.get();
			page.setResult((List) result);
			return result;
		}
		return null;
	}
	
	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}
	
	@Override
	public void setProperties(Properties properties) {
		logger.info("PageHelper setProperties properties={}", properties);
	}
	
	private String buildPageSql(String sql, Page page) {
		StringBuilder pageSql = new StringBuilder();
		pageSql.append("select * from ( ");
		pageSql.append(sql);
		pageSql.append(" ) a limit ");
		pageSql.append(page.getStartRow());
		pageSql.append(",");
		pageSql.append(page.getPageSize());
		return pageSql.toString();
	}
	
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql, Page page) {
		String countSql = "select count(1) from ( " + sql + " ) a";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
			ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, countBS.getParameterObject(), boundSql);
			parameterHandler.setParameters(ps);
			rs = ps.executeQuery();
			int total = 0;
			if (rs.next()) {
				total = rs.getInt(1);
			}
			page.setTotal(total);
			int pages = total / page.getPageSize() + ((total % page.getPageSize() == 0) ? 0 : 1);
			page.setPages(pages);
		} catch (SQLException ex) {
			logger.error("ignore this exception", ex);
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
