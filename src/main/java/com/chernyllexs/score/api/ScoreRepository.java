package com.chernyllexs.score.api;

import com.chernyllexs.score.model.entity.ScoreEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScoreRepository extends CrudRepository<ScoreEntity, Long>{

    Iterable<ScoreEntity> findByPostIdOrderByScoreId(Long postId);

    Long countByPostIdAndScoreStateIsTrue(Long postId);

    Long countByPostIdAndScoreStateIsFalse(Long postId);

    Long deleteByPostIdAndAndUserId(Long postId, Long userId);

    Long deleteByPostId(Long postId);

    Long deleteByUserId(Long userId);

    Optional<ScoreEntity> findByPostIdAndUserId(Long postId, Long userId);

    @Modifying
    @Query(value = "UPDATE scores SET score_state = :state WHERE score_id = :id", nativeQuery = true)
    int updateState(@Param(value = "id") Long scoreId, @Param(value = "state") Boolean scoreState);
}
