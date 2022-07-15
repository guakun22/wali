package com.guakun22.robot.wali.converter.p2c;

import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserP2CConverterTest {

    private UserP2CConverter userP2CConverter = new UserP2CConverter();

    @Test
    void doForwardTest() {
        // Arrange
        Long id = 99L;
        String name = "云想衣裳";
        String password = "花想容";

        UserDO user = UserDO.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();

        // Act
        UserBO result = userP2CConverter.convert(user);

        // Assert
        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName())
                .hasFieldOrPropertyWithValue("password", user.getPassword());

    }

    @Test
    void doBackwardTest() {
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
        UserDO result = userP2CConverter.reverse().convert(user);

        // Assert
        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName())
                .hasFieldOrPropertyWithValue("createAt", null)
                .hasFieldOrPropertyWithValue("modifiedAt", null)
                .hasFieldOrPropertyWithValue("password", user.getPassword());

    }

}
