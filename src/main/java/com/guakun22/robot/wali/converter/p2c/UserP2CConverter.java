package com.guakun22.robot.wali.converter.p2c;

import com.google.common.base.Converter;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.persistence.UserDO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserP2CConverter extends Converter<UserDO, UserBO> {
    @Override
    protected UserBO doForward(UserDO userDO) {
        return UserBO
                .builder()
                .id(userDO.getId())
                .name(userDO.getName())
                .password(userDO.getPassword())
                .build();
    }

    @Override
    protected UserDO doBackward(UserBO userBO) {
//        throw new UnsupportedOperationException("还不支持这种操作！");
        return UserDO.builder()
                .id(userBO.getId())
                .name(userBO.getName())
                .password(userBO.getPassword())
                .build();
    }
}
