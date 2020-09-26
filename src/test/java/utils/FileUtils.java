package utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static byte[] readBytesFromFile(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    public String readStringFromFile(String filePath) {
        return new String(readBytesFromFile(filePath));
    }

    public void saveFile(String content, String filePath)  {
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(URL sourceUrl, String dest){
        File destFile = new File(dest);

        try {
            org.apache.commons.io.FileUtils.copyURLToFile(sourceUrl, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
