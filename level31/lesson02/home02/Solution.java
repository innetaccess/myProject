package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        File rootDir = new File(root);
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, rootDir.listFiles());
        while (!fileTree.isEmpty()){
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory())
                Collections.addAll(fileTree, currentFile.listFiles());
                else fileList.add(currentFile.getAbsolutePath());

        }
        return fileList;

    }
}
