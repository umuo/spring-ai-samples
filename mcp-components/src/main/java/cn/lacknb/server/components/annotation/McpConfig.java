package cn.lacknb.server.components.annotation;

import com.logaritex.mcp.spring.SpringAiMcpAnnotationProvider;
import io.modelcontextprotocol.server.McpServerFeatures;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <h2>  </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2025/7/1 15:24
 **/
@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }

    @Bean
    public List<McpServerFeatures.SyncResourceSpecification> resourceSpecs(UserProfileResourceProvider userProfileResourceProvider) {
        return SpringAiMcpAnnotationProvider.createSyncResourceSpecifications(List.of(userProfileResourceProvider));
    }

    @Bean
    public List<McpServerFeatures.SyncPromptSpecification> promptSpecs(PromptProvider promptProvider) {
        return SpringAiMcpAnnotationProvider.createSyncPromptSpecifications(List.of(promptProvider));
    }

    @Bean
    public List<McpServerFeatures.SyncCompletionSpecification> completionSpecs(AutocompleteProvider autocompleteProvider) {
        return SpringAiMcpAnnotationProvider.createSyncCompleteSpecifications(List.of(autocompleteProvider));
    }

}
