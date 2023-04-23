package charan;

public class Booking {
    private static int lastBookingId = 0;

    private int bookingId;
    private Customer customer;
    private FitnessLesson fitnessLesson;
    private boolean isAttended;

    public Booking(Customer customer, FitnessLesson fitnessLesson) {
        this.bookingId = generateBookingId();
        this.customer = customer;
        this.fitnessLesson = fitnessLesson;
        this.isAttended = false;
    }



    public Booking(int bookingId, Customer customer, FitnessLesson fitnessLesson) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.fitnessLesson = fitnessLesson;
        this.isAttended = false;
    }
    
    private static int generateBookingId() {
        lastBookingId++;
        return lastBookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public FitnessLesson getFitnessLesson() {
        return fitnessLesson;
    }

    public boolean isAttended() {
        return isAttended;
    }

    public void setFitnessLesson(FitnessLesson fitnessLesson) {
        this.fitnessLesson = fitnessLesson;
    }

    public void attend() {
        this.isAttended = true;
    }
}
