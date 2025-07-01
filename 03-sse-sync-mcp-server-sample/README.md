# sse sync mcp server 

Using the low-level API

```yml
spring:
  # Spring Boot 主配置
  main:
    # 关闭启动时的 Spring Boot 横幅（banner）
    banner-mode: off

  # AI 相关配置
  ai:
    # MCP (Model Control Protocol) 服务器配置
    mcp:
      server:
        # MCP 服务器实例名称
        name: test-tool-mcp-server

        # MCP 服务器版本号
        version: 0.0.1

        # 服务器类型 - ASYNC 推荐用于响应式/非阻塞应用
        type: sync
```
这里配置的是同步模式


