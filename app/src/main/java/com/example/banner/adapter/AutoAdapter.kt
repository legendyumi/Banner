package com.example.banner.adapter

import android.app.Activity
import android.view.View
import androidx.viewpager.widget.PagerAdapter

/**
 * banner的adapter
 */
class AutoAdapter : PagerAdapter() {
    private var mSize: Int = 0
    private var mActivity : Activity ? = null
    private var mImageCorner : Int ? = null


    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}