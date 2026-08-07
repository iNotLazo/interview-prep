package com.lazo.confizprep.practice.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void shouldReturnUserWhenUserExists() {
        // Arrange
        User expectedUser = new User(1L, "Jose");

        when(repository.findById(1L))
                .thenReturn(Optional.of(expectedUser));

        // Act
        User result = service.findById(1L);

        // Assert
        assertEquals(expectedUser, result);

        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        // Arrange
        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        // Act + Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.findById(99L)
        );

        assertEquals(
                "User not found: 99",
                exception.getMessage()
        );

        verify(repository).findById(99L);
    }

    @Test
    void shouldReturnTrueWhenUserExists() {
        when(repository.existsById(1L)).thenReturn(true);

        boolean result = service.exists(1L);

        assertTrue(result);

        verify(repository, times(1)).existsById(1L);
    }

    @Test
    void shouldReturnFalseWhenUserDoesNotExist() {
        when(repository.existsById(99L)).thenReturn(false);

        boolean result = service.exists(99L);

        assertFalse(result);

        verify(repository, times(1)).existsById(99L);
    }
}