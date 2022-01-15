package com.test.apps.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.apps.myapplication.ui.main.AnimMainFragment

class AnimMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anim_main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AnimMainFragment.newInstance())
                .commitNow()
        }
    }
}