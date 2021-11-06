package dao.conversation;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.annotations.Immutable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dao.dto.ConversationDto;
import dao.dto.MessageDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
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
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document x = cursor.next();
                returnedConversations.add(
                        new ConversationDto(
                                x.getObjectId("_id").toString(),
                                x.getString("participant1"),
                                x.getString("participant2"),
                                x.getList("messages", MessageDto.class)
                        )
                );
            }
        }
        return returnedConversations;
    }

    @Override
    public ConversationDto create(ConversationDto newEntry) {
        MongoCollection<Document> collection = db.getCollection("Conversation");
        Document newConversation = new Document();
        newConversation.put("participant1", newEntry.getParticipant1());
        newConversation.put("participant2", newEntry.getParticipant2());
        newConversation.put("messages", Collections.emptyList());
        collection.insertOne(newConversation);

        return new Gson().fromJson(newConversation.toJson(), ConversationDto.class);
    }

    @Override
    public ConversationDto update(ConversationDto entry) {
        return null;
    }
}
