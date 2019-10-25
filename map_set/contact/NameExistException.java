package map_set.contact;

/**
 * @PackageName: map_set.contact
 * @ClassName: NameExistException
 * @Description:
 * 定义一个姓名存在异常
 * @author: 呆呆
 * @date: 2019/10/25
 */
public class NameExistException extends Exception{
    public NameExistException() {
    }

    public NameExistException(String message) {
        super(message);
    }

    public NameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameExistException(Throwable cause) {
        super(cause);
    }

    public NameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
