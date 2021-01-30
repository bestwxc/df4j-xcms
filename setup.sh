#!/bin/bash

## 目标目录
target_dir=/srv/xcms
## 定义
artifact_id=df4j-xcms
varsion=1.0.0-SNAPSHOT

## jar 名称
jar_name=$artifact_id-$varsion.jar

cur_dir=$(cd `dirname $0`;pwd)

## 创建目标目录
mkdir -p $target_dir

## 拷贝包
\cp -f "$cur_dir"/target/$jar_name $target_dir

## 进入目标目录
cd $target_dir

echo "java -jar $target_dir/$jar_name &"

## 启动
nohup java -jar $target_dir/$jar_name &

tail -fn 200 nohup.out
