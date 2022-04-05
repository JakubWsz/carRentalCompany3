package com.kuba.carrentalcompany3.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.api.dto.request.CreateOfficeRequest;
import com.kuba.carrentalcompany3.api.dto.response.OfficeView;
import com.kuba.carrentalcompany3.domain.office.OfficeService;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.OfficeRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.OfficeRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OfficeControllerTest {
    private static final String CREATE_OFFICE_ENDPOINT = "/office/create";
    private static final String DELETE_OFFICE_ENDPOINT = "/office/delete";
    private static final String OFFICE_STREET_ADDRESS = "Szkolna 17";
    private static final String OFFICE_CITY_CODE = "23-407";
    private static final String OFFICE_CITY_NAME = "Lublin";
    private static final String WEBSITE_URL = "https://www.fura.pl";
    private static final String OFFICE_CEO = "Jan Rodo";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private OfficeRepositoryAdapterJPA officeRepository;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private OfficeRepositoryJPA officeRepositoryJPA;

    @BeforeEach
    void setUp() {
        officeRepositoryJPA.deleteAll();
    }

    @Test
    public void createOffice_ShouldReturnValidResponse() throws Exception {
        //when
        OfficeView officeView = createExpectedOfficeViewResponse(status().isCreated());
        //then
        Office office = conversionService.convert(officeView, Office.class);
        validateOffice(office);
    }

    @Test
    public void createOffice_ShouldCreateValidEntity() throws Exception {
        //when
        OfficeView officeView = createExpectedOfficeViewResponse(status().isCreated());
        //then
        OfficeDao officeDao = officeRepository.getByDomainId(officeView.getId());
        Office office = conversionService.convert(officeDao, Office.class);
        validateOffice(office);
    }

    @Test
    public void deleteOffice_ShouldSetIsDeletedTrue() throws Exception {
        //when
        OfficeView office = createExpectedOfficeViewResponse(status().isCreated());
        deleteOfficeRequest(office.getId());
        //then
        Office officeFromDB = conversionService.convert(officeRepository.getByDomainId(office.getId()), Office.class);
        assertNotNull(officeFromDB);
        assertTrue(officeFromDB.isDeleted());
    }

    private void validateOffice(Office office) {
        assertTrue(Objects.nonNull(office));
        assertTrue(Objects.nonNull(office.getId()));
        assertFalse(office.getId().isBlank());
        assertEquals(OFFICE_STREET_ADDRESS, office.getOfficeAddress().getOfficeStreetAddress());
        assertEquals(OFFICE_CITY_NAME, office.getOfficeAddress().getOfficeCityName());
        assertEquals(OFFICE_CITY_CODE, office.getOfficeAddress().getOfficePostalCode());
        assertEquals(WEBSITE_URL, office.getWebsiteURL());
        assertEquals(OFFICE_CEO, office.getOfficeCEO());
    }

    private OfficeView createExpectedOfficeViewResponse(ResultMatcher... matchers) throws Exception {
        CreateOfficeRequest request = new CreateOfficeRequest(new OfficeAddressDTO(OFFICE_STREET_ADDRESS,
                OFFICE_CITY_CODE, OFFICE_CITY_NAME), WEBSITE_URL, OFFICE_CEO);

        ResultActions createOfficeRequest = createOfficeRequest(request)
                .andExpectAll(matchers)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        return mapper.readValue(
                createOfficeRequest.andReturn().getResponse().getContentAsString(), OfficeView.class);
    }

    private ResultActions createOfficeRequest(CreateOfficeRequest request) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(CREATE_OFFICE_ENDPOINT)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    private void deleteOfficeRequest(String id) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete(DELETE_OFFICE_ENDPOINT).param("id", id))
                .andReturn();
    }
}
