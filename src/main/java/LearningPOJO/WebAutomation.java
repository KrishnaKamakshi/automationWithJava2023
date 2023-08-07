package LearningPOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebAutomation {

    private String courseTitle;
    private String price;

    public String getCoursesTitle() {
        return courseTitle;
    }

    public void setCoursesTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
