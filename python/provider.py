#!/usr/bin/python
# cython: language_level=3
# -*- coding:utf-8 -*-
# @filename : demo
# @package :
# @Time : 2020-05-31 4:37 下午
# @Author : naah
# @desc :


import time
from concurrent import futures

import grpc

from proto import helloworld_pb2_grpc, helloworld_pb2


class Greeter(helloworld_pb2_grpc.GreeterServicer):

    def SayHello(self, request, context):
        msg = 'Python: Hello {msg}'.format(msg=request.name)
        print(msg)
        return helloworld_pb2.HelloReply(message=msg)


def serve():
    # 启动 rpc 服务
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    helloworld_pb2_grpc.add_GreeterServicer_to_server(Greeter(), server)
    # 定义grpc服务的接口
    server.add_insecure_port('[::]:50001')
    server.start()
    print("grpc provider start success")
    try:
        while True:
            time.sleep(60 * 60 * 24)  # one day in seconds
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
