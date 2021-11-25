package dao.message;

import com.google.gson.Gson;
import com.mongodb.annotations.Immutable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dao.dto.ConversationDto;
import dao.dto.MessageDto;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MessageDaoImpl implements MessageDao {
    private final MongoDatabase db;

    public MessageDaoImpl(MongoDatabase db) {
        this.db = db;
    }

    /**
     * @param id = "conversationId&messageId"
     * @return
     */
    @Override
    public Optional<MessageDto> readById(String id) {
        MongoCollection<Document> collection = db.getCollection("Conversation");
        String[] ids = id.split("&");
        String conversationId = ids[0];
        String messageId = ids[1];

        try (MongoCursor<Document> cursor = collection.find(Filters.eq("_id", conversationId)).iterator()) {
            Document x = cursor.next();
            return x.getList("messages", MessageDto.class)
                    .stream()
                    .filter(messageDto -> messageDto.getId().equals(messageId))
                    .findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<MessageDto> readAll(Bson filters) {
        MongoCollection<Document> collection = db.getCollection("Conversation");
        try (MongoCursor<Document> cursor = collection.find(filters).iterator()) {
            Document x = cursor.next();
            return x.getList("messages", MessageDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public MessageDto create(MessageDto newEntry) {
        return null;
    }

    @Override
    public MessageDto update(MessageDto entry) {
        return null;
    }
//
//    @Override
//    public ConversationDto create(ConversationDto newEntry) {
//        MongoCollection<Document> collection = db.getCollection("Conversation");
//        Document newConversation = new Document();
//        newConversation.put("participant1", newEntry.getParticipant1());
//        newConversation.put("participant2", newEntry.getParticipant2());
//        newConversation.put("messages", Collections.emptyList());
//        collection.insertOne(newConversation);
//
//        return new Gson().fromJson(newConversation.toJson(), ConversationDto.class);
//    }
//
//    @Override
//    public ConversationDto update(ConversationDto entry) {
//        MongoCollection<Document> collection = db.getCollection("Conversation");
//
//        Document updatedConversation = new Document();
//        updatedConversation.put("participant1", entry.getParticipant1());
//        updatedConversation.put("participant2", entry.getParticipant2());
//        updatedConversation.put("messages", Collections.emptyList());
//
//        collection.updateOne(Filters.eq("_id", entry.getId()), updatedConversation);
//        return entry;
//    }
}
