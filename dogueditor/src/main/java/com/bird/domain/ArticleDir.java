package com.bird.domain;

import lombok.Data;

@Data

public class ArticleDir {

    //注释:  默认值: null 是否可为空 NO

    private String id;

    //注释: 作者id 默认值: null 是否可为空 YES

    private String authorId;

    //注释: 目录名称 默认值: null 是否可为空 YES

    private String dirName;

    //注释:  默认值: null 是否可为空 NO

    private String createTime;

    //注释: 最后修改时间 默认值: null 是否可为空 YES

    private String updateTime;

    //注释: 是否有效1有效;0无效 默认值: null 是否可为空 NO

    private Integer effective;

}
 
