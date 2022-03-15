package com.chernyllexs.score.web;

import com.chernyllexs.score.model.dto.ScoreDto;
import com.chernyllexs.score.model.dto.ScoreResponseDto;
import com.chernyllexs.score.api.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add-score")
    public ResponseEntity<ScoreDto> setScore(@RequestBody ScoreDto scoreDto) {
        return ResponseEntity.ok().body(scoreService.addScore(scoreDto));
    }

    @GetMapping("/get-number-score-for-post/{postId}")
    public ResponseEntity<ScoreResponseDto> getNumberScoreByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok().body(scoreService.getNumberOfScoresByPostId(postId));
    }

    @GetMapping("/get-user-score-for-post/{postId}/{userId}")
    public ResponseEntity<Boolean> getScoreByPostIdAndUserId(@PathVariable(value = "postId") Long postId, @PathVariable(value = "userId") Long userId){
        return ResponseEntity.ok().body(scoreService.getUserScoreForPost(postId,userId));
    }

    @DeleteMapping("/delete-user-score-for-post/{postId}/{userId}")
    public ResponseEntity<ScoreResponseDto> deleteUserScoreForPost(@PathVariable(value = "postId") Long postId, @PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok().body(scoreService.deleteUserScoreForPost(postId, userId));
    }


    @DeleteMapping("/delete-all-scores-for-post/{postId}")
    public ResponseEntity<Boolean> deleteScoresByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok().body(scoreService.deleteAllScoresForPost(postId));
    }
}
