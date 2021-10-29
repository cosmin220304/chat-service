package controller;

import models.Message;
import models.SendMessageRequestPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.chat.ChatService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MessageControllerTest extends Mockito {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private MessageController messageController;
    private ChatService mockChatService;

    @BeforeEach
    public void setUp() throws ServletException, IOException {
        request = mock(HttpServletRequest.class);

        response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        mockChatService = mock(ChatService.class);
        messageController = new MessageController();
        messageController.init(mockChatService);
    }

    @Test
    public void Given_Get_With_QueryString_ConversationId_And_Offset_And_Limit_Call_ReadMessage() throws Exception {
        // Arrange
        when(request.getParameter("conversationId")).thenReturn("123");
        when(request.getParameter("limit")).thenReturn("5");
        when(request.getParameter("offset")).thenReturn("5");

        // Act
        messageController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).readMessages("123", 5, 5);
        verifyNoMoreInteractions(mockChatService);
    }

    @Test
    public void Given_Post_With_QueryString_ConversationId_Call_sendMessage() throws Exception {
        // Arrange
        String body = "{ \"message\": \"test\" }";
        when(request.getParameter("conversationId")).thenReturn("123");
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(body)));

        // Act
        messageController.doPost(request, response);

        // Assert
        verify(mockChatService, times(1)).sendMessage(eq("123"), eq("test"));
        verifyNoMoreInteractions(mockChatService);
    }
}
