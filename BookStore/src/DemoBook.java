import java.time.LocalDate;

public class DemoBook extends Book {
    public DemoBook(String ISBN, String Title, LocalDate PublicationDate, double Price, DeliveryService deliveryService) {
        super(ISBN, Title, PublicationDate, Price, deliveryService);
    }
}
