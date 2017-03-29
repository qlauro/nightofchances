package sk.qbsw.nightofchances.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.Serializable;

/**
 * The spring configuration.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SpringConfiguration implements Serializable
{
	private static final long serialVersionUID = 7941739727234284146L;

	@Bean
	@Primary
	public ObjectMapper objectMapper (Jackson2ObjectMapperBuilder builder)
	{
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		return objectMapper;
	}
}
