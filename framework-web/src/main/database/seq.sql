---------------------------------------------
-- Export file for user FRK                --
-- Created by jiangp on 2016/6/16, 9:20:46 --
---------------------------------------------

spool seq.log

prompt
prompt Creating sequence SEQ_SYS_BEHAVIOR_LOG
prompt ======================================
prompt
create sequence SEQ_SYS_BEHAVIOR_LOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_DIC
prompt =============================
prompt
create sequence SEQ_SYS_DIC
minvalue 1
maxvalue 99999999
start with 1000
increment by 1
cache 2;

prompt
prompt Creating sequence SEQ_SYS_MENU
prompt ==============================
prompt
create sequence SEQ_SYS_MENU
minvalue 1
maxvalue 99999999
start with 600
increment by 1
cache 2;

prompt
prompt Creating sequence SEQ_SYS_ORG
prompt =============================
prompt
create sequence SEQ_SYS_ORG
minvalue 1
maxvalue 99999999
start with 10
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_ROLE
prompt ==============================
prompt
create sequence SEQ_SYS_ROLE
minvalue 1
maxvalue 99999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_URL
prompt =============================
prompt
create sequence SEQ_SYS_URL
minvalue 1
maxvalue 99999999
start with 600
increment by 1
cache 2;

prompt
prompt Creating sequence SEQ_SYS_USER
prompt ==============================
prompt
create sequence SEQ_SYS_USER
minvalue 1
maxvalue 99999999
start with 1720
increment by 1
cache 20;


spool off
