package cpf.learn.oop.pkg;

import cpf.learn.oop.pkg.jack.Dog;

/**
 * ����Ϊ�˲��ԣ��ڲ�ͬ�ļ����µ�ͬ���࣬���ⲿ�����µı���.
 * import����һ���࣬����ͬ������Ҫ��ʵ���������ʱ��������ǰ���ϰ�ǰ׺.
 * ��ǰ׺����ʼ��jvm�ɶ�λ���ļ��е���һ���ļ�
 */
public class Quote {
    public static void main(String[] args) {

        Dog hisDog = new Dog();
        hisDog.cry();

        cpf.learn.oop.pkg.mary.Dog herDog = new cpf.learn.oop.pkg.mary.Dog();
        herDog.cry();

    }
}
