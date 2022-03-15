package com.chernyllexs.score.model.entity;

import javax.persistence.*;
@Entity
@Table(name = "scores")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long scoreId;
    private Long postId;
    private Long userId;
    private Boolean scoreState;

    public ScoreEntity() {
    }

    public ScoreEntity(Long scoreId, Long postId, Long userId, Boolean scoreState) {
        this.scoreId = scoreId;
        this.postId = postId;
        this.userId = userId;
        this.scoreState = scoreState;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getScoreState() {
        return scoreState;
    }

    public void setScoreState(Boolean scoreState) {
        this.scoreState = scoreState;
    }
}
