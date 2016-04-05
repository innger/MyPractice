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

# 2016-02-14
情人节,本来想发到朋友圈里的,想了想作为单身汪还是算了,跑步就专心跑步.
>爱与被爱,是这个世界上最重要的事情 **<<滚蛋吧,肿瘤君>>**
>贱贱的人类啊,就是因为被爱才觉得自己与众不同 **<<女王乔安>>**

# 2016-02-15
 * 练习思维,预防秀逗,不为什么
 * 就跟跑步一样,不为愉悦别人,只为讨好自己,体验其中的过程
 * 过去的就过去吧,往事留在风中,往前看
 
 过年回来第一天开工,仔细看看 gate-connector 长连接工程
 
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

# 2016-04-01
 左脚底还是持续疼,昨天试着想跑跑,结果不到一公里就疼得受不了停下了,心情非常沮丧,既然身体让我休息,那就安心歇歇养伤吧
 希望早点恢复