package controller;

import com.google.gson.Gson;
import model.Conversation;
import service.chat.ChatService;
import service.chat.ChatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/conversations")
public class ConversationController extends HttpServlet {
    private ChatService chatService;

    @Override
    public void init() throws ServletException {
        super.init();
        chatService = ChatServiceImpl.getInstance();
    }

    public void init(ChatService chatService) throws ServletException {
        super.init();
        this.chatService = chatService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String queryString = request.getQueryString();

        if (queryString == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        if (queryString.contains("userId")) {
            String userId = queryString.split("userId=")[1];
            List<Conversation> conversations = chatService.getAllConversationsByUserId(userId);
            response.getWriter().println(new Gson().toJson(conversations));

        } else if (queryString.contains("conversationId")) {
            String conversationId = queryString.split("conversationId=")[1];
            List<Conversation> conversations = chatService.getAllConversationsById(conversationId);
            response.getWriter().println(new Gson().toJson(conversations));

        } else if (queryString.contains("user1") && queryString.contains("user2")) {
            String user1 = queryString.split("user1=")[1].split("&user2=")[0];
            String user2 = queryString.split("user2=")[1];
            Conversation conversation = chatService.getConversationBetweenUsers(user1, user2);
            response.getWriter().println(new Gson().toJson(conversation));

        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}