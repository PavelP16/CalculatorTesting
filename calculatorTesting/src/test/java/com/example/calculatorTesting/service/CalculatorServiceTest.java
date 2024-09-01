package com.example.calculatorTesting.service;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;



class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    private static final Random random = new Random();

    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSum(int num1, int num2) {
        int expected = num1 + num2;

        //test
        int actual = calculatorService.getSummary(num1, num2);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shouldThrowException_WhenParamNullForSum(String message, Integer num1, Integer num2) {
        // test
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getSummary(num1, num2));
    }


    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSub(int num1, int num2) {
        int expected = num1 - num2;

        //test
        int actual = calculatorService.getSummary(num1, num2);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shouldThrowException_WhenParamNullSub(String message, Integer num1, Integer num2) {
        // test
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getSubtraction(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultMulti(int num1, int num2) {
        int expected = num1 * num2;

        //test
        int actual = calculatorService.getSummary(num1, num2);
        //check
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shouldThrowException_WhenParamNullMulti(String message, Integer num1, Integer num2) {
        // test
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getMultiply(num1, num2));
    }






    private static Stream<Arguments> provideNullParams() {
        return Stream.of(Arguments.of("Отсутствует первый параметр", null, random.nextInt()),
                Arguments.of("Отсутствует второй параметр", random.nextInt(), null),
                Arguments.of("Отсутствуют оба параметр", null, null)
        );
    }


    private static Stream<Arguments> provideDifferentNumbers() {
        return Stream.of(Arguments.of(0, 0),
                Arguments.of(100, 2),
                Arguments.of(-1, 2),
                Arguments.of(10000, 10000)
        );
    }

}


