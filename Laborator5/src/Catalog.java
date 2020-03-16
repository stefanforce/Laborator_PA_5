import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//implementarea clasei catalog.
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    //adaugrea unui document la catalog
    //implementam clasa Serializable pentru a permite serializarea (translatarea informatiei de tip obiect sub forma de data care poate fi stocata)

    public void add(Document doc) {
        documents.add(doc);
    }
    //cautarea unui document in Catalog
    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
    //setteri,getteri si constructorii pentru campurile clasei catalog
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
