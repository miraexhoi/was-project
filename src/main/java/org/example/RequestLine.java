package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method; // GET
    private final String urlPath; // /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
    private String queryString;

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    // GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
    public RequestLine(String requestLine) {
        // GET <= tokens
        // /calculate? <= urlPath
        // operand1=11&operator=*&operand2=55 <= queryString
        // HTTP/1.1

        String[] tokens = requestLine.split(" ");
        this.method = tokens[0]; // http 메소드
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        // 즉 query 스트링이 있다면
        if (urlPathTokens.length == 2) {
            this.queryString = urlPathTokens[1];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
