package io.pivotal;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

public class WordCountStream {

    private String topic = "streams-file-input";
    private final String version = "0.2";
    private KafkaStreams streams;
    private String brokerList = "localhost:9092";
    private String zookeeperList = "localhost:2181";

    public void runStream() throws Exception {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeeperList);
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.STATE_DIR_CONFIG, ".");

        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> source = builder.stream("streams-file-input");

        KTable<String, Long> counts = source
                .flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String value) {
                        //if (value.equals("Dikurola")) {
                        //    System.out.println("HIT IT: " + value);
                        //    System.exit(1);
                        //} else {
                            System.out.println("fruit/veggie: " + value);
                        //}
                        return Arrays.asList(value.toLowerCase(Locale.getDefault()));
                    }
                }).map(new KeyValueMapper<String, String, KeyValue<String, String>>() {
                    @Override
                    public KeyValue<String, String> apply(String key, String value) {

                        return new KeyValue<>(value, value);
                    }
                })
                .countByKey("Counts");

        // need to override value serde to Long type
        counts.to(Serdes.String(), Serdes.Long(), "streams-wordcount-output");

        KafkaStreams streams = new KafkaStreams(builder, props);
        // delete the applications local state, forcing a reset
        //streams.cleanUp();

        Thread.sleep(10000);
        // start stream
        streams.start();

        //streams.close();
    }
}
