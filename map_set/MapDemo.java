package map_set;

import java.util.Map;
import java.util.TreeMap;

/**
 * @PackageName: map_set
 * @ClassName: MapDemo
 * @Description:
 * Map常见方法使用
 * @author: 呆呆
 * @date: 2019/10/12
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        //get()，返回key对应的value。
        System.out.println(map.get("Tom"));   //null
        //getOrDefault()，返回key对应的value，key若不存在返回指定的默认值
        System.out.println(map.getOrDefault("Tom","查无此人"));
        //put()，设置key对应的value，第一次插入返回null，更新返回原来的值
        String oldValue = map.put("Tom","123456");
        System.out.println(oldValue);
        oldValue = map.put("Tom","111111");
        System.out.println(oldValue);
        //多放几个数据
        map.put("Jack","222222");
        map.put("Rose","333333");

        //keySet(),返回所有 key 的不重复集合
        System.out.println(map.keySet());
        for (String key : map.keySet()){
            System.out.print(key+" ");
        }
        System.out.println();
        //values(),返回所有 value 的可重复集合
        System.out.println(map.values());
        for (String value : map.values()){
            System.out.print(value+" ");
        }
        System.out.println();
        //entrySet(),返回所有的 key-value 映射关系
        System.out.println(map.entrySet());
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.print(entry.getKey()+" ");
            System.out.println(entry.getValue() + " ");
        }
        //containsKey(),判断是否包含 key
        System.out.println(map.containsKey("Jerry"));
        System.out.println(map.containsKey("Tom"));
        //containsValue(),判断是否包含 value
        System.out.println(map.containsValue("222222"));
    }
}
