package Week_1.DesignPattern_and_Principles._02_Answer.factories;
import Week_1.DesignPattern_and_Principles._02_Answer.documents.Document;
import Week_1.DesignPattern_and_Principles._02_Answer.documents.WordDocument;
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}