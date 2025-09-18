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

import app.texter.FONT_SIZE
import app.texter.components.Icons
import app.texter.components.locales.Locales
import app.texter.updateChanges

import java.awt.event.KeyEvent
import javax.swing.JCheckBoxMenuItem
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.KeyStroke
import javax.swing.text.JTextComponent

class ViewMenu {
    fun initialize(frame: JFrame, area: JTextComponent, bar: JLabel): JMenu {
        val menu = JMenu(Locales.VIEW).apply {
            icon = Icons.VIEW
        }

        val zoomin = JMenuItem(Locales.VIEW_ZOOM_IN).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK)
        }

        val zoomout = JMenuItem(Locales.VIEW_ZOOM_OUT).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK)
        }

        val restore = JMenuItem(Locales.VIEW_ZOOM_RESTORE).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK)
        }

        val status = JCheckBoxMenuItem(Locales.VIEW_STATUS_BAR, true)

        zoomin.addActionListener {
            FONT_SIZE += 8
            updateChanges(area)
        }

        zoomout.addActionListener {
            FONT_SIZE -= 8
            updateChanges(area)
        }

        restore.addActionListener {
            FONT_SIZE = 16
            updateChanges(area)
        }

        status.addActionListener {
            bar.isVisible = status.isSelected

            bar.revalidate()
            bar.repaint()
        }

        return menu.apply {
            add(zoomin)
            add(zoomout)
            add(restore)
            addSeparator()
            add(status)
        }
    }
}