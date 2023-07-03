//Complete

package task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage, а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.


Requirements:
1. Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
2. Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();
    public static Properties properties = new Properties();

    public static void save(OutputStream outputStream) throws Exception {
        runtimeStorage.put("number", "12394");
        properties.clear();
        properties.putAll(runtimeStorage);
        properties.store(outputStream, "new properties");
    }

    public static void load(InputStream inputStream) throws IOException {
        properties.clear();
        properties.load(inputStream);
        for (Map.Entry<Object, Object> pair : properties.entrySet()) {
            runtimeStorage.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine());
             FileOutputStream fos = new FileOutputStream(reader.readLine());) {
            load(fis);
            save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
