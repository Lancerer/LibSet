package com.lancer.libset.common

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.DiskLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 *
 *created by Lancer on 2019/11/20
 *desc
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
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