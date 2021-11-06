package controller;

import aop.annotations.ValidateMessagePayload;
import com.google.gson.Gson;
import model.Message;
import model.SendMessageRequestPayload;
import service.chat.ChatService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.Integer.parseInt;

@WebServlet("/api/messages")
public class MessageController extends HttpServlet {
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String conversationId = request.getParameter("conversationId");
        String stringOffset = request.getParameter("offset");
        String stringLimit = request.getParameter("limit");

        if (conversationId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        int offset = stringLimit == null ? 0 : parseInt(stringOffset);
        int limit = stringLimit == null ? -1 : parseInt(stringLimit);
        List<Message> messages = chatService.readMessages(conversationId, offset, limit);

        response.setContentType("application/json");
        response.getWriter().println(messages);
    }

    @Override
    protected void doPost(@ValidateMessagePayload HttpServletRequest request, HttpServletResponse response) throws IOException {
        String conversationId = request.getParameter("conversationId");
        if (conversationId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        SendMessageRequestPayload messageRequestPayload = new Gson().fromJson(request.getReader(), SendMessageRequestPayload.class);
        Message message = chatService.sendMessage(conversationId, messageRequestPayload.getMessage());

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().println(message);
    }
}