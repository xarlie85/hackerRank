package hackerrank.common;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.support.AnnotationConsumer;

public class VariableArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<VariableSource> {

	private String variableName;

	@Override
	public void accept(VariableSource variableSource) {
		variableName = variableSource.value();
	}

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return context.getTestClass()
				.map(this::getField)
				.map(this::getValue)
				.orElseThrow(() -> 
				new IllegalArgumentException("Failed to load test arguments"));
	}
	
	private Field getField(Class<?> clazz) {
        try {
            return clazz.getDeclaredField(variableName);
        } catch (Exception e) {
            return null;
        }
    }
	
	@SuppressWarnings("unchecked")
    private Stream<Arguments> getValue(Field field) {
        Object value = null;
        try {
        	field.setAccessible(true); // when non-public neither in the same package attribute access
            value = field.get(null);
        } catch (Exception ignored) {}
 
        return value == null ? null : (Stream<Arguments>) value;
    }

}
