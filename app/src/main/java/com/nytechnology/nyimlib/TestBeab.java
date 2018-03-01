package com.nytechnology.nyimlib;

/**
 * Created by 18513 on 2018/1/25.
 */

public class TestBeab {

    /**
     * u1F600 : {"en":"Grinning Face","zh":"笑嘻嘻","tag":"😀","position":"0px 0px"}
     * u1F601 : {"en":"Grinning With Smiling","zh":"露齿而笑","tag":"😁","position":"-25px 0px"}
     * u1F602 : {"en":"Laughing Tears","zh":"喜极而泣","tag":"😂","position":"-50px 0px"}
     * u1F603 : {"en":"Smiley Face","zh":"笑脸","tag":"😃","position":"-75px 0px"}
     * u1F605 : {"en":"Happy Sweat","zh":"尴尬","tag":"😅","position":"-100px 0px"}
     * u1F606 : {"en":"Big Grin","zh":"大笑","tag":"😆","position":"-125px 0px"}
     * u1F607 : {"en":"Halo","zh":"天使光环","tag":"😇","position":"-150px 0px"}
     * u1F608 : {"en":"Purple Devil","zh":"小恶魔","tag":"😈","position":"-175px 0px"}
     * u1F609 : {"en":"Winking Face","zh":"眨眼","tag":"😉","position":"-200px 0px"}
     * u1F611 : {"en":"Expressionless Face","zh":"面无表情","tag":"😑","position":"-225px 0px"}
     * u1F612 : {"en":"Dissatisfied","zh":"不满","tag":"😒","position":"-250px 0px"}
     * u1F613 : {"en":"Sweat","zh":"汗","tag":"😓","position":"-275px 0px"}
     * u1F614 : {"en":"Pensive","zh":"沉思","tag":"😔","position":"-300px 0px"}
     * u1F615 : {"en":"Confused","zh":"困惑","tag":"😕","position":"-325px 0px"}
     * u1F616 : {"en":"Confounded Face","zh":"蒙羞","tag":"😖","position":"-350px 0px"}
     * u1F618 : {"en":"Blowing Kiss","zh":"飞吻","tag":"😘","position":"-375px 0px"}
     * u1F621 : {"en":"Angry Face","zh":"生气","tag":"😡","position":"-400px 0px"}
     * u1F622 : {"en":"Sobbing","zh":"哭泣","tag":"😭","position":"-2075px 0px"}
     * u1F623 : {"en":"Helpless Face","zh":"无助","tag":"😣","position":"-450px 0px"}
     * u1F624 : {"en":"Mad Face","zh":"怒气冲冲","tag":"😤","position":"-475px 0px"}
     * u1F628 : {"en":"Fearful Face","zh":"可怕","tag":"😨","position":"-500px 0px"}
     * u1F629 : {"en":"Weary Face","zh":"疲惫","tag":"😩","position":"-525px 0px"}
     * u1F630 : {"en":"Cold Sweat","zh":"冷汗","tag":"😰","position":"-550px 0px"}
     * u1F631 : {"en":"Scream","zh":"尖叫","tag":"😱","position":"-575px 0px"}
     * u1F632 : {"en":"Shocked Face","zh":"震惊","tag":"😲","position":"-600px 0px"}
     * u1F633 : {"en":"Flushed Face","zh":"脸红","tag":"😳","position":"-625px 0px"}
     * u1F634 : {"en":"Sleeping","zh":"睡眠","tag":"😴","position":"-650px 0px"}
     * u1F635 : {"en":"Dizzy Face","zh":"头晕眼花","tag":"😵","position":"-675px 0px"}
     * u1F636 : {"en":"Mouthless","zh":"无口","tag":"😶","position":"-700px 0px"}
     * u1F637 : {"en":"Mask Face","zh":"口罩","tag":"😷","position":"-725px 0px"}
     * u1F3A4 : {"en":"Microphone","zh":"麦克风","tag":"🎤","position":"-750px 0px"}
     * u1F3B2 : {"en":"Game Die","zh":"骰子","tag":"🎲","position":"-775px 0px"}
     * u1F3B5 : {"en":"Musical Note","zh":"音乐","tag":"🎵","position":"-800px 0px"}
     * u1F3C0 : {"en":"Basketball","zh":"篮球","tag":"🏀","position":"-825px 0px"}
     * u1F3C2 : {"en":"Snowboarder","zh":"单板滑雪","tag":"🏂","position":"-850px 0px"}
     * u1F3E1 : {"en":"House With Garden","zh":"房子","tag":"🏡","position":"-875px 0px"}
     * u1F004 : {"en":"Mahjong Red Dragon","zh":"麻将","tag":"🀄","position":"-900px 0px"}
     * u1F4A1 : {"en":"Light Bulb","zh":"灯泡","tag":"💡","position":"-925px 0px"}
     * u1F4A2 : {"en":"Anger","zh":"愤怒","tag":"💢","position":"-950px 0px"}
     * u1F4A3 : {"en":"Bomb","zh":"炸弹","tag":"💣","position":"-975px 0px"}
     * u1F4A4 : {"en":"Zzz","zh":"ZZZ","tag":"💤","position":"-1000px 0px"}
     * u1F4A9 : {"en":"Pile Of Poo","zh":"便便","tag":"💩","position":"-1025px 0px"}
     * u1F4AA : {"en":"Flexed Biceps","zh":"肌肉","tag":"💪","position":"-1050px 0px"}
     * u1F4B0 : {"en":"Money Bag","zh":"钱袋","tag":"💰","position":"-1075px 0px"}
     * u1F4DA : {"en":"Books","zh":"书籍","tag":"📚","position":"-1100px 0px"}
     * u1F4DE : {"en":"Telephone Receiver","zh":"电话听筒","tag":"📞","position":"-1125px 0px"}
     * u1F4E2 : {"en":"Loudspeaker","zh":"扩音器","tag":"📢","position":"-1150px 0px"}
     * u1F6AB : {"en":"Prohibited","zh":"禁止","tag":"🚫","position":"-1175px 0px"}
     * u1F6BF : {"en":"Shower","zh":"淋浴","tag":"🚿","position":"-1200px 0px"}
     * u1F30F : {"en":"Globe","zh":"地球","tag":"🌏","position":"-1225px 0px"}
     * u1F33B : {"en":"Sunflower","zh":"向日葵","tag":"🌻","position":"-1250px 0px"}
     * u1F35A : {"en":"Cooked Rice","zh":"米饭","tag":"🍚","position":"-1275px 0px"}
     * u1F36B : {"en":"Chocolate Bar","zh":"巧克力","tag":"🍫","position":"-1300px 0px"}
     * u1F37B : {"en":"Cheers","zh":"干杯","tag":"🍻","position":"-1325px 0px"}
     * u270A : {"en":"Oncoming Fist","zh":"击拳","tag":"👊","position":"-1350px 0px"}
     * u1F44C : {"en":"Ok Hand","zh":"没问题","tag":"👌","position":"-1375px 0px"}
     * u1F44D : {"en":"Thumbs Up","zh":"赞","tag":"👍","position":"-1400px 0px"}
     * u1F44E : {"en":"Thumbs Down","zh":"喝倒彩","tag":"👎","position":"-1425px 0px"}
     * u1F44F : {"en":"Clapping Hands","zh":"鼓掌","tag":"👏","position":"-1450px 0px"}
     * u1F46A : {"en":"Family","zh":"家庭","tag":"👪","position":"-1475px 0px"}
     * u1F46B : {"en":"Couple","zh":"情侣","tag":"👫","position":"-1500px 0px"}
     * u1F62C : {"en":"Grimacing Face","zh":"扮鬼脸","tag":"😬","position":"-2050px 0px"}
     * u1F47B : {"en":"Ghost","zh":"鬼","tag":"👻","position":"-1525px 0px"}
     * u1F47C : {"en":"Baby Angel","zh":"宝贝天使","tag":"👼","position":"-1550px 0px"}
     * u1F47D : {"en":"Alien","zh":"外星人","tag":"👽","position":"-1575px 0px"}
     * u1F47F : {"en":"Devil","zh":"恶魔","tag":"👿","position":"-1600px 0px"}
     * u1F48A : {"en":"Capsule","zh":"药","tag":"💊","position":"-1625px 0px"}
     * u1F48B : {"en":"Kiss","zh":"吻","tag":"💋","position":"-1650px 0px"}
     * u1F48D : {"en":"Ring","zh":"戒指","tag":"💍","position":"-1675px 0px"}
     * u1F52B : {"en":"Pistol","zh":"手枪","tag":"🔫","position":"-1700px 0px"}
     * u1F60A : {"en":"Smiley","zh":"微笑","tag":"😊","position":"-1725px 0px"}
     * u1F60B : {"en":"Hungry","zh":"馋","tag":"😋","position":"-1750px 0px"}
     * u1F60C : {"en":"Pleased","zh":"满意","tag":"😌","position":"-1775px 0px"}
     * u1F60D : {"en":"Heart Eyes","zh":"色迷迷","tag":"😍","position":"-1800px 0px"}
     * u1F60E : {"en":"Sunglasses","zh":"墨镜","tag":"😎","position":"-1825px 0px"}
     * u1F60F : {"en":"Smirking Face","zh":"傻笑","tag":"😏","position":"-1850px 0px"}
     * u1F61A : {"en":"Kiss Face","zh":"么么哒","tag":"😚","position":"-1875px 0px"}
     * u1F61C : {"en":"Crazy Face","zh":"调皮","tag":"😜","position":"-1900px 0px"}
     * u1F61D : {"en":"Tongue Out","zh":"吐舌头","tag":"😝","position":"-1925px 0px"}
     * u1F61E : {"en":"Disappointed Face","zh":"失望","tag":"😞","position":"-1950px 0px"}
     * u1F61F : {"en":"Worried Face","zh":"苦瓜脸","tag":"😟","position":"-1975px 0px"}
     * u1F62A : {"en":"Sleepy Face","zh":"困","tag":"😪","position":"-2000px 0px"}
     * u1F62B : {"en":"Tired Face","zh":"抓狂","tag":"😫","position":"-2025px 0px"}
     * u1F62D : {"en":"Crying","zh":"伤心","tag":"😢","position":"-425px 0px"}
     * u1F62F : {"en":"Surprised Face","zh":"惊呆","tag":"😯","position":"-2100px 0px"}
     * u1F64A : {"en":"No Speaking","zh":"闭嘴","tag":"🙊","position":"-2125px 0px"}
     * u1F64F : {"en":"Folded Hands","zh":"祈祷","tag":"🙏","position":"-2150px 0px"}
     * u1F319 : {"en":"Drescent Moon","zh":"弯月","tag":"🌙","position":"-2175px 0px"}
     * u1F332 : {"en":"Pine Tree","zh":"松树","tag":"🌲","position":"-2200px 0px"}
     * u1F339 : {"en":"Rose","zh":"玫瑰","tag":"🌹","position":"-2225px 0px"}
     * u1F349 : {"en":"Watermelon","zh":"西瓜","tag":"🍉","position":"-2250px 0px"}
     * u1F356 : {"en":"Barbecue","zh":"BBQ","tag":"🍖","position":"-2275px 0px"}
     * u1F366 : {"en":"Ice Cream","zh":"冰淇淋","tag":"🍦","position":"-2300px 0px"}
     * u1F377 : {"en":"Wine Glass","zh":"红酒","tag":"🍷","position":"-2325px 0px"}
     * u1F381 : {"en":"Wrapped Gift","zh":"礼物","tag":"🎁","position":"-2350px 0px"}
     * u1F382 : {"en":"Birthday Cake","zh":"生日蛋糕","tag":"🎂","position":"-2375px 0px"}
     * u1F384 : {"en":"Christmas Tree","zh":"圣诞树","tag":"🎄","position":"-2400px 0px"}
     * u1F389 : {"en":"Party Popper","zh":"聚会礼花","tag":"🎉","position":"-2425px 0px"}
     * u1F393 : {"en":"Graduation Cap","zh":"毕业帽","tag":"🎓","position":"-2450px 0px"}
     * u1F434 : {"en":"Horse","zh":"马","tag":"🐴","position":"-2475px 0px"}
     * u1F436 : {"en":"Dog","zh":"狗","tag":"🐶","position":"-2500px 0px"}
     * u1F437 : {"en":"Pig","zh":"猪","tag":"🐷","position":"-2525px 0px"}
     * u1F451 : {"en":"Crown","zh":"王冠","tag":"👑","position":"-2550px 0px"}
     * u1F484 : {"en":"Lipstick","zh":"口红","tag":"💄","position":"-2575px 0px"}
     * u1F494 : {"en":"Broken Heart","zh":"心碎","tag":"💔","position":"-2600px 0px"}
     * u1F525 : {"en":"Fire","zh":"火","tag":"🔥","position":"-2625px 0px"}
     * u1F556 : {"en":"Clock","zh":"表","tag":"🕖","position":"-2650px 0px"}
     * u1F648 : {"en":"See No Monkey","zh":"不看","tag":"🙈","position":"-2675px 0px"}
     * u1F649 : {"en":"Hear No Monkey","zh":"不听","tag":"🙉","position":"-2700px 0px"}
     * u1F680 : {"en":"Rocket","zh":"火箭","tag":"🚀","position":"-2725px 0px"}
     * u2B50 : {"en":"Star","zh":"星星","tag":"⭐","position":"-2750px 0px"}
     * u23F0 : {"en":"Alarm Clock","zh":"闹钟","tag":"⏰","position":"-2775px 0px"}
     * u23F3 : {"en":"Hourglass","zh":"沙漏","tag":"⏳","position":"-2800px 0px"}
     * u26A1 : {"en":"Lightning Bolt","zh":"闪电","tag":"⚡","position":"-2825px 0px"}
     * u26BD : {"en":"Soccer Ball","zh":"足球","tag":"⚽","position":"-2850px 0px"}
     * u26C4 : {"en":"Snowman","zh":"雪人","tag":"⛄","position":"-2875px 0px"}
     * u26C5 : {"en":"Cloudy","zh":"多云","tag":"⛅","position":"-2900px 0px"}
     * u261D : {"en":"Pointing Up","zh":"第一","tag":"☝","position":"-2925px 0px"}
     * u263A : {"en":"Cute","zh":"萌萌哒","tag":"☺","position":"-2950px 0px"}
     * u1F44A : {"en":"Raised Fist","zh":"举起拳头","tag":"✊","position":"-2975px 0px"}
     * u270B : {"en":"Raised Hand","zh":"举手","tag":"✋","position":"-3000px 0px"}
     * u270C : {"en":"Victory Hand","zh":"耶","tag":"✌","position":"-3025px 0px"}
     * u270F : {"en":"Pencil","zh":"铅笔","tag":"✏","position":"-3050px 0px"}
     * u2600 : {"en":"Sunny","zh":"晴朗","tag":"☀","position":"-3075px 0px"}
     * u2601 : {"en":"Cloud","zh":"云彩","tag":"☁","position":"-3100px 0px"}
     * u2614 : {"en":"Umbrella","zh":"雨伞","tag":"☔","position":"-3125px 0px"}
     * u2615 : {"en":"Coffee","zh":"咖啡","tag":"☕","position":"-3150px 0px"}
     * u2744 : {"en":"Snowflake","zh":"雪花","tag":"❄","position":"-3175px 0px"}
     */

