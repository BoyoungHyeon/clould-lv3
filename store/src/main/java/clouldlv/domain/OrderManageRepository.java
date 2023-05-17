package clouldlv.domain;

import clouldlv.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderManages",
    path = "orderManages"
)
public interface OrderManageRepository
    extends PagingAndSortingRepository<OrderManage, Long> {}
