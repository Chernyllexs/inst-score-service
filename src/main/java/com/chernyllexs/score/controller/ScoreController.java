package com.chernyllexs.score.controller;

import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.service.ScoreServiceImpl;
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
    public ResponseEntity<ScoreDto> setScore(@RequestBody ScoreDto scoreDto){
        return ResponseEntity.ok().body(scoreService.addScore(scoreDto));
    }

    @GetMapping("/by-postId/{postId}")
    public ResponseEntity<List<ScoreDto>> getScoresByPostId(@PathVariable Long postId){
        return ResponseEntity.ok().body(scoreService.getScoreByPostId(postId));
    }
    @GetMapping("/by-userId/{userId}")
    public ResponseEntity<List<ScoreDto>> getScoresByUserId(@PathVariable Long userId){
        return ResponseEntity.ok().body(scoreService.getScoreByUserId(userId));
    }
}
