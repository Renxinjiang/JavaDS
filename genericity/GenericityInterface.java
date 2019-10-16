package genericity;

/**
 * @PackageName: genericity
 * @ClassName: GenericityInterface
 * @Description:
 * 加入继承或实现的示例
 * 继承或实现后面的泛型<>中应该是具体的类型，
 * 与前面的class MyArrayList<E>中的<E>保持一致，或者传一个具体的String/Integer类型。
 * @author: 呆呆
 * @date: 2019/10/16
 */
interface List<E>{
    E get();
    E put();
}
//此处List处需要具体类型，F定义后是一个具体类型。
class MyList<F> implements List<F>{

    @Override
    public F get() {
        return null;
    }

    @Override
    public F put() {
        return null;
    }
}
public class GenericityInterface {
    public static void main(String[] args) {
        MyList<Integer> l;
    }
}
