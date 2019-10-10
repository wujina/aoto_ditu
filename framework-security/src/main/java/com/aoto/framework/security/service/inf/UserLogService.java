package com.aoto.framework.security.service.inf;

import com.aoto.framework.security.DTO.TotalDTO;

import javax.servlet.http.HttpServletRequest;

public interface UserLogService {
    void add(TotalDTO dto, HttpServletRequest request,String string);
}
