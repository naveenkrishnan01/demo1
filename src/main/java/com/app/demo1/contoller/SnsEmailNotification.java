package com.app.demo1.contoller;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.app.demo1.Config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsEmailNotification {

    @Autowired
    private AmazonSNSClient snsClient;

    //Please copy the below value from your sns topic
    String TOPIC_ARN = "arn:aws:sns:us-east-1:xxxxxxxxx:springBootEmail";

    @GetMapping("/addSubscription/{email}")
    public String addSubscription(@PathVariable String email) {
        SubscribeRequest subscribeRequest =
                new SubscribeRequest(TOPIC_ARN, "email", email);
        snsClient.subscribe(subscribeRequest);
        return "Subscription is pending, please subscribe the email : " + email;
    }

    @GetMapping("/sendEmailNotification")
    public String publishMessage() {
        PublishRequest publishRequest =
                new PublishRequest(TOPIC_ARN, emailBody(), "Hello Sns");
        snsClient.publish(publishRequest);
        return "Notification send successfully";

    }

    public String emailBody() {
        return "Dear Subscriber ,\n" +
                "\n" +
                "\n" +
                "Notification triggered on hitting api for sendEmailNotification"+"\n"+
                "We are using the SNS service of aws where we create a topic ! \n" +
                "Subscriber notification is generated on hitting addSubscription api";
    }
}