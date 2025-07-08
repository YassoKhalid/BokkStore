public class ShippingService implements DeliveryService {
    private double ShippingFees; // 0 if it is not Shipped

    ShippingService() {
        ShippingFees = 0;
    }

    ShippingService(double ShippingFees) {
        this.ShippingFees = ShippingFees;
    }

    @Override
    public void Deliver(Book book, int quantity, String DestinationAddress) {
        System.out.println("Shipping Service Delivers " + quantity + " Of " + book.getTitle() + " To " + DestinationAddress);
    }

    public double getShippingFees() {
        return ShippingFees;
    }

    public void setShippingFees(double shippingFees) {
        ShippingFees = shippingFees;
    }
}
