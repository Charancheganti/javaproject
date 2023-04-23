package charan;

import java.util.HashMap;
import java.util.Map;

public class Reports {
    public static void generateCustomersPerLessonReport(Timetable timetable) {
        System.out.println("Customers per Lesson Report:");
        for (FitnessLesson lesson : timetable.getLessons()) {
            System.out.printf("Lesson ID: %d, Lesson Type: %s, Day: %s, Time: %s, Customers: %d, Average Rating: %.2f%n",
                    lesson.getLessonId(), lesson.getLessonType(), lesson.getDay(), lesson.getStartTime(),
                    lesson.getCurrentCapacity(), lesson.getAverageRating());
        }
    }

    public static void generateHighestIncomeLessonTypeReport(Timetable timetable) {
        Map<String, Double> incomePerType = new HashMap<>();

        for (FitnessLesson lesson : timetable.getLessons()) {
            double income = lesson.getCurrentCapacity() * lesson.getPrice();
            incomePerType.put(lesson.getLessonType(),
                    incomePerType.getOrDefault(lesson.getLessonType(), 0.0) + income);
        }

        String highestIncomeType = null;
        double maxIncome = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : incomePerType.entrySet()) {
            if (entry.getValue() > maxIncome) {
                maxIncome = entry.getValue();
                highestIncomeType = entry.getKey();
            }
        }

        System.out.printf("Highest Income Lesson Type: %s, Total Income: %.2f%n", highestIncomeType, maxIncome);
    }
}
