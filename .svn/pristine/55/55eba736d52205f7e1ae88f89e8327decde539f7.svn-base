---------------------------------------------
-- Export file for user FRK                --
-- Created by jiangp on 2016/6/16, 9:20:19 --
---------------------------------------------

spool table.log

prompt
prompt Creating table SYS_BEHAVIOR_LOG
prompt ===============================
prompt
create table SYS_BEHAVIOR_LOG
(
  BEHAVIOR_ID  NUMBER(8) not null,
  SESSION_ID   VARCHAR2(32) not null,
  LOGGED_DATE  TIMESTAMP(3) not null,
  ACTION       VARCHAR2(128),
  DATA_CHANGED NUMBER(1) not null
)
partition by range (LOGGED_DATE)
(
  partition P1 values less than (TIMESTAMP' 2017-12-31 23:59:59.999000000')
    tablespace FRK_DATA
    pctfree 10
    initrans 1
    maxtrans 255
    storage
    (
      initial 64K
      next 1M
      minextents 1
      maxextents unlimited
    )
);
alter table SYS_BEHAVIOR_LOG
  add constraint PK_SYS_BEHAVIOR_LOG primary key (BEHAVIOR_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_DATA_LOG
prompt ===========================
prompt
create table SYS_DATA_LOG
(
  BEHAVIOR_ID NUMBER(8) not null,
  LOGGED_DATE TIMESTAMP(3) not null,
  TABLE_NAME  VARCHAR2(32) not null,
  COLUMN_NAME VARCHAR2(32) not null,
  KEY_VALUE   NUMBER(8) not null,
  OLD_VALUE   VARCHAR2(512),
  NEW_VALUE   VARCHAR2(512)
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_DIC
prompt ======================
prompt
create table SYS_DIC
(
  DIC_ID            NUMBER(8) not null,
  DIC_NAME          VARCHAR2(64) not null,
  DIC_KEY           VARCHAR2(32) not null,
  DIC_VALUE         VARCHAR2(128) not null,
  DIC_TYPE          VARCHAR2(32) not null,
  DIC_SYMBOL        VARCHAR2(128),
  CREATED_BY        NUMBER(8) not null,
  CREATED_DATE      TIMESTAMP(3) not null,
  LAST_UPDATED_BY   NUMBER(8) not null,
  LAST_UPDATED_DATE TIMESTAMP(3) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_DIC
  add constraint PK_SYS_DIC primary key (DIC_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_FUN
prompt ======================
prompt
create table SYS_FUN
(
  FUN_ID            NUMBER(8) not null,
  FUN_NAME          VARCHAR2(64) not null,
  PARENT_ID         NUMBER(8) not null,
  SORT_NUM          NUMBER(3) not null,
  LEVEL_NUM         NUMBER(1) not null,
  DELETED           NUMBER(1) not null,
  CREATED_BY        NUMBER(8),
  CREATED_DATE      TIMESTAMP(3),
  LAST_UPDATED_BY   NUMBER(8),
  LAST_UPDATED_DATE TIMESTAMP(3)
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_FUN
  add constraint PK_SYS_FUN primary key (FUN_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_FUN_URL
prompt ==========================
prompt
create table SYS_FUN_URL
(
  FUN_ID NUMBER(8) not null,
  URL_ID NUMBER(8) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_LOGIN_LOG
prompt ============================
prompt
create table SYS_LOGIN_LOG
(
  SESSION_ID     VARCHAR2(32) not null,
  USER_ID        NUMBER(8) not null,
  USERNAME       VARCHAR2(32) not null,
  REAL_NAME      VARCHAR2(32) not null,
  IP             VARCHAR2(16) not null,
  ORG_ID         NUMBER(8) not null,
  ORG_NAME       VARCHAR2(64) not null,
  INHERITED_NAME VARCHAR2(512) not null,
  LOGIN_DATE     TIMESTAMP(3) not null,
  LOGOUT_DATE    TIMESTAMP(3),
  OS             VARCHAR2(32),
  BROWSER        VARCHAR2(32),
  USER_AGENT     VARCHAR2(256)
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_LOGIN_LOG
  add constraint SYS_LOGIN_LOG primary key (SESSION_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_MENU
prompt =======================
prompt
create table SYS_MENU
(
  MENU_ID           NUMBER(8) not null,
  MENU_NAME         VARCHAR2(64) not null,
  MENU_URL          VARCHAR2(64),
  ICON              VARCHAR2(16),
  PARENT_ID         NUMBER(8) not null,
  FUN_ID            NUMBER(8) not null,
  SORT_NUM          NUMBER(3) not null,
  LEVEL_NUM         NUMBER(1) not null,
  DELETED           NUMBER(1) not null,
  CREATED_BY        NUMBER(8),
  CREATED_DATE      TIMESTAMP(3),
  LAST_UPDATED_BY   NUMBER(8),
  LAST_UPDATED_DATE TIMESTAMP(3)
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
alter table SYS_MENU
  add constraint PK_SYS_MENU primary key (MENU_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ORG
prompt ======================
prompt
create table SYS_ORG
(
  ORG_ID            NUMBER(8) not null,
  ORG_CODE          VARCHAR2(16) not null,
  ORG_NAME          VARCHAR2(64) not null,
  PARENT_ID         NUMBER(8) not null,
  INHERITED_ID      VARCHAR2(128) not null,
  INHERITED_NAME    VARCHAR2(512) not null,
  SORT_NUM          NUMBER(4) not null,
  LEVEL_NUM         NUMBER(2) not null,
  TEL               VARCHAR2(16),
  ADDRESS           VARCHAR2(128),
  REMARK            VARCHAR2(128),
  DELETED           NUMBER(1) not null,
  CREATED_BY        NUMBER(8) not null,
  CREATED_DATE      TIMESTAMP(3) not null,
  LAST_UPDATED_BY   NUMBER(8) not null,
  LAST_UPDATED_DATE TIMESTAMP(3) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_ORG
  add constraint PK_SYS_ORG primary key (ORG_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table SYS_ROLE
(
  ROLE_ID           NUMBER(8) not null,
  ROLE_NAME         VARCHAR2(64) not null,
  ROLE_TYPE         NUMBER(1) not null,
  ORG_ID            NUMBER(8),
  REMARK            VARCHAR2(128),
  DELETED           NUMBER(1) not null,
  CREATED_BY        NUMBER(8) not null,
  CREATED_DATE      TIMESTAMP(3) not null,
  LAST_UPDATED_BY   NUMBER(8) not null,
  LAST_UPDATED_DATE TIMESTAMP(3) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_ROLE
  add constraint PK_SYS_ROLE primary key (ROLE_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_ROLE
  add constraint UK_SYS_ROLE unique (ROLE_NAME, ORG_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE_FUN
prompt ===========================
prompt
create table SYS_ROLE_FUN
(
  ROLE_ID NUMBER(8) not null,
  FUN_ID  NUMBER(8) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE_USER
prompt ============================
prompt
create table SYS_ROLE_USER
(
  ROLE_ID NUMBER(8) not null,
  USER_ID NUMBER(8) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_URL
prompt ======================
prompt
create table SYS_URL
(
  URL_ID              NUMBER(8) not null,
  URL_NAME            VARCHAR2(64),
  URL_PATTERN         VARCHAR2(64) not null,
  HTTP_METHOD         VARCHAR2(8) not null,
  ACTION_CODE         VARCHAR2(32),
  ARGS_CODE           VARCHAR2(64),
  LOGGED_DATA_CHANGED NUMBER(1) not null,
  CREATED_BY          NUMBER(8),
  CREATED_DATE        TIMESTAMP(3),
  LAST_UPDATED_BY     NUMBER(8),
  LAST_UPDATED_DATE   TIMESTAMP(3)
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_URL
  add constraint PK_SYS_URL primary key (URL_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table SYS_USER
(
  USER_ID           NUMBER(8) not null,
  USERNAME          VARCHAR2(32) not null,
  REAL_NAME         VARCHAR2(64) not null,
  PWD               CHAR(32) not null,
  ORG_ID            NUMBER(8) not null,
  LOCKED            NUMBER(1) not null,
  ERROR_TIME        NUMBER(2),
  AGE               NUMBER(3),
  BIRTHDAY          TIMESTAMP(3),
  PHONE             VARCHAR2(16),
  MOBILE            VARCHAR2(16),
  EMAIL             VARCHAR2(64),
  ADDRESS           VARCHAR2(128),
  REMARK            VARCHAR2(128),
  USER_PIC_DATA     BLOB,
  USER_PIC_SUFFIX   VARCHAR2(16),
  ABOUT             CLOB,
  LAST_LOGIN_DATE   TIMESTAMP(3),
  LAST_LOGIN_IP     VARCHAR2(16),
  DELETED           NUMBER(1) not null,
  CREATED_BY        NUMBER(8) not null,
  CREATED_DATE      TIMESTAMP(3) not null,
  LAST_UPDATED_BY   NUMBER(8) not null,
  LAST_UPDATED_DATE TIMESTAMP(3) not null
)
tablespace FRK_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_USER
  add constraint PK_SYS_USER primary key (USER_ID)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_USER
  add constraint UK_SYS_USER unique (USERNAME)
  using index 
  tablespace FRK_INDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
