package Materi;

import java.security.PublicKey;
import java.util.Scanner;

public class Kubus extends BangunRuang {
    private double sisi;

    public Kubus(String name) {
        super(name);
    }

    @Override
    public
    void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input sisi: ");
        sisi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 6 * sisi * sisi;
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.pow(sisi, 3);
        System.out.println("Hasil volume: " + hasil);
    }
}