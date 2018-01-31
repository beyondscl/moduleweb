package com.bird.domain; 
import lombok.Data;
@Data
public class User { 
 //注释:  默认值: null 是否可为空 NO
 private String id;
 //注释:  默认值: null 是否可为空 YES
 private String name;
 //注释:  默认值: null 是否可为空 YES
 private int age;
 //注释:  默认值: null 是否可为空 YES
 private String password;
}
