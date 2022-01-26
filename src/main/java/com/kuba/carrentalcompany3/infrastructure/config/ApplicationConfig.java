package com.kuba.carrentalcompany3.infrastructure.config;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryAdapterJPA;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.ClientRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }

//    public ClientRepository clientRepositoryJPAImpl(ClientRepositoryJPA clientRepositoryJPA,
//                                                    ConversionService conversionService) {
//        return new ClientRepositoryAdapterJPA(clientRepositoryJPA, conversionService);
//    }
}
