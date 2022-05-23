package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.infrastructure.converter.AddressDAOToAddress;
import com.kuba.carrentalcompany3.infrastructure.converter.AddressToAddressDAO;
import com.kuba.carrentalcompany3.infrastructure.converter.AddressToAddressDTO;
import com.kuba.carrentalcompany3.infrastructure.converter.car.api.CarToCarView;
import com.kuba.carrentalcompany3.infrastructure.converter.car.jpa.CarDAOToCar;
import com.kuba.carrentalcompany3.infrastructure.converter.car.jpa.CarToCarDAO;
import com.kuba.carrentalcompany3.infrastructure.converter.client.api.ClientToClientView;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientDAOToClient;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientToDAOClient;
import com.kuba.carrentalcompany3.infrastructure.converter.AddressDTOToAddress;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.api.EmployeeToEmployeeView;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.api.EmployeeViewToEmployee;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa.EmployeeDAOToEmploy;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa.EmployeeToEmployeeDAO;
import com.kuba.carrentalcompany3.infrastructure.converter.office.api.*;
import com.kuba.carrentalcompany3.infrastructure.converter.office.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConvertersConfig implements WebMvcConfigurer {
    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ClientToClientView());
        registry.addConverter(new ClientDAOToClient());
        registry.addConverter(new ClientToDAOClient());
        registry.addConverter(new AddressToAddressDAO());
        registry.addConverter(new AddressDAOToAddress());
        registry.addConverter(new AddressToAddressDTO());
        registry.addConverter(new OfficeToOfficeView(conversionService));
        registry.addConverter(new OfficeDAOOptionalToOffice(conversionService));
        registry.addConverter(new OfficeToOfficeDAO(conversionService));
        registry.addConverter(new EmployeeDAOToEmploy());
        registry.addConverter(new EmployeeToEmployeeView(conversionService));
        registry.addConverter(new AddressDTOToAddress());
        registry.addConverter(new EmployeeToEmployeeDAO(conversionService));
        registry.addConverter(new EmployeeViewToEmployee(conversionService));
        registry.addConverter(new CarToCarDAO());
        registry.addConverter(new CarDAOToCar());
        registry.addConverter(new CarToCarView());
    }
}
