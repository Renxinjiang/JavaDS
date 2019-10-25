package map_set.contact;

import java.util.Map;
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
}
