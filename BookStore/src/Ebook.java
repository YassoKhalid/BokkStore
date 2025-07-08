import java.time.LocalDate;
import java.util.Date;

public class Ebook extends Book {
    public Ebook(String ISBN, String Title, LocalDate PublicationDate, double Price) {
        DeliveryService deliveryService=new MailService();
        super(ISBN, Title, PublicationDate, Price, deliveryService);
    }
}
