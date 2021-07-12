package com.epam.ld.module2.testing.mailserver;

import com.epam.ld.module2.testing.template.Template;

/**
 * Mail server class.
 */
public class ConsoleMailServer implements MailServer {

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    @Override
    public void send(String addresses, String messageContent) {

    }

    @Override
    public Template readTemplate() {
        return null;
    }

    @Override
    public String[] readValue() {
        return new String[0];
    }
}
