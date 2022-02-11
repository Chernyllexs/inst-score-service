package com.chernyllexs.score.service;

import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.model.ScoreResponseDto;

import java.util.List;

public interface ScoreService {
    void addScore(ScoreDto scoreDto);

    ScoreResponseDto getNumberOfScoresByPostId(Long postId);

    void deleteUserScoreForPost(Long postId, Long userId);

    void deleteAllUserScores(Long userId);

    void deleteAllScoresForPost(Long postId);
}
