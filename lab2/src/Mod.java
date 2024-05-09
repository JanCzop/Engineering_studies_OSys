public class Mod {

    int range_l;
    int range_h;
    int modif;

    public Mod(int modif,int range_l,int range_h){
        if (range_l<=range_h){
            this.range_l = range_l;
            this.range_h = range_h;
        }
        this.modif = modif;
    }
}
