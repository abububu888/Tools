
public class FileObject {

	private String path;
	private String content;
	
	public FileObject(String path, String content) {
		this.path = path;
		this.content = content;
	}

	public FileObject(String path) {
		this.path = path;	
	}
	
	public String getPath() {
		return path;
	}

	public String getContent() {
		return content;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}	
	
	public String toString(){
		if (this.content==null)	{
			return null;
		}
		
		return this.content.substring(0, 10);
	}
	
}
