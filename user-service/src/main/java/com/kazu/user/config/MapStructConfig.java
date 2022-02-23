package com.kazu.user.config;

import com.kazu.core.jpa.BaseDto;
import com.kazu.core.jpa.BaseEntity;
import org.mapstruct.*;

/**
 * @author akifova
 * @since 24.01.2021
 */
@MapperConfig(
        uses = MapStructActiveFieldMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG
)
public interface MapStructConfig {
    @Mapping(source = "active", target = "isActive")
    BaseEntity anyToEntity(BaseDto baseDto);
    @Mapping(source = "isActive", target = "active")
    @InheritInverseConfiguration
    BaseDto anyToDto(BaseEntity baseEntity);
}
