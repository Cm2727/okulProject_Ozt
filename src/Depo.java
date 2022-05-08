import java.util.Scanner;

public class Depo {
    static Scanner scan = new Scanner(System.in);


    public static void anaMenu() throws InterruptedException {
        Ogrenci.feykOgrenciEkle();
        Ogretmen.ogrtListesi();
        int tercih = 0;
        do {
            System.out.println("============= DOGA KOLEJI =============\n" +
                    "==============  ANA MENU ==============\n" +
                    "\n" +
                    "\t   1- Okul Bilgileri Goruntule\n" +
                    "\t   2- Ogretmen Menu\n" +
                    "\t   3- Ogrenci Menu\t\t \n" +
                    "\t   4- ÇIKIŞ\n");

            System.out.println("Seciminizi yapin");
                tercih = scan.nextInt();

            switch (tercih) {

                case 1://Okul Bilgileri
                    Okul.okulBilgileri();


                    break;

                case 2:// Ogretmen Menu
                    Ogretmen.ogretmenMenu();


                    break;
                case 3:// Ogrenci Menu
                    Ogrenci.ogrenciMenu();

                    break;


                case 4:// ÇIKIŞ
                    cikis();
                    break;

                default:

                     System.out.println("Hatali giris yaptiniz");


            }


        } while (tercih != 4);

    }

    public static void cikis() {
        System.out.println("cikis yaptiniz.");
        System.exit(0);
    }
}
