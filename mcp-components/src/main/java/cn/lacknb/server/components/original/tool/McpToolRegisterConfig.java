package cn.lacknb.server.components.original.tool;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h2>  </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2025/7/1 09:42
 **/
@Configuration
public class McpToolRegisterConfig {

    private final ExpressionParser parser = new SpelExpressionParser();


    public record TextInput(String input) {
    }

    /*
     * 两种注册工具方式
     * */

    /**
     * 注册一个Tool，使用FunctionToolCallback
     * @return
     */
    @Bean
    public ToolCallback toUpperCase() {
        return FunctionToolCallback.builder("toUpperCase", (TextInput input) -> input.input().toUpperCase())
                .inputType(TextInput.class)
                .description("将小写字母转为大写字母")
                .build();
    }

    /**
     * 注册某个Bean中@Tool注解的工具
     * @param mathTool
     * @return
     */
    @Bean
    public ToolCallbackProvider toolCallbackProvider(MathTool mathTool) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(mathTool).build();
    }

    /**
     * 这里使用的low level api 注册tool，并且是同步(sync)的
     * @return
     */
    @Bean
    public List<McpServerFeatures.SyncToolSpecification> myTools() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("expression", Map.of(
                "type", "string",
                "description", "需要评估的数学表达式字符串，例如 '2 + 3 * (4 - 1)'"
        ));

        List<String> requiredFields = new ArrayList<>();
        requiredFields.add("expression");

        return List.of(
                new McpServerFeatures.SyncToolSpecification(
                        new McpSchema.Tool(
                                "calculator",
                                "Performs mathematical calculations",
                                new McpSchema.JsonSchema(
                                        "object",
                                        properties,
                                        requiredFields,
                                        false, // additionalProperties 通常为 false，表示不允许额外的未定义属性
                                        null,  // $defs 很少用在简单的函数参数定义中
                                        null   // definitions 很少用在简单的函数参数定义中
                                )
                        ),
                        (exchange, args) -> {
                            String expr = (String) args.get("expression");
                            return new McpSchema.CallToolResult("Result: " + evaluate(expr), false);
                        }
                )
        );
    }

    /**
     * 评估一个数学表达式。
     * @param expression 待评估的数学表达式字符串。
     * @return 表达式的计算结果。
     * @throws IllegalArgumentException 如果表达式无效或评估失败。
     */
    private Object evaluate(String expression) {
        Expression expressionObj = parser.parseExpression(expression);
        return expressionObj.getValue();
    }
}
