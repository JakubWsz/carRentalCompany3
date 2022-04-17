package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.infrastructure.converter.client.api.ClientToClientViewConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientDaoToClientConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.client.jpa.ClientToDaoClientConverter;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.api.EmployeeToEmployeeDetailsView;
import com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa.EmployeeDaoToEmploy;
import com.kuba.carrentalcompany3.infrastructure.converter.office.api.OfficeAddressToOfficeAddressDao;
import com.kuba.carrentalcompany3.infrastructure.converter.office.jpa.OfficeAddressDTOToOfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.converter.office.api.OfficeAddressDaoToOfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.converter.office.api.OfficeToOfficeView;
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
        registry.addConverter(new ClientDaoToClientConverter());
        registry.addConverter(new ClientToDaoClientConverter());
        registry.addConverter(new EmployeeDaoToEmploy());
        registry.addConverter(new OfficeAddressDTOToOfficeAddress());
        registry.addConverter(new OfficeAddressToOfficeAddressDao());
        registry.addConverter(new OfficeAddressDaoToOfficeAddress());
        registry.addConverter(new OfficeAddressToOfficeAddressDTO());
        registry.addConverter(new OfficeToOfficeView(conversionService));
        registry.addConverter(new OfficeDaoOptionalToOffice(conversionService));
        registry.addConverter(new OfficeToOfficeDao(conversionService));
        registry.addConverter(new EmployeeToEmployeeDetailsView());
    }
}
