package com.zhouchao.tool.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/7/29 22:32
 * @Description
 **/

@Slf4j
public class JacksonUtil {
    private static JacksonUtil _instance = new JacksonUtil();
    public static ObjectMapper objectMapper = null;

    static {
        log.info("JacksonUtil init");
        try {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        } catch (Exception e) {
            log.error("JacksonUtil init error,cause:", e);
        }
    }

    synchronized public static JacksonUtil getInstance() {
        return _instance;
    }

    /**
     * json对象转换为Map. <br/>
     * toMap:(jsonMap,Map的Key泛型，Map的Value泛型). <br/>
     *
     * @param jsonMap
     * @param keyClass
     * @param valueClass
     * @param <T>
     * @return
     * @throws Exception
     * @author zhouchao
     * @since JDK 1.8
     */
    public static <T> T toMap(String jsonMap, Class<?> keyClass, Class<?> valueClass) throws Exception {
        MapType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
        try {
            return (T) objectMapper.readValue(jsonMap, mapType);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("json {} to Map error {}", jsonMap, e.getMessage());
            throw new Exception("参数异常", e);
        }
    }

    /**
     * 对象转换为JSON串. <br/>
     * toJson:(obj). <br/>
     *
     * @param obj
     * @return
     * @author zhouchao
     * @since JDK 1.8
     */
    public static String toJson(Object obj) throws Exception {
        String rs = null;
        try {
            rs = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("obj to json error {}", e.getMessage());
            throw new Exception("参数错误", e);
        }
        return rs;
    }

    /**
     * 根据json串转换java对象. <br/>
     * toObj:(json,Obj). <br/>
     *
     * @param jsonString
     * @param prototype
     * @return
     * @author zhouchao
     * @since JDK 1.8
     */
    public static <T> T toObj(String jsonString, Class<T> prototype) throws Exception {
        try {
            return (T) objectMapper.readValue(jsonString, prototype);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("json to obj error {}", e.getMessage());
            throw new Exception("参数错误", e);
        }
    }

    /**
     * json数组转换为java对象列表. <br/>
     * toList:(jsonArray,对象类型). <br/>
     *
     * @param jsonArray
     * @param javaType
     * @return
     * @author WangLZ
     * @since JDK 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T> T toList(String jsonArray, JavaType javaType) throws Exception {
        try {
            return (T) objectMapper.readValue(jsonArray, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("json {} to List error {}", jsonArray, e.getMessage());
            throw new Exception("参数错误", e);
        }
    }
}
