package com.lazo.confizprep.practice.mockito;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    boolean existsById(Long id);
}