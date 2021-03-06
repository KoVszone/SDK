#** 更新日志 **

======= 2015-06-23 ============

1.将分支feature1.1内容合并到master <br/> 

======= 2015-04-30 ============

1.增加新对战游戏：西游释厄传Super <br/> 
2.So库从armeabi-v7a移动到armeabi


======= 2015-04-17 ============

1.加载资源时，支持中途退出。支持断点续传<br/>
2. 新增功能：出招表， 新手引导

======= 2015-04-09 ============

1.Demo 的AndroidManifest.xml增加VirtualGamdPadService

======= 2015-04-03 ============

1.小米盒子1代，游戏列表按方向键，程序崩溃<br/>
2.调整首页右边距 <br/>
3.连接正式服务器下载资源（之前是用测试服务器）<br/>
4. 移除umeng统计的jar包依赖<br/>

======= 2015-03-21 ============

 1、增加混淆配置说明<br/>
 2、AndroidManifest.xml添加VirtualGamdPadService支持电视游戏助手（手机虚拟手柄)<br/>

======= 2015-03-19 ============

1、修复游戏退出时奔溃<br/>
2、首页界面优化<br/>
3、解决焦点框从左上角出来的问题<br/>

# KO对战游戏频道SDK
### 功能
通过该SDK，允许第三方将KO对战游戏频道接入到其应用，在该应用中实现在线对战功能。


###SDK接入步骤：
####1. 将项目 KOBattleChannel.SDK 导入到Eclipse 中
####2. 在您的项目工程中：
右键->Properties ->Android ->在Library中选择刚刚导入的KOBattleChannel.SDK项目
![Alt text](./config_project_libs.png)
####3. 修改AndroidManifest.xml
在您的项目工程的AndroidManifest.xml 添加如下代码段：
#####**权限**
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
#####*applicatin 节点中添加meta**
``` xml
        <meta-data
            android:name="KO_APP_KEY"
            android:value="xxxxxxxxxx" />
        <meta-data
            android:name="KO_APP_ID"
            android:value="xxxxxxxxx" />
```

其中 **KO_APP_ID**为合作方的名称（英文), **KO_APP_KEY** 为应用标识，该值由第三方开发者工程的包名和签名计算，具体计算方法请联系官方QQ讨论群434142774

#####*applicatin 节点中添加activity, service 等**

