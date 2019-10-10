create tablespace FRK_DATA  
logging  
datafile 'C:\oracle\oradata\orcl\avs\FRK_DATA.DBF' 
size 10m  
autoextend on   
next 10m maxsize 100m  
extent management local;

create tablespace FRK_INDEX  
logging  
datafile 'C:\oracle\oradata\orcl\avs\FRK_INDEX.DBF' 
size 10m  
autoextend on   
next 10m maxsize 100m  
extent management local;

create temporary tablespace FRK_TEMP
tempfile 'C:\oracle\oradata\orcl\avs\FRK_TEMP.DBF' 
size 10m  
autoextend on   
next 10m maxsize 100m  
extent management local;

CREATE USER frk IDENTIFIED BY frk DEFAULT TABLESPACE FRK_DATA TEMPORARY TABLESPACE FRK_TEMP;

grant connect,resource,dba to frk;