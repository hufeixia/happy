package com.p2p.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonUtils {
    public enum GsonSerializerFeature {
        /**
         * 过滤空字符串
         */
        WriteMapNullValue
    }
    //线程安全的
    private static final Gson GSON;
    private static final Gson GSON_NULL; // 不过滤空值
    static {
        GSON = new GsonBuilder().enableComplexMapKeySerialization() //当Map的key为复杂对象时,需要开启该方法
//                .serializeNulls() //当字段值为空或null时，依然对该字段进行转换
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//                .setPrettyPrinting() //自动格式化换行
                .disableHtmlEscaping() //防止特殊字符出现乱码
                .create();
        GSON_NULL = new GsonBuilder().enableComplexMapKeySerialization() //当Map的key为复杂对象时,需要开启该方法
                .serializeNulls() //当字段值为空或null时，依然对该字段进行转换
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//                .setPrettyPrinting() //自动格式化换行
                .disableHtmlEscaping() //防止特殊字符出现乱码
                .create();
    }

    //获取gson解析器
    public static Gson getGson() {
        return GSON;
    }

    //获取gson解析器 有空值 解析
    public static Gson getWriteNullGson() {
        return GSON_NULL;
    }


    /**
     * 根据对象返回json  过滤空值字段
     */
    public static String toJsonString(Object object) {
        return GSON.toJson(object);
    }

    /**
     * 根据对象返回json  不过滤空值字段
     */
    public static String toJsonString(Object object, GsonSerializerFeature ser) {
        if (ser == GsonSerializerFeature.WriteMapNullValue){
            return GSON_NULL.toJson(object);
        }
        return GSON.toJson(object);
    }


    /**
     * 将字符串转化对象
     *
     * @param json     源字符串
     * @param classOfT 目标对象类型
     * @param <T>
     * @return
     */
    public static <T> T strToJavaBean(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     * 将json转化为对应的实体对象
     * new TypeToken<List<T>>() {}.getType()
     * new TypeToken<Map<String, T>>() {}.getType()
     * new TypeToken<List<Map<String, T>>>() {}.getType()
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

    /**
     * 转成list
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> strToList(String gsonString, Class<T> cls) {
        return GSON.fromJson(gsonString, new TypeToken<List<T>>() {
        }.getType());
    }

    /**
     * 转成list中有map的
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> strToListMaps(String gsonString) {
        return GSON.fromJson(gsonString, new TypeToken<List<Map<String, String>>>() {
        }.getType());
    }

    /**
     * 转成map
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> strToMaps(String gsonString) {
        return GSON.fromJson(gsonString, new TypeToken<Map<String, T>>() {
        }.getType());
    }


//    public static void main(String[] args) {
//        Result result = new Result("A000", "success");
////        toString
//        String s = toJsonString(result);
//        String s1 = toJsonString(result,GsonSerializerFeature.WriteMapNullValue);
//        System.out.println(s);
//        System.out.println(s1);
////        strTobean
//        String beanStr = "{\"code\":\"A000\",\"message\":\"success\"}";
//        Result result1 = strToJavaBean(beanStr, Result.class);
//        System.out.println(result.getMessage());
////        strToMaps
//        Map<String, String> map = new HashMap<>();
//        map.put("mac", "12312312");
//        map.put("userId", "3sdqxasx");
//        map.put("productId", "201");
//        map.put("trasnId", "12312w12w12w12");
//        Map<String, Object> map1 = strToMaps(map.toString());
//        System.out.println("map to str:" + map.toString());
//        String mac = map.get("mac");
//        System.out.println("get map mac:" + mac);
//
////     strToListMaps
///*        Map<String, String> map = new HashMap<>();
//        List<Map<String, String>> maps = new ArrayList<>();
//        map.put("mac", "12312312");
//        map.put("userId", "3sdqxasx");
//        map.put("productId", "201");
//        map.put("trasnId", "12312w12w12w12");
//        maps.add(map);
//        maps.add(map);
//        String s2 = maps.toString();
//        System.out.println("list to string:" + s2);
//        List<Map<String, Object>> maps1 = strToListMaps(s2);
//        System.out.println("list to string:" + maps1.toString());
//        System.out.println("map get field:" + maps1.get(0).get("mac"));*/
////      strToList
//        List<Result> lists =  new ArrayList<>();
//        lists.add(result);
//        lists.add(result);
//        lists.add(result);
//        String s2 = toJsonString(lists);
//        System.out.println("list to string :" + s2);
//        List<Result> list = strToList(s2, Result.class);
//        System.out.println("list to string :" + toJsonString(list));
//    }

}
