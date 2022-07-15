package com.guakun22.robot.wali.dao;

import com.guakun22.robot.wali.model.persistence.UserDO;

public interface UserDAO {
    /**
     * get by id
     * @param id id
     * @return do
     */
    UserDO getUserById(Long id);

    /**
     * create
     * @param name name
     * @param password passwd
     */
    void create(String name, String password);
}
