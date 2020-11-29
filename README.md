# TTSRadioLib
基于百度合成语音的语音合成工具类

1、可灵活自定义语音播报文件和播报内容。

2、支持播放在线合成语音、离线语音。

3、自动检测当前网络状况，切换在线合成播报和离线播报模式。

4、支持播报特殊声音，比如童音、女音，可灵活设置。

5、封装了整合百度合成语音的具体细节、集成了合成语音sdk，调用简单。

6、可自由替换自己项目的百度合成语音鉴权文件。

7、即时播放，不受其它语音播报干扰。

8、网络质量不好，会有一定程度影响在线合成语音的播报效果。

9、基于百度合成语音免费版整合而成。


项目集成：

只需要5步即可将合成语音集成进你的项目：

第一步：将语音合成工具包TTSRadioLib.aar，拷贝到你项目工程下的libs文件夹下。

第二步：在你项目modul的build.gradle文件中加入aar目录声明：

android{
  
  ...
  
  //声明libs目录
  
  repositories {
  
    flatDir {
    
        dirs 'libs'   // aar目录
        
    }
    
  }
  
  ...
  
}

第三步：在dependencies下引入arr文件依赖：

dependencies{

...

//引入语音依赖

implementation(name: 'TTSRadioLib', ext: 'aar')

...

}

第四步：自定义Application的onCreate方法中，初始化语音Speaker:

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


第五步：将自定义Application引入到manifest配置文件中，添加name属性值：

<application
        android:name=".Application"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        
================================================================================================


播报语音：

//获取语音工具类实例

mSpeaker = MySpeaker.getInstance(this);

//语音播报前，判空处理，contents二维数组是播报的具体内容，contents[0]：播报文件的文件名，contents[1]：播报的语音内容

if (mSpeaker != null) {

   contents = PlayContent.getContent(PlayContent.Index.avoid.ordinal());
   
   if(contents != null && contents.length == 2){
   
      mSpeaker.speak(contents[0],contents[1]);
      
   }
   
}

================================================================================================

自定义语音播报内容：

