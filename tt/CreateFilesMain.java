import java.io.File;
import java.io.PrintWriter;

public class CreateFilesMain {

	public static void main(String[] args) throws Exception {

		final String NAME = "file_";
		final String PATH = "C:\\Users\\user\\Desktop\\New folder\\";
		final String EXT = ".txt";
		
		
		File dir = new File(PATH);
		
		
		if (!dir.exists()){
			throw new Exception("Dir " + PATH + " wasn't found !");
		}
		
		for (int i = 0; i < 100; i++) {
			PrintWriter writer = new PrintWriter(PATH + NAME + "_" + i + EXT, "UTF-8");
			writer.print(createFileData());
			writer.close();
		}		
		
	}	
	
	private static String createFileData(){
		StringBuffer sb = new StringBuffer();
		
		for (long i = 0; i < 1_000_0000L; i++) {
			sb.append((char)random());
		}
		
		return sb.toString();
	}
	
	private static int random(){
		return (int)((Math.random() * 255) + 1);
	}

}
