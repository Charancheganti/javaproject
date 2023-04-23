package charan;

import java.util.ArrayList;
import java.util.List;

public class WeekendFitnessClub {
    private Timetable timetable;
    private List<Customer> customers;

    public WeekendFitnessClub() {
        this.timetable = new Timetable();
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void generateReports() {
        Reports.generateCustomersPerLessonReport(timetable);
        Reports.generateHighestIncomeLessonTypeReport(timetable);
    }

    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // Add the missing getter method for the timetable
    public Timetable getTimetable() {
        return timetable;
    }
}
