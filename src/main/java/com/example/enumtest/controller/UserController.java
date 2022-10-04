package com.example.enumtest.controller;

import com.example.enumtest.model.business.User;
import com.example.enumtest.model.dto.UserDto;
import com.example.enumtest.service.UserService;
import com.example.enumtest.util.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    /**
     * User enters his data and they get saved in db
     *
     * @param userDto
     * @return UserDto
     */
    @PostMapping("/signup")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        var user = userMapper.controllerToService(userDto);
        var savedUser = userService.save(user);
        var response = userMapper.serviceToController(savedUser);
        return ResponseEntity.ok(response);
    }

    /**
     * Lists all users from db
     *
     * @return List<UserDto>
     * no param
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.findAll();
        var response = users.stream().map(userMapper::serviceToController).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id) {
        User user = userService.findById(id);
        var response = userMapper.serviceToController(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable(name = "id") Integer id) {
        UserDto userDto = userMapper.serviceToController(userService.deleteById(id));
        return ResponseEntity.ok(userDto);
    }
}

