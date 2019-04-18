package com.zeazonz.infrastructure.repository.impl.user;

import com.zeazonz.domain.model.user.Email;
import com.zeazonz.domain.model.user.User;
import com.zeazonz.domain.model.user.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User persisted) {

    }

    @Override
    public Optional<User> findUserByEmailAndPassword(Email email, String password) {
        return Optional.empty();
    }

    @Override
    public void delete(User user) {

    }
}
