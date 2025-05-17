# Spring gRPC Example 🚀

This repository demonstrates how to build a **gRPC server** and **client** using Spring Boot. It includes a step-by-step guide to setting up gRPC communication, defining service contracts with **Protocol Buffers (protobuf)**, and exposing REST APIs for seamless integration.


---

## Features ✨
- **gRPC Server**: Implements a simple unary RPC method to handle greeting requests.
- **gRPC Client**: Exposes a REST API to interact with the gRPC server.
- **Protocol Buffers**: Defines service contracts and message types using `.proto` files.
- **Spring Boot Integration**: Leverages the Spring gRPC experimental starter for easy setup.

---

## Prerequisites 📋
- Java 21 or higher
- Gradle or Maven
- Basic knowledge of gRPC and Protocol Buffers

---

## Getting Started 🛠️

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/spring-grpc.git
   cd spring-grpc
   ```

2. **Build the Project**:
   ```bash
   ./gradlew build
   ```

3. **Run the gRPC Server**:
   ```bash
   ./gradlew bootRun
   ```

4. **Run the gRPC Client**:
   ```bash
   ./gradlew bootRun
   ```

5. **Test the Application**:
   Use `curl` to send a request to the gRPC client:
   ```bash
   curl -X GET http://localhost:8080/hello -H "Content-Type: text/plain" -d "oussema"
   ```

   **Expected Output**:
   ```
   Hello, oussema!
   ```