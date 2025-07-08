import java.time.Period;
import java.util.*;
import java.time.LocalDate;


public class Inventory {
    Map<String, Book> books = new HashMap<String, Book>();
    Map<String, Integer> Quantities = new HashMap<>();

    public void AddBook(Book book, int quantity) {
        if (books.containsKey(book.getISBN())) {
            Quantities.compute(book.getISBN(), (k, OldQuantity) -> quantity + OldQuantity);
        }
        if (!books.containsKey(book.getISBN())) {
            Quantities.put(book.getISBN(), quantity);
            books.put(book.getISBN(), book);
        }
        System.out.println("Book Added Successfully");
    }

    public void RemoveBook(String ISBN) {
        books.remove(ISBN);
        Quantities.remove(ISBN);
    }

    public List<String> RemoveOldBooks(int NumberOfYears) {
        List<String> booksToRemove = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            LocalDate BookDate = entry.getValue().getPublicationDate();
            Period period = Period.between(currentDate, BookDate);
            if (period.getYears() >= NumberOfYears) {
                booksToRemove.add(entry.getValue().getISBN());
            }
        }
        for (String i : booksToRemove) {
            RemoveBook(i);
        }
        return booksToRemove;
    }

    void ChangeQuantity(String ISBN, int Quantity) {
        if (!books.containsKey(ISBN)) {
            throw new NoSuchElementException("Book does not exist");
        }
        Quantities.put(ISBN, Quantity);
    }

    boolean FindBook(String ISBN) {
        return books.containsKey(ISBN);
    }
}
