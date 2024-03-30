import java.util.Random;

public class BankovniUcet {
    protected long cisloUctu;
    protected String jmenoMajitele;
    protected String adresaMajitele;
    protected boolean platebniKarta;
    protected long stavUctu;

    CislaUctu c = new CislaUctu();


     BankovniUcet(long cislo, String jmeno, String adresa, boolean karta, long stav){
         this.jmenoMajitele = jmeno;
         this.adresaMajitele = adresa;
         this.cisloUctu = cislo;
         this.platebniKarta = karta;
         this.stavUctu = stav;
    }

    void Informace(){
         System.out.println("Číslo účtu: " + getCisloUctu());
         System.out.println("Jméno: " + getJmenoMajitele());
         System.out.println("Adresa: " + getAdresaMajitele());
         System.out.println("Stav účtu: " + getStavUctu());
         System.out.println("Platební karta: " + isPlatebniKarta());
         System.out.println("");
         System.out.println("");
    }

    void Vklad(int castka){
         this.stavUctu = this.stavUctu + castka;
         System.out.println("Na účet bylo vloženo: " + castka + " Czk. Zůstatek na účtu je: " + this.stavUctu + " Czk.");
         Informace();
    }

    void Vyber(int castka){
         if(castka > this.stavUctu){
             System.out.println("Není dostatek peněz");
         }else{
             this.stavUctu = this.stavUctu - castka;
             System.out.println("Bylo vybráno " + castka + " Czk. Zůstatek na účtu činí " + this.stavUctu + "Czk.");
         }
         Informace();
    }

    void ZalozitKartu(){
         if(this.platebniKarta == false){
             this.platebniKarta = true;
             System.out.println("Platební karta byla založena");
         }else System.out.println("Platební karta je již založená");
         Informace();
    }

    public long getCisloUctu() {
        return cisloUctu;
    }

    public String getJmenoMajitele() {
        return jmenoMajitele;
    }

    public String getAdresaMajitele() {
        return adresaMajitele;
    }

    public boolean isPlatebniKarta() {
        return platebniKarta;
    }

    public long getStavUctu() {
        return stavUctu;
    }

    public void setStavUctu(long stavUctu) {
        this.stavUctu = stavUctu;
    }

    public void Menu(){
         System.out.println("1. Přehled o účtu");
         System.out.println("2. Vklad hotovosti");
         System.out.println("3. Výběr hotovosti");
         if(platebniKarta == false){
            System.out.println("4. Založit platební kartu");
         }else System.out.println("4. Platební karta již založena");
         System.out.println("5. Založit kontokorent");
         System.out.println("6. Založit spotřebitelský úvěr");
         System.out.println("7. Splátka");
         System.out.println("8. Odejít");
    }
}

/*
* Poznamky pod carou xd
* text u menu bude kontokorent a sporici ucet, jako vybizeni na zalozeni
* zabezpečit proti vkládání stringů do intů
* 1. - přehled
* 2. vklad
* 3. výběr
* 4. založit platební kartu
* 5. Kontokorent
* 6. Spořící účet
* 7. Exit
* */