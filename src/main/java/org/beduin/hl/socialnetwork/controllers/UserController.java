package org.beduin.hl.socialnetwork.controllers;

import lombok.AllArgsConstructor;
import org.beduin.hl.socialnetwork.dto.UserDto;
import org.beduin.hl.socialnetwork.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")

    public UserDto getUser(@PathVariable Integer id) {
        System.out.println("======= GetUser Дошли до роутера ================");
        UserDto t = userService.getUser(id);
        return t;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto item) {
        System.out.println("======= Store User - Дошли до роутера ================");
        userService.createUser(item);
    }
    @GetMapping("")

    public Collection<UserDto> getUsers() {
        System.out.println("======= GetUserList - Дошли до роутера ================");
        return  userService.getUsers();

    }
}
