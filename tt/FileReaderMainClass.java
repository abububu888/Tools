import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileReaderMainClass extends Thread {

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		
		final String PATH = "C:\\Users\\user\\Desktop\\New folder\\";
		File dir = new File(PATH);				
		if (!dir.exists()){
			throw new Exception("Dir " + PATH + " wasn't found !");
		}
		
		System.out.println("Dir is found and has " + dir.listFiles().length + " files.");
		
		BlockingQueue bq = new ArrayBlockingQueue(10);
		
		List<FileObject> objects = new Vector<FileObject>();
		
		
		System.out.println("Start creating the values to list");
		
		for (File file : dir.listFiles()) {
			
			System.out.println("File name: " + file.getAbsolutePath());
			
			Thread t = new ReadFileThread(file, bq);
			t.start();
			objects.add(((ReadFileThread)t).getFileObject());			
		}


		System.out.println("Total time: " + (System.currentTimeMillis() - start));
		
				
	}

}
