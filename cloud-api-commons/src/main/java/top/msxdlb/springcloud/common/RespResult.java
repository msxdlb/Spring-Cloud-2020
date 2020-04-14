package top.msxdlb.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Lb on 2020/4/14
 * 统一化返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespResult<T> {

    private Integer code;
    private String message;
    private T data;

    public static RespResult success() {
        return new RespResult(RespResultEnum.SUCCESS);
    }

    public static <T> RespResult<T> success(T t) {
        return new RespResult(RespResultEnum.SUCCESS, t);
    }

    public static <T> RespResult<T> success(RespResultEnum respResultEnum) {
        return new RespResult(respResultEnum);
    }

    public static <T> RespResult<T> error(RespResultEnum respResultEnum) {
        return new RespResult(respResultEnum);
    }

    public static <T> RespResult<T> error(Integer code, String message) {
        return new RespResult<>(code, message);
    }

    public RespResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespResult(RespResultEnum respResultEnum) {
        this.code = respResultEnum.getCode();
        this.message = respResultEnum.getMessage();
    }

    public RespResult(RespResultEnum respResultEnum, T data) {
        this.code = respResultEnum.getCode();
        this.message = respResultEnum.getMessage();
        this.data = data;
    }
}
