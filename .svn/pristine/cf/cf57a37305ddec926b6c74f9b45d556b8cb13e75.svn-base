package com.aoto.framework.commons.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
public class JsonUtils
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * [简要描述]:javaBean,list,array convert to json string
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param obj Object
     * @return String
     * @throws Exception JsonProcessingException
     */
    public static String obj2json(Object obj) throws Exception
    {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * [简要描述]:json string convert to javaBean
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param jsonStr String
     * @param clazz Class<T>
     * @param <T> T
     * @return T
     * @throws Exception JsonProcessingException
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz) throws Exception
    {
        return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * [简要描述]:json string convert to map
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param jsonStr String
     * @param <T> T
     * @return Map<String, Object>
     * @throws Exception IOException, JsonParseException, JsonMappingException
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> json2map(String jsonStr) throws Exception
    {
        return objectMapper.readValue(jsonStr, Map.class);
    }

    /**
     * [简要描述]:json string convert to map with javaBean
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param jsonStr String
     * @param clazz Class<T>
     * @param <T> T
     * @return Map<String, T>
     * @throws Exception IOException, JsonParseException, JsonMappingException
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) throws Exception
    {
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>()
        {
        });
        Map<String, T> result = new HashMap<String, T>();
        for (Entry<String, Map<String, Object>> entry : map.entrySet())
        {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * [简要描述]:json array string convert to list with javaBean
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param jsonArrayStr String
     * @param clazz Class<T>
     * @param <T> T
     * @return List<T>
     * @throws Exception IOException, JsonParseException, JsonMappingException
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) throws Exception
    {
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>()
        {
        });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list)
        {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * [简要描述]:map convert to javaBean
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<?, ?>
     * @param clazz Class<T>
     * @param <T> T
     * @return T
     */
    public static <T> T map2pojo(Map<?, ?> map, Class<T> clazz)
    {
        return objectMapper.convertValue(map, clazz);
    }

    // @SuppressWarnings("unchecked")
    // public static <T> T json2Object(String json, Class<T> clazz) {
    // JSONObject jsonObject = JSONObject.fromObject(json);
    // String[] dateFormats = new String[] { "yyyy-MM-dd HH:mm:ss" };
    // JSONUtils.getMorpherRegistry().registerMorpher(new
    // TimestampMorpher(dateFormats));
    // return (T) JSONObject.toBean(jsonObject, clazz);
    // }
}
