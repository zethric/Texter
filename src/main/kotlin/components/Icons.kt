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

import javax.swing.ImageIcon

object Icons {
    val APP = ImageIcon(ClassLoader.getSystemResource("icon.png"))
    val FILE = ImageIcon(ClassLoader.getSystemResource("icons/folder_page.png"))
    val FORMAT = ImageIcon(ClassLoader.getSystemResource("icons/style.png"))
    val PREFERENCES = ImageIcon(ClassLoader.getSystemResource("icons/wrench.png"))
    val HELP = ImageIcon(ClassLoader.getSystemResource("icons/help.png"))
    val SEARCH = ImageIcon(ClassLoader.getSystemResource("icons/magnifier.png"))
    val EDIT = ImageIcon(ClassLoader.getSystemResource("icons/pencil.png"))
    val VIEW = ImageIcon(ClassLoader.getSystemResource("icons/eye.png"))
    val APPEARANCE = ImageIcon(ClassLoader.getSystemResource("icons/color_wheel.png"))
    val SETTINGS = ImageIcon(ClassLoader.getSystemResource("icons/cog.png"))
}