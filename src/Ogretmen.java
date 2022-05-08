import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Ogretmen {

    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ogretmenMap = new HashMap();

    public static void ogrtListesi() {
        ogretmenMap.put("1001", "Ahmet, Aslan, 1988, Kimya");
        ogretmenMap.put("1002", "Mehmet, Aksu, 1986, Matematik");
        ogretmenMap.put("1003", "Yunus, Ay, 2000, Turkce");
        ogretmenMap.put("1004", "Sadik, Kilic, 1997, Deutsch");
        ogretmenMap.put("1005", "Ahmet, Aksu, 1978, Kimya");
        ogretmenMap.put("1006", "Yunus, Kilic, 1978, Tarih");
    }


    public static void ogretmenMenu() throws InterruptedException {

        int tercih = 0;
        do {
            System.out.println("============= YILDIZ KOLEJI =============\n" +
                    "=========== OGRETMEN MENU ============\n" +
                    "\n" +
                    "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                    "\t   2- Soyisimden Ogretmen Bulma\n" +
                    "\t   3- Branstan Ogretmen Bulma\n" +
                    "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                    "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t   6- ANAMENU\n" +
                    "\t   7- ÇIKIŞ\n");
            System.out.println("Lütfen tercihinizi seciniz.");
            tercih = scan.nextInt();


            switch (tercih) {

                case 1: // Ogretmenler listesi yazdir.
                    ogretmenListesiYazdir();
                    break;
                case 2://Soyisimden Ogretmen Bulma
                    soyIsimdenOgretmenBulma();
                    break;
                case 3://Branstan Ogretmen Bulma
                    branstanOgretmenBulma();

                    break;
                case 4: //Bilgilerini Girerek Ogretmen Ekleme
                    bilgileriniGirerekOgretEkle();
                    break;
                case 5://5- Kimlik No Ile Kayit Silme
                    tcNoIleKayitSilme();
                    break;
                case 6:
                    Depo.anaMenu();
                    break;
                case 7:
                    Depo.cikis();
                    break;
                default:
                    System.out.println("Hatali secim yaptiniz");
                    ogretmenMenu();
            }


        } while (tercih != 7);


    }

    private static void tcNoIleKayitSilme() {
        System.out.println("Silmek istediginiz ögretmenin TC Nosunu giriniz");
        String SilinecekTcNo=scan.next();

        ogretmenMap.remove(SilinecekTcNo);

      // System.out.println(Sonuc);

       // boolean So=Sonuc.equals(SilinecekTcNo);

       /* if () {
            System.out.println(Sonuc+"Kayidi silindi.");

        }else System.out.println("TC kayit bulunamadi.");
*/

    }

    private static void bilgileriniGirerekOgretEkle() {
        System.out.println("TcNo giriniz");
        String TcNo = scan.next();
        System.out.println("Adini giriniz");
        String Adi = scan.next();
        System.out.println("Soyadini giriniz");
        String Soyad = scan.next();
        System.out.println("Dogum tarihini giriniz");
        String dogum = scan.next();
        System.out.println("Brans giriniz");
        String brans = scan.next();

        String eklenecekValue =Adi + ", " + Soyad + ", " + dogum + ", " + brans;
        ogretmenMap.put(TcNo, eklenecekValue);


    }

    private static void branstanOgretmenBulma() throws InterruptedException {

        System.out.println("Aradiginiz ogretmenin brans ini giriniz...");
        scan.nextLine();
        String brans = scan.nextLine();


        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogretmenMap.entrySet();


        System.out.println("============= YASAM KOLEJI =============\n" +
                "=========== BRAS'TAN OGRETMEN BULMA ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {


            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");

            if (brans.equalsIgnoreCase(eachValuearr[3])) {
                System.out.printf("%8s %-7s %-8s %-4s  %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
            }

        }
        Thread.sleep(5000);

    }

    private static void soyIsimdenOgretmenBulma() throws InterruptedException {
        System.out.println("aradigin ögretmenin soyismini girin");
        scan.nextLine();
        String arananSoyIsim = scan.nextLine();
        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogretmenMap.entrySet();
        System.out.println("============= DOGA KOLEJI =============\n" +
                "=========== SOYISIMDEN OGRETMEN BULMA ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");

        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuee[] = eachValue.split(", ");

            if (arananSoyIsim.equalsIgnoreCase(eachValuee[1])) {

                System.out.printf("%4s %-7s %-9s %-4s %s \n", eachKey, eachValuee[0],
                        eachValuee[1], eachValuee[2], eachValuee[3]);
            }

        }

        Thread.sleep(5000);

    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogretmenMapEntrySet = ogretmenMap.entrySet();
        System.out.println("============= DOGA KOLEJI =============\n" +
                "=========== OGRETMEN LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  Brans");


        for (Map.Entry<String, String> each : ogretmenMapEntrySet) {
            //System.out.println(each);

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuee[] = eachValue.split(", ");

            // System.out.print("eachKey  "+eachKey);
            // System.out.println("isim  "+eachValuee[0]);
            // System.out.println("brans  "+eachValuee[3]);

            System.out.printf("%8s %-7s %-9s %-4s %s \n", eachKey, eachValuee[0],
                    eachValuee[1], eachValuee[2], eachValuee[3]);

        }

        Thread.sleep(5000);

    }
}
