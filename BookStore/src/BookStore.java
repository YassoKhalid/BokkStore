import java.util.NoSuchElementException;

public class BookStore {
    private final Inventory inventory = new Inventory();

    public void AddBook(Book book, int Quantity) {
        inventory.AddBook(book, Quantity);
    }

    public void RemoveBook(String ISBN) {
        inventory.RemoveBook(ISBN);
    }

    public double BuyBook(String ISBN, int Quantity, String Email, String Address) {
        if (Quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        if (!inventory.FindBook(ISBN)) {
            throw new NoSuchElementException("Book does not exist");
        }
        Book book = inventory.books.get(ISBN);
        if (book instanceof DemoBook) {
            book.Deliver(Quantity, Email, Address);
            return 0;
        }
        double PaidAmount = book.Price * Quantity;
        if (book instanceof PaperBook paperBook) {
            if (paperBook.AvailableQuantity < Quantity) {
                throw new IllegalArgumentException("Paper Book Quantity Exceeded");
            }
            PaidAmount += paperBook.ShippingCost * Quantity;
            inventory.DecrementBook(book, Quantity);
        }
        book.Deliver(Quantity, Email, Address);
        return PaidAmount;
    }
}
