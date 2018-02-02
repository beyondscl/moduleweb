package com.bird.domain;

import lombok.Data;

@Data
public class ArticleDiscuss {
    //注释:  默认值: null 是否可为空 NO
    private String id;
    //注释: 文章id 默认值: null 是否可为空 YES
    private String articleId;
    //注释: 作者id,可以游客 默认值: null 是否可为空 YES
    private String authorId;
    //注释: 创建时间 默认值: null 是否可为空 NO
    private String createTime;
    //注释: 回复谁 默认值: null 是否可为空 YES
    private String parentId;
    //注释: 是否有效1有效;0无效 默认值: null 是否可为空 NO
    private int effective;
}
