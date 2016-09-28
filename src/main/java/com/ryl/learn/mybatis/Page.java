package com.ryl.learn.mybatis;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 分页类
 * Created on 16/9/28 11:08.
 */
public class Page<E> {
	
	private int pageNum;
	private int pageSize;
	private int startRow;
	private int endRow;
	private long total;
	private int pages;
	private List<E> result; 
	
	public Page(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;
		this.endRow = pageNum * pageSize;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List getResult() {
		return result;
	}
	
	public void setResult(List<E> result) {
		this.result = result;
	}
	
	public int getStartRow() {
		return startRow;
	}
	
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	public int getEndRow() {
		return endRow;
	}
	
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
