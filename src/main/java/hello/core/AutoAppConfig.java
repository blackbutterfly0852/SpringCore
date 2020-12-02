package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // AppConfig의 @Bean과 충돌방지
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class),
        // 탐색할 패키지의 시작 위치를 지정한다. ( 현재는 member 패키지 내에서 조회)
        // 추천 : default + CoreApplication 같은 위치 (Root)
        basePackages = "hello.core.member"

)
public class AutoAppConfig {
}
