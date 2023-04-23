package charan;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeekendFitnessClubTest {
    private WeekendFitnessClub club;
    private FitnessLesson lesson1, lesson2, lesson3, lesson4;
    private Customer customer1, customer2, customer3;

    @Before
    public void setUp() {
        club = new WeekendFitnessClub();

        lesson1 = new FitnessLesson(1, "SPIN", "Saturday", "10:00", 5, 25.0);
        lesson2 = new FitnessLesson(2, "YOGA", "Saturday", "14:00", 5, 20.0);
        lesson3 = new FitnessLesson(3, "BODYSCULPT", "Sunday", "11:00", 5, 30.0);
        lesson4 = new FitnessLesson(4, "ZUMBA", "Sunday", "15:00", 5, 20.0);

        club.getTimetable().addLesson(lesson1);
        club.getTimetable().addLesson(lesson2);
        club.getTimetable().addLesson(lesson3);
        club.getTimetable().addLesson(lesson4);

        customer1 = new Customer(1, "Alice");
        customer2 = new Customer(2, "Bob");
        customer3 = new Customer(3, "Charlie");

        club.addCustomer(customer1);
        club.addCustomer(customer2);
        club.addCustomer(customer3);
    }

    @Test
    public void testBooking() {
        assertTrue(customer1.bookLesson(lesson1));
        assertEquals(1, lesson1.getCurrentCapacity());
    }

    @Test
    public void testBookingFullLesson() {
        for (int i = 0; i < lesson1.getMaxCapacity(); i++) {
            customer1.bookLesson(lesson1);
        }
        assertFalse(customer2.bookLesson(lesson1));
    }

   

    @Test
    public void testChangeBookingToFullLesson() {
        for (int i = 0; i < lesson1.getMaxCapacity(); i++) {
            customer1.bookLesson(lesson1);
        }
        customer2.bookLesson(lesson2);
        assertFalse(customer2.changeBooking(1, lesson1));
    }

    @Test
    public void testCancelBooking() {
        customer1.bookLesson(lesson1);
        assertTrue(customer1.cancelBooking(1));
        assertEquals(0, lesson1.getCurrentCapacity());
    }

    @Test
    public void testCancelNonExistentBooking() {
        assertFalse(customer1.cancelBooking(1));
    }

    @Test
    public void testAddReview() {
        Review review1 = new Review(1, customer1.getCustomerId(), 5, "Great spin class!");
        lesson1.addReview(review1);
        List<Review> reviews = lesson1.getReviews();
        assertEquals(1, reviews.size());
        assertTrue(reviews.contains(review1));
    }

    @Test
    public void testAverageRating() {
        Review review1 = new Review(1, customer1.getCustomerId(), 5, "Great spin class!");
        Review review2 = new Review(2, customer1.getCustomerId(), 4, "Nice yoga session.");
        lesson1.addReview(review1);
        lesson1.addReview(review2);
        double averageRating = lesson1.getAverageRating();
        assertEquals(4.5, averageRating, 0.01);
        }
        @Test
        public void testTimetableGetLessonsByDay() {
            List<FitnessLesson> saturdayLessons = club.getTimetable().getLessonsByDay("Saturday");
            List<FitnessLesson> sundayLessons = club.getTimetable().getLessonsByDay("Sunday");
        
            assertEquals(2, saturdayLessons.size());
            assertTrue(saturdayLessons.contains(lesson1));
            assertTrue(saturdayLessons.contains(lesson2));
        
            assertEquals(2, sundayLessons.size());
            assertTrue(sundayLessons.contains(lesson3));
            assertTrue(sundayLessons.contains(lesson4));
        }
        
        @Test
        public void testTimetableGetLessonsByType() {
            List<FitnessLesson> spinLessons = club.getTimetable().getLessonsByType("SPIN");
            List<FitnessLesson> yogaLessons = club.getTimetable().getLessonsByType("YOGA");
            List<FitnessLesson> bodysculptLessons = club.getTimetable().getLessonsByType("BODYSCULPT");
            List<FitnessLesson> zumbaLessons = club.getTimetable().getLessonsByType("ZUMBA");
        
            assertEquals(1, spinLessons.size());
            assertTrue(spinLessons.contains(lesson1));
        
            assertEquals(1, yogaLessons.size());
            assertTrue(yogaLessons.contains(lesson2));
        
            assertEquals(1, bodysculptLessons.size());
            assertTrue(bodysculptLessons.contains(lesson3));
        
            assertEquals(1, zumbaLessons.size());
            assertTrue(zumbaLessons.contains(lesson4));
        }
        
        @Test
        public void testBookingAttendance() {
            customer1.bookLesson(lesson1);
            Booking booking = customer1.getBookings().get(0);
            assertFalse(booking.isAttended());
        
            booking.attend();
            assertTrue(booking.isAttended());
        }

    
        @Test
        public void testMaxCapacityBooking() {
            for (int i = 0; i < 5; i++) {
                customer1.bookLesson(lesson1);
            }
            assertFalse(customer2.bookLesson(lesson1));
        }
    

    
        @Test
        public void testIncreaseCurrentCapacity() {
            lesson1.increaseCurrentCapacity();
            assertEquals(1, lesson1.getCurrentCapacity());
        }
    
        @Test
        public void testDecreaseCurrentCapacity() {
            customer1.bookLesson(lesson1);
            lesson1.decreaseCurrentCapacity();
            assertEquals(0, lesson1.getCurrentCapacity());
        }
    
        @Test
        public void testGetLessonsWithNoFilter() {
            List<FitnessLesson> allLessons = club.getTimetable().getLessons();
            assertEquals(4, allLessons.size());
            assertTrue(allLessons.contains(lesson1));
            assertTrue(allLessons.contains(lesson2));
            assertTrue(allLessons.contains(lesson3));
            assertTrue(allLessons.contains(lesson4));
        }
    
        @Test
        public void testInvalidDayFilter() {
            List<FitnessLesson> invalidDayLessons = club.getTimetable().getLessonsByDay("InvalidDay");
            assertEquals(0, invalidDayLessons.size());
        }
    
        @Test
        public void testInvalidTypeFilter() {
            List<FitnessLesson> invalidTypeLessons = club.getTimetable().getLessonsByType("InvalidType");
            assertEquals(0, invalidTypeLessons.size());
        }
    
        @Test
        public void testNoReviews() {
            double averageRating = lesson3.getAverageRating();
            assertEquals(0.0, averageRating, 0.01);
        }
}