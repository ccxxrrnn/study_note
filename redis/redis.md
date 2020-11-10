







# Redis

---



## 五大数据类型

---



### Redis-Key

---

```html
keys  *    # 查看所有的key

EXISTS  #{keynamme}  # 判断当前的key是否存在

move #{key#{keyname}} 1 # 移除当前的key,1为当前

EXPIRE #{keyname} 10 # 设置key的过期时间，单位是秒

ttl #{keyname} # 查看当前key的剩余时间

type #{keyname} # 查看当前key的一个类型！

```



String

---

```html
set #{keyname} v1 # 设置值

get #{keyname} # 获得值

APPEND  key1 "hello"  # 追加字符串，如果当前key不存在，就相当于setkey

STRLEN key1 # 获取字符串的长度
##################################################################################################
# i++
# 步长 i+= (源码转换为Integer加值，不能转换报错)

incr views # 自增1 浏览量变为1

decr views # 自减1 浏览量-1

INCRBY views 10 # 可以设置步长，指定增量！

DECRBY views 5

##########################################################################
# 字符串范围 range

 GETRANGE key1 0 3 # 截取字符串 [0,3]

GETRANGE key1 0 -1 # 获取全部的字符串 和 get key是一样的

SETRANGE key2 1 xx # 替换指定位置开始的字符串！

##########################################################################
# setex (set with expire) # 设置过期时间
# setnx (set if not exist) # 不存在在设置 （在分布式锁中会常常使用！）

setex key3 30 "hello" # 设置key3 的值为 hello,30秒后过期

setnx mykey "redis" # 如果mykey 不存在，创建mykey,如果mykey存在，创建失败！

##########################################################################
#mset
#mget

mset k1 v1 k2 v2 k3 v3 # 同时设置多个值

mget k1 k2 k3 # 同时获取多个值

msetnx k1 v1 k4 v4 # msetnx 是一个原子性的操作，要么一起成功，要么一起失败！

# 对象

set user:1 {name:zhangsan,age:3} # 设置一个user:1 对象 值为 json字符来保存一个对象！
# 这里的key是一个巧妙的设计： user:{id}:{filed} , 如此设计在Redis中是完全OK了！

mset user:1:name zhangsan user:1:age 2 #二个对象（user:1:name，user:1:age）

##########################################################################
getset # 先get然后在set

getset db redis # 如果不存在值，则返回 nil，如果存在值，获取原来的值，并设置新的值

```

数据结构是相同的！ 

String类似的使用场景：value除了是我们的字符串还可以是我们的数字！ 

- 计数器 rr
- 统计多单位的数量 
- 粉丝数 
- 对象缓存存储



### List（列表）

---

基本的数据类型，列表 



![image-20201027162445262](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201027162445262.png)

在redis里面，我们可以把list玩成 ，栈、队列、阻塞队列！ 所有的list命令都是用l开头的，Redis不区分大小命令

```html
##########################################################################
LPUSH list one # 将一个值或者多个值，插入到列表头部 （左）

LRANGE list 0 -1 # 获取list中值！


Rpush list righr # 将一个值或者多个值，插入到列表位部 （右）

##########################################################################
LPOP 左移除
RPOP 右移除

Lpop list # 移除list的第一个元素

RPOP list #移除list的最后一个元素

##########################################################################
Lindex

lindex list 1 # 通过下标获得 list 中的某一个值！

##########################################################################
Llen

Llen list # 返回列表的长度

##########################################################################
L remove()  移除指定的值！
取关 uid  //不满足则删除部分


lrem list 1 one # 移除list集合中指定个数的value，精确匹配

##########################################################################
trim 修剪。； list 截断!

ltrim mylist 1 2 # 通过下标截取指定的长度，这个list已经被改变了，截断了只剩下截取的元素！

##########################################################################
rpoplpush # 移除列表的最后一个元素，将他移动到新的列表中！

rpoplpush mylist myotherlist # 移除列表的最后一个元素，将他移动到新的列表中！

##########################################################################
lset 将列表中指定下标的值替换为另外一个值，更新操作


lset list 0 item # 如果不存在列表我们去更新就会报错# 如果存在，更新当前下标的值 # 如果不存在，则会报错！

##########################################################################
linsert # 将某个具体的value插入到列把你中某个元素的前面或者后面！

LINSERT mylist before "world" "other"

LINSERT mylist after world new

```

小结 

- 他实际上是一个链表，before Node after ， left，right 都可以插入值
-  如果key 不存在，创建新的链表 
- 如果key存在，新增内容
- 如果移除了所有值，空链表，也代表不存在！ 
- 在两边插入或者改动值，效率最高！ 中间元素，相对来说效率会低一点~

消息排队！消息队列 （Lpush Rpop）， 栈（ Lpush Lpop）！



### Set（集合）

---

set中的值是不能重复的！

```html
##########################################################################

sadd myset "hello" # set集合中添加匀速

SMEMBERS myset # 查看指定set的所有值

SISMEMBER myset hello # 判断某一个值是不是在set集合中！

##########################################################################
scard myset # 获取set集合中的内容元素个数！

##########################################################################
rem

srem myset hello # 移除set集合中的指定元素

srem myset hello # 移除set集合中的指定元素

##########################################################################
set 无序不重复集合。抽随机！

SRANDMEMBER myset # 随机抽选出一个元素

SRANDMEMBER myset 2 # 随机抽选出指定个数的元素

##########################################################################
删除定的key，随机删除key！

spop myset # 随机删除一些set集合中的元素

##########################################################################
将一个指定的值，移动到另外一个set集合！

smove myset myset2 "kuangshen" # 将一个指定的值，移动到另外一个set集合！

##########################################################################
微博，B站，共同关注！(并集)
数字集合类：
- 差集 SDIFF
- 交集
- 并集

SDIFF key1 key2 # 差集

SINTER key1 key2 # 交集 共同好友就可以这样实现

SUNION key1 key2 # 并集

```

