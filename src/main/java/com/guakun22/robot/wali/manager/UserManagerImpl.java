package com.guakun22.robot.wali.manager;

import com.guakun22.robot.wali.converter.p2c.UserP2CConverter;
import com.guakun22.robot.wali.dao.UserDAO;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public UserBO getUserById(Long userId) {
        UserDO userDO = userDAO.getById(userId);
        return userP2CConverter.convert(userDO);
    }
}
