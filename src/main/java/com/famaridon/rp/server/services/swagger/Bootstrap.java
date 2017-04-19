package com.famaridon.rp.server.services.swagger;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.ReaderConfigUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by famaridon on 11/04/2017.
 */
@WebServlet(loadOnStartup = 2,initParams ={
	@WebInitParam(name = "scan.all.resources",value = "true")
})
public class Bootstrap extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ReaderConfigUtils.initReaderConfig(config);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("com.famaridon.rp.server.services");
		beanConfig.setScan(true);
	}
}
