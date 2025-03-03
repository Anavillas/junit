package org.example;


import java.util.ArrayList;
import java.util.List;

public class ClinicaVeterinaria {

    private List<Animal> animais = new ArrayList<>();
    private List<Procedimento> procedimentos = new ArrayList<>();

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void cadastrarProcedimento(Procedimento procedimento){
        procedimentos.add(procedimento);
    }

    public int getTotalAnimais() {
        return animais.size();
    }

    public int getTotalProcedimentos() {
        return procedimentos.size();
    }

    public boolean darAlta(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                a.setInternado(false);
                return true;
            }
        }
        return false;
    }


    public Animal buscarAnimalPorId(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }


    public List<Procedimento> listarProcedimentosPorAnimal(int animalId) {
        List<Procedimento> procAnimal = new ArrayList<>();
        for (Procedimento p : procedimentos) {
            if (p.getAnimalID() == animalId) {
                procAnimal.add(p);
            }
        }
        return procAnimal;
    }
}