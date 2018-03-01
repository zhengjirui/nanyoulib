package com.nytechnology.nyimlib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 18513 on 2018/1/27.
 */
public class RegexDemoTest {

    @Test
    public void start(){
        RegexDemo regexDemo = new RegexDemo();
//        regexDemo.EmojiToString("");
//        regexDemo.StringToEmoji("");
        regexDemo.getUnicode();


        // 创建一个正则表达式模式
        String patt = "\\s*\\uD83D\\uDE00|\\uD83D\\uDE01|\\uD83D\\uDE02|\\uD83D\\uDE0A";

        // 用于测试的输入字符串
        String input = "lkj\uD83D\uDE0A";

//        regexDemo.getDivision(input,patt);
//        regexDemo.getString("ming tian jiu yao fangjia le ","\\b\\w{3}\\b");
    }
}