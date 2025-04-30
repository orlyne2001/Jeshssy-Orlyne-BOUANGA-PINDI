package casestudy.Question3;

public class TopClass extends NurseryClass {

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    @Override
    public void enrollStudent(Student student) {
        if (student.age >= 4 && student.age <= 5 && students.size() < maxCapacity && student.registeredClass == null) {
            students.add(student);
            student.registeredClass = this;
            System.out.println(student.studentName + " enrolled in Top Class.");
        } else {
            System.out.println("Enrollment failed for " + student.studentName);
        }
    }

    @Override
    public void trackProgress() {
        progressNotes = "Students are being prepared for primary school with reading, writing, and arithmetic.";
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Activity conducted: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Top Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of students: " + students.size());
        System.out.println("Activities: " + activities);
        System.out.println("Progress: " + progressNotes);
        System.out.println("Assessment: Done this term.");
    }
}

