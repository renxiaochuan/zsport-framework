package com.zsport.platform.fileuploadservice.web;

import com.zsport.platform.common.annotation.SysLogger;
import com.zsport.platform.common.dto.RespDTO;
import com.zsport.platform.fileuploadservice.entity.User;
import com.zsport.platform.fileuploadservice.service.FileUploadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @ApiOperation(value = "fileUpload", notes = "文件上传")
    @PostMapping("/fileUpload")
//    @SysLogger("login")
    public RespDTO<List<User>> fileUpload(@RequestParam(required = false) String parentId , @RequestParam(required = false) MultipartFile file){
        //参数判读省略
        return    RespDTO.onSuc(fileUploadService.getUserList());
    }

    @ApiOperation(value = "test", notes = "测试")
    @GetMapping("/test")
//    @SysLogger("login")
    public RespDTO<List<User>> test(@RequestParam(required = false) String parentId , @RequestParam(required = false) MultipartFile file){
        //参数判读省略
        return    RespDTO.onSuc(fileUploadService.getUserList());
    }
}
