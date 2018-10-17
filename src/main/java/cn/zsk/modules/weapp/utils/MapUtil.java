package cn.zsk.modules.weapp.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {
    /**
     * getOrderedMap 获取带排序的Map
     */
    public static Map<String, String> getOrderMap() {
        Map<String, String> paramMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
        return paramMap;
    }

    /**
     * getOrderedMap 获取带排序的Map
     */
    public static Map<String, Object> getOrderObjMap() {
        Map<String, Object> paramMap = new TreeMap<String, Object>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
        return paramMap;
    }
}
