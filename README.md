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

自定义PlayContent这个类就好，播报时直接调用这个类中的内容进行播报，需注意的是，枚举Index的长度需和二维数组contents长度一致：

public class PlayContent {

    //语音播放文件名集合
    public enum Index {
        avoid,
        bad,
        beginmove,
        cancel,
        finish,
        gopower,
        power,
        select,
        ydyl,
        zudang
    }

    //二维数组中的一维长度,跟Index项目数相等,跟Index中的顺序一致，二维长度为2，0-文件名，1-播报内容

    public static final String[][] contents = new String[][]{
            {"avoid", "请避让"},
            {"bad", "出现故障"},
            {"beginmove", "出发了"},
            {"cancel", "取消了"},
            {"finish", "任务完成"},
            {"gopower", "该休息了"},
            {"power", "准备补充能量"},
            {"select", "请选择"},
            {"ydyl", "欢迎您"},
            {"zudang", "被挡住了"},
    };

    //通过传入数组下标的方式，获取该播报的文件名和语音内容
    public static String[] getContent(int index) {
        if (index >= contents.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return contents[index];
    }
    
}

================================================================================================

播报特殊声音：

播报特殊声音是通过Param.setParam方法来实现的，他要求在Application初始化语音工具类之前调用，通过调整合成语音播音员、语调、语速、音量的方式，灵活实现多种特殊的声音效果：

//设置特殊语音-童音

Param.setParam("4","6");

//设置特殊语音-女声

Param.setParam("0","5");

//设置特殊语音-普通男声

Param.setParam("1","5");

//设置特殊语音-情感男声

Param.setParam("3","5");

================================================================================================

替换自己的百度合成语音鉴权文件（推荐）：

第一步：找到你项目工程的app/src/main目录，点击新建assets文件夹。

第二步：将鉴权文件auth.properties拷贝到assets文件夹中。

第三步：将文件中的appId、appKey、secretKey、applicationId值，分别替换成你在百度开发者平台上申请的合成语音应用的AppID、API Key、Secret Key、包名，包名即你当前项目的manifest文件中package的值。

第四步：在Application初始化语音工具类之前，传入自己项目的Auth认证：

if (mSpeaker != null) {

   //传入自己的Auth认证,与assets下的auth.properties配合使用
   
   Auth auth = Auth.getInstance(this);
   
   mSpeaker.init(true,auth);
   
   //常规方法
   
   // mSpeaker.init(true);
   
}

================================================================================================

代码混淆：

-keep class top.lyoun.ttsradiolib.radio.**{*;}

