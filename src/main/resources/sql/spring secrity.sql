-----------------ROLE---------------------------
create table u_md_rs.role_test_temp
(
  id        NUMBER(3),
  name            VARCHAR2(24) ,
  name_remark          VARCHAR2(24),
  created_time   DATE,
  modified_time DATE,
  status       NUMBER(2),
  is_delete      NUMBER(2)
)

insert into u_md_rs.role_test_temp values (1,'super_admin','超级管理员',sysdate,sysdate,1,0);
insert into u_md_rs.role_test_temp values (2,'general_user','普通用户',sysdate,sysdate,1,0);

---------------MENU---------------------------

create table MENU_TEST_TEMP
(
  ID            NUMBER(3),
  NAME          VARCHAR2(24),
  URL           VARCHAR2(255),
  TYPE          NUMBER(11),
  PARENT_ID     NUMBER(3),
  CREATED_TIME  DATE,
  MODIFIED_TIME DATE,
  STATUS        NUMBER(2),
  IS_DELETE     NUMBER(2)
)

insert into u_md_rs.menu_test_temp values (1,'Spring Security','/index',1,0,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (3,'会员列表','/user/list',2,1,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (4,'角色列表','/role/list',2,1,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (5,'菜单列表','/menu/list',2,1,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (6,'添加用户','/user/add',3,3,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (7,'修改用户','/user/update',3,3,sysdate,sysdate,1,0);
insert into u_md_rs.menu_test_temp values (10,'删除用户','/user/del',3,3,sysdate,sysdate,1,0);


-----------------ROLE_MENU---------------------------
create table ROLE_MENU_TEST_TEMP
(
  id            NUMBER(3),
  role_id          NUMBER(3),
  menu_id           NUMBER(3)
)


INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (1, 1, 1);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (2, 1, 10);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (3, 1, 3);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (4, 1, 4);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (5, 1, 5);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (6, 1, 6);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (7, 1, 7);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (8, 2, 1);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (9, 2, 3);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (10, 2, 4);
INSERT INTO u_md_rs.ROLE_MENU_TEST_TEMP VALUES (11, 2, 5);

-----------------USER---------------------------
create table USER_TEST_TEMP
(
  id            NUMBER(3),
  nickname      VARCHAR2(24),
  username      VARCHAR2(24),
  password      VARCHAR2(32),
  admin          NUMBER(2),
  CREATED_TIME  DATE,
  MODIFIED_TIME DATE,
  STATUS        NUMBER(2),
  IS_DELETE     NUMBER(2)
)


insert into u_md_rs.USER_TEST_TEMP VALUES (1, '许许', 'admin', 'admin', 2, sysdate, sysdate, 1, 0);
insert into u_md_rs.USER_TEST_TEMP VALUES (2, '多多', 'user', 'user', 1, sysdate, sysdate, 1, 0);

-------------USER_ROLE------------------
create table u_md_rs.USER_ROLE
(
  id            NUMBER(3),
  user_id           NUMBER(3),
  role_id          NUMBER(3),
   CREATED_TIME  DATE,
  MODIFIED_TIME DATE,
    STATUS        NUMBER(2),
  IS_DELETE     NUMBER(2)
)

INSERT INTO u_md_rs.USER_ROLE VALUES (1, 1, 1, sysdate, sysdate, 1, 0);
INSERT INTO u_md_rs.USER_ROLE VALUES (2, 2, 2, sysdate, sysdate, 1, 0);
