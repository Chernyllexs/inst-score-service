package com.chernyllexs.score.controller;

import com.chernyllexs.score.model.ScoreDto;
import com.chernyllexs.score.service.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreServiceImpl scoreService;

    @PostMapping
    public void setScore(@RequestBody ScoreDto scoreDto){
        scoreService.setScore(scoreDto);
    }
}
