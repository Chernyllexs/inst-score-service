package com.chernyllexs.score.repository;

import com.chernyllexs.score.entity.ScoreEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScoreRepository extends CrudRepository<ScoreEntity, Long>{

    Iterable<ScoreEntity> findByPostIdOrderByScoreId(Long postId);

    Iterable<ScoreEntity> findByUserIdOrderByScoreState(Long userId);

    Long countByPostIdAndScoreStateIsTrue(Long postId);

    Long countByPostIdAndScoreStateIsFalse(Long postId);

    Long deleteByPostIdAndAndUserId(Long postId, Long userId);

    Long deleteByPostId(Long postId);

    Long deleteByUserId(Long userId);

    Boolean existsByPostIdAndUserId(Long postId, Long userId);

    Optional<ScoreEntity> findByPostIdAndUserId(Long postId, Long userId);

    @Modifying
    @Query(value = "UPDATE scores SET score_state = :state WHERE score_id = :id", nativeQuery = true)
    void updateState(@Param(value = "id") Long scoreId, @Param(value = "state") Boolean scoreState);
}
