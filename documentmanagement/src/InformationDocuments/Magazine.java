package InformationDocuments;

public class Magazine extends Document {

    private String magazineType;
    private int releaseMonth;

    public Magazine(String materialCode, String title, String publisherName, int quantity, String magazineType, int releaseMonth) {
        super(materialCode, publisherName, title, quantity);
        this.magazineType = magazineType;
        this.releaseMonth = releaseMonth;
    }

    public String getMagazineType() {
        return magazineType;
    }

    public void setMagazineType(String magazineType) {
        this.magazineType = magazineType;
    }


    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "materialCode='" + getMaterialCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publisherName='" + getPublisherName() + '\'' +
                ", quantity=" + getQuantity() + '\'' +
                ", magazineType='" + magazineType + '\'' +
                ", releaseMonth=" + releaseMonth +
                '}';
    }
}
