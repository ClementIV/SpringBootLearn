# REST&SpringBoot

## HTTP方法与资源操作的关系

http方法 | 资源操作 | 幂等 | 安全
-|-|-|-
GET | SELECT | 是 | 是
POST | INSERT| 否 | 否
PUT | UPDATE | 是 | 否
DELETE | DELETE | 是 | 否

* 幂等性：对同一REST接口的多次访问，得到的资源是否相同
* 安全性：对该REST接口访问，不会使服务器资源的状态发生改变

## SpringBoot如何支持RESTful

天然支持

### SpringBoot中支持RESTful的普通方式

![image](https://raw.githubusercontent.com/ClementIV/picture/master/springbootr.png)

### SpringBoot中支持RESTful的简洁方式

![image](https://raw.githubusercontent.com/ClementIV/picture/master/spring2.png)

### 设计思路

![image](https://raw.githubusercontent.com/ClementIV/picture/master/spring3.png)

