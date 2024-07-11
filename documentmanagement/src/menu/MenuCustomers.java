package menu;

import java.util.Scanner;
import manager.Manager;


public class MenuCustomers {
    public static void menuSelect1(Scanner scanner, Manager manager) {

        try {
            while (true) {
            System.out.println(" Customer menu ");
            System.out.println("1:Show documents");
            System.out.println("2:Borrow documents");
            System.out.println("3:Return documents");
            System.out.println("0:Exit the program");
                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 0) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        manager.displayAllDocuments();
                        break;

                    case 2:
                        System.out.println("Enter the borrower code");
                        String idBorrower = scanner.nextLine();
                        System.out.println("Enter the document code");
                        String idDocument = scanner.nextLine();
                        manager.borrowDocument(idBorrower , idDocument);
                        break;
                    case 3:
                        System.out.println("Enter returner id code");
                        String idReturner = scanner.nextLine();
                        System.out.println("Enter the returned document id code");
                        String idDocument1 = scanner.nextLine();
                        manager.returnDocument(idReturner,idDocument1);
                        break;
                    default:
                        System.out.println("Retype!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
