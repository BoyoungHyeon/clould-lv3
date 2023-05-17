package clouldlv.infra;

import clouldlv.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderManageHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderManage>> {

    @Override
    public EntityModel<OrderManage> process(EntityModel<OrderManage> model) {
        return model;
    }
}
