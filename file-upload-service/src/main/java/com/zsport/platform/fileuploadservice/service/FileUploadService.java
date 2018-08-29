package com.zsport.platform.fileuploadservice.service;

import com.zsport.platform.fileuploadservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FileUploadService {

    List<User> getUserList();
}
