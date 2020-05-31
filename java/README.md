# 1 通过IDL生成代码
切换到`dubbo-api`目录下运行下方代码
```
mvn clean compile
```

# 2 生成jar包
切换到`dubbo-api`目录下运行下方代码
使用下方命令生成jar包会自动将build下的class打包
```
mvn clean install
```

# 3 启动zookeeper
运行`dubbo-zookeeper`项目中的主程序`ZookeeperApplication`

# 4 启动dubbo-provider
运行`dubbo-provider`项目中的主程序`DubboGrpcProviderApplication`

# 4 启动dubbo-consumer
运行`dubbo-consumer`项目中的主程序`DubboGrpcConsumerApplication`

# 5 浏览器测试

## 5.1 测试dubbo的grpc功能（dubbo调用dubbo）

浏览器访问下方链接，返回`Dubbo: Hello world!`即成功
```
http://127.0.0.1:28080/grpc/dubbo
```

## 5.2 测试python的grpc功能（dubbo调用python）
浏览器访问下方链接，返回`Python: Hello world!`即成功
```
http://127.0.0.1:28080/grpc/python
```
