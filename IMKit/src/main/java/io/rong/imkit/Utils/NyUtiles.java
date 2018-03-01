package io.rong.imkit.Utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.rong.imkit.NYAppManger;
import io.rong.imkit.constant.Constant;

/**
 * Created by 18513 on 2017/12/16.
 */

public class NyUtiles {

    private static final String SLAT = "nanyou";

    /**
     * 数据加密
     *
     * @return
     */
    public static String encodeToString(Map<String, String> tm) {
        return encodeToMd5Slat(encodeToMd5(keySort(tm)),SLAT).toUpperCase();
    }

    /**
     * md5 不加盐加密
     *
     * @param string
     * @return
     */
    public static String encodeToMd5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * md5 加盐加密
     *
     * @param string
     * @param slat
     * @return
     */
    public static String encodeToMd5Slat(String string, String slat) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest((string + slat).getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 按key进行排序
     * @param tm
     * @return
     */
    public static String keySort(Map<String, String> tm) {
        //这里将map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(tm.entrySet());

        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //降序排序
            @Override
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getKey());
            sb.append("=");
            sb.append(list.get(i).getValue());
            if (i != list.size() - 1)
                sb.append("&");
        }
        Log.e("----", sb.toString());
        return sb.toString();
    }

    /**
     * 获取设备的唯一标识，deviceId
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
//        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tm.getDeviceId();
//        if (deviceId == null) {
//            return "";
//        } else {
//            return deviceId;
//        }
        return Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static String getInfoJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PhoneBrand",getPhoneBrand());//品牌
        jsonObject.put("PhoneModel",getPhoneModel());//型号
        jsonObject.put("BuildLevel",getBuildLevel());//api 登记
        jsonObject.put("BuildVersion",getBuildVersion());//android 版本号

        return jsonObject.toString();
    }

    public static void showToast(String text) {
        Toast.makeText(NYAppManger.getInstance().getAppContent(), text, Toast.LENGTH_SHORT).show();
    }

    public static void showLog(String name,String msg){
        if(Constant.isDebug){
            Log.e(name,msg);
        }
    }

    /**
     * 验证手机格式
     * http://blog.csdn.net/u012400885/article/details/53837472
     */
    public static boolean isMobileNum(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通） 147
         * 177 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles.trim()))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * 用于判断用户输入字符长度0到500位
     *
     * @param str
     * @return
     */
    public static boolean isLength(String str) {
        Pattern pattern = Pattern.compile(".{0,500}");
        return pattern.matcher(str).matches();
    }

    /**
     * 用于判断用户名字符长度0到500位
     *
     * @param str
     * @return
     */
    public static boolean isNameLength(String str) {
        Pattern pattern = Pattern.compile(".{0,50}");
        return pattern.matcher(str).matches();
    }

    /**
     * 过滤特殊字符
     */
    public static String stringFilter(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }
}
