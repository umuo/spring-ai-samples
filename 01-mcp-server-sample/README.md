# 01-mcp-server-sample

该项目是 Spring AI MCP (Model-Centric Programming) 服务器的示例实现。它演示了如何创建一个服务器，该服务器公开 AI 模型和工具以供其他应用程序使用。

## 关键技术

*   **Spring Boot:** 用作应用程序的底层框架。
*   **Spring AI:** Spring 生态系统中用于 AI 驱动应用程序的核心库。
*   **spring-ai-starter-mcp-server-webflux:** 用于创建反应式 MCP 服务器的特定 Spring AI 启动器。
*   **Maven:** 用于依赖管理和项目构建。

## 项目结构

*   `pom.xml`: 定义项目依赖项，包括 Spring Boot 和 Spring AI。
*   `src/main/java/cn/lacknb/mcp/server/sse/McpServerApplication.java`: 主应用程序类。它包括 Spring Boot 应用程序入口点和 AI 工具的定义。
*   `src/main/java/cn/lacknb/mcp/server/tools/MathTool.java`: 一个简单的服务，提供基本的数学函数作为工具。
*   `src/main/resources/application.yml`: 应用程序配置文件。它定义了服务器端口、MCP 服务器名称和其他设置。

## 特性

*   **MCP 服务器:** 该应用程序充当 MCP 服务器，公开 AI 模型和工具。
*   **工具定义:** 该项目演示了两种定义工具的方法：
    *   使用 `FunctionToolCallback` 从简单函数创建工具。
    *   使用 `MethodToolCallbackProvider` 从服务类的方法创建工具。
*   **SSE 端点:** 服务器在 `/sse/mcp` 上公开一个 SSE (Server-Sent Events) 端点，供客户端连接。

## 如何运行

1.  **构建项目:**
    ```bash
    mvn clean package
    ```
2.  **运行应用程序:**
    ```bash
    java -jar target/01-mcp-server-sample.jar
    ```
服务器将在端口 8080 上启动。

## 配置

可以在 `src/main/resources/application.yml` 文件中配置应用程序。关键配置属性包括：

*   `spring.ai.mcp.server.name`: MCP 服务器的名称。
*   `spring.ai.mcp.server.version`: MCP 服务器的版本。
*   `spring.ai.mcp.server.sse-endpoint`: SSE 端点的基本路径。
*   `server.port`: 服务器将运行的端口。