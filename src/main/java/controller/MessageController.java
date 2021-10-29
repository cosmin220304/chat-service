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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("got message");
    }

    @Override
    protected void doPost(@ValidateMessagePayload HttpServletRequest request, HttpServletResponse response) {
        //to do
    }
}