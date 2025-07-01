package cn.lacknb.server.components.original.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

/**
 * <h2>  </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2025/6/30 16:15
 **/
@Service
public class MathTool {

    /**
     * 使用 @ToolParam 注解，指定参数的描述
     * @param a
     * @param b
     * @return
     */
    @Tool(name = "add", description = "求两数之和")
    public int add(@ToolParam(description = "参数a") int a, @ToolParam(description = "参数b") int b) {
        return a + b;
    }

    @Tool(name = "sub", description = "求两数之差")
    public int sub(int a, int b) {
        return a - b;
    }

    @Tool(name = "mul", description = "求两数之积")
    public int mul(int a, int b) {
        return a * b;
    }

    @Tool(name = "div", description = "求两数之商")
    public int div(int a, int b) {
        return a / b;
    }

}
