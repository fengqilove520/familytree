package top.fqq.familytree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import top.fqq.familytree.intercept.DictPluginIntercept;

@SpringBootApplication
public class FamilytreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilytreeApplication.class, args);
    }

    @Bean
    public DictPluginIntercept sensitivePlugin() {
        return new DictPluginIntercept();
    }

}
