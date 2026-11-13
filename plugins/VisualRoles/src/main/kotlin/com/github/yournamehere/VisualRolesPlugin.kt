package com.github.yournamehere

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.api.SettingsAPI
import com.aliucord.entities.Plugin
import com.aliucord.entities.Plugin.SettingsTab
import com.aliucord.fragments.SettingsPage

@AliucordPlugin
@Suppress("unused")
class VisualRolesPlugin : Plugin() {

    init {
        settingsTab = SettingsTab(VisualRolesPage::class.java)
            .withArgs(settings)
    }

    override fun start(context: Context) {
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}

class VisualRolesPage(
    private val pluginSettings: SettingsAPI
) : SettingsPage() {

    override fun onViewBound(view: View) {
        super.onViewBound(view)

        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
        }

        layout.addView(TextView(context).apply {
            text = "Visual Roles"
            textSize = 24f
        })

        layout.addView(TextView(context).apply {
            text = "Personalize visualmente os cargos dos servidores."
            textSize = 14f
        })

        layout.addView(TextView(context).apply {
            text = "Configurações locais"
            textSize = 16f
        })

        addView(layout)
    }
}
