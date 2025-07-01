package cn.lacknb.mcp.server.sse.tools;

import org.springframework.ai.tool.annotation.Tool;
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

    @Tool(name = "add", description = "求两数之和")
    public int add(int a, int b) {
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
