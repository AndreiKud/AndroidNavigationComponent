package ru.andreikud.navigationcomponentpracticing

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.core.os.bundleOf
import androidx.navigation.NavDeepLinkBuilder

private const val TAG = "DeepLinkAppWidgetProvid"

class DeepLinkAppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        Log.d(TAG, "onUpdate: $context, $appWidgetManager, $appWidgetIds")
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        checkNotNull(context)
        checkNotNull(appWidgetManager)

        val remoteViews = RemoteViews(context.packageName, R.layout.widget_first)
        val args = bundleOf("key" to "Hello from widget!")
        val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.secondFragment)
            .setArguments(args)
            .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.btnClick, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }

}