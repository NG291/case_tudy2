import manager.Manager;
import menu.MenuCustomers;
import menu.MenuDocument;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        try {
            while (true) {
            System.out.println("   Quan ly He thong    ");
            System.out.println("1:Quan ly tai lieu");
            System.out.println("2:Quan ly Khach muon");
            System.out.println("0:Thoat chương trinh");
                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 0) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        MenuDocument.menuSelect2(scanner, manager);
                        break;
                    case 2:
                        MenuCustomers.menuSelect1(scanner, manager);
                        break;
                    default:
                        System.out.println("Nhap lai!");

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
