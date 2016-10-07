package io.pivotal.cloud.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Service Instance for Kafka. Values will default to application.* files but can be overridden by setters
 *
 * @author phopper
 */
@ConfigurationProperties(prefix = "vcap.services.kafka-broker-cluster.credentials")
public class KafkaServiceInstance {
    private String topic;

    private String brokerList;

    private String zkNodes;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getZkNodes() {
        return zkNodes;
    }

    public void setZkNodes(String zkNodes) {
        this.zkNodes = zkNodes;
    }

    @Override
    public String toString() {
        return "KafkaServiceInstance{" +
                "topic='" + getTopic() + '\'' +
                ", brokerList='" + getBrokerList() + '\'' +
                ", zookeeperNodes='" + getZkNodes() + '\'' +
                '}';
    }
}
