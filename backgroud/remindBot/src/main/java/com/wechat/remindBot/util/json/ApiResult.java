package com.wechat.remindBot.util.json;

/**
 * http 返回值
 *
 * @param <T>
 */
public class ApiResult<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public enum Code {
        OK(0, "操作成功"),
        NOT_MODIFIED(304, "未做修改"),
        BAD_REQUEST(400, "请求参数有误"),
        NOT_FOUND(404, "未找到资源"),
        BILL_STATUS_ALTERED(421, "业务状态已经变更"),
        ERROR(500, "系统异常");

        private Integer code;
        private String message;

        Code(Integer code, String message) {
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

    public ApiResult() {
    }

    private ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <E> Builder<E> newBuilder() {
        return new Builder<>();
    }

    public static <E> ApiResult<E> newSuccessResult() {
        return new ApiResult<>(
                Code.OK.getCode(),
                Code.OK.getMessage(),
                null
        );
    }

    public static <E> ApiResult<E> newSuccessResult(E data) {
        return new ApiResult<>(
                Code.OK.getCode(),
                Code.OK.getMessage(),
                data
        );
    }

    public static <E> ApiResult<E> newFailResult() {
        return new ApiResult<>(
                Code.NOT_MODIFIED.getCode(),
                Code.NOT_MODIFIED.getMessage(),
                null
        );
    }

    public static <E> ApiResult<E> newBadRequest() {
        return new ApiResult<>(
                Code.BAD_REQUEST.getCode(),
                "请求参数有误",
                null
        );
    }

    public static <E> ApiResult<E> newBadRequest(String message) {
        return new ApiResult<>(
                Code.BAD_REQUEST.getCode(),
                message,
                null
        );
    }

    public static <E> ApiResult<E> newServerError() {
        return new ApiResult<>(
                Code.ERROR.getCode(),
                "服务器端错误",
                null
        );
    }

    public static <E> ApiResult<E> newServerError(String message) {
        return new ApiResult<>(
                Code.ERROR.getCode(),
                message,
                null
        );
    }

    public static <E> ApiResult<E> newFailResult(String message) {
        return new ApiResult<>(
                Code.NOT_MODIFIED.getCode(),
                message,
                null
        );
    }

    public static <E> ApiResult<E> newFailOfBillStatusAlteredResult(String message) {
        return new ApiResult<>(
                Code.BILL_STATUS_ALTERED.getCode(),
                null == message ? Code.BILL_STATUS_ALTERED.getMessage() : message,
                null
        );
    }

    public static <E> ApiResult<E> newFailResult(E data) {
        return new ApiResult<>(
                Code.NOT_MODIFIED.getCode(),
                Code.NOT_MODIFIED.getMessage(),
                data
        );
    }

    public static <E> ApiResult<E> newNotFoundResult() {
        return new ApiResult<>(
                Code.NOT_FOUND.getCode(),
                Code.NOT_FOUND.getMessage(),
                null
        );
    }

    public static <E> ApiResult<E> newNotFoundResult(E data) {
        return new ApiResult<>(
                Code.NOT_FOUND.getCode(),
                Code.NOT_FOUND.getMessage(),
                data
        );
    }

    public static final class Builder<T> {
        private Integer code;
        private String message;
        private T data;

        private Builder() {
        }

        private Builder(Integer code, String message, T data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResult<T> build() {
            ApiResult<T> baseResult = new ApiResult<>();
            baseResult.setCode(code);
            baseResult.setMessage(message);
            baseResult.setData(data);
            return baseResult;
        }
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
