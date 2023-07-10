package com.example.androidwidgetexample.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.example.androidwidgetexample.GlassPreferences
import com.example.androidwidgetexample.R

/**
 * Implementation of App Widget functionality.
 */
class MainWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val prefs = GlassPreferences(context)
    val ml = prefs.fetch()
    val views = RemoteViews(context.packageName, R.layout.main_widget)
    views.setTextViewText(R.id.widget_total_result, context.getString(R.string.total_result, ml))
    //views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    //appWidgetManager.updateAppWidget(appWidgetId, views)
}