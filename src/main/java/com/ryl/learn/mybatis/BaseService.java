package com.ryl.learn.mybatis;

import com.ryl.learn.mybatis.pojo.Invoice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created on 16/9/28 13:40.
 */
public class BaseService {
	
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Invoice invoice = session.selectOne("com.ryl.learn.mybatis.mapper.InvoiceMapper.selectByPrimaryKey", "1442375603019177");
		System.out.println(invoice);
		System.out.println();
		session.close();
		
		for(int i = 1; i < 5; i++) {
			session = factory.openSession();
			PageHelper.startPage(i, 3);
			List<Invoice> list = session.selectList("com.ryl.learn.mybatis.mapper.InvoiceMapper.getAllInvoice");
			System.out.println(list.size() + " " + list);
			Page<Invoice> page = PageHelper.endPage();
			System.out.println(page);
			System.out.println("");
			session.close();
		}
		
	}
	
}
