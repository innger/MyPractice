转自:[http://bbs.byr.cn/#!article/Java/47587](http://bbs.byr.cn/#!article/Java/47587)

1. Java标准规定，byte的范围是-0x80到0x7f，short的范围是-0x8000到0x7fff，int的范围是-0x80000000到0x7fffffff，long的范围是-0x8000000000000000L到0x7fffffffffffffffL。

2. float和double采用IEEE754浮点数格式。

3. byte,short,int,long都是有符号的，采用补码（2's complement）表记法

4. 因为上述原因，int数2147483647（2的31次方减1）再加1，结果是-2147483648。

5. 因为上述原因，只要x是有符号的，编译器就不可以假设x<x+1这样的表达式永远为真，因为x+1有可能突然变成负的。

6. 因为上述原因，可以用判断符号的方法判断有符号整数是否溢出，如：

```
void f(int x, int delta) {
    assert(x>=0 && delta>=0);
    int y = x + delta
    if (y < 0) {
        throw new ArithmeticException("Overflow when adding");
    }
 
    // continue from here...
}
```

但从Java1.8开始，用Math.addExact可以完成同样的工作：
```
void f(int x, int delta) {
    assert(x>=0 && delta>=0);
    int y = Math.addExact(x, delta);
    // continue from here...
}
```

7. 整数除以0的行为是：抛出ArithmeticException。

8. 因为上述原因，如果在进行除法运算之前判断除数不为0，那么就不会抛出ArithmeticException，即：

```
int x = ..., y = ...;
if (y != 0) {
    return x / y; // 这行是安全的，因为y不可能为0，即使x==-2147483648且y==-1也不会抛异常
}
```

9. char的范围是0-65535

10. 一个char表示一个unicode字符，不管它是中文还是英文，不管它用utf8或者gb18030编码出来是几个字节。

11. boolean的值不是true就是false。

12. 一个IEEE754的浮点数表示一个数。由于精度有限，虽然不是所有的数都可以表示，但只要能表示的，IEEE754就严格地、精确地表示那一个数，而不是一个范围。

13. IEEE754浮点数的下列六个运算：加、减、乘、除、开平方、FMA（fma(a,b,c) = a * b + c，但是一步完成，不是两步），都是精确的。即，只要数学结果可以用和参数相同的IEEE754格式表示，在不同的机器上执行的结果就一定一样。所以，5.0 + 3.0 == 8.0在任何地方都是真的。

14. 对于int型整数x,y，移位运算x<<y相当于x<<(y & 0x1f)，即只取y的最低5位。所以x<<32相当于x<<0也即是x。【修正：应该是&而不是%】

15. 类似地，x<<(-2)相当于x<<30，因为(-2) & 0x1f == 30。

16. 存在某个float或者double型的值x，使得x == x为假。

17. Java求表达式的值时，按先左后右（a+b，先求a后求b），先操作数运算符（如a+b，加法要在a、b都求完之后才求）的原则，同时尊重优先级和括号。如果表达式有副作用（如i++），那么副作用发生的时间和表达式求值相同。

18. Java的程序，在函数调用时，函数的实际参数按从左往右的顺序求值（如f(a,b,c)，先求a，然后b，再c），然后将值传入被调用函数。Java没有C++的“按引用传递”，即使引用类型也是“按值传递”。

19. Java的引用不是指向null就是指向某个活着的对象。不可能指向一个已经被垃圾回收器回收了的对象。

20. 虽然Java和JVM都没有规定使用什么垃圾回收算法，但在主流的JVM实现里，循环引用（如对象a引用对象b，且b引用a）并不会引起内存泄露。

21. Java里所有的class类型都是“引用类型”，即，如果有类型T的变量a，那么a是一个指向一个类型为T（或者其子类）的对象的引用，而不是这个对象本身。如果把a赋值给b，那么拷贝的是引用，而不是值。

22. Java里，长度是数组对象的一部分。如果a是int[]型，那么a.length就是它的长度。

23. Java没有“函数指针”、“函数引用”类型。

24. 尽管openjdk的实现里面，PrintStream的println方法是加了synchronized块的，但Java API并没有规定System.out.println是线程安全的。

25. public static void main(String[] args)和static public void main(String[] args)都是正确的main函数的签名。

26. 局部变量如果没有初始化就读取，是编译错误。

27. Java的特色是面向对象编程。Java语言规定，类的实例和数组都是对象。

28. Java的类只支持单继承，不能继承多个类，但可以实现多个接口。

29. Java的类的方法成员，如果没有加private、static和final，就是可以重写（override）的，相当于C++里的虚函数。

30. Java里，只要有一个abstract成员，那么这个类就必须标记为abstract，并且不可以有实例。

31. Java的Object类定义了finalize方法，用于对象被垃圾回收的时候清理用。但Java既没有规定垃圾回收器是否一定要在一个对象失去最后一个引用的时候立即回收，也没有规定垃圾回收器什么时候运行，甚至也没有规定在程序退出之前必须回收所有的对象。所以，完全有可能一个对象的finalize方法从来没有被调用过。

32. Java里的异常，除了Error以及RuntimeException的子类外，都是checked exception。Java语言里，函数中有可能抛出checked exception却没有声明，是编译错误。

33. 存在一种高效的“零代价”异常处理（即try{...}catch(...){...}）方法。即：如果程序不抛出异常，那么程序运行的效率接近于try-catch根本不存在的情况。所以，在java里，如果异常情况很罕见，那么用抛异常的方法处理异常情况，比返回特殊值效率更高。

34. 如果整个栈上没有任何函数可以捕获异常，那么Java会执行每个函数里finally块，然后执行该线程的uncaught exception handler。例如：main函数调用f，f调用g，g调用h，h抛出了异常，此时h,g,f,main中的当前执行的位置都被try-catch-finally块包围，但它们的catch块都不能抓住这个异常。那么Java会顺次执行h,g,f,main里的finally块，然后执行当前线程的uncaught excepiton handler。

35. 即使有“零代价”异常处理，意思也只是说“没有异常”的时候代价不大。当异常真的被抛出的时候，代价还是比返回一个特殊值要大。所以，如果设计一个容器，如hashmap，如果认为绝大多数“查找”操作都找不到元素，那么应该让“找不到”的情况返回特殊值（如null，或者Java 1.8里的Optional.empty），而不是抛出异常。

36. Java的.class文件格式保持一定的二进制兼容性。所以，如果一个类A在某个版本增加了一个新的方法m，而另一个类B编译的时候参考的是老版本的A，那么这个新增加的方法m并不会使得B无法工作。

37. Java 1.8的lambda表达式可以用来创建匿名内部类的实例。这个类继承一个现有的抽象类或者接口。如果这个类或者接口有且只有一个抽象方法，就可以用lambda表达式。即：

```
    class Foo {
      public int foo1() { ... }
      public String foo2() { ... }
      public absract int theOnlyAbstractMethod(int x, int y);
    }
 
    class Bar {
      void baz(Foo x) { ...}
      void f() {
        baz((x,y) -> x+y); // 因为Foo只有一个抽象方法，所以可以用lambda表达式，且这个lambda函数体实现theOnlyAbstractMethod
      }
    }

```

38. Java里，String是不可变的。两个字符串相加，并不改变任何一个字符串的值，但有可能会因此构造出大量的String对象，而影响效率。所以，要逐步构造String，建议使用StringBuilder。但Java也允许优化器把字符串串接运算（如"abc" + x + "def"）优化成用StringBuilder来做。

39. 有两个线程t1和t2，和一个共享的非volatile的long型类成员变量x，初值为v1。如果t1给x赋值v2，而t2读x的值，除此之外不存在任何对x的赋值，且两个线程之间没有任何同步。那么t2仍有可能读到一个既不是v1也不是v2的值。

40. 有两个线程t1和t2，和两个volatile的long型类成员变量x和y，初始值都是0。线程t1按顺序执行x=1; y=2;，线程t2按顺序执行long yy = y; long xx = x;，那么不管在什么计算机上，不管优化器如何优化（比如交换指令的顺序），Java都保证t2绝不可能看到yy==2且xx==0。

41. 多个线程可以在多个CPU上同时执行，也可以被任意调度，谁先执行谁后执行，或者如何交错执行，是不一定的。而且，一个多线程的程序执行的结果，有可能和任何串行化执行（即把各个线程的所有动作任意交错地串成一个线程来顺序执行）的结果都不一样。

42. Java允许垃圾回收器把对象从内存里的一个地方移动到另一个地方，而应用程序并不知道。

43. 允许对象搬动，会使得对象分配（即new）的效率超过C语言默认的malloc和free，同时避免内存碎片（当然，不可能完全避免，但起码可以保证某个百分比的内存是可以用的。）。所以，即使有大型软件从C++移植到Java而性能提升20%，也并不奇怪。

44. 一般来说，绝大多数对象都“早死”。如果一个对象在一次垃圾回收中没有被回收（即：在一次垃圾回收中“存活”了下来），那么下次垃圾回收时，它比起新创建的对象来说，被回收的可能性更低。
