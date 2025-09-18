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

import java.awt.Desktop
import java.awt.event.KeyEvent
import java.net.URI
import java.net.URLEncoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.Action
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.KeyStroke
import javax.swing.text.DefaultEditorKit
import javax.swing.text.JTextComponent
import javax.swing.undo.UndoManager

class EditMenu {
    fun initialize(frame: JFrame, area: JTextComponent): JMenu {
        val menu = JMenu(Locales.EDIT).apply {
            icon = Icons.EDIT
        }

        val manager = UndoManager()

        area.document.addUndoableEditListener {
            manager.addEdit(it.edit)
        }

        val delete = JMenuItem(Locales.EDIT_DELETE).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)
            isEnabled = false
        }

        val selectAll = JMenuItem(Locales.EDIT_SELECT_ALL).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK)
        }

        val searchweb = JMenuItem(Locales.EDIT_SEARCH_WEB).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK)
            isEnabled = false
        }

        val undo = JMenuItem(Locales.EDIT_UNDO).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK)
            isEnabled = false

            addActionListener {
                if (manager.canUndo()) {
                    manager.undo()
                }
                isEnabled = manager.canUndo()
            }

            area.document.addUndoableEditListener {
                isEnabled = manager.canUndo()
            }
        }

        val cut = JMenuItem(DefaultEditorKit.CutAction().apply {
            putValue(Action.NAME, Locales.EDIT_CUT)
        }).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK)
            isEnabled = false
        }

        val copy = JMenuItem(DefaultEditorKit.CopyAction().apply {
            putValue(Action.NAME, Locales.EDIT_COPY)
        }).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK)
            isEnabled = false
        }

        val paste = JMenuItem(DefaultEditorKit.PasteAction().apply {
            putValue(Action.NAME, Locales.EDIT_PASTE)
        }).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK)
        }

        val datetime = JMenuItem(Locales.EDIT_DATE_TIME).apply {
            accelerator = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0)
        }

        area.addCaretListener {
            val hasSelection = !area.selectedText.isNullOrEmpty()

            cut.isEnabled = hasSelection
            copy.isEnabled = hasSelection
            delete.isEnabled = hasSelection
            searchweb.isEnabled = hasSelection
        }

        selectAll.addActionListener {
            area.selectAll()
        }

        searchweb.addActionListener {
            val query = area.selectedText?.trim()

            if (!query.isNullOrEmpty()) {
                try {
                    val url = "https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")

                    Desktop.getDesktop().browse(URI(url))
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }

        delete.addActionListener {
            area.replaceSelection("")
        }

        datetime.addActionListener {
            val string = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"))

            try {
                area.document.insertString(area.caretPosition, string, null)
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }

        return menu.apply {
            add(undo)
            addSeparator()
            add(cut)
            add(copy)
            add(paste)
            add(delete)
            addSeparator()
            add(searchweb)
            addSeparator()
            add(selectAll)
            add(datetime)
        }
    }
}