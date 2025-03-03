package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteClinicaVeterinaria {
    private Animal a1;
    private Animal a2;
    private Animal a3;
    private ClinicaVeterinaria clinica;

    @Before
    public void setUp() {
        clinica = new ClinicaVeterinaria();

        a1 = Animal.builder()
                .nome("Sushi")
                .id(2)
                .idade(1)
                .especie("Gato")
                .internado(true)
                .build();

        a2 = Animal.builder()
                .nome("Max")
                .id(24)
                .idade(2)
                .especie("Cachorro")
                .internado(false)
                .build();

        a3 = Animal.builder()
                .nome("Fumaça")
                .id(23)
                .idade(3)
                .especie("Gato")
                .internado(true)
                .build();
    }

    @Test
    public void verificaCadastroDeUmAnimal() {
        Assert.assertEquals(0, clinica.getTotalAnimais());
        // Caso de Uso: Cadastro de um animal
        // Entrada:  .nome("Sushi")
        //                .id(2)
        //                .idade(1)
        //                .especie("Gato")
        //                .internado(true)
        //
        // Saída esperada: O total de animais na clínica deve ser 1

        clinica.cadastrarAnimal(a1);
        Assert.assertEquals(1, clinica.getTotalAnimais());
    }

    @Test
    public void verificaCadastroDeTresAnimais() {
        // Caso de Uso: Cadastro dos animais
        // Entrada: dados de a1, a2 e a3
        //
        // Saída esperada: O total de animais na clínica deve ser 3
        Assert.assertEquals(0, clinica.getTotalAnimais());
        clinica.cadastrarAnimal(a1);
        Assert.assertEquals(1, clinica.getTotalAnimais());
        clinica.cadastrarAnimal(a2);
        Assert.assertEquals(2, clinica.getTotalAnimais());
        clinica.cadastrarAnimal(a3);
        Assert.assertEquals(3, clinica.getTotalAnimais());
    }

    @Test
    public void verificaAltaAnimal() {
        // Caso de Uso: Dar alta para animal
        // Entrada: ID do animal
        //
        // Saída esperada: retorna true
        clinica.cadastrarAnimal(a1);
        clinica.cadastrarAnimal(a2);
        clinica.cadastrarAnimal(a3);

        Assert.assertTrue(clinica.darAlta(2));

    }

    @Test
    public void verificaCadastroProcedimento() {

        // Caso de Uso: Cadastro do procedimento
        // Entrada: ID: 1, Animal ID: 2, nomeProcedimento: "Vacina aplicada"
        // Saída esperada: O total de procedimentos deve ser 1

        Procedimento proc = new Procedimento(1, 2, "Vacina aplicada");
        clinica.cadastrarProcedimento(proc);
        Assert.assertEquals(1, clinica.getTotalProcedimentos());
    }


    @Test
    public void verificaListagemProcedimentosPorAnimal() {
        // Caso de Uso: Listar procedimentos de um animal solicitado
        // Entrada: Procedimentos cadastrados para animais ID 2 e 24

        // - Animal ID 2 deve ter 2 procedimentos registrados
        // - Animal ID 24 deve ter 1 procedimento registrado
        // - Animal ID 99 (inexistente) deve ter 0 procedimentos registrados

        clinica.cadastrarProcedimento(new Procedimento(1, 2, "Vacina"));
        clinica.cadastrarProcedimento(new Procedimento(2, 2, "Exame"));
        clinica.cadastrarProcedimento(new Procedimento(3, 24, "Castração"));


    }
}