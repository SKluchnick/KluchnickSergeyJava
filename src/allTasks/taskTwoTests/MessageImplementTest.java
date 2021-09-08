package allTasks.taskTwoTests;

import allTasks.taskTwo.MessageImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MessageImplementTest {

    MessageImplement messageImplement = new MessageImplement();


    @ParameterizedTest
    @ValueSource(strings = {"25"})
    void checkInput(String strings) {
        try {
            messageImplement.checkInputFirst(strings);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Must be only letters", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void checkInputTwo(String strings) {
        try {
            String result = messageImplement.checkInputFirst(strings);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Must be only letters", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello"})
    void checkInputThree(String strings) {
        String result = messageImplement.checkInputFirst(strings);
        Assertions.assertEquals("Hello", result);

    }

    @ParameterizedTest
    @ValueSource(strings = {"y", "k"})
    void isContinue(String strings) {
        boolean flag = messageImplement.isContinue(strings);
        assertTrue(flag);
    }
}