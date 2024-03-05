package framework.supporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SupportProperty {
    public Properties load(String fileName) {
        Properties pros = new java.util.Properties();
        {
            try {
                InputStream input = new FileInputStream("src/test/java/framework/supporter/resources/" + fileName + ".properties");
                pros.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return pros;
    }

}
