// https://developers.redhat.com/articles/2022/03/03/rest-api-error-modeling-quarkus-20#constraintviolationexceptionmapper

package org.acme.rest.client;

public class CorreiosException extends RuntimeException {

    private int code;
    private String reason;

    public CorreiosException() {
        
    }

    public CorreiosException(String errorMsg) {
        super(errorMsg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "CorreiosException [code=" + code + ", reason=" + reason + "]";
    }
}
