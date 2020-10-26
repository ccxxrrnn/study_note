# **一、Java 基础**

### 0.装箱和拆箱*

[自动装箱和拆箱](https://www.cnblogs.com/haoyunfeng/p/9557830.html)



---

### **1. JDK 和 JRE 有什么区别？**

- JDK：Java Development Kit 的简称，java 开发工具包，提供了 java 的开发环境和运行环境。
- JRE：Java Runtime Environment 的简称，java 运行环境，为 java 的运行提供了所需环境。

具体来说 JDK 其实包含了 JRE，同时还包含了编译 java 源码的编译器 javac，还包含了很多 java 程序调试和分析的工具。简单来说：如果你需要运行 java 程序，只需安装 JRE 就可以了，如果你需要编写 java 程序，需要安装 JDK。



---

### **2. == 和 equals 的区别是什么？**

**== 解读**

对于基本类型和引用类型 == 的作用效果是不同的，如下所示：

- 基本类型：比较的是值是否相同；
- 引用类型：比较的是引用是否相同；

**equals 解读**

equals 本质上就是 ==，只不过 String 和 Integer 等重写了 equals 方法，把它变成了值比较。看下面的代码就明白了。

**总结** ：== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；而 equals 默认情况下是引用比较，只是很多类重新了 equals 方法，比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等。



---

### **3. 两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？**

​	不对，两个对象的 hashCode()相同，equals()不一定 true。

​	很显然“通话”和“重地”的 hashCode() 相同，然而 equals() 则为 false，因为在散列表中，hashCode()相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等。



---

### **4. final 在 java 中有什么作用？**

- final 修饰的类叫最终类，该类不能被继承。
- final 修饰的方法不能被重写。
- final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。

---

### **5. java 中的 Math.round(-1.5) 等于多少？**

等于 -1，因为在数轴上取值时，中间值（0.5）向右取整，所以正 0.5 是往上取整，负 0.5 是直接舍弃。



---

### **6. String 属于基础的数据类型吗？**

String 不属于基础类型，基础类型有 8 种：byte、boolean、char、short、int、float、long、double，而 String 属于对象。



---

### **7. java 中操作字符串都有哪些类？它们之间有什么区别？**

操作字符串的类有：String、StringBuffer、StringBuilder。

String 和 StringBuffer、StringBuilder 的区别在于 String 声明的是不可变的对象，每次操作都会生成新的 String 对象，然后将指针指向新的 String 对象，而 StringBuffer、StringBuilder 可以在原有对象的基础上进行操作，所以在经常改变字符串内容的情况下最好不要使用 String。

StringBuffer 和 StringBuilder 最大的区别在于，StringBuffer 是线程安全的，而 StringBuilder 是非线程安全的，但 StringBuilder 的性能却高于 StringBuffer，所以在单线程环境下推荐使用 StringBuilder，多线程环境下推荐使用 StringBuffer。



---

### **8. String str="i"与 String str=new String("i")一样吗？**

不一样，因为内存的分配方式不一样。String str="i"的方式，java 虚拟机会将其分配到常量池中；而 String str=new String("i") 则会被分到堆内存中。



---

### **9. 如何将字符串反转？**

使用 StringBuilder 或者 stringBuffer 的 reverse() 方法。



---

### **10. String 类的常用方法都有那些？**

- indexOf()：返回指定字符的索引。
- charAt()：返回指定索引处的字符。
- replace()：字符串替换。
- trim()：去除字符串两端空白。
- split()：分割字符串，返回一个分割后的字符串数组。
- getBytes()：返回字符串的 byte 类型数组。
- length()：返回字符串长度。
- toLowerCase()：将字符串转成小写字母。
- toUpperCase()：将字符串转成大写字符。
- substring()：截取字符串。
- equals()：字符串比较。

---

### **11. 抽象类必须要有抽象方法吗？**

不需要，抽象类不一定非要有抽象方法。



---

### **12. 普通类和抽象类有哪些区别？**

- 普通类不能包含抽象方法，抽象类可以包含抽象方法。

- 抽象类不能直接实例化，普通类可以直接实例化。

  

---

### **13. 抽象类能使用 final 修饰吗？**

不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类，如下图所示，编辑器也会提示错误信息



---

### **14. 接口和抽象类有什么区别？***

实现方式、实例化（构造函数）、主函数、数量、修饰符



- 实现：抽象类的子类使用 extends 来继承；接口必须使用 implements 来实现接口。

- 构造函数：抽象类可以有构造函数；接口不能有。

- main 方法：抽象类可以有 main 方法，并且我们能运行它；接口不能有 main 方法。

- 实现数量：类可以实现很多个接口；但是只能继承一个抽象类。

- 访问修饰符：

  ​	接口中的方法默认使用 public 修饰，接口只能被public,abstract修饰符修饰；

  ​	抽象类中的方法可以是任意访问修饰符。



---

### **15. java 中 IO 流分为几种？**

按功能来分：输入流（input）、输出流（output）。

按类型来分：字节流和字符流。

字节流和字符流的区别是：字节流按 8 位传输以字节为单位输入输出数据，字符流按 16 位传输以字符为单位输入输出数据。



---

### **16. BIO、NIO、AIO 有什么区别？**

[详解](https://blog.csdn.net/madongyu1259892936/article/details/79311671)

- BIO：Block IO 同步阻塞式 IO，就是我们平常使用的传统 IO，它的特点是模式简单使用方便，并发处理能力低。

- NIO：New IO 同步非阻塞 IO，是传统 IO 的升级，客户端和服务器端通过 Channel（通道）通讯，实现了多路复用。

- AIO：Asynchronous IO 是 NIO 的升级，也叫 NIO2，实现了异步非堵塞 IO ，异步 IO 的操作基于事件和回调机制。

  **各种I/O的对比**

   ***\*![img](https://img-blog.csdn.net/20180211163137810?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbWFkb25neXUxMjU5ODkyOTM2/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)\*
  
  
  
  AIO 是彻底的异步通信。
  NIO 是同步非阻塞通信。
  有一个经典的举例。烧开水。
  假设有这么一个场景，有一排水壶（客户）在烧水。
  
  AIO的做法是，每个水壶上装一个开关，当水开了以后会提醒对应的线程去处理。
  NIO的做法是，叫一个线程不停的循环观察每一个水壶，根据每个水壶当前的状态去处理。
  BIO的做法是，叫一个线程停留在一个水壶那，直到这个水壶烧开，才去处理下一个水壶。
  
  

---

### **17. Files的常用方法都有哪些？**

- Files.exists()：检测文件路径是否存在。

- Files.createFile()：创建文件。

- Files.createDirectory()：创建文件夹。

- Files.delete()：删除一个文件或目录。

- Files.copy()：复制文件。

- Files.move()：移动文件。

- Files.size()：查看文件个数。

- Files.read()：读取文件。

- Files.write()：写入文件。

  

---



### synchronized和lock区别

[各种锁](https://www.cnblogs.com/jyroy/p/11365935.html)

Synchronized和Lock的区别：Synchronized编码更简单，锁机制由JVM维护，在竞争不激烈的情况下性能更好。Lock功能更强大更灵活，竞争激烈时性能较好。

1. 性能不一样：资源竞争激烈的情况下，lock性能会比synchronize好，竞争不激烈的情况下，synchronize比lock性能好，synchronize会根据锁的竞争情况，从偏向锁-->轻量级锁-->重量级锁升级，而且编程更简单。
2. 锁机制不一样：synchronize是在JVM层面实现的，系统会监控锁的释放与否。lock是JDK代码实现的，需要手动释放，在finally块中释放。可以采用非阻塞的方式获取锁。
3. Synchronized的编程更简洁，lock的功能更多更灵活，缺点是一定要在finally里面 unlock()资源才行。
4. 用法不一样：synchronize可以用在代码块上，方法上。lock只能写在代码里，不能直接修改方法。

Lock支持的功能:

- 公平锁：Synchronized是非公平锁，Lock支持公平锁，默认非公平锁
- 可中断锁：ReentrantLock提供了lockInterruptibly（）的功能，可以中断争夺锁的操作，抢锁的时候会check是否被中断，中断直接抛出异常，退出抢锁。而Synchronized只有抢锁的过程，不可干预，直到抢到锁以后，才可以编码控制锁的释放。
- 快速反馈锁：ReentrantLock提供了trylock（）  和 trylock（tryTimes）的功能，不等待或者限定时间等待获取锁，更灵活。可以避免死锁的发生。
- 读写锁：ReentrantReadWriteLock类实现了读写锁的功能，类似于Mysql，锁自身维护一个计数器，读锁可以并发的获取，写锁只能独占。而synchronized全是独占锁
- Condition：ReentrantLock提供了比Sync更精准的线程调度工具，Condition，一个lock可以有多个Condition，比如在生产消费的业务下，一个锁通过控制生产Condition和消费Condition精准控制

------

# **二、容器**

### **18. java 容器都有哪些？**

常用容器的图录：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJT1B3UFRLSkpYYW9ydzFGSk1OUkthT1RmQzRXSVZ1WE05QzRpYUNYUnNUdTVPNTFVUGVpYmY2d2RHZkVOWEdETjV4NjVrYkpKR0NYUzZ3LzY0MA?x-oss-process=image/format,png)



---

### **19. Collection 和 Collections 有什么区别？**

- java.util.Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。
- Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。



---

### **20. List、Set、Map 之间的区别是什么？**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJT1B3UFRLSkpYYW9ydzFGSk1OUkthT2VvOXRTRGdjR1FqOHZ5MjQ5WmRGN0hJeURURWFhMFl0TlVNODdoUHNYVjhnTHJTaHk0Z2pCQS82NDA?x-oss-process=image/format,png)





---

### **21. HashMap 和 Hashtable 有什么区别？**

- hashMap和hashTable都有containsValue（）和containsKey（）方法，HashTable多一个Contains（）方法，是值比较，和containsValue()等价。

- hashTable同步的，而HashMap是非同步的，效率上比hashTable要高。

- hashMap允许空键值，而hashTable不允许。

- Hashtable继承字典，Map接口、hashMap继承虚Map，Map接口

-    HashMap是非线程安全的，只是用于单线程环境下，多线程环境下可以采用concurrent并发包下的concurrentHashMap。Hashtable线程安全。

-   哈希值的使用不同，HashTable直接使用对象的hashCode。而HashMap重新计算hash值。hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值。

-  HashTable在不指定容量的情况下的默认容量为11，而HashMap为16，Hashtable不要求底层数组的容量一定要为2的整数次幂，而HashMap则要求一定为2的整数次幂。
     Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。

     Hashtable和HashMap它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable中hash数组默认大小是11，增加的方式是 old*2+1。

-    Hashtable计算hash值，直接用key的hashCode()，而HashMap重新计算了key的hash值，Hashtable在求hash值对应的位置索引时，用取模运算，而HashMap在求位置索引时，则用与运算，且这里一般先用hash&0x7FFFFFFF后，再对length取模，&0x7FFFFFFF的目的是为了将负的hash值转化为正值，因为hash值有可能为负数，而&0x7FFFFFFF后，只有符号外改变，而后面的位都不变。

- 都实现 实现了Serializable接口，因此它支持序列化，实现了Cloneable接口，能被克隆。



---

### **22. 如何决定使用 HashMap 还是 TreeMap？**

对于在Map中插入、删除和定位元素这类操作，HashMap是最好的选择。然而，假如你需要对一个有序的key集合进行遍历，TreeMap是更好的选择。基于你的collection的大小，也许向HashMap中添加元素会更快，将map换为TreeMap进行有序key的遍历。



---

### **23. 说一下 HashMap 的实现原理？**

[红黑树](https://blog.csdn.net/wypblog/article/details/102774364)

[实例演示](https://www.cs.usfca.edu/~galles/visualization/RedBlack.html)

HashMap概述： HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。 

HashMap的数据结构： 在java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。

当我们往Hashmap中put元素时,首先根据key的hashcode重新计算hash值,根绝hash值得到这个元素在数组中的位置(下标),如果该数组在该位置上已经存放了其他元素,那么在这个位置上的元素将以链表的形式存放,新加入的放在链头,最先加入的放入链尾.如果数组中该位置没有元素,就直接将该元素放到数组的该位置上。

需要注意Jdk 1.8中对HashMap的实现做了优化,当链表中的节点数据超过八个之后,该链表会转为红黑树来提高查询效率,从原来的O(n)到O(logn)



---

### **24. 说一下 HashSet 的实现原理？**

- HashSet底层由HashMap实现
- HashSet的值存放于HashMap的key上
- HashMap的value统一为PRESENT



---

### **25. ArrayList 和 LinkedList 的区别是什么？**

[LInkedlist用法](https://blog.csdn.net/jdsjlzx/article/details/41654295)

最明显的区别是 ArrrayList底层的数据结构是数组，支持随机访问，而 LinkedList 的底层数据结构是双向循环链表，不支持随机访问。使用下标访问一个元素，ArrayList 的时间复杂度是 O(1)，而 LinkedList 是 O(n)。

**LinkList是一个双链表,在添加和删除元素时具有比ArrayList更好的性能.但在get与set方面弱于ArrayList.当然,这些对比都是指数据量很大或者操作很频繁。**



---

### **26. 如何实现数组和 List 之间的转换？**

- List转换成为数组：调用ArrayList的toArray方法。
- 数组转换成为List：调用Arrays的asList方法。



---

### **27. ArrayList 和 Vector 的区别是什么？**

- Vector与ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector，避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问ArrayList慢。 
- vector是线程（Thread）同步（Synchronized）的，所以它也是线程安全的，而Arraylist是线程异步（ASynchronized）的，是不安全的。如果不考虑到线程的安全因素，一般用Arraylist效率比较高。
- 如果集合中的元素的数目大于目前集合数组的长度时，vector增长率为目前数组长度的100%,而arraylist增长率为目前数组长度
  的50%.如过在集合中使用数据量比较大的数据，用vector有一定的优势。



---

### **28. Array 和 ArrayList 有何区别？**

- Array 数组可以包含基本类型和对象类型，
  ArrayList 却只能包含对象类型。
  Array 数组在存放的时候一定是同种类型的元素。ArrayList 就不一定了 。
- Array 数组的空间大小是固定的,所以需要事前确定合适的空间大小。
  ArrayList 的空间是动态增长的,而且，每次添加新的元素的时候都会检查内部数组的空间是否足够。
- Array没有提供ArrayList那么多功能，比如addAll、removeAll和iterator等。



---

### **29. 在 Queue 中 poll()和 remove()有什么区别？**

poll() 和 remove() 都是从队列中取出一个元素，但是 poll() 在获取元素失败的时候会返回空，但是 remove() 失败的时候会抛出异常。



---

### **30. 哪些集合类是线程安全的？**

- vector：就比arraylist多了个同步化机制（线程安全），因为效率较低，现在已经不太建议使用。在web应用中，特别是前台页面，往往效率（页面响应速度）是优先考虑的。
- statck：堆栈类，先进后出。
- hashtable：就比hashmap多了个线程安全。
- enumeration：枚举，相当于迭代器。



---

### **31. 迭代器 Iterator 是什么？**

迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，而开发人员不需要了解该序列的底层结构。迭代器通常被称为“轻量级”对象，因为创建它的代价小。



+++

### **32. Iterator 怎么使用？有什么特点？**

Java中的Iterator功能比较简单，并且只能单向移动：

(1) 使用方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。

(2) 使用next()获得序列中的下一个元素。

(3) 使用hasNext()检查序列中是否还有元素。

(4) 使用remove()将迭代器新返回的元素删除。

Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，它可以从两个方向遍历List，也可以从List中插入和删除元素。



+++

### **33. Iterator 和 ListIterator 有什么区别？**

- Iterator可用来遍历Set和List集合，但是ListIterator只能用来遍历List。 
- Iterator对集合只能是前向遍历，ListIterator既可以前向也可以后向。 
- ListIterator实现了Iterator接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等。



------

#  三、**多线程**

### **35. 并行和并发有什么区别？**

- 并行是指两个或者多个事件在同一时刻发生；而并发是指两个或多个事件在同一时间间隔发生。
- 并行是在不同实体上的多个事件，并发是在同一实体上的多个事件。
- 在一台处理器上“同时”处理多个任务，在多台处理器上同时处理多个任务。如hadoop分布式集群。

所以并发编程的目标是充分的利用处理器的每一个核，以达到最高的处理性能。



---

### **36. 线程和进程的区别？**

简而言之，进程是程序运行和资源分配的基本单位，一个程序至少有一个进程，一个进程至少有一个线程。进程在执行过程中拥有独立的内存单元，而多个线程共享内存资源，减少切换次数，从而效率更高。线程是进程的一个实体，是cpu调度和分派的基本单位，是比程序更小的能独立运行的基本单位。同一进程中的多个线程之间可以并发执行。



---

### **37. 守护线程是什么？**

守护线程（即daemon thread），是个服务线程，准确地来说就是服务其他的线程。



---

### **38. 创建线程有哪几种方式？**

①. 继承Thread类创建线程类

- 定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。因此把run()方法称为执行体。
- 创建Thread子类的实例，即创建了线程对象。
- 调用线程对象的start()方法来启动该线程。

②. 通过Runnable接口创建线程类

- 定义runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
- 创建 Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。
- 调用线程对象的start()方法来启动该线程。

③. 通过Callable和Future创建线程

- 创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
- 创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值。
- 使用FutureTask对象作为Thread对象的target创建并启动新线程。
- 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。



---

### **39. 说一下 runnable 和 callable 有什么区别？**

有点深的问题了，也看出一个Java程序员学习知识的广度。

- Runnable接口中的run()方法的返回值是void，它做的事情只是纯粹地去执行run()方法中的代码而已；
- Callable接口中的call()方法是有返回值的，是一个泛型，和Future、FutureTask配合可以用来获取异步执行的结果。



---

### **40. 线程有哪些状态？**

线程通常都有五种状态，创建、就绪、运行、阻塞和死亡。

- 创建状态。在生成线程对象，并没有调用该对象的start方法，这是线程处于创建状态。
- 就绪状态。当调用了线程对象的start方法之后，该线程就进入了就绪状态，但是此时线程调度程序还没有把该线程设置为当前线程，此时处于就绪状态。在线程运行之后，从等待或者睡眠中回来之后，也会处于就绪状态。
- 运行状态。线程调度程序将处于就绪状态的线程设置为当前线程，此时线程就进入了运行状态，开始运行run函数当中的代码。
- 阻塞状态。线程正在运行的时候，被暂停，通常是为了等待某个时间的发生(比如说某项资源就绪)之后再继续运行。sleep,suspend，wait等方法都可以导致线程阻塞。
- 死亡状态。如果一个线程的run方法执行结束或者调用stop方法后，该线程就会死亡。对于已经死亡的线程，无法再使用start方法令其进入就绪 　



---

### **41. sleep() 和 wait() 有什么区别？**

sleep()：方法是线程类（Thread）的静态方法，让调用线程进入睡眠状态，让出执行机会给其他线程，等到休眠时间结束后，线程进入就绪状态和其他线程一起竞争cpu的执行时间。因为sleep() 是static静态的方法，他不能改变对象的机锁，当一个synchronized块中调用了sleep() 方法，线程虽然进入休眠，但是对象的机锁没有被释放，其他线程依然无法访问这个对象。

wait()：wait()是Object类的方法，当一个线程执行到wait方法时，它就进入到一个和该对象相关的等待池，同时释放对象的机锁，使得其他线程能够访问，可以通过notify，notifyAll方法来唤醒等待的线程。



---

### **42. notify()和 notifyAll()有什么区别？**

- 如果线程调用了对象的 wait()方法，那么线程便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。
- 当有线程调用了对象的 notifyAll()方法（唤醒所有 wait 线程）或 notify()方法（只随机唤醒一个 wait 线程），被唤醒的的线程便会进入该对象的锁池中，锁池中的线程会去竞争该对象锁。也就是说，调用了notify后只要一个线程会由等待池进入锁池，而notifyAll会将该对象等待池内的所有线程移动到锁池中，等待锁竞争。
- 优先级高的线程竞争到对象锁的概率大，假若某线程没有竞争到该对象锁，它还会留在锁池中，唯有线程再次调用 wait()方法，它才会重新回到等待池中。而竞争到对象锁的线程则继续往下执行，直到执行完了 synchronized 代码块，它会释放掉该对象锁，这时锁池中的线程会继续竞争该对象锁。



---

### **43. 线程的 run()和 start()有什么区别？**

每个线程都是通过某个特定Thread对象所对应的方法run()来完成其操作的，方法run()称为线程体。通过调用Thread类的start()方法来启动一个线程。

start()方法来启动一个线程，真正实现了多线程运行。这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码； 这时此线程是处于就绪状态， 并没有运行。 然后通过此Thread类调用方法run()来完成其运行状态， 这里方法run()称为线程体，它包含了要执行的这个线程的内容， Run方法运行结束， 此线程终止。然后CPU再调度其它线程。

run()方法是在本线程里的，只是线程里的一个函数,而不是多线程的。 如果直接调用run(),其实就相当于是调用了一个普通函数而已，直接待用run()方法必须等待run()方法执行完毕才能执行下面的代码，所以执行路径还是只有一条，根本就没有线程的特征，所以在多线程执行时要使用start()方法而不是run()方法。



---

### **44. 创建线程池有哪几种方式？**

①. newFixedThreadPool(int nThreads)

创建一个固定长度的线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程规模将不再变化，当线程发生未预期的错误而结束时，线程池会补充一个新的线程。

②. newCachedThreadPool()

创建一个可缓存的线程池，如果线程池的规模超过了处理需求，将自动回收空闲线程，而当需求增加时，则可以自动添加新线程，线程池的规模不存在任何限制。

③. newSingleThreadExecutor()

这是一个单线程的Executor，它创建单个工作线程来执行任务，如果这个线程异常结束，会创建一个新的来替代它；它的特点是能确保依照任务在队列中的顺序来串行执行。

④. newScheduledThreadPool(int corePoolSize)

创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer。



---

### **45. 线程池都有哪些状态？**

线程池有5种状态：Running、ShutDown、Stop、Tidying、Terminated。

线程池各个状态切换框架图：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X2pwZy9RQ3U4NDlZVGFJT1B3UFRLSkpYYW9ydzFGSk1OUkthT2libXBwZG04R0lpYjAwUUNneWliclZoRmNVNHR2akFCb1lCVUtpYlZFZlE5VXZBdlQwbGliV0E5TFdnLzY0MA?x-oss-process=image/format,png)



+++

### **46. 线程池中 submit()和 execute()方法有什么区别？**

- 接收的参数不一样
- submit有返回值，而execute没有
- submit方便Exception处理



+++

**47. 在 java 程序中怎么保证多线程的运行安全？**

线程安全在三个方面体现：

- 原子性：提供互斥访问，同一时刻只能有一个线程对数据进行操作，（atomic,synchronized）；
- 可见性：一个线程对主内存的修改可以及时地被其他线程看到，（synchronized,volatile）；
- 有序性：一个线程观察其他线程中的指令执行顺序，由于指令重排序，该观察结果一般杂乱无序，（happens-before原则）。



+++

**48. 多线程锁的升级原理是什么？**

在Java中，锁共有4种状态，级别从低到高依次为：无状态锁，偏向锁，轻量级锁和重量级锁状态，这几个状态会随着竞争情况逐渐升级。锁可以升级但不能降级。

锁升级的图示过程： 

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJT1B3UFRLSkpYYW9ydzFGSk1OUkthTzFwYVdpYThyR2RoTkdEeW1KNVdpYk5ZOHBFaWJsNm0yMUZnNUpoNlhZUURIa0hzVHZlUVVmZXVDdy82NDA?x-oss-process=image/format,png)



+++

### **49. 什么是死锁？**

死锁是指两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去。此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。是操作系统层面的一个错误，是进程死锁的简称，最早在 1965 年由 Dijkstra 在研究银行家算法时提出的，它是计算机操作系统乃至整个并发程序设计领域最难处理的问题之一。



+++

### **50. 怎么防止死锁？**

死锁的四个必要条件：

- 互斥条件：进程对所分配到的资源不允许其他进程进行访问，若其他进程访问该资源，只能等待，直至占有该资源的进程使用完成后释放该资源
- 请求和保持条件：进程获得一定的资源之后，又对其他资源发出请求，但是该资源可能被其他进程占有，此事请求阻塞，但又对自己获得的资源保持不放
- 不可剥夺条件：是指进程已获得的资源，在未完成使用之前，不可被剥夺，只能在使用完后自己释放
- 环路等待条件：是指进程发生死锁后，若干进程之间形成一种头尾相接的循环等待资源关系

这四个条件是死锁的必要条件，只要系统发生死锁，这些条件必然成立，而只要上述条件之 一不满足，就不会发生死锁。

理解了死锁的原因，尤其是产生死锁的四个必要条件，就可以最大可能地避免、预防和 解除死锁。

所以，在系统设计、进程调度等方面注意如何不让这四个必要条件成立，如何确 定资源的合理分配算法，避免进程永久占据系统资源。

此外，也要防止进程在处于等待状态的情况下占用资源。因此，对资源的分配要给予合理的规划。



+++

### **51. ThreadLocal 是什么？有哪些使用场景？**

线程局部变量是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java提供ThreadLocal类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下（如 web 服务器）使用线程局部变量的时候要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完成后没有释放，Java 应用就存在内存泄露的风险。



+++

### **52.说一下 synchronized 底层实现原理？**

synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性。

Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

- 普通同步方法，锁是当前实例对象
- 静态同步方法，锁是当前类的class对象
- 同步方法块，锁是括号里面的对象



+++

### **53. synchronized 和 volatile 的区别是什么？**

- volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取； synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
- volatile仅能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的。
- volatile仅能实现变量的修改可见性，不能保证原子性；而synchronized则可以保证变量的修改可见性和原子性。
- volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞。
- volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化。



 但是volatile有个条件，用在getAndOperator场合是不具备原子性的。比如在做n =n+1,n++这种。因为在执行此类操作时有三个步骤：获取，自增，赋值。其jvm指令中，有内存屏障的介入，内存屏障会将已经发生写入的值同步到各个线程内存中。
  因此在此种情况下不具备原子性



+++

### **54. synchronized 和 Lock 有什么区别？**

- 首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
- synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
- synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
- 用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
- synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）；
- Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。



+++

### **55. synchronized 和 ReentrantLock 区别是什么？**

synchronized是和if、else、for、while一样的关键字，ReentrantLock是类，这是二者的本质区别。既然ReentrantLock是类，那么它就提供了比synchronized更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量，ReentrantLock比synchronized的扩展性体现在几点上： 

- ReentrantLock可以对获取锁的等待时间进行设置，这样就避免了死锁 
- ReentrantLock可以获取各种锁的信息
- ReentrantLock可以灵活地实现多路通知 

另外，二者的锁机制其实也是不一样的:ReentrantLock底层调用的是Unsafe的park方法加锁，synchronized操作的应该是对象头中mark word。



+++

### **56. 说一下 atomic 的原理？**

Atomic包中的类基本的特性就是在多线程环境下，当有多个线程同时对单个（包括基本类型及引用类型）变量进行操作时，具有排他性，即当多个线程同时对该变量的值进行更新时，仅有一个线程能成功，而未成功的线程可以向自旋锁一样，继续尝试，一直等到执行成功。

Atomic系列的类中的核心方法都会调用unsafe类中的几个本地方法。我们需要先知道一个东西就是Unsafe类，全名为：sun.misc.Unsafe，这个类包含了大量的对C代码的操作，包括很多直接内存分配以及原子操作的调用，而它之所以标记为非安全的，是告诉你这个里面大量的方法调用都会存在安全隐患，需要小心使用，否则会导致严重的后果，例如在通过unsafe分配内存的时候，如果自己指定某些区域可能会导致一些类似C++一样的指针越界到其他进程的问题。



------

# 四、反射

### **57. 什么是反射？**

反射主要是指程序可以访问、检测和修改它本身状态或行为的一种能力

Java反射：

在Java运行时环境中，对于任意一个类，能否知道这个类有哪些属性和方法？对于任意一个对象，能否调用它的任意一个方法

Java反射机制主要提供了以下功能：

- 在运行时判断任意一个对象所属的类。
- 在运行时构造任意一个类的对象。
- 在运行时判断任意一个类所具有的成员变量和方法。
- 在运行时调用任意一个对象的方法。 



+++

### **58. 什么是 java 序列化？什么情况下需要序列化？**

简单说就是为了保存在内存中的各种对象的状态（也就是实例变量，不是方法），并且可以把保存的对象状态再读出来。虽然你可以用你自己的各种各样的方法来保存object states，但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。

什么情况下需要序列化：

a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
b）当你想用套接字在网络上传送对象的时候；
c）当你想通过RMI传输对象的时候；



+++

### **59. 动态代理是什么？有哪些应用？**

动态代理：

当想要给实现了某个接口的类中的方法，加一些额外的处理。比如说加日志，加事务等。可以给这个类创建一个代理，故名思议就是创建一个新的类，这个类不仅包含原来类方法的功能，而且还在原来的基础上添加了额外处理的新类。这个代理类并不是定义好的，是动态生成的。具有解耦意义，灵活，扩展性强。

动态代理的应用：

- Spring的AOP
- 加事务
- 加权限
- 加日志



+++

### **60. 怎么实现动态代理？**

​		首先必须定义一个接口，还要有一个InvocationHandler(将实现接口的类的对象传递给它)处理类。再有一个工具类Proxy(习惯性将其称为代理类，因为调用他的newInstance()可以产生代理对象,其实他只是一个产生代理对象的工具类）。利用到InvocationHandler，拼接代理类源码，将其编译生成代理类的二进制码，利用加载器加载，并将其实例化产生代理对象，最后返回。





------

# 五、**对象拷贝**

### **61. 为什么要使用克隆？**

想对一个对象进行处理，又想保留原有的数据进行接下来的操作，就需要克隆了，Java语言中克隆针对的是类的实例。



---

### **62. 如何实现对象克隆？**

有两种方式：

1). 实现Cloneable接口并重写Object类中的clone()方法；

2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，代码如下：

注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。



+++

### **63. 深拷贝和浅拷贝区别是什么？**

- 浅拷贝只是复制了对象的引用地址，两个对象指向同一个内存地址，所以修改其中任意的值，另一个值都会随之变化，这就是浅拷贝（例：assign()）
- 深拷贝是将对象及值复制过来，两个对象修改其中任意的值另一个值不会改变，这就是深拷贝（例：JSON.parse()和JSON.stringify()，但是此方法无法复制函数类型）





------

# 六、**Java Web**

### **64. jsp 和 servlet 有什么区别？**

1. jsp经编译后就变成了Servlet.（JSP的本质就是Servlet，JVM只能识别java的类，不能识别JSP的代码，Web容器将JSP的代码编译成JVM能够识别的java类）
2. jsp更擅长表现于页面显示，servlet更擅长于逻辑控制。
3. Servlet中没有内置对象，Jsp中的内置对象都是必须通过HttpServletRequest对象，HttpServletResponse对象以及HttpServlet对象得到。
4. Jsp是Servlet的一种简化，使用Jsp只需要完成程序员需要输出到客户端的内容，Jsp中的Java脚本如何镶嵌到一个类中，由Jsp容器完成。而Servlet则是个完整的Java类，这个类的Service方法用于生成对客户端的响应。



+++

### **65. jsp 有哪些内置对象？作用分别是什么？**

JSP有9个内置对象：

- request：封装客户端的请求，其中包含来自GET或POST请求的参数；
- response：封装服务器对客户端的响应；
- pageContext：通过该对象可以获取其他对象；
- session：封装用户会话的对象；
- application：封装服务器运行环境的对象；
- out：输出服务器响应的输出流对象；
- config：Web应用的配置对象；
- page：JSP页面本身（相当于Java程序中的this）；
- exception：封装页面抛出异常的对象。



+++

### **66. 说一下 jsp 的 4 种作用域？**

JSP中的四种作用域包括page、request、session和application，具体来说：

- **page**代表与一个页面相关的对象和属性。
- **request**代表与Web客户机发出的一个请求相关的对象和属性。一个请求可能跨越多个页面，涉及多个Web组件；需要在页面显示的临时数据可以置于此作用域。
- **session**代表与某个用户与服务器建立的一次会话相关的对象和属性。跟某个用户相关的数据应该放在用户自己的session中。
- **application**代表与整个Web应用程序相关的对象和属性，它实质上是跨越整个Web应用程序，包括多个页面、请求和会话的一个全局作用域。



+++

### **67. session 和 cookie 有什么区别？**

- 由于HTTP协议是无状态的协议，所以服务端需要记录用户的状态时，就需要用某种机制来识具体的用户，这个机制就是Session.典型的场景比如购物车，当你点击下单按钮时，由于HTTP协议无状态，所以并不知道是哪个用户操作的，所以服务端要为特定的用户创建了特定的Session，用用于标识这个用户，并且跟踪用户，这样才知道购物车里面有几本书。这个Session是保存在服务端的，有一个唯一标识。在服务端保存Session的方法很多，内存、数据库、文件都有。集群的时候也要考虑Session的转移，在大型的网站，一般会有专门的Session服务器集群，用来保存用户会话，这个时候 Session 信息都是放在内存的，使用一些缓存服务比如Memcached之类的来放 Session。
- 思考一下服务端如何识别特定的客户？这个时候Cookie就登场了。每次HTTP请求的时候，客户端都会发送相应的Cookie信息到服务端。实际上大多数的应用都是用 Cookie 来实现Session跟踪的，第一次创建Session的时候，服务端会在HTTP协议中告诉客户端，需要在 Cookie 里面记录一个Session ID，以后每次请求把这个会话ID发送到服务器，我就知道你是谁了。有人问，如果客户端的浏览器禁用了 Cookie 怎么办？一般这种情况下，会使用一种叫做URL重写的技术来进行会话跟踪，即每次HTTP交互，URL后面都会被附加上一个诸如 sid=xxxxx 这样的参数，服务端据此来识别用户。
- Cookie其实还可以用在一些方便用户的场景下，设想你某次登陆过一个网站，下次登录的时候不想再次输入账号了，怎么办？这个信息可以写到Cookie里面，访问网站的时候，网站页面的脚本可以读取这个信息，就自动帮你把用户名给填了，能够方便一下用户。这也是Cookie名称的由来，给用户的一点甜头。所以，总结一下：Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。



+++

### **68. 说一下 session 的工作原理？**

其实session是一个存在服务器上的类似于一个散列表格的文件。里面存有我们需要的信息，在我们需要用的时候可以从里面取出来。类似于一个大号的map吧，里面的键存储的是用户的sessionid，用户向服务器发送请求的时候会带上这个sessionid。这时就可以从中取出对应的值了。



+++

### **69. 如果客户端禁止 cookie 能实现 session 还能用吗？**

Cookie与 Session，一般认为是两个独立的东西，Session采用的是在服务器端保持状态的方案，而Cookie采用的是在客户端保持状态的方案。但为什么禁用Cookie就不能得到Session呢？因为Session是用Session ID来确定当前对话所对应的服务器Session，而Session ID是通过Cookie来传递的，禁用Cookie相当于失去了Session ID，也就得不到Session了。

假定用户关闭Cookie的情况下使用Session，其实现途径有以下几种：

1. 设置php.ini配置文件中的“session.use_trans_sid = 1”，或者编译时打开打开了“--enable-trans-sid”选项，让PHP自动跨页传递Session ID。
2. 手动通过URL传值、隐藏表单传递Session ID。
3. 用文件、数据库等形式保存Session ID，在跨页过程中手动调用。



+++

### **70. spring mvc 和 struts 的区别是什么？**

- 拦截机制的不同

Struts2是类级别的拦截，每次请求就会创建一个Action，和Spring整合时Struts2的ActionBean注入作用域是原型模式prototype，然后通过setter，getter吧request数据注入到属性。Struts2中，一个Action对应一个request，response上下文，在接收参数时，可以通过属性接收，这说明属性参数是让多个方法共享的。Struts2中Action的一个方法可以对应一个url，而其类属性却被所有方法共享，这也就无法用注解或其他方式标识其所属方法了，只能设计为多例。

SpringMVC是方法级别的拦截，一个方法对应一个Request上下文，所以方法直接基本上是独立的，独享request，response数据。而每个方法同时又何一个url对应，参数的传递是直接注入到方法中的，是方法所独有的。处理结果通过ModeMap返回给框架。在Spring整合时，SpringMVC的Controller Bean默认单例模式Singleton，所以默认对所有的请求，只会创建一个Controller，有应为没有共享的属性，所以是线程安全的，如果要改变默认的作用域，需要添加@Scope注解修改。

Struts2有自己的拦截Interceptor机制，SpringMVC这是用的是独立的Aop方式，这样导致Struts2的配置文件量还是比SpringMVC大。

- 底层框架的不同

Struts2采用Filter（StrutsPrepareAndExecuteFilter）实现，SpringMVC（DispatcherServlet）则采用Servlet实现。Filter在容器启动之后即初始化；服务停止以后坠毁，晚于Servlet。Servlet在是在调用时初始化，先于Filter调用，服务停止后销毁。

- 性能方面

Struts2是类级别的拦截，每次请求对应实例一个新的Action，需要加载所有的属性值注入，SpringMVC实现了零配置，由于SpringMVC基于方法的拦截，有加载一次单例模式bean注入。所以，SpringMVC开发效率和性能高于Struts2。

- 配置方面

spring MVC和Spring是无缝的。从这个项目的管理和安全上也比Struts2高。



+++

### **71. 如何避免 sql 注入？**

SQL方面、后端、前端

1. PreparedStatement（简单又有效的方法）
2. 使用正则表达式过滤传入的参数
3. 字符串过滤
4. JSP中调用该函数检查是否包函非法字符
5. JSP页面判断代码



+++

### **72. 什么是 XSS 攻击，如何避免？**

XSS攻击又称CSS,全称Cross Site Script （跨站脚本攻击），其原理是攻击者向有XSS漏洞的网站中输入恶意的 HTML 代码，当用户浏览该网站时，这段 HTML 代码会自动执行，从而达到攻击的目的。XSS 攻击类似于 SQL 注入攻击，SQL注入攻击中以SQL语句作为用户输入，从而达到查询/修改/删除数据的目的，而在xss攻击中，通过插入恶意脚本，实现对用户游览器的控制，获取用户的一些信息。 XSS是 Web 程序中常见的漏洞，XSS 属于被动式且用于客户端的攻击方式。

XSS防范的总体思路是：对输入(和URL参数)进行过滤，对输出进行编码。



+++

### **73. 什么是 CSRF 攻击，如何避免？**

CSRF（Cross-site request forgery）也被称为 one-click attack或者 session riding，中文全称是叫**跨站请求伪造**。一般来说，攻击者通过伪造用户的浏览器的请求，向访问一个用户自己曾经认证访问过的网站发送出去，使目标网站接收并误以为是用户的真实操作而去执行命令。常用于盗取账号、转账、发送虚假消息等。攻击者利用网站对请求的验证漏洞而实现这样的攻击行为，网站能够确认请求来源于用户的浏览器，却不能验证请求是否源于用户的真实意愿下的操作行为。

如何避免：

\1. 验证 HTTP Referer 字段

> HTTP头中的Referer字段记录了该 HTTP 请求的来源地址。在通常情况下，访问一个安全受限页面的请求来自于同一个网站，而如果黑客要对其实施 CSRF
> 攻击，他一般只能在他自己的网站构造请求。因此，可以通过验证Referer值来防御CSRF 攻击。

\2. 使用验证码

> 关键操作页面加上验证码，后台收到请求后通过判断验证码可以防御CSRF。但这种方法对用户不太友好。

\3. 在请求地址中添加token并验证

> CSRF 攻击之所以能够成功，是因为黑客可以完全伪造用户的请求，该请求中所有的用户验证信息都是存在于cookie中，因此黑客可以在不知道这些验证信息的情况下直接利用用户自己的cookie 来通过安全验证。要抵御 CSRF，关键在于在请求中放入黑客所不能伪造的信息，并且该信息不存在于 cookie 之中。可以在 HTTP 请求中以参数的形式加入一个随机产生的 token，并在服务器端建立一个拦截器来验证这个 token，如果请求中没有token或者 token 内容不正确，则认为可能是 CSRF 攻击而拒绝该请求。这种方法要比检查 Referer 要安全一些，token 可以在用户登陆后产生并放于session之中，然后在每次请求时把token 从 session 中拿出，与请求中的 token 进行比对，但这种方法的难点在于如何把 token 以参数的形式加入请求。
> 对于 GET 请求，token 将附在请求地址之后，这样 URL 就变成 http://url?csrftoken=tokenvalue。
> 而对于 POST 请求来说，要在 form 的最后加上 <input type="hidden" name="csrftoken" value="tokenvalue"/>，这样就把token以参数的形式加入请求了。

\4. 在HTTP 头中自定义属性并验证

> 这种方法也是使用 token 并进行验证，和上一种方法不同的是，这里并不是把 token 以参数的形式置于 HTTP 请求之中，而是把它放到 HTTP 头中自定义的属性里。通过 XMLHttpRequest 这个类，可以一次性给所有该类请求加上 csrftoken 这个 HTTP 头属性，并把 token 值放入其中。这样解决了上种方法在请求中加入 token 的不便，同时，通过 XMLHttpRequest 请求的地址不会被记录到浏览器的地址栏，也不用担心 token 会透过 Referer 泄露到其他网站中去。





------

# **七、异常**

### **74. throw 和 throws 的区别？**

throws是用来声明一个方法可能抛出的所有异常信息，throws是将异常声明但是不处理，而是将异常往上传，谁调用我就交给谁处理。而throw则是指抛出的一个具体的异常类型。



+++

### **75. final、finally、finalize 有什么区别？**

- final可以修饰类、变量、方法，修饰类表示该类不能被继承、修饰方法表示该方法不能被重写、修饰变量表示该变量是一个常量不能被重新赋值。
- finally一般作用在try-catch代码块中，在处理异常的时候，通常我们将一定要执行的代码方法finally代码块中，表示不管是否出现异常，该代码块都会执行，一般用来存放一些关闭资源的代码。
- finalize是一个方法，属于Object类的一个方法，而Object类是所有类的父类，该方法一般由垃圾回收器来调用，当我们调用System的gc()方法的时候，由垃圾回收器调用finalize(),回收垃圾。 



+++

### **76. try-catch-finally 中哪个部分可以省略？**

答：catch 可以省略

**原因：**

更为严格的说法其实是：try只适合处理运行时异常，try+catch适合处理运行时异常+普通异常。也就是说，如果你只用try去处理普通异常却不加以catch处理，编译是通不过的，因为编译器硬性规定，普通异常如果选择捕获，则必须用catch显示声明以便进一步处理。而运行时异常在编译时没有如此规定，所以catch可以省略，你加上catch编译器也觉得无可厚非。

理论上，编译器看任何代码都不顺眼，都觉得可能有潜在的问题，所以你即使对所有代码加上try，代码在运行期时也只不过是在正常运行的基础上加一层皮。但是你一旦对一段代码加上try，就等于显示地承诺编译器，对这段代码可能抛出的异常进行捕获而非向上抛出处理。如果是普通异常，编译器要求必须用catch捕获以便进一步处理；如果运行时异常，捕获然后丢弃并且+finally扫尾处理，或者加上catch捕获以便进一步处理。

至于加上finally，则是在不管有没捕获异常，都要进行的“扫尾”处理。



+++

### **77. try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？**

答：会执行，在 return 前执行。



+++

### **78. 常见的异常类有哪些？**

- NullPointerException：当应用程序试图访问空对象时，则抛出该异常。
- SQLException：提供关于数据库访问错误或其他错误信息的异常。
- IndexOutOfBoundsException：指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。 
- NumberFormatException：当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。
- FileNotFoundException：当试图打开指定路径名表示的文件失败时，抛出此异常。
- IOException：当发生某种I/O异常时，抛出此异常。此类是失败或中断的I/O操作生成的异常的通用类。
- ClassCastException：当试图将对象强制转换为不是实例的子类时，抛出该异常。
- ArrayStoreException：试图将错误类型的对象存储到一个对象数组时抛出的异常。
- IllegalArgumentException：抛出的异常表明向方法传递了一个不合法或不正确的参数。
- ArithmeticException：当出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例。 
- NegativeArraySizeException：如果应用程序试图创建大小为负的数组，则抛出该异常。
- NoSuchMethodException：无法找到某一特定方法时，抛出该异常。
- SecurityException：由安全管理器抛出的异常，指示存在安全侵犯。
- UnsupportedOperationException：当不支持请求的操作时，抛出该异常。
- RuntimeExceptionRuntimeException：是那些可能在Java虚拟机正常运行期间抛出的异常的超类。





------

# 八、**网络**

### **79. http 响应码 301 和 302 代表的是什么？有什么区别？**

答：301，302 都是HTTP状态的编码，都代表着某个URL发生了转移。

**区别：** 

- 301 redirect: 301 代表永久性转移(Permanently Moved)。

- 302 redirect: 302 代表暂时性转移(Temporarily Moved )。 

  ​    详细来说，301和302状态码都表示重定向，就是说浏览器在拿到服务器返回的这个状态码后会自动跳转到一个新的URL地址，这个地址可以从响应的Location首部中获取（用户看到的效果就是他输入的地址A瞬间变成了另一个地址B）——这是它们的共同点。他们的不同在于。301表示旧地址A的资源已经被永久地移除了（这个资源不可访问了），**搜索引擎在抓取新内容的同时也将旧的网址交换为重定向之后的网址**；302表示旧地址A的资源还在（仍然可以访问），这个重定向只是临时地从旧地址A跳转到地址B，**搜索引擎会抓取新的内容而保存旧的网址。**

  ​    当一个网站或者网页24—48小时内临时移动到一个新的位置，这时候就要进行302跳转，打个比方说，我有一套房子，但是最近走亲戚去亲戚家住了，过两天我还回来的。而使用301跳转的场景就是之前的网站因为某种原因需要移除掉，然后要到新的地址访问，是永久性的，就比如你的那套房子其实是租的，现在租期到了，你又在另一个地方找到了房子，之前租的房子不住了。



+++

### **80. forward 和 redirect 的区别？**

Forward和Redirect代表了两种请求转发方式：直接转发和间接转发。

**直接转发方式（Forward）**，客户端和浏览器只发出一次请求，Servlet、HTML、JSP或其它信息资源，由第二个信息资源响应该请求，在请求对象request中，保存的对象对于每个信息资源是共享的。

**间接转发方式（Redirect）**实际是两次HTTP请求，服务器端在响应第一次请求的时候，让浏览器再向另外一个URL发出请求，从而达到转发的目的。

**举个通俗的例子：**

直接转发就相当于：“A找B借钱，B说没有，B去找C借，借到借不到都会把消息传递给A”；

间接转发就相当于："A找B借钱，B说没有，让A去找C借"。



+++

### **81. 简述 tcp 和 udp的区别？**

- TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接。
- TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保证可靠交付。
- Tcp通过校验和，重传控制，序号标识，滑动窗口、确认应答实现可靠传输。如丢包时的重发控制，还可以对次序乱掉的分包进行顺序控制。
- UDP具有较好的实时性，工作效率比TCP高，适用于对高速传输和实时性有较高的通信或广播通信。
- 每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信。
- TCP对系统资源要求较多，UDP对系统资源要求较少。



+++

### **82. tcp 为什么要三次握手，两次不行吗？为什么？**

[三次握手](https://baijiahao.baidu.com/s?id=1654225744653405133&wfr=spider&for=pc)

为了实现可靠数据传输， TCP 协议的通信双方， 都必须维护一个序列号， 以标识发送出去的数据包中， 哪些是已经被对方收到的。 三次握手的过程即是通信双方相互告知序列号起始值， 并确认对方已经收到了序列号起始值的必经步骤。

如果只是两次握手， 至多只有连接发起方的起始序列号能被确认， 另一方选择的序列号则得不到确认。



+++

**83. 说一下 tcp 粘包是怎么产生的？**

**①. 发送方产生粘包**

采用TCP协议传输数据的客户端与服务器经常是保持一个长连接的状态（一次连接发一次数据不存在粘包），双方在连接不断开的情况下，可以一直传输数据；但当发送的数据包过于的小时，那么TCP协议默认的会启用Nagle算法，将这些较小的数据包进行合并发送（缓冲区数据发送是一个堆压的过程）；这个合并过程就是在发送缓冲区中进行的，也就是说数据发送出来它已经是粘包的状态了。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTW5PaWFMWkx2Q2F1aWJCNmExTnhJd0xkUUMxZ3FmS0R3dXN2U2xReEVhRG5SU3lTU3ZjSzJWTmxwZEg5TUZmUmFzVGljaGExNEp1dktZUS82NDA?x-oss-process=image/format,png)

**②. 接收方产生粘包**

接收方采用TCP协议接收数据时的过程是这样的：数据到底接收方，从网络模型的下方传递至传输层，传输层的TCP协议处理是将其放置接收缓冲区，然后由应用层来主动获取（C语言用recv、read等函数）；这时会出现一个问题，就是我们在程序中调用的读取数据函数不能及时的把缓冲区中的数据拿出来，而下一个数据又到来并有一部分放入的缓冲区末尾，等我们读取数据时就是一个粘包。（放数据的速度 > 应用层拿数据速度） 

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTW5PaWFMWkx2Q2F1aWJCNmExTnhJd0xkVjlNaWMxdWFid2NYM0FxWjlUdzlNN2xjYndNUXhGVlVNV21HM1NLTlJpYlZMSFpnY1F2RkRibXcvNjQw?x-oss-process=image/format,png)



+++

### **84. OSI 的七层模型都有哪些？**

1. 应用层：网络服务与最终用户的一个接口。
2. 表示层：数据的表示、安全、压缩。
3. 会话层：建立、管理、终止会话。
4. 传输层：定义传输数据的协议端口号，以及流控和差错校验。
5. 网络层：进行逻辑地址寻址，实现不同网络之间的路径选择。
6. 数据链路层：建立逻辑连接、进行硬件地址寻址、差错校验等功能。
7. 物理层：建立、维护、断开物理连接。



+++

### **85. get 和 post 请求有哪些区别？**

- GET在浏览器回退时是无害的，而POST会再次提交请求。
- GET产生的URL地址可以被Bookmark，而POST不可以。
- GET请求会被浏览器主动cache，而POST不会，除非手动设置。
- GET请求只能进行url编码，而POST支持多种编码方式。
- GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。
- GET请求在URL中传送的参数是有长度限制的，而POST没有。
- 对参数的数据类型，GET只接受ASCII字符，而POST没有限制。
- GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。
- GET参数通过URL传递，POST放在Request body中。



+++

### **87.说一下 JSONP 实现原理？**

jsonp 即 json+padding，动态创建script标签，利用script标签的src属性可以获取任何域下的js脚本，通过这个特性(也可以说漏洞)，服务器端不在返货json格式，而是返回一段调用某个函数的js代码，在src中进行了调用，这样实现了跨域。



------

# **九、设计模式**

### **88. 说一下你熟悉的设计模式？**

参考：[常用的设计模式汇总，超详细！](http://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=2651938221&idx=1&sn=9cb29d1eb0fdbdb5f976306b08d5bdcc&chksm=8d0f32e3ba78bbf547c6039038682706a2eaf83002158c58060d5eb57bdd83eb966a1e223ef6&scene=21#wechat_redirect)

1、单例模式（懒汉（安全，不安全），饿汉，静态类部类，枚举）

2、观察者模式

3、装饰器模式

4、适配器模式

5、工厂模式

6、代理模式（静态代理，动态代理（JDK动态代理，CGLIB动态代理））



+++

### **89. 简单工厂和抽象工厂有什么区别？**

**简单工厂模式**：

这个模式本身很简单而且使用在业务较简单的情况下。一般用于小项目或者具体产品很少扩展的情况（这样工厂类才不用经常更改）。

它由三种角色组成：

- 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑，根据逻辑不同，产生具体的工厂产品。如例子中的Driver类。
- 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。由接口或者抽象类来实现。如例中的Car接口。
- 具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现，如例子中的Benz、Bmw类。

来用类图来清晰的表示下的它们之间的关系：
![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnVTSnFSR1lkaExaSXRzRWYwOFN4OGFhUHJpYk04end6bjhRVkVOSFdmUHg3TlgyQVYxeWxnM0ZnLzY0MA?x-oss-process=image/format,png)

**抽象工厂模式：**

先来认识下什么是产品族： 位于不同产品等级结构中，功能相关联的产品组成的家族。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnVFamZrQjc3OUdmSjJpYmg4MnB3Sm1jdmlhM1JoZktDVVEyM25LWEV0Zk5sdGN0Y2lhd3hQOWppYkV3LzY0MA?x-oss-process=image/format,png)

图中的BmwCar和BenzCar就是两个产品树（产品层次结构）；而如图所示的BenzSportsCar和BmwSportsCar就是一个产品族。他们都可以放到跑车家族中，因此功能有所关联。同理BmwBussinessCar和BenzBusinessCar也是一个产品族。

**可以这么说，它和工厂方法模式的区别就在于需要创建对象的复杂程度上。而且抽象工厂模式是三个里面最为抽象、最具一般性的。抽象工厂模式的用意为：给客户端提供一个接口，可以创建多个产品族中的产品对象。**

而且使用抽象工厂模式还要满足一下条件：

1. 系统中有多个产品族，而系统一次只可能消费其中一族产品
2. 同属于同一个产品族的产品以其使用。

来看看抽象工厂模式的各个角色（和工厂方法的如出一辙）：

- 抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。在java中它由抽象类或者接口来实现。
- 具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。在java中它由具体的类来实现。
- 抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
- 具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。

------

# **十、Spring / Spring MVC**

### **90. 为什么要使用 spring？**

**1.简介**

- 目的：解决企业应用开发的复杂性
- 功能：使用基本的JavaBean代替EJB，并提供了更多的企业应用功能
- 范围：任何Java应用

简单来说，Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器框架。

**2.轻量**　

从大小与开销两方面而言Spring都是轻量的。完整的Spring框架可以在一个大小只有1MB多的JAR文件里发布。并且Spring所需的处理开销也是微不足道的。此外，Spring是非侵入式的：典型地，Spring应用中的对象不依赖于Spring的特定类。

**3.控制反转**　　

Spring通过一种称作控制反转（IoC）的技术促进了松耦合。当应用了IoC，一个对象依赖的其它对象会通过被动的方式传递进来，而不是这个对象自己创建或者查找依赖对象。你可以认为IoC与JNDI相反——不是对象从容器中查找依赖，而是容器在对象初始化时不等对象请求就主动将依赖传递给它。

**4.面向切面**　　

Spring提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务（例如审计（auditing）和事务（transaction）管理）进行内聚性的开发。应用对象只实现它们应该做的——完成业务逻辑——仅此而已。它们并不负责（甚至是意识）其它的系统级关注点，例如日志或事务支持。

**5.容器**

Spring包含并管理应用对象的配置和生命周期，在这个意义上它是一种容器，你可以配置你的每个bean如何被创建——基于一个可配置原型（prototype），你的bean可以创建一个单独的实例或者每次需要时都生成一个新的实例——以及它们是如何相互关联的。然而，Spring不应该被混同于传统的重量级的EJB容器，它们经常是庞大与笨重的，难以使用。

**6.框架**

Spring可以将简单的组件配置、组合成为复杂的应用。在Spring中，应用对象被声明式地组合，典型地是在一个XML文件里。Spring也提供了很多基础功能（事务管理、持久化框架集成等等），将应用逻辑的开发留给了你。

所有Spring的这些特征使你能够编写更干净、更可管理、并且更易于测试的代码。它们也为Spring中的各种模块提供了基础支持。

### **91. 解释一下什么是 aop？**

AOP（Aspect-Oriented Programming，面向方面编程），可以说是OOP（Object-Oriented Programing，面向对象编程）的补充和完善。OOP引入封装、继承和多态性等概念来建立一种对象层次结构，用以模拟公共行为的一个集合。当我们需要为分散的对象引入公共行为的时候，OOP则显得无能为力。也就是说，OOP允许你定义从上到下的关系，但并不适合定义从左到右的关系。例如日志功能。日志代码往往水平地散布在所有对象层次中，而与它所散布到的对象的核心功能毫无关系。对于其他类型的代码，如安全性、异常处理和透明的持续性也是如此。这种散布在各处的无关的代码被称为横切（cross-cutting）代码，在OOP设计中，它导致了大量代码的重复，而不利于各个模块的重用。

而AOP技术则恰恰相反，它利用一种称为“横切”的技术，剖解开封装的对象内部，并将那些影响了多个类的公共行为封装到一个可重用模块，并将其名为“Aspect”，即方面。所谓“方面”，简单地说，就是将那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可操作性和可维护性。AOP代表的是一个横向的关系，如果说“对象”是一个空心的圆柱体，其中封装的是对象的属性和行为；那么面向方面编程的方法，就仿佛一把利刃，将这些空心圆柱体剖开，以获得其内部的消息。而剖开的切面，也就是所谓的“方面”了。然后它又以巧夺天功的妙手将这些剖开的切面复原，不留痕迹。

使用“横切”技术，AOP把软件系统分为两个部分：核心关注点和横切关注点。业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点。横切关注点的一个特点是，他们经常发生在核心关注点的多处，而各处都基本相似。比如权限认证、日志、事务处理。Aop 的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。正如Avanade公司的高级方案构架师Adam Magee所说，AOP的核心思想就是“将应用程序中的商业逻辑同对其提供支持的通用服务进行分离。”

### **92. 解释一下什么是 ioc？**

IOC是Inversion of Control的缩写，多数书籍翻译成“控制反转”。

1996年，Michael Mattson在一篇有关探讨面向对象框架的文章中，首先提出了IOC 这个概念。对于面向对象设计及编程的基本思想，前面我们已经讲了很多了，不再赘述，简单来说就是把复杂系统分解成相互合作的对象，这些对象类通过封装以后，内部实现对外部是透明的，从而降低了解决问题的复杂度，而且可以灵活地被重用和扩展。

IOC理论提出的观点大体是这样的：借助于“第三方”实现具有依赖关系的对象之间的解耦。如下图：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnVtVVdIazdWVkJxNU81V2dXajFRRlFCUFdsamxqNUNpYnNVeDZmcDRiN0xRaHZOSm1HTjZ2NzNBLzY0MA?x-oss-process=image/format,png)

大家看到了吧，由于引进了中间位置的“第三方”，也就是IOC容器，使得A、B、C、D这4个对象没有了耦合关系，齿轮之间的传动全部依靠“第三方”了，全部对象的控制权全部上缴给“第三方”IOC容器，所以，IOC容器成了整个系统的关键核心，它起到了一种类似“粘合剂”的作用，把系统中的所有对象粘合在一起发挥作用，如果没有这个“粘合剂”，对象与对象之间会彼此失去联系，这就是有人把IOC容器比喻成“粘合剂”的由来。

我们再来做个试验：把上图中间的IOC容器拿掉，然后再来看看这套系统：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnVQanlJaWN2bzVkNm5Jc2NoakVtaWM2aHlSeXIySTlJY3ZNR1IwMXVQOERCQmhFNHpWWlU0ZnJNUS82NDA?x-oss-process=image/format,png)

我们现在看到的画面，就是我们要实现整个系统所需要完成的全部内容。这时候，A、B、C、D这4个对象之间已经没有了耦合关系，彼此毫无联系，这样的话，当你在实现A的时候，根本无须再去考虑B、C和D了，对象之间的依赖关系已经降低到了最低程度。所以，如果真能实现IOC容器，对于系统开发而言，这将是一件多么美好的事情，参与开发的每一成员只要实现自己的类就可以了，跟别人没有任何关系！

我们再来看看，控制反转(IOC)到底为什么要起这么个名字？我们来对比一下：

软件系统在没有引入IOC容器之前，如图1所示，对象A依赖于对象B，那么对象A在初始化或者运行到某一点的时候，自己必须主动去创建对象B或者使用已经创建的对象B。无论是创建还是使用对象B，控制权都在自己手上。

软件系统在引入IOC容器之后，这种情形就完全改变了，如图3所示，由于IOC容器的加入，对象A与对象B之间失去了直接联系，所以，当对象A运行到需要对象B的时候，IOC容器会主动创建一个对象B注入到对象A需要的地方。

通过前后的对比，我们不难看出来：对象A获得依赖对象B的过程,由主动行为变为了被动行为，控制权颠倒过来了，这就是“控制反转”这个名称的由来。

### **93. spring 有哪些主要模块？**

Spring框架至今已集成了20多个模块。这些模块主要被分如下图所示的核心容器、数据访问/集成,、Web、AOP（面向切面编程）、工具、消息和测试模块。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnV0ZlFKWUNIV0pqQ0VTOWlickZiVzAydXRtQks0bUNsRUNEOWRGV0ppYUtQUDdtUkdqaWJJdVh3YmcvNjQw?x-oss-process=image/format,png)

