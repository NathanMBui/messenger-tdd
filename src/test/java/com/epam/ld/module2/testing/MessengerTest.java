package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.mailserver.ConsoleMailServer;
import com.epam.ld.module2.testing.mailserver.FileMailServer;
import com.epam.ld.module2.testing.mailserver.MailServer;
import com.epam.ld.module2.testing.template.Template;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MessengerTest {

    @Test
    public void testConsoleMode() {
        Messenger.main(null);
        assertTrue(Messenger.messenger.getMailServer() instanceof ConsoleMailServer);
    }

    @Test
    public void testFileMode() {
        Messenger.main(new String[] {"inputFile", "outputFile"});
        assertTrue(Messenger.messenger.getMailServer() instanceof FileMailServer);
    }

    @Test
    public void testSendWithSpy() {
        MailServer mailServer = spy(MailServer.class);
        Template fakeTemplate = new Template("Body: ${body}");
        when(mailServer.readTemplate()).thenReturn(fakeTemplate);

        assertEquals(fakeTemplate, mailServer.readTemplate());
    }
}
