package com.guakun22.robot.wali.manager;

import com.guakun22.robot.wali.converter.p2c.UserP2CConverter;
import com.guakun22.robot.wali.dao.UserDAO;
import com.guakun22.robot.wali.exception.ResourceNotFoundException;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

class UserManagerTest {

    private UserManager userManager;

    @Mock
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        userManager = new UserManagerImpl(
                userDAO,
                new UserP2CConverter());
    }


    @Test
    void testGetUserById() {
        // Arrange
        Long id = 99L;
        String name = "云想衣裳";
        String password = "花想容";
        LocalDate createAt = LocalDate.now();

        UserDO user = UserDO.builder()
                .id(id)
                .name(name)
                .password(password)
                .createAt(createAt)
                .build();

        Mockito.doReturn(user).when(userDAO).getUserById(id);

        // Act
        UserBO result = userManager.getUserById(id);

        // Assert
        // 检查调用过一次
        Mockito.verify(userDAO).getUserById(Mockito.eq(id));

        // 检查结果
        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName())
                .hasFieldOrPropertyWithValue("password", user.getPassword());
    }

    @Test
    void testGetUserByIdWithInvalidUserId() {
        // Arrange
        Long id = Long.MIN_VALUE;

        Mockito.doReturn(null).when(userDAO).getUserById(id);

        // Act & Assert
        // 检查结果
        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> userManager.getUserById(id));

        // 检查调用过一次
        Mockito.verify(userDAO).getUserById(Mockito.eq(id));
    }
}
