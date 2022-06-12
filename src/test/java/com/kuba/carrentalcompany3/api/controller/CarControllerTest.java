package com.kuba.carrentalcompany3.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuba.carrentalcompany3.api.dto.car.CarView;
import com.kuba.carrentalcompany3.api.dto.car.CreateCarRequest;
import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.CarRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;
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
class CarControllerTest {
    private static final String REGISTRATION = "Mercedes";
    private static final String BRAND = "Mercedes";
    private static final String MODEL = "EQE";
    private static final CarType CAR_TYPE = CarType.PASSENGER;
    private static final FuelType FUEL_TYPE = FuelType.PETROL;
    private static final GearboxType GEARBOX_TYPE = GearboxType.MANUAL;
    private static final DoorNumber DOOR_NUMBER = DoorNumber._3;
    private static final double BOOT_CAPACITY = 350;
    private static final String OFFICE_ID = "ASD123-QWZ098";
    private static final String CREATE_ENDPOINT = "/car/create";
    private static final String DELETE_CAR_ENDPOINT = "/car/%s//remove";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private CarRepositoryJPA carRepositoryJPA;
    @Autowired
    private ConversionService conversionService;

    @BeforeEach
    void setUp() {
        carRepositoryJPA.deleteAll();
    }

    @Test
    public void createAccount_ShouldReturn201Status() throws Exception {
        //given
        CreateCarRequest request = new CreateCarRequest(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE,
                DOOR_NUMBER, BOOT_CAPACITY,OFFICE_ID);

        //when
        //then
        createCarRequest(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createCar_ShouldReturnValidCarView() throws Exception {
        //given
        ResultActions createCarRequest = createDefaultCarRequest();

        //when
        CarView response = mapper.readValue(
                createCarRequest.andReturn().getResponse().getContentAsString(), CarView.class);

        //then
        assertTrue(Objects.nonNull(response.getId()));
        assertFalse(response.getId().isBlank());
        assertEquals(response.getBrand(), BRAND);
        assertEquals(response.getModel(), MODEL);
        assertEquals(response.getCarType(), CAR_TYPE);
        assertEquals(response.getFuelType(), FUEL_TYPE);
        assertEquals(response.getGearboxType(), GEARBOX_TYPE);
        assertEquals(response.getDoorNumber(), DOOR_NUMBER);
        assertEquals(response.getBootCapacity(), BOOT_CAPACITY);
        assertEquals(response.getOfficeId(), OFFICE_ID);
    }

    @Test
    public void createCar_ShouldHaveSameDataAsCarFromDB() throws Exception {
        //when
        CarView carView = createExpectedCarResponse();

        //then
        Car carFromDB = conversionService.convert(carRepositoryJPA.findByDomainId(carView.getId()).get(),
                Car.class);
        assertNotNull(carFromDB);
        assertEquals(carFromDB.getRegistration(), REGISTRATION);
        assertEquals(carFromDB.getBrand(), BRAND);
        assertEquals(carFromDB.getModel(), MODEL);
        assertEquals(carFromDB.getCarType(), CAR_TYPE);
        assertEquals(carFromDB.getFuelType(), FUEL_TYPE);
        assertEquals(carFromDB.getGearboxType(), GEARBOX_TYPE);
        assertEquals(carFromDB.getDoorNumber(), DOOR_NUMBER);
        assertEquals(carFromDB.getBootCapacity(), BOOT_CAPACITY);
        assertEquals(carFromDB.getOfficeId(), OFFICE_ID);
    }

    @Test
    public void deleteEmployee_ShouldSetIsDeletedTrue() throws Exception {
        //when
        CarView carView = createExpectedCarResponse(status().isCreated());
        deleteCarRequest(carView.getId());
        //then
        Car carFromDB = conversionService.convert(carRepositoryJPA.findByDomainId(carView.getId()).get(),
                Car.class);
        assertNotNull(carFromDB);
        assertTrue(carFromDB.isDeleted());
    }

    private ResultActions createDefaultCarRequest() throws Exception {
        CreateCarRequest request =  new CreateCarRequest(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE,
                DOOR_NUMBER, BOOT_CAPACITY,OFFICE_ID);

        return createCarRequest(request);
    }

    private ResultActions createCarRequest(CreateCarRequest request) throws Exception {
            return mvc.perform(MockMvcRequestBuilders.post(CREATE_ENDPOINT)
                    .content(mapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    private CarView createExpectedCarResponse(ResultMatcher... matchers) throws Exception {
        CreateCarRequest request = new CreateCarRequest(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE,
                DOOR_NUMBER, BOOT_CAPACITY,OFFICE_ID);

        ResultActions createCarRequest = createCarRequest(request)
                .andExpectAll(matchers)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        return mapper.readValue(
                createCarRequest.andReturn().getResponse().getContentAsString(), CarView.class);
    }

    private void deleteCarRequest(String id) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .delete(String.format(DELETE_CAR_ENDPOINT, id)))
                .andReturn();
    }
}