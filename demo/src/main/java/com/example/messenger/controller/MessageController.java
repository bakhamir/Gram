package com.example.messenger.controller;

import com.example.messenger.domain.Message;
import com.example.messenger.domain.User;
import com.example.messenger.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam String content) {
        // Для упрощения предполагаем, что юзеры уже есть в базе
        User sender = new User(); // Загрузи из базы
        User receiver = new User(); // Загрузи из базы
        return messageService.sendMessage(sender, receiver, content);
    }

    @GetMapping("/get")
    public List<Message> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        User sender = new User(); // Загрузи из базы
        User receiver = new User(); // Загрузи из базы
        return messageService.getMessages(sender, receiver);
    }
}
