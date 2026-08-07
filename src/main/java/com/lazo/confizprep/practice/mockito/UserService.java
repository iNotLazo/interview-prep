package com.lazo.confizprep.practice.mockito;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "User not found: " + id
                        )
                );
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}