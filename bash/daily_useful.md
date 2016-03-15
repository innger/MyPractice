#### Mac OS/Linux命令查询网络端口占用情况
```
netstat -an | grep 3306

list open file -i参数表示网络链接，:80指明端口号，该命令会同时列出PID，方便kill
lsof -i:80
```

#### 常用Linux命令
从服务器上拉取日志文件到本机
> rsync -zvrtopg -progress -e 'ssh -p 22' 用户名@:/文件目录/  本地（即跳板机）的目录地址
- rsync -zvrtopg -e "ssh" yulong.ryl@10.180.24.175:/home/admin/mom/logs/access.log ./