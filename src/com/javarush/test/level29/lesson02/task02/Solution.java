package com.javarush.test.level29.lesson02.task02;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution solution = new Solution();
        String fileNameToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getProcessStartNotepad(fileNameToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Process getProcessStartNotepad(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public Path getAbsolutePathToDefaultTxtFile() {
        String packageName = Solution.class.getPackage().getName().replaceAll("[.]", "\\\\");
        String fileName = "src\\" + packageName + "\\file.txt";
        Path path = Paths.get(fileName);
        return path.toAbsolutePath();
    }
}
