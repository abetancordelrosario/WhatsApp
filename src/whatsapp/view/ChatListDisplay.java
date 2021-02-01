package whatsapp.view;

import java.util.List;
import whatsapp.model.Chat;

public interface ChatListDisplay extends Chat.Observer {

    @Override
    public void update();

    void display(List<Chat> chats);
    
    void on(ChatSelected chatSelected);
        
    public interface ChatSelected {
        void chat(Chat chat);
    }
}
