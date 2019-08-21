/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/7/25 15:50:16                           */
/*==============================================================*/


drop table DSE_DTH_PUMP_STATION cascade constraints;

drop table DSE_DTH_PUMP_STATION_REPORT cascade constraints;

drop index IDX_DSE_DTH_RELATIONSHIP;

drop table DSE_DTH_RELATIONSHIP cascade constraints;

drop table DSE_DTH_RESERVOIR cascade constraints;

drop table DSE_DTH_RESERVOIR_REPORT cascade constraints;

drop index IDX_DSE_DTH_SPACE;

drop table DSE_DTH_SPACE cascade constraints;

drop table DSE_DTH_SW_RELATION cascade constraints;

drop table DSE_DTH_SW_SOURCE cascade constraints;

drop table DSE_DTH_WATER_ENT cascade constraints;

drop table DSE_DTH_WATER_PLANT cascade constraints;

drop table DSE_DTH_WATER_PLANT_ENT cascade constraints;

drop index IDX_DSE_DTH_WDP_PART;

drop table DSE_DTH_WDP_PART cascade constraints;

drop table DSE_DTH_WSPIPELINE cascade constraints;

/*==============================================================*/
/* Table: DSE_DTH_PUMP_STATION                                  */
/*==============================================================*/
create table DSE_DTH_PUMP_STATION 
(
   ID                   VARCHAR2(32)         not null,
   PP_CODE              VARCHAR2(32),
   PP_NAME              VARCHAR2(255)        not null,
   PP_PROJECT_NAME      VARCHAR2(255)        not null,
   DRAINAGE_CAPACITY    NUMBER(18,6)         not null,
   SORT_ON              INTEGER,
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   STATUS               CHAR(1),
   MAN_ORG_CODE         VARCHAR2(32),
   constraint PK_DSE_DTH_PUMP_STATION primary key (ID)
);

comment on table DSE_DTH_PUMP_STATION is
'泵站闸门表';

comment on column DSE_DTH_PUMP_STATION.ID is
'编号';

comment on column DSE_DTH_PUMP_STATION.PP_CODE is
'泵站/闸门编码';

comment on column DSE_DTH_PUMP_STATION.PP_NAME is
'泵站/闸门名称';

comment on column DSE_DTH_PUMP_STATION.PP_PROJECT_NAME is
'所属工程';

comment on column DSE_DTH_PUMP_STATION.DRAINAGE_CAPACITY is
'最高设计排水能力';

comment on column DSE_DTH_PUMP_STATION.SORT_ON is
'排序';

comment on column DSE_DTH_PUMP_STATION.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_PUMP_STATION.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_PUMP_STATION.STATUS is
'状态(0：未删除，1：删除)';

comment on column DSE_DTH_PUMP_STATION.MAN_ORG_CODE is
'管理单位';

/*==============================================================*/
/* Table: DSE_DTH_PUMP_STATION_REPORT                           */
/*==============================================================*/
create table DSE_DTH_PUMP_STATION_REPORT 
(
   ID                   VARCHAR2(32)         not null,
   PM_CODE              VARCHAR2(32),
   PM_NAME              VARCHAR2(64),
   DESIGN_SCALE         NUMBER(18,6),
   SINGLE_SCALE         NUMBER(18,6),
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   ORDER_INDEX          INTEGER,
   constraint PK_DSE_DTH_PUMP_STATION_REPORT primary key (ID)
);

comment on table DSE_DTH_PUMP_STATION_REPORT is
'泵闸日报表';

comment on column DSE_DTH_PUMP_STATION_REPORT.ID is
'编号';

comment on column DSE_DTH_PUMP_STATION_REPORT.PM_CODE is
'泵闸编码';

comment on column DSE_DTH_PUMP_STATION_REPORT.PM_NAME is
'泵闸名称';

comment on column DSE_DTH_PUMP_STATION_REPORT.DESIGN_SCALE is
'设计规模';

