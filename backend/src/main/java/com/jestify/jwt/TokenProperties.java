package com.jestify.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("jestify-app")
public class TokenProperties {

    private Token token = new Token();
    private RememberMe rememberMe = new RememberMe();

    @Getter
    @Setter
    public class Token {
        private int accessLifetimeMinutes;
        private int refreshLifetimeMinutes;
    }

    @Getter
    @Setter
    public class RememberMe {
        private int expiredDays;
    }
}
