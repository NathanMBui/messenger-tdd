package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TemplateEngineTest {

    @Test
    public void testGenerateMessage() {
        Template template = new Template("Subject: ${subject}\n\nBody: {body}\n\nSignature: ${signature}", "${", "}");
        Client client = new Client("abc@xyz.com");
        client.setSubject("aSubject");
        client.setBody("aBody");
        client.setSignature("aSignature");
        TemplateEngine engine = new TemplateEngine();
        String message = engine.generateMessage(template, client);

        assertEquals("Subject: aSubject\n\nBody: aBody\n\nSignature: aSignature", message);
    }
}
