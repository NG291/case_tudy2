package manager;

import InformationCustomers.Borrower;
import InformationDocuments.Book;
import InformationDocuments.Document;
import InformationDocuments.Magazine;
import InformationDocuments.Newspaper;
import fileManage.FileDocBorrower;
import fileManage.FileDocDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private final List<Document> documentLists;
    private final List<Borrower> borrowerList;

    public Manager() {
        this.documentLists = FileDocDocument.read();
        this.borrowerList = FileDocBorrower.readFileBorrower();
    }

    public void addDocument(Document document) {
        if (findDocumentById(document.getMaterialCode()) != null) {
            System.out.println("Document ID must be unique.");
            return;
        }
        documentLists.add(document);
        FileDocDocument.write(documentLists);
    }

    public void addBook(Scanner scanner) {
        try {
            System.out.println("Enter the book code");
            String bookCode = scanner.nextLine();
            System.out.println("Enter the book title");
            String bookTitle = scanner.nextLine();
            System.out.println("Enter the publisher name");
            String bookPublisher = scanner.nextLine();
            System.out.println("Enter the product quantity");
            int bookQuantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the author's name");
            String bookAuthor = scanner.nextLine();
            System.out.println("Enter the book type");
            String bookType = scanner.nextLine();
            System.out.println("Enter the year of publication");
            int productionYear = Integer.parseInt(scanner.nextLine());

            Book book = new Book(bookCode, bookTitle, bookPublisher, bookQuantity, bookAuthor, bookType, productionYear);

            addDocument(book);
        } catch (Exception _) {

        }
    }

    public void addMagazine(Scanner scanner) {
        System.out.println("Enter the magazine code");
        String magazineId = scanner.nextLine();
        System.out.println("Enter the magazine name");
        String magazineTitle = scanner.nextLine();
        System.out.println("Enter the publisher name");
        String magazinePublisher = scanner.nextLine();
        System.out.println("Enter the product quantity");
        int magazineQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the magazine type");
        String magazineType = scanner.nextLine();
        System.out.println("Enter the month of publication");
        int magazineMonth = Integer.parseInt(scanner.nextLine());

        Magazine magazine = new Magazine(magazineId, magazineTitle, magazinePublisher, magazineQuantity, magazineType, magazineMonth);
        addDocument(magazine);
    }

    public void addNewspaper(Scanner scanner) {
        try {
            System.out.println("Enter the token");
            String newspaperId = scanner.nextLine();
            System.out.println("Enter the newspaper title");
            String newspaperTitle = scanner.nextLine();
            System.out.println("Enter the publisher name");
            String newspaperPublisher = scanner.nextLine();
            System.out.println("Enter the newspaper quantity");
            int newspaperQuantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the author's name");
            String newspaperAuthorName = scanner.nextLine();
            System.out.println("Enter the number now");
            int newspaperDate = Integer.parseInt(scanner.nextLine());

            Newspaper newspaper = new Newspaper(newspaperId, newspaperTitle, newspaperPublisher, newspaperQuantity, newspaperAuthorName, newspaperDate);

            addDocument(newspaper);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void addBorrower(Borrower borrower) {
        borrowerList.add(borrower);
        FileDocBorrower.writeFileBorrower(borrowerList);

    }

    public void addBorrowerName(Scanner scanner) {
        System.out.println("Enter the borrower code");
        String borrowerCode = scanner.nextLine();
        System.out.println("Enter the borrower's name");
        String borrowerName = scanner.nextLine();
        System.out.println("Enter your phone number");
        String borrowerPhone = scanner.nextLine();
        System.out.println("Enter Gender");
        String borrowerGender = scanner.nextLine();
        Borrower borrower = new Borrower(borrowerCode, borrowerName, borrowerPhone, borrowerGender);
        addBorrower(borrower);
    }

    public Borrower findBorrowerById(String borrowerId) {
        for (Borrower borrower : borrowerList) {
            if (borrower.getCustomerCode().equals(borrowerId)) {
                return borrower;
            }
        }
        return null;
    }
    public void displayAllBorrower(){
        for (Borrower borrower : borrowerList){
            System.out.println(borrower);
        }
    }

    public Document findDocumentById(String documentId) {
        for (Document document : documentLists) {
            if (document.getMaterialCode().equalsIgnoreCase(documentId)) {
                return document;
            }
        }
        return null;
    }

    public Document findDocumentByTitle(String documentPublisher) {
        for (Document document : documentLists) {
            if (document.getPublisherName().equalsIgnoreCase(documentPublisher)) ;
            return document;
        }
        return null;
    }

    public List<Document> findDocumentByAuthor(String author) {
        List<Document> result = new ArrayList<>();
        for (Document document : documentLists) {
            if (document instanceof Book && ((Book) document).getAuthorNames().equalsIgnoreCase(author)) {
                result.add(document);
            }
        }
        return result;
    }

    public void borrowDocument(String borrowerId, String documentId) {
        Borrower borrower = findBorrowerById(borrowerId);
        Document document = findDocumentById(documentId);

        if (borrower != null && document != null) {
            if (document.getQuantity() > 0) {
                borrower.borrowDocument(document);
                document.setQuantity(document.getQuantity() - 1);
                System.out.println("Document borrowed successfully.");
            } else {
                System.out.println("Document is not available for borrowing.");
            }
        } else {
            System.out.println("Borrowing failed. Either borrower or document not found.");
        }
    }

    public void returnDocument(String borrowerId, String documentId) {
        Borrower borrower = findBorrowerById(borrowerId);
        Document document = findDocumentById(documentId);

        if (borrower != null && document != null) {
            borrower.returnDocument(document);
            document.setQuantity(document.getQuantity() + 1);
            System.out.println("Document returned successfully.");
        } else {
            System.out.println("Returning failed. Either borrower or document not found.");
        }
    }

    public void displayAllDocuments() {
        for (Document document : documentLists) {
            System.out.println(document);
        }
    }

    public void removeDocument(String documentId) {
        Document document = findDocumentById(documentId);
        if (document != null) {
            boolean isBorrowed = false;
            for (Borrower borrower : borrowerList) {
                if (borrower.getBorrowedDocuments().contains(document)) {
                    isBorrowed = true;
                    break;
                }
            }
            if (!isBorrowed) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Are you sure you want to delete this document? (yes/no): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    documentLists.remove(document);
                    System.out.println("Document removed successfully.");
                } else {
                    System.out.println("Document removal canceled.");
                }
            } else {
                System.out.println("Document is currently borrowed and cannot be removed.");
            }
        } else {
            System.out.println("Document not found.");
        }
    }
}
