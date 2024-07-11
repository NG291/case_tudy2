package menu;

import java.util.Scanner;
import manager.Manager;


public class MenuCustomers {
    public static void menuSelect1(Scanner scanner, Manager manager) {

        try {
            while (true) {
            System.out.println(" Quan ly Khach Hang ");
            System.out.println("1:Hien thi tai lieu");
            System.out.println("2:Muon Sach");
            System.out.println("3:Tra Sach");
            System.out.println("0:Thoat chương trinh");
                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 0) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        manager.displayAllDocuments();
                        break;

                    case 2:
                        System.out.println("Nhap id nguoi muon");
                        String idBorrower = scanner.nextLine();
                        System.out.println("Nhap id tai lieu");
                        String idDocument = scanner.nextLine();
                        manager.borrowDocument(idBorrower , idDocument);
                        break;
                    case 3:
                        System.out.println("Nhap id nguoi trả");
                        String idReturner = scanner.nextLine();
                        System.out.println("Nhap id tai lieu");
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
