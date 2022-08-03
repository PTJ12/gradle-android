/**
 * Copyright 2022 bejson.com
 */
package cn.ut.application.Entity;

/**
 * Auto-generated: 2022-07-30 23:42:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BaseEntity<T> {

    private int code;
    private String message;
    private T object;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setObject(T object) {
        this.object = object;
    }
    public T getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}