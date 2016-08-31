package com.carpediem.homer.imagemaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okio.Okio;

/**
 *  FileSystem,Steam,backup,journal,and lock
 * Created by homer on 16-8-31.
 */
public class DiskLruCache {
    static final String JOURNAL_FILE = "journal";
    static final String MAGIC = "homer.imagemaster.DiskLruCache";
    static final String VERSION_1 = "1";

    private static final String CLEAN = "clean";
    private static final String DIRTY = "dirty";
    private static final String REMOVE = "remove";
    private static final String READ = "read";

    /**
     *
     *magic
     *version
     * app_version
     *
     * REMOVE
     */

    private File directory;
    private File journal;
    private int appVersion;
    private int valueCount;
    private long maxSize;

    private DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        this.journal = new File(directory,JOURNAL_FILE);
        this.appVersion = appVersion;
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        //这里的话，可能本来就存在journal了
        initJournal(journal);
    }

    private void checkJournal(File journal) {
        if (!journal.exists()) {
            initJournal(journal);
        }

    }
    private void initJournal(File journal) {
        assert journal.exists();
        try {
            FileOutputStream os = new FileOutputStream(journal);
            byte[] bytes = (JOURNAL_FILE + "\n").getBytes();
            os.write(bytes);
            bytes = (VERSION_1 + "\n").getBytes();
            os.write(bytes);
            bytes = (appVersion + "\n").getBytes();
            os.write(bytes);
            bytes = (valueCount + "\n").getBytes();
            os.write(bytes);
            bytes = "\n".getBytes();
            os.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 检验file的可用性(是否存在，大小),初始化journal
     * @param directory
     * @param appVersion
     * @param valueCount
     * @param maxSize
     * @return
     */
    public static DiskLruCache open(File directory, int appVersion, int valueCount, long maxSize) {
        if (directory == null) {

        }
        boolean legal = directory.exists() && directory.isDirectory();
        boolean hasPermission = directory.canRead() && directory.canWrite();
        boolean sizeEnough  = directory.getUsableSpace() > maxSize;

        if (! (legal && hasPermission && sizeEnough)) {

        }
        return new DiskLruCache(directory,appVersion,valueCount,maxSize);
    }
    public Editor edit(String key) throws IOException {
        return null;
    }

    public synchronized Snapshot get(String key) throws IOException {
        return null;
    }

    public synchronized boolean remove(String key) throws IOException {
        return false;
    }

    private class Editor {

    }

    private class Snapshot {

    }
}
