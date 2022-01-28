package com.chernyllexs.score.repository;

import com.chernyllexs.score.entity.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {
}
