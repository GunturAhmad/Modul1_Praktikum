package Materi;

public class App {
    public static void main(String[] args) throws Exception {
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");
        Balok balok = new Balok("balok");

        System.out.println("Balok");
        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        System.out.println("Kubus");
        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        System.out.println("Tabung");
        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}