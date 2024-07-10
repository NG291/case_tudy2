package fileManage;

import InformationCustomers.Borrower;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileDocBorrower {
    private static final String FILE_NAME1 = "D:\\case_study\\documentmanagement\\src\\fileTxt\\dataCustomer.txt";

    public static List<Borrower> readFileBorrower() {
        List<Borrower> borrowerList = new ArrayList<>();
        try {
            File file = new File(FILE_NAME1);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                    String borrowerCode = data[0];
                    String borrowerName = data[1];
                    String borrowerPhone = data[2];
                    String borrowerGender = data[3];
                    Borrower borrower = new Borrower(borrowerCode, borrowerName, borrowerPhone, borrowerGender);
                    borrowerList.add(borrower);

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return borrowerList;
    }

    public static void writeFileBorrower(List<Borrower> borrowerList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME1));
            for (Borrower borrower : borrowerList) {
                String line = borrower.getCustomerCode() + "," +
                        borrower.getCustomerName() + "," +
                        borrower.getCustomerPhone() + "," +
                        borrower.getCustomerGender();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
