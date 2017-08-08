package com.plugin.score;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.net.Uri;
import android.content.Intent;
import android.text.TextUtils;
import java.io.File;

/**
 * This class echoes a string called from JavaScript.
 */
public class score extends CordovaPlugin {
    private static final String MARKET_PKG = "com.tencent.android.qqdownloader";//腾讯应用宝包名
    // com.qihoo.appstore //360手机助手
    private static final String PACKAGE_NAME = "yzt.jzt";//应用程序包名

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("toScore")) {
            if(isInstallByRead(MARKET_PKG)){
                Uri uri = Uri.parse("market://details?id="+PACKAGE_NAME);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                if (!TextUtils.isEmpty(MARKET_PKG)){
                   intent.setPackage(MARKET_PKG);
                }
                // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                cordova.getActivity().startActivity(intent); //启动调用

            }else{
                callbackContext.success("false");
            }
            return true;
        }
        return false;
    }

    /**
     * 根据包名检测某个APP是否安装
     * @param packageName 包名
     * @return true 安装 false 没有安装
     */
    public boolean isInstallByRead(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

}
