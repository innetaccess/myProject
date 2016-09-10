package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]))
        {
            byte[] buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            String s = new String(buff, "UTF-8");
            outputStream.write(s.getBytes("WINDOWS-1251"));
        }

    }
}