微博，A用户将所有关注的人放在一个set集合中！将它的粉丝也放在一个集合中！ 共同关注，共同爱好，二度好友，推荐好友！（六度分割理论）



### Hash（哈希）

---

Map集合，key-map! 时候这个值是一个map集合！ 本质和String类型没有太大区别，还是一个简单的 key-vlaue！

```html
##########################################################################

hset myhash field1 kuangshen # set一个具体 key-vlaue

hget myhash field1 # 获取一个字段值

hmset myhash field1 hello field2 world # set多个 key-vlaue

hmget myhash field1 field2 # 获取多个字段值

hgetall myhash # 获取全部的数据

hdel myhash field1 # 删除hash指定key字段！对应的value值也就消失了！

##########################################################################
hlen

hlen myhash # 获取hash表的字段数量！

##########################################################################
HEXISTS myhash field1 # 判断hash中指定字段是否存在！

##########################################################################
# 只获得所有field
# 只获得所有value

hkeys myhash # 只获得所有field

hvals myhash # 只获得所有value

##########################################################################
incr decr

HINCRBY myhash field3 1 #指定增量！ 没有decr，负数表示减

hsetnx myhash field4 hello # 如果不存在则可以设置# 如果存在则不能设置


```

hash变更的数据 user name age,尤其是是用户信息之类的，经常变动的信息！ hash 更适合于对象的 存储，String更加适合字符串存储！





### Zset（有序集合）

---

在set的基础上，增加了一个值，set  k1  v1      zset  k1  score1 v1

```html
zadd myset 1 one # 添加一个值或者多个值

ZRANGE myset 0 -1 

##########################################################################
排序如何实现

ZRANGEBYSCORE salary -inf +inf # 显示全部的用户 范围在负无穷到正无穷

ZREVRANGE salary 0 -1 # 从大到进行排序！

ZRANGEBYSCORE salary -inf +inf withscores # 显示全部的用户并且附带成绩

##########################################################################
# 移除rem中的元素

zrem salary xiaohong # 移除有序集合中的指定元素

zcard salary # 获取有序集合中的个数

#########################################################################

zcount myset 1 3 # 获取指定区间的成员数量！



```

其与的一些API，通过我们的学习吗，你们剩下的如果工作中有需要，这个时候你可以去查查看官方文 档！ 

案例思路：set 排序 存储班级成绩表，工资表排序！

 普通消息，1， 重要消息 2，带权重进行判断！ 

排行榜应用实现，取Top N 测试



## 三种特殊数据类型

---



### Geospatial 地理位置

---

朋友的定位，附近的人，打车距离计算？

Redis 的 Geo 在Redis3.2 版本就推出了！ 这个功能可以推算地理位置的信息，两地之间的距离，方圆 几里的人！

 可以查询一些测试数据：http://www.jsons.cn/lngcodeinfo/0706D99C19A781A3/ 

六个命令：

![image-20201027192653327](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201027192653327.png)

geoadd

```html
# getadd 添加地理位置
# 规则：两级无法直接添加，我们一般会下载城市数据，直接通过java程序一次性导入！
# 有效的经度从-180度到180度。
# 有效的纬度从-85.05112878度到85.05112878度。
# 当坐标位置超出上述指定范围时，该命令将会返回一个错误。
# 127.0.0.1:6379> geoadd china:city 39.90 116.40 beijin
(error) ERR invalid longitude,latitude pair 39.900000,116.400000
# 参数 key 值（）

geoadd china:city 116.40 39.90 beijing
```

---

geopos

获取当前定位：一定是一个坐标值

```html
GEOPOS china:city beijing # 获取指定的城市的经度和纬度！
```

++++

geodist

两人之间的距离！ 

单位： 

- m 表示单位为米。 
- km 表示单位为千米。 
- mi 表示单位为英里。 
- ft 表示单位为英尺。

```
 GEODIST china:city beijing shanghai km # 查看上海到北京的直线距离
```

++++

georadius 

以给定的经纬度为中心， 找出某一半径内的元素

我附近的人？ （获得所有附近的人的地址，定位！）通过半径来查询！ 获得指定数量的人，200 所有数据应该都录入：china:city ，才会让结果更加请求！

```
GEORADIUS china:city 110 30 1000 km # 以110，30 这个经纬度为中心，寻找方圆1000km内的城市

GEORADIUS china:city 110 30 500 km withdist # 显示到中间距离的位置

GEORADIUS china:city 110 30 500 km withcoord # 显示他人的定位信息

 GEORADIUS china:city 110 30 500 km withdist withcoord count 1 #筛选出指定的结果！
```

+++

GEORADIUSBYMEMBER

```
# 找出位于指定元素周围的其他元素！
GEORADIUSBYMEMBER china:city beijing 1000 km
```

+++

GEOHASH 

命令 - 返回一个或多个位置元素的 Geohash 表示

```
将二维的经纬度转换为一维的字符串，如果两个字符串越接近，那么则距离越近！

geohash china:city beijing chongqi
1) "wx4fbxxfke0"
2) "wm5xzrybty0"
```

+++

GEO 底层的实现原理其实就是 Zset！我们可以使用Zset命令来操作geo！

```
ZRANGE china:city 0 -1 # 查看地图中全部的元素

zrem china:city beijing # 移除指定元素！
```



### Hyperloglog

---

> 什么是基数？

A {1,3,5,7,8,7}

 B{1，3,5,7,8} 

基数（不重复的元素） = 5，可以接受误差！

> 简介

Redis 2.8.9 版本就更新了 Hyperloglog 数据结构！

 Redis Hyperloglog 基数统计的算法！

优点：占用的内存是固定，2^64 不同的元素的技术，只需要废 12KB内存！如果要从内存角度来比较的 话 Hyperloglog 首选！ 

网页的 UV （一个人访问一个网站多次，但是还是算作一个人！） 

