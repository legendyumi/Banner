package com.example.banner.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

import com.example.banner.R

class Adapter : PagerAdapter {

    private var mSize: Int = 0
    private var mActivity: Activity? = null
    private val mImageCorner = -1f
    private val ResIds = intArrayOf(
        R.mipmap.gdfw_fjwl,
        R.mipmap.gdfw_kgdc,
        R.mipmap.gdfw_ttbj,
        R.mipmap.gdfw_wzdj,
        R.mipmap.gdfw_zjxl
    )

    /* private int[] TextIds = new int[] {
            R.string.a_name,
            R.string.b_name,
            R.string.c_name,
            R.string.d_name,
            R.string.e_name,
    };*/

    constructor(activity: Activity) {
        mActivity = activity
        mSize = 5
    }

    constructor(count: Int) {
        mSize = count
    }

    override fun getCount(): Int {
        return mSize
    }

    override fun destroyItem(view: ViewGroup, position: Int, `object`: Any) {
        view.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(mActivity?.applicationContext)
            .inflate(R.layout.auto_play_item, container, false)
        val imageView = view.findViewById<View>(R.id.image) as ImageView
        val textView = view.findViewById<View>(R.id.image_desc) as TextView
        //        textView.setText(TextIds[position]);
        imageView.setImageResource(ResIds[position])
        val image = (imageView.drawable as BitmapDrawable).bitmap
        val newimage = getRoundCornerImage(image, 50)
        val imageView2 = ImageView(view.context)
        imageView2.setImageBitmap(newimage)
        container.addView(view)
        return view
    }

    fun addItem() {
        mSize++
        notifyDataSetChanged()
    }

    fun removeItem() {
        mSize--
        mSize = if (mSize < 0) 0 else mSize

        notifyDataSetChanged()
    }

    fun getRoundCornerImage(bitmap: Bitmap, roundPixels: Int): Bitmap {
        val roundConcerImage =
            Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(roundConcerImage)
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        val rectF = RectF(rect)
        paint.isAntiAlias = true
        canvas.drawRoundRect(rectF, roundPixels.toFloat(), roundPixels.toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, null, rect, paint)
        return roundConcerImage
    }
}
