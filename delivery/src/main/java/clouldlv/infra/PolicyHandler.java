package clouldlv.infra;

import clouldlv.config.kafka.KafkaProcessor;
import clouldlv.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cooked'"
    )
    public void wheneverCooked_ConfirmDelivery(@Payload Cooked cooked) {
        Cooked event = cooked;
        System.out.println(
            "\n\n##### listener ConfirmDelivery : " + cooked + "\n\n"
        );

        // Sample Logic //
        Delivery.confirmDelivery(event);
    }
}
