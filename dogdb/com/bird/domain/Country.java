package com.bird.domain; 
import lombok.Data;
@Data
public class Country { 
 //注释:  默认值:  是否可为空 NO
 private String Code;
 //注释:  默认值:  是否可为空 NO
 private String Name;
 //注释:  默认值: Asia 是否可为空 NO
 private enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')Continent;
 //注释:  默认值:  是否可为空 NO
 private String Region;
 //注释:  默认值: 0.00 是否可为空 NO
 private double SurfaceArea;
 //注释:  默认值: null 是否可为空 YES
 private int IndepYear;
 //注释:  默认值: 0 是否可为空 NO
 private int Population;
 //注释:  默认值: null 是否可为空 YES
 private double LifeExpectancy;
 //注释:  默认值: null 是否可为空 YES
 private double GNP;
 //注释:  默认值: null 是否可为空 YES
 private double GNPOld;
 //注释:  默认值:  是否可为空 NO
 private String LocalName;
 //注释:  默认值:  是否可为空 NO
 private String GovernmentForm;
 //注释:  默认值: null 是否可为空 YES
 private String HeadOfState;
 //注释:  默认值: null 是否可为空 YES
 private int Capital;
 //注释:  默认值:  是否可为空 NO
 private String Code2;
}
