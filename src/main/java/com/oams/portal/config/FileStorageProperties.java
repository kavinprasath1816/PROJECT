package com.oams.portal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "file")
@Data
@Component
public class FileStorageProperties {
    private String uploadDir;
}
