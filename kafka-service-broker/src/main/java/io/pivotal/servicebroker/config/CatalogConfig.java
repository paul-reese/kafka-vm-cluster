package io.pivotal.servicebroker.config;

import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 *
 * @author phopper
 *
 */
@Configuration
public class CatalogConfig {
    @Bean
    public Catalog catalog() {
        return new Catalog(Collections.singletonList(
                new ServiceDefinition(
                        "kafka-broker-cluster",
                        "p-kafka-broker",
                        "Kafka broker",
                        true,
                        false,
                        Collections.singletonList(
                                new Plan("kafka-broker-plan",
                                         "shared-vm",
                                         "This is a shared Kafka service broker cluster plan",
                                         getPlanMetadata())),
                        Arrays.asList("kafka"),
                        getServiceDefinitionMetadata(),
                        null,
                        null)
        ));
    }

    private Map<String, Object> getServiceDefinitionMetadata() {
        Map<String, Object> sdMetadata = new HashMap<>();
        sdMetadata.put("displayName", "Kafka");
        sdMetadata.put("imageUrl", "https://svn.apache.org/repos/asf/kafka/site/logos/originals/png/TALL%20-%20Black%20on%20Transparent.png");
        sdMetadata.put("longDescription", "Kafka Service Broker");
        sdMetadata.put("providerDisplayName", "Pivotal");
        sdMetadata.put("documentationUrl", "https://github.com/phopper-pivotal/kafka-vm-cluster");
        sdMetadata.put("supportUrl", "https://github.com/phopper-pivotal/kafka-vm-cluster");
        return sdMetadata;
    }

    private Map<String, Object> getPlanMetadata() {
        Map<String, Object> planMetadata = new HashMap<>();
        planMetadata.put("costs", getCosts());
        planMetadata.put("bullets", getBullets());

        return planMetadata;
    }

    private List<Map<String, Object>> getCosts() {
        Map<String, Object> costsMap = new HashMap<>();
        Map<String, Object> amount = new HashMap<>();
        // @TODO need to remove the cost as it results in "will incur this cost..." message
        amount.put("USD", "0.0");

        costsMap.put("amount", amount);
        costsMap.put("unit", "MONTHLY");

        return Collections.singletonList(costsMap);
    }

    private List<String> getBullets() {
        return Arrays.asList("Shared Kafka Service Broker");
    }
}