comment on column DSE_DTH_PUMP_STATION_REPORT.SINGLE_SCALE is
'单机规模';

comment on column DSE_DTH_PUMP_STATION_REPORT.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_PUMP_STATION_REPORT.CREATE_TIME is
'创建时间';

/*==============================================================*/
/* Table: DSE_DTH_RELATIONSHIP                                  */
/*==============================================================*/
create table DSE_DTH_RELATIONSHIP 
(
   ID                   VARCHAR2(32)         not null,
   COMPONENT_CODE       VARCHAR2(32)         not null,
   COMPONENT_TYPE       INTEGER              not null,
   WDP_PART_CODE        VARCHAR2(32)         not null,
   PARENT_COMPONENT_CODE VARCHAR2(32),
   LEV                  INTEGER,
   SORT_ON              INTEGER              not null,
   TS                   VARCHAR2(20)         not null,
   constraint PK_DSE_DTH_RELATIONSHIP primary key (ID)
);

comment on column DSE_DTH_RELATIONSHIP.COMPONENT_TYPE is
'0:水厂 1:水库 2:泵站 3:闸门';

/*==============================================================*/
/* Index: IDX_DSE_DTH_RELATIONSHIP                              */
/*==============================================================*/
create index IDX_DSE_DTH_RELATIONSHIP on DSE_DTH_RELATIONSHIP (
   COMPONENT_CODE ASC,
   WDP_PART_CODE ASC,
   PARENT_COMPONENT_CODE ASC,
   LEV ASC,
   SORT_ON ASC
);

/*==============================================================*/
/* Table: DSE_DTH_RESERVOIR                                     */
/*==============================================================*/
create table DSE_DTH_RESERVOIR 
(
   ID                   VARCHAR2(32)         not null,
   RSV_CODE             VARCHAR2(32),
   RSV_NAME             VARCHAR2(255)        not null,
   MAN_ORG_CODE         VARCHAR2(32),
   ADDVCD               VARCHAR2(6)          not null,
   STREET               VARCHAR2(255)        not null,
   ADDRESS              VARCHAR2(255)        not null,
   RSV_TYPE             INTEGER              not null,
   DEAD_STORAGE_CAPACITY NUMBER(18,6)         not null,
   TOTAL_STORAGE_CAPACITY NUMBER(18,6)         not null,
   RAIN_COLLECTING_AREA NUMBER(18,6)         not null,
   WATER_STORAGE_AREA   VARCHAR2(255)        not null,
   RSV_MAN_PERSON       VARCHAR2(32),
   RSV_MAN_MOBILE       VARCHAR2(16),
   RSV_MAN_PHONE        VARCHAR2(16),
   SORT_ON              INTEGER,
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   STATUS               CHAR(1),
   constraint PK_DSE_DTH_RESERVOIR primary key (ID)
);

comment on table DSE_DTH_RESERVOIR is
'供水水库表';

comment on column DSE_DTH_RESERVOIR.ID is
'编号';

comment on column DSE_DTH_RESERVOIR.RSV_CODE is
'水库编码';

comment on column DSE_DTH_RESERVOIR.RSV_NAME is
'水库名称';

comment on column DSE_DTH_RESERVOIR.MAN_ORG_CODE is
'所属单位';

comment on column DSE_DTH_RESERVOIR.ADDVCD is
'行政区划代码';

comment on column DSE_DTH_RESERVOIR.STREET is
'所属街道';

comment on column DSE_DTH_RESERVOIR.ADDRESS is
'水库地址';

comment on column DSE_DTH_RESERVOIR.RSV_TYPE is
'水库类型';

comment on column DSE_DTH_RESERVOIR.DEAD_STORAGE_CAPACITY is
'死库容';

comment on column DSE_DTH_RESERVOIR.TOTAL_STORAGE_CAPACITY is
'总库容';

comment on column DSE_DTH_RESERVOIR.RAIN_COLLECTING_AREA is
'集雨面积';

