package com.guakun22.robot.wali.dao.mapper;

import com.guakun22.robot.wali.model.persistence.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * get user by id
     * @param id
     * @return
     */
    @Select("SELECT * FROM robot_wali_user WHERE id = #{id};")
    UserDO getById(@Param("id") Long id);
}
