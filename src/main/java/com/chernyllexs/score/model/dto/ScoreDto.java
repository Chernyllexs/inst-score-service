package com.chernyllexs.score.model.dto;

public class ScoreDto {
    private Long postId;
    private Long userId;
    private Boolean scoreState;

    public ScoreDto() {
    }

    public ScoreDto(Long postId, Long userId, Boolean scoreState) {
        this.postId = postId;
        this.userId = userId;
        this.scoreState = scoreState;
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

    @Override
    public String toString() {
        return "ScoreDto{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", scoreState=" + scoreState +
                '}';
    }
}
