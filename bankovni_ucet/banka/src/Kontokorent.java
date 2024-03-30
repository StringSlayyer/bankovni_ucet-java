public class Kontokorent extends BankovniUcet{
    int puvodVyse;
    private int vyseKonto;


    Kontokorent(long cislo, String jmeno, String adresa, boolean karta, long stav, int vyseKonto){
        super(cislo, jmeno, adresa, karta, stav);
        this.vyseKonto = vyseKonto;
        this.puvodVyse = vyseKonto;
    }
    public void Vklad(int castka){
        int potreba = this.puvodVyse - this.vyseKonto;
        if(castka>potreba) {
            this.vyseKonto = this.puvodVyse;
            int zbytek = castka - potreba;
            super.Vklad(zbytek);
        }else this.vyseKonto = this.vyseKonto + castka;
        System.out.println("Na účet bylo vloženo: " + castka + " Czk. Zůstatek na účtu je: " + this.stavUctu + " Czk a výše kontokorentu je: " + this.vyseKonto + " Czk.");
        Informace();
    }

    public void Vyber(int castka){
        if(this.stavUctu + this.vyseKonto > castka){
            if(castka>this.stavUctu) {
                long zbytek = castka - this.stavUctu;
                this.stavUctu = 0;
                this.vyseKonto = (int)(this.vyseKonto - zbytek);
            }else{
                this.stavUctu = this.stavUctu - castka;
            }

            System.out.println("Bylo vybráno " + castka + " Czk. Zůstatek na účtu činí " + this.stavUctu + " Czk a výše kontokorentu je " + this.vyseKonto + "Czk.");
        }else{
            System.out.println("Na účtu není dostatek peněz.");
        }
        Informace();
    }

    public int getVyseKonto() {
        return vyseKonto;
    }

    void Informace(){
        System.out.println("Číslo účtu: " + getCisloUctu());
        System.out.println("Jméno: " + getJmenoMajitele());
        System.out.println("Adresa: " + getAdresaMajitele());
        System.out.println("Stav účtu: " + getStavUctu());
        System.out.println("Stav kontokorentu: " + getVyseKonto());
        System.out.println("Platební karta: " + isPlatebniKarta());
    }
}
