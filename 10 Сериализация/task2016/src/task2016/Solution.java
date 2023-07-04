//Complete

package task2016;

import java.io.*;

/* 
Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.


Requirements:
1. В классе Solution должен существовать класс A.
2. В классе Solution должен существовать класс B.
3. В классе Solution должен существовать класс C.
4. Класс B должен быть потомком класса A.
5. Класс C должен быть потомком класса B.
6. Класс A должен поддерживать интерфейс Serializable.
7. Класс B не должен явно поддерживать интерфейс Serializable.
8. Класс C не должен явно поддерживать интерфейс Serializable.*/

public class Solution {
    public class A implements Externalizable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
