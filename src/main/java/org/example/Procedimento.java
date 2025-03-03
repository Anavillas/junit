package org.example;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Procedimento {
    private int id;
    private int animalID;
    private String nomeProcedimento;
}
