package InformationDocuments;

public abstract class Document {
    private String materialCode;
    private String title;
    private String publisherName;
    private int quantity;

    public Document(String materialCode, String title, String publisherName, int quantity) {
        this.materialCode = materialCode;
        this.title = title;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Document{" +
                "materialCode='" + materialCode + '\'' +
                ", title='" + title + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
