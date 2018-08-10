package com.zsport.platform.blogservice.client.hystrix;

import com.zsport.platform.blogservice.client.UserServiceClient;
import com.zsport.platform.blogservice.entity.User;
import com.zsport.platform.common.dto.RespDTO;
import org.springframework.stereotype.Component;


/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
