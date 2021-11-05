package dao.conversation;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.dto.ConversationDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ConversationDaoImpl implements ConversationDao {

    private final MongoDatabase db;

    public ConversationDaoImpl(MongoDatabase db) {
        this.db = db;
    }

    @Override
    public ConversationDto readById(String id) {
        return null;
    }

    @Override
    public List<ConversationDto> readAll() {
        List<ConversationDto> returnedConversations = new ArrayList<ConversationDto>();

        MongoCollection<Document> collection = db.getCollection("Conversation");
        BasicDBObject searchQuery = new BasicDBObject();
        try (MongoCursor<Document> cursor = collection.find(searchQuery).iterator()) {
            while (cursor.hasNext()) {
                ConversationDto conversation = new Gson().fromJson(cursor.next().toJson(), ConversationDto.class);
                returnedConversations.add(conversation);
            }
        }

        return returnedConversations;
    }

    @Override
    public ConversationDto create(ConversationDto newEntry) {
        return null;
    }

    @Override
    public ConversationDto update(ConversationDto entry) {
        return null;
    }
}
