以下命令在python目录下执行

# 1 安装环境
这里使用conda安装python环境
```
conda create -n -y grpc_demo python=3.6
conda activate grpc_demo
pip install -r requirements-pip.txt 
```

# 2 通过IDL生成代码
该命令依赖上一步中安装的`grpcio-tools`库
```bash
python -m grpc_tools.protoc --python_out=. --grpc_python_out=. -I. proto/helloworld.proto
```

# 3 运行 provider
```
python provider.py
```

# 4 运行 consumer（python调用python）
运行consumer进行测试，也可以直接使用dubbo进行调用测试
```
python consumer.py
```

