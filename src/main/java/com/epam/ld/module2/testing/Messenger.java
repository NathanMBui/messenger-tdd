package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.mailserver.ConsoleMailServer;
import com.epam.ld.module2.testing.mailserver.FileMailServer;
import com.epam.ld.module2.testing.mailserver.MailServer;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.File;

/**
 * The type Messenger.
 */
public class Messenger {
    public static Messenger messenger;

    private MailServer mailServer;
    private TemplateEngine templateEngine;

    /**
     * Instantiates a new Messenger.
     *
     * @param mailServer     the mail server
     * @param templateEngine the template engine
     */
    public Messenger(MailServer mailServer,
                     TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /**
     * Send message.
     *
     * @param client   the client
     * @param template the template
     */
    public void sendMessage(Client client, Template template) {
        String messageContent =
            templateEngine.generateMessage(template, client);
        mailServer.send(client.getAddresses(), messageContent);
    }

    public static void main(String[] args) {
        MailServer mailServer;
        if (args != null && args.length > 1) {
            String inputFile = args[0];
            String outputFile = args[1];
            mailServer = new FileMailServer(new File(inputFile), new File(outputFile));
        } else {
            mailServer = new ConsoleMailServer();
        }
        messenger = new Messenger(mailServer, new TemplateEngine());
    }

    public void run() {
        Client client = mailServer.readClient();
        Template template = mailServer.readTemplate();
        sendMessage(client, template);
    }

    public MailServer getMailServer() {
        return mailServer;
    }

    public void setMailServer(MailServer mailServer) {
        this.mailServer = mailServer;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}