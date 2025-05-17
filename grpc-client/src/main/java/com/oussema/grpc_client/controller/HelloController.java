package com.oussema.grpc_client.controller;

import org.springframework.grpc.sample.proto.HelloReply;
import org.springframework.grpc.sample.proto.HelloRequest;
import org.springframework.grpc.sample.proto.SimpleGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class HelloController {

    private final SimpleGrpc.SimpleBlockingStub simpleBlockingStub;

    // Step 1: Inject the blocking stub via constructor injection
    public HelloController(SimpleGrpc.SimpleBlockingStub simpleBlockingStub ) {
        this.simpleBlockingStub = simpleBlockingStub;
    }

    @GetMapping("/hello")
    public String hello(@RequestBody String name) {
        try {
            // Step 2: Create a HelloRequest object with the provided name
            HelloRequest request = HelloRequest.newBuilder()
                    .setName(name)
                    .build();

            // Step 3: Call the gRPC server's Greet method using the blocking stub
            return simpleBlockingStub.sayHello(request).getMessage();
        } catch (Exception e) {
            // Step 4: Handle any errors that occur during the gRPC call
            e.printStackTrace();
            return "Sorry, something went wrong!";
        }
    }
    @GetMapping("/stream/hello")
    public String streamHello(@RequestBody String name) {
        try {
            HelloRequest request = HelloRequest.newBuilder()
                    .setName(name)
                    .build();

            Iterator<HelloReply> replies = simpleBlockingStub.streamHello(request);
            StringBuilder messages = new StringBuilder();
            while (replies.hasNext()) {
                HelloReply reply = replies.next();
                messages.append(reply.getMessage()).append("\n");
            }
            return messages.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, something went wrong!";
        }
    }
}