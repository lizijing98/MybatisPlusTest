package com.example.mybatisplustest.result;

/**
 * <p> 异常结果枚举 </p>
 *
 * @author LiZijing
 * @className ErrorEnum
 * @date 2021/9/6
 */
public enum ResultEnum implements ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    RESOURCE_NOT_FOUND(404, "找不到资源"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403, "没有操作权限");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
