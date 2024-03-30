public class SpotrebitelskyUver extends BankovniUcet{
    int vyseUver;

    SpotrebitelskyUver(long cislo, String jmeno, String adresa, boolean karta, long stav, int vyseUver){
        super(cislo, jmeno, adresa, karta, stav);
        this.vyseUver = vyseUver;
        this.stavUctu = this.stavUctu + vyseUver;
    }

    void splatka(int vyse){
        this.stavUctu = this.stavUctu - vyse;
        if(vyse>this.vyseUver){
            int zbytek = vyse - this.vyseUver;
            this.vyseUver = 0;
            this.stavUctu = this.stavUctu + zbytek;
            System.out.println("Úvěr byl splacen. Na účet bylo vrácen přeplatek " + zbytek + " Czk");
        }else {
            this.vyseUver = this.vyseUver - vyse;
        }

        System.out.println("Bylo splaceno " + vyse + " Czk. Zbývá splatit " + this.vyseUver + " Czk.");
        Informace();
    }
}
