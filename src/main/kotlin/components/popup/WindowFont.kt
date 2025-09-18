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

import app.texter.FONT_NAME
import app.texter.components.locales.Locales
import app.texter.updateChanges

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.GridLayout
import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.ListSelectionModel
import javax.swing.text.JTextComponent

class WindowFont {
    fun initialize(parent: JFrame, area: JTextComponent) {
        val dialog = JDialog(parent, Locales.POPUP_FONT)

        val fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().availableFontFamilyNames

        val list = JList(fonts)
        val scroll = JScrollPane(list)

        list.selectionMode = ListSelectionModel.SINGLE_SELECTION

        scroll.preferredSize = Dimension(200, 250)

        val panel = JPanel()
        val close = JButton(Locales.POPUP_FONT_CLOSE)
        val apply = JButton(Locales.POPUP_FONT_APPLY)

        close.addActionListener {
            dialog.dispose()
        }

        apply.addActionListener {
            val name = list.selectedValue

            if (name != null) {
                FONT_NAME = name

                updateChanges(area)
            }
        }

        panel.add(close)
        panel.add(apply)

        val preview = JPanel(GridLayout(3, 1, 5, 5))

        preview.preferredSize = Dimension(300, 200)
        preview.layout = BoxLayout(preview, BoxLayout.Y_AXIS)
        preview.border = BorderFactory.createTitledBorder(Locales.POPUP_FONT_PREVIEW)

        val plain = JLabel(Locales.EXAMPLE_TEXT).apply {
            isVisible = false
        }

        val bold = JLabel(Locales.EXAMPLE_TEXT).apply {
            isVisible = false
        }

        val bolditalic = JLabel(Locales.EXAMPLE_TEXT).apply {
            isVisible = false
        }

        val italic = JLabel(Locales.EXAMPLE_TEXT).apply {
            isVisible = false
        }

        preview.add(plain)
        preview.add(bold)
        preview.add(bolditalic)
        preview.add(italic)

        list.addListSelectionListener {
            val name = list.selectedValue

            if (name != null) {
                plain.font = Font(name, Font.PLAIN, 16)
                bold.font = Font(name, Font.BOLD, 16)
                bolditalic.font = Font(name, Font.BOLD or Font.ITALIC, 16)
                italic.font = Font(name, Font.ITALIC, 16)

                plain.isVisible = true
                bold.isVisible = true
                bolditalic.isVisible = true
                italic.isVisible = true
            }
        }

        dialog.add(preview, BorderLayout.WEST)
        dialog.add(scroll, BorderLayout.CENTER)
        dialog.add(panel, BorderLayout.SOUTH)

        dialog.pack()
        dialog.setLocationRelativeTo(parent)

        dialog.isResizable = false
        dialog.isVisible = true
    }
}