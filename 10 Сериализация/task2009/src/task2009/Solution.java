//Complete

package task2009;

import java.io.*;

/* 
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.


Requirements:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.*/

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        @Override
        public String toString() {
            return "ClassWithStatic{" +
                    "i=" + i +
                    ", j=" + j +
                    ", staticString=" + staticString +
                    '}';
        }
    }

    public static void main(String[] args) {
        String fileName = "file2009.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            ClassWithStatic classWithStaticOut = new ClassWithStatic();
            classWithStaticOut.i = 11;
            classWithStaticOut.j = 22;

            System.out.println(classWithStaticOut);
            objectOutputStream.writeObject(classWithStaticOut);

            ClassWithStatic classWithStaticIn = (ClassWithStatic) objectInputStream.readObject();
            System.out.println(classWithStaticIn);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
