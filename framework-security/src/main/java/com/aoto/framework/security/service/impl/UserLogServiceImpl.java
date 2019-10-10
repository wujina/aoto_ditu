package com.aoto.framework.security.service.impl;

import com.aoto.framework.security.DTO.TotalDTO;
import com.aoto.framework.security.Ecmybatis.Dao;
import com.aoto.framework.security.models.UserLog;
import com.aoto.framework.security.persistence.inf.UserMapper;
import com.aoto.framework.security.service.inf.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    protected Dao dao;

    @Autowired
    protected UserMapper userMapper;

    @Override
    public void add(TotalDTO dto, HttpServletRequest request,String string) {
        Map<String,Object> map=userMapper.checkToken(request.getHeader("token"));
        String ip = request.getHeader("x-forwarded-for");
        String str;
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            ip =ip.split(",")[0];
        }

        UserLog userLog=new UserLog();
        userLog.setUserLogIpAddess(dto.getIp_addess());
        userLog.setUserLogMacAddress(dto.getMac_addess());
        userLog.setUserLogOperator(string);
        userLog.setUserLogUser((Integer) map.get("userId"));
        userLog.setUserLogCallTime(new java.util.Date());
        userLog.setUserLogIp(ip);
        dao.saveOne(userLog);
    }
}
