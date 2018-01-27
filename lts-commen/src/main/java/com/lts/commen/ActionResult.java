package com.lts.commen;




import java.io.Serializable;

/**
 * @description
 * @Author liutiansheng
 * @Email liutiansheng@encdata.cn
 * @Date 2018年01月27日
 */
public class ActionResult<T> implements Serializable {

    private int code = ResultEnum.OK.getCode();
    private String message = ResultEnum.OK.getDesc();
    private T data;
    
    public ActionResult() {
        super();
    }

    public ActionResult(T data) {
        super();
        this.data = data;
    }

    public ActionResult(ResultEnum actionResultEnum) {
        super();
        this.code = actionResultEnum.getCode();
        this.message = actionResultEnum.getDesc();
    }

    public ActionResult(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ActionResult(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ActionResult(ResultEnum actionResultEnum, T data) {
        super();
        this.code = actionResultEnum.getCode();
        this.message = actionResultEnum.getDesc();
        this.data = data;
    }

    public ActionResult(ResultEnum codeEnum, String message, T data) {
        super();
        this.code = codeEnum.getCode();
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

	@Override
    public String toString() {
        return "ActionResult [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}
