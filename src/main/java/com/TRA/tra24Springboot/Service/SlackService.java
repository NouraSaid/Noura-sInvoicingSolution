package com.TRA.tra24Springboot.Service;


import com.slack.api.Slack;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {



    @Value("${slack.token}")
    private String slackToken;

    public void sendMessage(String channel, String message) {
        Slack slack = Slack.getInstance();
        String token = slackToken=""; // Your Slack API token

        channel = "#noura";
        message = "Hi";
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build();

        try {
            ChatPostMessageResponse response = slack.methods(token).chatPostMessage(request);
            if (response.isOk()) {
                System.out.println("Message sent successfully to Slack!");
            } else {
                System.out.println("Failed to send message to Slack: " + response.getError());
            }
        } catch (Exception e) {
            System.out.println("Error sending message to Slack: " + e.getMessage());
        }
    }

/*    public void sendMessage(String title, String message) {
        RestTemplate restTemplate = new RestTemplate();
        String payload = String.format("{\"text\": \"%s\\n%s\"}", title, message);

        try {
            restTemplate.postForEntity(slackToken, payload, String.class);
        } catch (Exception e) {
            System.out.println("Error sending message to Slack: " + e.getMessage());
        }
    }*/
}