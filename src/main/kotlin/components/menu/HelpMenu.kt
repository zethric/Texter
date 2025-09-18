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
import app.texter.components.popup.WindowAbout

import java.awt.Desktop
import java.awt.event.KeyEvent
import java.net.URI
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.KeyStroke
import javax.swing.text.JTextComponent

class HelpMenu {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.HELP).apply {
            icon = Icons.HELP
        }

        val send = JMenuItem(Locales.HELP_SEND_FEEDBACK)

        val about = JMenuItem(Locales.HELP_ABOUT).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0)
        }

        send.addActionListener {
            try {
                Desktop.getDesktop().browse(URI("https://github.com/zethric"))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }

        about.addActionListener {
            WindowAbout().initialize(frame)
        }

        return menu.apply {
            add(send)
            addSeparator()
            add(about)
        }
    }
}