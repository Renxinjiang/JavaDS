package map_set.contact;

import javax.naming.NameNotFoundException;
import java.util.Scanner;

/**
 * @PackageName: map_set.contact
 * @ClassName: Main
 * @Description:
 * 入口Main
 *     打印操作界面
 *     用户输入选择
 *     根据用户选择执行不同动作
 * @author: 呆呆
 * @date: 2019/10/25
 */
public class Main {
    public static void main(String[] args) throws NameNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        while (true) {
            // 1. 打印操作界面
            menu();
            // 2. 用户输入选择
            int selected = scanner.nextInt();
            scanner.nextLine();
            // 3. 根据用户的选择，执行不同的动作
            switch (selected) {
                case 1:
                    add(contact, scanner);
                    break;
                case 2:
                    search(scanner,contact);
                    break;
                case 3:
                    remove(scanner,contact);
                    break;
                case 4:
                    update(scanner,contact);
                    break;
                default:
                    System.out.println("指令错误");
            }
        }
    }

    private static void update(Scanner scanner, Contact contact) {
        System.out.println("请输入要更新的姓名: ");
        String name = scanner.nextLine();
        User user = contact.get(name);
        if (user == null) {
            System.out.println("查无此人");
        }
        System.out.println("请选择要更新的字段: ");
        System.out.println("1. 姓名");
        System.out.println("2. 手机号");
        System.out.println("3. 办公室电话");
        int selected = scanner.nextInt();
        scanner.nextLine();
        switch (selected) {
            case 1: {
                System.out.println("请输入新的姓名:");
                String newName = scanner.nextLine();
                if (user == null) {
                    System.out.println("查无此人");
                } else {
                    try {
                        contact.add(newName, user.mobilePhone, user.officePhone);
                        try {
                            contact.remove(name);
                        } catch (NameNotFoundException e) {
                        }
                    } catch (NameExistException e) {
                        System.out.println("新姓名已经存在");
                    }
                }
                break;
            }
            case 2: {
                System.out.println("请输入新的手机号");
                String mobilePhone = scanner.nextLine();
                contact.get(name).mobilePhone = mobilePhone;
                System.out.println("更新成功");
                break;
            }
            case 3: {
                System.out.println("请输入新的办公室电话");
                String officePhone = scanner.nextLine();
                contact.get(name).officePhone = officePhone;
                System.out.println("更新成功");
                break;
            }
        }
    }


    private static void remove(Scanner scanner,Contact contact) throws NameNotFoundException {
        System.out.println("请输入您要删除的姓名:");
        String name = scanner.nextLine();
        contact.remove(name);
        System.out.println("删除成功");
        System.out.println("**********************");
    }

    private static void search(Scanner scanner,Contact contact) {
        System.out.println("请输入您要查找的姓名:");
        String name = scanner.nextLine();
        contact.search(name,contact);
        System.out.println("**********************");
    }

    private static void add(Contact contact, Scanner scanner) {
        System.out.println("请输入姓名:");
        String name = scanner.nextLine();
        System.out.println("请输入手机:");
        String mobilePhone = scanner.nextLine();
        System.out.println("请输入办公室电话:");
        String officePhone = scanner.nextLine();

        try {
            contact.add(name, mobilePhone, officePhone);
            System.out.println("添加成功");
        } catch (NameExistException e) {
            System.out.println("添加失败，用户已经存在");
        } finally {
            System.out.println("**********************");
        }
    }

    private static void menu() {
        System.out.println("|      呆呆の通讯录      |");
        System.out.println("|       1. 添加          |");
        System.out.println("|       2. 查找          |");
        System.out.println("|       3. 删除          |");
        System.out.println("|       4. 更新          |");
        System.out.println("请选择正确的选项:");
    }
}
