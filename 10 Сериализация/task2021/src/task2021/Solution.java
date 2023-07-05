package task2021;

import java.io.*;

/* 
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Requirements:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream oos) throws Exception {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream ois) throws Exception {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {
        String fileName = "file2021.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Solution solution = new SubSolution();
            oos.writeObject(solution);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
