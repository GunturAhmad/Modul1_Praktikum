import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;

    static String tampilUniversitas() {
        return "Universitas Muhammadiyah Malang";
    }

    static String tampilDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        StringBuilder dataMahasiswa = new StringBuilder();
        dataMahasiswa.append("Data Mahasiswa:\n");
        dataMahasiswa.append(tampilUniversitas()).append("\n");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            dataMahasiswa.append("Nama: ").append(mahasiswa.nama).append(", NIM: ").append(mahasiswa.nim).append(", Jurusan: ").append(mahasiswa.jurusan).append("\n");
        }
        return dataMahasiswa.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("Menu");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa(daftarMahasiswa, scanner);
                    break;
                case 2:
                    System.out.println(Mahasiswa.tampilDataMahasiswa(daftarMahasiswa));
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Pilihan Salah");
                    break;
            }
        } while (pilihan != 3);
    }

    static void tambahDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa, Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa   : ");
        String nama = scanner.nextLine();

        String nim;
        do {
            System.out.print("Masukkan NIM mahasiswa    : ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM Harus 15 Digit!!!");
            }
        } while (nim.length() != 15);

        System.out.print("Masukkan jurusan mahasiswa    : ");
        String jurusan = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = nama;
        mahasiswa.nim = nim;
        mahasiswa.jurusan = jurusan;

        daftarMahasiswa.add(mahasiswa);
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }
}
