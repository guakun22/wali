package com.guakun22.robot.wali.dao;

import com.guakun22.robot.wali.dao.mapper.UserMapper;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    private final UserMapper userMapper;

    @Autowired
    public UserDAOImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDO getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public void create(String name, String password) {

    }
}
