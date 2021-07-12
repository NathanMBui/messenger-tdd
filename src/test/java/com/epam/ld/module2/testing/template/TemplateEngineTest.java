package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemplateEngineTest {

    private Template template;
    private Client client;
    private TemplateEngine engine;

    @BeforeEach
    public void setup() {
        template = new Template("Subject: ${subject}\n\nBody: ${body}\n\nSignature: ${signature}");
        client = new Client("abc@xyz.com");
        engine = new TemplateEngine();
    }

    @Test
    public void testGenerateMessage() {
        client.setSubject("aSubject");
        client.setBody("aBody");
        client.setSignature("aSignature");

        String message = engine.generateMessage(template, client);

        assertEquals("Subject: aSubject\n\nBody: aBody\n\nSignature: aSignature", message);
    }

    @Test
    public void testThrowExceptionWhenAtLeastOnePlaceHolderValueNotProvided() {
        client.setSubject("aSubject");
        client.setBody("aBody");

        assertThrows(IllegalArgumentException.class,
                () -> engine.generateMessage(template, client),
                "Expected generateMessage() to throw, but it didn't");
    }
}
