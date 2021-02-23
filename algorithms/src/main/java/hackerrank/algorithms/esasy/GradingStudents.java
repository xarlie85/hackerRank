package hackerrank.algorithms.esasy;

import hackerrank.annotations.Specification;

import java.util.List;
import java.util.stream.Collectors;

@Specification("https://www.hackerrank.com/challenges/grading/problem")
public class GradingStudents {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(GradingStudents::roundGrade).collect(Collectors.toList());
    }

    private static Integer roundGrade(Integer grade) {
        int nextMult5 = ((int) (grade / 5)) * 5 + 5;
        if (grade > 37 && nextMult5 - grade < 3) {
            grade = nextMult5;
        }
        return grade;
    }

}