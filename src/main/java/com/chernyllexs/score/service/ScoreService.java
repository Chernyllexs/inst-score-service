package com.chernyllexs.score.service;

import com.chernyllexs.score.model.ScoreDto;

import java.util.List;

public interface ScoreService {
    void setScore(ScoreDto commentDto);

    List<ScoreDto> getScoreByPostId(Long postId);

}
