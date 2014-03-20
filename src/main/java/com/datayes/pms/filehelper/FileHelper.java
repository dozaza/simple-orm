package com.datayes.pms.filehelper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-14
 * Time: 下午3:57
 */
public class FileHelper {

    /**
     *
     * Public methods
     *
     */

    /**
     *
     * Get path separator of whatever operating system
     *
     */
    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     *
     * Get project current path
     *
     */
    public static String getCurrentPath() {
        File file = new File("");
        return file.getAbsolutePath();
    }

}
