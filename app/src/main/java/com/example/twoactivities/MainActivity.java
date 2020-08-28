package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public static final int TEXT_REQUEST = 1;
private TextView mReplyHeadTextView;
private TextView mReplyTextView;





public static final String EXTRA_MESSAGE =
        "com.example.android.twoactivities.extra.MESSAGE";

private EditText mMessageEditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        mMessageEditText = findViewById(R.id.editText_main);

        @Override
        public void onStart(){
            super.onStart();
            Log.d(LOG_TAG, "onStart");

            @Override
            protected void onPause() {
                super.onPause();
                Log.d(LOG_TAG, "onPause");
            }

            @Override
            protected void onRestart() {
                super.onRestart();
                Log.d(LOG_TAG, "onRestart");
            }

            @Override
            protected void onResume() {
                super.onResume();
                Log.d(LOG_TAG, "onResume");
            }

            @Override
            protected void onStop() {
                super.onStop();
                Log.d(LOG_TAG, "onStop");
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
                Log.d(LOG_TAG, "onDestroy");
            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
        @Override
        public void onActivityResult(int requestCode,
        int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                    mReplyHeadTextView.setVisibility(View.VISIBLE);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);

                    @Override
                    public void onSaveInstanceState(Bundle outState) {
                        super.onSaveInstanceState(outState);

                        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
                            outState.putBoolean("reply_visible", true);

                            if (isVisible) {
                                mReplyHeadTextView.setVisibility(View.VISIBLE);
                                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                                mReplyTextView.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                }
            }

        }
    }
}