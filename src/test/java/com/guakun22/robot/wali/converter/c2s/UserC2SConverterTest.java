package com.guakun22.robot.wali.converter.c2s;

import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.service.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserC2SConverterTest {

    private UserC2SConverter userC2SConverter = new UserC2SConverter();

    @Test
    void doForwardTest() {
        // Arrange
        Long id = 99L;
        String name = "云想衣裳";
        String password = "花想容";

        UserBO user = UserBO.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();

        // Act
        UserDTO result = userC2SConverter.convert(user);

        // Assert
        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName());

    }

    @Test
    void doBackwardTest() {
        // Arrange
        Long id = 99L;
        String name = "云想衣裳";

        UserDTO user = UserDTO.builder()
                .id(id)
                .name(name)
                .build();

        // Act
        UserBO result = userC2SConverter.reverse().convert(user);

        // Assert
        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName())
                .hasFieldOrPropertyWithValue("password", null);

    }

}
