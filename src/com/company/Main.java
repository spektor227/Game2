package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        GameProgress save1 = new GameProgress(100, 1, 1, 50);
        try {
            FileOutputStream save11 = new FileOutputStream("E://Games//savegames//save1.dat");
            ObjectOutputStream save111 = new ObjectOutputStream(save11);
            save111.writeObject(save1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameProgress save2 = new GameProgress(78, 3, 7, 1200.20);
        try {
            FileOutputStream save22 = new FileOutputStream("E://Games//savegames//save2.dat");
            ObjectOutputStream save222 = new ObjectOutputStream(save22);
            save222.writeObject(save2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameProgress save3 = new GameProgress(42, 6, 20, 10500.10);
        try {
            FileOutputStream save33 = new FileOutputStream("E://Games//savegames//save3.dat");
            ObjectOutputStream save333 = new ObjectOutputStream(save33);
            save333.writeObject(save3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ZipOutputStream archive = new ZipOutputStream(
                new FileOutputStream("E://Games//savegames//zip.zip"));
             FileInputStream fis = new FileInputStream("E://Games//savegames//save1.dat");
             FileInputStream fis1 = new FileInputStream("E://Games//savegames//save2.dat");
             FileInputStream fis2 = new FileInputStream("E://Games//savegames//save3.dat")) {
            ZipEntry entry = new ZipEntry("packed_save1.dat");
            archive.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            archive.write(buffer);
            archive.closeEntry();
            ZipEntry entry1 = new ZipEntry("packed_save2.dat");
            archive.putNextEntry(entry1);
            byte[] buffer1 = new byte[fis1.available()];
            fis1.read(buffer);
            archive.write(buffer1);
            archive.closeEntry();
            ZipEntry entry2 = new ZipEntry("packed_save3.dat");
            archive.putNextEntry(entry2);
            byte[] buffer2 = new byte[fis2.available()];
            fis.read(buffer);
            archive.write(buffer2);
            archive.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