    private U1F600Bean u1F600;
    private U1F601Bean u1F601;
    private U1F602Bean u1F602;
    private U1F603Bean u1F603;
    private U1F605Bean u1F605;
    private U1F606Bean u1F606;
    private U1F607Bean u1F607;
    private U1F608Bean u1F608;
    private U1F609Bean u1F609;
    private U1F611Bean u1F611;
    private U1F612Bean u1F612;
    private U1F613Bean u1F613;
    private U1F614Bean u1F614;
    private U1F615Bean u1F615;
    private U1F616Bean u1F616;
    private U1F618Bean u1F618;
    private U1F621Bean u1F621;
    private U1F622Bean u1F622;
    private U1F623Bean u1F623;
    private U1F624Bean u1F624;
    private U1F628Bean u1F628;
    private U1F629Bean u1F629;
    private U1F630Bean u1F630;
    private U1F631Bean u1F631;
    private U1F632Bean u1F632;
    private U1F633Bean u1F633;
    private U1F634Bean u1F634;
    private U1F635Bean u1F635;
    private U1F636Bean u1F636;
    private U1F637Bean u1F637;
    private U1F3A4Bean u1F3A4;
    private U1F3B2Bean u1F3B2;
    private U1F3B5Bean u1F3B5;
    private U1F3C0Bean u1F3C0;
    private U1F3C2Bean u1F3C2;
    private U1F3E1Bean u1F3E1;
    private U1F004Bean u1F004;
    private U1F4A1Bean u1F4A1;
    private U1F4A2Bean u1F4A2;
    private U1F4A3Bean u1F4A3;
    private U1F4A4Bean u1F4A4;
    private U1F4A9Bean u1F4A9;
    private U1F4AABean u1F4AA;
    private U1F4B0Bean u1F4B0;
    private U1F4DABean u1F4DA;
    private U1F4DEBean u1F4DE;
    private U1F4E2Bean u1F4E2;
    private U1F6ABBean u1F6AB;
    private U1F6BFBean u1F6BF;
    private U1F30FBean u1F30F;
    private U1F33BBean u1F33B;
    private U1F35ABean u1F35A;
    private U1F36BBean u1F36B;
    private U1F37BBean u1F37B;
    private U270ABean u270A;
    private U1F44CBean u1F44C;
    private U1F44DBean u1F44D;
    private U1F44EBean u1F44E;
    private U1F44FBean u1F44F;
    private U1F46ABean u1F46A;
    private U1F46BBean u1F46B;
    private U1F62CBean u1F62C;
    private U1F47BBean u1F47B;
    private U1F47CBean u1F47C;
    private U1F47DBean u1F47D;
    private U1F47FBean u1F47F;
    private U1F48ABean u1F48A;
    private U1F48BBean u1F48B;
    private U1F48DBean u1F48D;
    private U1F52BBean u1F52B;
    private U1F60ABean u1F60A;
    private U1F60BBean u1F60B;
    private U1F60CBean u1F60C;
    private U1F60DBean u1F60D;
    private U1F60EBean u1F60E;
    private U1F60FBean u1F60F;
    private U1F61ABean u1F61A;
    private U1F61CBean u1F61C;
    private U1F61DBean u1F61D;
    private U1F61EBean u1F61E;
    private U1F61FBean u1F61F;
    private U1F62ABean u1F62A;
    private U1F62BBean u1F62B;
    private U1F62DBean u1F62D;
    private U1F62FBean u1F62F;
    private U1F64ABean u1F64A;
    private U1F64FBean u1F64F;
    private U1F319Bean u1F319;
    private U1F332Bean u1F332;
    private U1F339Bean u1F339;
    private U1F349Bean u1F349;
    private U1F356Bean u1F356;
    private U1F366Bean u1F366;
    private U1F377Bean u1F377;
    private U1F381Bean u1F381;
    private U1F382Bean u1F382;
    private U1F384Bean u1F384;
    private U1F389Bean u1F389;
    private U1F393Bean u1F393;
    private U1F434Bean u1F434;
    private U1F436Bean u1F436;
    private U1F437Bean u1F437;
    private U1F451Bean u1F451;
    private U1F484Bean u1F484;
    private U1F494Bean u1F494;
    private U1F525Bean u1F525;
    private U1F556Bean u1F556;
    private U1F648Bean u1F648;
    private U1F649Bean u1F649;
    private U1F680Bean u1F680;
    private U2B50Bean u2B50;
    private U23F0Bean u23F0;
    private U23F3Bean u23F3;
    private U26A1Bean u26A1;
    private U26BDBean u26BD;
    private U26C4Bean u26C4;
    private U26C5Bean u26C5;
    private U261DBean u261D;
    private U263ABean u263A;
    private U1F44ABean u1F44A;
    private U270BBean u270B;
    private U270CBean u270C;
    private U270FBean u270F;
    private U2600Bean u2600;
    private U2601Bean u2601;
    private U2614Bean u2614;
    private U2615Bean u2615;
    private U2744Bean u2744;

