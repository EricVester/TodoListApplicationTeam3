package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.HTTPUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HTTPUtilsTest {

    HTTPUtils httpUtils;

    @BeforeEach
    void setup() {
        httpUtils = new HTTPUtils("team3");
    }

    @Test // ONLY works when time is set to "now (for test)". Set time back to "time" variable otherwise!
    void addTodoItemTest() throws IOException {
        var string = httpUtils.addTodoItem("Team 3 Test", "4/20");
        var expected = "{\n" +
                "  \"title\": \"Team 3 Test\",\n" +
                "  \"deadline\": \"4/20\",\n" +
                "  \"owner\": \"team3\",\n" +
                "  \"time created\": \"TIME ENTER HERE\",\n" +
                "  \"id\": 7\n" +
                "}";
        assertEquals(expected, string);
    }

    @Test
    void deleteTodoItemByTitleTest() throws IOException {
        httpUtils.addTodoItem("Delete Item Test.", "4/21");
        assertTrue(httpUtils.deleteTodoItemByTitle("Delete Item Test."));
    }

    @Test
    void getTodoItemByTitleTest() throws IOException {
        httpUtils.addTodoItem("Get Item by Title Test", "4/21");
        String expectedTitle = httpUtils.getTodoItemByTitle("Get Item by Title Test").getTitle();
        assertEquals("Get Item by Title Test", expectedTitle);
        httpUtils.deleteTodoItemByTitle("Get Item by Title Test");
    }
}