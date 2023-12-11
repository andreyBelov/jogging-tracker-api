package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.service.RunService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishDateTimeAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishDateTimeInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishLatAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishLatInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishLonAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunFinishLonInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunValid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunValidWithNullableDistance;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.finishRunValidWithoutDistance;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunLatAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunLatInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunLonAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunLonInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunStartDateTimeAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunStartDateTimeInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunUserIdAbsent;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunUserIdInvalid;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunUserIdNegative;
import static de.bergmanninfotech.joggingtrackerapi.web.RunControllerTestHelper.startRunValid;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RunController.class)
public class RunControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RunService runService;

    @Test
    void createRun_whenBodyIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunUserIdAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunUserIdInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunUserIdNegative()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunLatAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunLatInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunLonAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunLonInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunStartDateTimeAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunStartDateTimeInvalid()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createRun_whenBodyIsValid_thenReturnsStatus200() throws Exception {
        mvc.perform(post("/api/runs")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isOk());
    }

    @Test
    void finishRun_whenBodyIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishDateTimeAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishDateTimeInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishLatAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishLatInvalid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishLonAbsent()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunFinishLonInvalid()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void finishRun_whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
        mvc.perform(post("/api/runs/asd")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/null")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/0")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/1.5")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isBadRequest());
        mvc.perform(post("/api/runs/-10")
                        .contentType("application/json")
                        .content(startRunValid()))
                .andExpect(status().isBadRequest());
    }

    @Test
    void finishRun_whenBodyIsValid_thenReturnsStatus200() throws Exception {
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunValid()))
                .andExpect(status().isOk());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunValidWithoutDistance()))
                .andExpect(status().isOk());
        mvc.perform(post("/api/runs/1")
                        .contentType("application/json")
                        .content(finishRunValidWithNullableDistance()))
                .andExpect(status().isOk());
    }
}
