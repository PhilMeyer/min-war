package org.pnm.organize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Organizer {

	public static void main(String[] args) throws Exception {
		String directory = getDirectory();
		System.out.println(directory);
		File dir = new File(directory);
		System.out.println(dir.exists());
		organize(dir);
	}

	private static void organize(File dir) {
		File all = new File(dir, "z_all");
		if(!all.exists()){
			all.mkdir();
		}
		for (File temp : dir.listFiles()) {
			if (temp.isDirectory() && !temp.getName().equals("z_all")) {
				int index = 0;
				for (File file : temp.listFiles()) {
					if (!file.isDirectory()) {
						index++;
						System.out.println(temp.getName() + "/" + file.getName());
						String extension = getExtension(file.getName());
						String newName = temp.getName() + "-" + index + extension;
						System.out.println(newName);
						copyFile(file, new File(all, newName));
						//file.renameTo(new File(temp, newName));
					}
				}
				temp.delete();
			}
		}
	}

	private static void copyFile(File file, File dest) {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			inStream = new FileInputStream(file);
			outStream = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}

	private static String getDirectory() throws IOException {
		File file = new File("input");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		return br.readLine();
	}

}
