package com.epam.ld.module2.testing.mailserver;

import com.epam.ld.module2.testing.template.Template;

public interface MailServer {
    void send(String addresses, String messageContent);
    Template readTemplate();
    String[] readValue();
}
