package com.zsport.platform.blogservice.client;

import com.zsport.platform.blogservice.client.hystrix.UserServiceHystrix;
import com.zsport.platform.blogservice.entity.User;
import com.zsport.platform.common.dto.RespDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;



/**
 * Created by fangzhipeng on 2017/5/27.
 */

@FeignClient(value = "user-service",fallback = UserServiceHystrix.class )
public interface UserServiceClient {

    @PostMapping(value = "/user/{username}")
    RespDTO<User> getUser(@RequestHeader(value = "Authorization") String token, @PathVariable("username") String username);
}



