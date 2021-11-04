package com.exemplo.exemploSFTP.objetos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Aluno {

    private Integer id;
    private String nome;
    private String curso;
    private Integer nota;

    public static String CSV_HEADER = "ID;NOME;CURSO;NOTA\n";

    public String[] toStringArray() {
        return new String[]{String.valueOf(id), nome, curso, String.valueOf(nota)};
    }

}
