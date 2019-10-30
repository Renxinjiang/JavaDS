package map_set.contact;

/**
 * @PackageName: map_set.contact
 * @ClassName: MameNotFoundException
 * @Description:
 * @author: 呆呆
 * @date: 2019/10/30
 */
public class NameNotFoundException extends Exception {
    public NameNotFoundException() {
    }

    public NameNotFoundException(String message) {
        super(message);
    }

    public NameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameNotFoundException(Throwable cause) {
        super(cause);
    }

    public NameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
