package uz.xtreme.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * Elasticsearch configuration.
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

  @Bean
  @Override
  public RestHighLevelClient elasticsearchClient() {
    return RestClients
            .create(ClientConfiguration.localhost())
            .rest();
  }

  @Bean
  public ElasticsearchRestTemplate elasticsearchRestTemplate(RestHighLevelClient client) {
    return new ElasticsearchRestTemplate(client);
  }
}
