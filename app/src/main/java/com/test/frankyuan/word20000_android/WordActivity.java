package com.test.frankyuan.word20000_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class WordActivity extends AppCompatActivity
{
    private JSONArray wordArray;
    private int currentIndex;
    private boolean showTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        GetWordFile();

        if (!isEmptyArray()) {
            currentIndex = 0;
            showCurrentWord();
            SeekBar seekBar = findViewById(R.id.sbWord);
            seekBar.setMax(wordArray.length()-1);
            seekBar.setProgress(currentIndex);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        currentIndex = progress;
                        showCurrentWord();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        } else {
            currentIndex = -1;
        }
        showTranslate = false;
    }

    private void GetWordFile() {
        Intent intent = getIntent();
        int currentFileId = intent.getIntExtra(getResources().getResourceName(R.string.txt_currentfileid), -1);
        int resId = FileListUtil.GetFileResIdByIndexId(currentFileId);
        InputStream is = getResources().openRawResource(resId);
        String workContentString = "";
        try {
            workContentString =  IOUtils.toString(is, "UTF-8");
        } catch (IOException e) {
            Log.e("Read Error", e.getMessage());
            workContentString = "";
        }
        try {
             wordArray = new JSONArray(workContentString);
        } catch (JSONException e) {
            Log.e("Parse JSON Error", e.getMessage());
            wordArray = null;
        }
    }

    public void jumpWord(View view) {
        String isNextString = view.getTag().toString();
        boolean isNext = Boolean.parseBoolean(isNextString);

        if (isEmptyArray()) {
            return;
        }

        if (isNext && currentIndex < wordArray.length()) {
            currentIndex ++;
            showCurrentWord();
        }

        if (!isNext && currentIndex > 0) {
            currentIndex --;
            showCurrentWord();
        }

        SeekBar seekBar = findViewById(R.id.sbWord);
        seekBar.setProgress(currentIndex);
    }

    public void setShowTranslate(View view)
    {
        showTranslate = !showTranslate;
        Button btnViewTranslate = findViewById(R.id.btnShowTranslate);
        if (showTranslate) {
            btnViewTranslate.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
        } else {
            btnViewTranslate.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
        }

        showCurrentWord();

    }

    private boolean isEmptyArray() {
        return wordArray == null || wordArray.length() == 0;
    }

    private void showCurrentWord() {
        if (isEmptyArray()) {
            return;
        }

        try {
            TextView textView = findViewById(R.id.textViewWord);
            textView.setText(Integer.toString(wordArray.getJSONObject(currentIndex).getInt("id"))  + ". " + wordArray.getJSONObject(currentIndex).getString("word"));

            TextView textPhonetic = findViewById(R.id.textViewPhonetic);
            textPhonetic.setText("[" + wordArray.getJSONObject(currentIndex).getJSONObject("translate").getString("us-phonetic") + "]");

            TextView textViewTranslate = findViewById(R.id.textViewTranslation);
            if (showTranslate) {
                textViewTranslate.setText(wordArray.getJSONObject(currentIndex).getJSONObject("translate").getJSONArray("explians").getString(0));
            } else {
                textViewTranslate.setText("");
            }

        } catch (JSONException err) {
            Log.e("Parse JSON Error", err.getMessage());
        }
    }
}
