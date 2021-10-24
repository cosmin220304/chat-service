package controller;

import aop.annotations.ValidateMessagePayload;
import service.chat.ChatService;
import service.chat.ChatServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/api/chat-service")
public class ChatServiceController extends HttpServlet {

    private ChatService chatService;

    @Override
    public void init() throws ServletException {
        super.init();
        chatService = new ChatServiceImpl();
        System.out.println("test123");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("hello world");
    }

    @Override
    protected void doPost(@ValidateMessagePayload HttpServletRequest request, HttpServletResponse response) {
        //to do
    }
}