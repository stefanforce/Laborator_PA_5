import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
//implementarea clasei document
//implementam clasa Serializable pentru a permite serializarea (translatarea informatiei de tip obiect sub forma de data care poate fi stocata)
public class Document implements Serializable {
    private String id;
    private String name;
    private String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();
    //adaugarea unui tag pentru document
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
    //setteri,getteri si constructorii pentru campurile clasei document
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
//…

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
