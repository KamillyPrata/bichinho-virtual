import java.util.*;

class Bichinho {
    private String nome;
    private int fome;
    private int energia;
    private int felicidade;

    public Bichinho(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.energia = 50;
        this.felicidade = 50;
    }

    private int limitar(int valor) {
        return Math.max(0, Math.min(100, valor));
    }

    public void alimentar() {
        fome = limitar(fome - 30);
        felicidade = limitar(felicidade + 5);
    }

    public void dormir() {
        energia = 100;
        fome = limitar(fome + 20);
    }

    public boolean estaFeliz() {
        return felicidade >= 70;
    }

    public boolean estaDoente() {
        return fome == 100;
    }

    public void brincar() {
        if (estaDoente()) {
            System.out.println(nome + " está doente e se recusa a brincar.");
            return;
        }
        felicidade = limitar(felicidade + 20);
        energia = limitar(energia - 15);
        fome = limitar(fome + 10);
    }

    public void status() {
        System.out.println("===" + nome + " ===");
        System.out.println("Fome: " + fome);
        System.out.println("Energia: " + energia);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Feliz? " + (estaFeliz() ? "Sim" : "Não"));
        if (estaDoente()) {
            System.out.println("Está doente!");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Bichinho pet = new Bichinho("Tobi");

        System.out.println("Manhã:");
        pet.status();

        pet.alimentar();
        pet.brincar();
        System.out.println("Depois de comer e brincar:");
        pet.status();

        pet.dormir();
        System.out.println("Depois da soneca:");
        pet.status();

        // Teste do limite: alimentar várias vezes, fome nunca fica negativa
        for (int i = 0; i < 5; i++) {
            pet.alimentar();
        }
        System.out.println("Depois de comer muito (fome deve parar em 0):");
        pet.status();

        // Teste do bônus: fome chega a 100, fica doente e recusa brincar
        for (int i = 0; i < 6; i++) {
            pet.dormir();
        }
        System.out.println("Depois de ficar sem comer (fome 100):");
        pet.brincar();
        pet.status();
    }
}