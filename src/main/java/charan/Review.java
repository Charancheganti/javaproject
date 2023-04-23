package charan;

public class Review {
    private int reviewId;
    private int customerId;
    private int rating;
    private String text;

    public Review(int reviewId, int customerId, int rating, String text) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.rating = rating;
        this.text = text;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }
}