comment on column DSE_DTH_RESERVOIR.WATER_STORAGE_AREA is
'所属蓄水片区';

comment on column DSE_DTH_RESERVOIR.RSV_MAN_PERSON is
'水库责任人';

comment on column DSE_DTH_RESERVOIR.RSV_MAN_MOBILE is
'责任人联系电话';

comment on column DSE_DTH_RESERVOIR.RSV_MAN_PHONE is
'责任人手机';

comment on column DSE_DTH_RESERVOIR.SORT_ON is
'排序';

comment on column DSE_DTH_RESERVOIR.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_RESERVOIR.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_RESERVOIR.STATUS is
'状态(0：未删除，1：删除)';

/*==============================================================*/
/* Table: DSE_DTH_RESERVOIR_REPORT                              */
/*==============================================================*/
create table DSE_DTH_RESERVOIR_REPORT 
(
   ID                   VARCHAR2(32)         not null,
   RSV_CODE             VARCHAR2(32),
   RSV_NAME             VARCHAR2(64),
   RSV_NWL              NUMBER(18,6),
   RSV_FPWL             NUMBER(18,6),
   RSV_EWL              NUMBER(18,6),
   RSV_NSC              NUMBER(18,6),
   RSV_FPSC             NUMBER(18,6),
   RSV_ESC              NUMBER(18,6),
   CREATE_TIME          VARCHAR2(20),
   UPDATE_TIME          VARCHAR2(20),
   ORDER_INDEX          INTEGER,
   constraint PK_DSE_DTH_RESERVOIR_REPORT primary key (ID)
);

comment on table DSE_DTH_RESERVOIR_REPORT is
'水库日报表';

comment on column DSE_DTH_RESERVOIR_REPORT.ID is
'编号';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_CODE is
'泵闸编码';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_NAME is
'泵闸名称';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_NWL is
'设计规模';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_FPWL is
'单机规模';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_EWL is
'修改时间';

comment on column DSE_DTH_RESERVOIR_REPORT.RSV_NSC is
'创建时间';

/*==============================================================*/
/* Table: DSE_DTH_SPACE                                         */
/*==============================================================*/
create table DSE_DTH_SPACE 
(
   POINT_ID             VARCHAR2(32)         not null,
   POINT_CODE           VARCHAR2(32)         not null,
   POINT_TYPE           INTEGER,
   LONGITUDE            NUMBER(16,10)        not null,
   LATITUDE             NUMBER(16,10)        not null,
   STATUS               INTEGER              not null,
   SORT_ON              INTEGER              not null,
   TS                   VARCHAR2(20)         not null,
   constraint PK_DSE_DTH_SPACE primary key (POINT_ID)
);

comment on column DSE_DTH_SPACE.POINT_CODE is
'等于引水工程分段编号或者是部件ID';

comment on column DSE_DTH_SPACE.POINT_TYPE is
'1：分段编号
2：部件ID';

comment on column DSE_DTH_SPACE.STATUS is
'1启动0删除';

/*==============================================================*/
/* Index: IDX_DSE_DTH_SPACE                                     */
/*==============================================================*/
create index IDX_DSE_DTH_SPACE on DSE_DTH_SPACE (
   POINT_CODE ASC,
   SORT_ON ASC,
   STATUS ASC
);

/*==============================================================*/
/* Table: DSE_DTH_SW_RELATION                                   */
/*==============================================================*/
create table DSE_DTH_SW_RELATION 
(
   ID                   VARCHAR2(32)         not null,
   WATER_ENT_NAME       VARCHAR2(128)        not null,
   WS_OBJ_NAME          VARCHAR2(128)        not null,
   TYPE                 VARCHAR2(1)          not null,
   YEAR                 VARCHAR(16)          not null,
   MON1                 NUMBER(18,6),
   MON2                 NUMBER(18,6),
   MON3                 NUMBER(18,6),
   MON4                 NUMBER(18,6),
   MON5                 NUMBER(18,6),
   MON6                 NUMBER(18,6),
   MON7                 NUMBER(18,6),
   MON8                 NUMBER(18,6),
   MON9                 NUMBER(18,6),
   MON10                NUMBER(18,6),
   MON11                NUMBER(18,6),
   MON12                NUMBER(18,6),
   MON                  NUMBER(18,6),
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   STATUS               CHAR(1)              not null,
   ORDER_INDEX          INTEGER              not null,
   constraint PK_DSE_DTH_SW_RELATION primary key (ID)
);

