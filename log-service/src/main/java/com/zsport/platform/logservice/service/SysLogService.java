package com.zsport.platform.logservice.service;

import com.zsport.platform.logservice.dao.SysLogDAO;
import com.zsport.platform.logservice.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fangzhipeng on 2017/7/12.
 */
@Service
public class SysLogService {

    @Autowired
    SysLogDAO sysLogDAO;

    public void saveLogger(SysLog sysLog){
        sysLogDAO.save(sysLog);
    }
}
