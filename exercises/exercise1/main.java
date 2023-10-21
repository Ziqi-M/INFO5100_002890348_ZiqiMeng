import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private String name;
    private List<Integer> quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new ArrayList<>();
    }

    public void addQuizScore(int score) {
        quizScores.add(score);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getQuizScores() {
        return quizScores;
    }
}

class PartTimeStudent extends Student {
    public PartTimeStudent(String name) {
        super(name);
    }
}

class FullTimeStudent extends Student {
    private int examScore1;
    private int examScore2;

    public FullTimeStudent(String name, int examScore1, int examScore2) {
        super(name);
        this.examScore1 = examScore1;
        this.examScore2 = examScore2;
    }

    public int getExamScore1() {
        return examScore1;
    }

    public int getExamScore2() {
        return examScore2;
    }
}

class Session {
    private List<Student> students;

    public Session() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateAverageQuizScore() {
        double totalQuizScore = 0;
        int totalStudents = 0;
        for (Student student : students) {
            totalQuizScore += student.getQuizScores().stream().mapToInt(Integer::intValue).sum();
            totalStudents += student.getQuizScores().size();
        }
        return totalQuizScore / totalStudents;
    }

    public void printQuizScoresAscending() {
        List<Integer> allQuizScores = new ArrayList<>();
        for (Student student : students) {
            allQuizScores.addAll(student.getQuizScores());
        }
        Collections.sort(allQuizScores);
        System.out.println("Quiz Scores in Ascending Order: " + allQuizScores);
    }

    public void printPartTimeStudents() {
        System.out.println("Part-Time Students:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeExamScores() {
        System.out.println("Full-Time Students' Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                FullTimeStudent fullTimeStudent = (FullTimeStudent) student;
                System.out.println(student.getName() + " - Exam 1: " + fullTimeStudent.getExamScore1() +
                        ", Exam 2: " + fullTimeStudent.getExamScore2());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Session session = new Session();

        // Populate the session with students and dummy scores
        for (int i = 1; i <= 15; i++) {
            PartTimeStudent partTimeStudent = new PartTimeStudent("Part-Time Student " + i);
            FullTimeStudent fullTimeStudent = new FullTimeStudent("Full-Time Student " + i, 85 + i, 90 - i);

            // Add quiz scores for each student
            for (int j = 1; j <= 15; j++) {
                partTimeStudent.addQuizScore((int) (Math.random() * 100));
                fullTimeStudent.addQuizScore((int) (Math.random() * 100));
            }

            session.addStudent(partTimeStudent);
            session.addStudent(fullTimeStudent);
        }

        // Test the session methods
        System.out.println("Average Quiz Score: " + session.calculateAverageQuizScore());
        session.printQuizScoresAscending();
        session.printPartTimeStudents();
        session.printFullTimeExamScores();
    }
}
