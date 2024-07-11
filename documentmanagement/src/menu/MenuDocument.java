package menu;

import InformationDocuments.Document;
import manager.Manager;

import java.util.List;
import java.util.Scanner;

public class MenuDocument {
    public static void menuSelect2(Scanner scanner, Manager manager) {
        try {
            while (true) {
                System.out.println("    Quan ly tai lieu   ");
                System.out.println("1:Them tai lieu");
                System.out.println("2:Xoa tai lieu");
                System.out.println("3:Tim kiem tai lieu");
                System.out.println("4:Hien thi  tai lieu");
                System.out.println("5:Them thong tin khach hang");
                System.out.println("6:Hien thi danh sach thong tin khach muon");
                System.out.println("0:Thoat chuong trinh");

                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 0) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        addTypeDocument(scanner, manager);
                        break;

                    case 2:
                        System.out.println("Nhap id xoa");
                        String id = scanner.nextLine();
                        manager.removeDocument(id);
                        break;
                    case 3:
                        findType(scanner, manager);
                        break;
                    case 4:
                        manager.displayAllDocuments();
                        break;
                    case 5:
                        manager. addBorrowerName(scanner);
                        break;
                    case 6:
                        manager.displayAllBorrower();
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
    public static void addTypeDocument(Scanner scanner, Manager manager) {
        try {
            System.out.println("1. Them bao");
            System.out.println("2. Them sach");
            System.out.println("3. Them tap chi");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manager.addNewspaper(scanner);
                    break;
                case 2:
                    manager.addBook(scanner);
                    break;
                case 3:
                    manager.addMagazine(scanner);
                    break;
                default:
                    System.out.println("Ket Thuc");
                    break;
            }
        } catch (Exception e) {

        }
    }

    public static void findType(Scanner scanner, Manager manager) {
        System.out.println("1:Tim kiem theo id");
        System.out.println("2:Tim kiem theo ten");
        System.out.println("3:Tim kiem tac gia");
        int option = Integer.parseInt(scanner.nextLine());
        try {
            switch (option) {
                case 1:
                    System.out.println("Nhap id");
                    String id = scanner.nextLine();
                    Document doc = manager.findDocumentById(id);
                    System.out.println(doc);
                    break;
                case 2:
                    System.out.println("Nhap Ten ");
                    String name = scanner.nextLine();
                    Document document = manager.findDocumentByTitle(name);
                    System.out.println(document);
                    break;
                case 3:
                    System.out.println("Nhap ten tac gia");
                    String authorNames = scanner.nextLine();
                    List<Document> list = manager.findDocumentByAuthor(authorNames);
                    for (Document b : list) {
                        System.out.println(b);
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}