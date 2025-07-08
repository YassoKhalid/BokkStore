import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        DemoBook demobook = new DemoBook("E1", "The blue elephant", LocalDate.of(2010, Month.AUGUST, 23), 50);
        store.AddBook(demobook, 2);
        //trying to Try reading Demobook
        store.TryDemo("E1");
    }
}