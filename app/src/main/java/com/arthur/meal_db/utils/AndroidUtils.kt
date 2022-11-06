package com.arthur.meal_db.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.arthur.meal_db.R

object IntentUtils {
    fun openExternalUrl(externalUrl: String, context: Context){
        val urlIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(externalUrl)
        )
        context.startActivity(urlIntent)
    }

    fun openYtVideo(ytVideoLink: String, context: Context){
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ytVideoLink))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.google.android.youtube")
            ContextCompat.startActivity(context, intent, null)
        } catch (e: ActivityNotFoundException) {
            ContextCompat.startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(ytVideoLink)), null)
        } catch (e: PackageManager.NameNotFoundException) {
            ContextCompat.startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(ytVideoLink)), null)
        } catch (e: Exception) {
            Toast.makeText(context, context.getString(R.string.video_intent_error), Toast.LENGTH_LONG).show()
        }
    }
}