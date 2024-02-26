import java.util.Scanner;

public class Tugas {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String[] STUDENTS_NIM = {"202110370311119", "202110370311141", "202110370311103"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tugas Tugas = new Tugas();

        while (true) {
            System.out.println("\n\u001B[33m===== \u001B[38;5;208mLibrary System \u001B[33m=====\u001B[0m");
            System.out.println("\n1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.println("\u001B[33m==========================\u001B[0m");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\u001B[33m==========================\u001B[0m");

            switch (choice) {
                case 1:
                    Tugas.loginAsStudent(scanner);
                    break;
                case 2:
                    Tugas.loginAsAdmin(scanner);
                    break;
                case 3:
                    System.out.println("\u001B[31mAdios\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31mInvalid choice. Please choose between 1 and 3.");
                    System.out.println("\u001B[33m==========================");
            }
        }
    }

    private void loginAsStudent(Scanner scanner) {
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();

        for (int i = 0; i < STUDENTS_NIM.length; i++) {
            if (nim.equals(STUDENTS_NIM[i])) {
                System.out.println("\n\u001B[34mSuccessful Login as Student");
                System.out.println("\u001B[33m==========================");
                return;
            }
        }
        System.out.println("\n\u001B[31mUser Not Found");
        System.out.println("\u001B[33m==========================\u001B[0m");
    }

    private void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("\n\u001B[32mSuccessful Login as Admin");
            System.out.println("\u001B[33m==========================");
        } else {
            System.out.println("\n\u001B[31mAdmin User Not Found!!");
            System.out.println("\u001B[33m==========================");
        }
    }
}
