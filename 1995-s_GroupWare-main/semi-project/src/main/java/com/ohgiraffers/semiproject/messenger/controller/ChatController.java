package com.ohgiraffers.semiproject.messenger.controller;

import com.ohgiraffers.semiproject.messenger.model.dto.ChatDTO;
import com.ohgiraffers.semiproject.messenger.model.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;


    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatDTO sendMessage(ChatDTO chat) {

        // 지금까지 한 기능.
        // 1. 사용자 목록 조회
        // 2. 채팅 상대에게 메세지 보내기

        // 해야 될 것.
        // 채팅 기록 select
        // 유저 정보 특정하기

        String code = "001";

        System.out.println("code = " + code);

        chat.setSenderCode(code);
        chat.setTimestamp(new Timestamp(System.currentTimeMillis())); // 현재 시간 설정
        System.out.println("chat = " + chat);
        service.insertChat(chat);
        // 메시지 저장
        return chat; // 메시지 브로커를 통해 전송
    }
}