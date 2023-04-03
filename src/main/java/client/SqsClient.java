package client;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;


public class SqsClient {
  public static void main(String[] args) {

    String messageBody = "Hello from IntelliJ!!";
    String queueUrl = "https://sqs.us-east-1.amazonaws.com/771290919915/SQSExerciseQueue";

    SendMessageRequest send_msg_request = new SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(messageBody);

    AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    SendMessageResult send_msg_result = sqs.sendMessage(send_msg_request);

    String msgId = send_msg_result.getMessageId();
    System.out.println("Message ID: " + msgId);
  }
} 