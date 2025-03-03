package org.example;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Animal {
    private String nome;
    private int id;
    private int idade;
    private String especie;
    private boolean internado;
}
