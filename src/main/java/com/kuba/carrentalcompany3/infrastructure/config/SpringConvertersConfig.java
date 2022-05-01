package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.infrastructure.converter.client.api.ClientToClientViewConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientDAOToClientConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientToDAOClientConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.api.EmployeeAddressDTOToEmployeeAddress;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.api.EmployeeToEmployeeDetailsView;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa.EmployeeDAOToEmploy;
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
        registry.addConverter(new ClientToClientViewConverter());
        registry.addConverter(new ClientDAOToClientConverter());
        registry.addConverter(new ClientToDAOClientConverter());
        registry.addConverter(new OfficeAddressDTOToOfficeAddress());
        registry.addConverter(new OfficeAddressToOfficeAddressDAO());
        registry.addConverter(new OfficeAddressDAOToOfficeAddress());
        registry.addConverter(new OfficeAddressToOfficeAddressDTO());
        registry.addConverter(new OfficeToOfficeView(conversionService));
        registry.addConverter(new OfficeDAOOptionalToOffice(conversionService));
        registry.addConverter(new OfficeToOfficeDAO(conversionService));
        registry.addConverter(new EmployeeDAOToEmploy());
        registry.addConverter(new EmployeeToEmployeeDetailsView(conversionService));
        registry.addConverter(new EmployeeAddressDTOToEmployeeAddress());
    }
}
