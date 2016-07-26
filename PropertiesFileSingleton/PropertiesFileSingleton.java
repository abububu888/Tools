import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileSingleton implements Singleton {

	private static final String FILE_PATH = "props.properties";
	
	private static PropertiesFileSingleton instance = null;
	private Map<String , String> valuesMap = new HashMap<>();
	private Properties prop = new Properties();


	protected PropertiesFileSingleton() throws IOException {}

	public static PropertiesFileSingleton getInstance() throws Exception {

		if (!new File(FILE_PATH).exists()){
			throw new Exception("Cannot find file at path: " + FILE_PATH);
		}

		if (instance == null) {
			synchronized (PropertiesFileSingleton.class) {
				if (instance == null) {
					instance = new PropertiesFileSingleton();
					instance.load();
				}
			}
		}
		return instance;
	}

	@Override
	public void load() throws FileNotFoundException, IOException {
		
		InputStream input = new FileInputStream(FILE_PATH);

		// load a properties file
		prop.load(input);
		
		prop.entrySet().stream().forEach(item -> 
			valuesMap.put(item.getKey().toString(), item.getValue().toString())
		);
		
		System.out.println("Loading file " + FILE_PATH + " properties...");
		prop.entrySet().stream().forEach(item -> 
			System.out.println(item.getKey().toString() + " = " + item.getValue().toString())
		);
	}


	@Override
	public String get(String key) {
		return valuesMap.get(key);
	}


	@Override
	public boolean update(String key, String value) {
		prop.setProperty(key, value);
		valuesMap.put(key, value);
		
		return true;
	}


}