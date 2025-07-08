import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        LocalDate Date = LocalDate.of(1895, 12, 12);
        PaperBook book1 = new PaperBook("9865047", "Les Misrables", Date, 120.5, 20, 12.5);
        bookStore.AddBook(book1, 19);
        bookStore.BuyBook("9865047", 20, "yassenkhaled927@gmail.com", "Cairo");
        bookStore.RemoveBook("9865047");
        bookStore.RemoveBook("1234565");

    }
}