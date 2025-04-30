package casestudy.Question3;

import java.util.ArrayList;

public abstract class NurseryClass {
    String classId;
    String className;
    int maxCapacity;
    Teacher assignedTeacher;
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> activities = new ArrayList<>();
    String progressNotes = "";

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
        teacher.assignedClass = this;
    }

    public abstract void enrollStudent(Student student);
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract void generateClassReport();
}

