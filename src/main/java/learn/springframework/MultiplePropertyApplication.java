package learn.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import learn.springframework.beans.FakeDataSource;
import learn.springframework.beans.FakeJmsBroker;

@SpringBootApplication
public class MultiplePropertyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MultiplePropertyApplication.class, args);

		FakeDataSource dbSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		FakeJmsBroker jmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);

		System.out.println("Data Source : " + dbSource.getUser());
		System.out.println("JMS Broker : " + jmsBroker.getUsername());
	}
}
