import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;


//implementarea clasei CatalogUtil
public class CatalogUtil {




    //metoda save(folosita pentru a salva continutul fisierului in path-ul dat)
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }

    }
    //metoda load(folosita pentru a incarca un fisier din path-ul dat)
    public static Catalog load(String path)
            throws InvalidCatalogException {
        try (var oos = new ObjectInputStream(
                new FileInputStream(path))) {
            Catalog catalog=(Catalog)oos.readObject();
            oos.close();
            return catalog;
        }

        catch (FileNotFoundException e) {
            System.err.println("File not found...");
        } catch (IOException e) {
            System.out.println("I/O Error");
        } catch (Exception e){
            System.out.println("Something is wrong..." + e);
        }

     return null;
    }
    //metoda view(folosita pentru a afisa continutul fisierului dat)
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        if(doc.getLocation().startsWith("http"))
        {URI u = new URI(doc.getLocation());
            desktop.browse(u);
        }
        else {
            File u=new File(doc.getLocation());
            desktop.open(u);
        }
    }
}