package clouldlv.domain;

import clouldlv.domain.*;
import clouldlv.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliveried extends AbstractEvent {

    private Long id;
    private String orderId;
    private String riderId;
    private String address;
    private String status;

    public Deliveried(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveried() {
        super();
    }
}
