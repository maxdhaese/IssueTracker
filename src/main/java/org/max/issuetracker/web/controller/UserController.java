package org.max.issuetracker.web.controller;

import jakarta.validation.Valid;
import org.max.issuetracker.domain.model.User;
import org.max.issuetracker.domain.service.UserService;
import org.max.issuetracker.web.dto.CreateUserRequest;
import org.max.issuetracker.web.dto.UserDTO;
import org.max.issuetracker.web.dto.UserWebMapper;
import org.max.issuetracker.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO create(@Valid @RequestBody CreateUserRequest req) {
        User created = service.createUser(
                req.username(),
                req.email(),
                req.password(),
                req.role()
        );

        return UserWebMapper.toDTO(created);
    }
    @GetMapping("/{id}")
    public UserDTO get(@PathVariable long id){
        return service.findById(id).
                map(UserWebMapper::toDTO).
                orElseThrow(()-> new NotFoundException("User with id " + id + " not found"));
    }

    @GetMapping
    public List<UserDTO> list(){
        return service.listAll().stream().
                map(UserWebMapper::toDTO).
                toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteUser(id);
    }
}
