package com.chernyllexs.score.controller;

import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.model.ScoreResponseDto;
import com.chernyllexs.score.service.implementation.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreServiceImpl scoreService;

    @PostMapping
    public void setScore(@RequestBody ScoreDto scoreDto) {
        scoreService.addScore(scoreDto);
    }

    @GetMapping("/get-number-score-for-post/{postId}")
    public ResponseEntity<ScoreResponseDto> getNumberScoreByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok().body(scoreService.getNumberOfScoresByPostId(postId));
    }

    @GetMapping("/by-postId/{postId}")
    public ResponseEntity<List<ScoreDto>> getScoresByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok().body(scoreService.getScoreByPostId(postId));
    }

    @DeleteMapping("/delete-user-score-for-post/{postId}/{userId}")
    public void deleteUserScoreForPost(@PathVariable(value = "postId") Long postId, @PathVariable(value = "userId") Long userId) {
        scoreService.deleteUserScoreForPost(postId, userId);
    }

    @DeleteMapping("/delete-all-scores-for-post/{postId}")
    public void deleteScoresByPostId(@PathVariable Long postId) {
        scoreService.deleteAllScoresForPost(postId);
    }

    @DeleteMapping("/delete-all-user-scores/{userId}")
    public void deleteScoresByUserId(@PathVariable Long userId) {
        scoreService.deleteAllUserScores(userId);
    }
}
