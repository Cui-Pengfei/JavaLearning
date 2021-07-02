package cpf.learn.chapter10.interface_;

/**
 * 接口的亿点点细节：
 *      1. 接口不能被实例化（类比抽象类也不能实例化）
 *      2. 接口中允许三种方法：抽象方法、静态方法、default方法
 *      3. 抽象方法默认是public abstract的，因此不必再写这些关键字
 *      4. 接口的default方法仍然是public的，跨包实现接口的类仍然能继承并访问到default方法，
 *          这是因为default在接口中表示的不是访问权限，接口中的所有方法默认都是public,
 *          这个default表示接口的这个方法不是抽象的，不必被实现。
 *      5. 接口的static方法，非常特殊，他不会被实现接口的类所继承，
 *      x. 一个普通类实现接口，就必须将该接口的所有抽象方法实现(alt+enter快速修补)
 *          并且实现的方法必须由public修饰
 *      x. 抽象类实现接口，可以不实现接口中的抽象方法（抽象类也允许抽象方法存在）
 */
public class InterfaceDetail01{
}
