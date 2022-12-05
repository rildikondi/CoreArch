package com.akondi.corearch.core.platform

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint

/**
* Base Activity class with helper methods for handling fragment transactions and back button
* events.
*
* @see ComponentActivity
*/
//@AndroidEntryPoint
abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setSupportActionBar(toolbar)
//        addFragment(savedInstanceState)
    }

//    override fun onBackPressed() {
//        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
//        super.onBackPressed()
//    }
//
//    private fun addFragment(savedInstanceState: Bundle?) =
//        savedInstanceState ?: supportFragmentManager.inTransaction { add(R.id.fragmentContainer, fragment()) }

    abstract fun fragment(): BaseFragment
}