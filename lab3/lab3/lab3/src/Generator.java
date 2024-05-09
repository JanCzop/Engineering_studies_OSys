import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private static Random random = new Random();

    public static ArrayList<Strona> prymitywnyGenerator(int iloscStron, int zakresPrzestrzeni) { // to delete but it was base for another so ill keep it
        ArrayList<Strona> strony = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < iloscStron; i++) {
            int nr = random.nextInt(zakresPrzestrzeni) + 1;
            strony.add(new Strona(nr));
        }
        return strony;
    }

    public static ArrayList<Strona> generatorModyfikacje(int iloscStron, int zakresPrzestrzeni, ArrayList<Modyfikacja> listaModyfikacji) {
        ArrayList<Strona> strony = new ArrayList<>();

        int licznik_stron_mod = 0;
        if (listaModyfikacji != null){
            for (int i = 0; i < listaModyfikacji.size(); i++){
                licznik_stron_mod += listaModyfikacji.get(i).getHigherIndex() - listaModyfikacji.get(i).getLowerIndex() +1;
            }
        }
        if (iloscStron < licznik_stron_mod) System.out.println("modyfikacji bylo wiecej niz ilosc stron (nieistotny blad)");
        //System.out.println(licznik_stron_mod);

        for (int i = 0; i < iloscStron-licznik_stron_mod; i++) {
            int nr = random.nextInt(zakresPrzestrzeni) + 1;
            strony.add(new Strona(nr));
        }
        if (listaModyfikacji == null || listaModyfikacji.isEmpty()) return strony;
        for (int i = 0; i < listaModyfikacji.size(); i++){
            if (listaModyfikacji.get(i).getZakres()>0 && listaModyfikacji.get(i).getLowerIndex() < listaModyfikacji.get(i).getHigherIndex()){
                int pointer = listaModyfikacji.get(i).getLowerIndex();
                do{
                if (listaModyfikacji.get(i).isPowtarzajacy()) {
                    strony.add(pointer, new Strona(listaModyfikacji.get(i).getNumerDlaIndeksu0()));
                }
                else if (listaModyfikacji.get(i).isUporzadkowany()) {
                    if (pointer == listaModyfikacji.get(i).getLowerIndex()) {
                        strony.add(pointer, new Strona(listaModyfikacji.get(i).getNumerDlaIndeksu0()));
                    }
                    else{
                    strony.add(pointer, new Strona(strony.get(pointer-1).nr+1));
                    }
                }
                else {
                    int nr = random.nextInt(listaModyfikacji.get(i).getZakres()) + 1 + listaModyfikacji.get(i).getZakresPlus();
                    strony.add(pointer, new Strona(nr));
                }
                pointer++;
                } while (listaModyfikacji.get(i).getHigherIndex()+1 > pointer);

            }
        }
        return strony;
    }
    public static void main(String[] args) {
        ArrayList<Modyfikacja> listaMod = new ArrayList<>();
        Modyfikacja modyfikacja1 = new Modyfikacja(1,6,2);
        modyfikacja1.setZakresPlus(100);
        //modyfikacja1.setUporzadkowany(true);
        //modyfikacja1.setNumerDlaIndeksu0(10);
        listaMod.add(modyfikacja1);
        ArrayList<Strona> strony = generatorModyfikacje(10,10,listaMod);
        for (int i = 0; i < strony.size(); i++){
            System.out.println("index=" + i + " " + strony.get(i).nr);
        }
    }
}
