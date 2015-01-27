/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Morgan Coiffier
 */
public class FileManager {

    public static ArrayList<byte[]> convertFileToArray(String path, int length) throws IOException {
        FileInputStream fis = null;
        ArrayList<byte[]> result = new ArrayList<>();

        byte[] bs = new byte[length];
        try {

            fis = new FileInputStream(path);
            int i = 0;
            while (fis.read(bs) != -1) {
                result.add(i, bs);
                i++;
                bs = new byte[length];
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return result;
    }

    public static void writeToFile(byte[] contentInBytes, String pathFile) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathFile, true);
            String str = new String(contentInBytes,"UTF-8");
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
