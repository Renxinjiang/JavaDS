package genericity;

/**
 * @PackageName: genericity
 * @ClassName: Example
 * @Description:
 * 泛型的示例
 * @author: 呆呆
 * @date: 2019/10/16
 */
public class Example {
    private static class Person<T>{
        // 为了类型可变，定义成泛型，以下凡是用到类的地方都可以用T替换
        //String name;
        T name;

        /*
        并不是任何场景都可以使用
        定义为
        static T name；则不可以使用
        所有静态的都不可以使用（属性、方法，类）
         */
    }

    public static void main(String[] args) {
        //使用传入什么就是什么类型
        Person<String> p1 = new Person<>();
        Person<Integer> p2 = new Person<>();
    }

}
