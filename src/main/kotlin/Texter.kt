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
package app.texter

import app.texter.components.Constants
import app.texter.components.TitleBar

import java.awt.BorderLayout
import java.awt.Font
import javax.swing.*
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.JTextComponent

var FONT_NAME = Constants.DEFAULT_FONT_NAME
var FONT_SIZE = Constants.DEFAULT_FONT_SIZE
var FONT_STYLE = Constants.DEFAULT_FONT_STYLE

fun main() {
    initialize()
}

private fun initialize() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    } catch (exception: Exception) {
        exception.printStackTrace()
    }

    val frame = JFrame(Constants.APPLICATION_NAME)
    val status = JLabel()
    val text = JTextArea()

    text.tabSize = 1
    text.font = Font(FONT_NAME, FONT_STYLE, FONT_SIZE)

    val scroll = JScrollPane(text).apply {
        horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
    }

    status.border = BorderFactory.createEmptyBorder(2, 5, 2, 5)

    frame.add(scroll)
    frame.add(status, BorderLayout.SOUTH)

    frame.jMenuBar = (TitleBar().initialize(frame, text, status))
    frame.iconImage = Constants.APPLICATION_ICON.image
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    frame.setSize(Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT)
    frame.setLocationRelativeTo(null)

    frame.isVisible = true

    SwingUtilities.invokeLater {
        refreshStatusBar(text, status)
        handleListeners(text, status)
    }
}

fun updateChanges(area: JTextComponent) {
    FONT_SIZE = FONT_SIZE.coerceIn(Constants.MIN_FONT_SIZE, Constants.MAX_FONT_SIZE)

    area.font = Font(FONT_NAME, FONT_STYLE, FONT_SIZE)
}

private fun refreshStatusBar(text: JTextArea, status: JLabel) {
    val content = text.text

    val lines = content.lines().size

    val words = content.split("\\s+".toRegex()).filter {
        it.isNotEmpty()
    }.size

    val symbols = content.replace("\r", "").replace("\n", "").length

    status.text = "Words: $words | Lines: $lines Symbols: $symbols"
}

private fun handleListeners(text: JTextArea, status: JLabel) {
    text.document.addDocumentListener(object : DocumentListener {
        override fun insertUpdate(e: DocumentEvent) = refreshStatusBar(text, status)
        override fun removeUpdate(e: DocumentEvent) = refreshStatusBar(text, status)
        override fun changedUpdate(e: DocumentEvent) = refreshStatusBar(text, status)
    })
}