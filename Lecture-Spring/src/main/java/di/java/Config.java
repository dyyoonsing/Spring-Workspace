package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * xml에서 bean만드는 행동을 대체하는 class - @Configuration 어노테이션 사용
 */
@ComponentScan(basePackages = {"di.java"})
@Configuration
public class Config {
	
	
	
	
	/*
//	@Bean(name="car")		-- 컴퓨터가 메소드명을 이름으로 인식! 아니면 name="car"이렇게 해야함
	@Bean
	public Car car() {
		return new Car();
	}
	
	//<bean class="di.java.HanKookTire" id="hankookTire" />와 같은 의미
	//@Qualifier 쓰는건  (name="hankook")과 동일! 이름을 부여하는 것
	@Bean
	@Qualifier("hankook")
	public Tire hankookTire() {
		return new HankookTire();
	}
	
	@Bean(name="kumho")
	public Tire kumhoTire() {
		return new KumhoTire();
	}
	*/
}