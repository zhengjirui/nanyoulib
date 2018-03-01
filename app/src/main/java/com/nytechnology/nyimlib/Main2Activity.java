package com.nytechnology.nyimlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    private String JSON = "{\n" +
            "        \"u1F600\": { \"en\": \"Grinning Face\", \"zh\": \"笑嘻嘻\", \"tag\": \"\\uD83D\\uDE00\", \"position\": \"0px 0px\" },\n" +
            "        \"u1F601\": { \"en\": \"Grinning With Smiling\", \"zh\": \"露齿而笑\", \"tag\": \"\\uD83D\\uDE01\", \"position\": \"-25px 0px\" },\n" +
            "        \"u1F602\": { \"en\": \"Laughing Tears\", \"zh\": \"喜极而泣\", \"tag\": \"\\uD83D\\uDE02\", \"position\": \"-50px 0px\" },\n" +
            "        \"u1F603\": { \"en\": \"Smiley Face\", \"zh\": \"笑脸\", \"tag\": \"\\uD83D\\uDE03\", \"position\": \"-75px 0px\" },\n" +
            "        \"u1F605\": { \"en\": \"Happy Sweat\", \"zh\": \"尴尬\", \"tag\": \"\\uD83D\\uDE05\", \"position\": \"-100px 0px\" },\n" +
            "        \"u1F606\": { \"en\": \"Big Grin\", \"zh\": \"大笑\", \"tag\": \"\\uD83D\\uDE06\", \"position\": \"-125px 0px\" },\n" +
            "        \"u1F607\": { \"en\": \"Halo\", \"zh\": \"天使光环\", \"tag\": \"\\uD83D\\uDE07\", \"position\": \"-150px 0px\" },\n" +
            "        \"u1F608\": { \"en\": \"Purple Devil\", \"zh\": \"小恶魔\", \"tag\": \"\\uD83D\\uDE08\", \"position\": \"-175px 0px\" },\n" +
            "        \"u1F609\": { \"en\": \"Winking Face\", \"zh\": \"眨眼\", \"tag\": \"\\uD83D\\uDE09\", \"position\": \"-200px 0px\" },\n" +
            "        \"u1F611\": { \"en\": \"Expressionless Face\", \"zh\": \"面无表情\", \"tag\": \"\\uD83D\\uDE11\", \"position\": \"-225px 0px\" },\n" +
            "        \"u1F612\": { \"en\": \"Dissatisfied\", \"zh\": \"不满\", \"tag\": \"\\uD83D\\uDE12\", \"position\": \"-250px 0px\" },\n" +
            "        \"u1F613\": { \"en\": \"Sweat\", \"zh\": \"汗\", \"tag\": \"\\uD83D\\uDE13\", \"position\": \"-275px 0px\" },\n" +
            "        \"u1F614\": { \"en\": \"Pensive\", \"zh\": \"沉思\", \"tag\": \"\\uD83D\\uDE14\", \"position\": \"-300px 0px\" },\n" +
            "        \"u1F615\": { \"en\": \"Confused\", \"zh\": \"困惑\", \"tag\": \"\\uD83D\\uDE15\", \"position\": \"-325px 0px\" },\n" +
            "        \"u1F616\": { \"en\": \"Confounded Face\", \"zh\": \"蒙羞\", \"tag\": \"\\uD83D\\uDE16\", \"position\": \"-350px 0px\" },\n" +
            "        \"u1F618\": { \"en\": \"Blowing Kiss\", \"zh\": \"飞吻\", \"tag\": \"\\uD83D\\uDE18\", \"position\": \"-375px 0px\" },\n" +
            "        \"u1F621\": { \"en\": \"Angry Face\", \"zh\": \"生气\", \"tag\": \"\\uD83D\\uDE21\", \"position\": \"-400px 0px\" },\n" +
            "        \"u1F622\": { \"en\": \"Sobbing\", \"zh\": \"哭泣\", \"tag\": \"\\uD83D\\uDE2D\", \"position\": \"-2075px 0px\" },\n" +
            "        \"u1F623\": { \"en\": \"Helpless Face\", \"zh\": \"无助\", \"tag\": \"\\uD83D\\uDE23\", \"position\": \"-450px 0px\" },\n" +
            "        \"u1F624\": { \"en\": \"Mad Face\", \"zh\": \"怒气冲冲\", \"tag\": \"\\uD83D\\uDE24\", \"position\": \"-475px 0px\" },\n" +
            "        \"u1F628\": { \"en\": \"Fearful Face\", \"zh\": \"可怕\", \"tag\": \"\\uD83D\\uDE28\", \"position\": \"-500px 0px\" },\n" +
            "        \"u1F629\": { \"en\": \"Weary Face\", \"zh\": \"疲惫\", \"tag\": \"\\uD83D\\uDE29\", \"position\": \"-525px 0px\" },\n" +
            "        \"u1F630\": { \"en\": \"Cold Sweat\", \"zh\": \"冷汗\", \"tag\": \"\\uD83D\\uDE30\", \"position\": \"-550px 0px\" },\n" +
            "        \"u1F631\": { \"en\": \"Scream\", \"zh\": \"尖叫\", \"tag\": \"\\uD83D\\uDE31\", \"position\": \"-575px 0px\" },\n" +
            "        \"u1F632\": { \"en\": \"Shocked Face\", \"zh\": \"震惊\", \"tag\": \"\\uD83D\\uDE32\", \"position\": \"-600px 0px\" },\n" +
            "        \"u1F633\": { \"en\": \"Flushed Face\", \"zh\": \"脸红\", \"tag\": \"\\uD83D\\uDE33\", \"position\": \"-625px 0px\" },\n" +
            "        \"u1F634\": { \"en\": \"Sleeping\", \"zh\": \"睡眠\", \"tag\": \"\\uD83D\\uDE34\", \"position\": \"-650px 0px\" },\n" +
            "        \"u1F635\": { \"en\": \"Dizzy Face\", \"zh\": \"头晕眼花\", \"tag\": \"\\uD83D\\uDE35\", \"position\": \"-675px 0px\" },\n" +
            "        \"u1F636\": { \"en\": \"Mouthless\", \"zh\": \"无口\", \"tag\": \"\\uD83D\\uDE36\", \"position\": \"-700px 0px\" },\n" +
            "        \"u1F637\": { \"en\": \"Mask Face\", \"zh\": \"口罩\", \"tag\": \"\\uD83D\\uDE37\", \"position\": \"-725px 0px\" },\n" +
            "        \"u1F3A4\": { \"en\": \"Microphone\", \"zh\": \"麦克风\", \"tag\": \"\\uD83C\\uDFA4\", \"position\": \"-750px 0px\" },\n" +
            "        \"u1F3B2\": { \"en\": \"Game Die\", \"zh\": \"骰子\", \"tag\": \"\\uD83C\\uDFB2\", \"position\": \"-775px 0px\" },\n" +
            "        \"u1F3B5\": { \"en\": \"Musical Note\", \"zh\": \"音乐\", \"tag\": \"\\uD83C\\uDFB5\", \"position\": \"-800px 0px\" },\n" +
            "        \"u1F3C0\": { \"en\": \"Basketball\", \"zh\": \"篮球\", \"tag\": \"\\uD83C\\uDFC0\", \"position\": \"-825px 0px\" },\n" +
            "        \"u1F3C2\": { \"en\": \"Snowboarder\", \"zh\": \"单板滑雪\", \"tag\": \"\\uD83C\\uDFC2\", \"position\": \"-850px 0px\" },\n" +
            "        \"u1F3E1\": { \"en\": \"House With Garden\", \"zh\": \"房子\", \"tag\": \"\\uD83C\\uDFE1\", \"position\": \"-875px 0px\" },\n" +
            "        \"u1F004\": { \"en\": \"Mahjong Red Dragon\", \"zh\": \"麻将\", \"tag\": \"\\uD83C\\uDC04\", \"position\": \"-900px 0px\" },\n" +
            "        \"u1F4A1\": { \"en\": \"Light Bulb\", \"zh\": \"灯泡\", \"tag\": \"\\uD83D\\uDCA1\", \"position\": \"-925px 0px\" },\n" +
            "        \"u1F4A2\": { \"en\": \"Anger\", \"zh\": \"愤怒\", \"tag\": \"\\uD83D\\uDCA2\", \"position\": \"-950px 0px\" },\n" +
            "        \"u1F4A3\": { \"en\": \"Bomb\", \"zh\": \"炸弹\", \"tag\": \"\\uD83D\\uDCA3\", \"position\": \"-975px 0px\" },\n" +
            "        \"u1F4A4\": { \"en\": \"Zzz\", \"zh\": \"ZZZ\", \"tag\": \"\\uD83D\\uDCA4\", \"position\": \"-1000px 0px\" },\n" +
            "        \"u1F4A9\": { \"en\": \"Pile Of Poo\", \"zh\": \"便便\", \"tag\": \"\\uD83D\\uDCA9\", \"position\": \"-1025px 0px\" },\n" +
            "        \"u1F4AA\": { \"en\": \"Flexed Biceps\", \"zh\": \"肌肉\", \"tag\": \"\\uD83D\\uDCAA\", \"position\": \"-1050px 0px\" },\n" +
            "        \"u1F4B0\": { \"en\": \"Money Bag\", \"zh\": \"钱袋\", \"tag\": \"\\uD83D\\uDCB0\", \"position\": \"-1075px 0px\" },\n" +
            "        \"u1F4DA\": { \"en\": \"Books\", \"zh\": \"书籍\", \"tag\": \"\\uD83D\\uDCDA\", \"position\": \"-1100px 0px\" },\n" +
            "        \"u1F4DE\": { \"en\": \"Telephone Receiver\", \"zh\": \"电话听筒\", \"tag\": \"\\uD83D\\uDCDE\", \"position\": \"-1125px 0px\" },\n" +
            "        \"u1F4E2\": { \"en\": \"Loudspeaker\", \"zh\": \"扩音器\", \"tag\": \"\\uD83D\\uDCE2\", \"position\": \"-1150px 0px\" },\n" +
            "        \"u1F6AB\": { \"en\": \"Prohibited\", \"zh\": \"禁止\", \"tag\": \"\\uD83D\\uDEAB\", \"position\": \"-1175px 0px\" },\n" +
            "        \"u1F6BF\": { \"en\": \"Shower\", \"zh\": \"淋浴\", \"tag\": \"\\uD83D\\uDEBF\", \"position\": \"-1200px 0px\" },\n" +
            "        \"u1F30F\": { \"en\": \"Globe\", \"zh\": \"地球\", \"tag\": \"\\uD83C\\uDF0F\", \"position\": \"-1225px 0px\" },\n" +
            "        \"u1F33B\": { \"en\": \"Sunflower\", \"zh\": \"向日葵\", \"tag\": \"\\uD83C\\uDF3B\", \"position\": \"-1250px 0px\" },\n" +
            "        \"u1F35A\": { \"en\": \"Cooked Rice\", \"zh\": \"米饭\", \"tag\": \"\\uD83C\\uDF5A\", \"position\": \"-1275px 0px\" },\n" +
            "        \"u1F36B\": { \"en\": \"Chocolate Bar\", \"zh\": \"巧克力\", \"tag\": \"\\uD83C\\uDF6B\", \"position\": \"-1300px 0px\" },\n" +
            "        \"u1F37B\": { \"en\": \"Cheers\", \"zh\": \"干杯\", \"tag\": \"\\uD83C\\uDF7B\", \"position\": \"-1325px 0px\" },\n" +
            "        \"u270A\": { \"en\": \"Oncoming Fist\", \"zh\": \"击拳\", \"tag\": \"\\uD83D\\uDC4A\", \"position\": \"-1350px 0px\" },\n" +
            "        \"u1F44C\": { \"en\": \"Ok Hand\", \"zh\": \"没问题\", \"tag\": \"\\uD83D\\uDC4C\", \"position\": \"-1375px 0px\" },\n" +
            "        \"u1F44D\": { \"en\": \"Thumbs Up\", \"zh\": \"赞\", \"tag\": \"\\uD83D\\uDC4D\", \"position\": \"-1400px 0px\" },\n" +
            "        \"u1F44E\": { \"en\": \"Thumbs Down\", \"zh\": \"喝倒彩\", \"tag\": \"\\uD83D\\uDC4E\", \"position\": \"-1425px 0px\" },\n" +
            "        \"u1F44F\": { \"en\": \"Clapping Hands\", \"zh\": \"鼓掌\", \"tag\": \"\\uD83D\\uDC4F\", \"position\": \"-1450px 0px\" },\n" +
            "        \"u1F46A\": { \"en\": \"Family\", \"zh\": \"家庭\", \"tag\": \"\\uD83D\\uDC6A\", \"position\": \"-1475px 0px\" },\n" +
            "        \"u1F46B\": { \"en\": \"Couple\", \"zh\": \"情侣\", \"tag\": \"\\uD83D\\uDC6B\", \"position\": \"-1500px 0px\" },\n" +
            "        \"u1F62C\": { \"en\": \"Grimacing Face\", \"zh\": \"扮鬼脸\", \"tag\": \"\\uD83D\\uDE2C\", \"position\": \"-2050px 0px\" },\n" +
            "        \"u1F47B\": { \"en\": \"Ghost\", \"zh\": \"鬼\", \"tag\": \"\\uD83D\\uDC7B\", \"position\": \"-1525px 0px\" },\n" +
            "        \"u1F47C\": { \"en\": \"Baby Angel\", \"zh\": \"宝贝天使\", \"tag\": \"\\uD83D\\uDC7C\", \"position\": \"-1550px 0px\" },\n" +
            "        \"u1F47D\": { \"en\": \"Alien\", \"zh\": \"外星人\", \"tag\": \"\\uD83D\\uDC7D\", \"position\": \"-1575px 0px\" },\n" +
            "        \"u1F47F\": { \"en\": \"Devil\", \"zh\": \"恶魔\", \"tag\": \"\\uD83D\\uDC7F\", \"position\": \"-1600px 0px\" },\n" +
            "        \"u1F48A\": { \"en\": \"Capsule\", \"zh\": \"药\", \"tag\": \"\\uD83D\\uDC8A\", \"position\": \"-1625px 0px\" },\n" +
            "        \"u1F48B\": { \"en\": \"Kiss\", \"zh\": \"吻\", \"tag\": \"\\uD83D\\uDC8B\", \"position\": \"-1650px 0px\" },\n" +
            "        \"u1F48D\": { \"en\": \"Ring\", \"zh\": \"戒指\", \"tag\": \"\\uD83D\\uDC8D\", \"position\": \"-1675px 0px\" },\n" +
            "        \"u1F52B\": { \"en\": \"Pistol\", \"zh\": \"手枪\", \"tag\": \"\\uD83D\\uDD2B\", \"position\": \"-1700px 0px\" },\n" +
            "        \"u1F60A\": { \"en\": \"Smiley\", \"zh\": \"微笑\", \"tag\": \"\\uD83D\\uDE0A\", \"position\": \"-1725px 0px\" },\n" +
            "        \"u1F60B\": { \"en\": \"Hungry\", \"zh\": \"馋\", \"tag\": \"\\uD83D\\uDE0B\", \"position\": \"-1750px 0px\" },\n" +
            "        \"u1F60C\": { \"en\": \"Pleased\", \"zh\": \"满意\", \"tag\": \"\\uD83D\\uDE0C\", \"position\": \"-1775px 0px\" },\n" +
            "        \"u1F60D\": { \"en\": \"Heart Eyes\", \"zh\": \"色迷迷\", \"tag\": \"\\uD83D\\uDE0D\", \"position\": \"-1800px 0px\" },\n" +
            "        \"u1F60E\": { \"en\": \"Sunglasses\", \"zh\": \"墨镜\", \"tag\": \"\\uD83D\\uDE0E\", \"position\": \"-1825px 0px\" },\n" +
            "        \"u1F60F\": { \"en\": \"Smirking Face\", \"zh\": \"傻笑\", \"tag\": \"\\uD83D\\uDE0F\", \"position\": \"-1850px 0px\" },\n" +
            "        \"u1F61A\": { \"en\": \"Kiss Face\", \"zh\": \"么么哒\", \"tag\": \"\\uD83D\\uDE1A\", \"position\": \"-1875px 0px\" },\n" +
            "        \"u1F61C\": { \"en\": \"Crazy Face\", \"zh\": \"调皮\", \"tag\": \"\\uD83D\\uDE1C\", \"position\": \"-1900px 0px\" },\n" +
            "        \"u1F61D\": { \"en\": \"Tongue Out\", \"zh\": \"吐舌头\", \"tag\": \"\\uD83D\\uDE1D\", \"position\": \"-1925px 0px\" },\n" +
            "        \"u1F61E\": { \"en\": \"Disappointed Face\", \"zh\": \"失望\", \"tag\": \"\\uD83D\\uDE1E\", \"position\": \"-1950px 0px\" },\n" +
            "        \"u1F61F\": { \"en\": \"Worried Face\", \"zh\": \"苦瓜脸\", \"tag\": \"\\uD83D\\uDE1F\", \"position\": \"-1975px 0px\" },\n" +
            "        \"u1F62A\": { \"en\": \"Sleepy Face\", \"zh\": \"困\", \"tag\": \"\\uD83D\\uDE2A\", \"position\": \"-2000px 0px\" },\n" +
            "        \"u1F62B\": { \"en\": \"Tired Face\", \"zh\": \"抓狂\", \"tag\": \"\\uD83D\\uDE2B\", \"position\": \"-2025px 0px\" },\n" +
            "        \"u1F62D\": { \"en\": \"Crying\", \"zh\": \"伤心\", \"tag\": \"\\uD83D\\uDE22\", \"position\": \"-425px 0px\" },\n" +
            "        \"u1F62F\": { \"en\": \"Surprised Face\", \"zh\": \"惊呆\", \"tag\": \"\\uD83D\\uDE2F\", \"position\": \"-2100px 0px\" },\n" +
            "        \"u1F64A\": { \"en\": \"No Speaking\", \"zh\": \"闭嘴\", \"tag\": \"\\uD83D\\uDE4A\", \"position\": \"-2125px 0px\" },\n" +
            "        \"u1F64F\": { \"en\": \"Folded Hands\", \"zh\": \"祈祷\", \"tag\": \"\\uD83D\\uDE4F\", \"position\": \"-2150px 0px\" },\n" +
            "        \"u1F319\": { \"en\": \"Drescent Moon\", \"zh\": \"弯月\", \"tag\": \"\\uD83C\\uDF19\", \"position\": \"-2175px 0px\" },\n" +
            "        \"u1F332\": { \"en\": \"Pine Tree\", \"zh\": \"松树\", \"tag\": \"\\uD83C\\uDF32\", \"position\": \"-2200px 0px\" },\n" +
            "        \"u1F339\": { \"en\": \"Rose\", \"zh\": \"玫瑰\", \"tag\": \"\\uD83C\\uDF39\", \"position\": \"-2225px 0px\" },\n" +
            "        \"u1F349\": { \"en\": \"Watermelon\", \"zh\": \"西瓜\", \"tag\": \"\\uD83C\\uDF49\", \"position\": \"-2250px 0px\" },\n" +
            "        \"u1F356\": { \"en\": \"Barbecue\", \"zh\": \"BBQ\", \"tag\": \"\\uD83C\\uDF56\", \"position\": \"-2275px 0px\" },\n" +
            "        \"u1F366\": { \"en\": \"Ice Cream\", \"zh\": \"冰淇淋\", \"tag\": \"\\uD83C\\uDF66\", \"position\": \"-2300px 0px\" },\n" +
            "        \"u1F377\": { \"en\": \"Wine Glass\", \"zh\": \"红酒\", \"tag\": \"\\uD83C\\uDF77\", \"position\": \"-2325px 0px\" },\n" +
            "        \"u1F381\": { \"en\": \"Wrapped Gift\", \"zh\": \"礼物\", \"tag\": \"\\uD83C\\uDF81\", \"position\": \"-2350px 0px\" },\n" +
            "        \"u1F382\": { \"en\": \"Birthday Cake\", \"zh\": \"生日蛋糕\", \"tag\": \"\\uD83C\\uDF82\", \"position\": \"-2375px 0px\" },\n" +
            "        \"u1F384\": { \"en\": \"Christmas Tree\", \"zh\": \"圣诞树\", \"tag\": \"\\uD83C\\uDF84\", \"position\": \"-2400px 0px\" },\n" +
            "        \"u1F389\": { \"en\": \"Party Popper\", \"zh\": \"聚会礼花\", \"tag\": \"\\uD83C\\uDF89\", \"position\": \"-2425px 0px\" },\n" +
            "        \"u1F393\": { \"en\": \"Graduation Cap\", \"zh\": \"毕业帽\", \"tag\": \"\\uD83C\\uDF93\", \"position\": \"-2450px 0px\" },\n" +
            "        \"u1F434\": { \"en\": \"Horse\", \"zh\": \"马\", \"tag\": \"\\uD83D\\uDC34\", \"position\": \"-2475px 0px\" },\n" +
            "        \"u1F436\": { \"en\": \"Dog\", \"zh\": \"狗\", \"tag\": \"\\uD83D\\uDC36\", \"position\": \"-2500px 0px\" },\n" +
            "        \"u1F437\": { \"en\": \"Pig\", \"zh\": \"猪\", \"tag\": \"\\uD83D\\uDC37\", \"position\": \"-2525px 0px\" },\n" +
            "        \"u1F451\": { \"en\": \"Crown\", \"zh\": \"王冠\", \"tag\": \"\\uD83D\\uDC51\", \"position\": \"-2550px 0px\" },\n" +
            "        \"u1F484\": { \"en\": \"Lipstick\", \"zh\": \"口红\", \"tag\": \"\\uD83D\\uDC84\", \"position\": \"-2575px 0px\" },\n" +
            "        \"u1F494\": { \"en\": \"Broken Heart\", \"zh\": \"心碎\", \"tag\": \"\\uD83D\\uDC94\", \"position\": \"-2600px 0px\" },\n" +
            "        \"u1F525\": { \"en\": \"Fire\", \"zh\": \"火\", \"tag\": \"\\uD83D\\uDD25\", \"position\": \"-2625px 0px\" },\n" +
            "        \"u1F556\": { \"en\": \"Clock\", \"zh\": \"表\", \"tag\": \"\\uD83D\\uDD56\", \"position\": \"-2650px 0px\" },\n" +
            "        \"u1F648\": { \"en\": \"See No Monkey\", \"zh\": \"不看\", \"tag\": \"\\uD83D\\uDE48\", \"position\": \"-2675px 0px\" },\n" +
            "        \"u1F649\": { \"en\": \"Hear No Monkey\", \"zh\": \"不听\", \"tag\": \"\\uD83D\\uDE49\", \"position\": \"-2700px 0px\" },\n" +
            "        \"u1F680\": { \"en\": \"Rocket\", \"zh\": \"火箭\", \"tag\": \"\\uD83D\\uDE80\", \"position\": \"-2725px 0px\" },\n" +
            "        \"u2B50\": { \"en\": \"Star\", \"zh\": \"星星\", \"tag\": \"\\u2B50\", \"position\": \"-2750px 0px\" },\n" +
            "        \"u23F0\": { \"en\": \"Alarm Clock\", \"zh\": \"闹钟\", \"tag\": \"\\u23F0\", \"position\": \"-2775px 0px\" },\n" +
            "        \"u23F3\": { \"en\": \"Hourglass\", \"zh\": \"沙漏\", \"tag\": \"\\u23F3\", \"position\": \"-2800px 0px\" },\n" +
            "        \"u26A1\": { \"en\": \"Lightning Bolt\", \"zh\": \"闪电\", \"tag\": \"\\u26A1\", \"position\": \"-2825px 0px\" },\n" +
            "        \"u26BD\": { \"en\": \"Soccer Ball\", \"zh\": \"足球\", \"tag\": \"\\u26BD\", \"position\": \"-2850px 0px\" },\n" +
            "        \"u26C4\": { \"en\": \"Snowman\", \"zh\": \"雪人\", \"tag\": \"\\u26C4\", \"position\": \"-2875px 0px\" },\n" +
            "        \"u26C5\": { \"en\": \"Cloudy\", \"zh\": \"多云\", \"tag\": \"\\u26C5\", \"position\": \"-2900px 0px\" },\n" +
            "        \"u261D\": { \"en\": \"Pointing Up\", \"zh\": \"第一\", \"tag\": \"\\u261D\", \"position\": \"-2925px 0px\" },\n" +
            "        \"u263A\": { \"en\": \"Cute\", \"zh\": \"萌萌哒\", \"tag\": \"\\u263A\", \"position\": \"-2950px 0px\" },\n" +
            "        \"u1F44A\": { \"en\": \"Raised Fist\", \"zh\": \"举起拳头\", \"tag\": \"\\u270A\", \"position\": \"-2975px 0px\" },\n" +
            "        \"u270B\": { \"en\": \"Raised Hand\", \"zh\": \"举手\", \"tag\": \"\\u270B\", \"position\": \"-3000px 0px\" },\n" +
            "        \"u270C\": { \"en\": \"Victory Hand\", \"zh\": \"耶\", \"tag\": \"\\u270C\", \"position\": \"-3025px 0px\" },\n" +
            "        \"u270F\": { \"en\": \"Pencil\", \"zh\": \"铅笔\", \"tag\": \"\\u270F\", \"position\": \"-3050px 0px\" },\n" +
            "        \"u2600\": { \"en\": \"Sunny\", \"zh\": \"晴朗\", \"tag\": \"\\u2600\", \"position\": \"-3075px 0px\" },\n" +
            "        \"u2601\": { \"en\": \"Cloud\", \"zh\": \"云彩\", \"tag\": \"\\u2601\", \"position\": \"-3100px 0px\" },\n" +
            "        \"u2614\": { \"en\": \"Umbrella\", \"zh\": \"雨伞\", \"tag\": \"\\u2614\", \"position\": \"-3125px 0px\" },\n" +
            "        \"u2615\": { \"en\": \"Coffee\", \"zh\": \"咖啡\", \"tag\": \"\\u2615\", \"position\": \"-3150px 0px\" },\n" +
            "        \"u2744\": { \"en\": \"Snowflake\", \"zh\": \"雪花\", \"tag\": \"\\u2744\", \"position\": \"-3175px 0px\" }\n" +
            "    }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("getPackageName()=",  getPackageName()); //Context类
        Log.e("getClass().getName()=",  getClass().getName());//Class类
        try {
            JSONObject jsStr = new JSONObject(JSON);
            JSONArray tag = jsStr.getJSONArray("tag");
            Log.e("------------",tag.length() + "");
//            JSONObject u1F600 = jsStr.getJSONObject("u1F600");
//            String zh = u1F600.getString("zh");
//            String tag = u1F600.getString("tag");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
