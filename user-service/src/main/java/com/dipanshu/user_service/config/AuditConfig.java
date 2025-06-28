package com.dipanshu.user_service.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return () -> Optional.of("system");
	}
}