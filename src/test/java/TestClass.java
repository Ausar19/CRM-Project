
import Lead.Lead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass {

    // Lead Class convertID method tests
    @Test
    @DisplayName("Must return an exception ")
    void exceptionTest_convertId(){
        assertThrows(InputMismatchException.class, () -> Lead.convertID(1));
    }
}
