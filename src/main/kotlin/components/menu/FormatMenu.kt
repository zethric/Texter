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

import app.texter.FONT_STYLE
import app.texter.components.Icons
import app.texter.components.locales.Locales
import app.texter.components.popup.WindowFont
import app.texter.updateChanges

import java.awt.Font
import java.awt.event.KeyEvent
import javax.swing.ButtonGroup
import javax.swing.JCheckBoxMenuItem
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.JRadioButtonMenuItem
import javax.swing.KeyStroke
import javax.swing.text.JTextComponent

class FormatMenu {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.FORMAT).apply {
            icon = Icons.FORMAT
        }

        val font = JMenuItem(Locales.FORMAT_CHANGE_FONT).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.SHIFT_DOWN_MASK or KeyEvent.CTRL_DOWN_MASK)
        }

        val wrap = JCheckBoxMenuItem(Locales.FORMAT_WORD_WRAP, false).apply {
            // TODO: Implement
            isEnabled = false
        }

        val style = JMenu(Locales.FORMAT_FONT_STYLE)

        val regular = JRadioButtonMenuItem(Locales.FORMAT_REGULAR).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.ALT_DOWN_MASK)
            isSelected = true
        }

        val bold = JRadioButtonMenuItem(Locales.FORMAT_BOLD).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.ALT_DOWN_MASK)
        }

        val bolditalic = JRadioButtonMenuItem(Locales.FORMAT_BOLD_ITALIC).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.ALT_DOWN_MASK or KeyEvent.SHIFT_DOWN_MASK)
        }

        val italic = JRadioButtonMenuItem(Locales.FORMAT_ITALIC).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.ALT_DOWN_MASK)
        }

        val group = ButtonGroup()

        listOf(regular, bold, bolditalic, italic).forEach {
            group.add(it)
        }

        font.addActionListener {
            WindowFont().initialize(frame, area)
        }

        regular.addActionListener {
            FONT_STYLE = Font.PLAIN
            updateChanges(area)
        }

        bold.addActionListener {
            FONT_STYLE = Font.BOLD
            updateChanges(area)
        }

        bolditalic.addActionListener {
            FONT_STYLE = Font.BOLD or Font.ITALIC
            updateChanges(area)
        }

        italic.addActionListener {
            FONT_STYLE = Font.ITALIC
            updateChanges(area)
        }

        listOf(regular, italic, bold, bolditalic).forEach {
            style.add(it)
        }

        return menu.apply {
            add(font)
            add(wrap)
            addSeparator()
            add(style)
        }
    }
}