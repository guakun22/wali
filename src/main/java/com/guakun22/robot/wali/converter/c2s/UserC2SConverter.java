package com.guakun22.robot.wali.converter.c2s;

import com.google.common.base.Converter;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.service.UserDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserC2SConverter extends Converter<UserBO, UserDTO> {
    @Override
    protected UserDTO doForward(UserBO userBO) {
        return UserDTO
                .builder()
                .id(userBO.getId())
                .name(userBO.getName())
                .build();
    }

    @Override
    protected UserBO doBackward(UserDTO userDTO) {
//        throw new UnsupportedOperationException("不支持这种操作。");
        return UserBO.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .build();
    }
}
