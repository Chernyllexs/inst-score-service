package com.chernyllexs.score.util.mapper;

import com.chernyllexs.score.entity.ScoreEntity;
import com.chernyllexs.score.model.ScoreDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ScoreMapper {
    private final ModelMapper modelMapper;

    public ScoreMapper() {
        this.modelMapper = new ModelMapper();
    }

    public ScoreEntity convertToEntity(ScoreDto commentDto){
        return modelMapper.map(commentDto, ScoreEntity.class);
    }

    public ScoreDto convertToDto(ScoreEntity commentEntity){
        return modelMapper.map(commentEntity, ScoreDto.class);
    }
}