comment on table DSE_DTH_SW_RELATION is
'水源单位与供水对象关系表';

comment on column DSE_DTH_SW_RELATION.ID is
'ID';

comment on column DSE_DTH_SW_RELATION.WATER_ENT_NAME is
'水源单位名称';

comment on column DSE_DTH_SW_RELATION.WS_OBJ_NAME is
'供水对象名称';

comment on column DSE_DTH_SW_RELATION.TYPE is
'是否多水源';

comment on column DSE_DTH_SW_RELATION.YEAR is
'年份';

comment on column DSE_DTH_SW_RELATION.MON1 is
'1月';

comment on column DSE_DTH_SW_RELATION.MON2 is
'2月';

comment on column DSE_DTH_SW_RELATION.MON3 is
'3月';

comment on column DSE_DTH_SW_RELATION.MON4 is
'4月';

comment on column DSE_DTH_SW_RELATION.MON5 is
'5月';

comment on column DSE_DTH_SW_RELATION.MON6 is
'6月';

comment on column DSE_DTH_SW_RELATION.MON7 is
'7月';

comment on column DSE_DTH_SW_RELATION.MON8 is
'8月';

comment on column DSE_DTH_SW_RELATION.MON9 is
'9月';

comment on column DSE_DTH_SW_RELATION.MON10 is
'10月';

comment on column DSE_DTH_SW_RELATION.MON11 is
'11月';

comment on column DSE_DTH_SW_RELATION.MON12 is
'12月';

comment on column DSE_DTH_SW_RELATION.MON is
'小计';

comment on column DSE_DTH_SW_RELATION.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_SW_RELATION.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_SW_RELATION.STATUS is
'状态(0：删除，1：未删除)';

/*==============================================================*/
/* Table: DSE_DTH_SW_SOURCE                                     */
/*==============================================================*/
create table DSE_DTH_SW_SOURCE 
(
   ID                   VARCHAR2(32)         not null,
   WATER_ENT_NAME       VARCHAR2(128),
   WS_OBJ_NAME          VARCHAR2(128)        not null,
   WP_NAME              VARCHAR2(128)        not null,
   RSV_NAME             VARCHAR2(128),
   TYPE                 CHAR(1),
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   STATUS               CHAR(1)              not null,
   ORDER_INDEX          INTEGER              not null,
   REPORT_TYPE          CHAR(1),
   constraint PK_DSE_DTH_SW_SOURCE primary key (ID)
);

comment on table DSE_DTH_SW_SOURCE is
'供水对象取水来源关系表';

comment on column DSE_DTH_SW_SOURCE.ID is
'ID';

comment on column DSE_DTH_SW_SOURCE.WATER_ENT_NAME is
'水源单位名称';

comment on column DSE_DTH_SW_SOURCE.WS_OBJ_NAME is
'供水对象名称';

comment on column DSE_DTH_SW_SOURCE.WP_NAME is
'水厂名称';

comment on column DSE_DTH_SW_SOURCE.RSV_NAME is
'水库名称';

comment on column DSE_DTH_SW_SOURCE.TYPE is
'类型(1:水厂,2:泵闸)';

comment on column DSE_DTH_SW_SOURCE.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_SW_SOURCE.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_SW_SOURCE.STATUS is
'状态(0：删除，1：未删除)';

