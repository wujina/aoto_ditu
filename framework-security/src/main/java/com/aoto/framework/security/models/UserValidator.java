package com.aoto.framework.security.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aoto.framework.commons.constant.NumberEnum;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class UserValidator implements Validator
{
    @Override
    public boolean supports(Class<?> zlass)
    {
        // 要验证的Model，为假则不验证。
        return UserModel.class.isAssignableFrom(zlass);
        // return false;
    }

    @Override
    public void validate(Object object, Errors errors)
    {
        UserModel userVO = (UserModel) object;
        ValidationUtils.rejectIfEmpty(errors, "name", "user.name.required", "name的内容不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.required", "password的内容不能为空");

        int length = userVO.getUsername().length();
        if (length > NumberEnum.NUMBER_20.getNum())
        {
            errors.rejectValue("name", "user.name.too_long", "用户名不能超过{20}个字符");
        }
        length = userVO.getPwd().length();
        if (length < NumberEnum.NUMBER_6.getNum())
        {
            errors.rejectValue("password", "user.password.too_short", "密码太短，不能少于{6}个字符");
        }
        else if (length > NumberEnum.NUMBER_20.getNum())
        {
            errors.rejectValue("password", "user.password.too_long", "密码太长，不能长于{20}个字符");
        }
    }
}