更多信息：howtodoinjava.com/java-spring-framework-tutorials/

### **94. spring 常用的注入方式有哪些？**

Spring通过DI（依赖注入）实现IOC（控制反转），常用的注入方式主要有三种：

1. 构造方法注入
2. setter注入
3. 基于注解的注入

### **95. spring 中的 bean 是线程安全的吗？**

Spring容器中的Bean是否线程安全，容器本身并没有提供Bean的线程安全策略，因此可以说spring容器中的Bean本身不具备线程安全的特性，但是具体还是要结合具体scope的Bean去研究。

### **96. spring 支持几种 bean 的作用域？**

当通过spring容器创建一个Bean实例时，不仅可以完成Bean实例的实例化，还可以为Bean指定特定的作用域。Spring支持如下5种作用域：

- singleton：单例模式，在整个Spring IoC容器中，使用singleton定义的Bean将只有一个实例
- prototype：原型模式，每次通过容器的getBean方法获取prototype定义的Bean时，都将产生一个新的Bean实例
- request：对于每次HTTP请求，使用request定义的Bean都将产生一个新实例，即每次HTTP请求将会产生不同的Bean实例。只有在Web应用中使用Spring时，该作用域才有效
- session：对于每次HTTP Session，使用session定义的Bean豆浆产生一个新实例。同样只有在Web应用中使用Spring时，该作用域才有效
- globalsession：每个全局的HTTP Session，使用session定义的Bean都将产生一个新实例。典型情况下，仅在使用portlet context的时候有效。同样只有在Web应用中使用Spring时，该作用域才有效

