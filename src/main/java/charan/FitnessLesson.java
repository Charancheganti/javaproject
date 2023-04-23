package charan;

import java.util.ArrayList;
import java.util.List;

public class FitnessLesson {
    private int lessonId;
    private String lessonType;
    private String day;
    private String startTime;
    private int maxCapacity;
    private int currentCapacity;
    private double price;
    private List<Review> reviews;

    public FitnessLesson(int lessonId, String lessonType, String day, String startTime, int maxCapacity, double price) {
        this.lessonId = lessonId;
        this.lessonType = lessonType;
        this.day = day;
        this.startTime = startTime;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public int getLessonId() {
        return lessonId;
    }

    public String getLessonType() {
        return lessonType;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public double getPrice() {
        return price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void increaseCurrentCapacity() {
        currentCapacity++;
    }

    public void decreaseCurrentCapacity() {
        currentCapacity--;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }

        return totalRating / reviews.size();
    }
}
