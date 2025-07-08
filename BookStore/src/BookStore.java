import java.util.NoSuchElementException;

public class BookStore {
    private Inventory inventory = new Inventory();

    public void AddBook(Book book, int Quantity) {
        if (book instanceof PaperBook pb) {
            if (Quantity > pb.AvailableQuantity) {
                throw new NoSuchElementException("You can't add more than " + Quantity + " PaperBooks.");
            }
        }
        inventory.AddBook(book, Quantity);
    }

    public void RemoveBook(String ISBN) {
        inventory.RemoveBook(ISBN);
    }

    public double BuyBook(String ISBN, int Quantity, String Email, String Address) {
        if (!inventory.FindBook(ISBN)) {
            throw new NoSuchElementException("Book does not exist");
        }
        Book book = inventory.books.get(ISBN);
        double PaidAmount = book.Price * Quantity;
        if (book instanceof PaperBook paperBook) {
            if (paperBook.AvailableQuantity < Quantity) {
                throw new IllegalArgumentException("Paper Book Quantity Exceeded");
            }
            PaidAmount += paperBook.ShippingCost * Quantity;
            inventory.AddBook(book, -Quantity);
        }
        book.Deliver(Quantity, Email, Address);
        return PaidAmount;
    }
}
