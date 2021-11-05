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
        this.db = MongoClients.create(todo: add url).getDatabase("ConversationStorage");
        this.conversationDao = new ConversationDaoImpl(db);
        this.messageDao = new MessageDaoImpl();
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
