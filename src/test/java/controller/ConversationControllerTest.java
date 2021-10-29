package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import service.chat.ChatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConversationControllerTest extends Mockito {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private ConversationController conversationController;
    private ChatService mockChatService;

    @BeforeEach
    public void setUp() throws ServletException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
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
        verifyNoMoreInteractions();
    }

    @Test
    public void Given_Get_With_QueryString_ConversationId_Call_getAllConversationsById() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn("conversationId=123");

        // Act
        conversationController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).getAllConversationsById("123");
        verifyNoMoreInteractions();
    }

    @Test
    public void Given_Get_With_QueryStrings_user1_and_user2_Call_getConversationBetweenUsers() throws Exception {
        // Arrange
        when(request.getQueryString()).thenReturn("user1=123&user2=456");

        // Act
        conversationController.doGet(request, response);

        // Assert
        verify(mockChatService, times(1)).getConversationBetweenUsers("123", "456");
        verifyNoMoreInteractions();
    }
}
