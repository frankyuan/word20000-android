package com.test.frankyuan.word20000_android;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuan on 18.1.1.
 */

public class FileListUtil
{
    private static Resources resources;
    public static void setResources(Resources resources) {
        FileListUtil.resources = resources;
    }

    public FileListUtil()
    {
    }

    public static List<FileItem> loadFileList(Resources resources)
    {
        if (resources == null) {
            return new ArrayList<>();
        }

        List<FileItem> list = new ArrayList<>();
        // TODO: need refractor
        list.add(new FileItem(1, formatFileName(resources.getResourceName(R.raw.word_1))));
        list.add(new FileItem(2, formatFileName(resources.getResourceName(R.raw.word_2))));
        list.add(new FileItem(3, formatFileName(resources.getResourceName(R.raw.word_3))));
        list.add(new FileItem(4, formatFileName(resources.getResourceName(R.raw.word_4))));
        list.add(new FileItem(5, formatFileName(resources.getResourceName(R.raw.word_5))));
        list.add(new FileItem(6, formatFileName(resources.getResourceName(R.raw.word_6))));
        list.add(new FileItem(7, formatFileName(resources.getResourceName(R.raw.word_7))));
        list.add(new FileItem(8, formatFileName(resources.getResourceName(R.raw.word_8))));
        list.add(new FileItem(9, formatFileName(resources.getResourceName(R.raw.word_9))));
        list.add(new FileItem(10, formatFileName(resources.getResourceName(R.raw.word_10))));
        list.add(new FileItem(11, formatFileName(resources.getResourceName(R.raw.word_11))));
        list.add(new FileItem(12, formatFileName(resources.getResourceName(R.raw.word_12))));
        list.add(new FileItem(13, formatFileName(resources.getResourceName(R.raw.word_13))));
        list.add(new FileItem(14, formatFileName(resources.getResourceName(R.raw.word_14))));
        list.add(new FileItem(15, formatFileName(resources.getResourceName(R.raw.word_15))));
        list.add(new FileItem(16, formatFileName(resources.getResourceName(R.raw.word_16))));
        list.add(new FileItem(17, formatFileName(resources.getResourceName(R.raw.word_17))));
        list.add(new FileItem(18, formatFileName(resources.getResourceName(R.raw.word_18))));
        list.add(new FileItem(19, formatFileName(resources.getResourceName(R.raw.word_19))));
        list.add(new FileItem(20, formatFileName(resources.getResourceName(R.raw.word_20))));
        return list;
    }

    public static int GetFileResIdByIndexId(int id)
    {
        int resId = -1;
        switch (id) {
            case 1:
                resId = R.raw.word_1;
                break;
            case 2:
                resId = R.raw.word_2;
                break;
            case 3:
                resId = R.raw.word_3;
                break;
            case 4:
                resId = R.raw.word_4;
                break;
            case 5:
                resId = R.raw.word_5;
                break;
            case 6:
                resId = R.raw.word_6;
                break;
            case 7:
                resId = R.raw.word_7;
                break;
            case 8:
                resId = R.raw.word_8;
                break;
            case 9:
                resId = R.raw.word_9;
                break;
            case 10:
                resId = R.raw.word_10;
                break;
            case 11:
                resId = R.raw.word_11;
                break;
            case 12:
                resId = R.raw.word_12;
                break;
            case 13:
                resId = R.raw.word_13;
                break;
            case 14:
                resId = R.raw.word_14;
                break;
            case 15:
                resId = R.raw.word_15;
                break;
            case 16:
                resId = R.raw.word_16;
                break;
            case 17:
                resId = R.raw.word_17;
                break;
            case 18:
                resId = R.raw.word_18;
                break;
            case 19:
                resId = R.raw.word_19;
                break;
            case 20:
                resId = R.raw.word_20;
                break;
            default:
                resId = -1;
        }

        return resId;
    }

    private static String formatFileName(String fileName)
    {
        if (fileName == null || fileName.isEmpty()) {
            return fileName;
        }

        String[] str = fileName.split("/",0);
        if (str.length == 2) {
            return str[1];
        }
        else {
            return fileName;
        }
    }
}
