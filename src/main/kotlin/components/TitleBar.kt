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
package app.texter.components

import app.texter.components.menu.FileMenu
import app.texter.components.menu.EditMenu
import app.texter.components.menu.FormatMenu
import app.texter.components.menu.HelpMenu
import app.texter.components.menu.SearchMenu
import app.texter.components.menu.PreferencesMenu
import app.texter.components.menu.ViewMenu

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JMenuBar
import javax.swing.text.JTextComponent

class TitleBar {
    fun initialize(frame: JFrame, area: JTextComponent, status: JLabel): JMenuBar {
        val titlebar = JMenuBar()

        titlebar.add(FileMenu().initialize(frame, area))
        titlebar.add(EditMenu().initialize(frame, area))
        titlebar.add(SearchMenu().initialize(frame, area))
        titlebar.add(ViewMenu().initialize(frame, area, status))
        titlebar.add(FormatMenu().initialize(frame, area))
        titlebar.add(PreferencesMenu().initialize(frame, area))
        titlebar.add(HelpMenu().initialize(frame, area))

        return titlebar
    }
}