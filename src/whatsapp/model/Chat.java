package whatsapp.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    
    List<Observer> observers = new ArrayList<>();
    List<Message> messages = new ArrayList<>();

    public static Chat Null = new Chat(){
        @Override
        public void unsubscribe(Observer observer) {
        }

        @Override
        public void subscribe(Observer observer) {
        }
        
    };

    public void subscribe(Observer observer) {   
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    
    public interface Observer {
        void update();
    }
}