```xml
        <activity
            android:name="cn.vszone.ko.tv.battle.channel.StartUpActivity"
            android:configChanges="keyboardHidden"
            android:screenOrientation="landscape"
            android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen" >
        </activity>
        <activity
            android:name="cn.vszone.ko.tv.battle.channel.MainBattleListActivity"
            android:configChanges="keyboardHidden"
            android:label="@string/ko_app_name"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen" />
        <activity
            android:name="cn.vszone.tv.gamebox.DownLoadWebActivity"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme"
            android:windowSoftInputMode="stateUnchanged" />
        <activity
            android:name="cn.vszone.ko.tv.emu.bnet.BNetExitActivity"
            android:launchMode="singleTop"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.tv.gamebox.BNetExerciseGuideActivity"
            android:launchMode="singleTop"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.BNetTipsActivity"
            android:launchMode="singleTask"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.tv.gamebox.BattleHallActivity"
            android:hardwareAccelerated="false"
            android:launchMode="singleTop"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.ko.tv.emu.bnet.BNetPrepareActivity"
            android:exported="true"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.GamePrepareActivity"
            android:exported="true"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" >
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
            </intent-filter>
        </activity>
        <activity
            android:name="cn.vszone.tv.gamebox.MyAccountActivity"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_NormalBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.MemoryCleanActivity"
            android:exported="true"
            android:process=":prepare"
            android:theme="@style/TranslucentFullscreen" >
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
            </intent-filter>
        </activity>
        <activity
            android:name="cn.vszone.ko.tv.emu.FbaMainActivity"
            android:launchMode="singleTask"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.ko.tv.emu.EmuMenuActivity"
            android:configChanges="keyboardHidden"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.MyGamePadActivity"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_NormalBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.GamePadSupportedListActivity"
            android:launchMode="standard"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_NormalBackgroundTheme" />
        <activity
            android:name="cn.vszone.ko.tv.emu.StateSlotsActivity"
            android:configChanges="keyboardHidden"
            android:screenOrientation="landscape"
            android:theme="@style/TranslucentFullscreen" />
        <activity
            android:name="cn.vszone.tv.gamebox.PadKeyMappingActivity"
            android:launchMode="standard"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" />
        <activity
            android:name="cn.vszone.ko.tv.emu.bnet.FbaBNetActivity"
            android:launchMode="singleTask"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.ko.tv.emu.FbaSettingActivity"
            android:screenOrientation="landscape"
            android:theme="@style/TranslucentFullscreen" />
        <activity
            android:name="cn.vszone.tv.gamebox.ModifyAvatarActivity"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_NormalBackgroundTheme" />
        <activity
            android:name="cn.vszone.tv.gamebox.ModifyNickNameActivity"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_NormalBackgroundTheme"
            android:windowSoftInputMode="adjustNothing" />
        <activity
            android:name="cn.vszone.ko.tv.emu.bnet.BNetLevelModePrepareActivity"
            android:exported="true"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/BlurBackgroundTheme" />
        <activity
            android:name="cn.vszone.ko.tv.emu.bnet.FbaBNetLevelModeActivity"
            android:launchMode="singleTask"
            android:screenOrientation="landscape" />
        <activity
            android:name="cn.vszone.tv.gamebox.LoadingLibsProgressActivity"
            android:launchMode="singleInstance"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" >
        </activity>
        <activity
            android:name="cn.vszone.tv.gamebox.BNetNoviceGuideActivity"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" >
        </activity>
        <activity
            android:name="cn.vszone.ko.tv.emu.teaching.FbaTeachingActivity"
            android:launchMode="singleTask"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" >
            <intent-filter>
                <action android:name="ko.intent.action.FBA_TEAVHING" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
        <activity
            android:name="cn.vszone.tv.gamebox.FighterMovesListActivity"
            android:hardwareAccelerated="false"
            android:screenOrientation="landscape"
            android:theme="@style/KO_Battle_Channel_BlurBackgroundTheme" >
        </activity>
        <activity
            android:name="cn.vszone.tv.gamebox.FighterListActivity"
            android:hardwareAccelerated="false"
            android:screenOrientation="landscape" >
        </activity>
        
        <service android:name="cn.vszone.ko.gm.download.service.DownloadService" />
        <service android:name="cn.vszone.ko.bnet.core.BattleNetService" />
        <service
            android:name="cn.vszone.gamepad.virtual.VirtualGamdPadService"
            android:enabled="true"
            android:exported="true" >
            <intent-filter>
                <action android:name="VirtualGamdPadService" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </service>

        <receiver android:name="cn.vszone.ko.tv.receivers.VsNetReceiver" >
            <intent-filter>
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
            </intent-filter>
        </receiver>

```

####4. Application中添加代码：

```java
    @Override
    public void onCreate() {
        super.onCreate();
        KOChannelSDK.getInstance().onApplicationCreate(this);
    }
    
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        KOChannelSDK.getInstance().onApplicationLowMemory();
    }
```
####5. 需要启动KO对战频道的地方（如Button 的onClick)添加代码：
```java
        Intent intent = new Intent(this, cn.vszone.ko.tv.battle.channel.StartUpActivity.class);
        startActivity(intent);

```

启动成功后将出现如下界面：

![Alt text](./battle_home.png)

####6. 在应用退出时，需要调用以下代码：
```java
KOChannelSDK.getInstance().onApplicationExit()
```


-----
### 示例DEMO
下载地址 https://github.com/KoVszone/BattleChannelSDK/KOBattleChannel.Demo
``` git
git clone https://github.com/KoVszone/SDK.git

```

### Java Doc
JAVA开发文档见 /doc


###常见问题QA
混淆配置

如果代码需要混淆， 请在proguard配置文件（例如proguard-project.txt）中添加：

```
### ko start
### for gson
-keepattributes Signature
-keepattributes *Annotation*

-dontwarn com.bda.controller.**
-dontnote com.bda.controller.**
-dontwarn a.**
-dontnote a.**
-dontwarn cn.vszone.**
-dontnote cn.vszone.**
-dontwarn com.a.**
-dontnote com.a.**
-dontwarn com.google.protobuf.**
-dontnote com.google.protobuf.**
-dontwarn u.aly.**
-dontnote u.aly.**
-dontwarn com.google.**
-keep class a.** {*;}
-keep class cn.vszone.** {*;}
-keep class com.a.** {*;}
-keep class com.bda.controller.** {*;}
-keep class com.google.protobuf.** {*;}
-keep class u.aly.** {*;}
### ko end
```

运行demo 提示 KO_APP_KEY 是无效的

请使用SDK中的 ko_debug.keystore编译运行Demo工程

如有其它技术问题，请联系官方QQ讨论群434142774
