package com.sparta.week03work.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BotRepository extends JpaRepository<Bot, Long> {


    List<Bot> findAllByOrderByModifiedAtDesc(); //내림차순으로 정리

}
