package br.com.poc.dynamodb.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "br.com.poc.dynamodb.productmanagement")
public class DynamoConfig {

	@Value("${aws.dynamodb.endpoint}")
	private String dynamoEndpoint;

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient();

		amazonDynamoDB.setEndpoint(dynamoEndpoint);

		return amazonDynamoDB;
	}
}
