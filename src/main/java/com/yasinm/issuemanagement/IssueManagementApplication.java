package com.yasinm.issuemanagement;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class IssueManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueManagementApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulatorFactoryBean(){
        Jackson2RepositoryPopulatorFactoryBean jackson2RepositoryPopulatorFactoryBean = new Jackson2RepositoryPopulatorFactoryBean();
        jackson2RepositoryPopulatorFactoryBean.setResources(new Resource[]{new ClassPathResource("projects.json")});
        return  jackson2RepositoryPopulatorFactoryBean;
    }
}