其中比较常用的是singleton和prototype两种作用域。对于singleton作用域的Bean，每次请求该Bean都将获得相同的实例。容器负责跟踪Bean实例的状态，负责维护Bean实例的生命周期行为；如果一个Bean被设置成prototype作用域，程序每次请求该id的Bean，Spring都会新建一个Bean实例，然后返回给程序。在这种情况下，Spring容器仅仅使用new 关键字创建Bean实例，一旦创建成功，容器不在跟踪实例，也不会维护Bean实例的状态。

如果不指定Bean的作用域，Spring默认使用singleton作用域。Java在创建Java实例时，需要进行内存申请；销毁实例时，需要完成垃圾回收，这些工作都会导致系统开销的增加。因此，prototype作用域Bean的创建、销毁代价比较大。而singleton作用域的Bean实例一旦创建成功，可以重复使用。因此，除非必要，否则尽量避免将Bean被设置成prototype作用域。

### **97. spring 自动装配 bean 有哪些方式？**

Spring容器负责创建应用程序中的bean同时通过ID来协调这些对象之间的关系。作为开发人员，我们需要告诉Spring要创建哪些bean并且如何将其装配到一起。

spring中bean装配有两种方式：

- 隐式的bean发现机制和自动装配
- 在java代码或者XML中进行显示配置

