package org.leadpony.justify.cli;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {
    
    public static Stream<Arguments> schemas() {
        return Stream.of(
                Arguments.of("arrays.schema.json", 0),
                Arguments.of("geographical-location.schema.json", 0),
                Arguments.of("person.schema.json", 0),
                Arguments.of("person-invalid.schema.json", 4),
                Arguments.of("nonexistent.schema.json", 1)
                );
    }

    @ParameterizedTest(name="[{index}] {0}")
    @MethodSource("schemas")
    public void testSchemaValidation(String path, int expected) {
        Validator validator = new Validator();
        String[] args = { path(path) };
        validator.validate(args);
        assertThat(validator.getNumberOfErrors()).isEqualTo(expected);
    }

    public static Stream<Arguments> instances() {
        return Stream.of(
                Arguments.of("arrays.schema.json", "arrays.json", 0),
                Arguments.of("arrays.schema.json", "arrays-invalid.json", 2),
                Arguments.of("geographical-location.schema.json", "geographical-location.json", 0),
                Arguments.of("geographical-location.schema.json", "geographical-location-invalid.json", 1),
                Arguments.of("person.schema.json", "person.json", 0),
                Arguments.of("person.schema.json", "person-invalid.json", 3),
                Arguments.of("person.schema.json", "nonexistent.json", 1),
                Arguments.of("nonexistent.schema.json", "person.json", 1)
                );
    }
    
    @ParameterizedTest(name="[{index}] {1}")
    @MethodSource("instances")
    public void testInstanceValidation(String schemaPath, String instancePath, int expected) {
        Validator validator = new Validator();
        String[] args = { path(schemaPath), path(instancePath) };
        validator.validate(args);
        assertThat(validator.getNumberOfErrors()).isEqualTo(expected);
    }
    
    @Test
    public void testNoArguments() {
        Validator validator = new Validator();
        String[] args = {};
        validator.validate(args);
    }
    
    private String path(String name) {
        return Paths.get("target", "test-classes", name).toString();
    }
}
