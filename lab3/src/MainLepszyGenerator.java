import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainLepszyGenerator {

    private static int iloscStron = 10000;
    private static int zakresPrzestrzeni = 100;
    private static int iloscTestow = 10;
    private static int[] iloscRamek = new int[iloscTestow];

    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < iloscRamek.length; i++){
            iloscRamek[i] = 3+10*i;
           // iloscRamek[i] = random.nextInt(5)+1+i;
            //iloscRamek[i] = 200;
        }


        ArrayList<Modyfikacja> modyfikacje = Generator.test2();



        ArrayList<Strona> strony = Generator.generatorPlusModyfikacje(iloscStron, zakresPrzestrzeni, modyfikacje);
     //   for (int i = 0; i < strony.size(); i++){
          //  System.out.println("index=" + i + " " + strony.get(i).nr);
     //   }
        System.out.println("\n\n\n");

        double sredniaFIFO = 0;
        double sredniaOPT = 0;
        double sredniaRAND = 0;
        double sredniaLRU = 0;
        double sredniaSCA = 0;


        for (int i = 0; i < iloscTestow; i++) {

            Algorytmy algorytmy = new Algorytmy(iloscRamek[i], strony);

            int FIFO = algorytmy.FIFO();
            int OPT = algorytmy.OPT();
            int RAND =algorytmy.RAND();
            int LRU =algorytmy.LRU();
            int SCA = algorytmy.SCA();

            System.out.println("FIFO  : " + FIFO );
            System.out.println("OPT   : " + OPT );
            System.out.println("RAND  : " + RAND);
            System.out.println("LRU   : " + LRU );
            System.out.println("SCA   : " + SCA);

            sredniaFIFO+=FIFO;
            sredniaOPT+=OPT;
            sredniaRAND+=RAND;
            sredniaLRU+=LRU;
            sredniaSCA+=SCA;
            System.out.println();

        }
        System.out.println("Srednia ------------");
        System.out.println("FIFO  : " + sredniaFIFO/iloscTestow );
        System.out.println("OPT   : " + sredniaOPT/iloscTestow );
        System.out.println("RAND  : " + sredniaRAND/iloscTestow);
        System.out.println("LRU   : " + sredniaLRU/iloscTestow );
        System.out.println("SCA   : " + sredniaSCA/iloscTestow);

    }
}