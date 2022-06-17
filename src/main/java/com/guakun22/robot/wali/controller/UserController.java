package com.guakun22.robot.wali.controller;

import com.guakun22.robot.wali.converter.c2s.UserC2SConverter;
import com.guakun22.robot.wali.exception.InvalidParameterException;
import com.guakun22.robot.wali.manager.UserManager;
import com.guakun22.robot.wali.model.service.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserManager userManager;
    private final UserC2SConverter userC2SConverter;

    @Autowired
    public UserController(final UserManager userManager,
            final UserC2SConverter userC2SConverter) {
        this.userManager = userManager;
        this.userC2SConverter = userC2SConverter;
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") Long id) {
        if (Objects.isNull(id) || id < 0L) {
            throw new InvalidParameterException(
                    String.format("Parse wrong type for id(%s).", id)
            );
        }
        return userC2SConverter.convert(userManager.getById(id));
    }
}