传统的方式， set 保存用户的id，然后就可以统计 set 中的元素数量作为标准判断 ! 这个方式如果保存大量的用户id，就会比较麻烦！我们的目的是为了计数，而不是保存用户id； 0.81% 错误率！ 统计UV任务，可以忽略不计的！

> 测试使用

```
PFadd mykey a b c d e f g h i j # 创建第一组元素 mykey

PFCOUNT mykey # 统计 mykey 元素的基数数量

PFadd mykey2 i j z x c v b n m # 创建第二组元素 mykey2

 PFMERGE mykey3 mykey mykey2 # 合并两组 mykey mykey2 => mykey3 并集
```

如果允许容错，那么一定可以使用 Hyperloglog ！

如果不允许容错，就使用 set 或者自己的数据类型即可！



### Bitmap

---

为什么其他教程都不喜欢讲这些？这些在生活中或者开发中，都有十分多的应用场景，学习了，就是就 是多一个思路！

> 位存储

统计用户信息，活跃，不活跃！ 登录 、 未登录！ 打卡，365打卡！ 两个状态的，都可以使用 Bitmaps！

Bitmap 位图，数据结构！ 都是操作二进制位来进行记录，就只有0 和 1 两个状态！ 365 天 = 365 bit 1字节 = 8bit 46 个字节左右！

使用bitmap 来记录 周一到周日的打卡！

![image-20201027200622388](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201027200622388.png)查看某一天是否有打卡！

```
getbit sign 3
```

统计操作，统计 打卡的天数！

```
bitcount sign # 统计这周的打卡记录，就可以看到是否有全勤！

```





## 事务（ACID）

---

Redis 事务本质：一组命令的集合！ 一个事务中的所有命令都会被序列化，在事务执行过程的中，会按 照顺序执行！

一次性、顺序性、排他性！执行一些列的命令！

```
------ 队列 set set set 执行------
```

Redis事务没有没有隔离级别的概念！

所有的命令在事务中，并没有直接被执行！只有发起执行命令的时候才会执行！Exec 

Redis单条命令式保存原子性的，但是事务不保证原子性！

redis的事务：

- 开启事务（multi）
-  命令入队（......） 
- 执行事务（exec）

>事务

```
multi #开启事务

exec # 执行事务

DISCARD # 取消事务，事务队列中命令都不会被执行！


```

编译型异常（代码有问题！ 命令有错！） ，事务中所有的命令都不会被执行！

运行时异常（1/0）， 如果事务队列中存在语法性，那么执行命令的时候，其他命令是可以正常执行 的，错误命令抛出异常！



> **监控！ Watch**

悲观锁：

- 很悲观，认为什么时候都会出问题，无论做什么都会加锁！

乐观锁：

- 很乐观，认为什么时候都不会出问题，所以不会上锁！ 更新数据的时候去判断一下，在此期间是否有人修改过这个数据，
- 获取version
- 更新的时候比较 version



>Redis测监视测试

正常执行成功！

```
127.0.0.1:6379> set money 100
OK
127.0.0.1:6379> set out 0
OK
127.0.0.1:6379> watch money
OK
127.0.0.1:6379> multi
OK
127.0.0.1:6379> decrby money 20
QUEUED
127.0.0.1:6379> incrby out 20
QUEUED
127.0.0.1:6379> exec
1) (integer) 80
2) (integer) 20
127.0.0.1:6379>  
```

测试多线程修改值 , 使用watch 可以当做redis的乐观锁操作！

![image-20201027203134892](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201027203134892.png)

如果修改失败，获取最新的值就好

先解锁unwatch

再watch



## Jedis

---

我们要使用 Java 来操作 Redis。

> 什么是Jedis 是 Redis 官方推荐的 java连接开发工具！ 使用Java 操作Redis 中间件！如果你要使用 java操作redis，那么一定要对Jedis 十分的熟悉！

> 测试

1、导入对应的依赖

```
<!--导入jedis的包-->
<dependencies>
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
<groupId>redis.clients</groupId>
<artifactId>jedis</artifactId>
<version>3.2.0</version>
</dependency>
<!--fastjson-->
<dependency>
<groupId>com.alibaba</groupId>
<artifactId>fastjson</artifactId>
<version>1.2.62</version>
</dependency>
</dependencies>
```

2、编码测试：

- 连接数据库 
- 操作命令
-  断开连接！

```
import redis.clients.jedis.Jedis;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-27 20:36
 */

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
    }
}
```



### 常用的API

----

String

 List

 Set

 Hash 

Zset

> 所有的api命令，就是我们对应的上面学习的指令，一个都没有变化！

> 事务

```
package com.xw.REDIS;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-27 20:45
 */

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        jedis.flushDB();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","xiongwei");
        System.out.println(jedis.ping());
        //开启事务
        Transaction multi=jedis.multi();
        String result=jsonObject.toJSONString();
        try {
            multi.set("user1",result);
            multi.set("user2",result);
            int i=1/0;  // 代码抛出异常事务，执行失败！
            multi.exec(); //执行
        } catch (Exception e) {
            multi.discard(); //放弃
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();//关闭
        } }
}

```

 



## SpringBoot整合

----------------

SpringBoot 操作数据：spring-data jpa jdbc mongodb redis！

 SpringData 也是和 SpringBoot 齐名的项目！ 

说明： 在 SpringBoot2.x 之后，原来使用的jedis 被替换为了 lettuce? : 采用的直连，多个线程操作的话，是不安全的，如果想要避免不安全的，使用

 jedis pool 连接 池！ 更像 BIO 模式 

lettuce : 采用netty，实例可以再多个线程中进行共享，不存在线程不安全的情况！可以减少线程数据 了，更像 NIO 模式

```java
@Bean
@ConditionalOnMissingBean(name = "redisTemplate") // 我们可以自己定义一个redisTemplate来替换这个默认的！
public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
// 默认的 RedisTemplate 没有过多的设置，redis 对象都是需要序列化！
// 两个泛型都是 Object, Object 的类型，我们后使用需要强制转换 <String, Object>
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
@Bean
@ConditionalOnMissingBean // 由于 String 是redis中最常使用的类型，所以说单独提出来了一个bean！
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
	StringRedisTemplate template = new StringRedisTemplate();
	template.setConnectionFactory(redisConnectionFactory);
	return template;
}

```

