
### 1.ShareSDK使用 http://www.mob.com/wiki/detailed?wiki=ShareSDK_Android_Title_ksjc&id=14
    1.在根目录下build.gradle的dependencies中加入classpath "com.mob.sdk:MobSDK:2018.0319.1724"
    2.在app目录下build.gradle上加上插件apply plugin: 'com.mob.sdk'
    3.在app目录下的build.gradle加上，注意是和android{}并列，不是包裹在android{}中
    MobSDK {
    appKey "申请Mob的appkey"
    appSecret "申请Mob的AppSecret"

    ShareSDK {
        //平台配置信息
        devInfo {
            Wechat {
                appId "wx4868b35061f87885"
                appSecret "64020361b8ec4c99936c0e3999a9f249"
            }
            QQ {
                appId "100371282"
                appKey "aed9b0303e3ed1e27bae87c33761161d"
                shareByAppClient true
            }
            Facebook {
                appKey "1412473428822331"
                appSecret "a42f4f3f867dc947b9ed6020c2e93558"
                callbackUri "https://mob.com"
            }
            SinaWeibo {
                appKey "568898243"
                appSecret "38a4f8204cc784f81f9f0daaf31e02e3"
                callbackUri "http://www.sharesdk.cn"
                shareByAppClient true
            }
        }
    }
    4.调用代码
      //java
    private void showShare() {
     OnekeyShare oks = new OnekeyShare();
     // title标题，微信、QQ和QQ空间等平台使用
     oks.setTitle(getString(R.string.share));
     // titleUrl QQ和QQ空间跳转链接
     oks.setTitleUrl("http://sharesdk.cn");
     // text是分享文本，所有平台都需要这个字段
     oks.setText("我是分享文本");
     // imagePath是图片的本地路径，确保SDcard下面存在此张图片
     oks.setImagePath("/sdcard/test.jpg");
     // url在微信、Facebook等平台中使用
     oks.setUrl("http://sharesdk.cn");
    // 启动分享GUI
    oks.show(this);
  }