    public U1F600Bean getU1F600() {
        return u1F600;
    }

    public void setU1F600(U1F600Bean u1F600) {
        this.u1F600 = u1F600;
    }

    public U1F601Bean getU1F601() {
        return u1F601;
    }

    public void setU1F601(U1F601Bean u1F601) {
        this.u1F601 = u1F601;
    }

    public U1F602Bean getU1F602() {
        return u1F602;
    }

    public void setU1F602(U1F602Bean u1F602) {
        this.u1F602 = u1F602;
    }

    public U1F603Bean getU1F603() {
        return u1F603;
    }

    public void setU1F603(U1F603Bean u1F603) {
        this.u1F603 = u1F603;
    }

    public U1F605Bean getU1F605() {
        return u1F605;
    }

    public void setU1F605(U1F605Bean u1F605) {
        this.u1F605 = u1F605;
    }

    public U1F606Bean getU1F606() {
        return u1F606;
    }

    public void setU1F606(U1F606Bean u1F606) {
        this.u1F606 = u1F606;
    }

    public U1F607Bean getU1F607() {
        return u1F607;
    }

    public void setU1F607(U1F607Bean u1F607) {
        this.u1F607 = u1F607;
    }

    public U1F608Bean getU1F608() {
        return u1F608;
    }

    public void setU1F608(U1F608Bean u1F608) {
        this.u1F608 = u1F608;
    }

    public U1F609Bean getU1F609() {
        return u1F609;
    }

    public void setU1F609(U1F609Bean u1F609) {
        this.u1F609 = u1F609;
    }

    public U1F611Bean getU1F611() {
        return u1F611;
    }

    public void setU1F611(U1F611Bean u1F611) {
        this.u1F611 = u1F611;
    }

    public U1F612Bean getU1F612() {
        return u1F612;
    }

