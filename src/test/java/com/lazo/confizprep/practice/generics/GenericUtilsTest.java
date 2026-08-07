package com.lazo.confizprep.practice.generics;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenericUtilsTest {

    @Test
    void shouldReturnFirstValue() {
        // Arrange
        List<String> names = List.of(
                "Jose",
                "Ana",
                "Carlos"
        );

        // Act
        Optional<String> result = GenericUtils.getFirst(names);

        // Assert
        assertEquals(Optional.of("Jose"), result);
    }

    @Test
    void shouldReturnEmptyWhenListIsEmpty() {
        List<String> names = List.of();

        Optional<String> result = GenericUtils.getFirst(names);

        assertEquals(Optional.empty(), result);
    }

    @Test
    void shouldReturnTrueWhenValueExists() {
        List<String> names = List.of(
                "Jose",
                "Ana",
                "Carlos"
        );

        boolean result = GenericUtils.contains(names, "Ana");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenValueDoesNotExist() {
        List<String> names = List.of(
                "Jose",
                "Ana",
                "Carlos"
        );

        boolean result = GenericUtils.contains(names, "Mario");

        assertFalse(result);
    }
}