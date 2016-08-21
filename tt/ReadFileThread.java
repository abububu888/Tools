import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ReadFileThread extends Thread {

	private File file;
	private BlockingQueue bq;
	private FileObject fo;
	private boolean isFinished = false;
	
	public ReadFileThread(File file, BlockingQueue bq) {
		this.file = file;
		this.bq = bq;
		this.fo = new FileObject(this.file.getPath()); 
	}

	public void run() {
		
		BufferedReader br = null;
		try {	
			this.bq.put(this);	
			br = new BufferedReader(new FileReader(this.file.getAbsolutePath()));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			
//			this.sleep(50);
			
			this.fo.setContent(everything);
			this.isFinished = true;
			this.bq.remove(this);
		} 
		catch (IOException | InterruptedException e) {			
			e.printStackTrace();
		} 
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public FileObject getFileObject() throws InterruptedException{
//		while (!isFinished){
//			this.sleep(50);
//		}
		return this.fo;
	}

}
