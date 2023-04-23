package charan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Timetable {
    private List<FitnessLesson> lessons;

    public Timetable() {
        this.lessons = new ArrayList<>();
    }

    public void addLesson(FitnessLesson lesson) {
        lessons.add(lesson);
    }

    public List<FitnessLesson> getLessonsByDay(String day) {
        return lessons.stream()
                .filter(lesson -> lesson.getDay().equalsIgnoreCase(day))
                .collect(Collectors.toList());
    }

    public List<FitnessLesson> getLessonsByType(String type) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public FitnessLesson getLessonById(int id) {
        return lessons.stream()
                .filter(lesson -> lesson.getLessonId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<FitnessLesson> getLessons() {
        return lessons;
    }
}
