import java.util.ArrayList;
import java.util.Collections;

class Student {
    protected String name;
    protected int[] quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new int[15];
    }

    public double calculateAverageQuizScore() {
        int total = 0;
        for(int score: quizScores) {
            total += score;
        }
        return (double) total / quizScores.length;
    }
}

class FullTimeStudent extends Student {
    private int[] examScores;

    public FullTimeStudent(String name) {
        super(name);
        this.examScores = new int[2];
    }

    public void setExamScores(int[] examScores) {
        this.examScores = examScores;
    }

    public int[] getExamScores() {
        return examScores;
    }
}

class PartTimeStudent extends Student {
    public PartTimeStudent(String name){
        super(name);
    }
}

class Session {
    private ArrayList<Student> students;

    public Session() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateClassAverageQuizScore() {
        double total = 0;
        for (Student student : students) {
            total += student.calculateAverageQuizScore();
        }
        return total / students.size();
    }

    public void printQuizScoresAscending() {
        ArrayList<Integer> allQuizScores = new ArrayList<>();
        for (Student student : students) {
            for (int score : student.quizScores) {
                allQuizScores.add(score);
            }
        }
        Collections.sort(allQuizScores);
        System.out.println("Quiz Scores in Ascending Order:");
        System.out.println(allQuizScores);
    }

    public void printPartTimeStudentNames() {
        System.out.println("Part-Time Student Names:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.name);
            }
        }
    }

    public void printFullTimeStudentExamScores() {
        System.out.println("Full-Time Student Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                FullTimeStudent fullTimeStudent = (FullTimeStudent) student;
                System.out.println(fullTimeStudent.name + ": " + fullTimeStudent.getExamScores()[0] + ", "
                        + fullTimeStudent.getExamScores()[1]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Session session = new Session();

        // Populate with dummy data
        for (int i = 0; i < 10; i++) {
            FullTimeStudent fullTimeStudent = new FullTimeStudent("Full-Time Student " + (i + 1));
            fullTimeStudent.setExamScores(new int[]{80 + i, 85 + i});
            fullTimeStudent.quizScores = new int[]{70 + i, 75 + i, 80 + i, 85 + i, 90 + i, 95 + i, 100 + i, 105 + i,
                    110 + i, 115 + i, 120 + i, 125 + i, 130 + i, 135 + i, 140 + i};
            session.addStudent(fullTimeStudent);
        }

        for (int i = 0; i < 10; i++) {
            PartTimeStudent partTimeStudent = new PartTimeStudent("Part-Time Student " + (i + 1));
            partTimeStudent.quizScores = new int[]{60 + i, 65 + i, 70 + i, 75 + i, 80 + i, 85 + i, 90 + i, 95 + i,
                    100 + i, 105 + i, 110 + i, 115 + i, 120 + i, 125 + i, 130 + i};
            session.addStudent(partTimeStudent);
        }

        // Call public methods and capture output
        System.out.println("Average Quiz Score for the whole class: " + session.calculateClassAverageQuizScore());
        session.printQuizScoresAscending();
        session.printPartTimeStudentNames();
        session.printFullTimeStudentExamScores();
    }
}