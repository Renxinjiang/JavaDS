package map_set.contact;

/**
 * @PackageName: map_set.contact
 * @ClassName: User
 * @Description:
 * 用户信息User
 *     需要的属性：姓名，手机，办公室电话
 * @author: 呆呆
 * @date: 2019/10/25
 */
public class User {
    String name;
    String mobilePhone;
    String officePhone;

    public User(String name, String mobilePhone, String officePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
    }
}
