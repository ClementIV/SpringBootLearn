# Spring Boot 集成HikariCP数据源

## 默认数据库连接池

SpringJDBC操作数据库的工具类jdbcTemplate在创建数据库连接池DataSource对象，只是使用的是Spring内置的、简单的数据库连接池对象DriverManagerDataSource;

## 数据库连接池的起源

建立一个数据库连接池是一件非常耗时（消耗时间）耗力（消耗资源）的事情，之所以耗时耗力，是因为连接到数据库服务器需要经历几个漫长的阶段：建立物理通道(例如套接字或命名管道)、与服务器进程初次握手，分析连接字符串信息，由服务器对连接进行身份验证、运行检查以便在当前事务中进行登记等

既然新建一条连接需要经历这么多的阶段，而且耗时耗力;那么为什么不重复利用已有的连接呢？这时数据库连接池技术就出现了.数据库连接池负责管理数据库连接的创建、分配和释放，它允许应用程序重复使用已有的数据库连接，而不是重新建立一个是数据连接、

![image](https://raw.githubusercontent.com/ClementIV/picture/master/5b25b4b952723d898625232544f507eb.png)

从图中可以看出数据库连接池的基本原理是在内部对象池中维护一定数量的数据库连接，并对外暴露获取数据库连接的方法，例如，使用者可通过`getConnection`方法获取连接，使用完毕后再通过`releaseConntection`方法将连接放回数据库连接池里。注意`此时并不是真正关闭连接，而是由连接池管理器进行回收，并为下一次使用做好准备`

## 常用的数据库连接池极其配置

<div class="bi-table">
  <table>
    <colgroup>
      <col width="90px" />
      <col width="163px" />
      <col width="124px" />
      <col width="110px" />
      <col width="90px" />
      <col width="163px" />
      <col width="85px" />
    </colgroup>
    <tbody>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">功能类别</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">功能</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">Druid</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">HikariCP</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">DBCP</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">Tomcat-jdbc</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">C3P0</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="3" colSpan="1">
          <div data-type="p">性能</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">PSCache</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">LRU</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">SLB负载均衡支持</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">稳定性</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">ExceptionSorter </div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">扩展</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">扩展</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">Filter</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p"></div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p"></div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">JdbcIntercepter</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p"></div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="3" colSpan="1">
          <div data-type="p">监控</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">监控方式</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">jmx/log/http</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">jmx/metrics</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">jmx</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">jmx</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">jmx</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">支持SQL级监控</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">Spring/Web关联监控</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="2" colSpan="1">
          <div data-type="p"></div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">诊断支持</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">LogFilter</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">连接泄露诊断</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">logAbandoned</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="2" colSpan="1">
          <div data-type="p">安全</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">SQL防注入</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">无</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">无</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">无</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">无</div>
        </td>
      </tr>
      <tr height="34px">
        <td rowspan="1" colSpan="1">
          <div data-type="p">支持配置加密</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">是</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
        <td rowspan="1" colSpan="1">
          <div data-type="p">否</div>
        </td>
      </tr>
    </tbody>
  </table>
</div>

### 参数配置

|属性 | 说明|
|-|-|
最小连接数 | 数据库连接池一直保持的最小的数据库连接数，所以如果应用程序对数据库连接的使用量不大，但是又把这个数值设置的会比大，将会导致大量数据库资源被浪费
初始化连接数 | 连接池启动时，初始化数据库连接的数量
最大连接数 | 是数据库连接池能申请的最大的数据库连接数，如果应用程序访问数据库的请求超过此请求数，后面的数据库连接请求被加入到等待队列中
最大等待时间 |当数据库连接池内没有可用连接时，连接池等待被归还的最大时间，超过时间则抛出异常，可设置参数为0或者负数使得无限等待（根据不同的连接池设置）

### 总结

为了发挥数据库连接池的关键作用，在应用启动时，将初始化一定数量的数据库连接放到连接池中，这些数据库连接的数量是由最小数据库连接数来设定。无论这些数据连接是否被使用，连接池内都将保证至少有那么多连接

