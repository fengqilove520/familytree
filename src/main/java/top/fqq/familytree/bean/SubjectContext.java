package top.fqq.familytree.bean;

/**
 * @author fitch
 * @date 2021/10/18 14:50
 */
public class SubjectContext {

    /**
     * 用户信息
     */
    private static ThreadLocal<Subject> userThread = new ThreadLocal<>();

    /**
     * 当前线程上下文中设置用户信息
     *
     * @param user 用户信息
     */
    public static void set(Subject user) {
        userThread.set(user);
    }

    /**
     * 在当前线程上下文中获取用户信息
     *
     * @return 用户信息
     */
    public static Subject get() {
        return userThread.get();
    }

    /**
     * 删除用户信息
     */
    public static void remove() {
        userThread.remove();
    }
}
