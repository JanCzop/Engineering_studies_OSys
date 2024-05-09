import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int iloscStron = 10000;
    private static int zakresPrzestrzeni = 1000;
    private static int iloscTestow = 10;
    private static int[] iloscRamek = new int[iloscTestow];

    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < iloscRamek.length; i++){
            iloscRamek[i] = random.nextInt(10)+1;
        }

        int wirtualna=1000; int ramki=3;
        ArrayList<Strona> lista = new ArrayList<>();
        lista.add(new Strona(1));
        lista.add(new Strona(2));
        lista.add(new Strona(3));
        lista.add(new Strona(4));
        lista.add(new Strona(1));
        lista.add(new Strona(2));
        lista.add(new Strona(5));
        lista.add(new Strona(1));
        lista.add(new Strona(2));
        lista.add(new Strona(3));
        lista.add(new Strona(4));
        lista.add(new Strona(5));

        Algorytmy alg = new Algorytmy(ramki, lista);
        System.out.println(alg.FIFO());



        System.out.println();
        System.out.println();




        ArrayList<Strona> strony = Generator.prymitywnyGenerator(iloscStron, zakresPrzestrzeni);
        double sredniaFIFO = 0;
        double sredniaOPT = 0;
        double sredniaRAND = 0;
        double sredniaLRU = 0;
        double sredniaSCA = 0;


        for (int i = 0; i < iloscTestow; i++) {

            Algorytmy algorytmy = new Algorytmy(iloscRamek[i], strony);

            double FIFO = algorytmy.FIFO();
            double OPT = algorytmy.OPT();
            double RAND =algorytmy.RAND();
            double LRU =algorytmy.LRU();
            double SCA = algorytmy.SCA();

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