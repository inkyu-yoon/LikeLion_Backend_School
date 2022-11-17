package com.example.springbootjpa.controller;

import com.example.springbootjpa.dto.UserAddRequestDto;
import com.example.springbootjpa.dto.UserAddResponseDto;
import com.example.springbootjpa.dto.UserFindDto;
import com.example.springbootjpa.service.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("get api 테스트")
    void 테스트() throws Exception {

        given(userService.findUser(1L))
                .willReturn(UserFindDto.builder().id(1L).username("테스트").message("테스트용 객체").build());

        Long userId = 1L;
        mockMvc.perform(
                        get("/api/v1/users/" + userId)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.message").exists())
                .andDo(print());

        verify(userService).findUser(1L);

    }

    @Test
    @DisplayName("post api 테스트")
    void 포스트테스트() throws Exception {

        UserAddRequestDto userAddRequestDto = new UserAddRequestDto("아이디1233", "패스워드");

        given(userService.add(userAddRequestDto))
                .willReturn(new UserAddResponseDto(userAddRequestDto.getUsername(), "가입이 완료 되었습니다"));

        Gson gson = new Gson();
        String content = gson.toJson(userAddRequestDto);

        mockMvc.perform(
                        post("/api/v1/users").contentType(MediaType.APPLICATION_JSON).content(content)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.message").exists())
                .andDo(print());

        verify(userService).add(userAddRequestDto);

    }
}
