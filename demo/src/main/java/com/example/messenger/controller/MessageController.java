@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam String content) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        return messageService.sendMessage(sender, receiver, content);
    }

    @GetMapping("/get")
    public List<Message> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        return messageService.getMessages(sender, receiver);
    }
}
