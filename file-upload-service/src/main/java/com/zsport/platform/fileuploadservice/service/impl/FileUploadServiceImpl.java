package com.zsport.platform.fileuploadservice.service.impl;

import com.zsport.platform.fileuploadservice.dao.UserMapper;
import com.zsport.platform.fileuploadservice.entity.User;
import com.zsport.platform.fileuploadservice.entity.UserExample;
import com.zsport.platform.fileuploadservice.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }
}
