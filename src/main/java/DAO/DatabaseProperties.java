package DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProperties {
	
	@Value("${use.database}")
	private String useDatabase;
	
	@Value("${use.database2}")
	private String useDatabase2;

	@Value("${db.mysql.drivername}")
	private String driverName;

	@Value("${accounts.mysql.url}")
	private String accountsUrl;
	
	@Value("${properties.mysql.url}")
	private String propertiesUrl;

	@Value("${db.mysql.username}")
	private String databaseUsername;

	@Value("${db.mysql.password}")
	private String databasePassword;

	public String getUseDatabase() {
		return useDatabase;
	}

	public void setUseDatabase(String useDatabase) {
		this.useDatabase = useDatabase;
	}

	public String getUseDatabase2() {
		return useDatabase2;
	}

	public void setUseDatabase2(String useDatabase2) {
		this.useDatabase2 = useDatabase2;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getAccountsUrl() {
		return accountsUrl;
	}

	public void setAccountsUrl(String accountsUrl) {
		this.accountsUrl = accountsUrl;
	}

	public String getPropertiesUrl() {
		return propertiesUrl;
	}

	public void setPropertiesUrl(String propertiesUrl) {
		this.propertiesUrl = propertiesUrl;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
	
}
