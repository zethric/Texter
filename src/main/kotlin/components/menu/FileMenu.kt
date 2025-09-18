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

import java.awt.event.KeyEvent
import java.io.File
import javax.swing.*
import javax.swing.text.JTextComponent

class FileMenu() {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.FILE).apply {
            icon = Icons.FILE
        }

        val chooser = JFileChooser()

        val newItem = JMenuItem(Locales.FILE_NEW).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK)
        }

        val openItem = JMenuItem(Locales.FILE_OPEN).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK)
        }

        val saveItem = JMenuItem(Locales.FILE_SAVE).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK)
        }

        val exitItem = JMenuItem(Locales.FILE_EXIT).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK)
        }

        newItem.addActionListener {
            area.text = ""
        }

        openItem.addActionListener {
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                area.text = chooser.selectedFile.readText()
            }
        }

        saveItem.addActionListener {
            if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                val file = File(chooser.selectedFile.parentFile, chooser.selectedFile.name)

                file.writeText(area.text)
            }
        }

        exitItem.addActionListener {
            frame.dispose()
        }

        return menu.apply {
            add(newItem)
            add(openItem)
            add(saveItem)
            addSeparator()
            add(exitItem)
        }
    }
}