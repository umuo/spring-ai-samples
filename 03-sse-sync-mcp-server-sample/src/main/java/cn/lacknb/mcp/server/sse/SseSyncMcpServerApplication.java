package cn.lacknb.mcp.server.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <h2>  </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2025/6/30 16:08
 **/
@SpringBootApplication
@ComponentScan(basePackages = "cn.lacknb.server.components")
public class SseSyncMcpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SseSyncMcpServerApplication.class, args);
    }

}
