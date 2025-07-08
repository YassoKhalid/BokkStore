import java.time.LocalDate;
import java.util.Date;

public class PaperBook extends Book {
    public int AvailableQuantity;
    double ShippingCost;
    public PaperBook(String ISBN, String Title, LocalDate PublicationDate, double Price, int AvailableQuantity) {
        DeliveryService deliveryService = new ShippingService();
        super(ISBN, Title, PublicationDate, Price, deliveryService);
        this.AvailableQuantity = AvailableQuantity;
    }

    public PaperBook(String ISBN, String Title, LocalDate PublicationDate, double Price, int AvailableQuantity, double ShippingFees) {
        DeliveryService deliveryService = new ShippingService(ShippingFees);
        super(ISBN, Title, PublicationDate, Price, deliveryService);
        this.AvailableQuantity = AvailableQuantity;
        this.ShippingCost = ShippingFees;
    }

    public int getAvailableQuantity() {
        return AvailableQuantity;
    }


}
