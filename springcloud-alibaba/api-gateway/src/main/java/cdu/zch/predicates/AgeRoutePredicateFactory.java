package cdu.zch.predicates;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Zch
 * @date 2023/7/22
 **/
// @Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    // 用于从配置文件中获取参数复制到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
        // 这里的顺序要和配置文件中的参数顺序一致
        return Arrays.asList("minAge", "maxAge");
    }

    // 断言
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return serverWebExchange -> {
            // 从serverWebExchange获取的参数
            String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
            if (ageStr != null) {
                int age = Integer.parseInt(ageStr);
                return (age > config.getMinAge()) && (age < config.getMaxAge());
            }
            return false;
        };
    }

    // 自定义一个配置类，用于接收配置文件中的参数
    @Data
    static class Config {
        private int minAge;
        private int maxAge;
    }
}
