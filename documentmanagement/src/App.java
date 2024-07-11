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
            System.out.println(" Document system management  ");
            System.out.println("1:Document Management");
            System.out.println("2:Manage borrowers");
            System.out.println("0:Exit the program");
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
                        System.out.println("Retype!");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
