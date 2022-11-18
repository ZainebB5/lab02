package com.example.junit.servicesTest;


import com.example.junit.services.MessageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {
    private final MessageService service =new MessageService();

    @DisplayName("Testing MessageService.getAll()")
    @Test

    void getAll() {

        Integer actual = 100;
        Integer expected = service.getAll().size();
        assertEquals(expected, actual);
    }
    @DisplayName("Testing MessageService.getByFrom()")
    @Test
    void shouldFailWhenFromIsNull() {

        Executable instruction = () -> {
            service.getByFrom(null);
        };
        assertThrows(IllegalArgumentException.class, instruction);
    }
   /* @DisplayName("Testing MessageService.getByFrom()")
    @Test
    void shouldSuccedWhenFromDontContainarobase() {

        Executable instruction = () -> {
            service.getByFrom("@mail.be");
        };
        assertThrows(IllegalArgumentException.class, instruction);
    }

    @DisplayName("Testing MessageService.getToFrom()")
    @Test
    void shouldFailWhenToIsNull() {

        String mock1 = "Message: {" + "\n" +
                "null" + "F1" + "\n" +
                "To: " + "T1" + "\n" +
                "Header: " + "H1" + "\n" +
                "Body" + "B1" + "\n" + "}";
        String mock2 = "Message: {" + "\n" +
                "From: " + "F2" + "\n" +
                "To: " + "T2" + "\n" +
                "Header: " + "H2" + "\n" +
                "Body" + "B2" + "\n" + "}";
        String[] actual = new String[]{
                mock1,mock2
        };
        Executable instruction = () -> {
            service.getByFrom(mock1);
        };
        assertThrows(IllegalArgumentException.class, instruction);
    }*/
}