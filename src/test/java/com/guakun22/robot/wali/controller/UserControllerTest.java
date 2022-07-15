package com.guakun22.robot.wali.controller;

import com.guakun22.robot.wali.converter.c2s.UserC2SConverter;
import com.guakun22.robot.wali.exception.GlobalExceptionHandler;
import com.guakun22.robot.wali.exception.ResourceNotFoundException;
import com.guakun22.robot.wali.manager.UserManager;
import com.guakun22.robot.wali.model.common.UserBO;
import com.guakun22.robot.wali.model.service.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserManager userManager;

    @Mock
    private UserC2SConverter userC2SConverter;

    @InjectMocks
    private UserController userController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();
    }

    @AfterEach
    void teardown() {
        reset(userManager);
        reset(userC2SConverter);
    }

    @Test
    void testGetUserById() throws Exception {
        // Arrange
        Long id = 99L;
        String name = "cloud image close";
        String password = "flower image beauty";

        UserBO user = UserBO.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();

        Mockito.doReturn(user)
                .when(userManager).getUserById(Mockito.anyLong());


        UserDTO userDTO = UserDTO.builder()
                .id(id)
                .name(name)
                .build();
        Mockito.doReturn(userDTO)
                .when(userC2SConverter).convert(user);

        // Act && Assert
        mockMvc.perform(get("/api/v1/user/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"id\":99,\"name\":\"cloud image close\"}"));

        Mockito.verify(userManager).getUserById(Mockito.anyLong());
        Mockito.verify(userC2SConverter).convert(user);
    }

    @Test
    void testGetUserByIdWithInvalidUserId() throws Exception {
        // Arrange
        Long id = -99L;

        Mockito.doThrow(new ResourceNotFoundException(
                        String.format("Parse wrong type for id(%s).", id)))
                .when(userManager).getUserById(Mockito.anyLong());

        // Act && Assert
        mockMvc.perform(get("/api/v1/user/" + id))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"code\":\"WRONG_QUERY\",\"type\":\"Client\",\"message\":\"Parse wrong type for id(-99).\",\"httpStatusCode\":\"BAD_REQUEST\"}"));

    }
}