> 测试

1、导入依赖

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```



2、配置连接

```properties
spring.redis.host=127.0.0.1
spring.redis.port=6379
```



3、测试

```java
package com.xw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //redisTemplate 操作不同的数据类型 //常用的操作提取出来了
        //opsForValue//操作字符串 数据类型
        //opsForList
        //opsForZSet

//获取连接对象
//        RedisConnection redisConnection=redisTemplate.getConnectionFactory().getConnection();
//        redisConnection.flushAll();
        redisTemplate.opsForValue().set("mykey","xiongwei");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

}

```



## Redis.conf详解

+++++++++++++

> 单位



> 包含



> 网络



> 通用配置



> 快照

持久化， 在规定的时间内，执行了多少次操作，则会持久化到文件 .rdb. aof 

redis 是内存数据库，如果没有持久化，那么数据断电及失！



>REPLICATION 复制，我们后面讲解主从复制的，时候再进行讲解



>SECURITY 安全



>限制 CLIENTS



>APPEND ONLY 模式 aof配置



## Redis持久化

++++++++++++++++++++

Redis 是内存数据库，如果不将内存中的数据库状态保存到磁盘，那么一旦服务器进程退出，服务器中 的数据库状态也会消失。所以 Redis 提供了持久化功能！

### RDB（Redis DataBase）

> 什么是RDB

在主从复制中，rdb就是备用了！从机上面！

![image-20201101210008272](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201101210008272.png)



在指定的时间间隔内将内存中的数据集快照写入磁盘，也就是行话讲的Snapshot快照，它恢复时是将快 照文件直接读到内存里。



Redis会单独创建（fork）一个子进程来进行持久化，会先将数据写入到一个临时文件中，待持久化过程 都结束了，再用这个临时文件替换上次持久化好的文件。整个过程中，主进程是不进行任何IO操作的。 这就确保了极高的性能。如果需要进行大规模数据的恢复，且对于数据恢复的完整性不是非常敏感，那 RDB方式要比AOF方式更加的高效。RDB的缺点是最后一次持久化后的数据可能丢失。我们默认的就是 RDB，一般情况下不需要修改这个配置！



有时候在生产环境我们会将这个文件进行备份！ 

rdb保存的文件是dump.rdb 都是在我们的配置文件中快照中进行配置的！

![image-20201101210047006](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201101210047006.png)



> 触发机制

1、save的规则满足的情况下，会自动触发rdb规则 

2、执行 flushall 命令，也会触发我们的rdb规则！

 3、退出redis，也会产生 rdb 文件！ 备份就自动生成一个 dump.rdb



![image-20201101210127478](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201101210127478.png)



> 如果恢复rdb文件！

1、只需要将rdb文件放在我们redis启动目录就可以，redis启动的时候会自动检查dump.rdb 恢复其中 的数据！



2、查看需要存在的位置

```properties
127.0.0.1:6379> config get dir
1) "dir"
2) "/usr/local/bin" # 如果在这个目录下存在 dump.rdb 文件，启动就会自动恢复其中的数据
```



> 几乎就他自己默认的配置就够用了，但是我们还是需要去学习！

优点：

1、适合大规模的数据恢复！ 

2、对数据的完整性要不高！ 

缺点： 

1、需要一定的时间间隔进程操作！如果redis意外宕机了，这个最后一次修改数据就没有的了！

2、fork进程的时候，会占用一定的内容空间！！



### AOF（Append Only File）

+++++++++++

将我们的所有命令都记录下来，history，恢复的时候就把这个文件全部在执行一遍！

> 是什么

![image-20201102153210918](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102153210918.png)

以日志的形式来记录每个写操作，将Redis执行过的所有指令记录下来（读操作不记录），只许追加文件 但不可以改写文件，redis启动之初会读取该文件重新构建数据，换言之，redis重启的话就根据日志文件 的内容将写指令从前到后执行一次以完成数据的恢复工作



Aof保存的是 appendonly.aof 文件



> append

![image-20201102153248323](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102153248323.png)

默认是不开启的，我们需要手动进行配置！我们只需要将 appendonly 改为yes就开启了 aof！

重启，redis 就可以生效了！

如果这个 aof 文件有错位，这时候 redis 是启动不起来的吗，我们需要修复这个aof文件redis 给我们提供了一个工具 redis-check-aof --fix

![image-20201102153336590](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102153336590.png)



> 重写规则说明

aof 默认就是文件的无限追加，文件会越来越大！

![image-20201102153416708](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102153416708.png)

如果 aof 文件大于 64m，太大了！ fork一个新的进程来将我们的文件进行重写！

> 优点缺点

```properties
appendonly no # 默认是不开启aof模式的，默认是使用rdb方式持久化的，在大部分所有的情况下，rdb完全够用！
appendfilename "appendonly.aof" # 持久化的文件的名字
# appendfsync always # 每次修改都会 sync。消耗性能
appendfsync everysec # 每秒执行一次 sync，可能会丢失这1s的数据！
# appendfsync no # 不执行 sync，这个时候操作系统自己同步数据，速度最快！
# rewrite 重写
```

优点：

 1、每一次修改都同步，文件的完整会更加好！ 

2、每秒同步一次，可能会丢失一秒的数据 

3、从不同步，效率最高的！ 

缺点： 

1、相对于数据文件来说，aof远远大于 rdb，修复的速度也比 rdb慢！

2、Aof 运行效率也要比 rdb 慢，所以我们redis默认的配置就是rdb持久化！

扩展： 

1、RDB 持久化方式能够在指定的时间间隔内对你的数据进行快照存储

2、AOF 持久化方式记录每次对服务器写的操作，当服务器重启的时候会重新执行这些命令来恢复原始 的数据，AOF命令以Redis 协议追加保存每次写的操作到文件末尾，Redis还能对AOF文件进行后台重 写，使得AOF文件的体积不至于过大。 

3、只做缓存，如果你只希望你的数据在服务器运行的时候存在，你也可以不使用任何持久化 

4、同时开启两种持久化方式 

- 在这种情况下，当redis重启的时候会优先载入AOF文件来恢复原始的数据，因为在通常情况下AOF 文件保存的数据集要比RDB文件保存的数据集要完整。
- RDB 的数据不实时，同时使用两者时服务器重启也只会找AOF文件，那要不要只使用AOF呢？作者 建议不要，因为RDB更适合用于备份数据库（AOF在不断变化不好备份），快速重启，而且不会有 AOF可能潜在的Bug，留着作为一个万一的手段。 

5、性能建议 

- 因为RDB文件只用作后备用途，建议只在Slave上持久化RDB文件，而且只要15分钟备份一次就够 了，只保留 save 900 1 这条规则。 
- 如果Enable AOF ，好处是在最恶劣情况下也只会丢失不超过两秒数据，启动脚本较简单只load自 己的AOF文件就可以了，代价一是带来了持续的IO，二是AOF rewrite 的最后将 rewrite 过程中产 生的新数据写到新文件造成的阻塞几乎是不可避免的。只要硬盘许可，应该尽量减少AOF rewrite 的频率，AOF重写的基础大小默认值64M太小了，可以设到5G以上，默认超过原大小100%大小重 写可以改到适当的数值。
- 如果不Enable AOF ，仅靠 Master-Slave Repllcation 实现高可用性也可以，能省掉一大笔IO，也 减少了rewrite时带来的系统波动。代价是如果Master/Slave 同时倒掉，会丢失十几分钟的数据， 启动脚本也要比较两个 Master/Slave 中的 RDB文件，载入较新的那个，微博就是这种架构。



## Redis发布订阅

+++++++++++++++

Redis 发布订阅(pub/sub)是一种消息通信模式：发送者(pub)发送消息，订阅者(sub)接收消息。微信、 微博、关注系统！ 

Redis 客户端可以订阅任意数量的频道。 

订阅/发布消息图：

第一个：消息发送者， 第二个：频道 第三个：消息订阅者！

![image-20201102155443125](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155443125.png)

下图展示了频道 channel1 ， 以及订阅这个频道的三个客户端 —— client2 、 client5 和 client1 之间的 关系：

![image-20201102155531033](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155531033.png)

> 命令

这些命令被广泛用于构建即时通信应用，比如网络聊天室(chatroom)和实时广播、实时提醒等。

![image-20201102155600809](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155600809.png)

> 测试

![image-20201102155615758](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155615758.png)

> 原理

Redis是使用C实现的，通过分析 Redis 源码里的 pubsub.c 文件，了解发布和订阅机制的底层实现，籍 此加深对 Redis 的理解。

Redis 通过 PUBLISH 、SUBSCRIBE 和 PSUBSCRIBE 等命令实现发布和订阅功能。 

微信：

 通过 SUBSCRIBE 命令订阅某频道后，redis-server 里维护了一个字典，字典的键就是一个个 频道！， 而字典的值则是一个链表，链表中保存了所有订阅这个 channel 的客户端。SUBSCRIBE 命令的关键， 就是将客户端添加到给定 channel 的订阅链表中。

![image-20201102155654636](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155654636.png)

通过 PUBLISH 命令向订阅者发送消息，redis-server 会使用给定的频道作为键，在它所维护的 channel 字典中查找记录了订阅这个频道的所有客户端的链表，遍历这个链表，将消息发布给所有订阅者。

![image-20201102155710119](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102155710119.png)

Pub/Sub 从字面上理解就是发布（Publish）与订阅（Subscribe），在Redis中，你可以设定对某一个 key值进行消息发布及消息订阅，当一个key值上进行了消息发布后，所有订阅它的客户端都会收到相应 的消息。这一功能最明显的用法就是用作实时消息系统，比如普通的即时聊天，群聊等功能。

使用场景： 

1、实时消息系统！ 

2、事实聊天！（频道当做聊天室，将信息回显给所有人即可！） 

3、订阅，关注系统都是可以的！ 

稍微复杂的场景我们就会使用 消息中间件 MQ （）



## Redis主从复制

---------------------

### 概念

主从复制，是指将一台Redis服务器的数据，复制到其他的Redis服务器。前者称为主节点 (master/leader)，后者称为从节点(slave/follower)；数据的复制是单向的，只能由主节点到从节点。 Master以写为主，Slave 以读为主。

默认情况下，每台Redis服务器都是主节点；

且一个主节点可以有多个从节点(或没有从节点)，但一个从节点只能有一个主节点。（）

主从复制的作用主要包括：

1、数据冗余：主从复制实现了数据的热备份，是持久化之外的一种数据冗余方式。 

2、故障恢复：当主节点出现问题时，可以由从节点提供服务，实现快速的故障恢复；实际上是一种服务 的冗余。 

3、负载均衡：在主从复制的基础上，配合读写分离，可以由主节点提供写服务，由从节点提供读服务 （即写Redis数据时应用连接主节点，读Redis数据时应用连接从节点），分担服务器负载；尤其是在写 少读多的场景下，通过多个从节点分担读负载，可以大大提高Redis服务器的并发量。 

4、高可用（集群）基石：除了上述作用以外，主从复制还是哨兵和集群能够实施的基础，因此说主从复 制是Redis高可用的基础。 

一般来说，要将Redis运用于工程项目中，只使用一台Redis是万万不能的（宕机），原因如下： 

1、从结构上，单个Redis服务器会发生单点故障，并且一台服务器需要处理所有的请求负载，压力较 大；

 2、从容量上，单个Redis服务器内存容量有限，就算一台Redis服务器内存容量为256G，也不能将所有 内存用作Redis存储内存，一般来说，单台Redis最大使用内存不应该超过20G。 

商网站上的商品，一般都是一次上传，无数次浏览的，说专业点也就是"多读少写"。 

对于这种场景，我们可以使如下这种架构： 

![image-20201102161142110](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102161142110.png)

主从复制，读写分离！ 80% 的情况下都是在进行读操作！减缓服务器的压力！架构中经常使用！ 一主 二从！ 

只要在公司中，主从复制就是必须要使用的，因为在真实的项目中不可能单机使用Redis！



### 环境配置

++++++++++++++++++

只配置从库，不用配置主库！

```properties
127.0.0.1:6379> info replication # 查看当前库的信息
# Replication
role:master # 角色 master
connected_slaves:0 # 没有从机
master_replid:b63c90e6c501143759cb0e7f450bd1eb0c70882a
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
```

复制3个配置文件，然后修改对应的信息 

1、端口 

2、pid 名字 

3、log文件名字 

4、dump.rdb

名字 修改完毕之后，启动我们的3个redis服务器，可以通过进程信息查看！

![image-20201102161307945](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102161307945.png)



### 一主二从

++++++++++++++

默认情况下，每台Redis服务器都是主节点； 我们一般情况下只用配置从机就好了！

```properties
127.0.0.1:6380> SLAVEOF 127.0.0.1 6379 # SLAVEOF host 6379 找谁当自己的老大！
OK
127.0.0.1:6380> info replication
# Replication
role:slave # 当前角色是从机
master_host:127.0.0.1 # 可以的看到主机的信息
master_port:6379
master_link_status:up
master_last_io_seconds_ago:3
master_sync_in_progress:0
slave_repl_offset:14
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:a81be8dd257636b2d3e7a9f595e69d73ff03774e
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:14
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:14
# 在主机中查看！
127.0.0.1:6379> info replication
# Replication
role:master
connected_slaves:1 # 多了从机的配置
slave0:ip=127.0.0.1,port=6380,state=online,offset=42,lag=1 # 多了从机的配置
master_replid:a81be8dd257636b2d3e7a9f595e69d73ff03774e
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:42
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:42

