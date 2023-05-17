package clouldlv.domain;

import clouldlv.StoreApplication;
import clouldlv.domain.CookStarted;
import clouldlv.domain.Cooked;
import clouldlv.domain.OrderCanceled;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderManage_table")
@Data
public class OrderManage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String orderId;

    private Integer amount;

    private String options;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderManageRepository repository() {
        OrderManageRepository orderManageRepository = StoreApplication.applicationContext.getBean(
            OrderManageRepository.class
        );
        return orderManageRepository;
    }

    public void cook() {
        //
    }

    public static void confirmOrder(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        CookStarted cookStarted = new CookStarted(orderManage);
        cookStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(orderManage->{
            
            orderManage // do something
            repository().save(orderManage);

            CookStarted cookStarted = new CookStarted(orderManage);
            cookStarted.publishAfterCommit();

         });
        */

    }

    public static void cancelOrder(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        OrderCanceled orderCanceled = new OrderCanceled(orderManage);
        orderCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(orderManage->{
            
            orderManage // do something
            repository().save(orderManage);

            OrderCanceled orderCanceled = new OrderCanceled(orderManage);
            orderCanceled.publishAfterCommit();

         });
        */

    }
}
