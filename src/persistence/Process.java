package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Process {
	
	private int id;
	private File file;
	private FileReader fr;
	private BufferedReader br;
	
	public Process(int id, String path){
		this.id=id;
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
	
	public Object[] toVector(){
		Object [] aux=new Object [2];
		aux[0]=id;
		aux[1]=file.toString();
		return aux;
	}
	
	@Override
	public String toString() {
		return String.format("[ID: %s, Archivo: %s]", id, file.toString());
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
