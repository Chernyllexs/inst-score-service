package com.chernyllexs.score.model;

public class ScoreResponseDto {
    private Long numberOfLikes;
    private Long numberOfDislikes;

    public ScoreResponseDto(Long numberOfLikes, Long numberOfDislikes) {
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
    }

    public Long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Long numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Long getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(Long numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    @Override
    public String toString() {
        return "ScoreResponseDto{" +
                "numberOfLikes=" + numberOfLikes +
                ", numberOfDislikes=" + numberOfDislikes +
                '}';
    }
}