    public void setU1F612(U1F612Bean u1F612) {
        this.u1F612 = u1F612;
    }

    public U1F613Bean getU1F613() {
        return u1F613;
    }

    public void setU1F613(U1F613Bean u1F613) {
        this.u1F613 = u1F613;
    }

    public U1F614Bean getU1F614() {
        return u1F614;
    }

    public void setU1F614(U1F614Bean u1F614) {
        this.u1F614 = u1F614;
    }

    public U1F615Bean getU1F615() {
        return u1F615;
    }

    public void setU1F615(U1F615Bean u1F615) {
        this.u1F615 = u1F615;
    }

    public U1F616Bean getU1F616() {
        return u1F616;
    }

    public void setU1F616(U1F616Bean u1F616) {
        this.u1F616 = u1F616;
    }

    public U1F618Bean getU1F618() {
        return u1F618;
    }

    public void setU1F618(U1F618Bean u1F618) {
        this.u1F618 = u1F618;
    }

    public U1F621Bean getU1F621() {
        return u1F621;
    }

    public void setU1F621(U1F621Bean u1F621) {
        this.u1F621 = u1F621;
    }

    public U1F622Bean getU1F622() {
        return u1F622;
    }

    public void setU1F622(U1F622Bean u1F622) {
        this.u1F622 = u1F622;
    }

    public U1F623Bean getU1F623() {
        return u1F623;
    }

    public void setU1F623(U1F623Bean u1F623) {
        this.u1F623 = u1F623;
    }

    public U1F624Bean getU1F624() {
        return u1F624;
    }

    public void setU1F624(U1F624Bean u1F624) {
        this.u1F624 = u1F624;
    }

    public U1F628Bean getU1F628() {
        return u1F628;
    }

    public void setU1F628(U1F628Bean u1F628) {
        this.u1F628 = u1F628;
    }

    public U1F629Bean getU1F629() {
        return u1F629;
    }

    public void setU1F629(U1F629Bean u1F629) {
        this.u1F629 = u1F629;
    }

    public U1F630Bean getU1F630() {
        return u1F630;
    }

    public void setU1F630(U1F630Bean u1F630) {
        this.u1F630 = u1F630;
    }

    public U1F631Bean getU1F631() {
        return u1F631;
    }

    public void setU1F631(U1F631Bean u1F631) {
        this.u1F631 = u1F631;
    }

    public U1F632Bean getU1F632() {
        return u1F632;
    }

    public void setU1F632(U1F632Bean u1F632) {
        this.u1F632 = u1F632;
    }

    public U1F633Bean getU1F633() {
        return u1F633;
    }

    public void setU1F633(U1F633Bean u1F633) {
        this.u1F633 = u1F633;
    }

    public U1F634Bean getU1F634() {
        return u1F634;
    }

    public void setU1F634(U1F634Bean u1F634) {
        this.u1F634 = u1F634;
    }

    public U1F635Bean getU1F635() {
        return u1F635;
    }

    public void setU1F635(U1F635Bean u1F635) {
        this.u1F635 = u1F635;
    }

    public U1F636Bean getU1F636() {
        return u1F636;
    }

    public void setU1F636(U1F636Bean u1F636) {
        this.u1F636 = u1F636;
    }

    public U1F637Bean getU1F637() {
        return u1F637;
    }

    public void setU1F637(U1F637Bean u1F637) {
        this.u1F637 = u1F637;
    }

    public U1F3A4Bean getU1F3A4() {
        return u1F3A4;
    }

    public void setU1F3A4(U1F3A4Bean u1F3A4) {
        this.u1F3A4 = u1F3A4;
    }

    public U1F3B2Bean getU1F3B2() {
        return u1F3B2;
    }

    public void setU1F3B2(U1F3B2Bean u1F3B2) {
        this.u1F3B2 = u1F3B2;
    }

    public U1F3B5Bean getU1F3B5() {
        return u1F3B5;
    }

    public void setU1F3B5(U1F3B5Bean u1F3B5) {
        this.u1F3B5 = u1F3B5;
    }

    public U1F3C0Bean getU1F3C0() {
        return u1F3C0;
    }

    public void setU1F3C0(U1F3C0Bean u1F3C0) {
        this.u1F3C0 = u1F3C0;
    }

    public U1F3C2Bean getU1F3C2() {
        return u1F3C2;
    }

    public void setU1F3C2(U1F3C2Bean u1F3C2) {
        this.u1F3C2 = u1F3C2;
    }

    public U1F3E1Bean getU1F3E1() {
        return u1F3E1;
    }

    public void setU1F3E1(U1F3E1Bean u1F3E1) {
        this.u1F3E1 = u1F3E1;
    }

    public U1F004Bean getU1F004() {
        return u1F004;
    }

    public void setU1F004(U1F004Bean u1F004) {
        this.u1F004 = u1F004;
    }

    public U1F4A1Bean getU1F4A1() {
        return u1F4A1;
    }

    public void setU1F4A1(U1F4A1Bean u1F4A1) {
        this.u1F4A1 = u1F4A1;
    }

    public U1F4A2Bean getU1F4A2() {
        return u1F4A2;
    }

    public void setU1F4A2(U1F4A2Bean u1F4A2) {
        this.u1F4A2 = u1F4A2;
    }

    public U1F4A3Bean getU1F4A3() {
        return u1F4A3;
    }

    public void setU1F4A3(U1F4A3Bean u1F4A3) {
        this.u1F4A3 = u1F4A3;
    }

    public U1F4A4Bean getU1F4A4() {
        return u1F4A4;
    }

    public void setU1F4A4(U1F4A4Bean u1F4A4) {
        this.u1F4A4 = u1F4A4;
    }

    public U1F4A9Bean getU1F4A9() {
        return u1F4A9;
    }

    public void setU1F4A9(U1F4A9Bean u1F4A9) {
        this.u1F4A9 = u1F4A9;
    }

    public U1F4AABean getU1F4AA() {
        return u1F4AA;
    }

    public void setU1F4AA(U1F4AABean u1F4AA) {
        this.u1F4AA = u1F4AA;
    }

    public U1F4B0Bean getU1F4B0() {
        return u1F4B0;
    }

    public void setU1F4B0(U1F4B0Bean u1F4B0) {
        this.u1F4B0 = u1F4B0;
    }

    public U1F4DABean getU1F4DA() {
        return u1F4DA;
    }

    public void setU1F4DA(U1F4DABean u1F4DA) {
        this.u1F4DA = u1F4DA;
    }

    public U1F4DEBean getU1F4DE() {
        return u1F4DE;
    }

    public void setU1F4DE(U1F4DEBean u1F4DE) {
        this.u1F4DE = u1F4DE;
    }

    public U1F4E2Bean getU1F4E2() {
        return u1F4E2;
    }

    public void setU1F4E2(U1F4E2Bean u1F4E2) {
        this.u1F4E2 = u1F4E2;
    }

    public U1F6ABBean getU1F6AB() {
        return u1F6AB;
    }

    public void setU1F6AB(U1F6ABBean u1F6AB) {
        this.u1F6AB = u1F6AB;
    }

    public U1F6BFBean getU1F6BF() {
        return u1F6BF;
    }

    public void setU1F6BF(U1F6BFBean u1F6BF) {
        this.u1F6BF = u1F6BF;
    }

    public U1F30FBean getU1F30F() {
        return u1F30F;
    }

    public void setU1F30F(U1F30FBean u1F30F) {
        this.u1F30F = u1F30F;
    }

