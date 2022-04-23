package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyUtil {
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		String path = System.getProperty("user.dir") + "/src/test/resources/training.properties";
		Properties properties = new Properties();
//		File file = new File(path);
//		FileInputStream stream = new FileInputStream(file);
		properties.load(new FileInputStream(new File(path)));
		
		System.out.println(properties.get("url"));
		
		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Object, Object> next = iterator.next();
			System.out.println(next.getKey() + " "  + next.getValue());
		}
	}
}
