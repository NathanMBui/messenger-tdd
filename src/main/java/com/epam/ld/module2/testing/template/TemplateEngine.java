package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.util.StringUtils;

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
        validate(client, template);
        String content = template.getTemplate();
        content = content.replace("${subject}", client.getSubject());
        content = content.replace("${body}", client.getBody());
        content = content.replace("${signature}", client.getSignature());
        return content;
    }

    public void validate(Client client, Template template) {
        if ((template.getTemplate().contains("${subject}") && StringUtils.isNullOrEmpty(client.getSubject())
        || (template.getTemplate().contains("${body}") && StringUtils.isNullOrEmpty(client.getBody())
        || (template.getTemplate().contains("${signature}") && StringUtils.isNullOrEmpty(client.getSignature()))))) {
            throw new IllegalArgumentException("At least one value is not provided");
        }
    }
}
