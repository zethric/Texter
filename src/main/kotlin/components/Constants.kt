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

import java.awt.Font

object Constants {
    const val APPLICATION_VERSION = 1.0

    val APPLICATION_ICON = Icons.APP

    const val APPLICATION_NAME = "Texter"

    const val DEFAULT_WIDTH = 640
    const val DEFAULT_HEIGHT = 512

    const val DEFAULT_FONT_NAME = "Consolas"
    const val DEFAULT_FONT_SIZE = 16
    const val DEFAULT_FONT_STYLE = Font.PLAIN

    const val MAX_FONT_SIZE = 128
    const val MIN_FONT_SIZE = 8
}