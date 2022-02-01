package com.chernyllexs.score.service;

import com.chernyllexs.score.model.ScoreDto;

import java.util.List;

public interface ScoreService {
    ScoreDto addScore(ScoreDto scoreDto);

    List<ScoreDto> getScoreByPostId(Long postId);

    List<ScoreDto> getScoreByUserId(Long postId);
}
