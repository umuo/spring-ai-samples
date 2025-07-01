package cn.lacknb.server.components.resource;

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
public class LowLevelResourceConfig {

    @Bean
    public List<McpServerFeatures.SyncResourceSpecification> myResources() {
        McpSchema.Resource resource = new McpSchema.Resource(
                "file://a/b/c/凡人修仙传.txt",
                "凡人修仙传",
                "这是一本修仙小说",
                "text/plain", new McpSchema.Annotations(List.of(McpSchema.Role.ASSISTANT), 1.0)
        );
        McpServerFeatures.SyncResourceSpecification syncResourceSpecification = new McpServerFeatures.SyncResourceSpecification(resource,
                (exchange, request) -> {
                    // 读取资源内容

                    // 返回结果
                    return new McpSchema.ReadResourceResult(
                            List.of(
                                    new McpSchema.TextResourceContents(
                                            resource.uri(),
                                            resource.mimeType(),
                                            "韩立是一名修仙者，他出生在偏僻的小山村里，从小就过着平凡的生活。然而，命运的转折点在他16岁那年到来。一次意外，韩立被卷入了一个神秘的空间，" +
                                                    "从此开始了他的修仙之旅。在修仙的道路上，韩立经历了种种困难和挑战，但他始终坚定地追求着他的目标。最终，他成为了修仙界中的一位传奇人物，被人们称为“凡人修仙传”。"
                                    ),
                                    new McpSchema.TextResourceContents(
                                            resource.uri(),
                                            resource.mimeType(),
                                            "在修仙的旅途中，韩立 encountered many challenges and obstacles. However, he always remained committed to his goal. Finally, he became a legend in the world of " +
                                                    "magic, being known as '凡人修仙传'."
                                    )
                            )
                    );
                });
        return List.of(syncResourceSpecification);
    }

}
