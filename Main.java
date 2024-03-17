package Praktikum;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String[] bookList = {"Buku A|Pengarang A|1|1", "Buku B|Pengarang B|2|5", "Buku C|Pengarang C|3|3"};
    static String[] userStudent = {"202110370311119|Guntur|Teknik|Informatika", "202110370311103|Cahyo|Teknik|Informatika"};

    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin("admin", "admin");

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.println("Selamat datang di Perpustakaan!");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            loginAdmin();
        } else if (choice == 2) {
            String nim = inputNIM();
            if (checkNim(nim)) {
                menuStudent();
            } else {
                System.out.println("NIM tidak valid!");
                menu();
            }
        } else {
            System.out.println("Pilihan tidak valid!");
            menu();
        }
    }

    static String inputNIM() {
        System.out.print("Masukkan NIM: ");
        return scanner.nextLine();
    }

    static boolean checkNim(String nim) {
        for (String student : userStudent) {
            if (student.startsWith(nim)) {
                return true;
            }
        }
        return false;
    }

    static void menuAdmin() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudents();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }

    static void menuStudent() {
        Student student = new Student();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu Mahasiswa:");
            System.out.println("1. Tampilkan Daftar Buku");
            System.out.println("2. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    student.displayBooks();
                    break;
                case 2:
                    student.logout();
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }
    static void loginAdmin() {
        System.out.print("Masukkan username Admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password Admin: ");
        String password = scanner.nextLine();
        
        if (admin.authenticate(username, password)) {
            menuAdmin();
        } else {
            System.out.println("Username atau password Admin salah!");
            menu();
        }
    }
}

class Student {
    String name;
    String faculty;
    String programStudi;

    Student(String name, String faculty, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }
    void logout() {
        System.out.println("Anda telah keluar dari sistem.");
    }

    void displayBooks() {
        System.out.println("\nDaftar Buku:");
        for (String book : Main.bookList) {
            String[] bookDetails = book.split("\\|");
            System.out.println("Judul: " + bookDetails[0]);
            System.out.println("Penulis: " + bookDetails[1]);
            System.out.println("ID Buku: " + bookDetails[2]);
            System.out.println("Stok: " + bookDetails[3]);
            System.out.println();
        }
    }
    Student() {}
}

class Admin {
    String adminUsername;
    String adminPassword;
    ArrayList<Student> studentList = new ArrayList<>();

    Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    boolean authenticate(String username, String password) {
        return this.adminUsername.equals(username) && this.adminPassword.equals(password);
    }
    
    void displayStudents() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Student student : studentList) {
            System.out.println("Nama: " + student.name);
            System.out.println("Fakultas: " + student.faculty);
            System.out.println("Program Studi: " + student.programStudi);
            System.out.println();
        }
    }
    
    void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("NIM tidak valid! NIM harus terdiri dari 15 digit angka.");
            return;
        }
        System.out.print("Masukkan Fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan Program Studi: ");
        String studi = scanner.nextLine();
        Student student = new Student(name, faculty, studi);
        studentList.add(student);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }
}
