package cn.lacknb.server.components.original.completion;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h2>  </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2025/7/1 11:41
 **/
@Service
public class LowLevelCompletionConfig {

    /**
     * 配置补全功能
     * @return
     */
    @Bean
    public List<McpServerFeatures.SyncCompletionSpecification> myCompletions() {
        var completion = new McpServerFeatures.SyncCompletionSpecification(
                new McpSchema.PromptReference("code-completion"),
                (exchange, request) -> {
                    // Implementation that returns completion suggestions
                    return new McpSchema.CompleteResult(
                            new McpSchema.CompleteResult.CompleteCompletion(
                                    List.of("suggestion1", "suggestion2"), 1, false
                            )
                    );
                }
        );

        return List.of(completion);
    }

}
