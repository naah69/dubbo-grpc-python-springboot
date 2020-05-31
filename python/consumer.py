#!/usr/bin/python
# cython: language_level=3
# -*- coding:utf-8 -*-
# @filename : consumer
# @package :
# @Time : 2020-05-31 4:45 下午
# @Author : naah
# @desc :
import grpc

from proto import helloworld_pb2_grpc, helloworld_pb2


def run():
    # 连接 rpc 服务器
    channel = grpc.insecure_channel('localhost:50001')
    # 调用 rpc 服务
    stub = helloworld_pb2_grpc.GreeterStub(channel)
    response = stub.SayHello(helloworld_pb2.HelloRequest(name='World'))
    print("Greeter client received: " + response.message)


if __name__ == '__main__':
    run()
