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

import app.texter.components.locales.Locales

import java.awt.BorderLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.text.JTextComponent

class WindowFind {
    fun initialize(parent: JFrame, area: JTextComponent) {
        val dialog = JDialog(parent, Locales.POPUP_FIND, false)

        dialog.layout = BorderLayout()
        dialog.defaultCloseOperation = JDialog.DISPOSE_ON_CLOSE
        dialog.isResizable = false

        val search = JTextField(20)
        val next = JButton(Locales.POPUP_FIND_NEXT)
        val cancel = JButton(Locales.POPUP_FIND_CANCEL)
        val status = JLabel(Locales.POPUP_FIND_MATCHES_NULL)

        val matchCase = JCheckBox(Locales.POPUP_FIND_MATCH_CASE)

        cancel.addActionListener {
            dialog.dispose()
        }

        next.addActionListener {
            val text = search.text
            val content = area.text

            val options = if (!matchCase.isSelected) {
                setOf(RegexOption.IGNORE_CASE)
            } else emptySet()

            val matches = Regex(Regex.escape(text), options).findAll(content).count()

            status.text = "${Locales.POPUP_FIND_MATCHES} $matches"

            val startPos = area.caretPosition
            val index = content.indexOf(text, startPos, !matchCase.isSelected)

            if (index != -1) {
                area.select(index, index + text.length)
            } else {
                val wrapper = content.indexOf(text, 0, !matchCase.isSelected)

                if (wrapper != -1) {
                    area.select(wrapper, wrapper + text.length)
                }
            }
        }

        val gridbag = GridBagConstraints().apply {
            insets = Insets(5, 5, 5, 5)
            anchor = GridBagConstraints.WEST
        }

        // TODO: Clean
        val top = JPanel(GridBagLayout()).apply {
            gridbag.gridx = 0
            gridbag.gridy = 0
            gridbag.anchor = GridBagConstraints.WEST
            add(JLabel(Locales.POPUP_FIND_WHAT), gridbag)

            gridbag.gridx = 1
            gridbag.gridy = 0
            gridbag.fill = GridBagConstraints.HORIZONTAL
            gridbag.weightx = 1.0
            add(search, gridbag)

            gridbag.gridx = 2
            gridbag.gridy = 0
            gridbag.fill = GridBagConstraints.NONE
            gridbag.weightx = 0.0
            add(next, gridbag)

            gridbag.gridx = 0
            gridbag.gridy = 1
            gridbag.anchor = GridBagConstraints.WEST
            add(matchCase, gridbag)

            gridbag.gridx = 2
            gridbag.gridy = 1
            gridbag.anchor = GridBagConstraints.EAST
            add(cancel, gridbag)

            gridbag.gridx = 0
            gridbag.gridy = 2
            gridbag.gridwidth = 3
            gridbag.anchor = GridBagConstraints.WEST
            add(status, gridbag)
        }

        dialog.add(top, BorderLayout.NORTH)

        dialog.pack()
        dialog.setLocationRelativeTo(parent)
        dialog.isVisible = true
    }
}