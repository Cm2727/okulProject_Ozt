import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {

    static Map<String, String> ogrenciMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void feykOgrenciEkle() {
        ogrenciMap.put("123456987411", "Ali, Can, 2008, 3569, 12, A");
        ogrenciMap.put("123456987412", "Veli, Yan, 2008, 3559, 12, B");
        ogrenciMap.put("123456987413", "Ayse, Can, 2007, 4569, 12, A");
        ogrenciMap.put("123456987414", "Ali, San, 2009, 1569, 11, A");
        ogrenciMap.put("123456987415", "Alp, Yan, 2009, 3769, 11, A");
    }

    public static void ogrenciMenu() throws InterruptedException {
        int tercih = 0;
        do {

            System.out.println("============= YILDIZ KOLEJI =============\n" +
                    "=========== OGRENCI MENU ============\n" +
                    "\t   1- Ogrenci Listesi Yazdir\n" +
                    "\t   2- Soyisimden Ogrenci Bulma\n" +
                    "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                    "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                    "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                    "\t   6- ANAMENU\n" +
                    "\t   7- ÇIKIŞ");
            tercih = scan.nextInt();
            switch (tercih) {
                case 1://Ogrenci Listesi Yazdir
                    ogreciListesiYazdir();
                    break;

                case 2://Soyisimden Ogrenci Bulma
                    soyIsimdenOgrenciBulma();

                    break;
                case 3://Sinif ve Sube Ile Ogrenci Bulma
                    sinifVeSubeIleOgrenciBulma();

                    break;

                case 4://Bilgilerini Girerek Ogrenci Ekleme

                    ogrenciEkleme();

                    break;

                case 5://Kimlik No Ile Kayit Silme

                    TcNoIleOgrnSilme();

                    break;

                case 6:
                    Depo.anaMenu();
                    break;
                case 7:
                    Depo.cikis();
                    break;
                default:
                    System.out.println("Hatali secim yaptiniz");
                    ogrenciMenu();
            }


        } while (tercih != 7);


    }

    private static void TcNoIleOgrnSilme() {
        System.out.println("Silmek istediginiz ogrencinin TC nosunu giriniz");
        String TcNo=scan.next();

        ogrenciMap.remove(TcNo);
    }

    private static void ogrenciEkleme() {
        System.out.println("Ogrencinin TC Nosunu giriniz.");
        String TcNo = scan.next();
        System.out.println("Ogrencinin adini giriniz.");
        String adi = scan.next();
        System.out.println("Ogrencinin soyadini giriniz.");
        String soyadi = scan.next();
        System.out.println("Ogrencinin dogum yilini giriniz.");
        String dogumYil = scan.next();
        System.out.println("Ogrencinin okul nosunu giriniz.");
        String okulNo = scan.next();
        System.out.println("Ogrencinin sinifini giriniz.");
        String sinif = scan.next();
        System.out.println("Ogrencinin subesini giriniz.");
        String sube = scan.next();

        String ogrnEklenecekValue = adi + ", " + soyadi + ", " + dogumYil + ", " + okulNo + ", " + sinif + ", " + sube;
        ogrenciMap.put(TcNo,ogrnEklenecekValue);

    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        System.out.println("Bulmak istediginiz ogrencinin sinifni giriniz");
        String sinif = scan.next();
        System.out.println("Bulmak istediginiz ogrencinin subesini giriniz");
        String sube = scan.next();
        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciMap.entrySet();
        System.out.println("============= DOGA KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  OgrenciNo   Sinif   Sube");
        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValuee[] = eachValue.split(", ");

            if (sinif.equalsIgnoreCase(eachValuee[4]) && sube.equalsIgnoreCase(eachValuee[5])) {
                System.out.printf("%8s %-7s %-9s %-4s %-4s %-3s %s \n", eachKey, eachValuee[0],
                        eachValuee[1], eachValuee[2], eachValuee[3], eachValuee[4], eachValuee[5]);
            }

        }
        Thread.sleep(5000);


    }

    private static void soyIsimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Bulmak istediginiz ogrencinin soyismini girin.");
        String soyIsim = scan.next();
        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciMap.entrySet();
        System.out.println("============= DOGA KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  OgrenciNo   Sinif   Sube");

        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValuee[] = eachValue.split(", ");

            if (soyIsim.equalsIgnoreCase(eachValuee[1])) {
                System.out.printf("%8s %-7s %-9s %-4s %-4s %-3s %s \n", eachKey, eachValuee[0],
                        eachValuee[1], eachValuee[2], eachValuee[3], eachValuee[4], eachValuee[5]);
            }

            Thread.sleep(5000);
        }


    }

    private static void ogreciListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogrenciMapEntrySet = ogrenciMap.entrySet();
        System.out.println("============= DOGA KOLEJI =============\n" +
                "=========== OGRENCI LISTESI ============\n" +
                "TcNo        Isim   Soyisim   D.Yili  OgrenciNo   Sinif   Sube");
        for (Map.Entry<String, String> each : ogrenciMapEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValuee[] = eachValue.split(", ");
            System.out.printf("%8s %-7s %-9s %-4s %-4s %-3s %s \n", eachKey, eachValuee[0],
                    eachValuee[1], eachValuee[2], eachValuee[3], eachValuee[4], eachValuee[5]);
        }

        Thread.sleep(5000);
    }

}
