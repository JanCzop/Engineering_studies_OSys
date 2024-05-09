public class Main {

    public static void main(String[] args) {

        // default test  test(1000,250,10,100,6,110,17);

        test(100,250,10,100,6,110,17);
        test(1000,250,10,100,6,110,17);
        test(10000,250,10,100,6,110,17);
        test(100000,250,10,100,6,110,17);

        test(10000,250,10,100,6,110,17);
        test(10000,1000,10,100,6,110,17);
        test(10000,1000,10,100,6,110,17);

        test(10000,250,10,100,6,110,17);
        test(10000,250,15,100,6,110,17);
        test(10000,250,50,100,6,110,17);

        test(1000,250,10,100,6,110,17);
        test(1000,250,10,50,6,110,17);
        test(1000,250,10,20,6,110,17);

        test(10000,400,10,100,6,25,17);
        test(10000,400,10,100,6,30,17);
        test(10000,400,10,100,6,50,17);
        test(10000,400,10,100,6,80,17);
    }


    public static void test(int strony,int zakres,int procesy, int ramki, int minB, int maxB, int oknoZ){
        int iloscStron = strony;
        int zakresPrzestrzenii = zakres;
        int iloscProcesow = procesy;
        int iloscRamek = ramki;
        int minBlad= minB;
        int maxBlad= maxB;
        int oknoZbioru= oknoZ;

        System.out.println("Ilosc stron:           "+iloscStron);
        System.out.println("Zakres przestrzenii:   "+zakresPrzestrzenii);
        System.out.println("Ilosc procesow:        "+iloscProcesow);
        System.out.println("Ilosc ramek:           "+iloscRamek);
        System.out.println("Minimalny blad:        "+minBlad);
        System.out.println("Maksymalny blad:       "+maxBlad);
        System.out.println("Okno zbioru roboczego: "+oknoZbioru);
        System.out.println();


        Algorytmy a = new Algorytmy(iloscRamek,iloscProcesow,zakresPrzestrzenii,iloscStron);


        System.out.println("Equal:        "+a.equal());
        System.out.println("Proportional: "+a.proportional());
        System.out.println("Steering:     "+a.steering(minBlad,maxBlad));
        System.out.println("Working-Set:  "+a.workingModel(oknoZbioru));
        System.out.println();

    }



}