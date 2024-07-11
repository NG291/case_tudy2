package menu;

import InformationDocuments.Document;
import manager.Manager;

import java.util.List;
import java.util.Scanner;

public class MenuDocument {
    public static void menuSelect2(Scanner scanner, Manager manager) {
        try {
            while (true) {
                System.out.println("  Document Management ");
                System.out.println("1:Add documents");
                System.out.println("2:Delete documents");
                System.out.println("3:Search documents");
                System.out.println("4:Show documents");
                System.out.println("5:Add customer information");
                System.out.println("6:Currently, customers are borrowing");
                System.out.println("0:Exit the program");

                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 0) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        addTypeDocument(scanner, manager);
                        break;

                    case 2:
                        System.out.println("Enter the deletion id code");
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
            System.out.println("1: Add newspaper");
            System.out.println("2: Add books");
            System.out.println("3: Add a magazine");
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
                    System.out.println("End");
                    break;
            }
        } catch (Exception e) {

        }
    }

    public static void findType(Scanner scanner, Manager manager) {
        System.out.println("1:Search by ID");
        System.out.println("2:Search by name");
        System.out.println("3:Search by author");
        int option = Integer.parseInt(scanner.nextLine());
        try {
            switch (option) {
                case 1:
                    System.out.println("Enter the id code");
                    String id = scanner.nextLine();
                    Document doc = manager.findDocumentById(id);
                    System.out.println(doc);
                    break;
                case 2:
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    Document document = manager.findDocumentByTitle(name);
                    System.out.println(document);
                    break;
                case 3:
                    System.out.println("Enter the author's name");
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