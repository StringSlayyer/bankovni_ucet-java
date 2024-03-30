import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CislaUctu cisla = new CislaUctu();
        long cislo = cisla.cisloU();
        BankovniUcet uziv1 = new BankovniUcet(cislo, "Pavel Novák", "Přerov", false, 0);
        SpotrebitelskyUver spotrebitelskyUver = null;

        uziv1.Informace();

        Scanner sc = new Scanner(System.in, "UTF-8");


        while(true){
            uziv1.Menu();
            String moznost = sc.nextLine();
            switch (moznost){
                case "1":
                    uziv1.Informace();
                    break;

                case "2":
                    System.out.println("Kolik peněz chcete vložit?");
                    String vkladIn = sc.nextLine();
                    int vklad = Integer.parseInt(vkladIn);
                    uziv1.Vklad(vklad);
                    break;

                case "3":
                    System.out.println("Kolik peněz chcete vybrat?");
                    String vyberIn = sc.nextLine();
                    int vyber = Integer.parseInt(vyberIn);
                    uziv1.Vyber(vyber);
                    break;

                case "4":
                    uziv1.ZalozitKartu();
                    break;

                case "5":
                    if (!(uziv1 instanceof Kontokorent)) {
                        uziv1 = new Kontokorent(uziv1.getCisloUctu(), uziv1.getJmenoMajitele(), uziv1.getAdresaMajitele(), uziv1.isPlatebniKarta(), uziv1.getStavUctu(), 10000);
                        System.out.println("Kontokorent byl založen.");
                    }
                    break;

                case "6":
                    System.out.println("Kolik potřebujete půjčit?");
                    String uverIn = sc.nextLine();
                    int uver = Integer.parseInt(uverIn);
                    if(spotrebitelskyUver == null) {
                        spotrebitelskyUver = new SpotrebitelskyUver(uziv1.getCisloUctu(), uziv1.getJmenoMajitele(), uziv1.getAdresaMajitele(), uziv1.isPlatebniKarta(), uziv1.getStavUctu(), uver);
                        uziv1.setStavUctu(uziv1.getStavUctu() + uver);
                        uziv1.Informace();
                    } else {
                        spotrebitelskyUver.vyseUver = spotrebitelskyUver.vyseUver + uver;
                        uziv1.setStavUctu(uziv1.getStavUctu() + uver);
                    }
                    System.out.println("Nyní máte půjčeno " + spotrebitelskyUver.vyseUver + " Czk");
                    break;

                case "7":
                    if(spotrebitelskyUver != null) {
                        spotrebitelskyUver.stavUctu = uziv1.getStavUctu();
                        System.out.println("Kolik chcete splatit?");
                        String splatkaIn = sc.nextLine();
                        int splatka = Integer.parseInt(splatkaIn);
                        spotrebitelskyUver.splatka(splatka);
                        uziv1.setStavUctu(spotrebitelskyUver.stavUctu);
                    }else {
                        System.out.println("Je potřeba založit spotřebitelský úvěr.");
                    }
                    uziv1.Informace();
                    break;

                case "8":
                    System.out.println("Program ukončen.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Neplatná volba. Zvolte prosím platnou akci.");
                    break;


            }
        }




    }
}
