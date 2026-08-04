package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Language
import com.example.model.LegalDocument
import com.example.model.LegalSection
import com.example.ui.theme.PikoneBgDark
import com.example.ui.theme.PikoneCardBorder
import com.example.ui.theme.PikoneCardBorderSubtle
import com.example.ui.theme.PikonePrimary
import com.example.ui.theme.PikonePrimaryLight
import com.example.ui.theme.PikoneSurfaceCard
import com.example.ui.theme.PikoneTextMuted
import com.example.ui.theme.PikoneTextPrimary
import com.example.ui.theme.PikoneTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentReaderSheet(
    document: LegalDocument,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var currentLanguage by remember { mutableStateOf(Language.ENGLISH) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedSectionIndex by remember { mutableStateOf<Int?>(null) }

    val docTitle = if (currentLanguage == Language.ENGLISH) document.type.titleEn else document.type.titleAr
    val lastUpdated = if (currentLanguage == Language.ENGLISH) document.lastUpdatedEn else document.lastUpdatedAr
    val summary = if (currentLanguage == Language.ENGLISH) document.summaryEn else document.summaryAr

    val filteredSections = remember(document, searchQuery, currentLanguage) {
        if (searchQuery.isBlank()) {
            document.sections
        } else {
            document.sections.filter { sec ->
                val title = if (currentLanguage == Language.ENGLISH) sec.titleEn else sec.titleAr
                val content = if (currentLanguage == Language.ENGLISH) sec.contentEn else sec.contentAr
                title.contains(searchQuery, ignoreCase = true) || content.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Surface(
        color = PikoneBgDark,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            // Header Bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0x227C3AED))
                        .testTag("back_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = PikoneTextPrimary
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = document.type.icon,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = docTitle,
                        color = PikoneTextPrimary,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Language Toggle Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0x337C3AED))
                        .border(1.dp, Color(0x66A855F7), RoundedCornerShape(12.dp))
                        .clickable {
                            currentLanguage = if (currentLanguage == Language.ENGLISH) Language.ARABIC else Language.ENGLISH
                        }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("language_toggle")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Language,
                            contentDescription = "Switch language",
                            tint = PikonePrimaryLight,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (currentLanguage == Language.ENGLISH) "العربية" else "English",
                            color = PikoneTextPrimary,
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // Document Info Subheader
            Card(
                colors = CardDefaults.cardColors(containerColor = PikoneSurfaceCard),
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, PikoneCardBorderSubtle),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = summary,
                        color = PikoneTextSecondary,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (currentLanguage == Language.ENGLISH) "Last Updated: $lastUpdated" else "آخر تحديث: $lastUpdated",
                        color = PikoneTextMuted,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        text = if (currentLanguage == Language.ENGLISH) "Search clauses or keywords..." else "ابحث في البنود والشروط...",
                        color = PikoneTextMuted,
                        fontSize = 13.5.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = PikonePrimaryLight
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear",
                                tint = PikoneTextMuted
                            )
                        }
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PikonePrimary,
                    unfocusedBorderColor = PikoneCardBorderSubtle,
                    focusedContainerColor = Color(0x3317102E),
                    unfocusedContainerColor = Color(0x2217102E),
                    focusedTextColor = PikoneTextPrimary,
                    unfocusedTextColor = PikoneTextPrimary
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .testTag("doc_search_input")
            )

            // Section Shortcut Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 6.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (selectedSectionIndex == null) PikonePrimary else Color(0x227C3AED)
                            )
                            .clickable { selectedSectionIndex = null }
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = if (currentLanguage == Language.ENGLISH) "All Sections" else "جميع البنود",
                            color = PikoneTextPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                items(document.sections) { sec ->
                    val isSelected = selectedSectionIndex?.toString() == sec.number
                    val secTitle = if (currentLanguage == Language.ENGLISH) "Sec ${sec.number}" else "البند ${sec.number}"
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (isSelected) PikonePrimary else Color(0x11A855F7)
                            )
                            .border(0.5.dp, PikoneCardBorderSubtle, CircleShape)
                            .clickable { selectedSectionIndex = sec.number.toIntOrNull() }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = secTitle,
                            color = if (isSelected) PikoneTextPrimary else PikoneTextSecondary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Sections List
            val displayedSections = if (selectedSectionIndex != null) {
                filteredSections.filter { it.number == selectedSectionIndex.toString() }
            } else {
                filteredSections
            }

            if (displayedSections.isEmpty()) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Text(
                        text = if (currentLanguage == Language.ENGLISH) "No clauses found matching '$searchQuery'" else "لم يتم العثور على بنود تطابق '$searchQuery'",
                        color = PikoneTextMuted,
                        fontSize = 14.sp
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(displayedSections, key = { it.number }) { sec ->
                        SectionCard(
                            section = sec,
                            language = currentLanguage,
                            onCopy = {
                                val textToCopy = "${sec.number}. ${if (currentLanguage == Language.ENGLISH) sec.titleEn else sec.titleAr}\n\n${if (currentLanguage == Language.ENGLISH) sec.contentEn else sec.contentAr}"
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText("Legal Clause", textToCopy)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, if (currentLanguage == Language.ENGLISH) "Clause copied to clipboard" else "تم نسخ البند إلى الحافظة", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionCard(
    section: LegalSection,
    language: Language,
    onCopy: () -> Unit
) {
    val title = if (language == Language.ENGLISH) section.titleEn else section.titleAr
    val content = if (language == Language.ENGLISH) section.contentEn else section.contentAr

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF140D2B)),
        shape = RoundedCornerShape(18.dp),
        border = androidx.compose.foundation.BorderStroke(0.8.dp, PikoneCardBorder),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(PikonePrimary)
                    ) {
                        Text(
                            text = section.number,
                            color = PikoneTextPrimary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = title,
                        color = PikoneTextPrimary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = onCopy,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "Copy section",
                        tint = PikonePrimaryLight,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = content,
                color = PikoneTextSecondary,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
