package com.lts.commen;

/**
 * @description
 * @Author liutiansheng
 * @Email liutiansheng@encdata.cn
 * @Date 2018年01月27日
 */
public enum ResultEnum
{

    OK(200, "成功"),

    BAD_PARAM_REQUEST(802000, "参数错误请求"),

    TOKEN_NOT_EXIST(802900, "token不存在或已过期"),

    INTERNAL_ERROR(802001, "系统错误，请联系管理员"),
    
    NO_TOKEN(802310, "未登录"),
    
    BAD_REQUEST(802400, "错误请求"),
    
    FORBIDDEN(802403, "服务拒绝执行"),
    
    NOT_SUPPORTED(802505, "非法连接"),
    
    PAGE_NOT_FOUND(802404, "页面未找到"),
    
    UNKNOWN(802101, "未知错误"),
    
    FAILE(8029999, "系统错误"),
    
    CAPTCHA_FAIL(8029998, "验证码错误"),
    
    LOGIN_FALL(8029997, "用户名或密码错误"),

    WAP_LOGIN_CAPTCHA(8029996, "用户名或密码错误"),
    
    THIRD_PARTY_FAILE(8029000, "第三方接口错误"),
    
    DATA_NO_EXISTS(8029995, "数据记录不存在"),

    REDIS_ERROR(802602, "redis操作错误"),

    REMOTE_VALIDATE_ERROR(802607, "调用认证中心出错"),

    HAVE_VALUE(802999, "没有此条数据请重新请求。");

    private Integer code;
    
    private String desc;// 描述
    
    private ResultEnum(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    public String getDesc()
    {
        
        return desc;
    }
    
    public void setDesc(String desc)
    {
        
        this.desc = desc;
    }
    
    public Integer getCode()
    {
        return code;
    }
    
    public String getStrCode()
    {
        return code.toString();
    }
}
