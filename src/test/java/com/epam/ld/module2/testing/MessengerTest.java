package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.mailserver.ConsoleMailServer;
import com.epam.ld.module2.testing.mailserver.FileMailServer;
import com.epam.ld.module2.testing.template.Template;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}
