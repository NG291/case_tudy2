import InformationDocuments.Document;
import menu.MenuManages;
import org.omg.PortableInterceptor.ObjectReferenceFactory;

import javax.print.Doc;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Manage manage = new Manage();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Quan ly tai lieu");
            System.out.println("1:Them tai lieu");
            System.out.println("2:Xoa tai lieu");
            System.out.println("3:Tim kiem tai lieu");
            System.out.println("4:Hien thi all tai lieu");
            System.out.println("5: them khach hang");
            System.out.println("8:Hien thi ds thong tin khach muon");
            System.out.println("6:Thoat chương trinh");
            while (true) {
                int chocie = Integer.parseInt(scanner.nextLine());
                if (chocie == 7) {
                    break;
                }
                switch (chocie) {
                    case 1:
                        add(scanner, manage);
                        break;

                    case 2:
                        System.out.println("Nhap id xoa");
                        String id = scanner.nextLine();
                        manage.removeDocument(id);
                        ;
                        break;
                    case 3:
                        find(scanner, manage);
                        break;
                    case 4:
                        manage.displayAllDocuments();
                        break;
                    case 5:
                        manage.addB(scanner);
                        break;
                    default:
                        System.out.println("Retype!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void add(Scanner scanner, Manage manage) {
        System.out.println("1. them bao");
        System.out.println("2. them sach");
        System.out.println("3. them tap chi");
        try {
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manage.addNewspaper(scanner);
                    break;
                case 2:
                    manage.addBook(scanner);
                    break;
                case 3:
                    manage.addMagazine(scanner);
                    break;
                default:
                    System.out.println("ket thuc");
                    break;
            }

        } catch (Exception e) {

        }
    }

    public static void find(Scanner scanner, Manage manage) {
        System.out.println("1:Tim kiem theo id");
        System.out.println("2:Tim kiem theo ten");
        System.out.println("3:Tim kiem tac gia");
        int option = Integer.parseInt(scanner.nextLine());
        try {
            switch (option) {
                case 1:
                    System.out.println("Nhap id");
                    String id = scanner.nextLine();
                    Document doc = manage.findDocumentById(id);
                    System.out.println(doc);
                    break;
                case 2:
                    System.out.println("Nhap name ");
                    String name = scanner.nextLine();
                    Document document = manage.findDocumentByTitle(name);
                    System.out.println(document);
                    break;
                case 3:
                    System.out.println("Nhap ten tac gia");
                    String authorNames = scanner.nextLine();
                    List<Document> list = manage.findDocumentByAuthor(authorNames);
                    for (Document b : list) {
                        System.out.println(b);
                    }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
