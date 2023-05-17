package clouldlv.domain;

import clouldlv.domain.*;
import clouldlv.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String foodId;
    private Integer amount;
    private String customerId;
    private String options;
    private String address;
    private String status;

    public OrderCanceled(Order aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
