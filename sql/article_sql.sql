USE world;
DROP TABLE article_dir;

CREATE TABLE article_dir (
  id          VARCHAR(32) NOT NULL PRIMARY KEY,
  author_id   VARCHAR(32) COMMENT '作者id',
  dir_name    VARCHAR(100) COMMENT '目录名称',
  create_time VARCHAR(32) NOT NULL,
  update_time VARCHAR(32) NOT NULL
  COMMENT '最后修改时间',
  effective   INT(1)      NOT NULL
  COMMENT '是否有效1有效;0无效'
)
  COMMENT = '文章目录表';

DROP TABLE article;
CREATE TABLE article (
  id             VARCHAR(32) NOT NULL PRIMARY KEY,
  article_dir_id VARCHAR(32) NOT NULL
  COMMENT '文章分类',
  author_id      VARCHAR(32) COMMENT '作者id',
  article_type   INT     DEFAULT 1
  COMMENT '1原创，2转载',
  title          VARCHAR(100) COMMENT '文章标题',
  content        BLOB COMMENT '内容，带格式的，直接包含了附件，图片等连接',
  privilege      INT     DEFAULT 1
  COMMENT '权限类型0私有，1公开，2关注我的',
  key_words      VARCHAR(100) COMMENT '关键字',
  discuss_type   INT     DEFAULT 1
  COMMENT '1开启评论 0关闭',
  create_time    VARCHAR(32) NOT NULL
  COMMENT '创建时间',
  update_time    VARCHAR(32) COMMENT '最后修改时间',
  update_times   INT     DEFAULT 0
  COMMENT '修改次数',
  view_times     INT     DEFAULT 0
  COMMENT '查阅次数',
  effective      CHAR(1) DEFAULT 1
  COMMENT '是否有效1有效;0无效'
)
  COMMENT = '文章表';

DROP TABLE article_discuss;
CREATE TABLE article_discuss (
  id          VARCHAR(32) NOT NULL PRIMARY KEY,
  article_id  VARCHAR(32) COMMENT '文章id',
  author_id   VARCHAR(32) COMMENT '作者id,可以游客',
  create_time VARCHAR(32) NOT NULL
  COMMENT '创建时间',
  parent_id   VARCHAR(32) COMMENT '回复谁',
  effective   INT(1)      NOT NULL
  COMMENT '是否有效1有效;0无效'
)
  COMMENT = '文章评论表';

COMMIT;