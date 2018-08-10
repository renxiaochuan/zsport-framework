package com.zsport.platform.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by fangzhipeng on 2017/5/27.
 */
@Configuration
//配置OAuth2资源服务
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);
//tokenServices：ResourceServerTokenServices 类的实例，用来实现令牌服务。
//resourceId：这个资源服务的ID，这个属性是可选的，但是推荐设置并在授权服务中进行验证。
//其他的拓展属性例如 tokenExtractor 令牌提取器用来提取请求中的令牌。
//请求匹配器，用来设置需要进行保护的资源路径，默认的情况下是受保护资源服务的全部路径。
//受保护资源的访问规则，默认的规则是简单的身份验证（plain authenticated）。
//其他的自定义权限保护规则通过 HttpSecurity 来进行配置。
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .regexMatchers(".*swagger.*",".*v2.*",".*webjars.*","/user/login.*","/user/registry.*","/user/test.*").permitAll()
                .antMatchers("/**").authenticated();
//        .antMatchers("/**").permitAll();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("Configuring ResourceServerSecurityConfigurer ");
        resources.resourceId("user-service").tokenStore(tokenStore);
    }

    @Autowired
    TokenStore tokenStore;
}
