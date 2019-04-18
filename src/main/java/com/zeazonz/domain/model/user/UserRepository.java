package com.zeazonz.domain.model.user;

import java.util.Optional;

public interface UserRepository {
    void save(User persisted);
    Optional<User> findUserByEmailAndPassword(Email email,String password);
    void delete(User user);
}
