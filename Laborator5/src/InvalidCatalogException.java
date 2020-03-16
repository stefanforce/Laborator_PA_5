//crearea exceptiei custom in caz ca avem un fisier catalog invalid
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}
