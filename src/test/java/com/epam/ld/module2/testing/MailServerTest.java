package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.mailserver.FileMailServer;
import com.epam.ld.module2.testing.mailserver.MailServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MailServerTest {

    @TempDir File tmpDir;

    @Test
    public void testReadFromFile() throws IOException {
        File templateFile = new File(tmpDir, "template.txt");
        File outputFile = new File(tmpDir, "output.txt");
        List<String> lines =Arrays.asList("Subject: ${subject}", "Body: ${body}");
        Files.write(templateFile.toPath(), lines);
        FileMailServer fileMailServer = new FileMailServer(templateFile, outputFile);

        assertEquals("Subject: ${subject}\nBody: ${body}", fileMailServer.readTemplate().getTemplate());
    }

    @Test
    public void testReadTemplateShouldBeCalled() {
        Messenger.main(new String[] {"inputFile", "outputFile"});
        Messenger.messenger.setMailServer(mock(MailServer.class));
        Messenger.messenger.run();

        verify(Messenger.messenger.getMailServer()).readTemplate();
    }
}
