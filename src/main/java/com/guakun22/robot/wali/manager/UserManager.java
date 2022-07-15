package com.guakun22.robot.wali.manager;

import com.guakun22.robot.wali.model.common.UserBO;

public interface UserManager {
    /**
     * Get user information by user id.
     *
     * @param userId the specific user id.
     * @return bo
     */
    UserBO getUserById(Long userId);
}
