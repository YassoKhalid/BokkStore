public class MailService implements DeliveryService {
    @Override
    public void Deliver(Book book, int quantity, String DestinationAddress) {
        System.out.println("Mail Service Delivers " + quantity + " Of " + book.getTitle() + " To " + DestinationAddress);
    }
}
