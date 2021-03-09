package adn.ceiba.consignataria.infraestructura.persistencia.repositorio;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "com.baeldung.spring.data.cosmosdb.repository")
public class MongoDbConfiguration {
	
    @Value("${azure.cosmosdb.uri}")
    private String uri;

    @Value("${azure.cosmosdb.key}")
    private String key;

    @Value("${azure.cosmosdb.database}")
    private String dbName;

    private CosmosKeyCredential cosmosKeyCredential;

    @Bean
    public CosmosDBConfig getConfig() {
        this.cosmosKeyCredential = new CosmosKeyCredential(key);
        CosmosDBConfig cosmosdbConfig = CosmosDBConfig.builder(uri, this.cosmosKeyCredential, dbName)
            .build();
        return cosmosdbConfig;
    }

}
