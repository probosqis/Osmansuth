/*
 * Copyright 2023-2024 wcaokaze
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wcaokaze.probosqis.osmansuth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import java.util.Locale

@Composable
@ReadOnlyComposable
internal actual fun language(): StrRes.Language {
   val locale = Locale.getDefault(Locale.Category.DISPLAY)
   val languageRange = Locale.LanguageRange.parse(locale.toLanguageTag())
   val langTag = Locale.lookupTag(languageRange, langTagMap.keys)
   return langTagMap[langTag] ?: StrRes.Language.ENGLISH
}

private val langTagMap = buildMap {
   put("ja", StrRes.Language.JAPANESE)
}
