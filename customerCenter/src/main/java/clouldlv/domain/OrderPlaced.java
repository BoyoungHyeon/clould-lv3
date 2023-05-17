package clouldlv.domain;

import clouldlv.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private Integer amount;
    private String customerId;
    private String options;
    private String address;
    private String status;
}
