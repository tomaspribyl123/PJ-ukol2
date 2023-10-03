import java.util.Scanner;

 public class RealizaceHryKonzola {
     public void start(){
     Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte výšku šachovnice (nx): ");
     int nx = scanner.nextInt();
        System.out.print("Zadejte šířku šachovnice (ny): ");
     int ny = scanner.nextInt();

     HraPosunPoSachovnici hra = new HraPosunPoSachovnici(nx, ny);

     char volba;
        do {
         System.out.println("Aktuální poloha: [" + hra.getX() + ", " + hra.getY() + "]");
         System.out.println("Zvolte akci: (L)eft, (R)ight, (U)p, (D)own, (K)onec:");
         volba = scanner.next().charAt(0);

         switch (Character.toUpperCase(volba)) {
             case 'L':
                 hra.posun(Smer.LEFT);
                 break;
             case 'R':
                 hra.posun(Smer.RIGHT);
                 break;
             case 'U':
                 hra.posun(Smer.UP);
                 break;
             case 'D':
                 hra.posun(Smer.DOWN);
                 break;
             case 'K':
                 System.out.println("Konec hry.");
                 break;
             default:
                 System.out.println("Neplatná volba.");
         }

         hra.tiskniHistoriiPohybu();
     } while (Character.toUpperCase(volba) != 'K');

        scanner.close();
    }
}
