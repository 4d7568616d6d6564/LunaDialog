package com.mechadev.lunadialog

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mechadev.lunadialog.databinding.ActivityMainBinding
import com.mechadev.lunadialog.ui.LunaProgressDialog
import com.mechadev.lunadialog.utils.AnimationType
import com.mechadev.lunadialog.utils.DialogAnimationStyle
import com.mechadev.lunadialog.utils.OrientationType
import com.mechadev.lunadialog.utils.ProgressDrawable


class MainActivity : AppCompatActivity() {
    private lateinit var lunaProgressDialog: LunaProgressDialog
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lunaProgressDialog = LunaProgressDialog.Builder(this)
            .setTitleText("Title")
            .setDescriptionText("This is desc")
            .setCancelableOption(true)
            .setContainerOrientation(OrientationType.VERTICAL)
            .setAnimationType(AnimationType.IMAGEVIEW)
            .setAnimationDelay(200L)
            .setAnimationStyle(DialogAnimationStyle.NORMAL)
            .setAnimationStart(false)
            .setProgressDrawable(ProgressDrawable.DOT_PROGRESS)
            .setProgressScaleType(ImageView.ScaleType.CENTER_CROP)
            .setTitleTextColor(Color.GREEN)
            .setTitleTextStyle(Typeface.BOLD)
            .setTitleFontFamily(R.font.beach)
            .setDescriptionFontFamily(R.font.poppins_medium)
            .setDescriptionTextColor(Color.RED)
            .setAnimationFPS(18)
            .setProgressImageSize(64, 64)
            .setTitleTextSize(14)
            .setTextContainerMargin(0, 0, 0, 0)
            .setTextContainerGravity(Gravity.CENTER)
            .setContainerPositionGravity(Gravity.CENTER, 56, 0)
            .setContainerBackgroundShape(GradientDrawable.RECTANGLE)
            .setContainerDimAmount(0.1f)
            .setContainerCornerRadius(16)
            .setContainerPadding(12)
            .setContainerBackgroundColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.kprogresshud_default_color
                )
            )
            .build()


        binding.showDialogButton.setOnClickListener {
            if (lunaProgressDialog.isShowing) {
                lunaProgressDialog.dismiss()
            } else {
                lunaProgressDialog.show()
            }
        }
    }
}