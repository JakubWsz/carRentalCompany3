package com.kuba.carrentalcompany3.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeView;
import com.kuba.carrentalcompany3.api.dto.employee.request.CreateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.employee.request.UpdateEmployeeRequest;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.EmployeeRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.EmployeeRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    private static final String CREATE_EMPLOYEE_ENDPOINT = "/employee/create";
    private static final String DELETE_EMPLOYEE_ENDPOINT = "/employee/%s/remove";
    private static final String UPDATE_EMPLOYEE_ENDPOINT = "/employee/%s/update-data";
    private static final String RELOCATE_EMPLOYEE_ENDPOINT = "/office/%s/relocate";
    private static final String CHANGE_EMPLOYEE_ENDPOINT = "/office/%s/changeCEO";
    private static final String FIRSTNAME = "Jan";
    private static final String LASTNAME = "Kowalski";
    private static final String STREET_ADDRESS = "Malinowa 19";
    private static final String POSTAL_CODE = "00-123";
    private static final String CITY_NAME = "Warszawa";
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
        EmployeeView employeeView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        //then
        Employee employee = conversionService.convert(employeeView, Employee.class);
        validateEmployee(employee);
    }

    @Test
    public void createEmployee_ShouldCreateValidEntity() throws Exception {
        //when
        EmployeeView employeeView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        //then
        Employee employee = conversionService.convert(employeeRepository.getEmployee(employeeView.getId()).get(),
                Employee.class);
        validateEmployee(employee);
    }

    @Test
    public void deleteEmployee_ShouldSetIsDeletedTrue() throws Exception {
        //when
        EmployeeView employeeView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        deleteOfficeRequest(employeeView.getId());
        //then
        Employee employeeFromDB = conversionService.convert(employeeRepository.getEmployee(employeeView.getId()).get(),
                Employee.class);
        assertNotNull(employeeFromDB);
        assertTrue(employeeFromDB.isDeleted());
    }

    @Test
    public void updateEmployee_shouldOverrideHisFields() throws Exception {
        //given
        EmployeeView employeeView = createExpectedEmployeeDetailsViewResponse(status().isCreated());
        String updateFirstname = "mariusz";
        String updateAddressCity = "Piaseczno";
        UpdateEmployeeRequest updateRequest = new UpdateEmployeeRequest(List.of(
                new FieldUpdateDTO<>(EmployeeFieldType.FIRST_NAME, updateFirstname),
                new FieldUpdateDTO<>(EmployeeFieldType.ADDRESS_CITY_NAME, updateAddressCity)));
        //when
        HttpStatus updateStatusResponse = updateEmployeeRequest(employeeView.getId(), updateRequest);
        //then
        Employee employee = conversionService.convert(employeeRepository.getEmployee(employeeView.getId()).get(),
                Employee.class);
        assertEquals(HttpStatus.OK, updateStatusResponse);
        assertNotNull(employee);
        assertEquals(updateFirstname, employee.getFirstname());
        assertEquals(updateAddressCity, employee.getAddress().getCityName());
    }

    private void validateEmployee(Employee employee) {
        assertTrue(Objects.nonNull(employee));
        assertTrue(Objects.nonNull(employee.getId()));
        assertFalse(employee.getId().isBlank());
        assertEquals(STREET_ADDRESS, employee.getAddress().getStreetAddress());
        assertEquals(CITY_NAME, employee.getAddress().getCityName());
        assertEquals(POSTAL_CODE, employee.getAddress().getPostalCode());
        assertEquals(PESEL, employee.getPesel());
        assertEquals(ACCOUNT_NUMBER, employee.getAccountNumber());
        assertEquals(0, employee.getSalaryAmount().compareTo(SALARY));
        assertEquals(CONTRACT_TYPE, employee.getContractType());
        assertEquals(POSITION, employee.getPosition());
        assertEquals(OFFICE_ID, employee.getOfficeId());
    }

    private EmployeeView createExpectedEmployeeDetailsViewResponse(ResultMatcher... matchers) throws Exception {
        CreateEmployeeRequest request = new CreateEmployeeRequest(FIRSTNAME, LASTNAME, ADDRESS, PESEL, ACCOUNT_NUMBER,
                SALARY, CONTRACT_TYPE, POSITION, OFFICE_ID);

        ResultActions createEmployeeRequest = createEmployeeRequest(request)
                .andExpectAll(matchers)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        return mapper.readValue(
                createEmployeeRequest.andReturn().getResponse().getContentAsString(), EmployeeView.class);
    }

    private ResultActions createEmployeeRequest(CreateEmployeeRequest request) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(CREATE_EMPLOYEE_ENDPOINT)
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    private HttpStatus updateEmployeeRequest(String id, UpdateEmployeeRequest updateRequest) throws Exception {
        return HttpStatus.resolve(mvc.perform(MockMvcRequestBuilders.patch(String.format(UPDATE_EMPLOYEE_ENDPOINT, id))
                .content(mapper.writeValueAsString(updateRequest))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getStatus());
    }

    private void deleteOfficeRequest(String id) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .delete(String.format(DELETE_EMPLOYEE_ENDPOINT, id)))
                .andReturn();
    }
}