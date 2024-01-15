package org.magellanhealth.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    public DataProviderUtils() {
    }


    @DataProvider(parallel = true)
    public Object[] getData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<Map<String, Object>> list;
        try {
            list = mapper.readValue(new File(System.getProperty("user.dir")
                    + "/src/test/resources/jsontestdata/" + PropertyUtils.getValue("deviceIteration") + ""), new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception exception) {
            throw new RuntimeException("** Please check config property file, Data provider location not provided *****");
        }

        return list.toArray();
    }

}
