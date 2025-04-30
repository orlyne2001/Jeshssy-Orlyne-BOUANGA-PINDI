package casestudy.Question3;

public class MiddleClass extends NurseryClass {

    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    @Override
    public void enrollStudent(Student student) {
        if (student.age >= 3 && student.age <= 4 && students.size() < maxCapacity && student.registeredClass == null) {
            students.add(student);
            student.registeredClass = this;
            System.out.println(student.studentName + " enrolled in Middle Class.");
        } else {
            System.out.println("Enrollment failed for " + student.studentName);
        }
    }

    @Override
    public void trackProgress() {
        progressNotes = "Students progressing in language development and counting.";
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Activity conducted: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Middle Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of students: " + students.size());
        System.out.println("Activities: " + activities);
        System.out.println("Progress: " + progressNotes);
    }
}

