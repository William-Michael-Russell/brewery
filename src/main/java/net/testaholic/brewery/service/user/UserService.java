package net.testaholic.brewery.service.user;

import net.testaholic.brewery.domain.user.Users;
import net.testaholic.brewery.domain.user.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<Users> getUserById(long id);

    Optional<Users> getUserByEmail(String email);

    Collection<Users> getAllUsers();

    Users create(UserCreateForm form);

    Users update(UserCreateForm form, long id);

}
