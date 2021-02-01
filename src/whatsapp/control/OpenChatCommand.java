package whatsapp.control;

import java.util.List;
import whatsapp.model.Chat;
import whatsapp.view.ChatDisplay;
import whatsapp.view.ChatListDisplay;
import whatsapp.view.ChatLoader;

public class OpenChatCommand implements Commnad {
    
    private final ChatLoader chatLoader;
    private final ChatDisplay chatDisplay;
    private final ChatListDisplay chatListDisplay;

    public OpenChatCommand(ChatLoader chatLoader, ChatDisplay chatDisplay, ChatListDisplay chatListDisplay) {
        this.chatLoader = chatLoader;
        this.chatDisplay = chatDisplay;
        this.chatListDisplay = chatListDisplay;
    }
    
    @Override
    public void execute() {
        List<Chat> chats = chatLoader.load();
        for (Chat chat : chats) {
            chat.subscribe(chatListDisplay);
        }
        this.chatListDisplay.display(chats);
        this.chatListDisplay.on(chatSelected());
    }

    private ChatListDisplay.ChatSelected chatSelected() {
        return new ChatListDisplay.ChatSelected() {
            @Override
            public void chat(Chat chat) {
                protect(chatDisplay.chat()).unsubscribe(chatDisplay);
                chat.subscribe(chatDisplay);
                chatDisplay.display(chat);
            }
        };
    }
    
    private Chat protect(Chat chat){
        return chat != null ? chat : Chat.Null;
    }
    
    
}
