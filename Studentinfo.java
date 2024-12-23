package Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Student {
    int id;
    String name;
    int sub1;
    int sub2;
    int sub3;
    int fee;
    String college = "Stpeter College";
    int maxFee = 75000;

    public Student(int id, String name, int sub1, int sub2, int sub3, int fee) {
        super();
        this.id = id;
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3
                + ", fee=" + fee + ", college=" + college + ", maxFee=" + maxFee + "]";
    }

    // Check if student passed all subjects
    public boolean hasPassed() {
        return sub1 >= 35 && sub2 >= 35 && sub3 >= 35;  // Assume passing marks are 35 or above in each subject
    }

    // Check if fee is cleared or pending
    public boolean isFeeCleared() {
        return fee <= 50000; // Assuming fee is cleared if it's <= 50000
    }
}

class StudentMarks {

    static int getRandom(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        Student[] stu = new Student[35]; // Changed to 35 to match the loop count

        // Create student data
        for (int i = 0; i < 35; i++) {
            stu[i] = new Student(getRandom(50, 7890), "Student" + i, getRandom(0, 100), getRandom(10, 90),
                    getRandom(23, 65), getRandom(5000, 67000));
        }

        // Lists to hold pass and fail students
        List<Student> passStudents = new ArrayList<>();
        List<Student> failStudents = new ArrayList<>();

        // Lists to hold students with cleared and pending fees
        List<Student> clearedFeeStudents = new ArrayList<>();
        List<Student> pendingFeeStudents = new ArrayList<>();

        // Categorize students as pass or fail and fee status
        for (int i = 0; i < 35; i++) {
            if (stu[i].hasPassed()) {
                passStudents.add(stu[i]);
            } else {
                failStudents.add(stu[i]);
            }

            if (stu[i].isFeeCleared()) {
                clearedFeeStudents.add(stu[i]);
            } else {
                pendingFeeStudents.add(stu[i]);
            }
        }

        // Output pass and fail students
        System.out.println("Passed Students: ");
        for (Student s : passStudents) {
            System.out.println(s);
        }

        System.out.println("\nFailed Students: ");
        for (Student s : failStudents) {
            System.out.println(s);
        }

        // Output fee status students
        System.out.println("\nStudents with Cleared Fees: ");
        for (Student s : clearedFeeStudents) {
            System.out.println(s);
        }

        System.out.println("\nStudents with Pending Fees: ");
        for (Student s : pendingFeeStudents) {
            System.out.println(s);
        }
    }
}
