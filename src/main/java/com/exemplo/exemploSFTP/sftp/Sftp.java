package com.exemplo.exemploSFTP.sftp;

import org.springframework.core.io.FileSystemResource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

import java.io.IOException;
import java.io.InputStream;

public class Sftp {

    private DefaultSftpSessionFactory getFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        factory.setHost("0.0.0.0");
        factory.setPort(22);
        factory.setUser("foo");
        factory.setPassword("pass");
        factory.setAllowUnknownKeys(true);
        //factory.setKnownHostsResource(new FileSystemResource("known_hosts"));
        return factory;
    }


    public void upload(InputStream inputStream, String filePath, String fileName) throws IOException {
        try (SftpSession session = getFactory().getSession()) {
            session.write(inputStream,filePath + "/" + fileName);
        }
    }
}
