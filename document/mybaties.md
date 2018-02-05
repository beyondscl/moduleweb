### mybatis 学习文档
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
使用包装类型 int -> Integer
````
#### 基本技巧
````
1.在任何时候都拒绝使用*作为查询
2.parameterType不建议配置，因为其可以自动推算
3.如果可以尽量配上 
注意：二进制和时间 jdbcType :data time datetime -> DATE TIME TIMESTAMP
````
### 多表关联如何设置返回？
````
1.新建继承对象，添加属性，不可取
2.在对象中添加其他对象作为字段，修改sql语句，不好
3.用resultmap处理！
````