    public U1F33BBean getU1F33B() {
        return u1F33B;
    }

    public void setU1F33B(U1F33BBean u1F33B) {
        this.u1F33B = u1F33B;
    }

    public U1F35ABean getU1F35A() {
        return u1F35A;
    }

    public void setU1F35A(U1F35ABean u1F35A) {
        this.u1F35A = u1F35A;
    }

    public U1F36BBean getU1F36B() {
        return u1F36B;
    }

    public void setU1F36B(U1F36BBean u1F36B) {
        this.u1F36B = u1F36B;
    }

    public U1F37BBean getU1F37B() {
        return u1F37B;
    }

    public void setU1F37B(U1F37BBean u1F37B) {
        this.u1F37B = u1F37B;
    }

    public U270ABean getU270A() {
        return u270A;
    }

    public void setU270A(U270ABean u270A) {
        this.u270A = u270A;
    }

    public U1F44CBean getU1F44C() {
        return u1F44C;
    }

    public void setU1F44C(U1F44CBean u1F44C) {
        this.u1F44C = u1F44C;
    }

    public U1F44DBean getU1F44D() {
        return u1F44D;
    }

    public void setU1F44D(U1F44DBean u1F44D) {
        this.u1F44D = u1F44D;
    }

    public U1F44EBean getU1F44E() {
        return u1F44E;
    }

    public void setU1F44E(U1F44EBean u1F44E) {
        this.u1F44E = u1F44E;
    }

    public U1F44FBean getU1F44F() {
        return u1F44F;
    }

    public void setU1F44F(U1F44FBean u1F44F) {
        this.u1F44F = u1F44F;
    }

    public U1F46ABean getU1F46A() {
        return u1F46A;
    }

    public void setU1F46A(U1F46ABean u1F46A) {
        this.u1F46A = u1F46A;
    }

    public U1F46BBean getU1F46B() {
        return u1F46B;
    }

    public void setU1F46B(U1F46BBean u1F46B) {
        this.u1F46B = u1F46B;
    }

    public U1F62CBean getU1F62C() {
        return u1F62C;
    }

    public void setU1F62C(U1F62CBean u1F62C) {
        this.u1F62C = u1F62C;
    }

    public U1F47BBean getU1F47B() {
        return u1F47B;
    }

    public void setU1F47B(U1F47BBean u1F47B) {
        this.u1F47B = u1F47B;
    }

    public U1F47CBean getU1F47C() {
        return u1F47C;
    }

    public void setU1F47C(U1F47CBean u1F47C) {
        this.u1F47C = u1F47C;
    }

    public U1F47DBean getU1F47D() {
        return u1F47D;
    }

    public void setU1F47D(U1F47DBean u1F47D) {
        this.u1F47D = u1F47D;
    }

    public U1F47FBean getU1F47F() {
        return u1F47F;
    }

    public void setU1F47F(U1F47FBean u1F47F) {
        this.u1F47F = u1F47F;
    }

    public U1F48ABean getU1F48A() {
        return u1F48A;
    }

    public void setU1F48A(U1F48ABean u1F48A) {
        this.u1F48A = u1F48A;
    }

    public U1F48BBean getU1F48B() {
        return u1F48B;
    }

    public void setU1F48B(U1F48BBean u1F48B) {
        this.u1F48B = u1F48B;
    }

    public U1F48DBean getU1F48D() {
        return u1F48D;
    }

    public void setU1F48D(U1F48DBean u1F48D) {
        this.u1F48D = u1F48D;
    }

    public U1F52BBean getU1F52B() {
        return u1F52B;
    }

    public void setU1F52B(U1F52BBean u1F52B) {
        this.u1F52B = u1F52B;
    }

    public U1F60ABean getU1F60A() {
        return u1F60A;
    }

    public void setU1F60A(U1F60ABean u1F60A) {
        this.u1F60A = u1F60A;
    }

    public U1F60BBean getU1F60B() {
        return u1F60B;
    }

    public void setU1F60B(U1F60BBean u1F60B) {
        this.u1F60B = u1F60B;
    }

    public U1F60CBean getU1F60C() {
        return u1F60C;
    }

    public void setU1F60C(U1F60CBean u1F60C) {
        this.u1F60C = u1F60C;
    }

    public U1F60DBean getU1F60D() {
        return u1F60D;
    }

    public void setU1F60D(U1F60DBean u1F60D) {
        this.u1F60D = u1F60D;
    }

    public U1F60EBean getU1F60E() {
        return u1F60E;
    }

    public void setU1F60E(U1F60EBean u1F60E) {
        this.u1F60E = u1F60E;
    }

    public U1F60FBean getU1F60F() {
        return u1F60F;
    }

    public void setU1F60F(U1F60FBean u1F60F) {
        this.u1F60F = u1F60F;
    }

    public U1F61ABean getU1F61A() {
        return u1F61A;
    }

    public void setU1F61A(U1F61ABean u1F61A) {
        this.u1F61A = u1F61A;
    }

    public U1F61CBean getU1F61C() {
        return u1F61C;
    }

    public void setU1F61C(U1F61CBean u1F61C) {
        this.u1F61C = u1F61C;
    }

    public U1F61DBean getU1F61D() {
        return u1F61D;
    }

    public void setU1F61D(U1F61DBean u1F61D) {
        this.u1F61D = u1F61D;
    }

    public U1F61EBean getU1F61E() {
        return u1F61E;
    }

    public void setU1F61E(U1F61EBean u1F61E) {
        this.u1F61E = u1F61E;
    }

    public U1F61FBean getU1F61F() {
        return u1F61F;
    }

    public void setU1F61F(U1F61FBean u1F61F) {
        this.u1F61F = u1F61F;
    }

    public U1F62ABean getU1F62A() {
        return u1F62A;
    }

    public void setU1F62A(U1F62ABean u1F62A) {
        this.u1F62A = u1F62A;
    }

    public U1F62BBean getU1F62B() {
        return u1F62B;
    }

    public void setU1F62B(U1F62BBean u1F62B) {
        this.u1F62B = u1F62B;
    }

    public U1F62DBean getU1F62D() {
        return u1F62D;
    }

    public void setU1F62D(U1F62DBean u1F62D) {
        this.u1F62D = u1F62D;
    }

    public U1F62FBean getU1F62F() {
        return u1F62F;
    }

    public void setU1F62F(U1F62FBean u1F62F) {
        this.u1F62F = u1F62F;
    }

    public U1F64ABean getU1F64A() {
        return u1F64A;
    }

    public void setU1F64A(U1F64ABean u1F64A) {
        this.u1F64A = u1F64A;
    }

    public U1F64FBean getU1F64F() {
        return u1F64F;
    }

    public void setU1F64F(U1F64FBean u1F64F) {
        this.u1F64F = u1F64F;
    }

    public U1F319Bean getU1F319() {
        return u1F319;
    }

    public void setU1F319(U1F319Bean u1F319) {
        this.u1F319 = u1F319;
    }

    public U1F332Bean getU1F332() {
        return u1F332;
    }

    public void setU1F332(U1F332Bean u1F332) {
        this.u1F332 = u1F332;
    }

    public U1F339Bean getU1F339() {
        return u1F339;
    }

    public void setU1F339(U1F339Bean u1F339) {
        this.u1F339 = u1F339;
    }

    public U1F349Bean getU1F349() {
        return u1F349;
    }

