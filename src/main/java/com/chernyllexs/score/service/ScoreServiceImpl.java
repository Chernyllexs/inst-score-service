package com.chernyllexs.score.service;

import com.chernyllexs.score.entity.ScoreEntity;
import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.repository.ScoreRepository;
import com.chernyllexs.score.util.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoreMapper scoreMapper;



    @Override
    public ScoreDto addScore(ScoreDto scoreDto) {
        //check available this post
        //check users rating on this post
        return scoreMapper.convertToDto(scoreRepository.save(scoreMapper.convertToEntity(scoreDto)));
    }

    @Override
    public List<ScoreDto> getScoreByPostId(Long postId) {
        return listMapper(scoreRepository.findByPostIdOrderByScoreId(postId));
    }

    @Override
    public List<ScoreDto> getScoreByUserId(Long userId) {
        return listMapper(scoreRepository.findByUserIdOrderByScoreState(userId));
    }

    private List<ScoreDto> listMapper(Iterable<ScoreEntity> iterable){
        List<ScoreDto> scoresDto = new ArrayList<>();
        for (ScoreEntity entity: iterable)
            scoresDto.add(scoreMapper.convertToDto(entity));
        return scoresDto;
    }
}
