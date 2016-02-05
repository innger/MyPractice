#日常整理SQL

##发票导出
```
select a.invoice_id as '发票流水号',a.user_id as '用户id',b.diu as '设备号diu',c.product_name as '产品名称',
a.consignee_name as '收货人姓名' , a.consignee_tel as '收货人电话', a.province as '省',a.city as '市',
a.district as '区',a.address_detai as '详细地址',
a.total_fee as '发票总金额', 
case invoice_type 
	when 1 then '个人'
	when 2 then '公司'
	else '未知'
end as '发票类型',
a.invoice_title as '发票抬头',
case deliver_time_limit
	when 0 then '无限制'
	when 1 then '只限周末'
	when 2 then '只限工作日'
	else '未知'
end as '收货时间限制',

a.create_time as '申请日期'

 from invoice a left join 
( select * from `order` where pay_info = 'success' group by invoice_id ) b 
on (a.invoice_id = b.invoice_id)
left join product c 
on (b.product_code = c.product_code)
where a.create_time >= '2016-01-29 00:00:00'
```