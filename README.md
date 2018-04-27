# moduleweb
#### 如何创建模块式项目
```
 1.新建maven空项目
 2.新建javase项目作为第一子项目，工具类引入
 3.新建web子项目，作为web的第一子项目，作为框架使用
 ```
 ```
 dogauth作为登录授权模块引入
 dogcore作为核心模块引入
 dogdb作为操作数据库，自动生成相关java jsp xml
 dogueditor百度富文本编辑器
 dogweb web主模块
 ```
#### 如何提交项目
```
 1.github新建仓库，复制地址
 2.idea允许CVS，add,commit，然后在push选择上一步的地址，push完成
```


#### 各种小问题
```
是否引入tomcat包为提供者
jdk1.8版本，
idea设置版本对不对，
tomat8 
springt4+，

idea maven 关闭offline不然不会去拉包

下面2个原因不排除的引入了nexus，本地中有，而私有库中没有.
有时候就是莫名其妙idea不识别包，删除pom在还原
有时候莫名其妙不识别jar包。换个版本重新下载或者删除本地库|或者将jar上传到nexus，让nexus中存在
虽然有时候有些莫名其妙。

```