comment on column DSE_DTH_SW_SOURCE.REPORT_TYPE is
'1：计划与实际供水分析
2：东江水量分配表（一）
3：东江水量分配表（二）';

/*==============================================================*/
/* Table: DSE_DTH_WATER_ENT                                     */
/*==============================================================*/
create table DSE_DTH_WATER_ENT 
(
   ID                   VARCHAR(32)          not null,
   WATER_ENT_CODE       VARCHAR(32),
   WATER_ENT_NAME       VARCHAR(64)          not null,
   STATUS               CHAR(1)              not null,
   CREATE_TIME          VARCHAR(20),
   ORDER_INDEX          INTEGER,
   constraint PK_DSE_DTH_WATER_ENT primary key (ID)
);

comment on table DSE_DTH_WATER_ENT is
'水源管理单位表';

comment on column DSE_DTH_WATER_ENT.STATUS is
'状态(0：不可用，1：可用)';

comment on column DSE_DTH_WATER_ENT.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_WATER_ENT.ORDER_INDEX is
'排序';

/*==============================================================*/
/* Table: DSE_DTH_WATER_PLANT                                   */
/*==============================================================*/
create table DSE_DTH_WATER_PLANT 
(
   ID                   VARCHAR2(32)         not null,
   WP_CODE              VARCHAR2(32),
   WP_NAME              VARCHAR2(255)        not null,
   WP_TYPE              INTEGER              not null,
   WATER_SUPPLY_CAPACITY NUMBER(18,6)         not null,
   ADDVCD               VARCHAR2(6)          not null,
   ADDRESS              VARCHAR2(255),
   SORT_ON              INTEGER,
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   WATER_SUPPLY_BUSINESS VARCHAR2(32),
   STATUS               CHAR(1),
   constraint PK_DSE_DTH_WATER_PLANT primary key (ID)
);

comment on table DSE_DTH_WATER_PLANT is
'供水水厂表';

comment on column DSE_DTH_WATER_PLANT.ID is
'编号';

comment on column DSE_DTH_WATER_PLANT.WP_CODE is
'水厂编码';

comment on column DSE_DTH_WATER_PLANT.WP_NAME is
'水厂名称';

comment on column DSE_DTH_WATER_PLANT.WP_TYPE is
'是否村办';

comment on column DSE_DTH_WATER_PLANT.WATER_SUPPLY_CAPACITY is
'最高设计供水能力';

comment on column DSE_DTH_WATER_PLANT.ADDVCD is
'行政区划代码';

comment on column DSE_DTH_WATER_PLANT.ADDRESS is
'水厂地址';

comment on column DSE_DTH_WATER_PLANT.SORT_ON is
'排序';

comment on column DSE_DTH_WATER_PLANT.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_WATER_PLANT.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_WATER_PLANT.WATER_SUPPLY_BUSINESS is
'水厂所属供水企业';

comment on column DSE_DTH_WATER_PLANT.STATUS is
'状态(0：未删除，1：删除)';

/*==============================================================*/
/* Table: DSE_DTH_WATER_PLANT_ENT                               */
/*==============================================================*/
create table DSE_DTH_WATER_PLANT_ENT 
(
   ID                   VARCHAR(32)          not null,
   ENT_CODE             VARCHAR(32),
   ENT_NAME             VARCHAR(64)          not null,
   STATUS               CHAR(1)              not null,
   CREATE_TIME          VARCHAR(20),
   ORDER_INDEX          INTEGER,
   constraint PK_DSE_DTH_WATER_PLANT_ENT primary key (ID)
);

comment on table DSE_DTH_WATER_PLANT_ENT is
'水厂所属企业表';

comment on column DSE_DTH_WATER_PLANT_ENT.STATUS is
'状态(0：不可用，1：可用)';

comment on column DSE_DTH_WATER_PLANT_ENT.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_WATER_PLANT_ENT.ORDER_INDEX is
'排序';

