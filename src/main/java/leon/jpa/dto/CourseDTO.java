package leon.jpa.dto;

public class CourseDTO {
    public String name;
    public int credits;
    public String teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public CourseDTO(String name, int credits, String teacher) {
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
    }
}
