package com.eco.ecoseoul.home.control

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.ProgressBar
import com.eco.ecoseoul.R


/**
 * Created by minhyoung on 2018. 9. 27..
 */
class ProgressBarAnimation(progress : ProgressBar,circleList : ArrayList<ImageView>,flag : Int,mDuration : Long) : Animation() {

    private var mTo: Int = 0
    private var mFrom: Int = 0
    private var mFlag = flag
    //private var mStepDuration = mDuration / progress.max
    private var mStepDuration = mDuration
    private val mProgressBar = progress
    private var mCircleList = circleList
    fun setProgress(progress: Int) {
        var progress = progress
        if (progress < 0) {
            progress = 0
        }

        if (progress > mProgressBar.max) {
            progress = mProgressBar.max
        }

        mTo = progress

        mFrom = 0
        //duration = Math.abs(mTo - mFrom) * mStepDuration
        duration = mStepDuration
        mProgressBar.startAnimation(this)
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        var value = mFrom + (mTo - mFrom) * interpolatedTime
        mProgressBar.progress = value.toInt()
        if(mFlag == 1){
            when(value.toInt()){
                25->{
                    mCircleList.get(0).setBackgroundResource(R.drawable.circle_point_red)
                }
                50->{
                    mCircleList.get(1).setBackgroundResource(R.drawable.circle_point_red)
                }
                75->{
                    mCircleList.get(2).setBackgroundResource(R.drawable.circle_point_red)
                }
            }
        } else {
            when(value.toInt()){
                25->{
                    mCircleList.get(0).setBackgroundResource(R.drawable.circle_point_green)
                }
                50->{
                    mCircleList.get(1).setBackgroundResource(R.drawable.circle_point_green)
                }
                75->{
                    mCircleList.get(2).setBackgroundResource(R.drawable.circle_point_green)
                }
            }
        }
    }
}