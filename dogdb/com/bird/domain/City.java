package com.bird.domain; 
import lombok.Data;
@Data
public class City { 
 //注释: auto_increment 默认值: null 是否可为空 NO
 private int ID;
 //注释:  默认值:  是否可为空 NO
 private String Name;
 //注释:  默认值:  是否可为空 NO
 private String CountryCode;
 //注释:  默认值:  是否可为空 NO
 private String District;
 //注释:  默认值: 0 是否可为空 NO
 private int Population;
}
