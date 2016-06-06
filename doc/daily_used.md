# 2016-06-06
Linux socket消耗内存
sysctl -a | grep 'net.ipv4.tcp' | grep mem

```
net.ipv4.tcp_mem = 365856       487808  731712  tcp栈内存使用,每个值单位是内存页(通常是4K)
net.ipv4.tcp_wmem = 4096        16384   4194304 socket发送缓冲区分配最少,默认,最大字节数
net.ipv4.tcp_rmem = 4096        87380   4194304 socket接收缓冲区分配最少,默认,最大字节数
```
就是说，每个tcp连接的socket，至少需要8k字节，那么对于8G内存的机器，如果不考虑swap等其他因素，最多支持并发100万个tcp socket

[linux最大文件句柄数量总结](http://jameswxx.iteye.com/blog/2096461)
```
ulimit -n

vi /etc/security/limits.conf
soft nofile 100000
hard nofile 100000

cat /proc/sys/fs/file-max
```
# 2016-04-05

logback默认应该使用程序运行时的编码，也就是tomcat启动时的编码，那么就可以通过设置tomcat启动时的JVM参数来更改编码：
   打开catalina.bat，在代码的第一行即set CATALINA_OPTS之前，增加一行：
   set JAVA_OPTS=%JAVA_OPTS%  -Dfile.encoding=UTF-8
   重新启动tomcat测试，日志文件正常。

vim设置编码:
* :set encoding
* :set fileencoding
* :set fileencodings
* :set termencoding
<br>
如果是GB18030,会提示无效的编码字符,使用如下设置:
```
:edit ++enc=gb18030
```

# 2016-04-01
 左脚底还是持续疼,昨天试着想跑跑,结果不到一公里就疼得受不了停下了,心情非常沮丧,既然身体让我休息,那就安心歇歇养伤吧
 希望早点恢复

# 2016-02-24
 IDEA-15破解网址
 license server: <br>
  http://www.iteblog.com/idea/key.php <br>
  http://us.idea.lanyus.com/ <br>
  http://idea.lanyus.com <br>
  http://15.idea.lanyus.com/ <br>
  
  默认idea.vmoptions配置
  ```
  -Xms128m 
  -Xmx750m
  -XX:MaxPermSize=350m
  -XX:ReservedCodeCacheSize=240m
  -XX:+UseCompressedOops
  ```

# 2016-02-15
 * 练习思维,预防秀逗,不为什么
 * 就跟跑步一样,不为愉悦别人,只为讨好自己,体验其中的过程
 * 过去的就过去吧,往事留在风中,往前看
 
 过年回来第一天开工,仔细看看 gate-connector 长连接工程
 
 
# 2016-02-14
情人节,本来想发到朋友圈里的,想了想作为单身汪还是算了,跑步就专心跑步.
>爱与被爱,是这个世界上最重要的事情 **<<滚蛋吧,肿瘤君>>** <br>
>贱贱的人类啊,就是因为被爱才觉得自己与众不同 **<<女王乔安>>**
 
# 2016-02-05 
年前最后一天上班,把电脑拿到公司,配置了一下 [Idea](https://github.com/ViceFantasyPlace/activate-power-mode) 和 [Atom](https://github.com/JoelBesada/activate-power-mode) 的activate-power-mode插件
感受了一把狂拽炫酷吊炸天,过年啦也放礼花庆祝一下,以后就用这个啦

IDEA中编译plugin
```
git clone https://github.com/ViceFantasyPlace/activate-power-mode.git
Build -> Prepare Plugin Moudle 'activate-power-mode' For Deployment 
```
直接install plugin from disk 选择生成的jar包即可

*Atom* *markdown*大赞,怎么会有这么好的工具

这些工具/插件的大神们,真的提升幸福感,世界很大,多体验点有意思的

年后把小黑升级一下8G内存,SSD整上
