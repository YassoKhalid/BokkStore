import java.time.LocalDate;

public class Book {
    public String ISBN;
    public String Title;
    public LocalDate PublicationDate;
    public double Price;
    public DeliveryService deliveryService;

    Book(String ISBN, String Title, LocalDate PublicationDate, double Price, DeliveryService deliveryService) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.PublicationDate = PublicationDate;
        this.Price = Price;
        this.deliveryService = deliveryService;
    }

    Book(String ISBN, String Title, LocalDate PublicationDate, double Price) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.PublicationDate = PublicationDate;
        this.Price = Price;
    }

    String getTitle() {
        return Title;
    }

    LocalDate getPublicationDate() {
        return PublicationDate;
    }

    double getPrice() {
        return Price;
    }

    String getISBN() {
        return ISBN;
    }

    public void Deliver(int quantity, String Email, String DestinationAddress) {
        deliveryService.Deliver(this, quantity, DestinationAddress);
    }


}
