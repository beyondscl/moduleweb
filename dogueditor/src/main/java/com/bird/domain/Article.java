package com.bird.domain;

import lombok.Data;

import java.io.UnsupportedEncodingException;

@Data
public class Article extends Page {
    //注释:  默认值: null 是否可为空 NO
    private String id;
    //注释: 文章分类 默认值: null 是否可为空 NO
    private String articleDirId;
    //注释: 作者id 默认值: null 是否可为空 YES
    private String authorId;
    //注释: 1原创，2转载 默认值: 1 是否可为空 YES
    private int articleType;
    //注释: 文章标题 默认值: null 是否可为空 YES
    private String title;
    //注释: 内容，带格式的，直接包含了附件，图片等连接 默认值: null 是否可为空 YES
    private byte[] content;

    public void setContent(byte[] content) {
        this.content = content;
        try {
            this.contentStr = new String(this.content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //主要是content为blob不方便读取，这个字段只为了页面能方便获取
    private String contentStr;

    //注释: 权限类型0私有，1公开，2关注我的 默认值: 1 是否可为空 YES
    private int privilege;
    //注释: 关键字 默认值: null 是否可为空 YES
    private String keyWords;
    //注释: 1开启评论 0关闭 默认值: 1 是否可为空 YES
    private int discussType;
    //注释: 创建时间 默认值: null 是否可为空 NO
    private String createTime;
    //注释: 最后修改时间 默认值: null 是否可为空 YES
    private String updateTime;
    //注释: 修改次数 默认值: 0 是否可为空 YES
    private int updateTimes;
    //注释: 查阅次数 默认值: 0 是否可为空 YES
    private int viewTimes;
    //注释: 是否有效1有效;0无效 默认值: 1 是否可为空 YES
    private int effective;
}
