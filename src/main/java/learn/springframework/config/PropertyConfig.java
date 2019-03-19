package learn.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import learn.springframework.beans.FakeDataSource;
import learn.springframework.beans.FakeJmsBroker;

@Configuration
@PropertySources({ 
	@PropertySource("classpath:datasource.properties"), 
	@PropertySource("classpath:jms.properties") 
})
public class PropertyConfig {
	@Value("${db.username}")
	String user;

	@Value("${db.password}")
	String password;

	@Value("${db.dburl}")
	String url;

	@Value("${jms.username}")
	String jmsUsername;

	@Value("${jms.password}")
	String jmsPassoword;

	@Value("${jms.url}")
	String jmsUrl;

	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker getFakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUsername(jmsUsername);
		fakeJmsBroker.setPassword(jmsPassoword);
		fakeJmsBroker.setUrl(jmsUrl);
		return fakeJmsBroker;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		return configurer;
	}
}
