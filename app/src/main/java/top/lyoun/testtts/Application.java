package top.lyoun.testtts;

import top.lyoun.ttsradiolib.radio.MySpeaker;
import top.lyoun.ttsradiolib.radio.Param;
import top.lyoun.ttsradiolib.radio.data.model.Auth;

/**
 * @Auth: 李友能
 * @gitHub: https://github.com/LyounJAP/TTSRadioLib.git
 * @createTime: 2020-11-29
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        //设置特殊语音
        Param.setParam("4","6");
        //初始化语音
        MySpeaker mSpeaker = MySpeaker.getInstance(this);
        if (mSpeaker != null) {
            //传入自己的Auth认证,与assets下的auth.properties配合使用
            Auth auth = Auth.getInstance(this);
            mSpeaker.init(true,auth);
//            //常规方法
//            mSpeaker.init(true);
        }
        super.onCreate();
    }

}
