package charan;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
       // Create a Weekend Fitness Club
       WeekendFitnessClub club = new WeekendFitnessClub();

       // Create an array of Fitness Lesson types
       String[] lessonTypes = {"SPIN", "YOGA", "BODYSCULPT", "ZUMBA"};

       // Initialize Random generator
       Random rand = new Random();

       // Generate 8 weekends of timetable (32 lessons)
       int lessonId = 1;
       for (int week = 1; week <= 8; week++) {
           for (int day = 0; day < 2; day++) {
               String lessonDay = day == 0 ? "Saturday" : "Sunday";
               for (int lessonTime = 0; lessonTime < 4; lessonTime++) {
                   String time = (10 + lessonTime * 2) + ":00";
                   String lessonType = lessonTypes[rand.nextInt(lessonTypes.length)];
                   double price = 20 + rand.nextDouble() * 10;
                   FitnessLesson lesson = new FitnessLesson(lessonId++, lessonType, lessonDay, time, 5, price);
                   club.getTimetable().addLesson(lesson);
               }
           }
       }

       // Create Customers
       Customer customer1 = new Customer(1, "Alice");
       Customer customer2 = new Customer(2, "Bob");
       Customer customer3 = new Customer(3, "Charlie");

       // Add Customers to the Club
       club.addCustomer(customer1);
       club.addCustomer(customer2);
       club.addCustomer(customer3);


       // Randomly book lessons for customers
       for (int i = 0; i < 10; i++) {
           int randomLessonId = rand.nextInt(32) + 1;
           FitnessLesson randomLesson = club.getTimetable().getLessonById(randomLessonId);
           Customer randomCustomer = club.getCustomerById(rand.nextInt(3) + 1);
           randomCustomer.bookLesson(randomLesson);

           // Randomly add reviews for lessons
           int randomRating = rand.nextInt(5) + 1;
           Review randomReview = new Review(i + 1, randomCustomer.getCustomerId(), randomRating, "Random review.");
           randomLesson.addReview(randomReview);
       }

       // Generate Reports
       club.generateReports();
    }
}
