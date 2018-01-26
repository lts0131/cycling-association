package com.lts.webmagic.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseConfig {

	private static Logger logger = Logger.getLogger(DatabaseConfig.class);
	
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("loginUsername", "admin");
		reg.addInitParameter("loginPassword", "admin");
		return reg;
	}

	@Primary
	@Bean(name = "miDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.lts")
	public DataSource ecssentDataSource() {
		//return new DruidDataSource();
		DruidDataSource druidDataSource = new DruidDataSource();
		List<Filter> filterList=new ArrayList<>();
		filterList.add(wallFilter());
		druidDataSource.setProxyFilters(filterList);
		return druidDataSource;
	}


	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

	@Bean
	public WallFilter wallFilter(){
		WallFilter wallFilter=new WallFilter();
		wallFilter.setConfig(wallConfig());
		return  wallFilter;
	}
	@Bean
	public WallConfig wallConfig(){
		WallConfig config =new WallConfig();
		config.setMultiStatementAllow(true);//允许一次执行多条语句
		config.setNoneBaseStatementAllow(true);//允许非基本语句的其他语句
		return config;
	}

}
