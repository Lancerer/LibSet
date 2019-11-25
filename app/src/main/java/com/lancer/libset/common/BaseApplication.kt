package com.lancer.libset.common

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.DiskLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.umeng.commonsdk.UMConfigure

/**
 *
 *created by Lancer on 2019/11/20
 *desc
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()

        /**
         * 初始化common库
         * 参数1:上下文，必须的参数，不能为空
         * 参数2:友盟 app key，非必须参数，如果Manifest文件中已配置app key，该参数可以传空，则使用Manifest中配置的app key，否则该参数必须传入
         * 参数3:友盟 channel，非必须参数，如果Manifest文件中已配置channel，该参数可以传空，则使用Manifest中配置的channel，否则该参数必须传入，channel命名请详见channel渠道命名规范
         * 参数4:设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机
         * 参数5:Push推送业务的secret，需要集成Push功能时必须传入Push的secret，否则传空
         */
        //如果AndroidManifest.xml清单配置中没有设置appkey和channel，则可以在这里设置
                UMConfigure.init(this, Constants.AppKey_you_meng, "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        //UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE,"");

    }

    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)  //（可选）是否显示线程信息。 默认值为true
            .methodCount(1)         // （可选）要显示的方法行数。 默认2
            .methodOffset(5)        // （可选）隐藏内部方法调用到偏移量。 默认5
            .tag("doShare")//（可选）每个日志的全局标记。 默认PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))//根据上面的格式设置logger相应的适配器
        Logger.addLogAdapter(DiskLogAdapter())//保存到文件
    }
}