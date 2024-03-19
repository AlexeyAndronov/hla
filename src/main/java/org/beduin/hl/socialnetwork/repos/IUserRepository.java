package org.beduin.hl.socialnetwork.repos;

import org.beduin.hl.socialnetwork.dto.UserDto;

import java.util.Collection;
import java.util.Optional;

public interface IUserRepository {

    Optional<UserDto> getUser(Integer id);
    void storeUser(UserDto item);
    Collection<UserDto> getUsers();

}
