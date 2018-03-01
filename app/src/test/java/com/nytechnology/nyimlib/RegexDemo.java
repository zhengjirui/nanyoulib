package com.nytechnology.nyimlib;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 18513 on 2018/1/27.
 */

public class RegexDemo {

    public void EmojiToString(String content) {
        // 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
        String patt = "\\s*\\uD83D\\uDE00|\\uD83D\\uDE01|\\uD83D\\uDE02|\\uD83D\\uDE0A";

        // 用于测试的输入字符串
        String input = "我是消息\uD83D\uDE0A";
        System.out.println("原始字符:" + input);

        // 从正则表达式实例中运行方法并查看其如何运行
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(input);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String groupEmoji = m.group();//得到从正则中得到匹配后的表情
            System.out.println("得到从正则中得到匹配后的表情：" + groupEmoji);

            String unicodeString = stringToUnicode(groupEmoji);//把表情反转成unicode字符串
            System.out.println("把表情反转成unicode字符串：" + unicodeString);

            String replace = unicodeString.replace("\\", "").toUpperCase();//把对应的unicodeString去掉反斜杠
            System.out.println("把对应的unicodeString去掉反斜杠：" + replace);
            try {
                Class nyRegExpBean = Class.forName("com.nytechnology.nyimlib.NyEmojiBean");
                Method method = nyRegExpBean.getDeclaredMethod("get" + replace);
                Object obj = nyRegExpBean.newInstance();
                String invoke = (String) method.invoke(obj);
                m.appendReplacement(sb, invoke);
                System.out.println("匹配的输出：" + sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        m.appendTail(sb);
        System.out.println("最后的输出：" + sb.toString());

    }

    public void StringToEmoji(String content) {

        // 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
        String patt = "\\s*\\u005b\\u5fae\\u7b11\\u005d";

        // 用于测试的输入字符串
        String input = "我是消息[微笑]";
        System.out.println("原始字符:" + input);

        // 从正则表达式实例中运行方法并查看其如何运行
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(input);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String groupEmoji = m.group();//得到从正则中得到匹配后的表情
            System.out.println("得到从正则中得到匹配后的表情：" + groupEmoji);

            String unicodeString = stringToUnicode(groupEmoji);//把表情反转成unicode字符串
            System.out.println("把表情反转成unicode字符串：" + unicodeString);

            String replace = unicodeString.replace("\\", "").replace("[","").replace("]","").toUpperCase();//把对应的unicodeString去掉反斜杠
            System.out.println("把对应的unicodeString去掉反斜杠：" + replace);
//            try {
//                Class nyRegExpBean = Class.forName("com.nytechnology.nyimlib.NyEmojiBean");
//                Method method = nyRegExpBean.getDeclaredMethod("get" + replace);
//                Object obj = nyRegExpBean.newInstance();
//                String invoke = (String) method.invoke(obj);
//                m.appendReplacement(sb, invoke);
//                System.out.println("匹配的输出：" + sb.toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
        }
        m.appendTail(sb);
        System.out.println("最后的输出：" + sb.toString());



    }


    /**
     * 获取查询的字符串
     * 将匹配的字符串取出
     */
    public void getString(String str, String regx) {
        //1.将正在表达式封装成对象Patten 类来实现
        Pattern pattern = Pattern.compile(regx);
        //2.将字符串和正则表达式相关联
        Matcher matcher = pattern.matcher(str);
        //3.String 对象中的matches 方法就是通过这个Matcher和pattern来实现的。

        System.out.println(matcher.matches());
        //查找符合规则的子串
        while (matcher.find()) {
            //获取 字符串
            System.out.println(matcher.group());
            //获取的字符串的首位置和末位置
            System.out.println(matcher.start() + "--" + matcher.end());
        }
    }


    /**
     * 字符串的分割
     */
    public void getDivision(String str, String regx) {
        String[] dataStr = str.split(regx);
        for (int i = 0; i < dataStr.length; i++) {
            System.out.println("正则表达式分割:" + dataStr.length + dataStr[i]);
        }
    }

    /**
     * 把中文字符串转换为十六进制Unicode编码字符串
     */
    public String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += "\\u" + Integer.toHexString(ch);
            else
                str += String.valueOf(s.charAt(i));
        }
        return str;
    }

    public String getUnicode(){
        try {
            Class nyRegExpBean = Class.forName("com.nytechnology.nyimlib.NyEmojiBean");

            Method[] methods = nyRegExpBean.getMethods();
            Object userInfo = nyRegExpBean.newInstance();
            StringBuffer sb = new StringBuffer();
            sb.append("{");
            for (Method method : methods) {
                String invoke = (String) method.invoke(userInfo);//得到方法中的描述字符串
                String replace = invoke.replace("[", "").replace("]", "");//去掉描述的括号
                String stringUnicode = stringToUnicode(replace);//将描述字符串转Unicode字符串
                String  filed= stringUnicode.replace("\\","").toUpperCase();

                sb.append("\"");
                sb.append(filed);
                sb.append("\"");
                sb.append(":");
                sb.append("\"");

                sb.append("\",");
                System.out.println(sb.toString());
            }
//            sb.append("}");
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
