package myOptions;

import java.io.File;

public class SearchFiles {

    public String getFilesPaths(String data) {
        String filePath = "";
        File folder = new File(data);
        if (folder.isFile() && folder.getName().endsWith(".csv") || folder.getName().endsWith(".json")) {
            filePath += folder.getAbsolutePath() + "\n";
        }
        if (folder.isDirectory()) {
            try {
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        filePath += getFilesPaths(file.getAbsolutePath());
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return filePath;
    }
}
