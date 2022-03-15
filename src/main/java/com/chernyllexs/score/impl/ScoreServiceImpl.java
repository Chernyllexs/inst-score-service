package com.chernyllexs.score.impl;

import com.chernyllexs.score.api.PostService;
import com.chernyllexs.score.api.ScoreRepository;
import com.chernyllexs.score.api.ScoreService;
import com.chernyllexs.score.api.exception.PostNotFoundException;
import com.chernyllexs.score.api.exception.ScoreException;
import com.chernyllexs.score.api.mapper.ScoreMapper;
import com.chernyllexs.score.model.dto.ScoreDto;
import com.chernyllexs.score.model.dto.ScoreResponseDto;
import com.chernyllexs.score.model.entity.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private PostService postService;

    @Override
    @Transactional
    public ScoreDto addScore(ScoreDto scoreDto) {
        //check available this post
        if (!postService.postIsExists(scoreDto.getPostId()))
            throw new PostNotFoundException("Post id = " + scoreDto.getPostId() + " not found");

        Optional<ScoreEntity> entity = scoreRepository.findByPostIdAndUserId(scoreDto.getPostId(), scoreDto.getUserId());
        if (entity.isPresent()) {
            if (!entity.get().getScoreState().equals(scoreDto.getScoreState())) {
                int status = scoreRepository.updateState(entity.get().getScoreId(), scoreDto.getScoreState());
                if (status == 1) { //check state update
                    return scoreDto;
                }
            }
        } else {
            return scoreMapper.convertToDto(scoreRepository.save(scoreMapper.convertToEntity(scoreDto)));
        }
        throw new ScoreException("Score wasn't added");
    }

    @Override
    public ScoreResponseDto getNumberOfScoresByPostId(Long postId) {
        long numberOfLikes = scoreRepository.countByPostIdAndScoreStateIsTrue(postId);
        long numberOfDislikes = scoreRepository.countByPostIdAndScoreStateIsFalse(postId);
        return new ScoreResponseDto(numberOfLikes, numberOfDislikes);
    }

    @Override
    public Boolean getUserScoreForPost(Long postId, Long userId) {
        Optional<ScoreEntity> score = scoreRepository.findByPostIdAndUserId(postId, userId);
        if (score.isPresent()) {
            return score.get().getScoreState();
        }
        throw new ScoreException("Score not found");
    }

    @Override
    @Transactional
    public ScoreResponseDto deleteUserScoreForPost(Long postId, Long userId) {
        if ((scoreRepository.deleteByPostIdAndAndUserId(postId, userId)) == 0) {
            throw new ScoreException("The score wasn't deleted!");
        }
        return getNumberOfScoresByPostId(postId);
    }

    @Override
    @Transactional
    public Boolean deleteAllScoresForPost(Long postId) {
        if ((scoreRepository.deleteByPostId(postId)) != 0) {
            return true;
        }
        return false;
    }
}
