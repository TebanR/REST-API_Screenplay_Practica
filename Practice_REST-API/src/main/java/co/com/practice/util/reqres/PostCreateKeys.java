package co.com.practice.util.reqres;

public enum PostCreateKeys {
    NAME("[name]"),
    JOB("[job]");

    private final String value;

    PostCreateKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