```

如果两个都配置完了，就是有两个从机的

![image-20201102161505230](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102161505230.png)

真实的从主配置应该在配置文件中配置，这样的话是永久的，我们这里使用的是命令，暂时的！

> 细节

主机可以写，从机不能写只能读！主机中的所有信息和数据，都会自动被从机保存！

主机写：

![image-20201102161611117](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102161611117.png)

从机只能读取内容！

![image-20201102161631682](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102161631682.png)

测试：主机断开连接，从机依旧连接到主机的，但是没有写操作，这个时候，主机如果回来了，从机依 旧可以直接获取到主机写的信息！

如果是使用命令行，来配置的主从，这个时候如果重启了，就会变回主机！只要变为从机，立马就会从 主机中获取值！

> 复制原理

Slave 启动成功连接到 master 后会发送一个sync同步命令

Master 接到命令，启动后台的存盘进程，同时收集所有接收到的用于修改数据集命令，在后台进程执行 完毕之后，master将传送整个数据文件到slave，并完成一次完全同步。

全量复制：而slave服务在接收到数据库文件数据后，将其存盘并加载到内存中。

增量复制：Master 继续将新的所有收集到的修改命令依次传给slave，完成同步

但是只要是重新连接master，一次完全同步（全量复制）将被自动执行！ 我们的数据一定可以在从机中 看到！

> 层层链路

上一个M链接下一个

![image-20201102162012105](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102162012105.png)

这时候也可以完成我们的主从复制！

> 如果没有老大了，这个时候能不能选择一个老大出来呢？ 手动！

谋朝篡位 

如果主机断开了连接，我们可以使用 **SLAVEOF no one** 让自己变成主机！其他的节点就可以手动连 接到最新的这个主节点（手动）！如果这个时候老大修复了，那就重新连接！



### 哨兵模式

++++++++++++

（自动选举老大的模式）

> 概述

主从切换技术的方法是：当主服务器宕机后，需要手动把一台从服务器切换为主服务器，这就需要人工 干预，费事费力，还会造成一段时间内服务不可用。这不是一种推荐的方式，更多时候，我们优先考虑 哨兵模式。Redis从2.8开始正式提供了Sentinel（哨兵） 架构来解决这个问题。

谋朝篡位的自动版，能够后台监控主机是否故障，如果故障了根据投票数自动将从库转换为主库。

哨兵模式是一种特殊的模式，首先Redis提供了哨兵的命令，哨兵是一个独立的进程，作为进程，它会独 立运行。其原理是哨兵通过发送命令，等待Redis服务器响应，从而监控运行的多个Redis实例。

![image-20201102163500189](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102163500189.png)

这里的哨兵有两个作用

- 通过发送命令，让Redis服务器返回监控其运行状态，包括主服务器和从服务器。 
- 当哨兵监测到master宕机，会自动将slave切换成master，然后通过发布订阅模式通知其他的从服 务器，修改配置文件，让它们切换主机。



然而一个哨兵进程对Redis服务器进行监控，可能会出现问题，为此，我们可以使用多个哨兵进行监控。 各个哨兵之间还会进行监控，这样就形成了多哨兵模式。

![image-20201102163846443](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102163846443.png)

假设主服务器宕机，哨兵1先检测到这个结果，系统并不会马上进行failover过程，仅仅是哨兵1主观的认 为主服务器不可用，这个现象成为主观下线。当后面的哨兵也检测到主服务器不可用，并且数量达到一 定值时，那么哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，进行failover[故障转移]操作。 切换成功后，就会通过发布订阅模式，让各个哨兵把自己监控的从服务器实现切换主机，这个过程称为 客观下线。

> 测试！



1、配置哨兵配置文件 sentinel.conf

```properties
# sentinel monitor 被监控的名称 host port 1
sentinel monitor myredis 127.0.0.1 6379 1

