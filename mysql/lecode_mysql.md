#leetcode mysql练习
2016-02-04 完成SQL
**185 Department Top Three Salaries** group by求top N,搜一下好多解法,[参考这个](http://blog.csdn.net/acmain_chm/article/details/4126306)
**177 Nth Highest Salary** 用到自定义函数,设置变量DECLARE SET
[参考地址](https://leetcode.com/problemset/database/)

现在工作没有统计相关内容,估计以后也很少能像在*游戏*接触那么复杂的SQL查询,但不能丢.

##[*175 Combine Two Tables*](https://leetcode.com/problems/combine-two-tables/)
```
select p.FirstName,p.LastName,a.City,a.State from Person p left join Address a
on (p.PersonId = a.PersonId)
```

##[*176 Second Highest Salary*](https://leetcode.com/problems/second-highest-salary/)
```
select if(count(1) > 0,a.Salary,null) as SecondHighestSalary from (
    select Salary from Employee where Salary < (select max(Salary) from Employee) order by Salary desc limit 1
) a
```

##[*177 Nth Highest Salary*](https://leetcode.com/problems/nth-highest-salary/)
```
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N - 1;
  RETURN (
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1
      # Write your MySQL query statement below.
      #select if(count(1) <0 ,null,b.Salary) as Salary from (
      #    select a.Salary from (
      #      select distinct Salary from Employee
      #    ) a order by a.Salary desc limit M,1
      #) b
  );
END
```

##[*178 Rank Scores*](https://leetcode.com/problems/rank-scores/)
```
select m.Score as Score,n.Rank as Rank from Scores m left join  (

select b.Score as Score,@rownum:=@rownum+1 Rank from (
	select @rownum:=0,a.Score from (
		select distinct Score from Scores order by Score desc
	) a
) b

) n on (m.Score = n.Score)
order by n.Rank
```

##[*180 Consecutive Numbers*](https://leetcode.com/problems/consecutive-numbers/)
```
select distinct (a.Num) as Num from Logs a left join Logs b
on(a.Id = b.Id - 1)
left join Logs c
on(a.Id = c.Id - 2)
where a.Num = b.Num and a.Num = c.Num
```

##[*181 Employees Earning More Than Their Managers*](https://leetcode.com/problems/employees-earning-more-than-their-managers/)
```
select a.Name as Employee from (
select * from Employee where ManagerId is not null
) a left join Employee b
on(a.ManagerId = b.Id)
where a.Salary > b.Salary
```

##[*182 Duplicate Emails*](https://leetcode.com/problems/duplicate-emails/)
```
select Email from Person group by Email having count(1) > 1
```

##[*183 Customers Who Never Order*](https://leetcode.com/problems/customers-who-never-order/)
```
select a.Name as Customers from Customers a left join Orders b
on(a.id = b.CustomerId)
where b.Id is null
```

##[*184 Department Highest Salary*](https://leetcode.com/problems/department-highest-salary/)
```
select c.Name as Department,a.Name as Employee,b.Salary from Employee a inner join (

select DepartmentId,max(Salary) as Salary from Employee group by DepartmentId

) b on (a.Salary = b.Salary and a.DepartmentId = b.DepartmentId)

inner join Department c
on (b.DepartmentId = c.Id)
```

##[*185 Department Top Three Salaries*](https://leetcode.com/problems/department-top-three-salaries/)
```
select d.Name,c.Name,c.Salary from (
select a.Name,a.Salary,a.DepartmentId from Employee a left join
 (select DepartmentId,Salary from Employee group by DepartmentId,Salary) b
on(a.DepartmentId = b.DepartmentId and a.Salary < b.Salary)
group by a.Id,a.DepartmentId,a.Salary
having count(b.Salary) < 3
order by a.DepartmentId,a.Salary desc
) c left join Department d
 on(c.DepartmentId = d.Id)
 where d.Id is not null
```

##[*196 Delete Duplicate Emails*](https://leetcode.com/problems/delete-duplicate-emails/)
```
delete a.* from Person a left join (
    select min(Id) as Id from Person group by Email
) b on (a.Id = b.Id)
where b.Id is null
```

##[*197 Rising Temperature*](https://leetcode.com/problems/rising-temperature/)
```
select b.Id from Weather a left join Weather b
on( a.Date = DATE_SUB(b.Date, INTERVAL 1 day))
where b.Temperature > a.Temperature
```

##[*262 Trips and Users*](https://leetcode.com/problems/trips-and-users/)
```
select m.Request_at as Day, round(ifnull(n.cal_num,0)/ifnull(m.total_num,1),2) as 'Cancellation Rate' from (

	select Request_at,count(1) as total_num from (select * from Trips where Request_at >= '2013-10-01' and Request_at <= '2013-10-03' ) a left join
	(select * from Users where Role = 'client' and Banned = 'No') b
	on(a.Client_id = b.Users_Id)
	where b.Users_id is not null
	group by Request_at

) m left join (

	select Request_at,count(1) as cal_num from (select * from Trips where (`Status` = 'cancelled_by_client' or `Status` = 'cancelled_by_driver') and Request_at >= '2013-10-01' and Request_at <= '2013-10-03' ) a left join
	(select * from Users where Role = 'client' and Banned = 'No') b
	on(a.Client_id = b.Users_Id)
	where b.Users_id is not null
	group by Request_at

) n on (m.Request_at = n.Request_at)

order by m.Request_at
```