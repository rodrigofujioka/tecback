package br.com.fujideia.iesp.tecback.exception;

public class FujiException {
    private String field;
    private String message;

    public FujiException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
