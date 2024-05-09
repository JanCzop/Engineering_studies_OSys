public class Modyfikacja {
    private int lowerIndex;
    private int higherIndex;
    private int zakres;
    private int zakresPlus = 0;
    private boolean uporzadkowany = false;
    private boolean powtarzajacy = false;
    private int numerDlaIndeksu0 = 1;

    public Modyfikacja(int lowerIndex, int higherIndex, int zakres){
        this.lowerIndex = lowerIndex;
        this.higherIndex = higherIndex;
        this.zakres = zakres;
    }

    public int getHigherIndex() {
        return higherIndex;
    }

    public int getLowerIndex() {
        return lowerIndex;
    }

    public int getZakres() {
        return zakres;
    }

    public void setHigherIndex(int higherIndex) {
        this.higherIndex = higherIndex;
    }

    public void setLowerIndex(int lowerIndex) {
        this.lowerIndex = lowerIndex;
    }

    public void setZakres(int zakres) {
        zakres = zakres;
    }

    public boolean isUporzadkowany() {
        return uporzadkowany;
    }

    public void setUporzadkowany(boolean uporzadkowany) {
        this.uporzadkowany = uporzadkowany;
    }

    public boolean isPowtarzajacy() {
        return powtarzajacy;
    }

    public void setPowtarzajacy(boolean powtarzajacy) {
        this.powtarzajacy = powtarzajacy;
    }

    public int getNumerDlaIndeksu0() {
        return numerDlaIndeksu0;
    }

    public void setNumerDlaIndeksu0(int numerDlaIndeksu0) {
        this.numerDlaIndeksu0 = numerDlaIndeksu0;
    }

    public void setZakresPlus(int zakresPlus) {
        this.zakresPlus = zakresPlus;
    }

    public int getZakresPlus() {
        return zakresPlus;
    }
}
