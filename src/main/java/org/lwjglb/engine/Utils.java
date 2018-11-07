package org.lwjglb.engine;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.InputStream;

public class Utils {

    public static String loadResource(String fileName) throws Exception {
        String result;
        File file = new File(fileName);
        System.out.println(file.exists());
        /*try (
                InputStream in = Class.forName(Utils.class.getName()).getResourceAsStream(fileName);
                Scanner scanner = new Scanner(in, "UTF-8")
        ) {
            result = scanner.useDelimiter("\\A").next();
        }
        return result;*/


        byte[] encoded = Files.readAllBytes(Paths.get(fileName));
        return new String(encoded, "UTF-8");


    }

}
