package de.regioosm.housenumbercore.util;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;


public class Applicationconfiguration {

	public String servername = "";
	public String application_homedir = "";
	public String application_datadir = "";
	public String db_application_url = "";
	public String db_application_username = "";
	public String db_application_password = "";
	public String db_application_listofstreets_url = "";
	public String db_application_listofstreets_username = "";
	public String db_application_listofstreets_password = "";
	public String db_osm2pgsql_url = "";
	public String db_osm2pgsql_username = "";
	public String db_osm2pgsql_password = "";
	public String db_osm2pgsqlwrite_username = "";
	public String db_osm2pgsqlwrite_password = "";
	public String osmosis_laststatefile = "";
	public String logging_filename = "";
	public Level logging_console_level = Level.FINEST;
	public Level logging_file_level = Level.FINEST;
	
	public Applicationconfiguration () {
			// get some configuration infos
		String configuration_filename = "../housenumbercore.properties";		

		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);

		try {
			System.out.println("read property file " + dir + File.separator + configuration_filename);
			Reader reader = new FileReader( dir + File.separator + configuration_filename );
			Properties prop = new Properties();
			prop.load( reader );
				// iterate over all properties and remove in-line comments in property values
			for (Entry<Object, Object> entry : prop.entrySet()) {
		        if(entry.getValue().toString().indexOf("#") != -1) {
		        	String tempentry = entry.getValue().toString().substring(0, entry.getValue().toString().indexOf("#"));
		        	tempentry = tempentry.trim();
		        	prop.setProperty(entry.getKey().toString(),  tempentry);
		        }
		    }
			prop.list( System.out );
		

			if( prop.getProperty("servername") != null)
				this.servername = prop.getProperty("servername");
			if( prop.getProperty("application_homedir") != null)
				this.application_homedir = prop.getProperty("application_homedir");
			if( prop.getProperty("application_datadir") != null)
				this.application_datadir = prop.getProperty("application_datadir");
			if( prop.getProperty("db_application_url") != null)
				this.db_application_url = prop.getProperty("db_application_url");
			if( prop.getProperty("db_application_username") != null)
				this.db_application_username = prop.getProperty("db_application_username");
			if( prop.getProperty("db_application_password") != null)
				this.db_application_password = prop.getProperty("db_application_password");
			if( prop.getProperty("db_application_listofstreets_url") != null)
				this.db_application_listofstreets_url = prop.getProperty("db_application_listofstreets_url");
			if( prop.getProperty("db_application_listofstreets_username") != null)
				this.db_application_listofstreets_username = prop.getProperty("db_application_listofstreets_username");
			if( prop.getProperty("db_application_listofstreets_password") != null)
				this.db_application_listofstreets_password = prop.getProperty("db_application_listofstreets_password");
			if( prop.getProperty("db_osm2pgsql_url") != null)
				this.db_osm2pgsql_url = prop.getProperty("db_osm2pgsql_url");
			if( prop.getProperty("db_osm2pgsql_username") != null)
				this.db_osm2pgsql_username = prop.getProperty("db_osm2pgsql_username");
			if( prop.getProperty("db_osm2pgsql_password") != null)
				this.db_osm2pgsql_password = prop.getProperty("db_osm2pgsql_password");
			if( prop.getProperty("db_osm2pgsqlwrite_username") != null)
				this.db_osm2pgsqlwrite_username = prop.getProperty("db_osm2pgsqlwrite_username");
			if( prop.getProperty("db_osm2pgsqlwrite_password") != null)
				this.db_osm2pgsqlwrite_password = prop.getProperty("db_osm2pgsqlwrite_password");


			if( prop.getProperty("osmosis_laststatefile") != null)
				this.osmosis_laststatefile = prop.getProperty("osmosis_laststatefile");
			if( prop.getProperty("logging_filename") != null)
				this.logging_filename = prop.getProperty("logging_filename");
			if( prop.getProperty("logging_console_level") != null)
				this.logging_console_level = Level.parse(prop.getProperty("logging_console_level"));
			if( prop.getProperty("logging_file_level") != null)
				this.logging_file_level = Level.parse(prop.getProperty("logging_file_level"));

			
			System.out.println(" .servername                              ==="+this.servername+"===");
			System.out.println(" .application_homedir                     ==="+this.application_homedir+"===");
			System.out.println(" .application_datadir                     ==="+this.application_datadir+"===");
			System.out.println(" .db_application_url                      ==="+this.db_application_url+"===");
			System.out.println(" .db_application_username                 ==="+this.db_application_username+"===");
			System.out.println(" .db_application_password                 ==="+this.db_application_password+"===");
			System.out.println(" .db_application_listofstreets_url        ==="+this.db_application_listofstreets_url+"===");
			System.out.println(" .db_application_listofstreets_username   ==="+this.db_application_listofstreets_username+"===");
			System.out.println(" .db_application_listofstreets_password   ==="+this.db_application_listofstreets_password+"===");
			System.out.println(" .db_osm2pgsql_url                        ==="+this.db_osm2pgsql_url+"===");
			System.out.println(" .db_osm2pgsql_username                   ==="+this.db_osm2pgsql_username+"===");
			System.out.println(" .db_osm2pgsql_password                   ==="+this.db_osm2pgsql_password+"===");
			System.out.println(" .db_osm2pgsqlwrite_username              ==="+this.db_osm2pgsqlwrite_username+"===");
			System.out.println(" .db_osm2pgsqlwrite_password              ==="+this.db_osm2pgsqlwrite_password+"===");
			System.out.println(" .osmosis_laststatefile                   ==="+this.osmosis_laststatefile+"===");
			System.out.println(" .logging_filename                        ==="+this.logging_filename +"===");
			System.out.println(" .logging_console_level                   ==="+this.logging_console_level.toString() +"===");
			System.out.println(" .logging_file_level                      ==="+this.logging_file_level.toString() +"===");

		} catch (Exception e) {
			System.out.println("ERROR: failed to read file ==="+configuration_filename+"===");

			String userdir = System.getProperty("user.dir");
			System.out.println("current dir, is it good?   ===" + userdir);
			
			
			e.printStackTrace();
			return;
		}
	}
}
