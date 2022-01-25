package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryJPAImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }

//    public ClientRepository clientRepositoryJPAImpl(ClientRepositoryJPA clientRepositoryJPA,
//                                                    ConversionService conversionService) {
//        return new ClientRepositoryJPAImpl(clientRepositoryJPA, conversionService);
//    }
}
