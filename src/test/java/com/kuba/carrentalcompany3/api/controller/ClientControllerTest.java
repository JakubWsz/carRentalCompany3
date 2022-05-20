package com.kuba.carrentalcompany3.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.carrentalcompany3.api.dto.client.CreateClientRequest;
import com.kuba.carrentalcompany3.api.dto.client.ClientView;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {
    private static final String CLIENT_FIRSTNAME = "Jan";
    private static final String CLIENT_LASTNAME = "Rodo";
    private static final String CLIENT_EMAIL = "asd@gmail.com";
    private static final String CLIENT_PASSWORD = "Password6^";
    private static final LocalDate CLIENT_BIRTHDATE = LocalDate.ofYearDay(1992, 246);
    private static final String CREATE_ACCOUNT_ENDPOINT = "/client/create-account";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ClientRepositoryJPA clientRepository;

    @BeforeEach
    void setUp() { clientRepository.deleteAll(); }

    @Test
    public void createAccount_ShouldReturn201Status() throws Exception {
        //given
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                CLIENT_PASSWORD, CLIENT_BIRTHDATE);

        //when
        //then
        createAccountRequest(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_ShouldReturnValidClientView() throws Exception {
        //given
        ResultActions createAccountRequest = createDefaultAccountRequest();

        //when
        ClientView response = mapper.readValue(
                createAccountRequest.andReturn().getResponse().getContentAsString(), ClientView.class);

        //then
        assertTrue(Objects.nonNull(response.getId()));
        assertFalse(response.getId().isBlank());
        assertEquals(response.getFirstname(), CLIENT_FIRSTNAME);
        assertEquals(response.getLastname(), CLIENT_LASTNAME);
        assertEquals(response.getEmail(), CLIENT_EMAIL);
        assertEquals(response.getBirthdate(), CLIENT_BIRTHDATE);
    }

    @Test
    public void createAccount_WhenEmailAlreadyExists_ShouldFailed() throws Exception {
        //given
        createDefaultAccountRequest().andReturn();
        //when then
        createDefaultAccountRequest()
                .andExpect(status().isConflict());
        //.andExpect(content().string());
    }

    @Test
    public void createAccount_WhenPasswordIsToShort_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "short1!", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_WhenPasswordIsToLong_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "tooooooooooLoooooooooongPasssssssword1!", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_WhenPasswordWithoutCapitalLetter_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "smallpasword1!", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_WhenPasswordWithoutSmallLetter_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "BIGPASSWORD1!", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_WhenPasswordWithoutNumbers_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "Password!", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createAccount_WhenPasswordWithoutSpecialSigns_ShouldFailed() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                "Password1", CLIENT_BIRTHDATE);

        createAccountRequest(request)
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    private ResultActions createDefaultAccountRequest() throws Exception {
        CreateClientRequest request = new CreateClientRequest(CLIENT_FIRSTNAME, CLIENT_LASTNAME, CLIENT_EMAIL,
                CLIENT_PASSWORD, CLIENT_BIRTHDATE);

        return createAccountRequest(request);
    }

    private ResultActions createAccountRequest(CreateClientRequest request) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(CREATE_ACCOUNT_ENDPOINT)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }
}