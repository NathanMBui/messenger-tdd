package com.epam.ld.module2.testing.mailserver;

public interface MailServer {
    void send(String addresses, String messageContent);
}
