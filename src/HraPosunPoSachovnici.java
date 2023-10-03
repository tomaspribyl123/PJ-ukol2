import java.util.Scanner;

public class HraPosunPoSachovnici {
    private int x;
    private int y;
    private Smer[] historiePohybu;
    private int pocetKroku;
    private int nx; // Počet řádků šachovnice
    private int ny; // Počet sloupců šachovnice

    public HraPosunPoSachovnici(int nx, int ny) {
        this.x = 0;
        this.y = 0;
        this.nx = nx;
        this.ny = ny;
        this.historiePohybu = new Smer[nx * ny]; // Maximální délka historie
        this.pocetKroku = 0;
    }

    public void posun(Smer smer) {
        int novaX = x;
        int novaY = y;

        switch (smer) {
            case LEFT:
                novaX--;
                break;
            case RIGHT:
                novaX++;
                break;
            case UP:
                novaY--;
                break;
            case DOWN:
                novaY++;
                break;
        }

        // Kontrola, zda nová pozice je stále na šachovnici

        if (novaX >= 0 && novaX < nx && novaY >= 0 && novaY < ny) {
            // Pokud ano, provedeme posun
            x = novaX;
            y = novaY;

            // Přidání směru do historie pohybu
            historiePohybu[pocetKroku] = smer;
            pocetKroku++;
        } else {
            System.out.println("Nelze provést tento posun, jste na okraji šachovnice.");
        }
    }


    public void tiskniHistoriiPohybu() {


        System.out.println("Historie pohybu:");
        for (int i = 0; i < pocetKroku; i++) {
            System.out.println(historiePohybu[i]);
        }

        System.out.println("Šachovnice s aktuálním bodem:");

        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                if (i == y && j == x) {
                    System.out.print("X "); // Aktuální pozice
                } else {
                    System.out.print(". "); // Prázdná pozice
                }
            }
            System.out.println(); // Nový řádek pro další řádek šachovnice
        }
    }


        public int getX () {
            return x;
        }

        public int getY () {
            return y;
        }
    }

