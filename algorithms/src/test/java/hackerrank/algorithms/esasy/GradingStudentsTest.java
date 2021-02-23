package hackerrank.algorithms.esasy;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GradingStudentsTest {

    public static final GradingStudents cut = new GradingStudents();

    // TDD 0
    @Test
    void gradingStudents_returnsAListOfIntegers() {
        List<Integer> grades = GradingStudents.gradingStudents(Collections.EMPTY_LIST);
        assertThat(grades, notNullValue(List.class));
    }

    // TDD 1
    @Test
    void gradingStudents_returnSameNumberOfElements() {
        List<Integer> grades = GradingStudents.gradingStudents(Arrays.asList(25, 33, 38, 42, 34, 85, 100, 99, 98, 97));
        List<Integer> expectedGrades = Arrays.asList(25, 33, 40, 42, 34, 85, 100, 100, 100, 97);
        assertThat(grades.size(), is(expectedGrades.size()));
    }

    // TDD
    @Test
    void gradingStudents_returnsGradesRounded() {
        List<Integer> grades = GradingStudents.gradingStudents(Arrays.asList(25, 33, 38, 42, 34, 85, 100, 99, 98, 97));
        List<Integer> expectedGrades = Arrays.asList(25, 33, 40, 42, 34, 85, 100, 100, 100, 97);
        assertArrayEquals(expectedGrades.toArray(),grades.toArray());
    }

}