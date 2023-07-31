package com.turkcell.commonpackage.configuration.mapper;

import com.turkcell.commonpackage.utils.mapper.ModelMapperManager;
import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper) {
        return new ModelMapperManager(mapper);
    }
}
