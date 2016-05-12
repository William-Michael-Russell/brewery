package net.testaholic.brewery.service.currentuser;

import net.testaholic.brewery.domain.user.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
