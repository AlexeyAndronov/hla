package org.beduin.hl.socialnetwork.services;

import lombok.AllArgsConstructor;
import org.beduin.hl.socialnetwork.dto.UserDto;
import org.beduin.hl.socialnetwork.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public UserDto getUser(Integer id) {

        System.out.println("-------------------------getUser------------------------------");

        try {
            UserDto user = userRepository.getUser(id).get();
            return user;
        }
        catch (Exception ex) {
            return null;
        }
    }

    public void createUser(UserDto item) {
        System.out.println("------------- Дошли до сервиса crateUser-------");
        userRepository.storeUser(item);
    }

    public List<UserDto> getUsers() {
        System.out.println("======= Дошли до сервиса getUsers================");
        return userRepository.getUsers().stream().toList();}

}
