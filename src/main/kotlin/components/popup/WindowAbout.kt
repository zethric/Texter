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
package app.texter.components.popup

import app.texter.components.Constants
import app.texter.components.locales.Locales

import java.awt.BorderLayout
import java.awt.Font
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants

class WindowAbout {
    fun initialize(parent: JFrame) {
        val dialog = JDialog(parent, Locales.POPUP_ABOUT, false).apply {
            layout = BorderLayout()
        }

        val close = JButton("Close")
        val panel = JPanel(BorderLayout())
        val buttonPanel = JPanel()

        val text = JLabel(
            // TODO: Make into Translation Key
            "<html><div style='text-align: center;'><br>" +
                    "<span style='font-size:32pt; font-weight:bold;'>Texter</span><br>" +
                    "<span style='font-size:12pt;'>A lightweight Kotlin text editor. Version ${Constants.APPLICATION_VERSION}</span><br><br>" +
                    "<span style='font-size:10pt;'>Copyright (C) 2025 Zethric</span><br><br>" +
                    "</div></html>",

            SwingConstants.CENTER
        ).apply {
            font = Font("Arial", Font.PLAIN, 16)
        }

        panel.add(text, BorderLayout.CENTER)

        val icon = ImageIcon(javaClass.getResource("/icon.png"))
        val label = JLabel(icon, SwingConstants.CENTER)

        panel.add(label, BorderLayout.NORTH)
        dialog.add(panel, BorderLayout.CENTER)

        close.addActionListener {
            dialog.dispose()
        }

        buttonPanel.add(close)

        dialog.add(buttonPanel, BorderLayout.PAGE_END)

        dialog.setSize(400, 300)
        dialog.setLocationRelativeTo(parent)

        dialog.isResizable = false
        dialog.isVisible = true
    }
}