```

后面的这个数字1，代表主机挂了，slave投票看让谁接替成为主机，票数最多的，就会成为主机！

2、启动哨兵！

```properties
[root@kuangshen bin]# redis-sentinel kconfig/sentinel.conf
26607:X 31 Mar 2020 21:13:10.027 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
26607:X 31 Mar 2020 21:13:10.027 # Redis version=5.0.8, bits=64, commit=00000000, modified=0, pid=26607, just started
26607:X 31 Mar 2020 21:13:10.027 # Configuration loaded
_._
_.-``__ ''-._
_.-`` `. `_. ''-._ Redis 5.0.8 (00000000/0) 64 bit
.-`` .-```. ```\/ _.,_ ''-._
( ' , .-` | `, ) Running in sentinel mode
|`-._`-...-` __...-.``-._|'` _.-'| Port: 26379
| `-._ `._ / _.-' | PID: 26607
`-._ `-._ `-./ _.-' _.-'
|`-._`-._ `-.__.-' _.-'_.-'|
| `-._`-._ _.-'_.-' | http://redis.io
`-._ `-._`-.__.-'_.-' _.-'
|`-._`-._ `-.__.-' _.-'_.-'|
| `-._`-._ _.-'_.-' |
`-._ `-._`-.__.-'_.-' _.-
`-._ `-.__.-' _.-'
`-._ _.-'
`-.__.-'
26607:X 31 Mar 2020 21:13:10.029 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower valueof 128.
26607:X 31 Mar 2020 21:13:10.031 # Sentinel ID is
4c780da7e22d2aebe3bc20c333746f202ce72996
26607:X 31 Mar 2020 21:13:10.031 # +monitor master myredis 127.0.0.1 6379 quorum 1
26607:X 31 Mar 2020 21:13:10.031 * +slave slave 127.0.0.1:6380 127.0.0.1 6380 @myredis 127.0.0.1 6379
26607:X 31 Mar 2020 21:13:10.033 * +slave slave 127.0.0.1:6381 127.0.0.1 6381 @myredis 127.0.0.1 6379


```

如果Master 节点断开了，这个时候就会从从机中随机选择一个服务器！ （这里面有一个投票算法！）

![image-20201102164438806](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102164438806.png)

哨兵日志！

![image-20201102164451473](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102164451473.png)

如果主机此时回来了，只能归并到新的主机下，当做从机，这就是哨兵模式的规则！

> 哨兵模式

优点： 

1、哨兵集群，基于主从复制模式，所有的主从配置优点，它全有 

2、 主从可以切换，故障可以转移，系统的可用性就会更好 

3、哨兵模式就是主从模式的升级，手动到自动，更加健壮！ 

缺点： 

1、Redis 不好啊在线扩容的，集群容量一旦到达上限，在线扩容就十分麻烦！ 2、实现哨兵模式的配置其实是很麻烦的，里面有很多选择！

> 哨兵模式的全部配置！

```properties
# Example sentinel.conf
# 哨兵sentinel实例运行的端口 默认26379
port 26379
# 哨兵sentinel的工作目录
dir /tmp
# 哨兵sentinel监控的redis主节点的 ip port
# master-name 可以自己命名的主节点名字 只能由字母A-z、数字0-9 、这三个字符".-_"组成。
# quorum 配置多少个sentinel哨兵统一认为master主节点失联 那么这时客观上认为主节点失联了
# sentinel monitor <master-name> <ip> <redis-port> <quorum>
sentinel monitor mymaster 127.0.0.1 6379 2
# 当在Redis实例中开启了requirepass foobared 授权密码 这样所有连接Redis实例的客户端都要提供密码
# 设置哨兵sentinel 连接主从的密码 注意必须为主从设置一样的验证密码
# sentinel auth-pass <master-name> <password>
sentinel auth-pass mymaster MySUPER--secret-0123passw0rd
# 指定多少毫秒之后 主节点没有应答哨兵sentinel 此时 哨兵主观上认为主节点下线 默认30秒
# sentinel down-after-milliseconds <master-name> <milliseconds>
sentinel down-after-milliseconds mymaster 30000
# 这个配置项指定了在发生failover主备切换时最多可以有多少个slave同时对新的master进行 同步，
这个数字越小，完成failover所需的时间就越长，
但是如果这个数字越大，就意味着越 多的slave因为replication而不可用。
可以通过将这个值设为 1 来保证每次只有一个slave 处于不能处理命令请求的状态。
# sentinel parallel-syncs <master-name> <numslaves>
sentinel parallel-syncs mymaster 1
# 故障转移的超时时间 failover-timeout 可以用在以下这些方面：
#1. 同一个sentinel对同一个master两次failover之间的间隔时间。
#2. 当一个slave从一个错误的master那里同步数据开始计算时间。直到slave被纠正为向正确的master那
里同步数据时。
#3.当想要取消一个正在进行的failover所需要的时间。
#4.当进行failover时，配置所有slaves指向新的master所需的最大时间。不过，即使过了这个超时，
slaves依然会被正确配置为指向master，但是就不按parallel-syncs所配置的规则来了
# 默认三分钟
# sentinel failover-timeout <master-name> <milliseconds>
sentinel failover-timeout mymaster 180000
# SCRIPTS EXECUTION
#配置当某一事件发生时所需要执行的脚本，可以通过脚本来通知管理员，例如当系统运行不正常时发邮件通知
相关人员。
#对于脚本的运行结果有以下规则：
#若脚本执行后返回1，那么该脚本稍后将会被再次执行，重复次数目前默认为10
#若脚本执行后返回2，或者比2更高的一个返回值，脚本将不会重复执行。
#如果脚本在执行过程中由于收到系统中断信号被终止了，则同返回值为1时的行为相同。
#一个脚本的最大执行时间为60s，如果超过这个时间，脚本将会被一个SIGKILL信号终止，之后重新执行。
#通知型脚本:当sentinel有任何警告级别的事件发生时（比如说redis实例的主观失效和客观失效等等），将会去调用这个脚本，这时这个脚本应该通过邮件，SMS等方式去通知系统管理员关于系统不正常运行的信息。调用该脚本时，将传给脚本两个参数，一个是事件的类型，一个是事件的描述。如果sentinel.conf配置文件中配置了这个脚本路径，那么必须保证这个脚本存在于这个路径，并且是可执行的，否则sentinel无法正常启动成功。
#通知脚本
# shell编程
# sentinel notification-script <master-name> <script-path>
sentinel notification-script mymaster /var/redis/notify.sh
# 客户端重新配置主节点参数脚本
# 当一个master由于failover而发生改变时，这个脚本将会被调用，通知相关的客户端关于master地址已
经发生改变的信息。
# 以下参数将会在调用脚本时传给脚本:
# <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>
# 目前<state>总是“failover”,
# <role>是“leader”或者“observer”中的一个。
# 参数 from-ip, from-port, to-ip, to-port是用来和旧的master和新的master(即旧的slave)通
信的
# 这个脚本应该是通用的，能被多次调用，不是针对性的。
# sentinel client-reconfig-script <master-name> <script-path>
sentinel client-reconfig-script mymaster /var/redis/reconfig.sh # 一般都是由运维来配
置！
```



## Redis缓存穿透和雪崩

++++++++++++++

> 服务的高可用问题！

在这里我们不会详细的区分析解决方案的底层！

Redis缓存的使用，极大的提升了应用程序的性能和效率，特别是数据查询方面。但同时，它也带来了一 些问题。其中，最要害的问题，就是数据的一致性问题，从严格意义上讲，这个问题无解。如果对数据 的一致性要求很高，那么就不能使用缓存。

另外的一些典型问题就是，缓存穿透、缓存雪崩和缓存击穿。目前，业界也都有比较流行的解决方案。

![image-20201102165448824](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102165448824.png)

### 缓存穿透（查不到）

> 概念

缓存穿透的概念很简单，用户想要查询一个数据，发现redis内存数据库没有，也就是缓存没有命中，于 是向持久层数据库查询。发现也没有，于是本次查询失败。当用户很多的时候，缓存都没有命中（秒 杀！），于是都去请求了持久层数据库。这会给持久层数据库造成很大的压力，这时候就相当于出现了 缓存穿透。

> 解决方案

布隆过滤器

布隆过滤器是一种数据结构，对所有可能查询的参数以hash形式存储，在控制层先进行校验，不符合则 丢弃，从而避免了对底层存储系统的查询压力；

![image-20201102165526870](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102165526870.png)

缓存空对象

当存储层不命中后，即使返回的空对象也将其缓存起来，同时会设置一个过期时间，之后再访问这个数 据将会从缓存中获取，保护了后端数据源；

![image-20201102165545879](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102165545879.png)

但是这种方法会存在两个问题：

1、如果空值能够被缓存起来，这就意味着缓存需要更多的空间存储更多的键，因为这当中可能会有很多 的空值的键；

2、即使对空值设置了过期时间，还是会存在缓存层和存储层的数据会有一段时间窗口的不一致，这对于 需要保持一致性的业务会有影响。



### 缓存击穿（量太大，缓存过期！）

++++++++++++++

> 概述

这里需要注意和缓存击穿的区别，缓存击穿，是指一个key非常热点，在不停的扛着大并发，大并发集中 对这一个点进行访问，当这个key在失效的瞬间，持续的大并发就穿破缓存，直接请求数据库，就像在一 个屏障上凿开了一个洞。

当某个key在过期的瞬间，有大量的请求并发访问，这类数据一般是热点数据，由于缓存过期，会同时访 问数据库来查询最新数据，并且回写缓存，会导使数据库瞬间压力过大。

> 解决方案

**设置热点数据永不过期**

从缓存层面来看，没有设置过期时间，所以不会出现热点 key 过期后产生的问题。

**加互斥锁**

分布式锁：使用分布式锁，保证对于每个key同时只有一个线程去查询后端服务，其他线程没有获得分布 式锁的权限，因此只需要等待即可。这种方式将高并发的压力转移到了分布式锁，因此对分布式锁的考 验很大。

![image-20201102170324650](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102170324650.png)



### 缓存雪崩

+++++++++++++++

> 概念

缓存雪崩，是指在某一个时间段，缓存集中过期失效。Redis 宕机！

产生雪崩的原因之一，比如在写本文的时候，马上就要到双十二零点，很快就会迎来一波抢购，这波商 品时间比较集中的放入了缓存，假设缓存一个小时。那么到了凌晨一点钟的时候，这批商品的缓存就都 过期了。而对这批商品的访问查询，都落到了数据库上，对于数据库而言，就会产生周期性的压力波 峰。于是所有的请求都会达到存储层，存储层的调用量会暴增，造成存储层也会挂掉的情况。

![image-20201102170429098](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20201102170429098.png)

其实集中过期，倒不是非常致命，比较致命的缓存雪崩，是缓存服务器某个节点宕机或断网。因为自然 形成的缓存雪崩，一定是在某个时间段集中创建缓存，这个时候，数据库也是可以顶住压力的。无非就 是对数据库产生周期性的压力而已。而缓存服务节点的宕机，对数据库服务器造成的压力是不可预知 的，很有可能瞬间就把数据库压垮。

> 解决方案

**redis高可用**

这个思想的含义是，既然redis有可能挂掉，那我多增设几台redis，这样一台挂掉之后其他的还可以继续 工作，其实就是搭建的集群。（异地多活！）

**限流降级**

这个解决方案的思想是，在缓存失效后，通过加锁或者队列来控制读数据库写缓存的线程数量。比如对 某个key只允许一个线程查询数据和写缓存，其他线程等待。

**数据预热**

数据加热的含义就是在正式部署之前，我先把可能的数据先预先访问一遍，这样部分可能大量访问的数 据就会加载到缓存中。在即将发生大并发访问前手动触发加载缓存不同的key，设置不同的过期时间，让 缓存失效的时间点尽量均匀。