    public void setU1F349(U1F349Bean u1F349) {
        this.u1F349 = u1F349;
    }

    public U1F356Bean getU1F356() {
        return u1F356;
    }

    public void setU1F356(U1F356Bean u1F356) {
        this.u1F356 = u1F356;
    }

    public U1F366Bean getU1F366() {
        return u1F366;
    }

    public void setU1F366(U1F366Bean u1F366) {
        this.u1F366 = u1F366;
    }

    public U1F377Bean getU1F377() {
        return u1F377;
    }

    public void setU1F377(U1F377Bean u1F377) {
        this.u1F377 = u1F377;
    }

    public U1F381Bean getU1F381() {
        return u1F381;
    }

    public void setU1F381(U1F381Bean u1F381) {
        this.u1F381 = u1F381;
    }

    public U1F382Bean getU1F382() {
        return u1F382;
    }

    public void setU1F382(U1F382Bean u1F382) {
        this.u1F382 = u1F382;
    }

    public U1F384Bean getU1F384() {
        return u1F384;
    }

    public void setU1F384(U1F384Bean u1F384) {
        this.u1F384 = u1F384;
    }

    public U1F389Bean getU1F389() {
        return u1F389;
    }

    public void setU1F389(U1F389Bean u1F389) {
        this.u1F389 = u1F389;
    }

    public U1F393Bean getU1F393() {
        return u1F393;
    }

    public void setU1F393(U1F393Bean u1F393) {
        this.u1F393 = u1F393;
    }

    public U1F434Bean getU1F434() {
        return u1F434;
    }

    public void setU1F434(U1F434Bean u1F434) {
        this.u1F434 = u1F434;
    }

    public U1F436Bean getU1F436() {
        return u1F436;
    }

    public void setU1F436(U1F436Bean u1F436) {
        this.u1F436 = u1F436;
    }

    public U1F437Bean getU1F437() {
        return u1F437;
    }

    public void setU1F437(U1F437Bean u1F437) {
        this.u1F437 = u1F437;
    }

    public U1F451Bean getU1F451() {
        return u1F451;
    }

    public void setU1F451(U1F451Bean u1F451) {
        this.u1F451 = u1F451;
    }

    public U1F484Bean getU1F484() {
        return u1F484;
    }

    public void setU1F484(U1F484Bean u1F484) {
        this.u1F484 = u1F484;
    }

    public U1F494Bean getU1F494() {
        return u1F494;
    }

    public void setU1F494(U1F494Bean u1F494) {
        this.u1F494 = u1F494;
    }

    public U1F525Bean getU1F525() {
        return u1F525;
    }

    public void setU1F525(U1F525Bean u1F525) {
        this.u1F525 = u1F525;
    }

    public U1F556Bean getU1F556() {
        return u1F556;
    }

    public void setU1F556(U1F556Bean u1F556) {
        this.u1F556 = u1F556;
    }

    public U1F648Bean getU1F648() {
        return u1F648;
    }

    public void setU1F648(U1F648Bean u1F648) {
        this.u1F648 = u1F648;
    }

    public U1F649Bean getU1F649() {
        return u1F649;
    }

    public void setU1F649(U1F649Bean u1F649) {
        this.u1F649 = u1F649;
    }

    public U1F680Bean getU1F680() {
        return u1F680;
    }

    public void setU1F680(U1F680Bean u1F680) {
        this.u1F680 = u1F680;
    }

    public U2B50Bean getU2B50() {
        return u2B50;
    }

    public void setU2B50(U2B50Bean u2B50) {
        this.u2B50 = u2B50;
    }

    public U23F0Bean getU23F0() {
        return u23F0;
    }

    public void setU23F0(U23F0Bean u23F0) {
        this.u23F0 = u23F0;
    }

    public U23F3Bean getU23F3() {
        return u23F3;
    }

    public void setU23F3(U23F3Bean u23F3) {
        this.u23F3 = u23F3;
    }

    public U26A1Bean getU26A1() {
        return u26A1;
    }

    public void setU26A1(U26A1Bean u26A1) {
        this.u26A1 = u26A1;
    }

    public U26BDBean getU26BD() {
        return u26BD;
    }

    public void setU26BD(U26BDBean u26BD) {
        this.u26BD = u26BD;
    }

    public U26C4Bean getU26C4() {
        return u26C4;
    }

    public void setU26C4(U26C4Bean u26C4) {
        this.u26C4 = u26C4;
    }

    public U26C5Bean getU26C5() {
        return u26C5;
    }

    public void setU26C5(U26C5Bean u26C5) {
        this.u26C5 = u26C5;
    }

    public U261DBean getU261D() {
        return u261D;
    }

    public void setU261D(U261DBean u261D) {
        this.u261D = u261D;
    }

    public U263ABean getU263A() {
        return u263A;
    }

    public void setU263A(U263ABean u263A) {
        this.u263A = u263A;
    }

    public U1F44ABean getU1F44A() {
        return u1F44A;
    }

    public void setU1F44A(U1F44ABean u1F44A) {
        this.u1F44A = u1F44A;
    }

    public U270BBean getU270B() {
        return u270B;
    }

    public void setU270B(U270BBean u270B) {
        this.u270B = u270B;
    }

    public U270CBean getU270C() {
        return u270C;
    }

    public void setU270C(U270CBean u270C) {
        this.u270C = u270C;
    }

    public U270FBean getU270F() {
        return u270F;
    }

    public void setU270F(U270FBean u270F) {
        this.u270F = u270F;
    }

    public U2600Bean getU2600() {
        return u2600;
    }

    public void setU2600(U2600Bean u2600) {
        this.u2600 = u2600;
    }

    public U2601Bean getU2601() {
        return u2601;
    }

    public void setU2601(U2601Bean u2601) {
        this.u2601 = u2601;
    }

    public U2614Bean getU2614() {
        return u2614;
    }

    public void setU2614(U2614Bean u2614) {
        this.u2614 = u2614;
    }

    public U2615Bean getU2615() {
        return u2615;
    }

    public void setU2615(U2615Bean u2615) {
        this.u2615 = u2615;
    }

    public U2744Bean getU2744() {
        return u2744;
    }

    public void setU2744(U2744Bean u2744) {
        this.u2744 = u2744;
    }

