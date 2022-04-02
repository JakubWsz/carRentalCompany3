package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.domain.office.OfficeRepository;
import com.kuba.carrentalcompany3.domain.office.OfficeService;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.OfficeRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.OfficeRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;

import java.time.Clock;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }

    @Bean
    public ClientRepository clientRepositoryAdapterJPA(ClientRepositoryJPA clientRepositoryJPA,
                                                       ConversionService conversionService) {
        return new ClientRepositoryAdapterJPA(clientRepositoryJPA, conversionService);
    }

    @Bean
    public OfficeRepositoryAdapterJPA officeRepositoryAdapterJPA(OfficeRepositoryJPA officeRepositoryJPA,
                                                                 ConversionService conversionService) {
        return new OfficeRepositoryAdapterJPA(officeRepositoryJPA, conversionService);
    }

    @Bean
    public Clock defaultClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                .withLocale(new Locale("pl"))
                .withZone(ZoneId.systemDefault());
    }

    @Bean
    public OfficeService officeService(OfficeRepository officeRepository) {
        return new OfficeService(officeRepository);
    }
}
