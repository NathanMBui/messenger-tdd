package com.epam.ld.module2.testing.mailserver;

import com.epam.ld.module2.testing.template.Template;

import java.io.File;

public class FileMailServer implements MailServer {

    public FileMailServer(File inputFile, File outputFile) {

    }

    @Override
    public void send(String addresses, String messageContent) {

    }

    @Override
    public Template readTemplate() {
        return new Template("Subject: ${subject}\nBody: ${body}");
    }

    @Override
    public String[] readValue() {
        return new String[0];
    }
}
