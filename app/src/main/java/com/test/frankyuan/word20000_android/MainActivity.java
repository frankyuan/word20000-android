package com.test.frankyuan.word20000_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<FileItem> fileList = FileListUtil.loadFileList(getResources());
        FileAdapter adapter = new FileAdapter(this, R.layout.filelist_item, fileList);
        ListView listView = (ListView)findViewById(R.id.lvFileList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, WordActivity.class);
                intent.putExtra(getResources().getResourceName(R.string.txt_currentfileid), ((FileItem)parent.getItemAtPosition(position)).getFileId());
                startActivity(intent);
            }
        });
    }
}
