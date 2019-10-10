/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleVoterImpl.java
 * 文件名称：RoleVoterImpl.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年10月8日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.web.access.vote;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;

import com.aoto.framework.commons.userdetails.CurrentUser;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class RoleVoterImpl extends RoleVoter
{
    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes)
    {
        if (null == authentication)
        {
            return super.vote(authentication, object, attributes);
        }
        
        Object principal = authentication.getPrincipal();

        if (principal instanceof CurrentUser)
        {
            CurrentUser currentUser = (CurrentUser) principal;

            if (currentUser.getUserId() < 0)
            {
                return ACCESS_GRANTED;
            }
        }

        return super.vote(authentication, object, attributes);
    }
}
