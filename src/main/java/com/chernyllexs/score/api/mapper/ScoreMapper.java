package com.chernyllexs.score.api.mapper;

import com.chernyllexs.score.model.entity.ScoreEntity;
import com.chernyllexs.score.model.dto.ScoreDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ScoreMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public ScoreEntity convertToEntity(ScoreDto commentDto){
        return Objects.isNull(commentDto) ? null : modelMapper.map(commentDto, ScoreEntity.class);
    }

    public ScoreDto convertToDto(ScoreEntity commentEntity){
        return Objects.isNull(commentEntity) ? null : modelMapper.map(commentEntity, ScoreDto.class);
    }
}
