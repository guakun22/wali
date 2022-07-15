package com.guakun22.robot.wali.dao;

import com.guakun22.robot.wali.dao.mapper.UserMapper;
import com.guakun22.robot.wali.model.persistence.UserDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UserDAOTest {

    private UserDAO userDAO;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAOImpl(userMapper);
    }

    @Test
    void testGetById() {
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

        Mockito.doReturn(user).when(userMapper).getUserById(id);

        // Act
        UserDO result = userDAO.getUserById(id);

        // Assert
        Mockito.verify(userMapper).getUserById(Mockito.eq(id));

        Assertions.assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", user.getId())
                .hasFieldOrPropertyWithValue("name", user.getName())
                .hasFieldOrPropertyWithValue("createAt", user.getCreateAt())
                .hasFieldOrPropertyWithValue("password", user.getPassword());
    }
}
