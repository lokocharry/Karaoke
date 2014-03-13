package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Process {
	
	private File file;
	private FileReader fr;
	
	public Process(String path){
		file=new File(path);
		try {
			fr=new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileReader getFr() {
		return fr;
	}

	public void setFr(FileReader fr) {
		this.fr = fr;
	}
	
}
