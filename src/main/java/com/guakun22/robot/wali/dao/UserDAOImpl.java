package com.guakun22.robot.wali.dao;

import com.guakun22.robot.wali.model.persistence.UserDO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public UserDO getById(Long id) {
        return null;
    }

    @Override
    public void create(String name, String password) {

    }
}
