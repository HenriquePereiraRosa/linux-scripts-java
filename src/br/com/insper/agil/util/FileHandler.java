package br.com.insper.agil.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FileUtils;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileHandler {

    FileVisitor recursiveDeleteVisitor = new SimpleFileVisitor<Path>() {

        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attrs) throws IOException {

            System.out.println("Deleting file: " + file);
            Files.delete(file);
            return CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir,
                                                  IOException exc) throws IOException {

            System.out.println("Deleting dir: " + dir);
            if (exc == null) {
                Files.delete(dir);
                return CONTINUE;
            } else {
                throw exc;
            }
        }

    };

    public boolean removeFile(String path) {
        Path root = Paths.get(path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
            for (Path entry : stream) {
                Files.walkFileTree(entry, recursiveDeleteVisitor);
            }
        } catch (IOException e) {
            System.out.println("Erro de IOException");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean removeFile2(String path) {
        String[] cmd = {"/bin/bash", "-c", "echo password| sudo -S ls | sudo rm -rf " + path + "/*"};
        // todo: DEBUG
        System.out.println(cmd[2]);
        Process pb = null;
        try {
            pb = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        String line;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));) {

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
