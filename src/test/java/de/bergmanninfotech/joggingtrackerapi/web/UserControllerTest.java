package de.bergmanninfotech.joggingtrackerapi.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bergmanninfotech.joggingtrackerapi.dto.UserCreationRequest;
import de.bergmanninfotech.joggingtrackerapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.birthDateAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.birthDateInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.firstNameAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.genderAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.genderInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.invalidJson;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.lastNameAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.UserControllerTestHelper.validCreationRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    void createUser_whenBodyIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(firstNameAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(lastNameAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(birthDateAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(birthDateInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(genderAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(genderInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(invalidJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createUser_whenBodyIsValid_thenReturnsStatus200() throws Exception {
        mvc.perform(post("/api/users")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isOk());
    }

    @Test
    void updateUser_whenBodyIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(firstNameAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(lastNameAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(birthDateAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(birthDateInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(genderAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(genderInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(invalidJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateUser_whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/users/asd")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/null")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/0")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/1.5")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/users/-10")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateUser_whenBodyIsValid_thenReturnsStatus200() throws Exception {
        mvc.perform(post("/api/users/1")
                        .contentType("application/json")
                        .content(validCreationRequest()))
                .andExpect(status().isOk());
    }

    @Test
    void getUserById_whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(get("/api/users/asd"))
                .andExpect(status().isBadRequest());
        mvc.perform(get("/api/users/null"))
                .andExpect(status().isBadRequest());
        mvc.perform(get("/api/users/0"))
                .andExpect(status().isBadRequest());
        mvc.perform(get("/api/users/1.5"))
                .andExpect(status().isBadRequest());
        mvc.perform(get("/api/users/-10"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteUserById_whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(delete("/api/users/asd"))
                .andExpect(status().isBadRequest());
        mvc.perform(delete("/api/users/null"))
                .andExpect(status().isBadRequest());
        mvc.perform(delete("/api/users/0"))
                .andExpect(status().isBadRequest());
        mvc.perform(delete("/api/users/1.5"))
                .andExpect(status().isBadRequest());
        mvc.perform(delete("/api/users/-10"))
                .andExpect(status().isBadRequest());
    }

//    @Test
//    void whenRequestParameterIsInvalid_thenReturnsStatus400() throws Exception {
//        mvc.perform(get("/validateRequestParameter")
//                        .param("param", "3"))
//                .andExpect(status().isBadRequest());
//    }

}
