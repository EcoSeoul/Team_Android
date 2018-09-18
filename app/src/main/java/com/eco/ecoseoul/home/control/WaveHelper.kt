package com.eco.ecoseoul.home.control

import android.animation.Animator
import android.animation.AnimatorSet
import com.gelitenight.waveview.library.WaveView
import android.view.animation.LinearInterpolator
import android.animation.ValueAnimator
import android.animation.ObjectAnimator
import android.view.animation.DecelerateInterpolator



/**
 * Created by minhyoung on 2018. 9. 18..
 */
class WaveHelper(waveView: WaveView) {
    var waveView = waveView
    lateinit var mAnimatorSet : AnimatorSet

    public fun initWave(waveHeight: Float){
        var animators : ArrayList<Animator>? = ArrayList()

        val waveShiftAnim = ObjectAnimator.ofFloat(
                waveView, "waveShiftRatio", 0f, 1f)
        waveShiftAnim.repeatCount = ValueAnimator.INFINITE
        waveShiftAnim.duration = 1000
        waveShiftAnim.interpolator = LinearInterpolator()
        animators!!.add(waveShiftAnim)

        // vertical animation.
        // water level increases from 0 to center of WaveView
        val waterLevelAnim = ObjectAnimator.ofFloat(
                waveView, "waterLevelRatio", 0f, waveHeight)
        waterLevelAnim.duration = 10000
        waterLevelAnim.interpolator = DecelerateInterpolator()
        animators.add(waterLevelAnim)

        // amplitude animation.
        // wave grows big then grows small, repeatedly
        val amplitudeAnim = ObjectAnimator.ofFloat(
                waveView, "amplitudeRatio", 0.0001f, 0.05f)
        amplitudeAnim.repeatCount = ValueAnimator.INFINITE
        amplitudeAnim.repeatMode = ValueAnimator.REVERSE
        amplitudeAnim.duration = 5000
        amplitudeAnim.interpolator = LinearInterpolator()
        animators.add(amplitudeAnim)

        mAnimatorSet = AnimatorSet()
        mAnimatorSet.playTogether(animators)
    }

    public fun startWave(){
        waveView.setShowWave(true);
        if (mAnimatorSet != null) {
            mAnimatorSet.start();
        }
    }

    public fun cancelWave(){
        if (mAnimatorSet != null) {
//            mAnimatorSet.cancel();
            mAnimatorSet.end();
        }
    }
}