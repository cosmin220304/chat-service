package dao;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dao.conversation.ConversationDao;
import dao.conversation.ConversationDaoImpl;
import dao.message.MessageDao;
import dao.message.MessageDaoImpl;

public final class DaoFactory {
    private final ConversationDao conversationDao;
    private final MessageDao messageDao;
    private final MongoDatabase db;
    private static DaoFactory instance;

    private DaoFactory(){
        this.conversationDao = new ConversationDaoImpl();
        this.messageDao = new MessageDaoImpl();
        this.db = MongoClients.create("mongodb://localhost:27017").getDatabase("ConversationStorage");
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public BaseDao getDao(String type) throws ClassNotFoundException {
       switch (type) {
           case "Conversation":
           case "conversation":
               return this.conversationDao;
           case "Message":
           case "message":
               return this.messageDao;
           default:
               throw new ClassNotFoundException("Couldn't find dao");
       }
    }
}
