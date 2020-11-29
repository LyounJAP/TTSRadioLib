package top.lyoun.testtts;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import top.lyoun.ttsradiolib.radio.MyAudioTracker;
import top.lyoun.ttsradiolib.radio.MySpeaker;

/**
 * @Auth: 李友能
 * @gitHub: https://github.com/LyounJAP/TTSRadioLib.git
 * @createTime: 2020-11-29
 * 测试合成语音
 */

public class TestRadio extends PublicActivity implements View.OnClickListener {

    private MyAudioTracker myAudioTracker;
    private AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_radio);
        initView();
//        //实例化语音工具类
//        myAudioTracker = MyAudioTracker.getInstance(this);
//        assetManager = getAssets();
        //实例化语音工具类
        mSpeaker = MySpeaker.getInstance(this);
    }

    private Button avoid;
    private Button bad;
    private Button beginmove;
    private Button cancel;
    private Button finish;
    private Button gopower;
    private Button power;
    private Button select;
    private Button ydyl;
    private Button zudang;

    private void initView(){
        avoid = findViewById(R.id.avoid);
        avoid.setOnClickListener(this);

        bad = findViewById(R.id.bad);
        bad.setOnClickListener(this);

        beginmove = findViewById(R.id.beginmove);
        beginmove.setOnClickListener(this);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        finish = findViewById(R.id.finish);
        finish.setOnClickListener(this);

        gopower = findViewById(R.id.gopower);
        gopower.setOnClickListener(this);

        power = findViewById(R.id.power);
        power.setOnClickListener(this);

        select = findViewById(R.id.select);
        select.setOnClickListener(this);

        ydyl = findViewById(R.id.ydyl);
        ydyl.setOnClickListener(this);

        zudang = findViewById(R.id.zudang);
        zudang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String[] contents = new String[2];
        switch (view.getId()){

            case R.id.avoid:
//                myAudioTracker.speaker("avoid",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.avoid.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.bad:
//                myAudioTracker.speaker("bad",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.bad.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.beginmove:
//                myAudioTracker.speaker("beginmove",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.beginmove.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.cancel:
//                myAudioTracker.speaker("cancel",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.cancel.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.finish:
//                myAudioTracker.speaker("finish",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.finish.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.gopower:
//                myAudioTracker.speaker("gopower",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.gopower.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.power:
//                myAudioTracker.speaker("power",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.power.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.select:
//                myAudioTracker.speaker("select",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.select.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.ydyl:
//                myAudioTracker.speaker("ydyl",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.ydyl.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;

            case R.id.zudang:
//                myAudioTracker.speaker("zudang",assetManager);
                if (mSpeaker != null) {
                    contents = PlayContent.getContent(PlayContent.Index.zudang.ordinal());
                    if(contents != null && contents.length == 2){
                        mSpeaker.speak(contents[0],contents[1]);
                    }
                }
                break;
        }
    }
}