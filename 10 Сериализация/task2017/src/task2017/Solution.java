//Complete

package task2017;

import java.io.*;

/* 
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.


Requirements:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
6. Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.*/

public class Solution implements Serializable {
    public static String fileName = "file2017.txt";

    public A getOriginalObject(ObjectInputStream objectStream) {
        A a;
        try {
            objectStream = new ObjectInputStream(new FileInputStream(fileName));
            a = (A) objectStream.readObject();
            return a;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Возникло исключение");
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Solution solutionOut = new Solution();
            A a = solutionOut.new B();
            System.out.println(a);
            outputStream.writeObject(a);
            Solution solutionIn = new Solution();
            B b = (B) solutionIn.getOriginalObject(objectInputStream);
            System.out.println(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
