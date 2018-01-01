package com.test.frankyuan.word20000_android;


/**
 * Created by Yuan on 17.12.31.
 */

public class FileItem
{
    public int getFileId()
    {
        return fileId;
    }

    private int fileId;

    public String getFileName()
    {
        return fileName;
    }

    private String fileName;

    public FileItem(int id, String name)
    {
        this.fileId = id;
        this.fileName = name;
    }
}

