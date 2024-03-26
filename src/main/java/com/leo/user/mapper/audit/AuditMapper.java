package com.leo.user.mapper.audit;

import com.leo.user.common.domain.Auditable;
import com.leo.user.model.audit.AuditDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditMapper {
    AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);

    AuditDto toAuditDto(Auditable auditable);
}
