package map_set.contact;

import javax.naming.NameNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @PackageName: map_set
 * @ClassName: Contact
 * @Description:
 * 通讯录
 *     联系人中有很多用户信息，需要一个容器Map将它们装起来
 *     Key（String类型）是姓名，Value（User类型）是用户信息
 *     联系人一般有序，因此用TreeMap实现
 * @author: 呆呆
 * @date: 2019/10/25
 */
public class Contact {
    Map<String,User> map = new TreeMap<>();

    //添加联系人
    public void add(String name,String mobilePhone,String officePhone) throws NameExistException{
        User user = new User(name, mobilePhone, officePhone);
        if (map.containsKey(name)){
            throw new NameExistException();
        }
        map.put(name,user);
    }
    //查找联系人
    public void search(String name,Contact contact){
        if (map.containsKey(name)){
            System.out.println("姓名：：" + map.get(name).name);
            System.out.println("手机号：" + map.get(name).mobilePhone);
            System.out.println("办公室电话：" + map.get(name).officePhone);
        }else {
            System.out.println("您输入的联系人不存在");
        }
    }

    //删除联系人
    public void remove(String name) throws NameNotFoundException {
        if (!map.containsKey(name)){
            throw new NameNotFoundException();
        }
        map.remove(name);
    }

    public User get(String name) {
        return map.get(name);
    }


}
