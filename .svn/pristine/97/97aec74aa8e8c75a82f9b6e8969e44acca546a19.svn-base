prompt PL/SQL Developer import file
set feedback off
set define off
prompt Loading SYS_DIC...
insert into SYS_DIC (DIC_ID, DIC_NAME, DIC_KEY, DIC_VALUE, DIC_TYPE, DIC_SYMBOL, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '公司名', 'AOTO', '奥拓电子', 'COM', null, -1, to_timestamp('24-02-2016 14:44:40.891', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('12-05-2016 15:16:11.132', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_DIC (DIC_ID, DIC_NAME, DIC_KEY, DIC_VALUE, DIC_TYPE, DIC_SYMBOL, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (2, '公司名', 'SUNING', '苏宁', 'COM', null, -1, to_timestamp('24-02-2016 14:44:40.891', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('12-05-2016 15:16:11.132', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt Loading SYS_FUN...
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '功能', 0, 0, 1, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (2, '系统', 1, 1, 2, 0, null, null, null, null);

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (301, '用户管理', 2, 1, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30101, '用户查询', 301, 1, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30102, '用户新增', 301, 2, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30103, '用户编辑', 301, 3, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30104, '用户删除', 301, 4, 4, 0, null, null, -1, to_timestamp('16-03-2016 08:50:22.964', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30105, '重置密码', 301, 5, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30106, '用户详情', 301, 6, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30107, '用户锁定', 301, 7, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30108, '用户解锁', 301, 8, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:32.207', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (302, '功能管理', 2, 2, 3, 0, -1, to_timestamp('24-02-2016 15:51:37.941', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30201, '功能新增', 302, 1, 4, 0, -1, to_timestamp('24-02-2016 15:51:54.952', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:51:54.952', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30202, '功能编辑', 302, 2, 4, 0, -1, to_timestamp('24-02-2016 15:52:02.321', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:52:02.321', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30203, '功能删除', 302, 3, 4, 0, -1, to_timestamp('24-02-2016 15:52:12.439', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:52:12.439', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30204, '功能详情', 302, 4, 4, 0, -1, to_timestamp('24-02-2016 15:52:17.358', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:52:17.358', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30205, '设置URL', 302, 5, 4, 0, -1, to_timestamp('24-02-2016 15:52:26.088', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:52:26.088', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30206, '功能查询', 302, 6, 4, 0, -1, to_timestamp('02-03-2016 08:58:33.339', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('02-03-2016 08:58:33.339', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (303, '菜单管理', 2, 3, 3, 0, -1, to_timestamp('24-02-2016 16:05:10.152', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30301, '菜单新增', 303, 1, 4, 0, -1, to_timestamp('24-02-2016 16:05:21.426', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:05:21.426', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30302, '菜单编辑', 303, 2, 4, 0, -1, to_timestamp('24-02-2016 16:05:25.609', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:05:25.609', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30303, '菜单删除', 303, 3, 4, 0, -1, to_timestamp('24-02-2016 16:05:30.721', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:05:30.721', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30304, '菜单详情', 303, 4, 4, 0, -1, to_timestamp('24-02-2016 16:05:37.489', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:05:37.489', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30305, '菜单查询', 303, 5, 4, 0, -1, to_timestamp('24-02-2016 16:06:13.011', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:06:13.011', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (304, '角色管理', 2, 4, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30401, '角色查询', 304, 1, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30402, '角色新增', 304, 2, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30403, '角色编辑', 304, 3, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30404, '角色删除', 304, 4, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30405, '角色授权', 304, 5, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30406, '设置成员', 304, 6, 4, 0, null, null, null, null);

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (305, '通用角色管理', 2, 5, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30501, '通用角色查询', 305, 1, 4, 0, null, null, null, null);
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30502, '设置成员', 305, 2, 4, 0, null, null, null, null);

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (306, '机构管理', 2, 6, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30601, '机构查询', 306, 1, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30602, '机构新增', 306, 2, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30603, '机构编辑', 306, 3, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30604, '机构删除', 306, 4, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30605, '机构详情', 306, 5, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30606, '机构导出', 306, 6, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30607, '机构导入', 306, 7, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:55:43.537', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (307, 'URL管理', 2, 7, 3, 0, -1, to_timestamp('24-02-2016 14:01:11.753', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30701, 'URL查询', 307, 1, 4, 0, -1, to_timestamp('24-02-2016 14:04:09.055', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:04:09.055', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30702, 'URL新增', 307, 2, 4, 0, -1, to_timestamp('24-02-2016 14:04:17.194', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:04:17.194', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30703, 'URL编辑', 307, 3, 4, 0, -1, to_timestamp('24-02-2016 14:04:25.241', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:04:25.241', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30704, 'URL删除', 307, 4, 4, 0, -1, to_timestamp('24-02-2016 14:04:31.443', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:04:31.443', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (30705, 'URL详情', 307, 5, 4, 0, -1, to_timestamp('24-02-2016 14:05:01.413', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:05:01.413', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (401, '字典管理', 2, 8, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40101, '字典新增', 401, 1, 4, 0, null, null, -1, to_timestamp('24-02-2016 10:30:40.406', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40102, '字典编辑', 401, 2, 4, 0, null, null, -1, to_timestamp('24-02-2016 10:30:40.406', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40103, '字典删除', 401, 3, 4, 0, null, null, -1, to_timestamp('24-02-2016 10:30:40.406', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40104, '字典详情', 401, 4, 4, 0, null, null, -1, to_timestamp('24-02-2016 10:30:40.406', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40105, '字典查询', 401, 5, 4, 0, null, null, -1, to_timestamp('24-02-2016 10:30:40.406', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (501, '日志管理', 2, 9, 3, 0, null, null, -1, to_timestamp('02-03-2016 16:03:19.912', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (50101, '在线用户', 501, 1, 4, 0, null, null, -1, to_timestamp('23-02-2016 16:24:32.690', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (50201, '登录日志', 501, 2, 4, 0, null, null, -1, to_timestamp('23-02-2016 16:24:32.690', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_FUN (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (50301, '用户行为', 501, 3, 4, 0, null, null, -1, to_timestamp('23-02-2016 16:24:32.690', 'dd-mm-yyyy hh24:mi:ss.ff'));

commit;
prompt Loading SYS_FUN_URL...
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30101, 1);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30101, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30102, 2);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30102, 3);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30102, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30103, 4);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30103, 5);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30103, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30104, 6);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30106, 7);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30105, 8);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30107, 9);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30108, 10);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30206, 31);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30201, 32);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30201, 33);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30202, 34);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30202, 35);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30203, 36);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30204, 37);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30205, 38);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30205, 39);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30205, 40);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30205, 41);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30305, 61);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30301, 62);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30301, 63);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30302, 64);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30302, 65);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30302, 66);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30303, 67);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30304, 68);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30401, 91);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30401, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30402, 92);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30402, 93);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30402, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30403, 94);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30403, 95);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30403, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30404, 96);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30405, 97);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30405, 98);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30405, 99);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30406, 100);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30406, 101);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30406, 102);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30406, 103);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30406, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30501, 121);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30502, 102);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30502, 103);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30502, 122);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30502, 123);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30601, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30602, 142);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30602, 143);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30603, 144);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30603, 145);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30603, 146);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30604, 147);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30605, 148);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30606, 149);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30607, 150);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30607, 151);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30701, 171);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30702, 172);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30702, 173);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30703, 174);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30703, 175);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30704, 176);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (30705, 177);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40105, 201);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40101, 202);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40101, 203);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40102, 204);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40102, 205);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40102, 208);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40103, 206);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40104, 207);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (40104, 208);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50101, 221);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50201, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50201, 231);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50301, 141);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50301, 241);
insert into SYS_FUN_URL (FUN_ID, URL_ID)
values (50301, 242);
commit;
prompt Loading SYS_MENU...
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '菜单', null, null, 0, -1, 1, 1, 0, null, null, null, null);
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (2, '系统', null, 'icon-laptop', 1, 0, 2, 2, 0, null, null, -1, to_timestamp('02-03-2016 15:54:52.612', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (3, '权限管理', null, 'icon-key', 2, 1, 2, 3, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (301, '用户管理', '/system/users/list', 'icon-user', 3, 30101, 1, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (302, '功能管理', '/system/funs/list', 'icon-cog', 3, 30206, 2, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (303, '菜单管理', '/system/menus/list', 'icon-list', 3, 30305, 3, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (304, '角色管理', '/system/roles/list', 'icon-tag', 3, 30401, 4, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (305, '通用角色管理', '/system/commroles/list', 'icon-tags', 3, 30501, 4, 4, 0, null, null, -1, to_timestamp('11-05-2017 11:26:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (306, '机构管理', '/system/orgs/list', 'icon-sitemap', 3, 30601, 5, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (307, 'URL管理', '/system/urls/list', 'icon-paper-clip', 3, 30701, 6, 4, 0, null, null, -1, to_timestamp('14-03-2016 16:07:44.940', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (4, '基础配置', null, 'icon-cogs', 2, 0, 3, 3, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (401, '字典管理', '/system/dics/list', 'icon-book', 4, 40105, 1, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (5, '日志管理', null, 'icon-file-alt', 2, 0, 4, 3, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (501, '在线用户', '/system/users/online', 'icon-user-md', 5, 50101, 1, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (502, '登录日志', '/system/logs/login', 'icon-desktop', 5, 50201, 2, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_MENU (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (503, '用户行为', '/system/logs/behavior', 'icon-hand-right', 5, 50301, 3, 4, 0, null, null, -1, to_timestamp('02-03-2016 15:29:03.697', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt Loading SYS_ORG...
insert into SYS_ORG (ORG_ID, ORG_CODE, ORG_NAME, PARENT_ID, INHERITED_ID, INHERITED_NAME, SORT_NUM, LEVEL_NUM, TEL, ADDRESS, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '1', '总部', 0, '1', '总部', 1, 1, null, null, null, 0, -1, to_timestamp('26-09-2013 00:00:00.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('02-03-2016 09:52:39.725', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt Loading SYS_ROLE...
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '日志管理员', 1, 1, null, 0, -1, to_timestamp('03-06-2014 15:20:23.334', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('11-06-2014 17:39:52.806', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (2, '角色管理员', 1, 1, null, 0, -1, to_timestamp('06-06-2014 15:08:39.197', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('20-10-2014 09:13:30.895', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (3, '系统管理员', 1, 1, null, 0, -1, to_timestamp('12-02-2014 16:33:41.608', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('12-02-2014 16:33:41.608', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (4, '用户管理员', 1, 1, null, 0, -1, to_timestamp('09-06-2014 15:36:12.091', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('11-06-2014 17:30:15.891', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (5, '机构管理员', 1, 1, null, 0, -1, to_timestamp('09-06-2014 15:36:55.941', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('11-05-2016 13:46:29.864', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_TYPE, ORG_ID, REMARK, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (6, '通用角色管理员', 1, 1, null, 0, -1, to_timestamp('19-05-2017 15:36:55.941', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('19-05-2017 15:36:55.941', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt Loading SYS_ROLE_FUN...
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (1, 501);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (1, 50101);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (1, 50201);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (1, 50301);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 304);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30401);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30402);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30403);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30404);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30405);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (2, 30406);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 301);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30101);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30102);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30103);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30104);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30105);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30106);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30107);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30108);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 304);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30401);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30402);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30403);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30404);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30405);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30406);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 306);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30601);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30602);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30603);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30604);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30605);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30606);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 30607);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 401);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 40101);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 40102);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 40103);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 40104);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 40105);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 501);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 50101);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 50201);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (3, 50301);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 301);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30101);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30102);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30103);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30104);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30105);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30106);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30107);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (4, 30108);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 306);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30601);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30602);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30603);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30604);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30605);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30606);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (5, 30607);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (6, 305);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (6, 30501);
insert into SYS_ROLE_FUN (ROLE_ID, FUN_ID)
values (6, 30502);
commit;
prompt Loading SYS_URL...
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (1, '用户查询', '^/system/users/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (2, '用户新增', '^/system/users$', 'POST', 'log.behavior.dialog.submit', 'user.new', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (3, '用户新增表单', '^/system/users/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (4, '用户编辑', '^/system/users/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'user.edit', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (5, '用户编辑表单', '^/system/users/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (6, '用户删除', '^/system/users.*', 'DELETE', 'log.behavior.dialog.ok', 'user.remove', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (7, '用户详情表单', '^/system/users/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (8, '密码重置', '^/system/users/password.*', 'PUT', 'log.behavior.dialog.ok', 'user.reset', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (9, '用户锁定', '^/system/users/locked.*', 'PUT', 'log.behavior.dialog.ok', 'user.lock', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (10, '用户解锁', '^/system/users/unlocked.*', 'PUT', 'log.behavior.dialog.ok', 'user.unlock', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (31, '功能查询', '^/system/funs/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 15:05:16.440', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:16.440', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (32, '功能新增', '^/system/funs$', 'POST', 'log.behavior.dialog.submit', 'fun.new', 1, -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (33, '功能新增表单', '^/system/funs/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (34, '功能编辑', '^/system/funs/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'fun.edit', 1, -1, to_timestamp('24-02-2016 15:06:41.291', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:06:41.291', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (35, '功能编辑表单', '^/system/funs/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (36, '功能删除', '^/system/funs/\d+.*', 'DELETE', 'log.behavior.dialog.ok', 'fun.remove', 1, -1, to_timestamp('24-02-2016 15:07:07.762', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:07:38.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (37, '功能详情表单', '^/system/funs/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (38, '新增功能对应的URL', '^/system/funs/\d+/urls$', 'POST', 'log.behavior.dialog.submit', 'fun.edit', 1, -1, to_timestamp('24-02-2016 15:06:41.291', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:06:41.291', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (39, '查询功能对应的URL', '^/system/funs/\d+/urls.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (40, '查询排除的URL', '^/system/urls/excepted.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (41, 'URL选择表单', '^/system/urls/select.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (61, '菜单查询', '^/system/menus/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 15:05:16.440', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:16.440', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (62, '菜单新增', '^/system/menus$', 'POST', 'log.behavior.dialog.submit', 'menu.new', 1, -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:05:45.134', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (63, '菜单新增表单', '^/system/menus/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (64, '菜单编辑', '^/system/menus/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'menu.edit', 1, -1, to_timestamp('24-02-2016 15:06:41.291', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 15:28:45.067', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (65, '菜单编辑表单', '^/system/menus/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (66, '菜单移动', '^/system/menus/\d+/parent/\d+/\d+.*', 'PUT', 'log.behavior.menu.act1', null, 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (67, '菜单删除', '^/system/menus/\d+.*', 'DELETE', 'log.behavior.dialog.o', 'menu.remove', 1, -1, to_timestamp('24-02-2016 15:07:07.762', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 16:42:28.458', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (68, '菜单详情表单', '^/system/menus/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (91, '角色查询', '^/system/roles/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (92, '角色新增', '^/system/roles$', 'POST', 'log.behavior.dialog.submit', 'role.new', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (93, '角色新增表单', '^/system/roles/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (94, '角色编辑', '^/system/roles/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'role.edit', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (95, '角色编辑表单', '^/system/roles/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (96, '角色删除', '^/system/roles.*', 'DELETE', 'log.behavior.dialog.ok', 'role.remove', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (97, '角色授权展示功能列表', '^/system/roles/\d+/funs.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (98, '角色授权', '^/system/roles/\d+/funs$', 'POST', 'log.behavior.dialog.submit', 'role.authorization', 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (99, '功能平铺选择表单', '^/system/funs/select.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (100, '获取角色成员', '^/system/roles/\d+/users.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (101, '设置角色成员', '^/system/roles/\d+/users.*', 'POST', 'log.behavior.dialog.submit', 'role.setMembership', 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (102, '查询排除ID的用户', '^/system/users/excepted.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (103, '用户选择表单', '^/system/users/select.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (121, '通用角色查询', '^/system/commroles/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (122, '获取通用角色成员', '^/system/commroles/\d+/users.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (123, '设置通用角色成员', '^/system/commroles/\d+/users.*', 'POST', 'log.behavior.dialog.submit', 'commrole.setMembership', 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (141, '机构查询', '^/system/orgs/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (142, '机构新增', '^/system/orgs$', 'POST', 'log.behavior.dialog.submit', 'org.new', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (143, '机构新增表单', '^/system/orgs/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('13-05-2016 15:11:39.085', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (144, '机构编辑', '^/system/orgs/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'org.edit', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (145, '机构编辑表单', '^/system/orgs/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (146, '机构移动', '^/system/orgs/\d+/parent/\d+.*', 'PUT', 'log.behavior.org.action1', null, 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (147, '机构删除', '^/system/orgs/\d+.*', 'DELETE', 'log.behavior.dialog.ok', 'org.remove', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (148, '机构详情表单', '^/system/orgs/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (149, '机构导出', '^/system/orgs/export$', 'GET', 'log.behavior.org.export', null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (150, '机构导入', '^/system/orgs/import$', 'POST', 'log.behavior.org.import', null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (151, '机构导入表单', '^/system/orgs/import.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (171, 'URL查询', '^/system/urls/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:34:51.540', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:34:51.540', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (172, 'URL新增', '^/system/urls$', 'POST', 'log.behavior.dialog.submit', 'url.new', 1, -1, to_timestamp('24-02-2016 13:36:14.345', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:36:14.345', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (173, 'URL新增表单', '^/system/urls/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (174, 'URL编辑', '^/system/urls/\d+.*', 'PUT', 'log.behavior.dialog.submit', 'url.edit', 1, -1, to_timestamp('24-02-2016 13:36:55.509', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:15:48.390', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (175, 'URL编辑表单', '^/system/urls/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (176, 'URL删除', '^/system/urls.*', 'DELETE', 'log.behavior.dialog.ok', 'url.remove', 1, -1, to_timestamp('24-02-2016 13:37:29.857', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 14:13:51.080', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (177, 'URL详情表单', '^/system/urls/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (201, '字典查询', '^/system/dics/list.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (202, '字典新增', '^/system/dics$', 'POST', 'log.behavior.dialog.submit', 'dic.new', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (203, '字典新增表单', '^/system/dics/new.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (204, '字典编辑', '^/system/dics.*', 'PUT', 'log.behavior.dialog.submit', 'dic.edit', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (205, '字典编辑表单', '^/system/dics/edit.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (206, '字典删除', '^/system/dics.*', 'DELETE', 'log.behavior.dialog.ok', 'dic.remove', 1, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (207, '字典详情表单', '^/system/dics/show.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (208, '字典键值对查询', '^/system/dics/.+', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:24:19.184', 'dd-mm-yyyy hh24:mi:ss.ff'));

insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (221, '查询在线用户', '^/system/users/online.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (231, '登录日志查询', '^/system/logs/login.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (241, '行为日志查询', '^/system/logs/behavior.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into SYS_URL (URL_ID, URL_NAME, URL_PATTERN, HTTP_METHOD, ACTION_CODE, ARGS_CODE, LOGGED_DATA_CHANGED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (242, '数据变更查询', '^/system/logs/data.*', 'GET', null, null, 0, -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('24-02-2016 13:23:01.000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt Loading SYS_USER...
insert into SYS_USER (USER_ID, USERNAME, REAL_NAME, PWD, ORG_ID, LOCKED, ERROR_TIME, PHONE, MOBILE, EMAIL, ADDRESS, REMARK, LAST_LOGIN_DATE, LAST_LOGIN_IP, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)
values (-1, 'admin', '管理员', '55fb1e4e8fc23ba1f6a3e549803592cd', 1, 0, 0, null, null, null, null, null, to_timestamp('16-03-2016 11:40:31.291', 'dd-mm-yyyy hh24:mi:ss.ff'), '172.16.210.95', 0, -1, to_timestamp('14-04-2014 15:30:11.341', 'dd-mm-yyyy hh24:mi:ss.ff'), -1, to_timestamp('23-02-2016 11:05:37.302', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 10 records loaded
set feedback on
set define on
prompt Done.