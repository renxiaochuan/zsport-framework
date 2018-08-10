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
//����OAuth2��Դ����
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);
//tokenServices��ResourceServerTokenServices ���ʵ��������ʵ�����Ʒ���
//resourceId�������Դ�����ID����������ǿ�ѡ�ģ������Ƽ����ò�����Ȩ�����н�����֤��
//��������չ�������� tokenExtractor ������ȡ��������ȡ�����е����ơ�
//����ƥ����������������Ҫ���б�������Դ·����Ĭ�ϵ���������ܱ�����Դ�����ȫ��·����
//�ܱ�����Դ�ķ��ʹ���Ĭ�ϵĹ����Ǽ򵥵������֤��plain authenticated����
//�������Զ���Ȩ�ޱ�������ͨ�� HttpSecurity ���������á�
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
