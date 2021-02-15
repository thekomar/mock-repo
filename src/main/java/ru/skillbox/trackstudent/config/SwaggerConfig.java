package ru.skillbox.trackstudent.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.trackstudent.util.TagName;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {


    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .tags(
                        new Tag(TagName.STUDENT, "АПИ для работы со студентами"),
                        new Tag(TagName.SUBJECT, "АПИ для работы с предметами"),
                        new Tag(TagName.RATING, "АПИ для работы с оценками студентов"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST API Specification")
                .description("Описание АПИ")
                .version("1.0.0")
                .license("http://localhost:8080")
                .build();
    }
}
