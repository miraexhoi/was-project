package org.example;

public class QueryString {
    private final String key;
    private final String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // key 존재여부
    public boolean exits(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }
}