当然这些方式也可以配合使用。

### **98. spring 事务实现方式有哪些？**

1. 编程式事务管理对基于 POJO 的应用来说是唯一选择。我们需要在代码中调用beginTransaction()、commit()、rollback()等事务管理相关的方法，这就是编程式事务管理。
2. 基于 TransactionProxyFactoryBean 的声明式事务管理
3. 基于 @Transactional 的声明式事务管理
4. 基于 Aspectj AOP 配置事务

### **99. 说一下 spring 的事务隔离？**

事务隔离级别指的是一个事务对数据的修改与另一个并行的事务的隔离程度，当多个事务同时访问相同数据时，如果没有采取必要的隔离机制，就可能发生以下问题：

- 脏读：一个事务读到另一个事务未提交的更新数据。
- 幻读：例如第一个事务对一个表中的数据进行了修改，比如这种修改涉及到表中的“全部数据行”。同时，第二个事务也修改这个表中的数据，这种修改是向表中插入“一行新数据”。那么，以后就会发生操作第一个事务的用户发现表中还存在没有修改的数据行，就好象发生了幻觉一样。
- 不可重复读：比方说在同一个事务中先后执行两条一模一样的select语句，期间在此次事务中没有执行过任何DDL语句，但先后得到的结果不一致，这就是不可重复读。

### **100. 说一下 spring mvc 运行流程？**

**Spring MVC运行流程图：**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9RQ3U4NDlZVGFJTzZqaWI4WFAzcjhoOHNpYjA4MGljaWJIdnVYZjZOODFvYVdSQlRKTjN0WUVIQlBpYjhlSENHTzZNbWx2a25TdWliRW1sUk90ejRJY2ZyeFg5dy82NDA?x-oss-process=image/format,png)

**Spring运行流程描述：**

\1. 用户向服务器发送请求，请求被Spring 前端控制Servelt DispatcherServlet捕获；

\2. DispatcherServlet对请求URL进行解析，得到请求资源标识符（URI）。然后根据该URI，调用HandlerMapping获得该Handler配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器），最后以HandlerExecutionChain对象的形式返回；

\3. DispatcherServlet 根据获得的Handler，选择一个合适的HandlerAdapter；（附注：如果成功获得HandlerAdapter后，此时将开始执行拦截器的preHandler(...)方法）

\4.  提取Request中的模型数据，填充Handler入参，开始执行Handler（Controller)。 在填充Handler的入参过程中，根据你的配置，Spring将帮你做一些额外的工作：

- HttpMessageConveter： 将请求消息（如Json、xml等数据）转换成一个对象，将对象转换为指定的响应信息
- 数据转换：对请求消息进行数据转换。如String转换成Integer、Double等
- 数据根式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等
- 数据验证： 验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中

\5.  Handler执行完成后，向DispatcherServlet 返回一个ModelAndView对象；

\6.  根据返回的ModelAndView，选择一个适合的ViewResolver（必须是已经注册到Spring容器中的ViewResolver)返回给DispatcherServlet ；

\7. ViewResolver 结合Model和View，来渲染视图；

\8. 将渲染结果返回给客户端。

### **101. spring mvc 有哪些组件？**

Spring MVC的核心组件：

1. DispatcherServlet：中央控制器，把请求给转发到具体的控制类
2. Controller：具体处理请求的控制器
3. HandlerMapping：映射处理器，负责映射中央处理器转发给controller时的映射策略
4. ModelAndView：服务层返回的数据和视图层的封装类
5. ViewResolver：视图解析器，解析具体的视图
6. Interceptors ：拦截器，负责拦截我们定义的请求然后做处理工作

### **102. @RequestMapping 的作用是什么？**

RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。

RequestMapping注解有六个属性，下面我们把她分成三类进行说明。

**value， method：**

- value：指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；
- method：指定请求的method类型， GET、POST、PUT、DELETE等；

**consumes，produces**

- consumes：指定处理请求的提交内容类型（Content-Type），例如application/json, text/html；
- produces：指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

**params，headers**

- params： 指定request中必须包含某些参数值是，才让该方法处理。
- headers：指定request中必须包含某些指定的header值，才能让该方法处理请求。

### **103. @Autowired 的作用是什么？**

