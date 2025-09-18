/*
 * Texter - A lightweight Kotlin text editor.
 * Copyright (C) 2025 Zethric
 * Contact: zethric.dev@pm.me
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package app.texter.components.menu

import app.texter.components.Icons
import app.texter.components.locales.Locales

import java.awt.Color
import javax.swing.ButtonGroup
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.JRadioButtonMenuItem
import javax.swing.UIManager
import javax.swing.text.JTextComponent

class PreferencesMenu {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.PREFERENCES).apply {
            icon = Icons.PREFERENCES
        }

        val appearance = JMenu(Locales.PREFERENCES_APPEARANCE).apply {
            icon = Icons.APPEARANCE
        }

        val settings = JMenuItem(Locales.PREFERENCES_SETTINGS).apply {
            // TODO: Implement
            icon = Icons.SETTINGS
            isEnabled = false
        }

        val system = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_SYSTEM).apply {
            isSelected = true
        }

        val dark = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_DARK)
        val light = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_LIGHT)
        val matrix = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_MATRIX)
        val ocean = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_OCEAN)
        val solarized = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_SOLARIZED)
        val pastel = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_PASTEL)
        val scripture = JRadioButtonMenuItem(Locales.PREFERENCES_THEME_SCRIPTURE)

        val group = ButtonGroup()

        system.addActionListener    {applyTheme(area, "system")}
        dark.addActionListener      {applyTheme(area, "dark")}
        light.addActionListener     {applyTheme(area, "light")}
        matrix.addActionListener    {applyTheme(area, "matrix")}
        ocean.addActionListener     {applyTheme(area, "ocean")}
        solarized.addActionListener {applyTheme(area, "solarized")}
        pastel.addActionListener    {applyTheme(area, "pastel")}
        scripture.addActionListener {applyTheme(area, "scripture")}

        listOf(system, dark, light, matrix, ocean, solarized, pastel, scripture).forEach {
            group.add(it)
            appearance.add(it)
        }

        return menu.apply {
            add(appearance)
            addSeparator()
            add(settings)
        }
    }

    private fun applyTheme(area: JTextComponent, theme: String) {
        when (theme) {
            "system" -> {
                area.background = UIManager.getColor("TextArea.background")
                area.foreground = UIManager.getColor("TextArea.foreground")
                area.caretColor = UIManager.getColor("TextArea.caretColor")
            }

            "dark" -> {
                area.background = Color(20, 20, 20)
                area.foreground = Color(250, 250, 250)
                area.caretColor = Color(250, 250, 250)
            }

            "light" -> {
                area.background = Color.WHITE
                area.foreground = Color.BLACK
                area.caretColor = Color.BLACK
            }

            "matrix" -> {
                area.background = Color.BLACK
                area.foreground = Color.GREEN
                area.caretColor = Color.GREEN
            }

            "ocean" -> {
                area.background = Color(28, 107, 160)
                area.foreground = Color(220, 240, 255)
                area.caretColor = Color(220, 240, 255)
            }

            "solarized" -> {
                area.background = Color(253, 246, 227)
                area.foreground = Color(88, 110, 117)
                area.caretColor = Color(88, 110, 117)
            }

            "pastel" -> {
                area.background = Color(255, 228, 225)
                area.foreground = Color(102, 51, 153)
                area.caretColor = Color(102, 51, 153)
            }

            "scripture" -> {
                area.background = Color(210, 185, 145)
                area.foreground = Color(35, 25, 15)
                area.caretColor = Color(35, 25, 15)
            }
        }
    }
}