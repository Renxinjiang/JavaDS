package map_set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @PackageName: map_set
 * @ClassName: SetDemo
 * @Description:
 * Set常用方法使用
 * @author: 呆呆
 * @date: 2019/10/12
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> bucket = new TreeSet<>();
        //add()，添加元素，但重复元素不会被添加成功
        bucket.add("苹果");
        bucket.add("香蕉");
        bucket.add("橘子");
        bucket.add("石榴");
        bucket.add("樱桃");
        System.out.println(bucket);
        System.out.println(bucket.size());
        bucket.add("苹果");
        System.out.println(bucket);
        System.out.println(bucket.size());
        //remove(),删除集合中的 o
        bucket.remove("苹果");
        System.out.println(bucket);
        System.out.println(bucket.size());
        bucket.remove("火龙果");
        System.out.println(bucket);
        System.out.println(bucket.size());
        //contains(),判断 o 是否在集合中
        System.out.println(bucket.contains("香蕉"));
        //clear(),清空集合
        bucket.clear();
        System.out.println(bucket);
        System.out.println(bucket.size());
    }
}
