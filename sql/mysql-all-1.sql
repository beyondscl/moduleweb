use world;
show  global  variables like  'wait_timeout';  
select * from user;
update  user   set password = '123123' where id = '0';
-- delete from user;

TRUNCATE `world`.`user`;

select * from user;


###查询表信息
desc article;
show full fields from article;


use world;
select * from all_tables WHERE owner='root';

###查询所有表
select table_name 
from information_schema.tables 
where table_schema='world';

select * from article_dir;



