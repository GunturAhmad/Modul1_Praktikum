import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CodeLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input");
        System.out.print("Nama : ");
        String nama = scanner.nextLine();

        System.out.print("Jenis Kelamin (L/P) : ");
        String jenisKelaminInput = scanner.nextLine();
        String jenisKelamin = jenisKelaminInput.equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan";

        System.out.print("Tanggal Lahir (yyyy-mm-dd) : ");
        String tanggalLahirInput = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirInput);

        LocalDate sekarang = LocalDate.now();
        Period usia = Period.between(tanggalLahir, sekarang);

        System.out.println("\nOutput");
        System.out.println("Nama : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelamin);
        System.out.println("Umur Anda : " + usia.getYears() + " tahun " + usia.getMonths() + " bulan");
    }
}
