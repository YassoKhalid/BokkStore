import java.util.NoSuchElementException;

public class BookStore {
    final Inventory inventory = new Inventory();

    public void AddBook(Book book, int Quantity) {
        inventory.AddBook(book, Quantity);
    }

    public void RemoveBook(String ISBN) {
        inventory.RemoveBook(ISBN);
    }

    public void TryDemo(String ISBN) {
        if (!inventory.FindBook(ISBN)) {
            throw new NoSuchElementException("There is no book with ISBN " + ISBN);
        }
        Book book = inventory.books.get(ISBN);
        if (book instanceof DemoBook) {
            System.out.println("Thank you BookStore For" + book.Title);
        } else {
            throw new IllegalArgumentException("The book is not DEMO");
        }
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
            throw new NoSuchElementException("Cannot Buy DemoBook");
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
