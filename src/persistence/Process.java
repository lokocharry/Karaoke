package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Process {
	
	private File file;
	private FileReader fr;
	private BufferedReader br;
	
	public Process(String path){
		file=new File(path);
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String readLine(){
		String line="";
		try {
			if((line=br.readLine())!=null)
				return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
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
