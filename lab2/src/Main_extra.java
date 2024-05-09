import java.util.ArrayList;

public class Main_extra {

    public static void main(String[] args) {
        int maksymalnyCzasPrzybycia = 100;
        int iloscZadan = 1000;
        int iloscBlokow = 200;
        int maksymalnyDeadline = 1000;
        int procentRealTime = 20;
        int iloscCykli = 100;


        int sumaFCFS_EDF = 0;
        int sumaFCFS_FD = 0;
        int sumaSSTF_EDF = 0;
        int sumaSSTF_FD = 0;
        int sumaSCAN_EDF = 0;
        int sumaSCAN_FD = 0;
        int sumaC_SCAN_EDF = 0;
        int sumaC_SCAN_FD = 0;

        Generator generatorZadan = new Generator();
        for (int i = 0; i < iloscCykli; i++) {
            ArrayList<Zadanie> listaZadan = generatorZadan.generujZadania(iloscZadan, maksymalnyDeadline, maksymalnyCzasPrzybycia, iloscBlokow, procentRealTime);

            Dysk_extra dysk = new Dysk_extra(iloscBlokow, listaZadan);
            /*
            sumaFCFS_EDF += dysk.obliczIloscPrzemieszczen("FCFS","EDF");
            sumaFCFS_FD += dysk.obliczIloscPrzemieszczen("FCFS","FD_SCAN");
            sumaSSTF_EDF += dysk.obliczIloscPrzemieszczen("SSTF","EDF");
            sumaSSTF_FD += dysk.obliczIloscPrzemieszczen("SSTF","FD_SCAN");
            sumaSCAN_EDF += dysk.obliczIloscPrzemieszczen("SCAN","EDF");
            sumaSCAN_FD += dysk.obliczIloscPrzemieszczen("SCAN","FD_SCAN");
            sumaC_SCAN_EDF += dysk.obliczIloscPrzemieszczen("C_SCAN","EDF");
            sumaC_SCAN_FD += dysk.obliczIloscPrzemieszczen("C_SCAN","FD_SCAN");
            */
            sumaFCFS_EDF = dysk.obliczFCFS_EDF();
            sumaFCFS_FD = dysk.obliczFCFS_FD_SCAN();
            sumaSSTF_EDF = dysk.obliczSSTF_EDF();
            sumaSSTF_FD = dysk.obliczSSTF_FD_SCAN();
            sumaSCAN_EDF = dysk.obliczSCAN_EDF();
            sumaSCAN_FD = dysk.obliczSCAN_FD_SCAN();
            sumaC_SCAN_EDF = dysk.obliczC_SCAN_EDF();
            sumaC_SCAN_FD = dysk.obliczC_SCAN_FD_SCAN();

        }
        System.out.println("------------------------------");
        System.out.println("--------Średnie wyniki--------");
        System.out.println("------------------------------");
        System.out.println("FCFS_EDF   : " + sumaFCFS_EDF / iloscCykli);
        System.out.println("FCFS_FD    : " + sumaFCFS_FD / iloscCykli);
        System.out.println("------------------------------");
        System.out.println("SSTF_EDF   : " + sumaSSTF_EDF / iloscCykli);
        System.out.println("SSTF_FD    : " + sumaSSTF_FD / iloscCykli);
        System.out.println("------------------------------");
        System.out.println("SCAN_EDF   : " + sumaSCAN_EDF / iloscCykli);
        System.out.println("SCAN_FD    : " + sumaSCAN_FD / iloscCykli);
        System.out.println("------------------------------");
        System.out.println("C_SCAN_EDF : " + sumaC_SCAN_EDF / iloscCykli);
        System.out.println("C_SCAN_FD  : " + sumaC_SCAN_FD / iloscCykli);


    }

}
