package allTasks.taskOneTests;

import allTasks.taskOne.MessageImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MessageImplementTest {

    MessageImplement messageImplement = new MessageImplement();


    @ParameterizedTest
    @ValueSource(strings = {"7"})
    void checkInput(String strings) {
        int result = messageImplement.checkInput(strings);
        Assertions.assertEquals(7, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A"})
    void checkInputSecond(String strings) {
        int result = messageImplement.checkInput(strings);
        Assertions.assertEquals(0, result);
    }


    @ParameterizedTest
    @ValueSource(strings = {"y", "k"})
    void isContinue(String strings) {
        boolean flag = messageImplement.isContinue(strings);
        assertTrue(flag);
    }
}