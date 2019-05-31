package org.egar.makshun.jdbc.controller;

import org.egar.makshun.jdbc.model.User;
import org.egar.makshun.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * postman example:
     * GET http://localhost:8080/api/users/getOne/1
     */
    @GetMapping("/getOne/{userId}")
    public ResponseEntity<User> getOne(@PathVariable("userId") Long userId) {
        User result = userService.getOne(userId);
        return result != null ?
                new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * postman example:
     * GET http://localhost:8080/api/users/findAllUsers
     */
    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> result = userService.findAllUsers();
        return Boolean.FALSE.equals(result.isEmpty()) ?
                new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * postman example:
     * POST http://localhost:8080/api/users/save
     * +
     * {
     * "id": 2, // or null (if null - create, if number - update)
     * "login": "somename",
     * "password":"somepass"
     * }
     */
    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User result = userService.save(user);
        return result != null ?
                new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * postman example:
     * DELETE http://localhost:8080/api/users/remove/1
     */
    @DeleteMapping("/remove/{userId}")
    public ResponseEntity remove(@PathVariable("userId") Long userId) {
        userService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
