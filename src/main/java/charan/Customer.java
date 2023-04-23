package charan;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private List<Booking> bookings;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean bookLesson(FitnessLesson lesson) {
        if (lesson.getCurrentCapacity() < lesson.getMaxCapacity()) {
            Booking booking = new Booking(this, lesson);
            bookings.add(booking);
            lesson.increaseCurrentCapacity();
            return true;
        }
        return false;
    }

    public boolean changeBooking(int bookingId, FitnessLesson newLesson) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                if (newLesson.getCurrentCapacity() < newLesson.getMaxCapacity()) {
                    booking.getFitnessLesson().decreaseCurrentCapacity();
                    booking.setFitnessLesson(newLesson);
                    newLesson.increaseCurrentCapacity();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelBooking(int bookingId) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == bookingId) {
                bookings.get(i).getFitnessLesson().decreaseCurrentCapacity();
                bookings.remove(i);
                return true;
            }
        }
        return false;
    }
}
