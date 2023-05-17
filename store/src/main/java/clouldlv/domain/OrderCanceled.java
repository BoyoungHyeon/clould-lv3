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
    private String orderId;
    private String address;
    private Integer amount;
    private String options;
    private String status;

    public OrderCanceled(OrderManage aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
