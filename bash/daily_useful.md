#### Mac OS/Linux命令查询网络端口占用情况
```
netstat -an | grep 3306

list open file -i参数表示网络链接，:80指明端口号，该命令会同时列出PID，方便kill
lsof -i:80
```
