package casestudy.Question3;

public class BabyClass extends NurseryClass {

    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    @Override
    public void enrollStudent(Student student) {
        if (student.age >= 2 && student.age <= 3 && students.size() < maxCapacity && student.registeredClass == null) {
            students.add(student);
            student.registeredClass = this;
            System.out.println(student.studentName + " enrolled in Baby Class.");
        } else {
            System.out.println("Enrollment failed for " + student.studentName);
        }
    }

    @Override
    public void trackProgress() {
        progressNotes = "Motor skills and play-based learning activities observed.";
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Activity conducted: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Baby Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of students: " + students.size());
        System.out.println("Activities: " + activities);
        System.out.println("Progress: " + progressNotes);
    }

    @Override
    public void assignTeacher(Teacher teacher) {
        if (teacher.teacherRole.equals("Early Childhood Educator")) {
            super.assignTeacher(teacher);
        } else {
            System.out.println("Invalid teacher role for Baby Class.");
        }
    }
}