    public static class U1F600Bean {
        /**
         * en : Grinning Face
         * zh : 笑嘻嘻
         * tag : 😀
         * position : 0px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F601Bean {
        /**
         * en : Grinning With Smiling
         * zh : 露齿而笑
         * tag : 😁
         * position : -25px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F602Bean {
        /**
         * en : Laughing Tears
         * zh : 喜极而泣
         * tag : 😂
         * position : -50px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F603Bean {
        /**
         * en : Smiley Face
         * zh : 笑脸
         * tag : 😃
         * position : -75px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F605Bean {
        /**
         * en : Happy Sweat
         * zh : 尴尬
         * tag : 😅
         * position : -100px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F606Bean {
        /**
         * en : Big Grin
         * zh : 大笑
         * tag : 😆
         * position : -125px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F607Bean {
        /**
         * en : Halo
         * zh : 天使光环
         * tag : 😇
         * position : -150px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F608Bean {
        /**
         * en : Purple Devil
         * zh : 小恶魔
         * tag : 😈
         * position : -175px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F609Bean {
        /**
         * en : Winking Face
         * zh : 眨眼
         * tag : 😉
         * position : -200px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F611Bean {
        /**
         * en : Expressionless Face
         * zh : 面无表情
         * tag : 😑
         * position : -225px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F612Bean {
        /**
         * en : Dissatisfied
         * zh : 不满
         * tag : 😒
         * position : -250px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F613Bean {
        /**
         * en : Sweat
         * zh : 汗
         * tag : 😓
         * position : -275px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F614Bean {
        /**
         * en : Pensive
         * zh : 沉思
         * tag : 😔
         * position : -300px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F615Bean {
        /**
         * en : Confused
         * zh : 困惑
         * tag : 😕
         * position : -325px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F616Bean {
        /**
         * en : Confounded Face
         * zh : 蒙羞
         * tag : 😖
         * position : -350px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F618Bean {
        /**
         * en : Blowing Kiss
         * zh : 飞吻
         * tag : 😘
         * position : -375px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F621Bean {
        /**
         * en : Angry Face
         * zh : 生气
         * tag : 😡
         * position : -400px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F622Bean {
        /**
         * en : Sobbing
         * zh : 哭泣
         * tag : 😭
         * position : -2075px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F623Bean {
        /**
         * en : Helpless Face
         * zh : 无助
         * tag : 😣
         * position : -450px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F624Bean {
        /**
         * en : Mad Face
         * zh : 怒气冲冲
         * tag : 😤
         * position : -475px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F628Bean {
        /**
         * en : Fearful Face
         * zh : 可怕
         * tag : 😨
         * position : -500px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F629Bean {
        /**
         * en : Weary Face
         * zh : 疲惫
         * tag : 😩
         * position : -525px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F630Bean {
        /**
         * en : Cold Sweat
         * zh : 冷汗
         * tag : 😰
         * position : -550px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F631Bean {
        /**
         * en : Scream
         * zh : 尖叫
         * tag : 😱
         * position : -575px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F632Bean {
        /**
         * en : Shocked Face
         * zh : 震惊
         * tag : 😲
         * position : -600px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F633Bean {
        /**
         * en : Flushed Face
         * zh : 脸红
         * tag : 😳
         * position : -625px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F634Bean {
        /**
         * en : Sleeping
         * zh : 睡眠
         * tag : 😴
         * position : -650px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F635Bean {
        /**
         * en : Dizzy Face
         * zh : 头晕眼花
         * tag : 😵
         * position : -675px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F636Bean {
        /**
         * en : Mouthless
         * zh : 无口
         * tag : 😶
         * position : -700px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F637Bean {
        /**
         * en : Mask Face
         * zh : 口罩
         * tag : 😷
         * position : -725px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3A4Bean {
        /**
         * en : Microphone
         * zh : 麦克风
         * tag : 🎤
         * position : -750px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3B2Bean {
        /**
         * en : Game Die
         * zh : 骰子
         * tag : 🎲
         * position : -775px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3B5Bean {
        /**
         * en : Musical Note
         * zh : 音乐
         * tag : 🎵
         * position : -800px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3C0Bean {
        /**
         * en : Basketball
         * zh : 篮球
         * tag : 🏀
         * position : -825px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3C2Bean {
        /**
         * en : Snowboarder
         * zh : 单板滑雪
         * tag : 🏂
         * position : -850px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F3E1Bean {
        /**
         * en : House With Garden
         * zh : 房子
         * tag : 🏡
         * position : -875px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F004Bean {
        /**
         * en : Mahjong Red Dragon
         * zh : 麻将
         * tag : 🀄
         * position : -900px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4A1Bean {
        /**
         * en : Light Bulb
         * zh : 灯泡
         * tag : 💡
         * position : -925px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4A2Bean {
        /**
         * en : Anger
         * zh : 愤怒
         * tag : 💢
         * position : -950px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4A3Bean {
        /**
         * en : Bomb
         * zh : 炸弹
         * tag : 💣
         * position : -975px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4A4Bean {
        /**
         * en : Zzz
         * zh : ZZZ
         * tag : 💤
         * position : -1000px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4A9Bean {
        /**
         * en : Pile Of Poo
         * zh : 便便
         * tag : 💩
         * position : -1025px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4AABean {
        /**
         * en : Flexed Biceps
         * zh : 肌肉
         * tag : 💪
         * position : -1050px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4B0Bean {
        /**
         * en : Money Bag
         * zh : 钱袋
         * tag : 💰
         * position : -1075px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4DABean {
        /**
         * en : Books
         * zh : 书籍
         * tag : 📚
         * position : -1100px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4DEBean {
        /**
         * en : Telephone Receiver
         * zh : 电话听筒
         * tag : 📞
         * position : -1125px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F4E2Bean {
        /**
         * en : Loudspeaker
         * zh : 扩音器
         * tag : 📢
         * position : -1150px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F6ABBean {
        /**
         * en : Prohibited
         * zh : 禁止
         * tag : 🚫
         * position : -1175px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F6BFBean {
        /**
         * en : Shower
         * zh : 淋浴
         * tag : 🚿
         * position : -1200px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F30FBean {
        /**
         * en : Globe
         * zh : 地球
         * tag : 🌏
         * position : -1225px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F33BBean {
        /**
         * en : Sunflower
         * zh : 向日葵
         * tag : 🌻
         * position : -1250px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F35ABean {
        /**
         * en : Cooked Rice
         * zh : 米饭
         * tag : 🍚
         * position : -1275px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F36BBean {
        /**
         * en : Chocolate Bar
         * zh : 巧克力
         * tag : 🍫
         * position : -1300px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F37BBean {
        /**
         * en : Cheers
         * zh : 干杯
         * tag : 🍻
         * position : -1325px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U270ABean {
        /**
         * en : Oncoming Fist
         * zh : 击拳
         * tag : 👊
         * position : -1350px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F44CBean {
        /**
         * en : Ok Hand
         * zh : 没问题
         * tag : 👌
         * position : -1375px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F44DBean {
        /**
         * en : Thumbs Up
         * zh : 赞
         * tag : 👍
         * position : -1400px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F44EBean {
        /**
         * en : Thumbs Down
         * zh : 喝倒彩
         * tag : 👎
         * position : -1425px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F44FBean {
        /**
         * en : Clapping Hands
         * zh : 鼓掌
         * tag : 👏
         * position : -1450px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F46ABean {
        /**
         * en : Family
         * zh : 家庭
         * tag : 👪
         * position : -1475px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F46BBean {
        /**
         * en : Couple
         * zh : 情侣
         * tag : 👫
         * position : -1500px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F62CBean {
        /**
         * en : Grimacing Face
         * zh : 扮鬼脸
         * tag : 😬
         * position : -2050px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F47BBean {
        /**
         * en : Ghost
         * zh : 鬼
         * tag : 👻
         * position : -1525px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F47CBean {
        /**
         * en : Baby Angel
         * zh : 宝贝天使
         * tag : 👼
         * position : -1550px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F47DBean {
        /**
         * en : Alien
         * zh : 外星人
         * tag : 👽
         * position : -1575px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F47FBean {
        /**
         * en : Devil
         * zh : 恶魔
         * tag : 👿
         * position : -1600px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F48ABean {
        /**
         * en : Capsule
         * zh : 药
         * tag : 💊
         * position : -1625px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F48BBean {
        /**
         * en : Kiss
         * zh : 吻
         * tag : 💋
         * position : -1650px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F48DBean {
        /**
         * en : Ring
         * zh : 戒指
         * tag : 💍
         * position : -1675px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F52BBean {
        /**
         * en : Pistol
         * zh : 手枪
         * tag : 🔫
         * position : -1700px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60ABean {
        /**
         * en : Smiley
         * zh : 微笑
         * tag : 😊
         * position : -1725px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60BBean {
        /**
         * en : Hungry
         * zh : 馋
         * tag : 😋
         * position : -1750px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60CBean {
        /**
         * en : Pleased
         * zh : 满意
         * tag : 😌
         * position : -1775px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60DBean {
        /**
         * en : Heart Eyes
         * zh : 色迷迷
         * tag : 😍
         * position : -1800px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60EBean {
        /**
         * en : Sunglasses
         * zh : 墨镜
         * tag : 😎
         * position : -1825px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F60FBean {
        /**
         * en : Smirking Face
         * zh : 傻笑
         * tag : 😏
         * position : -1850px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F61ABean {
        /**
         * en : Kiss Face
         * zh : 么么哒
         * tag : 😚
         * position : -1875px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F61CBean {
        /**
         * en : Crazy Face
         * zh : 调皮
         * tag : 😜
         * position : -1900px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F61DBean {
        /**
         * en : Tongue Out
         * zh : 吐舌头
         * tag : 😝
         * position : -1925px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F61EBean {
        /**
         * en : Disappointed Face
         * zh : 失望
         * tag : 😞
         * position : -1950px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F61FBean {
        /**
         * en : Worried Face
         * zh : 苦瓜脸
         * tag : 😟
         * position : -1975px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F62ABean {
        /**
         * en : Sleepy Face
         * zh : 困
         * tag : 😪
         * position : -2000px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F62BBean {
        /**
         * en : Tired Face
         * zh : 抓狂
         * tag : 😫
         * position : -2025px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F62DBean {
        /**
         * en : Crying
         * zh : 伤心
         * tag : 😢
         * position : -425px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F62FBean {
        /**
         * en : Surprised Face
         * zh : 惊呆
         * tag : 😯
         * position : -2100px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F64ABean {
        /**
         * en : No Speaking
         * zh : 闭嘴
         * tag : 🙊
         * position : -2125px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F64FBean {
        /**
         * en : Folded Hands
         * zh : 祈祷
         * tag : 🙏
         * position : -2150px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F319Bean {
        /**
         * en : Drescent Moon
         * zh : 弯月
         * tag : 🌙
         * position : -2175px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F332Bean {
        /**
         * en : Pine Tree
         * zh : 松树
         * tag : 🌲
         * position : -2200px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F339Bean {
        /**
         * en : Rose
         * zh : 玫瑰
         * tag : 🌹
         * position : -2225px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F349Bean {
        /**
         * en : Watermelon
         * zh : 西瓜
         * tag : 🍉
         * position : -2250px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F356Bean {
        /**
         * en : Barbecue
         * zh : BBQ
         * tag : 🍖
         * position : -2275px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F366Bean {
        /**
         * en : Ice Cream
         * zh : 冰淇淋
         * tag : 🍦
         * position : -2300px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F377Bean {
        /**
         * en : Wine Glass
         * zh : 红酒
         * tag : 🍷
         * position : -2325px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F381Bean {
        /**
         * en : Wrapped Gift
         * zh : 礼物
         * tag : 🎁
         * position : -2350px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F382Bean {
        /**
         * en : Birthday Cake
         * zh : 生日蛋糕
         * tag : 🎂
         * position : -2375px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F384Bean {
        /**
         * en : Christmas Tree
         * zh : 圣诞树
         * tag : 🎄
         * position : -2400px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F389Bean {
        /**
         * en : Party Popper
         * zh : 聚会礼花
         * tag : 🎉
         * position : -2425px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F393Bean {
        /**
         * en : Graduation Cap
         * zh : 毕业帽
         * tag : 🎓
         * position : -2450px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F434Bean {
        /**
         * en : Horse
         * zh : 马
         * tag : 🐴
         * position : -2475px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F436Bean {
        /**
         * en : Dog
         * zh : 狗
         * tag : 🐶
         * position : -2500px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F437Bean {
        /**
         * en : Pig
         * zh : 猪
         * tag : 🐷
         * position : -2525px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F451Bean {
        /**
         * en : Crown
         * zh : 王冠
         * tag : 👑
         * position : -2550px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F484Bean {
        /**
         * en : Lipstick
         * zh : 口红
         * tag : 💄
         * position : -2575px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F494Bean {
        /**
         * en : Broken Heart
         * zh : 心碎
         * tag : 💔
         * position : -2600px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F525Bean {
        /**
         * en : Fire
         * zh : 火
         * tag : 🔥
         * position : -2625px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F556Bean {
        /**
         * en : Clock
         * zh : 表
         * tag : 🕖
         * position : -2650px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F648Bean {
        /**
         * en : See No Monkey
         * zh : 不看
         * tag : 🙈
         * position : -2675px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F649Bean {
        /**
         * en : Hear No Monkey
         * zh : 不听
         * tag : 🙉
         * position : -2700px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F680Bean {
        /**
         * en : Rocket
         * zh : 火箭
         * tag : 🚀
         * position : -2725px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2B50Bean {
        /**
         * en : Star
         * zh : 星星
         * tag : ⭐
         * position : -2750px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U23F0Bean {
        /**
         * en : Alarm Clock
         * zh : 闹钟
         * tag : ⏰
         * position : -2775px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U23F3Bean {
        /**
         * en : Hourglass
         * zh : 沙漏
         * tag : ⏳
         * position : -2800px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U26A1Bean {
        /**
         * en : Lightning Bolt
         * zh : 闪电
         * tag : ⚡
         * position : -2825px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U26BDBean {
        /**
         * en : Soccer Ball
         * zh : 足球
         * tag : ⚽
         * position : -2850px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U26C4Bean {
        /**
         * en : Snowman
         * zh : 雪人
         * tag : ⛄
         * position : -2875px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U26C5Bean {
        /**
         * en : Cloudy
         * zh : 多云
         * tag : ⛅
         * position : -2900px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U261DBean {
        /**
         * en : Pointing Up
         * zh : 第一
         * tag : ☝
         * position : -2925px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U263ABean {
        /**
         * en : Cute
         * zh : 萌萌哒
         * tag : ☺
         * position : -2950px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U1F44ABean {
        /**
         * en : Raised Fist
         * zh : 举起拳头
         * tag : ✊
         * position : -2975px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U270BBean {
        /**
         * en : Raised Hand
         * zh : 举手
         * tag : ✋
         * position : -3000px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U270CBean {
        /**
         * en : Victory Hand
         * zh : 耶
         * tag : ✌
         * position : -3025px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U270FBean {
        /**
         * en : Pencil
         * zh : 铅笔
         * tag : ✏
         * position : -3050px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2600Bean {
        /**
         * en : Sunny
         * zh : 晴朗
         * tag : ☀
         * position : -3075px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2601Bean {
        /**
         * en : Cloud
         * zh : 云彩
         * tag : ☁
         * position : -3100px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2614Bean {
        /**
         * en : Umbrella
         * zh : 雨伞
         * tag : ☔
         * position : -3125px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2615Bean {
        /**
         * en : Coffee
         * zh : 咖啡
         * tag : ☕
         * position : -3150px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class U2744Bean {
        /**
         * en : Snowflake
         * zh : 雪花
         * tag : ❄
         * position : -3175px 0px
         */

        private String en;
        private String zh;
        private String tag;
        private String position;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getZh() {
            return zh;
        }

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
