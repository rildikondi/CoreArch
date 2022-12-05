package com.akondi.corearch.core.navigation

import android.content.Context
import android.view.View
import com.akondi.corearch.features.login.Authenticator
import com.akondi.corearch.features.login.LoginActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(private val authenticator: Authenticator) {

    private fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

    fun showMain(context: Context) {
//        when (authenticator.userLoggedIn()) {
//            true -> showMaterials(context)
//            false -> showLogin(context)
//        }
    }

//    private fun showMaterials(context: Context) = context.startActivity(MaterialsActivity.callingIntent(context))
//
//    fun showMaterialDetails(activity: FragmentActivity, materialView: MaterialView, navigationExtras: Extras) {
//        val intent = MaterialDetailsActivity.callingIntent(activity, materialView)
//        activity.startActivity(intent)
//    }

    class Extras(val transitionSharedElement: View)
}