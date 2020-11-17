package demo_20201113.annotation_develop.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

import demo_20201113.annotation_develop.entity.User;
import demo_20201113.annotation_develop.service.DemoService;
/**
 * 基于注解的开发
 * @author Jia Bing
 *
 */
import demo_20201113.annotation_develop.service.TestService;
@EnableTransactionManagement
@ComponentScan(basePackages = "demo_20201113.annotation_develop")
@Configuration
public class AppConfig {
	@Autowired
	private DemoService demoService;
	@Autowired
	private TestService testService;

	@Bean
	public User user() {
		return new User();
	}
	
	public AppConfig() {
		System.out.println("now AppConfig created....................");
	}
	@Bean
	public DataSource dataSource(DBConfig dbConfig) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(dbConfig.getDriverClassName());
		dataSource.setUrl(dbConfig.getUrl());
		dataSource.setUsername(dbConfig.getUsername());
		dataSource.setPassword(dbConfig.getPassword());
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("demo_20201113.annotation_develop.entity");
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/demo_20201113/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		
		return sqlSessionFactoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer scanner() {
		MapperScannerConfigurer scanner = new MapperScannerConfigurer();
		scanner.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		scanner.setBasePackage("demo_20201113.annotation_develop.dao");
		return scanner;
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}

	public void show() {
		
		System.out.println("demoservice is null?" + (demoService==null));
		System.out.println("Testservice is null?" + (testService==null));
	}
	
}
