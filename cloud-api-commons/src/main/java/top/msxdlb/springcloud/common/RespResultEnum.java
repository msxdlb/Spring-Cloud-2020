package top.msxdlb.springcloud.common;

/**
 * Created by Lb on 2020/4/14
 * 错误码 10000 ~ 10050
 */
public enum RespResultEnum {

    SUCCESS(200, "成功"),
    ERROR(10000, "网官错误"),
    ADD_SUCCESS(10001, "添加成功"),
    ADD_ERROR(10002, "添加失败"),
    UPDATE_SUCCESS(10003, "跟新成功"),
    UPDATE_ERROR(10004, "跟新失败"),
    SEARCH_SUCCESS(10005, "查询成功"),
    SEARCH_ERROR(10006, "查询失败"),
    DELETE_SUCCESS(10007, "删除成功"),
    DELETE_ERROR(10008, "删除失败"),
    DATABASE_ERROR(10005, "数据库内部错误"),
    INTERNAL_ERROR(10006, "内部错误");

    private Integer code;
    private String message;

    RespResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
