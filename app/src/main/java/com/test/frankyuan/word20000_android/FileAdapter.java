package com.test.frankyuan.word20000_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
/**
 * Created by Yuan on 18.1.1.
 */

public class FileAdapter extends ArrayAdapter<FileItem>
{
    private int resourceId;

    public FileAdapter(Context context, int textViewResourceId, List<FileItem> objects)
    {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        FileItem fileItem = getItem(position);
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view =convertView;
        }
        TextView fileIdTextView = (TextView) view.findViewById(R.id.fileId);
        TextView fileNameTextView = (TextView) view.findViewById(R.id.fileName);
        fileIdTextView.setText(Integer.toString(fileItem.getFileId()));
        fileNameTextView.setText(fileItem.getFileName());
        return view;
    }
}

