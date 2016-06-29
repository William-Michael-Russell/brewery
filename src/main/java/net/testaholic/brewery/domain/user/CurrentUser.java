package net.testaholic.brewery.domain.user;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Users users;

    public CurrentUser(Users users) {
        super(users.getEmail(), users.getPasswordHash(), AuthorityUtils.createAuthorityList(users.getRole().toString()));
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public Long getId() {
        return users.getId();
    }

    public Role getRole() {
        return users.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + users +
                "} " + super.toString();
    }
}
