# KOBattleChannleSDK KO对战游戏频道SDK
#### 功能
通过该SDK，允许第三方将KO对战游戏频道接入到其应用

![Alt text](./battle_home.png)

#### SDK接入步骤：
1. 将项目
KOBattleChannel.SDK
导入到Eclipse 中
2. 
在您的项目工程中：
右键->Properties ->Android ->在Library中选择刚刚导入的KOBattleChannel.SDK项目
3. 在您的项目工程的AndroidManifest.xml 添加如下代码段：
**权限**
``` xml
   <permission
        android:name="cn.vszone.ko.permission.PAUSE_ENGINE"
        android:protectionLevel="dangerous" >
    </permission>
    <permission
        android:name="cn.vszone.ko.permission.RESUME_ENGINE"
        android:protectionLevel="dangerous" >
    </permission>

    <!-- 接收系统通知权限组 -->
    <uses-permission android:name="android.permission.RESTART_PACKAGES" />
    <uses-permission android:name="android.Manifest.permission.KILL_BACKGROUND_PROCESSES" />
    <!-- 保持屏幕高亮权限组 -->
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <!-- 访问网络状态权限组 -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <!-- 读写SD卡权限组 -->
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
    <uses-permission android:name="android.permission.WRITE_SETTINGS" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <!-- 读取IMEI的权限 -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <!-- 系统操作权限组 -->
    <uses-permission android:name="com.android.launcher.permission.READ_SETTINGS" />
    <uses-permission android:name="com.android.launcher.permission.WRITE_SETTINGS" />
    <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
    <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.READ_LOGS" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    <uses-permission android:name="android.permission.CHANGE_CONFIGURATION" />
    <uses-permission android:name="android.permission.BROADCAST_STICKY" />
    <!-- 全局Dialog -->
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
    <!-- 全局Dialog -->
    <uses-permission android:name="cn.vszone.ko.permission.PAUSE_ENGINE" />
    <uses-permission android:name="cn.vszone.ko.permission.RESUME_ENGINE" />
    <uses-permission android:name="android.permission.GET_TASKS" />
``` 
**applicatin 节点中添加meta**
        <meta-data
            android:name="KO_APPKEY"
            android:value="xxxxxxxxxx" />
        <meta-data
            android:name="KO_CHANNEL"
            android:value="xxxxxxxxx" />
其中 **KO_CHANNEL**为合作方的名称（英文), **KO_APPKEY** 为应用标识，该值由第三方开发者工程的包名和签名计算，具体计算方法请联系[help@vszone.cn](luoyi@vszone.cn)



3: **依赖** 在android工程的构建路径中加入SDK的依赖jar包

**libgamepad.jar**//SDK
**gson-2.3.jar**//JSON
**protobuf2.5.0.jar**//google通信协议

以eclipse工程为例 在../libs下
![Alt text](./1421737547744.png)
**完成以上1,2,3点后,APP或者游戏就有了支持手柄的能力**

4:**接口拓展**

拓展 让手柄控制游戏




-----
### 关于混淆
在proguard配置文件中添加如下
>-libraryjars gamecontroller.jar

-----
### 示例DEMO
下载地址 https://github.com/Ko/KoGamePadDemo
``` git
git clone https://github.com/KoVszone/GamePad

```

### Java Doc
JAVA开发文档见 /doc


###常见问题QA
Q1:异常 java.lang.VerifyError. **cv.vszone.gamepad
>解决方法 :按照步骤3 导入gson-2.3.jar,protobuf2.5.0.jar依赖文件
