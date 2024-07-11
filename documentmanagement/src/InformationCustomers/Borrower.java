package InformationCustomers;

import InformationDocuments.Document;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String customerCode;
    private String customerName;
    private String customerPhone;
    private String customerGender;
    private List<Document> borrowedDocuments;

    public Borrower(String customerCode, String customerName, String customerPhone, String customerGender) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.borrowedDocuments = new ArrayList<>();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public List<Document> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public void borrowDocument(Document document) {
        borrowedDocuments.add(document);
    }

    public void returnDocument(Document document) {
        borrowedDocuments.remove(document);
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", borrowedDocuments=" + borrowedDocuments +
                '}';
    }
}
