package zerobase.weather.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableSwagger2
 *
 * springboot 3버전부터 springfox 대신 springdoc을 사용
 */
@Configuration
public class SwaggerConfig {

    /**
     * @Bean
     *     public Docket api() {
     *         return new Docket(DocumentationType.SWAGGER_2)
     *                 .select()
     *                 // .apis(RequestHandlerSelectors.any())
     *                 .apis(RequestHandlerSelectors.basePackage("zerobase.weather"))
     *                 .paths(PathSelectors.any())
     *                 // .paths(PathSelectors.ant("/read/**"))
     *                 .build().apiInfo(apiInfo());
     *
     *     }
     *
     *     private ApiInfo apiInfo() {
     *         return new ApiInfoBuilder()
     *                 .title("titile")
     *                 .description("description")
     *                 .version("1.0")
     *                 .build();
     *     }
     *
     */

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("날씨 일기 프로젝트 :)")
                .description("날씨 일기를 CRUD 할 수 있는 백엔드 API입니다.")
                .version("2.0.0");
    }
}