/*==============================================================*/
/* Table: DSE_DTH_WDP_PART                                      */
/*==============================================================*/
create table DSE_DTH_WDP_PART 
(
   WDP_PART_CODE        VARCHAR2(32)         not null,
   WDP_PART_NAME        VARCHAR2(250)        not null,
   PROJECT_CODE         VARCHAR2(32)         not null,
   PARENT_WDP_PART_CODE VARCHAR2(32),
   LEV                  INTEGER,
   SORT_ON              INTEGER              not null,
   STATUS               INTEGER              not null,
   TS                   VARCHAR2(20)         not null,
   constraint PK_DSE_DTH_WDP_PART primary key (WDP_PART_CODE)
);

comment on column DSE_DTH_WDP_PART.SORT_ON is
'从小到大为上游到下游';

comment on column DSE_DTH_WDP_PART.STATUS is
'1启动0删除';

/*==============================================================*/
/* Index: IDX_DSE_DTH_WDP_PART                                  */
/*==============================================================*/
create index IDX_DSE_DTH_WDP_PART on DSE_DTH_WDP_PART (
   PARENT_WDP_PART_CODE ASC,
   LEV ASC,
   SORT_ON ASC,
   STATUS ASC,
   WDP_PART_CODE ASC,
   PROJECT_CODE ASC
);

/*==============================================================*/
/* Table: DSE_DTH_WSPIPELINE                                    */
/*==============================================================*/
create table DSE_DTH_WSPIPELINE 
(
   PROJECT_CODE         VARCHAR2(32)         not null,
   PROJECT_NAME         VARCHAR2(255)        not null,
   PROJECT_MAN_CODE     VARCHAR2(128),
   PROJECT_SCALE        VARCHAR2(255)        not null,
   TOTAL_LENGTH         VARCHAR2(255),
   WATER_INTAKE_LOCATION VARCHAR2(255)        not null,
   WATER_DELIVERY_LOCATION VARCHAR2(255)        not null,
   ROUTE_LOCATION       VARCHAR2(255),
   WATER_SUPPLY_RANGE   VARCHAR2(255)        not null,
   WATER_DELIVERY_TYPE  INTEGER,
   SORT_ON              INTEGER,
   UPDATE_TIME          VARCHAR2(20),
   CREATE_TIME          VARCHAR2(20),
   STATUS               CHAR(1),
   constraint PK_DSE_DTH_WSPIPELINE primary key (PROJECT_CODE)
);

comment on table DSE_DTH_WSPIPELINE is
'供水管线表';

comment on column DSE_DTH_WSPIPELINE.PROJECT_CODE is
'工程代码';

comment on column DSE_DTH_WSPIPELINE.PROJECT_NAME is
'工程名称';

comment on column DSE_DTH_WSPIPELINE.PROJECT_MAN_CODE is
'管理单位';

comment on column DSE_DTH_WSPIPELINE.PROJECT_SCALE is
'工程规模';

comment on column DSE_DTH_WSPIPELINE.TOTAL_LENGTH is
'工程总长度';

comment on column DSE_DTH_WSPIPELINE.WATER_INTAKE_LOCATION is
'取水地点';

comment on column DSE_DTH_WSPIPELINE.WATER_DELIVERY_LOCATION is
'交水地点';

comment on column DSE_DTH_WSPIPELINE.ROUTE_LOCATION is
'途径地点';

comment on column DSE_DTH_WSPIPELINE.WATER_SUPPLY_RANGE is
'供水范围';

comment on column DSE_DTH_WSPIPELINE.WATER_DELIVERY_TYPE is
'输水型式';

comment on column DSE_DTH_WSPIPELINE.SORT_ON is
'排序';

comment on column DSE_DTH_WSPIPELINE.UPDATE_TIME is
'修改时间';

comment on column DSE_DTH_WSPIPELINE.CREATE_TIME is
'创建时间';

comment on column DSE_DTH_WSPIPELINE.STATUS is
'1启动0删除';

