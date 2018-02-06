### mybatis 学习文档`基础`
````
========================基本==============================
````
#### 解决数据库与bean的映射
```
1.产生原因，数据库字段采用A_B_c的格式
解决方式：
1.查询字段采用别名的方式
2.采用resultMap，设置column 和字段
3.mybatis全局配置:<setting name="mapUnderscoreToCamelCase" value="true" />
````
#### bean字段类型问题
````
java基本类型是有默认值的，比如int a，那么对应在xml文件中用 a!=null判断会失败，因为a默认会是0
解决方式：
1.使用包装类型 int -> Integer
2.如果数据库是int bean是boolean 可以使用*handler具体忘记了
````
#### 基本技巧
````
1.在任何时候都拒绝使用*作为查询
2.parameterType不建议配置，因为其可以自动推算
3.如果可以尽量配上 
注意：二进制和时间 jdbcType :data time datetime -> DATE TIME TIMESTAMP
4.返回主键：有2个属性可以设置，*genataor，selectKey，什么；还能使用select自动生成主键，但是建议统一生成主键
5.可以根据数据库类型做判断写不同的sql
````
### 多表关联如何设置返回
````
1.新建继承对象，添加属性，不可取
2.在对象中添加其他对象作为字段，修改sql语句，不好
3.用resultmap处理！
````
````
========================动态|静态标签==============================
````
### if:经常用于查询更新等,使用ognl表达式
````
if ("A!=null and | or "){
}
````
### choose:用于选择，替代if不能使用else
````
choose
 when 
 when
 otherwise
 记得跟上otherwise
````
### when ,set trim 
````
when 标签用于查询自动添加when ,这样避免使用when 1=1
set 用于更新标签
trim 替代when set
````
### foreach
````
用于循环，比如批量删除,id in (....)
foreach()可以传入array list map等
````
### 静态标签等等，可以参考我的有道文档
````
xml基础标签：
mapper,resultMap,select ,update ,delete,insert,
concat 连接字符串
````
````
========================缓存==============================
````
#### 缓存
````
1.默认开启一级，sqlsession
2.二级缓存，sqlsessionfactory，针对namespace的，
    如果有脏数据，可以使用参照缓存
    在多表(比较少量)，不长更新的请款下使用
3.集成ehcache ,mybatis
4.建议自己在业务层自己做可控缓存
````
````
========================高级映射==============================
````
#### 高级映射 1对多，多对多