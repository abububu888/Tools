import java.io.FileNotFoundException;
import java.io.IOException;

public interface Singleton {

	public void load() throws FileNotFoundException, IOException;
	
	public String get(String key);
	
	public boolean update(String key, String value);
	
}
