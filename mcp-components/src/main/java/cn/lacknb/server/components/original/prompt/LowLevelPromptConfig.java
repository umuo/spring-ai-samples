package cn.lacknb.server.components.original.prompt;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <h2>  </h2>
 *
 * @author gitsilence
 * @date 2025/7/1
 */
@Configuration
public class LowLevelPromptConfig {

    @Bean
    public List<McpServerFeatures.SyncPromptSpecification> myPrompts() {
        McpSchema.Prompt prompt = new McpSchema.Prompt("greeting", "这是一个打招呼的Prompt",
        List.of(
                new McpSchema.PromptArgument("name", "请输入你的名字", true)
        ));

        McpServerFeatures.SyncPromptSpecification syncPromptSpecification = new McpServerFeatures.SyncPromptSpecification(prompt, (exchange, request) -> {
            String name = (String) request.arguments().get("name");
            if (name == null) {
                name = "default";
            }
            McpSchema.PromptMessage userMessage = new McpSchema.PromptMessage(McpSchema.Role.USER, new McpSchema.TextContent(String.format("你好， %s, 早上好！", name)));
            return new McpSchema.GetPromptResult("一条打招呼的消息", List.of(userMessage));
        });
        return List.of(syncPromptSpecification);
    }

}