package com.lancer.libset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.sharesdk.framework.loopshare.MobLinkAPI
import cn.sharesdk.onekeyshare.OnekeyShare
import com.orhanobut.logger.Logger
import com.umeng.analytics.MobclickAgent

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)

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
