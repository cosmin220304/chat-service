package controller;

import aop.annotations.ValidateMessagePayload;
import service.chat.ChatService;
import service.chat.ChatServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
//        String conversationId = request.getParameter("conversationId");
        response.setContentType("application/json");

//        response.getWriter().println(test);
    }

    @Override
    protected void doPost(@ValidateMessagePayload HttpServletRequest request, HttpServletResponse response) {
        //to do
    }
}