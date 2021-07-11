package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        String content = template.getTemplate();
        System.out.println("content: " + content);
        content = content.replace("${subject}", client.getSubject());

        System.out.println("content: " + content);
        content = content.replace("${body}", client.getBody());

        System.out.println("content: " + content);
        content = content.replace("${signature}", client.getSignature());
        System.out.println("content: " + content);
        return content;
    }
}
