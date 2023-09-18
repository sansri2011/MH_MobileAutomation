package org.magellanhealth.utils;

import org.magellanhealth.Constant.FrameworkConstant;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {


    private static final Properties pr = new Properties();
    private static Map<String, String> MAP = new HashMap<>();

    static {
        try (FileInputStream fileImageInputStream = new FileInputStream(FrameworkConstant.getConfigFilePath())) {
            pr.load(fileImageInputStream);
            for (Map.Entry<Object, Object> entry : pr.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                MAP.put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("There is problem with file path");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getValue(String key) {
        return MAP.get(key);
    }

}
