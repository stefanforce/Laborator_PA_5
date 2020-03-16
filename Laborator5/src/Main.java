import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[])  {
       try {
           Main app = new Main();
           app.testCreateSave();
           app.testLoadView();
       }
       catch (IOException e){
           System.out.println("I/O Error");
       }
       catch (InvalidCatalogException e)
       {
           System.out.println("Invalid catalog file");
       }
    }
 //clasa de testare a crearii unui save
    private void testCreateSave() throws IOException {
        //cream un catalog
        Catalog catalog = new Catalog("Java Resources", "d:/Facultate/PA/Laborator5/catalog.ser");
        //cream un document
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        //ii adaugam un tag
        doc.addTag("type", "Slides");
        //adaugam documentul creat la catalog
        catalog.add(doc);
    //salvam catalogul
        CatalogUtil.save(catalog);
    }
    //clasa de testare a incarcare catalogului dintr-un fisier extern
    private void testLoadView() throws InvalidCatalogException {
        try{
            //facem load la catalogul deja salvat
            Catalog catalog = CatalogUtil.load("d:/Facultate/PA/Laborator5/catalog.ser");
            //cautam documentul care incepe cu id-ul java11
        Document doc = catalog.findById("java1");
        //afisam documentul selectat
        CatalogUtil.view(doc);}
        catch(NullPointerException e)
        {
            System.out.println("NullPointer exception");
        } catch (IOException e) {
            System.out.println("I/O Error");
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Error");
        }
    }
}