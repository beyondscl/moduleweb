package com.bird.domain; 
import lombok.Data;
@Data
public class Countrylanguage { 
 //注释:  默认值:  是否可为空 NO
 private String CountryCode;
 //注释:  默认值:  是否可为空 NO
 private String Language;
 //注释:  默认值: F 是否可为空 NO
 private enum('T','F')IsOfficial;
 //注释:  默认值: 0.0 是否可为空 NO
 private double Percentage;
}
