package casestudy.Question3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BabyClass babyClass = new BabyClass("BC001");
        MiddleClass middleClass = new MiddleClass("MC001");
        TopClass topClass = new TopClass("TC001");

        Teacher teacher1 = new Teacher("T01", "Ms. Joy", "Early Childhood Educator");
        Teacher teacher2 = new Teacher("T02", "Mr. Sam", "Assistant");
        Teacher teacher3 = new Teacher("T03", "Mrs. Rose", "Early Childhood Educator");

        babyClass.assignTeacher(teacher1);
        middleClass.assignTeacher(teacher2);
        topClass.assignTeacher(teacher3);

        Student student1 = new Student("S01", "Liam", 2, "Mrs. Smith");
        Student student2 = new Student("S02", "Emma", 3, "Mr. Brown");
        Student student3 = new Student("S03", "Noah", 4, "Ms. Johnson");
        Student student4 = new Student("S04", "Olivia", 5, "Mr. Wilson");

        babyClass.enrollStudent(student1);
        middleClass.enrollStudent(student2);
        middleClass.enrollStudent(student3);
        topClass.enrollStudent(student3);
        topClass.enrollStudent(student4);

        babyClass.conductActivity("Painting");
        middleClass.conductActivity("Storytelling");
        topClass.conductActivity("Writing Practice");

        babyClass.trackProgress();
        middleClass.trackProgress();
        topClass.trackProgress();

        babyClass.generateClassReport();
        middleClass.generateClassReport();
        topClass.generateClassReport();


    }
}

