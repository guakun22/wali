package com.guakun22.robot.wali.manager;

import com.guakun22.robot.wali.converter.p2c.UserP2CConverter;
import com.guakun22.robot.wali.dao.UserDAO;
import com.guakun22.robot.wali.exception.ResourceNotFoundException;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserManagerImpl implements UserManager {

    private final UserDAO userDAO;
    private final UserP2CConverter userP2CConverter;

    @Autowired
    public UserManagerImpl(
            final UserDAO userDAO,
            final UserP2CConverter userP2CConverter
    ) {
        this.userDAO = userDAO;
        this.userP2CConverter = userP2CConverter;
    }

    @Override
    public UserBO getById(Long id) {
        UserDO userDO = Optional
                .ofNullable(userDAO.getById(id))
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                String.format("Could not find User(id=%s).", id)));
        return userP2CConverter.convert(userDO);
    }
}
