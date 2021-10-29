package controller;

import aop.annotations.ValidateMessagePayload;
import models.Conversation;
import service.chat.ChatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/conversations")
public class ConversationController extends HttpServlet {
    private ChatService chatService;

    @Override
    public void init() throws ServletException {
        super.init();
        chatService = ChatService.getInstance();
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
            response.getWriter().println(conversations);

        } else if (queryString.contains("conversationId")) {
            String conversationId = queryString.split("conversationId=")[1];
            List<Conversation> conversations = chatService.getAllConversationsById(conversationId);
            response.getWriter().println(conversations);

        } else if (queryString.contains("user1") && queryString.contains("user2")) {
            String user1 = queryString.split("user1=")[1].split("&user2=")[0];
            String user2 = queryString.split("user2=")[1];
            Conversation conversation = chatService.getConversationBetweenUsers(user1, user2);
            response.getWriter().println(conversation);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}