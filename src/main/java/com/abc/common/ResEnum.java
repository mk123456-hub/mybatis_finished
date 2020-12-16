package com.abc.common;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 20:41
 */
public enum ResEnum {
    //枚举表示一种规范
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_DEL_BATCH(202,"delete batch success"),
    ERROR_USER_EXIST(501,"user exist error"),
    ERROR_PARAMS_IN_DELBATCH(501,"param can't be null"),
    ERROR(500,"error");

    private int status;
    private String msg;

    ResEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
