use xcms;

create table if not exists t_xcms_core_sub_sys
(
    id            bigint                             not null comment '主键ID' auto_increment primary key,
    sys_code      varchar(80)                        not null comment '系统代码',
    sys_name      varchar(200)                       not null comment '系统名称',
    sys_desc      varchar(1000)                      not null comment '系统描述',
    logo          varchar(200)                       null comment '子系统Logo',
    favicon       varchar(200)                       null comment '子系统小版图标',
    index_tpl     varchar(200)                       null comment '子系统首页模板',
    copyright     varchar(1000)                      null comment '网站版权所属信息',
    welcome_page  varchar(1000)                      null comment '子系统登录后默认首页',
    order_num     int      default 0                 not null comment '排序值',
    sub_sys_state int      default 0                 not null comment '子系统状态',
    create_time   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime default current_timestamp not null comment '修改时间'
) auto_increment 1000 comment '子系统配置表';

create table if not exists t_xcms_core_menu
(
    id               bigint                                  not null comment '主键ID' auto_increment primary key,
    source           varchar(40)   default 'xcms'            not null comment '来源xcms',
    sys_id           bigint                                  not null comment '子系统ID',
    sys_code         varchar(80)                             not null comment '系统代码',
    menu_code        varchar(80)                             not null comment '菜单代码',
    menu_name        varchar(80)                             not null comment '菜单名称',
    menu_desc        varchar(80)                             not null comment '菜单说明',
    parent_menu_id   bigint                                  not null comment '上级菜单ID',
    parent_ment_code varchar(80)                             not null comment '上级菜单代码',
    menu_path        varchar(1000) default '#'               not null comment '菜单路径',
    menu_icon        varchar(1000)                           null comment '菜单图标',
    global_menu      int           default 0                 not null comment '全局菜单',
    menu_type        int           default 1                 not null comment '菜单类型',
    jump_type        int           default 1                 not null comment '跳转类型',
    order_num        int           default 0                 not null comment '排序值',
    menu_state       int           default 1                 not null comment '菜单状态',
    create_time      datetime      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime      default CURRENT_TIMESTAMP not null comment '修改时间'
) auto_increment 1000 comment '菜单配置表';


create table if not exists t_xcms_core_user
(
    id              bigint                                 not null comment '主键id' auto_increment primary key,
    user_name       varchar(40)                            not null comment '登陆名',
    nick_name       varchar(100)                           not null comment '用户昵称',
    email           varchar(100)                           not null comment 'email',
    mobile_no       varchar(20)                            not null comment '手机号码',
    user_source     varchar(100) default 'xcms'            not null comment '用户来源',
    last_login_ip   varchar(100)                           null comment '最后登陆IP',
    last_login_time datetime                               null comment '最后登陆时间',
    user_state      int          default 1                 not null comment '用户状态',
    expire_time     datetime                               null comment '过期时间',
    create_time     datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     datetime     default CURRENT_TIMESTAMP not null comment '修改时间'
) auto_increment 1000 comment '系统用户表';


create table if not exists t_xcms_core_sub_sys_user
(
    id                       bigint                             not null comment '主键id' auto_increment primary key,
    sub_sys_id               bigint                             not null comment '子系统id',
    sub_sys_code             varchar(80)                        not null comment '子系统代码',
    user_id                  bigint                             not null comment '用户id',
    user_name                varchar(80)                        not null comment '用户名',
    dep_id                   bigint                             null comment '部门ID',
    dep_code                 varchar(80)                        null comment '部门代码',
    sub_sys_user_state       int      default 1                 not null comment '子系统用户状态',
    sub_sys_user_expire_time datetime                           null comment '子系统用户过期时间',
    create_time              datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time              datetime default CURRENT_TIMESTAMP not null comment '修改时间'
) auto_increment 1000 comment '子系统用户表';


create table if not exists t_xcms_core_dep
(
    id              bigint                             not null comment '主键id' auto_increment primary key,
    dep_code        varchar(80)                        not null comment '部门代码',
    dep_name        varchar(200)                       not null comment '部门名称',
    dep_desc        varchar(200)                       null comment '部门描述',
    parent_dep_id   bigint                             null comment '上级部门ID',
    parent_dep_code varchar(80)                        null comment '上级部门代码',
    head_dep_id     bigint                             null comment '一级部门ID',
    head_dep_code   varchar(80)                        null comment '一级部门代码',
    dep_level       int      default 1                 not null comment '部门级别',
    dep_id_path     varchar(300)                       null comment '部门ID路径',
    dep_code_path   varchar(300)                       null comment '部门代码路径',
    dep_name_path   varchar(1000)                      null comment '部门名称路径',
    order_num       int      default 0                 not null comment '排序值',
    dep_state       int      default 1                 not null comment '部门状态',
    create_time     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     datetime default CURRENT_TIMESTAMP not null comment '修改时间'
) auto_increment 1000 comment '部门表';




