package com.example.banner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banner.adapter.Adapter
import com.example.banner.util.CoverFlow
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
