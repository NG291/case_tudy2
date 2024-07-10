package InformationDocuments;

public class Newspaper extends Document {
    private String authorName;
    private int releaseDate;

    public Newspaper(String materialCode, String title, String publisherName, int quantity, String authorName, int releaseDate) {
        super(materialCode, title, publisherName, quantity);
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "materialCode='" + getMaterialCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisherName='" + getPublisherName() + '\'' +
                ", quantity=" + getQuantity() + '\'' +
                ", authorName='" + authorName + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
