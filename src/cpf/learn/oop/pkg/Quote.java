package cpf.learn.oop.pkg;

import cpf.learn.oop.pkg.jack.Dog;

/**
 * 本类为了测试，在不同文件夹下的同名类，在外部引用下的表现.
 * import其中一个类，其他同名类需要在实例化对象的时候，在类名前加上包前缀.
 * 包前缀的起始是jvm可定位的文件夹的下一级文件
 */
public class Quote {
    public static void main(String[] args) {

        Dog hisDog = new Dog();
        hisDog.cry();

        cpf.learn.oop.pkg.mary.Dog herDog = new cpf.learn.oop.pkg.mary.Dog();
        herDog.cry();

    }
}
