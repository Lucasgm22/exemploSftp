package com.exemplo.exemploSFTP.sftp;

import com.exemplo.exemploSFTP.objetos.Aluno;
import com.exemplo.exemploSFTP.utils.CSVUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SftpTest {

    @Test
    void upload() throws IOException {

        Aluno[] alunos = new Aluno[]{
                new Aluno(1,"Miguel","Arte",10),
                new Aluno(2, "Rafael", "Medicina", 9),
                new Aluno(3, "Gabriel", "Filosofia", 7),
                new Aluno(4, "Lucas", "Matematica", 2)
        };

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(Aluno.CSV_HEADER.getBytes(StandardCharsets.UTF_8));


        for (int i = 0; i < 4; i++ )
            baos.write(CSVUtils.stringArrayToCsvLine(alunos[i].toStringArray()).getBytes(StandardCharsets.UTF_8));

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        new Sftp().upload(inputStream,"upload", "alunos" + LocalDateTime.now() + ".txt" );
    }
}