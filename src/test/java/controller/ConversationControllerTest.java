package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import service.chat.ChatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ConversationControllerTest extends Mockito {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private ConversationController conversationController;
    private ChatService mockChatService;

    @BeforeEach
    public void setUp() throws ServletException, IOException {
        request = mock(HttpServletRequest.class);

        response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        mockChatService = mock(ChatService.class);
        conversationController = new ConversationController();
        conversationController.init(mockChatService);
    }

    @Test
    public void Given_Get_With_QueryString_UserId_Call_getAllConversationsByUserId() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn("userId=123");

        // Act
        conversationController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).getAllConversationsByUserId("123");
        verifyNoMoreInteractions(mockChatService);
    }

    @Test
    public void Given_Get_With_QueryString_ConversationId_Call_getAllConversationsById() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn("conversationId=123");

        // Act
        conversationController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).getAllConversationsById("123");
        verifyNoMoreInteractions(mockChatService);
    }

    @Test
    public void Given_Get_With_QueryStrings_user1_and_user2_Call_getConversationBetweenUsers() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn("user1=123&user2=456");

        // Act
        conversationController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).getConversationBetweenUsers("123", "456");
        verifyNoMoreInteractions(mockChatService);
    }

    @Test
    public void Given_Get_With_Invalid_or_Null_QueryStrings_Return_Not_Found() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn(null);

        // Act
        conversationController.doGet(request, response);

        // Assert
        verifyNoInteractions(mockChatService);
    }
}
