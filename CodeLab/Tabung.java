package Materi;

import java.util.Scanner;

public class Tabung extends BangunRuang {
    private double tinggi;
    private double jari_jari;

    public Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * Math.PI * jari_jari * (jari_jari + tinggi);
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = (4/3) * Math.PI * Math.pow(jari_jari, 3);
        System.out.println("Hasil volume: " + hasil);
    }
}