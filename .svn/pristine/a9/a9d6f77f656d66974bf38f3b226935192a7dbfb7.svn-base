-- Create table
create table SYS_BEHAVIOR_LOG__
(
  BEHAVIOR_ID  NUMBER(8) not null,
  SESSION_ID   VARCHAR2(32) not null,
  LOGGED_DATE  TIMESTAMP(3) not null,
  ACTION       VARCHAR2(128),
  DATA_CHANGED NUMBER(1) not null
)
PARTITION BY RANGE (LOGGED_DATE)
  INTERVAL (NUMTOYMINTERVAL(1, 'YEAR')) 
  (PARTITION P1 VALUES LESS THAN (TO_TIMESTAMP('2017-12-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.ff3'))
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
-- Create/Recreate primary, unique and foreign key constraints 
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
