package com.zsport.platform.logservice.dao;

import com.zsport.platform.logservice.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fangzhipeng on 2017/7/12.
 */
public interface SysLogDAO extends JpaRepository<SysLog, Long> {
}
