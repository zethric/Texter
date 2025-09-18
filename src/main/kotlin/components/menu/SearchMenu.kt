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
import app.texter.components.popup.WindowFind

import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.KeyStroke
import javax.swing.text.JTextComponent

class SearchMenu {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.SEARCH).apply {
            icon = Icons.SEARCH
        }

        val find = JMenuItem(Locales.SEARCH_FIND).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK)
            isEnabled = true
        }

        find.addActionListener {
            WindowFind().initialize(frame, area)
        }

        return menu.apply {
            add(find)
        }
    }
}