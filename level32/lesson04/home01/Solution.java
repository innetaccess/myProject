package com.javarush.test.level32.lesson04.home01;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:/setup2.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (is != null)
        {
            try (InputStreamReader inputStreamReader = new InputStreamReader(is))
            {
                char[] buff = new char[1024];
                int len;
                while (inputStreamReader.ready())
                {
                    len = inputStreamReader.read(buff);
                    stringWriter.write(buff, 0, len);
                }
            }
        }
        return stringWriter;
    }
}
