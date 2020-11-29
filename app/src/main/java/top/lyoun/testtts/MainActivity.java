package top.lyoun.testtts;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @Auth: 李友能
 * @gitHub: https://github.com/LyounJAP/TTSRadioLib.git
 * @createTime: 2020-11-29
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,TestRadio.class));
        finish();
    }

}