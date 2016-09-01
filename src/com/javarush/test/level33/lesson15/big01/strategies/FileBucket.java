package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket()  {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException ignored) {
        }
    }

    public long getFileSize() { // он должен возвращать размер файла на который указывает path.
        try {
            return Files.size(path);
        } catch (IOException ignored) {
            return 0L;
        }
    }

    public void putEntry(Entry entry) { // должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(entry);
        } catch (IOException ignored) {
        }

    }

    public Entry getEntry() { // должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
        if (getFileSize() != 0L) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                Entry result = (Entry) ois.readObject();
                return result;
            } catch (IOException | ClassNotFoundException ignored) {
            }
        }
        return null;
    }

    public void remove() { // удалять файл на который указывает path.
        try {
            Files.delete(path);
        } catch (IOException ignored) {
        }
    }
}
