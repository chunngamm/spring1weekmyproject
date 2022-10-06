package com.sparta.week03work.service;


import com.sparta.week03work.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor //선언할때 스프링에게 알려줌
@Service // 이것은 서비스라는 것을 스프링에게 알려준다.
public class BotService {

    private final BotRepository botRepository;

//    public static Bot createBot() {
//        BotRequestDto BotRequestDto = new BotRequestDto();
//        Bot bot = new Bot(BotRequestDto);
//        return BotRepository.save(bot);
//    }
    @Transactional
    public Long update(Long id, BotRequestDto requestDto) {
        Bot bot = botRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        bot.update(requestDto);
        return bot.getId();
    }

    @Transactional
    public boolean passwordCheck(Long id, BotRequestDto requestDto) {
        Bot bot = botRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 글입니다.")
        );
        return bot.getPassword().equals(requestDto.getPassword());
    }

}
