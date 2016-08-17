
package com.example.mr_wind.priojectdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.example.mr_wind.priojectdemo.BaseApplication;

import java.util.ArrayList;
import java.util.List;



/**
 * @author YOLANDA
 * @Time Apr 29, 2015 4:12:36 PM
 */
public class APKUtil {

    /**
     * @param context
     * @param packageName
     * @return
     * @description 调用第三方应用
     * @author Joe
     */
    public static boolean startOtherApp(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        try {
            intent = packageManager.getLaunchIntentForPackage(packageName);
            context.startActivity(intent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 是否安装了某个应用
     *
     * @param packageName
     * @return
     * @author YOLANDA
     */
    public static boolean isAInstallPackage(String packageName) {
        final PackageManager packageManager = BaseApplication.getInstance().getPackageManager();// 获取packagemanager
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        List<String> packages = new ArrayList<String>();// 用于存储所有已安装程序的包名
        if (packageInfos != null) {
            for (PackageInfo packageInfo : packageInfos) {
                packages.add(packageInfo.packageName);
            }
        }
        return packages.contains(packageName);// 判断pName中是否有目标程序的包名，有TRUE，没有FALSE
    }

    /**
     * 获得本应用版本号
     *
     * @param context
     * @return 返回版本号
     * @author YOLANDA
     */
    public static int getMYVersionCode() {
        int versionCode = 0;
        try {
            PackageInfo pi = getPackageInfoByPackage(BaseApplication.getInstance().getPackageName());
            versionCode = pi.versionCode;
        } catch (Exception e) {
        }
        return versionCode;
    }

    /**
     * 获得应用版本名称
     *
     * @param context
     * @return
     * @author YOLANDA
     */
    public static String getMYVersionName() {
        String versionName = "";
        try {
            PackageInfo pi = getPackageInfoByPackage(BaseApplication.getInstance().getPackageName());
            versionName = pi.versionName;
        } catch (Exception e) {
        }
        return versionName;
    }


    /**
     * 检查本地APK是否比安装的应用新
     *
     * @param downApkPath 本地APK完整路径
     * @return
     * @author YOLANDA
     */
    public static boolean checkIsNewThanInstallApp(String apkPath) {
        ApplicationInfo apkInfo = getAppInfoByPath(apkPath);
        PackageInfo apkPackageInfo = getPackageInfoByPath(apkPath);
        PackageInfo appPackageInfo = getPackageInfoByPackage(apkInfo.packageName);
        if (apkPackageInfo.versionCode > appPackageInfo.versionCode) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 按本地APK路径获取包信息，包含版本名称和版本号
     *
     * @param context
     * @param apkPath
     * @return
     * @author YOLANDA
     */
    public static PackageInfo getPackageInfoByPath(String apkPath) {
        return BaseApplication.getInstance().getPackageManager().getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
    }

    /**
     * 按已安装程序报名获取包信息
     *
     * @param context
     * @param packageName 已安装程序的包名
     * @return
     * @author YOLANDA
     */
    public static PackageInfo getPackageInfoByPackage(String packageName) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = BaseApplication.getInstance().getPackageManager().getPackageInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    /**
     * 按已安装程序报名读取应用信息
     *
     * @param context     上下文
     * @param packageName 包名
     * @return
     * @author YOLANDA
     */
    public static ApplicationInfo getAppInfoByPackageName(String packageName) {
        ApplicationInfo info = null;
        try {
            info = BaseApplication.getInstance().getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
        } catch (NameNotFoundException e) {
        }
        return info;
    }

    /**
     * 按本地APK路径读取APK应用信息
     *
     * @param context
     * @param path    APK完整路径
     * @return
     * @author YOLANDA
     */
    public static ApplicationInfo getAppInfoByPath(String apkPath) {
        PackageInfo info = getPackageInfoByPath(apkPath);
        ApplicationInfo appInfo = null;
        if (info != null) {
            appInfo = info.applicationInfo;
        }
        return appInfo;
    }

    /**
     * 按报名检查某个应用是否安装
     *
     * @param context
     * @param packageName 包名
     * @return
     * @author YOLANDA
     */
    public static boolean checkAppInstalledByPackageName(String packageName) {
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = BaseApplication.getInstance().getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < pinfo.size(); i++) {
            if (pinfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }

    /**
     * 按本地APK完整路径检查应用是否安装
     *
     * @param context
     * @param path    本地APK完整路径
     * @return
     * @author YOLANDA
     */
    public static boolean checkAppInstalledByPath(String apkPath) {
        ApplicationInfo locationInfo = getAppInfoByPath(apkPath);
        if (checkAppInstalledByPackageName(locationInfo.packageName)) {
            return true;
        }
        return false;
    }

}
