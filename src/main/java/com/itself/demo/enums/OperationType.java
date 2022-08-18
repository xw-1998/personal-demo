package com.itself.demo.enums;

/**
 * @Author xxw
 * @Date 2021/08/17
 */
public enum OperationType {
    /**
     * 操作类型
     */
    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    OperationType(String s){
        this.value = s;
    }
}
