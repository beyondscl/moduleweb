USE world;
SHOW GLOBAL VARIABLES LIKE 'wait_timeout';
SELECT *
FROM user;
UPDATE user
SET password = '123123'
WHERE id = '0';
-- delete from user;

TRUNCATE `world`.`user`;

SELECT *
FROM user;

###查询表信息
DESC article;
SHOW FULL FIELDS FROM article;


USE world;
SELECT *
FROM all_tables
WHERE owner = 'root';

###查询所有表
SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'world';

SELECT *
FROM article_dir;



