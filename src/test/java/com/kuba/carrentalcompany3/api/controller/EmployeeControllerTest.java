package com.kuba.carrentalcompany3.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeDetailsView;
import com.kuba.carrentalcompany3.api.dto.employee.request.CreateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.office.CreateOfficeRequest;
import com.kuba.carrentalcompany3.api.dto.office.OfficeView;
import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.EmployeeRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.EmployeeRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
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

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    private static final String CREATE_EMPLOYEE_ENDPOINT = "/employee/create";
    private static final String DELETE_EMPLOYEE_ENDPOINT = "/office/%s/delete";
    private static final String RELOCATE_EMPLOYEE_ENDPOINT = "/office/%s/relocate";
    private static final String CHANGE_EMPLOYEE_ENDPOINT = "/office/%s/changeCEO";
    private static final String FIRSTNAME = "Jan";
    private static final String LASTNAME = "Kowalski";
    private static final String STREET_ADDRESS = "Malinowa 19";
    private static final String POSTAL_CODE = "00-123";
    private static final String CITY_NAME = "Wodogrzmotów";
    private static final AddressDTO ADDRESS = new AddressDTO(
            STREET_ADDRESS, POSTAL_CODE, CITY_NAME);
    private static final String PESEL = "39062808299";
    private static final String ACCOUNT_NUMBER = "00847000017362211118980391";
    private static final BigDecimal SALARY = BigDecimal.valueOf(5500);
    private static final ContractType CONTRACT_TYPE = ContractType.B2B;
    private static final String POSITION = "custemmer service";
    private static final String OFFICE_ID = UUID.randomUUID().toString();

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EmployeeRepositoryAdapterJPA employeeRepository;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private EmployeeRepositoryJPA employeeRepositoryJPA;

    @BeforeEach
    void setUp() {
        employeeRepositoryJPA.deleteAll();
    }

    @Test
    public void createEmployee_ShouldReturnValidResponse() throws Exception {
        //when
        EmployeeDetailsView employeeDetailsView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        //then
        Employee employee = conversionService.convert(EmployeeDetailsView, Employee.class);
        validateEmployee(office);
    }

    @Test
    public void createEmployee_ShouldCreateValidEntity() throws Exception {
        //when
        EmployeeDetailsView employeeDetailsView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        //then
        EmployeeDAO employeeDAO = employeeRepository.(employeeDetailsView.g());
        Office office = conversionService.convert(officeDao, Office.class);
        validateEmployee(office);
    }

    private EmployeeDetailsView createExpectedEmployeeDetailsViewResponse(ResultMatcher... matchers) throws Exception {
        CreateEmployeeRequest request = new CreateEmployeeRequest(FIRSTNAME,LASTNAME,ADDRESS,PESEL,ACCOUNT_NUMBER,
                SALARY,CONTRACT_TYPE,POSITION,OFFICE_ID);

        ResultActions createEmployeeRequest = createEmployeeRequest(request)
                .andExpectAll(matchers)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        return mapper.readValue(
                createEmployeeRequest.andReturn().getResponse().getContentAsString(), EmployeeDetailsView.class);
    }

    private ResultActions createEmployeeRequest(CreateEmployeeRequest request) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(CREATE_EMPLOYEE_ENDPOINT)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

}