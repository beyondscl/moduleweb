package com.bird.domain;

import lombok.Data;

import java.io.Serializable;

@Data

public class User extends Page implements Serializable {

    //注释:  默认值: null 是否可为空 NO

    private String id;

    //注释:  默认值: null 是否可为空 YES

    private String name;

    //注释:  默认值: null 是否可为空 YES

    private Integer age;

    //注释:  默认值: null 是否可为空 YES

    private String password;

}
 
