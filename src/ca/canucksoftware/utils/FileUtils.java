
package ca.canucksoftware.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdesktop.application.Application;

/**
 *
 * @author Jason
 */
public class FileUtils {
    public static File appDirectory() {
        File app, dir;
        try {
            app = new File(Application.getInstance()
                    .getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            dir = app.getParentFile();
        } catch(Exception e) {
            app = new File(Application.getInstance().getClass().getProtectionDomain()
                    .getCodeSource().getLocation()
                    .getPath().replaceAll("%20", " "));
            dir = app.getParentFile();
        }
        return dir;
    }

    public static void copy(File from, File to) throws IOException {
        FileInputStream fis  = new FileInputStream(from);
        FileOutputStream fos = new FileOutputStream(to);
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (fis != null)
                fis.close();
            if (fos != null)
                fos.close();
        }
    }

    public static String getFilename(File file) {
        return getFilename(file.getName());
    }

    public static String getFilename(String file) {
        String name = file;
        int index = name.lastIndexOf("\\");
        if(index>-1) {
            name = name.substring(index+1, name.length());
        } else {
            index = name.lastIndexOf("/");
            if(index>-1)
                name = name.substring(index+1, name.length());
        }
        return name;
    }
}
