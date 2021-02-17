package hackerrank.algorithms.medium;

import common.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class MatricesTest {

	static Stream<Arguments> arguments = Stream.of(
		Arguments.of(new int[][]{{0,0},{0,0}}, 0), 
		Arguments.of(new int[][]{{0,0},{0,1}}, 1), 
		Arguments.of(new int[][]{{0,1},{0,1}}, 1), 
		Arguments.of(new int[][]{{1,0},{1,0}}, 1), 
		Arguments.of(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 0),
		Arguments.of(new int[][]{{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}}, 2),
		Arguments.of(new int[][]{{0,0,3,1},{3,0,0,1},{0,0,0,1},{0,0,0,1}}, 7),
		Arguments.of(new int[][]{{2,0,0,1},{0,0,4,1},{0,0,3,1},{0,0,7,1}}, 13),
		Arguments.of(new int[][]{{112,42,83,119},{56,125,56,49},{15,78,101,43},{62,98,114,108}}, 414),
		Arguments.of(new int[][]{{0,0,0,1},{0,0,10,1},{0,0,0,10},{23,0,0,1}}, 33)
		);

	@ParameterizedTest
	@VariableSource("arguments")
	void testFlippingMatrix(int[][] matrix, int expected) {

		//Arrays.stream(matrix).flatMapToInt(row -> Arrays.stream(row)).forEach(System.out::println);

		int result = Matrices.flippingMatrix(matrix, false);

		assertEquals(expected, result);

	}

}
