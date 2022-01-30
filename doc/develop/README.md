# xcms平台开发说明

### 一、数据库规范

#### 1. 数据库字符集和排序规则

数据库字符集使用utf8mb4,排序规则使用utf8mb4_bin

#### 2. 建表规范

1. 表结构中必须包含主键ID，创建时间，修改时间三个字段，如下：
``` sql
-- 使用自增主键时 自增从1000开始计数
create table if not exists t_xcms_core_xxxx
(
    id                       bigint                             not null comment '主键id' auto_increment primary key,
    -- 其他字段
    create_time              datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time              datetime default CURRENT_TIMESTAMP not null comment '修改时间'
) auto_increment 1000 comment 'XXX表';

-- 使用字符作为主键时
create table if not exists t_xcms_core_xxxx
(
    id                       varchar(40)                        not null comment '主键id' primary key,
    -- 其他字段
    create_time              datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time              datetime default CURRENT_TIMESTAMP not null comment '修改时间'
) comment 'XXX表';
```

2. 当表中存在关联字段时，尽量冗余记录好对应的id和code；关联时，程序中使用id进行关联；code尽量冗余记录，用于数据清洗、转换等特殊场合。
