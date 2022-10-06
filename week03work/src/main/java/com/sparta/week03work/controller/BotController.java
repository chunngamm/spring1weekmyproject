package com.sparta.week03work.controller;

import com.sparta.week03work.Repository.*;
import com.sparta.week03work.service.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//vinal 선언할때 스프링에게 알려줌
@RestController //ResponseBody를 안붙여도 문자열과 json 등을 전송이 가능
public class BotController {

    private final BotRepository botRepository;
    private final BotService botService;

    @GetMapping("/api/bot") //get으로 매핑해준다.
    public List<Bot> getBot() {
        return botRepository.findAllByOrderByModifiedAtDesc();
    }
    @GetMapping("/api/bot/{id}") //get으로 매핑해준다.
    public Optional<Bot> getBots(@PathVariable Long id) {
        return botRepository.findById(id);
    }

//    @PostMapping("/api/bot") //포스트로 매핑해준다.
//    public Bot createBot() {
//        return BotService.createBot();
//    }

    @PostMapping("/api/bot")//post로 매핑해준다.
    public Bot createBot(@RequestBody BotRequestDto requestDto) {
        Bot bot = new Bot(requestDto);
        return botRepository.save(bot);
    }
    @PostMapping("/api/bot/{id}")//post로 매핑해준다.
    public boolean passwordCheck(@PathVariable Long id, @RequestBody BotRequestDto requestDto) { //
        return botService.passwordCheck(id, requestDto);
    }


    @PutMapping("/api/bot/{id}")//put으로 매핑해준다.
    public Long updateBot(@PathVariable Long id, @RequestBody BotRequestDto requestDto) {
        botService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/bot/{id}")//delete로 매핑해준다.
    public Long deleteBot(@PathVariable Long id) {//@PathVariable url 경로에 변수를 넣어주는 것이다.
        botRepository.deleteById(id);
        return id;
    }
}

