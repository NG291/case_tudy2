package InformationDocuments;

public class Book extends Document {
    private String authorNames;
    private String typeBook;
    private int productionYear;

    public Book(String materialCode, String title, String publisherName, int quantity, String authorNames, String typeBook, int productionYear) {
        super(materialCode, title, publisherName, quantity);
        this.authorNames = authorNames;
        this.typeBook = typeBook;
        this.productionYear = productionYear;
    }

    public String getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(String typeBook) {
        this.typeBook = typeBook;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "materialCode='" + getMaterialCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisherName='" + getPublisherName() + '\'' +
                ", quantity=" + getQuantity() + '\'' +
                ", authorNames='" + authorNames + '\'' +
                ", typeBook='" + typeBook + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
