package com.example.domain.mapper;

import com.example.domain.entity.WebEntity;
import com.example.domain.vo.WebEntityVO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

/**
 * Web entities mapper
 */
@Mapper(componentModel = "spring")
public interface WebEntityMapper {

    @Named("FullForm")
    WebEntityVO domainToVo(WebEntity webEntity);

    @IterableMapping(qualifiedByName = "FullForm")
    List<WebEntityVO> domainListToVoList(List<WebEntity> webEntities);
}
