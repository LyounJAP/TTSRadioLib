package top.lyoun.testtts;

/**
 *
 * @Auth: 李友能
 * @gitHub: https://github.com/LyounJAP/TTSRadioLib.git
 * @createTime: 2020-11-29
 * 封装播报语音的内容
 * 注意添加播报内容时，也应该同步增加Index
 */

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
