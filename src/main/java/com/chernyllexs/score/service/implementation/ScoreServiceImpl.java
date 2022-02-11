package com.chernyllexs.score.service.implementation;

import com.chernyllexs.score.entity.ScoreEntity;
import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.model.ScoreResponseDto;
import com.chernyllexs.score.repository.ScoreRepository;
import com.chernyllexs.score.service.PostService;
import com.chernyllexs.score.service.ScoreService;
import com.chernyllexs.score.util.exception.PostNotFoundException;
import com.chernyllexs.score.util.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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
    public void addScore(ScoreDto scoreDto) {
        //check available this post
        if(!postService.postIsExists(scoreDto.getPostId()))
            throw new PostNotFoundException("Post id = " + scoreDto.getPostId() + " not found" );

        Optional<ScoreEntity> entity = scoreRepository.findByPostIdAndUserId(scoreDto.getPostId(), scoreDto.getUserId());
        if (entity.isPresent()) {
            if (!entity.get().getScoreState().equals(scoreDto.getScoreState()))
                scoreRepository.updateState(entity.get().getScoreId(), scoreDto.getScoreState());
        } else {
            scoreMapper.convertToDto(scoreRepository.save(scoreMapper.convertToEntity(scoreDto)));
        }
    }

    @Override
    public ScoreResponseDto getNumberOfScoresByPostId(Long postId) {
        long numberOfLikes = scoreRepository.countByPostIdAndScoreStateIsTrue(postId);
        long numberOfDislikes = scoreRepository.countByPostIdAndScoreStateIsFalse(postId);
        return new ScoreResponseDto(numberOfLikes, numberOfDislikes);
    }

    @Override
    @Transactional
    public void deleteUserScoreForPost(Long postId, Long userId) {
        scoreRepository.deleteByPostIdAndAndUserId(postId, userId);
    }

    @Override
    @Transactional
    public void deleteAllUserScores(Long userId) {
        scoreRepository.deleteByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteAllScoresForPost(Long postId) {
        scoreRepository.deleteByPostId(postId);
    }

    //===============

    public List<ScoreDto> getScoreByPostId(Long postId) {
        return listMapper(scoreRepository.findByPostIdOrderByScoreId(postId));
    }

    private List<ScoreDto> listMapper(Iterable<ScoreEntity> iterable) {
        List<ScoreDto> scoresDto = new ArrayList<>();
        for (ScoreEntity entity : iterable)
            scoresDto.add(scoreMapper.convertToDto(entity));
        return scoresDto;
    }
}
