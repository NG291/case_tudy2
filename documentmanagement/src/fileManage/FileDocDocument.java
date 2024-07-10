package fileManage;

import InformationDocuments.Book;
import InformationDocuments.Document;
import InformationDocuments.Magazine;
import InformationDocuments.Newspaper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDocDocument {
    private static final String FILE_NAME = "D:\\case_study\\documentmanagement\\src\\fileTxt\\dataDoc.txt";

    public static List<Document> read() {
        List<Document> documentList = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String documentType = data[0];
                switch (documentType) {
                    case "Book":
                        String bookCode = data[1];
                        String bookTitle = data[2];
                        String bookPublisher = data[3];
                        int bookQuantity = Integer.parseInt(data[4]);
                        String bookAuthor = data[5];
                        String bookType = data[6];
                        int productionYear = Integer.parseInt(data[7]);
                        Book book = new Book(bookCode, bookTitle, bookPublisher, bookQuantity, bookAuthor, bookType, productionYear);
                        documentList.add(book);

                        break;
                    case "Magazine":
                        String magazineId = data[1];
                        String magazineTitle = data[2];
                        String magazinePublisher = data[3];
                        int magazineQuantity = Integer.parseInt(data[4]);
                        String magazineType = data[5];
                        int magazineMonth = Integer.parseInt(data[6]);
                        Magazine magazine = new Magazine(magazineId, magazineTitle, magazinePublisher, magazineQuantity, magazineType, magazineMonth);
                        documentList.add(magazine);
                        break;
                    case "Newspaper":
                        String newspaperId = data[1];
                        String newspaperTitle = data[2];
                        String newspaperPublisher = data[3];
                        int newspaperQuantity = Integer.parseInt(data[4]);
                        String newspaperAuthorName = data[5];
                        int newspaperDate = Integer.parseInt(data[6]);
                        Newspaper newspaper = new Newspaper(newspaperId, newspaperTitle, newspaperPublisher, newspaperQuantity, newspaperAuthorName, newspaperDate);
                        documentList.add(newspaper);
                        break;
                    default:
                        System.out.println("Unknown document type: " + documentType);
                        break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {

            System.out.println("hello");
            e.printStackTrace();
        }

        return documentList;
    }

    public static void write(List<Document> documentList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Document document : documentList) {
                if (document instanceof Book) {
                    Book book = (Book) document;
                    writer.write(String.format("Book,%s,%s,%s,%d,%s,%s,%d\n",
                            book.getMaterialCode(), book.getTitle(), book.getPublisherName(), book.getQuantity(), book.getAuthorNames(), book.getTypeBook(), book.getProductionYear()));
                } else if (document instanceof Magazine) {
                    Magazine magazine = (Magazine) document;
                    writer.write(String.format("Magazine,%s,%s,%s,%d,%s,%d\n",
                            magazine.getMaterialCode(), magazine.getTitle(), magazine.getPublisherName(), magazine.getQuantity(), magazine.getMagazineType(), magazine.getReleaseMonth()));
                } else if (document instanceof Newspaper) {
                    Newspaper newspaper = (Newspaper) document;
                    writer.write(String.format("Newspaper,%s,%s,%s,%d,%s,%d\n",
                            newspaper.getMaterialCode(), newspaper.getTitle(), newspaper.getPublisherName(), newspaper.getQuantity(), newspaper.getAuthorName(), newspaper.getReleaseDate()));
                }
            }
            writer.close();
            System.out.println("Documents written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing documents to file: " + e.getMessage());
        }
    }

}
