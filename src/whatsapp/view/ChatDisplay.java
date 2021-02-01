package whatsapp.view;

import whatsapp.model.Chat;

public interface ChatDisplay extends Chat.Observer {

    @Override
    public void update();
    
    void display(Chat chat);
    
    public Chat chat();
}
