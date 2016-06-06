package org.reactive.mvc.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DowngradingConsistencyRetryPolicy;
import com.datastax.driver.core.policies.ReconnectionPolicy;
import com.datastax.driver.core.policies.RetryPolicy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.config.java.AbstractCqlTemplateConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.util.StringUtils;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableAutoConfiguration
public class CassandraConfig extends AbstractCqlTemplateConfiguration {

    @Override
    public String getKeyspaceName() {
        return "ras";
    }

    @Bean
    public CassandraTemplate cassandraTemplate(Session session) {
        return new CassandraTemplate(session);
    }

    @Override
    protected int getPort() {
        return 19042;
    }

    @Override
    protected SocketOptions getSocketOptions() {
        SocketOptions so = new SocketOptions();
        so.setReadTimeoutMillis((int)TimeUnit.SECONDS.toMillis(60));
        return so;
    }



    @Override
    protected ReconnectionPolicy getReconnectionPolicy() {
        return new ConstantReconnectionPolicy(200L);
    }

    @Override
    protected RetryPolicy getRetryPolicy() {
        return DowngradingConsistencyRetryPolicy.INSTANCE;

    }


}