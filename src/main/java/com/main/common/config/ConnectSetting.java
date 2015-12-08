package com.main.common.config;

import java.util.*;

import org.springframework.beans.factory.config.*;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.core.env.*;
import org.springframework.core.io.*;

/**


 * activeProfile = default => db_default.yml
 * 				   develop => db_develop.yml
 *  			   product => db_product.yml
 */
public class ConnectSetting {
static private ConnectSetting connectSetting = new ConnectSetting();
	
	static public String mysqlDriverClassName;
	static public String mysqlUrl;
	static public String mysqlUsername;
	static public String mysqlPassword;
	static public String mssqlDriverClassName;
	static public String mssqlUrl;
	static public String mssqlUsername;
	static public String mssqlPassword;
	
	private ConnectSetting() {
		super();
		ConfigurableApplicationContext context = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = context.getEnvironment();
		String dbActive = "";
		if(env.getActiveProfiles().length > 0){
			dbActive = env.getActiveProfiles()[0];
		}else{
			dbActive = env.getDefaultProfiles()[0];
		}
		context.close();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("dbInfo/db_"+dbActive+".yml"));
		Properties proper = yaml.getObject();
		mysqlDriverClassName = proper.getProperty("db.mysqlDriverClassName");
		mysqlUrl = proper.getProperty("db.mysqlUrl");
		mysqlUsername = proper.getProperty("db.mysqlUsername");
		mysqlPassword = proper.getProperty("db.mysqlPassword");
		
		mssqlDriverClassName= proper.getProperty("db.mssqlDriverClassName");
		mssqlUrl= proper.getProperty("db.mssqlUrl");
		mssqlUsername= proper.getProperty("db.mssqlUsername");
		mssqlPassword= proper.getProperty("db.mssqlPassword");
	}
	
	public static ConnectSetting getInstance(){
        return connectSetting;
    }

	
	
}
