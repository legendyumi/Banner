# Banner
![](https://qqadapt.qpic.cn/txdocpic/0/b8d5a4bbf1148f9306a818b0f97b67aa/0)

1.app的bulid.gradle添加引用:

```
implementation 'com.alibaba:fastjson:1.2.38
```

2.布局引用:

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/ll_auto_play"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_marginTop="@dimen/dp_10"
        android:layout_width="match_parent"
        android:layout_height="@dimen/dp_140"
        android:clipChildren="false">

        <com.hejunlin.superindicatorlibray.LoopViewPager
            android:id="@+id/viewpager"
            android:layout_width="300dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center" />

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="@dimen/dp_20"
            android:layout_gravity="bottom"
            android:layout_marginBottom="@dimen/dp_35"
            android:background="#20ffffff"
            android:visibility="gone">

            <com.hejunlin.superindicatorlibray.CircleIndicator
                android:id="@+id/indicator"
                android:layout_width="match_parent"
                android:layout_height="20dp"
                android:layout_gravity="right|center_vertical"
                android:layout_marginRight="@dimen/dp_14"
                android:gravity="center"
                android:orientation="horizontal" />

        </FrameLayout>
    </FrameLayout>
</LinearLayout>
```
3.activity:

```
package com.example.banner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banner.adapter.Adapter
import com.example.banner.util.banner.CoverFlow
import kotlinx.android.synthetic.main.act_auto_play.*

/**
 * banner
 *
 */

class MainActivity : AppCompatActivity() {
    private var madapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_auto_play)
        madapter = Adapter(this)
        viewpager.adapter = madapter
        viewpager.setLooperPic(true)
        viewpager.offscreenPageLimit = 15
        CoverFlow.Builder()
            .with(viewpager)
            .scale(0.3f)
            .scaley(0.15f)
            .pagerMargin(resources.getDimensionPixelSize(R.dimen.pager_margin).toFloat())
            .spaceSize(0f)
            .build()
        indicator.setViewPager(viewpager)
    }
}
```
