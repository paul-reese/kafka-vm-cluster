package io.pivotal;

import io.pivotal.cloud.service.KafkaServiceInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phopper on 10/6/16.
 */
@EnableConfigurationProperties(KafkaServiceInstance.class)
@RestController
public class KafkaController {
    @Autowired
    private KafkaServiceInstance kafkaServiceInstance;

    @RequestMapping("/")
    public String hello() {
        System.out.println("=====> "+ kafkaServiceInstance.toString());

        // grab vcap services
        String vcapServices = System.getenv("VCAP_SERVICES");
        if (vcapServices != null) {
            System.out.println("=====> " + vcapServices.toString());
        } else {
            System.out.println("-----> no vcap services");
        }

        return kafkaServiceInstance.toString();
    }
}
