package Week_1.DesignPattern_and_Principles._02_Answer;

import Week_1.DesignPattern_and_Principles._02_Answer.factories.DocumentFactory;
import Week_1.DesignPattern_and_Principles._02_Answer.factories.WordDocumentFactory;
import Week_1.DesignPattern_and_Principles._02_Answer.factories.PdfDocumentFactory;
import Week_1.DesignPattern_and_Principles._02_Answer.factories.ExcelDocumentFactory;
import Week_1.DesignPattern_and_Principles._02_Answer.documents.Document;

public class Test {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
