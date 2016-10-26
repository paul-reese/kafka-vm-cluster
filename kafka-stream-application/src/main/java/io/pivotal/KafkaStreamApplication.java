package io.pivotal;

//@SpringBootApplication
public class KafkaStreamApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(KafkaStreamApplication.class, args);

		WordCountStream wordCountStream = new WordCountStream();
		wordCountStream.runStream();
	}
}
