
package com.github.yournamehere

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.fragments.SettingsPage
import com.aliucord.settings.SettingsAPI
import com.aliucord.settings.SettingsTab

@AliucordPlugin
@Suppress("unused")
class MyFirstKotlinPlugin : Plugin() {

    override fun start(context: Context) {
        settingsTab = SettingsTab(VisualRolesPage::class.java)
            .withArgs(settings)
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

        val title = TextView(context).apply {
            text = "Visual Roles"
            textSize = 24f
        }

        val description = TextView(context).apply {
            text = "Personalize visualmente os cargos dos servidores."
            textSize = 14f
        }

        val status = TextView(context).apply {
            text = "Configurações locais"
            textSize = 16f
        }

        layout.addView(title)
        layout.addView(description)
        layout.addView(status)

        addView(layout)
    }
}
