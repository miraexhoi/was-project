package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    private List<QueryString> queryStrings;
    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55"); // List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
