package com.chernyllexs.score.service;

import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.repository.ScoreRepository;
import com.chernyllexs.score.util.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public void setScore(ScoreDto commentDto) {
        scoreRepository.save(scoreMapper.convertToEntity(commentDto));
    }

    @Override
    public List<ScoreDto> getScoreByPostId(Long postId) {
        return null;
    }
}
