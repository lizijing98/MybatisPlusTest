package com.example.mybatisplustest.result;

import lombok.Data;

/**
 * <p> 统一返回结果类 </p>
 *
 * @author LiZijing
 * @className CommonResult
 * @date 2021/9/6
 */
@Data
public class CommonResult<T> {
    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * <p> 成功返回结果 </p>
     *
     * @param date 获取的数据
     * @author LiZijing
     * @data 2021/9/6
     */
    public static <T> CommonResult<T> success(T date) {
        return new CommonResult<T>(true, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), date);
    }

    /**
     * <p> 错误返回结果 </p>
     *
     * @param date 获取的数据
     * @author LiZijing
     * @data 2021/9/6
     */
    public static <T> CommonResult<T> failed(T date) {
        return new CommonResult<T>(false, ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), date);
    }
}
