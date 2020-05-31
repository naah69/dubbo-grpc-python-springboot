package com.naah69.service.impl;


import io.grpc.examples.helloworld.DubboGreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.apache.dubbo.config.annotation.Service;

/**
 * GreeterImpl
 *
 * @author naah
 * @date 2020-05-31 6:28 下午
 * @desc
 */
@Service(protocol = "grpc")
public class GreeterImpl extends DubboGreeterGrpc.GreeterImplBase implements DubboGreeterGrpc.IGreeter {


    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String value = "Dubbo: Hello " + request.getName();
        System.out.println(value+", Executing thread is " + Thread.currentThread().getName());
        HelloReply reply = HelloReply.newBuilder().setMessage(value).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
