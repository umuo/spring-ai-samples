package cn.lacknb.mcp.server.sse;

import cn.lacknb.mcp.server.tools.MathTool;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
@ComponentScan(basePackages = "cn.lacknb.mcp.server")
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }

    public record TextInput(String input) {
    }

    /*
    * 两种注册工具方式
    * */

    @Bean
    public ToolCallback toUpperCase() {
        return FunctionToolCallback.builder("toUpperCase", (TextInput input) -> input.input().toUpperCase())
                .inputType(TextInput.class)
                .description("将小写字母转为大写字母")
                .build();
    }

    @Bean
    public ToolCallbackProvider toolCallbackProvider( MathTool mathTool) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(mathTool).build();
    }

}
