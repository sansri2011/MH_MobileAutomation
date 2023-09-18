package org.magellanhealth.Constant;


import lombok.Getter;
import org.magellanhealth.utils.PropertyUtils;

public class FrameworkConstant {

    private FrameworkConstant(){}

    private static String resourcePath = System.getProperty("user.dir") + "/src/test/resources";

    private static @Getter String apkFilePath = resourcePath + "/apkFiles/"+ "app-dev-release-4.apk";
    private static @Getter String configFilePath = resourcePath + "/config/config.properties";

}
