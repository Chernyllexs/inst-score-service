package com.chernyllexs.score.api;

import com.chernyllexs.score.model.dto.ScoreDto;
import com.chernyllexs.score.model.dto.ScoreResponseDto;

public interface ScoreService {
    ScoreDto addScore(ScoreDto scoreDto);

    ScoreResponseDto getNumberOfScoresByPostId(Long postId);

    Boolean getUserScoreForPost(Long postId, Long userId);

    ScoreResponseDto deleteUserScoreForPost(Long postId, Long userId);

    Boolean deleteAllScoresForPost(Long postId);
}
