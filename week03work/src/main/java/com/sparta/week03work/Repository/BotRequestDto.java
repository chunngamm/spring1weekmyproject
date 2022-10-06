package com.sparta.week03work.Repository;




import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본생성자를 만듭니다.
public class BotRequestDto {
    private String username;
    private String contents;
    private String title;
    private String password;

}

