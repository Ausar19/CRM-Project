import Classes.Account;
import Classes.Contact;
import Classes.Enums.Industry;
import Classes.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AccountTests {

    @BeforeEach
    void setUp() {
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList = new ArrayList<>();
        Account expected = new Account(Industry.MEDICAL, 123, "Paris", "France", contactList, opportunityList);
    }

    @Test
    void testLoopUp() {

        assertThrows(RuntimeException.class, () -> Account.lookUpAccount(3));

    }


}
