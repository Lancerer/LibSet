package com.lancer.libset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.sharesdk.onekeyshare.OnekeyShare
import com.orhanobut.logger.Logger

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.d("log日志系统")
        initData()
    }

    private fun initData() {
        shareMsg()
    }

    private fun shareMsg() {
        val share = OnekeyShare()
        share.setTitle("分享")
        share.setTitleUrl("http://sharesdk.cn")
        share.text = "我是分享文本"
        share.setImageUrl("")
        share.setUrl("")
        share.show(this)
    }
}