[《@Autowired用法详解》](https://blog.csdn.net/u013257679/article/details/52295106)



[Extend](https://blog.csdn.net/qq_35190492/article/details/105992063?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param)



# 十一、Mybatis

[B+树和BTree](https://www.jianshu.com/p/ac12d2c83708)



## **1、什么是Mybatis？**

（1）Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。程序员直接编写原生态sql，可以严格控制sql执行性能，灵活度高。

（2）MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

（3）通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中sql的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。（从执行sql到返回result的过程）。

## 2、Mybaits的优点：

（1）基于SQL语句编程，相当灵活，不会对应用程序或者数据库的现有设计造成任何影响，SQL写在XML里，解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用。

（2）与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接；

（3）很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持）。

（4）能够与Spring很好的集成；

（5）提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护。

## ***3、MyBatis框架的缺点：***

（1）SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求。

（2）SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。

## ***4、MyBatis框架适用场合：***

（1）MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。

（2）对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。

 

## ***5、MyBatis与Hibernate有哪些不同？***

（1）Mybatis和hibernate不同，它不完全是一个ORM框架，因为MyBatis需要程序员自己编写Sql语句。

（2）Mybatis直接编写原生态sql，可以严格控制sql执行性能，灵活度高，非常适合对关系数据模型要求不高的软件开发，因为这类软件需求变化频繁，一但需求变化要求迅速输出成果。但是灵活的前提是mybatis无法做到数据库无关性，如果需要实现支持多种数据库的软件，则需要自定义多套sql映射文件，工作量大。 

（3）Hibernate对象/关系映射能力强，数据库无关性好，对于关系模型要求高的软件，如果用hibernate开发可以节省很多代码，提高效率。 

 

## ***\*6、#{}和${}的区别是什么？\****

\#{}是预编译处理，${}是字符串替换。

Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；

Mybatis在处理${}时，就是把${}替换成变量的值。

使用#{}可以有效的防止SQL注入，提高系统安全性。

 

## ***7、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？\**

第1种： 通过在查询的sql语句中定义字段名的别名，让字段名的别名和实体类的属性名一致。

```html
    <select id=”selectorder” parametertype=”int” resultetype=”me.gacl.domain.order”>



       select order_id id, order_no orderno ,order_price price form orders where order_id=#{id};



    </select>
```

第2种： 通过<resultMap>来映射字段名和实体类属性名的一一对应的关系。

```html
 <select id="getOrder" parameterType="int" resultMap="orderresultmap">



        select * from orders where order_id=#{id}



    </select>



 



   <resultMap type=”me.gacl.domain.order” id=”orderresultmap”>



        <!–用id属性来映射主键字段–>



        <id property=”id” column=”order_id”>



 



        <!–用result属性来映射非主键字段，property为实体类属性名，column为数据表中的属性–>



        <result property = “orderno” column =”order_no”/>



        <result property=”price” column=”order_price” />



    </reslutMap>
```

 

***\*8、 模糊查询like语句该怎么写?\****

第1种：在Java代码中添加sql通配符。

```html
    string wildcardname = “%smi%”;



    list<name> names = mapper.selectlike(wildcardname);



 



    <select id=”selectlike”>



     select * from foo where bar like #{value}



    </select>
```

第2种：在sql语句中拼接通配符，会引起sql注入

```html
    string wildcardname = “smi”;



    list<name> names = mapper.selectlike(wildcardname);



 



    <select id=”selectlike”>



         select * from foo where bar like "%"${value}"%"



    </select>
```

 

***9、通常一个Xml映射文件，都会写一个Dao接口与之对应，请问，这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？***

Dao接口即Mapper接口。接口的全限名，就是映射文件中的namespace的值；接口的方法名，就是映射文件中Mapper的Statement的id值；接口方法内的参数，就是传递给sql的参数。

Mapper接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为key值，可唯一定位一个MapperStatement。在Mybatis中，每一个<select>、<insert>、<update>、<delete>标签，都会被解析为一个MapperStatement对象。

> 举例：com.mybatis3.mappers.StudentDao.findStudentById，可以唯一找到namespace为com.mybatis3.mappers.StudentDao下面 id 为 findStudentById 的 MapperStatement。

Mapper接口里的方法，是不能重载的，因为是使用 全限名+方法名 的保存和寻找策略。Mapper 接口的工作原理是JDK动态代理，Mybatis运行时会使用JDK动态代理为Mapper接口生成代理对象proxy，代理对象会拦截接口方法，转而执行MapperStatement所代表的sql，然后将sql执行结果返回。

 

***10、Mybatis是如何进行分页的？分页插件的原理是什么？***

​    Mybatis使用RowBounds对象进行分页，它是针对ResultSet结果集执行的内存分页，而非物理分页。可以在sql内直接书写带有物理分页的参数来完成物理分页功能，也可以使用分页插件来完成物理分页。

​    分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。

 

***11、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？***

第一种是使用<resultMap>标签，逐一定义数据库列名和对象属性名之间的映射关系。

第二种是使用sql列的别名功能，将列的别名书写为对象属性名。

有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。

 

***12、如何执行批量插入?***

首先,创建一个简单的insert语句:

```html
    <insert id=”insertname”>



         insert into names (name) values (#{value})



    </insert>
```

然后在java代码中像下面这样执行批处理插入:

```java
  list<string> names = new arraylist();



    names.add(“fred”);



    names.add(“barney”);



    names.add(“betty”);



    names.add(“wilma”);



 



    // 注意这里 executortype.batch



    sqlsession sqlsession = sqlsessionfactory.opensession(executortype.batch);



    try {



     namemapper mapper = sqlsession.getmapper(namemapper.class);



     for (string name : names) {



         mapper.insertname(name);



     }



     sqlsession.commit();



    }catch(Exception e){



     e.printStackTrace();



     sqlSession.rollback(); 



     throw e; 



    }



     finally {



         sqlsession.close();



    }
```

 

***13、如何获取自动生成的(主)键值?***

insert 方法总是返回一个int值 ，这个值代表的是插入的行数。

如果采用自增长策略，自动生成的键值在 insert 方法执行完后可以被设置到传入的参数对象中。

示例：

```html
<insert id=”insertname” usegeneratedkeys=”true” keyproperty=”id”>



     insert into names (name) values (#{name})



</insert>
    name name = new name();



    name.setname(“fred”);



 



    int rows = mapper.insertname(name);



    // 完成后,id已经被设置到对象中



    system.out.println(“rows inserted = ” + rows);



    system.out.println(“generated key value = ” + name.getid());
```

 

***14、在mapper中如何传递多个参数?***

```java
（1）第一种：



//DAO层的函数



Public UserselectUser(String name,String area);  



//对应的xml,#{0}代表接收的是dao层中的第一个参数，#{1}代表dao层中第二参数，更多参数一致往后加即可。



<select id="selectUser"resultMap="BaseResultMap">  



    select *  fromuser_user_t   whereuser_name = #{0} anduser_area=#{1}  



</select>  



 



（2）第二种： 使用 @param 注解:



public interface usermapper {



   user selectuser(@param(“username”) string username,@param(“hashedpassword”) string hashedpassword);



}



然后,就可以在xml像下面这样使用(推荐封装为一个map,作为单个参数传递给mapper):



<select id=”selectuser” resulttype=”user”>



         select id, username, hashedpassword



         from some_table



         where username = #{username}



         and hashedpassword = #{hashedpassword}



</select>



 



（3）第三种：多个参数封装成map



try{



//映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL



//由于我们的参数超过了两个，而方法中只有一个Object参数收集，因此我们使用Map集合来装载我们的参数



Map<String, Object> map = new HashMap();



     map.put("start", start);



     map.put("end", end);



     return sqlSession.selectList("StudentID.pagination", map);



 }catch(Exception e){



     e.printStackTrace();



     sqlSession.rollback();



    throw e; }



finally{



 MybatisUtil.closeSqlSession();



 }
```

 

***15、Mybatis动态sql有什么用？执行原理？有哪些动态sql？***

Mybatis动态sql可以在Xml映射文件内，以标签的形式编写动态sql，执行原理是根据表达式的值 完成逻辑判断并动态拼接sql的功能。

Mybatis提供了9种动态sql标签：trim | where | set | foreach | if | choose | when | otherwise | bind。

 

***\*16、Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？\****

答：<resultMap>、<parameterMap>、<sql>、<include>、<selectKey>，加上动态sql的9个标签，其中<sql>为sql片段标签，通过<include>标签引入sql片段，<selectKey>为不支持自增的主键生成策略标签。

 

***17、Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？***

不同的Xml映射文件，如果配置了namespace，那么id可以重复；如果没有配置namespace，那么id不能重复；

原因就是namespace+id是作为Map<String, MapperStatement>的key使用的，如果没有namespace，就剩下id，那么，id重复会导致数据互相覆盖。有了namespace，自然id就可以重复，namespace不同，namespace+id自然也就不同。

但是，在以前的Mybatis版本的namespace是可选的，不过新版本的namespace已经是必须的了。

 

***\*18、为什么说Mybatis是半自动ORM映射工具？它与全自动的区别在哪里？\****

Hibernate属于全自动ORM映射工具，使用Hibernate查询关联对象或者关联集合对象时，可以根据对象关系模型直接获取，所以它是全自动的。而Mybatis在查询关联对象或关联集合对象时，需要手动编写sql来完成，所以，称之为半自动ORM映射工具。

 

***\*19、 一对一、一对多的关联查询 ？\**** 

```html
<mapper namespace="com.lcb.mapping.userMapper">  



    <!--association  一对一关联查询 -->  



    <select id="getClass" parameterType="int" resultMap="ClassesResultMap">  



        select * from class c,teacher t where c.teacher_id=t.t_id and c.c_id=#{id}  



    </select>  



 



    <resultMap type="com.lcb.user.Classes" id="ClassesResultMap">  



        <!-- 实体类的字段名和数据表的字段名映射 -->  



        <id property="id" column="c_id"/>  



        <result property="name" column="c_name"/>  



        <association property="teacher" javaType="com.lcb.user.Teacher">  



            <id property="id" column="t_id"/>  



            <result property="name" column="t_name"/>  



        </association>  



    </resultMap>  



 



 



    <!--collection  一对多关联查询 -->  



    <select id="getClass2" parameterType="int" resultMap="ClassesResultMap2">  



        select * from class c,teacher t,student s where c.teacher_id=t.t_id and c.c_id=s.class_id and c.c_id=#{id}  



    </select>  



 



    <resultMap type="com.lcb.user.Classes" id="ClassesResultMap2">  



        <id property="id" column="c_id"/>  



        <result property="name" column="c_name"/>  



        <association property="teacher" javaType="com.lcb.user.Teacher">  



            <id property="id" column="t_id"/>  



            <result property="name" column="t_name"/>  



        </association>  



 



        <collection property="student" ofType="com.lcb.user.Student">  



            <id property="id" column="s_id"/>  



            <result property="name" column="s_name"/>  



        </collection>  



    </resultMap>  



</mapper> 
```

 

**20、MyBatis实现一对一有几种方式?具体怎么操作的？**

有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次, 通过在resultMap里面配置association节点配置一对一的类就可以完成；

嵌套查询是先查一个表，根据这个表里面的结果的 外键id，去再另外一个表里面查询数据,也是通过association配置，但另外一个表的查询通过select属性配置。

 

**21、MyBatis实现一对多有几种方式,怎么操作的？**

​    有联合查询和嵌套查询。联合查询是几个表联合查询,只查询一次,通过在resultMap里面的collection节点配置一对多的类就可以完成；嵌套查询是先查一个表,根据这个表里面的 结果的外键id,去再另外一个表里面查询数据,也是通过配置collection,但另外一个表的查询通过select节点配置。

 

**22、Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？**

答：Mybatis仅支持association关联对象和collection关联集合对象的延迟加载，association指的就是一对一，collection指的就是一对多查询。在Mybatis配置文件中，可以配置是否启用延迟加载lazyLoadingEnabled=true|false。

它的原理是，使用CGLIB创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调用a.getB().getName()，拦截器invoke()方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B对象的sql，把B查询上来，然后调用a.setB(b)，于是a的对象b属性就有值了，接着完成a.getB().getName()方法的调用。这就是延迟加载的基本原理。

当然了，不光是Mybatis，几乎所有的包括Hibernate，支持延迟加载的原理都是一样的。

 

 **23、Mybatis的一级、二级缓存:**

1）一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就将清空，默认打开一级缓存。

2）二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap 存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。默认不打开二级缓存，要开启二级缓存，使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置<cache/> ；

3）对于缓存数据更新机制，当某一个作用域(一级缓存 Session/二级缓存Namespaces)的进行了C/U/D 操作后，默认该作用域下所有 select 中的缓存将被 clear 掉并重新更新，如果开启了二级缓存，则只根据配置判断是否刷新。

 

**24、什么是MyBatis的接口绑定？有哪些实现方式？**

接口绑定，就是在MyBatis中任意定义接口,然后把接口里面的方法和SQL语句绑定, 我们直接调用接口方法就可以,这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

接口绑定有两种实现方式,一种是通过注解绑定，就是在接口的方法上面加上 @Select、@Update等注解，里面包含Sql语句来绑定；另外一种就是通过xml里面写SQL来绑定, 在这种情况下,要指定xml映射文件里面的namespace必须为接口的全路径名。当Sql语句比较简单时候,用注解绑定, 当SQL语句比较复杂时候,用xml绑定,一般用xml绑定的比较多。

**25、使用MyBatis的mapper接口调用时有哪些要求？**

① Mapper接口方法名和mapper.xml中定义的每个sql的id相同；
② Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同；
③ Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同；
④ Mapper.xml文件中的namespace即是mapper接口的类路径。

***\*26、Mapper编写有哪几种方式？\****

> **第一种：接口实现类继承SqlSessionDaoSupport：**使用此种方法需要编写mapper接口，mapper接口实现类、mapper.xml文件。
> （1）在sqlMapConfig.xml中配置mapper.xml的位置
> <mappers>
>   <mapper resource="mapper.xml文件的地址" />
>   <mapper resource="mapper.xml文件的地址" />
> </mappers>
> （2）定义mapper接口
> （3）实现类集成SqlSessionDaoSupport
> mapper方法中可以this.getSqlSession()进行数据增删改查。
> （4）spring 配置
> <bean id=" " class="mapper接口的实现">
>   <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
> </bean>
>
>  
> **第二种：使用org.mybatis.spring.mapper.MapperFactoryBean：**
> （1）在sqlMapConfig.xml中配置mapper.xml的位置，如果mapper.xml和mappre接口的名称相同且在同一个目录，这里可以不用配置
> <mappers>
>   <mapper resource="mapper.xml文件的地址" />
>   <mapper resource="mapper.xml文件的地址" />
> </mappers>
> （2）定义mapper接口：
> ①mapper.xml中的namespace为mapper接口的地址
> ②mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致
> ③Spring中定义
> <bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
>   <property name="mapperInterface"  value="mapper接口地址" /> 
>   <property name="sqlSessionFactory" ref="sqlSessionFactory" /> 
> </bean>
>
>
> **第三种：使用mapper扫描器：**
> （1）mapper.xml文件编写：
> mapper.xml中的namespace为mapper接口的地址；
> mapper接口中的方法名和mapper.xml中的定义的statement的id保持一致；
> 如果将mapper.xml和mapper接口的名称保持一致则不用在sqlMapConfig.xml中进行配置。 
> （2）定义mapper接口：
> 注意mapper.xml的文件名和mapper的接口名称保持一致，且放在同一个目录
> （3）配置mapper扫描器：
> <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
>   <property name="basePackage" value="mapper接口包地址"></property>
>   <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/> 
> </bean>
> （4）使用扫描器后从spring容器中获取mapper的实现对象。

 

***\*27、简述Mybatis的插件运行原理，以及如何编写一个插件。\****

答：Mybatis仅可以编写针对ParameterHandler、ResultSetHandler、StatementHandler、Executor这4种接口的插件，Mybatis使用JDK的动态代理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行这4种接口对象的方法时，就会进入拦截方法，具体就是InvocationHandler的invoke()方法，当然，只会拦截那些你指定需要拦截的方法。

编写插件：实现Mybatis的Interceptor接口并复写intercept()方法，然后在给插件编写注解，指定要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。

# 十二、Mysql优化

1、选取最适用的字段属性

MySQL可以很好的支持大数据量的存取，但是一般说来，数据库中的表越小，在它上面执行的查询也就会越快。因此，在创建表的时候，为了获得更好的性能，我们可以将表中字段的宽度设得尽可能小。

例如，在定义邮政编码这个字段时，如果将其设置为CHAR(255),显然给数据库增加了不必要的空间，甚至使用VARCHAR这种类型也是多余的，因为CHAR(6)就可以很好的完成任务了。同样的，如果可以的话，我们应该使用MEDIUMINT而不是BIGIN来定义整型字段。

另外一个提高效率的方法是在可能的情况下，应该尽量把字段设置为NOTNULL，这样在将来执行查询的时候，数据库不用去比较NULL值。
对于某些文本字段，例如“省份”或者“性别”，我们可以将它们定义为ENUM类型。因为在MySQL中，ENUM类型被当作数值型数据来处理，而数值型数据被处理起来的速度要比文本类型快得多。这样，我们又可以提高数据库的性能。

2、使用连接（JOIN）来代替子查询(Sub-Queries)

MySQL从4.1开始支持SQL的子查询。这个技术可以使用SELECT语句来创建一个单列的查询结果，然后把这个结果作为过滤条件用在另一个查询中。例如，我们要将客户基本信息表中没有任何订单的客户删除掉，就可以利用子查询先从销售信息表中将所有发出订单的客户ID取出来，然后将结果传递给主查询，如下所示：

```
DELETEFROMcustomerinfo
WHERECustomerIDNOTin(SELECTCustomerIDFROMsalesinfo)
```

使用子查询可以一次性的完成很多逻辑上需要多个步骤才能完成的SQL操作，同时也可以避免事务或者表锁死，并且写起来也很容易。但是，有些情况下，子查询可以被更有效率的连接（JOIN）..替代。例如，假设我们要将所有没有订单记录的用户取出来，可以用下面这个查询完成：

```
SELECT*FROMcustomerinfo
WHERECustomerIDNOTin(SELECTCustomerIDFROMsalesinfo)
```

如果使用连接（JOIN）..来完成这个查询工作，速度将会快很多。尤其是当salesinfo表中对CustomerID建有索引的话，性能将会更好，查询如下：

```
SELECT*FROMcustomerinfo
LEFTJOINsalesinfoONcustomerinfo.CustomerID=salesinfo.CustomerID
WHEREsalesinfo.CustomerIDISNULL
```

连接（JOIN）..之所以更有效率一些，是因为MySQL不需要在内存中创建临时表来完成这个逻辑上的需要两个步骤的查询工作。

3、使用联合(UNION)来代替手动创建的临时表

MySQL从4.0的版本开始支持union查询，它可以把需要使用临时表的两条或更多的select查询合并的一个查询中。在客户端的查询会话结束的时候，临时表会被自动删除，从而保证数据库整齐、高效。使用union来创建查询的时候，我们只需要用UNION作为关键字把多个select语句连接起来就可以了，要注意的是所有select语句中的字段数目要想同。下面的例子就演示了一个使用UNION的查询。

```
SELECTName,PhoneFROMclient
UNION
SELECTName,BirthDateFROMauthor
UNION
SELECTName,SupplierFROMproduct
```

4、事务

尽管我们可以使用子查询（Sub-Queries）、连接（JOIN）和联合（UNION）来创建[各种各样](https://www.baidu.com/s?wd=各种各样&tn=24004469_oem_dg&rsv_dl=gh_pl_sl_csd)的查询，但不是所有的数据库操作都可以只用一条或少数几条SQL语句就可以完成的。更多的时候是需要用到一系列的语句来完成某种工作。但是在这种情况下，当这个语句块中的某一条语句运行出错的时候，整个语句块的操作就会变得不确定起来。设想一下，要把某个数据同时插入两个相关联的表中，可能会出现这样的情况：第一个表中成功更新后，数据库突然出现意外状况，造成第二个表中的操作没有完成，这样，就会造成数据的不完整，甚至会破坏数据库中的数据。要避免这种情况，就应该使用事务，它的作用是：要么语句块中每条语句都操作成功，要么都失败。换句话说，就是可以保持数据库中数据的一致性和完整性。事物以BEGIN关键字开始，COMMIT关键字结束。在这之间的一条SQL操作失败，那么，ROLLBACK命令就可以把数据库恢复到BEGIN开始之前的状态。

```
BEGIN; INSERTINTOsalesinfoSETCustomerID=14;UPDATEinventorySETQuantity=11WHEREitem='book';COMMIT;
```

事务的另一个重要作用是当多个用户同时使用相同的数据源时，它可以利用锁定数据库的方法来为用户提供一种安全的访问方式，这样可以保证用户的操作不被其它的用户所干扰。

5、锁定表

尽管事务是维护数据库完整性的一个非常好的方法，但却因为它的独占性，有时会影响数据库的性能，尤其是在很大的应用系统中。由于在事务执行的过程中，数据库将会被锁定，因此其它的用户请求只能暂时等待直到该事务结束。如果一个数据库系统只有少数几个用户来使用，事务造成的影响不会成为一个太大的问题；但假设有[成千上万](https://www.baidu.com/s?wd=成千上万&tn=24004469_oem_dg&rsv_dl=gh_pl_sl_csd)的用户同时访问一个数据库系统，例如访问一个电子商务网站，就会产生比较严重的响应延迟。

其实，有些情况下我们可以通过锁定表的方法来获得更好的性能。下面的例子就用锁定表的方法来完成前面一个例子中事务的功能。

```
LOCKTABLEinventoryWRITESELECTQuantityFROMinventoryWHEREItem='book';
...
UPDATEinventorySETQuantity=11WHEREItem='book';UNLOCKTABLES
```

这里，我们用一个select语句取出初始数据，通过一些计算，用update语句将新值更新到表中。包含有WRITE关键字的LOCKTABLE语句可以保证在UNLOCKTABLES命令被执行之前，不会有其它的访问来对inventory进行插入、更新或者删除的操作。

6、使用外键

锁定表的方法可以维护数据的完整性，但是它却不能保证数据的关联性。这个时候我们就可以使用外键。

例如，外键可以保证每一条销售记录都指向某一个存在的客户。在这里，外键可以把customerinfo表中的CustomerID映射到salesinfo表中CustomerID，任何一条没有合法CustomerID的记录都不会被更新或插入到salesinfo中。

```
1. `CREATETABLEcustomerinfo( CustomerIDINTNOTNULL,PRIMARYKEY(CustomerID))TYPE=INNODB;`
2. 
3. `CREATETABLEsalesinfo( SalesIDINTNOTNULL,CustomerIDINTNOTNULL,`
4. 
5. `PRIMARYKEY(CustomerID,SalesID),`
6. 
7. `FOREIGNKEY(CustomerID)REFERENCEScustomerinfo(CustomerID)ONDELETECASCADE)TYPE=INNODB;` 
```

注意例子中的参数“ONDELETECASCADE”。该参数保证当customerinfo表中的一条客户记录被删除的时候，salesinfo表中所有与该客户相关的记录也会被自动删除。如果要在MySQL中使用外键，一定要记住在创建表的时候将表的类型定义为事务安全表InnoDB类型。该类型不是MySQL表的默认类型。定义的方法是在CREATETABLE语句中加上TYPE=INNODB。如例中所示。

7、使用索引

索引是提高数据库性能的常用方法，它可以令数据库服务器以比没有索引快得多的速度检索特定的行，尤其是在查询语句当中包含有MAX(),MIN()和ORDERBY这些命令的时候，性能提高更为明显。

那该对哪些字段建立索引呢？

一般说来，索引应建立在那些将用于JOIN,WHERE判断和ORDERBY排序的字段上。尽量不要对数据库中某个含有大量重复的值的字段建立索引。对于一个ENUM类型的字段来说，出现大量重复值是很有可能的情况

例如customerinfo中的“province”..字段，在这样的字段上建立索引将不会有什么帮助；相反，还有可能降低数据库的性能。我们在创建表的时候可以同时创建合适的索引，也可以使用ALTERTABLE或CREATEINDEX在以后创建索引。此外，MySQL从版本3.23.23开始支持全文索引和搜索。全文索引在MySQL中是一个FULLTEXT类型索引，但仅能用于MyISAM类型的表。对于一个大的数据库，将数据装载到一个没有FULLTEXT索引的表中，然后再使用ALTERTABLE或CREATEINDEX创建索引，将是非常快的。但如果将数据装载到一个已经有FULLTEXT索引的表中，执行过程将会非常慢。

8、优化的查询语句

绝大多数情况下，使用索引可以提高查询的速度，但如果SQL语句使用不恰当的话，索引将无法发挥它应有的作用。

下面是应该注意的几个方面。

- 首先，最好是在相同类型的字段间进行比较的操作。

  > 在MySQL3.23版之前，这甚至是一个必须的条件。例如不能将一个建有索引的INT字段和BIGINT字段进行比较；但是作为特殊的情况，在CHAR类型的字段和VARCHAR类型字段的字段大小相同的时候，可以将它们进行比较。

- 其次，在建有索引的字段上尽量不要使用函数进行操作。

> 例如，在一个DATE类型的字段上使用YEAE()函数时，将会使索引不能发挥应有的作用。所以，下面的两个查询虽然返回的结果一样，但后者要比前者快得多。

- 第三，在搜索字符型字段时，我们有时会使用LIKE关键字和通配符，这种做法虽然简单，但却也是以牺牲系统性能为代价的。

例如下面的查询将会比较表中的每一条记录。

```
1.  
2.  `SELECT*FROMbooks`
3.  
4.  `WHERE name like "MySQL%"` 
```

但是如果换用下面的查询，返回的结果一样，但速度就要快上很多：

```
1.  
2.  `SELECT*FROMbooks`
3.  
4.  `WHERE name＞="MySQL" and name＜"MySQM"` 
```

最后，应该注意避免在查询中让MySQL进行自动类型转换，因为转换过程也会使索引变得不起作用。

 

## 优化Mysql数据库的8个方法

本文通过8个方法优化Mysql数据库：创建索引、复合索引、索引不会包含有NULL值的列、使用短索引、排序的索引问题、like语句操作、不要在列上进行运算、不使用NOT IN和<>操作

### **1、创建索引**

对于查询占主要的应用来说，索引显得尤为重要。很多时候性能问题很简单的就是因为我们忘了添加索引而造成的，或者说没有添加更为有效的索引导致。如果不加索引的话，那么查找任何哪怕只是一条特定的数据都会进行一次全表扫描，如果一张表的数据量很大而符合条件的结果又很少，那么不加索引会引起致命的性能下降。但是也不是什么情况都非得建索引不可，比如性别可能就只有两个值，建索引不仅没什么优势，还会影响到更新速度，这被称为过度索引。

### **2、复合索引**

比如有一条语句是这样的：select * from users where area='beijing' and age=22;
如果我们是在area和age上分别创建单个索引的话，由于mysql查询每次只能使用一个索引，所以虽然这样已经相对不做索引时全表扫描提高了很多效率，但是如果在area、age两列上创建复合索引的话将带来更高的效率。如果我们创建了(area, age, salary)的复合索引，那么其实相当于创建了(area,age,salary)、(area,age)、(area)三个索引，这被称为最佳左前缀特性。因此我们在创建复合索引时应该将最常用作限制条件的列放在最左边，依次递减。

### **3、索引不会包含有NULL值的列**

只要列中包含有NULL值都将不会被包含在索引中，复合索引中只要有一列含有NULL值，那么这一列对于此复合索引就是无效的。所以我们在数据库设计时不要让字段的默认值为NULL。

### **4、使用短索引**

对串列进行索引，如果可能应该指定一个前缀长度。例如，如果有一个CHAR(255)的 列，如果在前10 个或20 个字符内，多数值是惟一的，那么就不要对整个列进行索引。短索引不仅可以提高查询速度而且可以节省磁盘空间和I/O操作。

### **5、排序的索引问题**

mysql查询只使用一个索引，因此如果where子句中已经使用了索引的话，那么order by中的列是不会使用索引的。因此数据库默认排序可以符合要求的情况下不要使用排序操作；尽量不要包含多个列的排序，如果需要最好给这些列创建复合索引。

### **6、like语句操作**

一般情况下不鼓励使用like操作，如果非使用不可，如何使用也是一个问题。like “%aaa%” 不会使用索引而like “aaa%”可以使用索引。

### **7、不要在列上进行运算**

select * from users where YEAR(adddate)<2007;
将在每个行上进行运算，这将导致索引失效而进行全表扫描，因此我们可以改成
select * from users where adddate<‘2007-01-01';

### **8、不使用NOT IN和<>操作**

NOT IN和<>操作都不会使用索引将进行全表扫描。NOT IN可以NOT EXISTS代替，id<>3则可使用id>3 or id<3来代替。

 

 

 

 

## 数据库SQL优化大总结之 百万级数据库优化方案

 

 

 

网上关于SQL优化的教程很多，但是比较杂乱。近日有空整理了一下，写出来跟大家分享一下，其中有错误和不足的地方，还请大家纠正补充。

这篇文章我花费了大量的时间查找资料、修改、排版，希望大家阅读之后，感觉好的话推荐给更多的人，让更多的人看到、纠正以及补充。

 

1.对查询进行优化，要尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的列上建立索引。


2.应尽量避免在 where 子句中对字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描，如：

```
select id from t where num is null
```

最好不要给数据库留NULL，尽可能的使用 NOT NULL填充数据库.

备注、描述、评论之类的可以设置为 NULL，其他的，最好不要使用NULL。

不要以为 NULL 不需要空间，比如：char(100) 型，在字段建立时，空间就固定了， 不管是否插入值（NULL也包含在内），都是占用 100个字符的空间的，如果是varchar这样的变长字段， null 不占用空间。


可以在num上设置默认值0，确保表中num列没有null值，然后这样查询：

```
select id from t where num = 0
```


3.应尽量避免在 where 子句中使用 != 或 <> 操作符，否则将引擎放弃使用索引而进行全表扫描。

4.应尽量避免在 where 子句中使用 or 来连接条件，如果一个字段有索引，一个字段没有索引，将导致引擎放弃使用索引而进行全表扫描，如：

```
select id from t where num=10 or Name = 'admin'
```

可以这样查询：

```
select id from t where num = 10
union all
select id from t where Name = 'admin'
```


5.in 和 not in 也要慎用，否则会导致全表扫描，如：

```
select id from t where num in(1,2,3)
```

对于连续的数值，能用 between 就不要用 in 了：

```
select id from t where num between 1 and 3
```

很多时候用 exists 代替 in 是一个好的选择：

```
select num from a where num in(select num from b)
```

用下面的语句替换：

```
select num from a where exists(select 1 from b where num=a.num)
```

 

6.下面的查询也将导致全表扫描：

```
select id from t where name like ‘%abc%’
```

若要提高效率，可以考虑全文检索。

7.如果在 where 子句中使用参数，也会导致全表扫描。因为SQL只有在运行时才会解析局部变量，但优化程序不能将访问计划的选择推迟到运行时；它必须在编译时进行选择。然 而，如果在编译时建立访问计划，变量的值还是未知的，因而无法作为索引选择的输入项。如下面语句将进行全表扫描：

```
select id from t where num = @num
```

可以改为强制查询使用索引：

```
select id from t with(index(索引名)) where num = @num
```

.应尽量避免在 where 子句中对字段进行表达式操作，这将导致引擎放弃使用索引而进行全表扫描。如：

```
select id from t where num/2 = 100
```

应改为:

```
select id from t where num = 100*2
```


9.应尽量避免在where子句中对字段进行函数操作，这将导致引擎放弃使用索引而进行全表扫描。如：

```
select id from t where substring(name,1,3) = ’abc’       -–name以abc开头的id
select id from t where datediff(day,createdate,’2005-11-30′) = 0    -–‘2005-11-30’    --生成的id
```

应改为:

```
select id from t where name like 'abc%'
select id from t where createdate >= '2005-11-30' and createdate < '2005-12-1'
```


10.不要在 where 子句中的“=”左边进行函数、算术运算或其他表达式运算，否则系统将可能无法正确使用索引。

11.在使用索引字段作为条件时，如果该索引是复合索引，那么必须使用到该索引中的第一个字段作为条件时才能保证系统使用该索引，否则该索引将不会被使用，并且应尽可能的让字段顺序与索引顺序相一致。

12.不要写一些没有意义的查询，如需要生成一个空表结构：

```
select col1,col2 into #t from t where 1=0
```

这类代码不会返回任何结果集，但是会消耗系统资源的，应改成这样：
create table #t(…)

13.Update 语句，如果只更改1、2个字段，不要Update全部字段，否则频繁调用会引起明显的性能消耗，同时带来大量日志。

14.对于多张大数据量（这里几百条就算大了）的表JOIN，要先分页再JOIN，否则逻辑读会很高，性能很差。

15.select count(*) from table；这样不带任何条件的count会引起全表扫描，并且没有任何业务意义，是一定要杜绝的。


16.索引并不是越多越好，索引固然可以提高相应的 select 的效率，但同时也降低了 insert 及 update 的效率，因为 insert 或 update 时有可能会重建索引，所以怎样建索引需要慎重考虑，视具体情况而定。一个表的索引数最好不要超过6个，若太多则应考虑一些不常使用到的列上建的索引是否有 必要。

17.应尽可能的避免更新 clustered 索引数据列，因为 clustered 索引数据列的顺序就是表记录的物理存储顺序，一旦该列值改变将导致整个表记录的顺序的调整，会耗费相当大的资源。若应用系统需要频繁更新 clustered 索引数据列，那么需要考虑是否应将该索引建为 clustered 索引。

18.尽量使用数字型字段，若只含数值信息的字段尽量不要设计为字符型，这会降低查询和连接的性能，并会增加存储开销。这是因为引擎在处理查询和连 接时会逐个比较字符串中每一个字符，而对于数字型而言只需要比较一次就够了。

19.尽可能的使用 varchar/nvarchar 代替 char/nchar ，因为首先变长字段存储空间小，可以节省存储空间，其次对于查询来说，在一个相对较小的字段内搜索效率显然要高些。

20.任何地方都不要使用 select * from t ，用具体的字段列表代替“*”，不要返回用不到的任何字段。

21.尽量使用表变量来代替临时表。如果表变量包含大量数据，请注意索引非常有限（只有主键索引）。

\22. 避免频繁创建和删除临时表，以减少系统表资源的消耗。临时表并不是不可使用，适当地使用它们可以使某些例程更有效，例如，当需要重复引用大型表或常用表中的某个数据集时。但是，对于一次性事件， 最好使用导出表。

23.在新建临时表时，如果一次性插入数据量很大，那么可以使用 select into 代替 create table，避免造成大量 log ，以提高速度；如果数据量不大，为了缓和系统表的资源，应先create table，然后insert。

24.如果使用到了临时表，在存储过程的最后务必将所有的临时表显式删除，先 truncate table ，然后 drop table ，这样可以避免系统表的较长时间锁定。

25.尽量避免使用游标，因为游标的效率较差，如果游标操作的数据超过1万行，那么就应该考虑改写。

26.使用基于游标的方法或临时表方法之前，应先寻找基于集的解决方案来解决问题，基于集的方法通常更有效。

27.与临时表一样，游标并不是不可使用。对小型数据集使用 FAST_FORWARD 游标通常要优于其他逐行处理方法，尤其是在必须引用几个表才能获得所需的数据时。在结果集中包括“合计”的例程通常要比使用游标执行的速度快。如果开发时 间允许，基于游标的方法和基于集的方法都可以尝试一下，看哪一种方法的效果更好。

28.在所有的存储过程和触发器的开始处设置 SET NOCOUNT ON ，在结束时设置 SET NOCOUNT OFF 。无需在执行存储过程和触发器的每个语句后向客户端发送 DONE_IN_PROC 消息。

29.尽量避免大事务操作，提高系统并发能力。

30.尽量避免向客户端返回大数据量，若数据量过大，应该考虑相应需求是否合理。

 

实际案例分析：拆分大的 DELETE 或INSERT 语句，批量提交SQL语句
　　如果你需要在一个在线的网站上去执行一个大的 DELETE 或 INSERT 查询，你需要非常小心，要避免你的操作让你的整个网站停止相应。因为这两个操作是会锁表的，表一锁住了，别的操作都进不来了。
　　Apache 会有很多的子进程或线程。所以，其工作起来相当有效率，而我们的服务器也不希望有太多的子进程，线程和数据库链接，这是极大的占服务器资源的事情，尤其是内存。
　　如果你把你的表锁上一段时间，比如30秒钟，那么对于一个有很高访问量的站点来说，这30秒所积累的访问进程/线程，数据库链接，打开的文件数，可能不仅仅会让你的WEB服务崩溃，还可能会让你的整台服务器马上挂了。
　　所以，如果你有一个大的处理，你一定把其拆分，使用 LIMIT oracle(rownum),sqlserver(top)条件是一个好的方法。下面是一个mysql示例：

```
while(1){

 　　//每次只做1000条

　　 mysql_query(“delete from logs where log_date <= ’2012-11-01’ limit 1000”);

 　　if(mysql_affected_rows() == 0){

　　 　　//删除完成，退出！
　　 　　break；
　　}

//每次暂停一段时间，释放表让其他进程/线程访问。
usleep(50000)

}
```

 

好了，到这里就写完了。我知道还有很多没有写到的，还请大家补充。后面有空会介绍一些SQL优化工具给大家。让我们一起学习，一起进步吧！

 

 

## 运维角度浅谈MySQL数据库优化

 

 

 一个成熟的数据库架构并不是一开始设计就具备高可用、高伸缩等特性的，它是随着用户量的增加，基础架构才逐渐完善。这篇博文主要谈MySQL数据库发展周期中所面临的问题及优化方案，暂且抛开前端应用不说，大致分为以下五个阶段：

**1、数据库表设计**

 项目立项后，开发部根据产品部需求开发项目，开发工程师工作其中一部分就是对表结构设计。对于数据库来说，这点很重要，如果设计不当，会直接影响访问速度和用户体验。影响的因素很多，比如慢查询、低效的查询语句、没有适当建立索引、数据库堵塞（死锁）等。当然，有测试工程师的团队，会做压力测试，找bug。对于没有测试工程师的团队来说，大多数开发工程师初期不会太多考虑数据库设计是否合理，而是尽快完成功能实现和交付，等项目有一定访问量后，隐藏的问题就会暴露，这时再去修改就不是这么容易的事了。

**2、数据库部署**

 该运维工程师出场了，项目初期访问量不会很大，所以单台部署足以应对在1500左右的QPS（每秒查询率）。考虑到高可用性，可采用MySQL主从复制+Keepalived做双击热备，常见集群软件有Keepalived、Heartbeat。

双机热备博文：http://lizhenliang.blog.51cto.com/7876557/1362313

**3、数据库性能优化**

 如果将MySQL部署到普通的X86服务器上，在不经过任何优化情况下，MySQL理论值正常可以处理2000左右QPS，经过优化后，有可能会提升到2500左右QPS，否则，访问量当达到1500左右并发连接时，数据库处理性能就会变慢，而且硬件资源还很富裕，这时就该考虑软件问题了。那么怎样让数据库最大化发挥性能呢？一方面可以单台运行多个MySQL实例让服务器性能发挥到最大化，另一方面是对数据库进行优化，往往操作系统和数据库默认配置都比较保守，会对数据库发挥有一定限制，可对这些配置进行适当的调整，尽可能的处理更多连接数。

具体优化有以下三个层面：

 **3.1 数据库配置优化**

 MySQL常用有两种存储引擎，一个是MyISAM，不支持事务处理，读性能处理快，表级别锁。另一个是InnoDB，支持事务处理（ACID），设计目标是为处理大容量数据发挥最大化性能，行级别锁。

 表锁：开销小，锁定粒度大，发生死锁概率高，相对并发也低。

 行锁：开销大，锁定粒度小，发生死锁概率低，相对并发也高。

 为什么会出现表锁和行锁呢？主要是为了保证数据的完整性，举个例子，一个用户在操作一张表，其他用户也想操作这张表，那么就要等第一个用户操作完，其他用户才能操作，表锁和行锁就是这个作用。否则多个用户同时操作一张表，肯定会数据产生冲突或者异常。

 根据以上看来，使用InnoDB存储引擎是最好的选择，也是MySQL5.5以后版本中默认存储引擎。每个存储引擎相关联参数比较多，以下列出主要影响数据库性能的参数。

 公共参数默认值：

| 123456 | `max_connections = 151``#同时处理最大连接数，推荐设置最大连接数是上限连接数的80%左右  ``sort_buffer_size = 2M``#查询排序时缓冲区大小，只对order by和group by起作用，可增大此值为16M``open_files_limit = 1024 ``#打开文件数限制，如果show global status like 'open_files'查看的值等于或者大于open_files_limit值时，程序会无法连接数据库或卡死` |
| ------ | ------------------------------------------------------------ |
|        |                                                              |

 MyISAM参数默认值：

| 12345678910 | `key_buffer_size = 16M``#索引缓存区大小，一般设置物理内存的30-40%``read_buffer_size = 128K ``#读操作缓冲区大小，推荐设置16M或32M``query_cache_type = ON``#打开查询缓存功能``query_cache_limit = 1M ``#查询缓存限制，只有1M以下查询结果才会被缓存，以免结果数据较大把缓存池覆盖``query_cache_size = 16M ``#查看缓冲区大小，用于缓存SELECT查询结果，下一次有同样SELECT查询将直接从缓存池返回结果，可适当成倍增加此值` |
| ----------- | ------------------------------------------------------------ |
|             |                                                              |

 InnoDB参数默认值：

| 12345678910 | `innodb_buffer_pool_size = 128M``#索引和数据缓冲区大小，一般设置物理内存的60%-70%``innodb_buffer_pool_instances = 1  ``#缓冲池实例个数，推荐设置4个或8个``innodb_flush_log_at_trx_commit = 1 ``#关键参数，0代表大约每秒写入到日志并同步到磁盘，数据库故障会丢失1秒左右事务数据。1为每执行一条SQL后写入到日志并同步到磁盘，I/O开销大，执行完SQL要等待日志读写，效率低。2代表只把日志写入到系统缓存区，再每秒同步到磁盘，效率很高，如果服务器故障，才会丢失事务数据。对数据安全性要求不是很高的推荐设置2，性能高，修改后效果明显。``innodb_file_per_table = OFF ``#默认是共享表空间，共享表空间idbdata文件不断增大，影响一定的I/O性能。推荐开启独立表空间模式，每个表的索引和数据都存在自己独立的表空间中，可以实现单表在不同数据库中移动。``innodb_log_buffer_size = 8M ``#日志缓冲区大小，由于日志最长每秒钟刷新一次，所以一般不用超过16M` |
| ----------- | ------------------------------------------------------------ |
|             |                                                              |

 **3.2 系统内核优化**

 大多数MySQL都部署在linux系统上，所以操作系统的一些参数也会影响到MySQL性能，以下对linux内核进行适当优化。

| 12345678910 | `net.ipv4.tcp_fin_timeout = 30``#TIME_WAIT超时时间，默认是60s``net.ipv4.tcp_tw_reuse = 1  ``#1表示开启复用，允许TIME_WAIT socket重新用于新的TCP连接，0表示关闭``net.ipv4.tcp_tw_recycle = 1 ``#1表示开启TIME_WAIT socket快速回收，0表示关闭``net.ipv4.tcp_max_tw_buckets = 4096  ``#系统保持TIME_WAIT socket最大数量，如果超出这个数，系统将随机清除一些TIME_WAIT并打印警告信息``net.ipv4.tcp_max_syn_backlog = 4096``#进入SYN队列最大长度，加大队列长度可容纳更多的等待连接` |
| ----------- | ------------------------------------------------------------ |
|             |                                                              |

 在linux系统中，如果进程打开的文件句柄数量超过系统默认值1024，就会提示“too many files open”信息，所以要调整打开文件句柄限制。

| 1234 | `# vi /etc/security/limits.conf #加入以下配置，*代表所有用户，也可以指定用户，重启系统生效``* soft nofile 65535``* hard nofile 65535``# ulimit -SHn 65535  #立刻生效` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 **3.3 硬件配置**

 加大物理内存，提高文件系统性能。linux内核会从内存中分配出缓存区（系统缓存和数据缓存）来存放热数据，通过文件系统延迟写入机制，等满足条件时（如缓存区大小到达一定百分比或者执行sync命令）才会同步到磁盘。也就是说物理内存越大，分配缓存区越大，缓存数据越多。当然，服务器故障会丢失一定的缓存数据。

 SSD硬盘代替SAS硬盘，将RAID级别调整为RAID1+0，相对于RAID1和RAID5有更好的读写性能（IOPS），毕竟数据库的压力主要来自磁盘I/O方面。

**4、数据库架构扩展**

 随着业务量越来越大，单台数据库服务器性能已无法满足业务需求，该考虑加机器了，该做集群了~~~。主要思想是分解单台数据库负载，突破磁盘I/O性能，热数据存放缓存中，降低磁盘I/O访问频率。

 **4.1 主从复制与读写分离**

 因为生产环境中，数据库大多都是读操作，所以部署一主多从架构，主数据库负责写操作，并做双击热备，多台从数据库做负载均衡，负责读操作，主流的负载均衡器有LVS、HAProxy、Nginx。

 怎么来实现读写分离呢？大多数企业是在代码层面实现读写分离，效率比较高。另一个种方式通过代理程序实现读写分离，企业中应用较少，常见代理程序有MySQL Proxy、Amoeba。在这样数据库集群架构中，大大增加数据库高并发能力，解决单台性能瓶颈问题。如果从数据库一台从库能处理2000 QPS，那么5台就能处理1w QPS，数据库横向扩展性也很容易。

 有时，面对大量写操作的应用时，单台写性能达不到业务需求。如果做双主，就会遇到数据库数据不一致现象，产生这个原因是在应用程序不同的用户会有可能操作两台数据库，同时的更新操作造成两台数据库数据库数据发生冲突或者不一致。在单库时MySQL利用存储引擎机制表锁和行锁来保证数据完整性，怎样在多台主库时解决这个问题呢？有一套基于perl语言开发的主从复制管理工具，叫MySQL-MMM（Master-Master replication managerfor Mysql，Mysql主主复制管理器），这个工具最大的优点是在同一时间只提供一台数据库写操作，有效保证数据一致性。

 主从复制博文：http://lizhenliang.blog.51cto.com/7876557/1290431

 读写分离博文：http://lizhenliang.blog.51cto.com/7876557/1305083

 MySQL-MMM博文：http://lizhenliang.blog.51cto.com/7876557/1354576

 **4.2 增加缓存**

 给数据库增加缓存系统，把热数据缓存到内存中，如果缓存中有要请求的数据就不再去数据库中返回结果，提高读性能。缓存实现有本地缓存和分布式缓存，本地缓存是将数据缓存到本地服务器内存中或者文件中。分布式缓存可以缓存海量数据，扩展性好，主流的分布式缓存系统有memcached、redis，memcached性能稳定，数据缓存在内存中，速度很快，QPS可达8w左右。如果想数据持久化就选择用redis，性能不低于memcached。

 工作过程：

 [![wKiom1VukrqyM-JcAABPhCy-LOM409.jpg](http://s3.51cto.com/wyfs02/M02/6D/E6/wKiom1VukrqyM-JcAABPhCy-LOM409.jpg)](http://s3.51cto.com/wyfs02/M02/6D/E6/wKiom1VukrqyM-JcAABPhCy-LOM409.jpg)

 **4.3 分库**

 分库是根据业务不同把相关的表切分到不同的数据库中，比如web、bbs、blog等库。如果业务量很大，还可将切分后的库做主从架构，进一步避免单个库压力过大。

 **4.4 分表**

 数据量的日剧增加，数据库中某个表有几百万条数据，导致查询和插入耗时太长，怎么能解决单表压力呢？你就该考虑是否把这个表拆分成多个小表，来减轻单个表的压力，提高处理效率，此方式称为分表。

 分表技术比较麻烦，要修改程序代码里的SQL语句，还要手动去创建其他表，也可以用merge存储引擎实现分表，相对简单许多。分表后，程序是对一个总表进行操作，这个总表不存放数据，只有一些分表的关系，以及更新数据的方式，总表会根据不同的查询，将压力分到不同的小表上，因此提高并发能力和磁盘I/O性能。

 分表分为垂直拆分和水平拆分：

 垂直拆分：把原来的一个很多字段的表拆分多个表，解决表的宽度问题。你可以把不常用的字段单独放到一个表中，也可以把大字段独立放一个表中，或者把关联密切的字段放一个表中。

 水平拆分：把原来一个表拆分成多个表，每个表的结构都一样，解决单表数据量大的问题。

 **4.5 分区**

 分区就是把一张表的数据根据表结构中的字段（如range、list、hash等）分成多个区块，这些区块可以在一个磁盘上，也可以在不同的磁盘上，分区后，表面上还是一张表，但数据散列在多个位置，这样一来，多块硬盘同时处理不同的请求，从而提高磁盘I/O读写性能，实现比较简单。

注：增加缓存、分库、分表和分区主要由程序猿来实现。

**5、数据库维护**

 数据库维护是运维工程师或者DBA主要工作，包括性能监控、性能分析、性能调优、数据库备份和恢复等。

 **5.1 性能状态关键指标**

 QPS，Queries Per Second：每秒查询数，一台数据库每秒能够处理的查询次数

 TPS，Transactions Per Second：每秒处理事务数

 通过show status查看运行状态，会有300多条状态信息记录，其中有几个值帮可以我们计算出QPS和TPS，如下：

 Uptime：服务器已经运行的实际，单位秒

 Questions：已经发送给数据库查询数

 Com_select：查询次数，实际操作数据库的

 Com_insert：插入次数

 Com_delete：删除次数

 Com_update：更新次数

 Com_commit：事务次数

 Com_rollback：回滚次数

 那么，计算方法来了，基于Questions计算出QPS：

| 12   | ` ``mysql> show global status like ``'Questions'``;`` ``mysql> show global status like ``'Uptime'``;` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 QPS = Questions / Uptime

 基于Com_commit和Com_rollback计算出TPS：

| 123  | ` ``mysql> show global status like ``'Com_commit'``;`` ``mysql> show global status like ``'Com_rollback'``;`` ``mysql> show global status like ``'Uptime'``;` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 TPS = (Com_commit + Com_rollback) / Uptime

 另一计算方式：基于Com_select、Com_insert、Com_delete、Com_update计算出QPS

| 1    | ` ``mysql> show global status where Variable_name ``in``(``'com_select'``,``'com_insert'``,``'com_delete'``,``'com_update'``);` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 等待1秒再执行，获取间隔差值，第二次每个变量值减去第一次对应的变量值，就是QPS

 TPS计算方法：

| 1    | ` ``mysql> show global status where Variable_name ``in``(``'com_insert'``,``'com_delete'``,``'com_update'``);` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 计算TPS，就不算查询操作了，计算出插入、删除、更新四个值即可。

 经网友对这两个计算方式的测试得出，当数据库中myisam表比较多时，使用Questions计算比较准确。当数据库中innodb表比较多时，则以Com_*计算比较准确。

 **5.2 开启慢查询日志**

 MySQL开启慢查询日志，分析出哪条SQL语句比较慢，使用set设置变量，重启服务失效，可以在my.cnf添加参数永久生效。

| 1234 | `mysql> ``set` `global slow-query-log=on ``#开启慢查询功能``mysql> ``set` `global slow_query_log_file=``'/var/log/mysql/mysql-slow.log'``; ``#指定慢查询日志文件位置``mysql> ``set` `global log_queries_not_using_indexes=on;  ``#记录没有使用索引的查询``mysql> ``set` `global long_query_time=1;  ``#只记录处理时间1s以上的慢查询` |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

 分析慢查询日志，可以使用MySQL自带的mysqldumpslow工具，分析的日志较为简单。

 \# mysqldumpslow -t 3 /var/log/mysql/mysql-slow.log   #查看最慢的前三个查询

 也可以使用percona公司的pt-query-digest工具，日志分析功能全面，可分析slow log、binlog、general log。

 分析慢查询日志：pt-query-digest /var/log/mysql/mysql-slow.log

 分析binlog日志：mysqlbinlog mysql-bin.000001 >mysql-bin.000001.sql 

 pt-query-digest --type=binlog mysql-bin.000001.sql 

 分析普通日志：pt-query-digest --type=genlog localhost.log

 **5.3 数据库备份**

 备份数据库是最基本的工作，也是最重要的，否则后果很严重，你懂得！但由于数据库比较大，上百G，往往备份都很耗费时间，所以就该选择一个效率高的备份策略，对于数据量大的数据库，一般都采用增量备份。常用的备份工具有mysqldump、mysqlhotcopy、xtrabackup等，mysqldump比较适用于小的数据库，因为是逻辑备份，所以备份和恢复耗时都比较长。mysqlhotcopy和xtrabackup是物理备份，备份和恢复速度快，不影响数据库服务情况下进行热拷贝，建议使用xtrabackup，支持增量备份。

 Xtrabackup备份工具使用博文：http://lizhenliang.blog.51cto.com/7876557/1612800

 **5.4 数据库修复**

 有时候MySQL服务器突然断电、异常关闭，会导致表损坏，无法读取表数据。这时就可以用到MySQL自带的两个工具进行修复，myisamchk和mysqlcheck。

 myisamchk：只能修复myisam表，需要停止数据库

 常用参数：

 -f --force   强制修复，覆盖老的临时文件，一般不使用

 -r --recover  恢复模式

 -q --quik   快速恢复

 -a --analyze  分析表

 -o --safe-recover 老的恢复模式，如果-r无法修复，可以使用此参数试试

 -F --fast   只检查没有正常关闭的表

 快速修复weibo数据库:

 \# cd /var/lib/mysql/weibo 

 \# myisamchk -r -q *.MYI

 mysqlcheck：myisam和innodb表都可以用，不需要停止数据库，如修复单个表，可在数据库后面添加表名，以空格分割

 常用参数：

 -a  --all-databases  检查所有的库

 -r  --repair  修复表

 -c  --check   检查表，默认选项

 -a  --analyze  分析表

 -o  --optimize 优化表

 -q  --quik  最快检查或修复表

 -F  --fast  只检查没有正常关闭的表

 快速修复weibo数据库:

 mysqlcheck -r -q -uroot -p123 weibo 

 5.5 另外，查看CPU和I/O性能方法

 \#查看CPU性能

![wKiom1VtPFmCEtY9AADbdiZbn9A400.jpg](http://s3.51cto.com/wyfs02/M02/6D/D9/wKiom1VtPFmCEtY9AADbdiZbn9A400.jpg)

 \#参数-P是显示CPU数，ALL为所有，也可以只显示第几颗CPU![wKioL1VtPpayB7WeAALQHX41buc367.jpg](http://s3.51cto.com/wyfs02/M00/6D/D5/wKioL1VtPpayB7WeAALQHX41buc367.jpg)

 \#查看I/O性能

[![wKiom1VtPSXTsI4zAAMkfVf2r-I743.jpg](http://s3.51cto.com/wyfs02/M00/6D/D9/wKiom1VtPSXTsI4zAAMkfVf2r-I743.jpg)](http://s3.51cto.com/wyfs02/M00/6D/D9/wKiom1VtPSXTsI4zAAMkfVf2r-I743.jpg)

 

 \#参数-m是以M单位显示，默认K

 \#%util：当达到100%时，说明I/O很忙。

 \#await：请求在队列中等待时间，直接影响read时间。

 I/O极限：IOPS（r/s+w/s）,一般RAID0/10在1200左右。（IOPS，每秒进行读写（I/O）操作次数）

 I/O带宽：在顺序读写模式下SAS硬盘理论值在300M/s左右，SSD硬盘理论值在600M/s左右。



# 十三、计算机网络

### **1. 网络层次划分**

　　为了使不同计算机厂家生产的计算机能够相互通信，以便在更大的范围内建立计算机网络，国际标准化组织（ISO）在1978年提出了“开放系统互联参考模型”，即著名的OSI/RM模型（Open System Interconnection/Reference Model）。它将计算机网络体系结构的通信协议划分为七层，自下而上依次为：物理层（Physics Layer）、数据链路层（Data Link Layer）、网络层（Network Layer）、传输层（Transport Layer）、会话层（Session Layer）、表示层（Presentation Layer）、应用层（Application Layer）。其中第四层完成数据传送服务，上面三层面向用户。

　　除了标准的OSI七层模型以外，常见的网络层次划分还有TCP/IP四层协议以及TCP/IP五层协议，它们之间的对应关系如下图所示：

 

![img](https://images2015.cnblogs.com/blog/764050/201509/764050-20150904094019903-1923900106.jpg)



### 2. OSI七层网络模型

　　TCP/IP协议毫无疑问是互联网的基础协议，没有它就根本不可能上网，任何和互联网有关的操作都离不开TCP/IP协议。不管是OSI七层模型还是TCP/IP的四层、五层模型，每一层中都要自己的专属协议，完成自己相应的工作以及与上下层级之间进行沟通。由于OSI七层模型为网络的标准层次划分，所以我们以OSI七层模型为例从下向上进行一一介绍。

![img](https://images2015.cnblogs.com/blog/764050/201509/764050-20150904095142060-1017190812.gif)

 

　　**1）物理层（Physical Layer）**

　　激活、维持、关闭通信端点之间的机械特性、电气特性、功能特性以及过程特性。**该层为上层协议提供了一个传输数据的可靠的物理媒体。简单的说，物理层确保原始的数据可在各种物理媒体上传输。**物理层记住两个重要的设备名称，中继器（Repeater，也叫放大器）和集线器。

　　**2）数据链路层（Data Link Layer）**

　　数据链路层在物理层提供的服务的基础上向网络层提供服务，其最基本的服务是将源自网络层来的数据可靠地传输到相邻节点的目标机网络层。为达到这一目的，数据链路必须具备一系列相应的功能，主要有：如何将数据组合成数据块，在数据链路层中称这种数据块为帧（frame），帧是数据链路层的传送单位；如何控制帧在物理信道上的传输，包括如何处理传输差错，如何调节发送速率以使与接收方相匹配；以及在两个网络实体之间提供数据链路通路的建立、维持和释放的管理。数据链路层在不可靠的物理介质上提供可靠的传输。该层的作用包括：物理地址寻址、数据的成帧、流量控制、数据的检错、重发等。

　　有关数据链路层的重要知识点：

　　**1> 数据链路层为网络层提供可靠的数据传输；**

　　**2> 基本数据单位为帧；**

　　**3> 主要的协议：以太网协议；**

　　**4> 两个重要设备名称：网桥和交换机。**

　　**3）网络层（Network Layer）**

　　网络层的目的是实现两个端系统之间的数据透明传送，具体功能包括寻址和路由选择、连接的建立、保持和终止等。它提供的服务使传输层不需要了解网络中的数据传输和交换技术。如果您想用尽量少的词来记住网络层，那就是“路径选择、路由及逻辑寻址”。

　　网络层中涉及众多的协议，其中包括最重要的协议，也是TCP/IP的核心协议——IP协议。IP协议非常简单，仅仅提供不可靠、无连接的传送服务。IP协议的主要功能有：无连接数据报传输、数据报路由选择和差错控制。与IP协议配套使用实现其功能的还有地址解析协议ARP、逆地址解析协议RARP、因特网报文协议ICMP、因特网组管理协议IGMP。具体的协议我们会在接下来的部分进行总结，有关网络层的重点为：

　　**1> 网络层负责对子网间的数据包进行路由选择。此外，网络层还可以实现拥塞控制、网际互连等功能；**

　　**2> 基本数据单位为IP数据报；**

　　**3> 包含的主要协议：**

　　**IP协议（Internet Protocol，因特网互联协议）;**

　　**ICMP协议（Internet Control Message Protocol，因特网控制报文协议）;**

　　**ARP协议（Address Resolution Protocol，地址解析协议）;**

　　**RARP协议（Reverse Address Resolution Protocol，逆地址解析协议）。**

　　**4> 重要的设备：路由器。**

　　**4）传输层（Transport Layer）**

　　第一个端到端，即主机到主机的层次。传输层负责将上层数据分段并提供端到端的、可靠的或不可靠的传输。此外，传输层还要处理端到端的差错控制和流量控制问题。

　　传输层的任务是根据通信子网的特性，最佳的利用网络资源，为两个端系统的会话层之间，提供建立、维护和取消传输连接的功能，负责端到端的可靠数据传输。在这一层，信息传送的协议数据单元称为段或报文。

　　网络层只是根据网络地址将源结点发出的数据包传送到目的结点，而传输层则负责将数据可靠地传送到相应的端口。

　　有关网络层的重点：

　　**1> 传输层负责将上层数据分段并提供端到端的、可靠的或不可靠的传输以及端到端的差错控制和流量控制问题；**

　　**2> 包含的主要协议：TCP协议（Transmission Control Protocol，传输控制协议）、UDP协议（User Datagram Protocol，用户数据报协议）；**

　　**3> 重要设备：网关。**

　　**5）会话层**

　　会话层管理主机之间的会话进程，即负责建立、管理、终止进程之间的会话。会话层还利用在数据中插入校验点来实现数据的同步。

　　**6）表示层**

　　表示层对上层数据或信息进行变换以保证一个主机应用层信息可以被另一个主机的应用程序理解。表示层的数据转换包括数据的加密、压缩、格式转换等。

　　**7）应用层**

　　为操作系统或网络应用程序提供访问网络服务的接口。

　　会话层、表示层和应用层重点：

　　**1> 数据传输基本单位为报文；**

　　**2> 包含的主要协议：FTP（文件传送协议）、Telnet（远程登录协议）、DNS（域名解析协议）、SMTP（邮件传送协议），POP3协议（邮局协议），HTTP协议（Hyper Text Transfer Protocol）。**



### 3. IP地址

　　**1）网络地址**

　　IP地址由网络号（包括子网号）和主机号组成，网络地址的主机号为全0，网络地址代表着整个网络。

　　**2）广播地址**

　　广播地址通常称为直接广播地址，是为了区分受限广播地址。

　　广播地址与网络地址的主机号正好相反，广播地址中，主机号为全1。当向某个网络的广播地址发送消息时，该网络内的所有主机都能收到该广播消息。

　　**3）组播地址**

　　D类地址就是组播地址。

　　先回忆下A，B，C，D类地址吧：

　　A类地址以0开头，第一个字节作为网络号，地址范围为：0.0.0.0~127.255.255.255；(**modified @2016.05.31**)

　　B类地址以10开头，前两个字节作为网络号，地址范围是：128.0.0.0~191.255.255.255;

　　C类地址以110开头，前三个字节作为网络号，地址范围是：192.0.0.0~223.255.255.255。

　　D类地址以1110开头，地址范围是224.0.0.0~239.255.255.255，D类地址作为组播地址（一对多的通信）；

　　E类地址以1111开头，地址范围是240.0.0.0~255.255.255.255，E类地址为保留地址，供以后使用。

　　注：只有A,B,C有网络号和主机号之分，D类地址和E类地址没有划分网络号和主机号。

　　**4）255.255.255.255**

　　该IP地址指的是受限的广播地址。受限广播地址与一般广播地址（直接广播地址）的区别在于，受限广播地址只能用于本地网络，路由器不会转发以受限广播地址为目的地址的分组；一般广播地址既可在本地广播，也可跨网段广播。例如：主机192.168.1.1/30上的直接广播数据包后，另外一个网段192.168.1.5/30也能收到该数据报；若发送受限广播数据报，则不能收到。

　　注：一般的广播地址（直接广播地址）能够通过某些路由器（当然不是所有的路由器），而受限的广播地址不能通过路由器。

　　**5）0.0.0.0**

　　常用于寻找自己的IP地址，例如在我们的RARP，BOOTP和DHCP协议中，若某个未知IP地址的无盘机想要知道自己的IP地址，它就以255.255.255.255为目的地址，向本地范围（具体而言是被各个路由器屏蔽的范围内）的服务器发送IP请求分组。

　　**6）回环地址**

　　127.0.0.0/8被用作回环地址，回环地址表示本机的地址，常用于对本机的测试，用的最多的是127.0.0.1。

　　**7）A、B、C类私有地址**

　　私有地址(private address)也叫专用地址，它们不会在全球使用，只具有本地意义。

　　A类私有地址：10.0.0.0/8，范围是：10.0.0.0~10.255.255.255

　　B类私有地址：172.16.0.0/12，范围是：172.16.0.0~172.31.255.255

　　C类私有地址：192.168.0.0/16，范围是：192.168.0.0~192.168.255.255



### 4. 子网掩码及网络划分

　　随着互连网应用的不断扩大，原先的IPv4的弊端也逐渐暴露出来，即网络号占位太多，而主机号位太少，所以其能提供的主机地址也越来越稀缺，目前除了使用NAT在企业内部利用保留地址自行分配以外，通常都对一个高类别的IP地址进行再划分，以形成多个子网，提供给不同规模的用户群使用。

　　这里主要是为了在网络分段情况下有效地利用IP地址，通过对主机号的高位部分取作为子网号，从通常的网络位界限中扩展或压缩子网掩码，用来创建某类地址的更多子网。但创建更多的子网时，在每个子网上的可用主机地址数目会比原先减少。

　　**什么是子网掩码？**

　　子网掩码是标志两个IP地址是否同属于一个子网的，也是32位二进制地址，其每一个为1代表该位是网络位，为0代表主机位。它和IP地址一样也是使用点式十进制来表示的。如果两个IP地址在子网掩码的按位与的计算下所得结果相同，即表明它们共属于同一子网中。

　　**在计算子网掩码时，我们要注意IP地址中的保留地址，即“ 0”地址和广播地址，它们是指主机地址或网络地址全为“ 0”或“ 1”时的IP地址，它们代表着本网络地址和广播地址，一般是不能被计算在内的。**

　　**子网掩码的计算：**

　　对于无须再划分成子网的IP地址来说，其子网掩码非常简单，即按照其定义即可写出：如某B类IP地址为 10.12.3.0，无须再分割子网，则该IP地址的子网掩码255.255.0.0。如果它是一个C类地址，则其子网掩码为 255.255.255.0。其它类推，不再详述。下面我们关键要介绍的是一个IP地址，还需要将其高位主机位再作为划分出的子网网络号，剩下的是每个子网的主机号，这时该如何进行每个子网的掩码计算。

　　下面总结一下有关子网掩码和网络划分常见的面试考题：

　　**1）利用子网数来计算**

　　在求子网掩码之前必须先搞清楚要划分的子网数目，以及每个子网内的所需主机数目。

　　(1) 将子网数目转化为二进制来表示;

　　如欲将B类IP地址168.195.0.0划分成27个子网：27=11011；

　　(2) 取得该二进制的位数，为N；

　　该二进制为五位数，N = 5

　　(3) 取得该IP地址的类子网掩码，将其主机地址部分的的前N位置1即得出该IP地址划分子网的子网掩码。

　　将B类地址的子网掩码255.255.0.0的主机地址前5位置 1，得到 255.255.248.0

　　**2）利用主机数来计算**

　　如欲将B类IP地址168.195.0.0划分成若干子网，每个子网内有主机700台：

　　(1) 将主机数目转化为二进制来表示；

　　700=1010111100；

　　(2) 如果主机数小于或等于254（注意去掉保留的两个IP地址），则取得该主机的二进制位数，为N，这里肯定 N<8。如果大于254，则 N>8，这就是说主机地址将占据不止8位；

　　该二进制为十位数，N=10；

　　(3) 使用255.255.255.255来将该类IP地址的主机地址位数全部置1，然后从后向前的将N位全部置为 0，即为子网掩码值。

　　将该B类地址的子网掩码255.255.0.0的主机地址全部置1，得到255.255.255.255，然后再从后向前将后 10位置0,即为：11111111.11111111.11111100.00000000，即255.255.252.0。这就是该欲划分成主机为700台的B类IP地址 168.195.0.0的子网掩码。

　　**3）还有一种题型，要你根据每个网络的主机数量进行子网地址的规划和****计算子网掩码。这也可按上述原则进行计算。**

　　比如一个子网有10台主机，那么对于这个子网需要的IP地址是：

　　10＋1＋1＋1＝13

　　**注意：加的第一个1是指这个网络连接时所需的网关地址，接着的两个1分别是指网****络地址和广播地址。**

　　因为13小于16（16等于2的4次方），所以主机位为4位。而256－16＝240，所以该子网掩码为255.255.255.240。

　　如果一个子网有14台主机，不少人常犯的错误是：依然分配具有16个地址空间的子网，而忘记了给网关分配地址。这样就错误了，因为14＋1＋1＋1＝17，17大于16，所以我们只能分配具有32个地址（32等于2的5次方）空间的子网。这时子网掩码为：255.255.255.224。



### 5. ARP/RARP协议

　　**地址解析协议，即ARP（Address Resolution Protocol），是根据IP地址获取物理地址的一个TCP/IP协议。**主机发送信息时将包含目标IP地址的ARP请求广播到网络上的所有主机，并接收返回消息，以此确定目标的物理地址；收到返回消息后将该IP地址和物理地址存入本机ARP缓存中并保留一定时间，下次请求时直接查询ARP缓存以节约资源。地址解析协议是建立在网络中各个主机互相信任的基础上的，网络上的主机可以自主发送ARP应答消息，其他主机收到应答报文时不会检测该报文的真实性就会将其记入本机ARP缓存；由此攻击者就可以向某一主机发送伪ARP应答报文，使其发送的信息无法到达预期的主机或到达错误的主机，这就构成了一个ARP欺骗。**ARP命令可用于查询本机ARP缓存中IP地址和MAC地址的对应关系、添加或删除静态对应关系等。**

　　ARP工作流程举例：

　　主机A的IP地址为192.168.1.1，MAC地址为0A-11-22-33-44-01；

　　主机B的IP地址为192.168.1.2，MAC地址为0A-11-22-33-44-02；

　　当主机A要与主机B通信时，地址解析协议可以将主机B的IP地址（192.168.1.2）解析成主机B的MAC地址，以下为工作流程：

　　（1）根据主机A上的路由表内容，IP确定用于访问主机B的转发IP地址是192.168.1.2。然后A主机在自己的本地ARP缓存中检查主机B的匹配MAC地址。

　　（2）如果主机A在ARP缓存中没有找到映射，它将询问192.168.1.2的硬件地址，从而将ARP请求帧广播到本地网络上的所有主机。源主机A的IP地址和MAC地址都包括在ARP请求中。本地网络上的每台主机都接收到ARP请求并且检查是否与自己的IP地址匹配。如果主机发现请求的IP地址与自己的IP地址不匹配，它将丢弃ARP请求。

　　（3）主机B确定ARP请求中的IP地址与自己的IP地址匹配，则将主机A的IP地址和MAC地址映射添加到本地ARP缓存中。

　　（4）主机B将包含其MAC地址的ARP回复消息直接发送回主机A。

　　（5）当主机A收到从主机B发来的ARP回复消息时，会用主机B的IP和MAC地址映射更新ARP缓存。本机缓存是有生存期的，生存期结束后，将再次重复上面的过程。主机B的MAC地址一旦确定，主机A就能向主机B发送IP通信了。

　　**逆地址解析协议，即RARP，功能和ARP协议相对，其将局域网中某个主机的物理地址转换为IP地址**，比如局域网中有一台主机只知道物理地址而不知道IP地址，那么可以通过RARP协议发出征求自身IP地址的广播请求，然后由RARP服务器负责回答。

　　RARP协议工作流程：

　　（1）给主机发送一个本地的RARP广播，在此广播包中，声明自己的MAC地址并且请求任何收到此请求的RARP服务器分配一个IP地址；

　　（2）本地网段上的RARP服务器收到此请求后，检查其RARP列表，查找该MAC地址对应的IP地址；

　　（3）如果存在，RARP服务器就给源主机发送一个响应数据包并将此IP地址提供给对方主机使用；

　　（4）如果不存在，RARP服务器对此不做任何的响应；

　　（5）源主机收到从RARP服务器的响应信息，就利用得到的IP地址进行通讯；如果一直没有收到RARP服务器的响应信息，表示初始化失败。



### 6. 路由选择协议

　　常见的路由选择协议有：RIP协议、OSPF协议。

　　**RIP****协议** ：底层是贝尔曼福特算法，它选择路由的度量标准（metric)是跳数，最大跳数是15跳，如果大于15跳，它就会丢弃数据包。

　　**OSPF****协议** ：Open Shortest Path First开放式最短路径优先，底层是迪杰斯特拉算法，是链路状态路由选择协议，它选择路由的度量标准是带宽，延迟。



### 7. TCP/IP协议

　　**TCP/IP协议是Internet最基本的协议、Internet国际互联网络的基础，由网络层的IP协议和传输层的TCP协议组成。通俗而言：TCP负责发现传输的问题，一有问题就发出信号，要求重新传输，直到所有数据安全正确地传输到目的地。而IP是给因特网的每一台联网设备规定一个地址。**

　　IP层接收由更低层（网络接口层例如以太网设备驱动程序）发来的数据包，并把该数据包发送到更高层---TCP或UDP层；相反，IP层也把从TCP或UDP层接收来的数据包传送到更低层。IP数据包是不可靠的，因为IP并没有做任何事情来确认数据包是否按顺序发送的或者有没有被破坏，IP数据包中含有发送它的主机的地址（源地址）和接收它的主机的地址（目的地址）。

 　TCP是面向连接的通信协议，通过三次握手建立连接，通讯完成时要拆除连接，由于TCP是面向连接的所以只能用于端到端的通讯。TCP提供的是一种可靠的数据流服务，采用“带重传的肯定确认”技术来实现传输的可靠性。TCP还采用一种称为“滑动窗口”的方式进行流量控制，所谓窗口实际表示接收能力，用以限制发送方的发送速度。

　　**TCP报文首部格式：**

![img](https://images2015.cnblogs.com/blog/764050/201509/764050-20150904110054856-961661137.png)

　　**TCP协议的三次握手和四次挥手：**

![img](https://images2015.cnblogs.com/blog/764050/201509/764050-20150904110008388-1768388886.gif)

 

　　**注：seq**:"sequance"序列号；**ack**:"acknowledge"确认号；**SYN**:"synchronize"请求同步标志；**；ACK**:"acknowledge"确认标志"**；****FIN**："Finally"结束标志。

　　**TCP连接建立过程：**首先Client端发送连接请求报文，Server段接受连接后回复ACK报文，并为这次连接分配资源。Client端接收到ACK报文后也向Server段发生ACK报文，并分配资源，这样TCP连接就建立了。

　　**TCP连接断开过程：**假设Client端发起中断连接请求，也就是发送FIN报文。Server端接到FIN报文后，意思是说"我Client端没有数据要发给你了"，但是如果你还有数据没有发送完成，则不必急着关闭Socket，可以继续发送数据。所以你先发送ACK，"告诉Client端，你的请求我收到了，但是我还没准备好，请继续你等我的消息"。这个时候Client端就进入FIN_WAIT状态，继续等待Server端的FIN报文。当Server端确定数据已发送完成，则向Client端发送FIN报文，"告诉Client端，好了，我这边数据发完了，准备好关闭连接了"。Client端收到FIN报文后，"就知道可以关闭连接了，但是他还是不相信网络，怕Server端不知道要关闭，所以发送ACK后进入TIME_WAIT状态，如果Server端没有收到ACK则可以重传。“，Server端收到ACK后，"就知道可以断开连接了"。Client端等待了2MSL后依然没有收到回复，则证明Server端已正常关闭，那好，我Client端也可以关闭连接了。Ok，TCP连接就这样关闭了！

　　**为什么要三次挥手？**

　　在只有两次“握手”的情形下，假设Client想跟Server建立连接，但是却因为中途连接请求的数据报丢失了，故Client端不得不重新发送一遍；这个时候Server端仅收到一个连接请求，因此可以正常的建立连接。但是，有时候Client端重新发送请求不是因为数据报丢失了，而是有可能数据传输过程因为网络并发量很大在某结点被阻塞了，这种情形下Server端将先后收到2次请求，并持续等待两个Client请求向他发送数据...问题就在这里，Cient端实际上只有一次请求，而Server端却有2个响应，极端的情况可能由于Client端多次重新发送请求数据而导致Server端最后建立了N多个响应在等待，因而造成极大的资源浪费！所以，“三次握手”很有必要！

　　**为什么要四次挥手？**

　　试想一下，假如现在你是客户端你想断开跟Server的所有连接该怎么做？第一步，你自己先停止向Server端发送数据，并等待Server的回复。但事情还没有完，虽然你自身不往Server发送数据了，但是因为你们之前已经建立好平等的连接了，所以此时他也有主动权向你发送数据；故Server端还得终止主动向你发送数据，并等待你的确认。其实，说白了就是保证双方的一个合约的完整执行！

　　使用TCP的协议：FTP（文件传输协议）、Telnet（远程登录协议）、SMTP（简单邮件传输协议）、POP3（和SMTP相对，用于接收邮件）、HTTP协议等。



### 8. UDP协议　

　　**UDP用户数据报协议，是面向无连接的通讯协议，UDP数据包括目的端口号和源端口号信息，由于通讯不需要连接，所以可以实现广播发送。****UDP通讯时不需要接收方确认，属于不可靠的传输，可能会出现丢包现象，实际应用中要求程序员编程验证。**

　　UDP与TCP位于同一层，但它不管数据包的顺序、错误或重发。因此，UDP不被应用于那些使用虚电路的面向连接的服务，UDP主要用于那些面向查询---应答的服务，例如NFS。相对于FTP或Telnet，这些服务需要交换的信息量较小。

　　每个UDP报文分UDP报头和UDP数据区两部分。报头由四个16位长（2字节）字段组成，分别说明该报文的源端口、目的端口、报文长度以及校验值。UDP报头由4个域组成，其中每个域各占用2个字节，具体如下：
　　（1）源端口号；

　　（2）目标端口号；

　　（3）数据报长度；

　　（4）校验值。

　　使用UDP协议包括：TFTP（简单文件传输协议）、SNMP（简单网络管理协议）、DNS（域名解析协议）、NFS、BOOTP。

　　**TCP** **与** **UDP** **的区别：**TCP是面向连接的，可靠的字节流服务；UDP是面向无连接的，不可靠的数据报服务。



### 9. DNS协议

　　DNS是域名系统(DomainNameSystem)的缩写，该系统用于命名组织到域层次结构中的计算机和网络服务，**可以简单地理解为将URL转换为IP地址**。域名是由圆点分开一串单词或缩写组成的，每一个域名都对应一个惟一的IP地址，在Internet上域名与IP地址之间是一一对应的，DNS就是进行域名解析的服务器。DNS命名用于Internet等TCP/IP网络中，通过用户友好的名称查找计算机和服务。



### 10. NAT协议

　　NAT网络地址转换(Network Address Translation)属接入广域网(WAN)技术，是一种将私有（保留）地址转化为合法IP地址的转换技术，它被广泛应用于各种类型Internet接入方式和各种类型的网络中。原因很简单，NAT不仅完美地解决了lP地址不足的问题，而且还能够有效地避免来自网络外部的攻击，隐藏并保护网络内部的计算机。



### 11. DHCP协议

　　DHCP动态主机设置协议（Dynamic Host Configuration Protocol）是一个局域网的网络协议，使用UDP协议工作，主要有两个用途：给内部网络或网络服务供应商自动分配IP地址，给用户或者内部网络管理员作为对所有计算机作中央管理的手段。



### 12. HTTP协议

　　超文本传输协议（HTTP，HyperText Transfer Protocol)是互联网上应用最为广泛的一种网络协议。所有的WWW文件都必须遵守这个标准。

　　**HTTP** **协议包括哪些请求？**

　　GET：请求读取由URL所标志的信息。

　　POST：给服务器添加信息（如注释）。

　　PUT：在给定的URL下存储一个文档。

　　DELETE：删除给定的URL所标志的资源。

　　**HTTP** **中，** **POST** **与** **GET** **的区别**

　　1）Get是从服务器上获取数据，Post是向服务器传送数据。

　　2）Get是把参数数据队列加到提交表单的Action属性所指向的URL中，值和表单内各个字段一一对应，在URL中可以看到。

　　3）Get传送的数据量小，不能大于2KB；Post传送的数据量较大，一般被默认为不受限制。

　　4）根据HTTP规范，GET用于信息获取，而且应该是安全的和幂等的。

　　I. 所谓 **安全的** 意味着该操作用于获取信息而非修改信息。换句话说，GET请求一般不应产生副作用。就是说，它仅仅是获取资源信息，就像数据库查询一样，不会修改，增加数据，不会影响资源的状态。

　　II. **幂等** 的意味着对同一URL的多个请求应该返回同样的结果。



### 13. 一个举例

　　**在浏览器中输入** [**www.baidu.com** ](http://www.baidu.com/) **后执行的全部过程**

　　现在假设如果我们在客户端（客户端）浏览器中输入http://www.baidu.com,而baidu.com为要访问的服务器（服务器），下面详细分析客户端为了访问服务器而执行的一系列关于协议的操作：

　　1）客户端浏览器通过DNS解析到www.baidu.com的IP地址220.181.27.48，通过这个IP地址找到客户端到服务器的路径。客户端浏览器发起一个HTTP会话到220.161.27.48，然后通过TCP进行封装数据包，输入到网络层。

　　2）在客户端的传输层，把HTTP会话请求分成报文段，添加源和目的端口，如服务器使用80端口监听客户端的请求，客户端由系统随机选择一个端口如5000，与服务器进行交换，服务器把相应的请求返回给客户端的5000端口。然后使用IP层的IP地址查找目的端。

　　3）客户端的网络层不用关心应用层或者传输层的东西，主要做的是通过查找路由表确定如何到达服务器，期间可能经过多个路由器，这些都是由路由器来完成的工作，不作过多的描述，无非就是通过查找路由表决定通过那个路径到达服务器。

　　4）客户端的链路层，包通过链路层发送到路由器，通过邻居协议查找给定IP地址的MAC地址，然后发送ARP请求查找目的地址，如果得到回应后就可以使用ARP的请求应答交换的IP数据包现在就可以传输了，然后发送IP数据包到达服务器的地址。