package br.com.fiap.appointments.config

import com.amazon.sqs.javamessaging.ProviderConfiguration
import com.amazon.sqs.javamessaging.SQSConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.regions.Region
import org.springframework.jms.support.destination.DynamicDestinationResolver

@Configuration
class JmsConfig {

    @Bean
    fun connectionFactory(): SQSConnectionFactory {
        val sqsClient = SqsClient.builder()
            .region(Region.US_EAST_1)
            .build()

        return SQSConnectionFactory(ProviderConfiguration(), sqsClient)
    }

    @Bean
    fun jmsTemplate(): JmsTemplate {
        return JmsTemplate(connectionFactory())
    }

    @Bean
    fun jmsListenerContainerFactory(): DefaultJmsListenerContainerFactory {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory())
        factory.setDestinationResolver(DynamicDestinationResolver())
        factory.setConcurrency("3-10")
        return factory
    }
}