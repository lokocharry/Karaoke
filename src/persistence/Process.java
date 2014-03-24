package persistence;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

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
	
	public int getLineCount(){
		InputStream is = null;
		int count = 0;
        boolean empty = true;
		try {
			is = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    try {
	        byte[] c = new byte[1024];
	        int readChars = 0;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	    } catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    return (count == 0 && !empty) ? 1 : count;
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
