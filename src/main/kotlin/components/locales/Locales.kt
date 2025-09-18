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
package app.texter.components.locales

import app.texter.components.Constants

object Locales {
    const val FILE     = "File"
    const val EDIT     = "Edit"
    const val FORMAT   = "Format"
    const val HELP     = "Help"
    const val SEARCH   = "Search"
    const val PREFERENCES = "Preferences"
    const val VIEW     = "View"

    const val FILE_NEW  = "New"
    const val FILE_OPEN = "Open..."
    const val FILE_SAVE = "Save..."
    const val FILE_EXIT = "Exit ${Constants.APPLICATION_NAME}"

    const val EDIT_UNDO  = "Undo"
    const val EDIT_DELETE  = "Delete"
    const val EDIT_SELECT_ALL  = "Select All"
    const val EDIT_SEARCH_WEB  = "Search with Google..."
    const val EDIT_CUT  = "Cut"
    const val EDIT_COPY  = "Copy"
    const val EDIT_PASTE  = "Paste"
    const val EDIT_DATE_TIME  = "Date/Time"

    const val VIEW_STATUS_BAR  = "Status Bar"
    const val VIEW_ZOOM_IN  = "Zoom In"
    const val VIEW_ZOOM_OUT  = "Zoom In"
    const val VIEW_ZOOM_RESTORE  = "Restore Default Zoom"

    const val HELP_ABOUT  = "About ${Constants.APPLICATION_NAME}..."
    const val HELP_SEND_FEEDBACK  = "Send Feedback"

    const val FORMAT_WORD_WRAP  = "Word Wrap"
    const val FORMAT_CHANGE_FONT  = "Font..."
    const val FORMAT_FONT_STYLE  = "Font Style"

    const val FORMAT_REGULAR  = "<html>Regular</html>"
    const val FORMAT_BOLD = "<html><b>Bold</b></html>"
    const val FORMAT_BOLD_ITALIC = "<html><b><i>Bold Italic</i></b></html>"
    const val FORMAT_ITALIC = "<html><i>Italic</i></html>"

    const val PREFERENCES_SETTINGS = "Settings"
    const val PREFERENCES_APPEARANCE = "Appearance"
    const val PREFERENCES_THEME_SYSTEM = "System Default"
    const val PREFERENCES_THEME_DARK = "Dark Theme"
    const val PREFERENCES_THEME_LIGHT = "Light Theme"
    const val PREFERENCES_THEME_MATRIX = "Matrix Theme"
    const val PREFERENCES_THEME_OCEAN = "Ocean Blue Theme"
    const val PREFERENCES_THEME_SOLARIZED = "Solarized Theme"
    const val PREFERENCES_THEME_PASTEL = "Pastel Theme"
    const val PREFERENCES_THEME_SCRIPTURE = "Scripture Theme"

    const val SEARCH_FIND = "Find..."
    const val SEARCH_REPLACE = "Replace..."

    const val POPUP_ABOUT = "About ${Constants.APPLICATION_NAME}"

    const val POPUP_FIND = "Find"
    const val POPUP_FIND_WHAT = "Find what:"
    const val POPUP_FIND_NEXT = "Find Next"
    const val POPUP_FIND_CANCEL = "Cancel"
    const val POPUP_FIND_MATCHES_NULL = "Matches: 0"
    const val POPUP_FIND_MATCHES = "Matches:"
    const val POPUP_FIND_MATCH_CASE = "Match case"

    const val POPUP_FONT = "Select Font"
    const val POPUP_FONT_CLOSE = "Close"
    const val POPUP_FONT_APPLY = "Apply"
    const val POPUP_FONT_PREVIEW = "Preview"

    const val EXAMPLE_TEXT = "The quick brown fox jumps over the lazy dog"
}