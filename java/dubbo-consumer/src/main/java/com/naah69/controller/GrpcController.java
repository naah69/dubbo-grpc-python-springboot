package com.naah69.controller;

import io.grpc.examples.helloworld.DubboGreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GrpcController
 *
 * @author naah
 * @date 2020-05-31 7:07 下午
 * @desc
 */
@RestController
public class GrpcController {
    @Reference(protocol = "grpc")
    private DubboGreeterGrpc.IGreeter dubboGreeter;

    @Reference(protocol = "grpc",url = "grpc://127.0.0.1:50001")
    private DubboGreeterGrpc.IGreeter pythonGreeter;

    @GetMapping("/grpc/dubbo")
    public String testDubboGrpc() {
        HelloReply reply = dubboGreeter.sayHello((HelloRequest.newBuilder().setName("world!").build()));
        return reply.getMessage();
    }

    @GetMapping("/grpc/python")
    public String testPythonGrpc() {
        HelloReply reply = pythonGreeter.sayHello((HelloRequest.newBuilder().setName("world!").build()));
        return reply.getMessage();
    }
}
