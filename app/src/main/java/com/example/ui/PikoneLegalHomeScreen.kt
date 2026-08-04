package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.LegalRepository
import com.example.model.LegalDocType
import com.example.model.LegalDocument
import com.example.ui.components.DocumentReaderSheet
import com.example.ui.components.GlassmorphicCard
import com.example.ui.components.PikoneLogo
import com.example.ui.theme.PikoneBgDark
import com.example.ui.theme.PikoneBgGradientEnd
import com.example.ui.theme.PikoneCardBorderSubtle
import com.example.ui.theme.PikonePrimaryLight
import com.example.ui.theme.PikoneSuccessGlow
import com.example.ui.theme.PikoneTextMuted
import com.example.ui.theme.PikoneTextPrimary
import com.example.ui.theme.PikoneTextSecondary

@Composable
fun PikoneLegalHomeScreen(
    modifier: Modifier = Modifier
) {
    var activeDocument by remember { mutableStateOf<LegalDocument?>(null) }
    val scrollState = rememberScrollState()

    Surface(
        color = PikoneBgDark,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            PikoneBgDark,
                            PikoneBgGradientEnd,
                            Color(0xFF0C081A)
                        )
                    )
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 20.dp, vertical = 28.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Top System Status Badge
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0x1F7C3AED))
                        .border(0.8.dp, PikoneCardBorderSubtle, CircleShape)
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(PikoneSuccessGlow)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "OFFICIAL LEGAL REPOSITORY • 2026",
                            color = PikonePrimaryLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.2.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Center Logo
                PikoneLogo(
                    sizeDp = 92,
                    modifier = Modifier.testTag("pikone_center_logo")
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Title
                Text(
                    text = "Pikone Legal Center",
                    color = PikoneTextPrimary,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.5).sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.testTag("legal_center_title")
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Description
                Text(
                    text = "Official legal documents and policies for the Pikone Photo Editor.",
                    color = PikoneTextSecondary,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .testTag("legal_center_description")
                )

                Spacer(modifier = Modifier.height(36.dp))

                // Card 1: Privacy Policy
                GlassmorphicCard(
                    emojiIcon = "🔒",
                    title = "Privacy Policy",
                    description = "Learn how Pikone protects your privacy and handles your data.",
                    buttonText = "Read Privacy Policy",
                    onClick = {
                        activeDocument = LegalRepository.getDocument(LegalDocType.PRIVACY_POLICY)
                    },
                    testTag = "privacy_policy_card"
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Card 2: Terms of Use
                GlassmorphicCard(
                    emojiIcon = "📜",
                    title = "Terms of Use",
                    description = "Read the terms and conditions for using Pikone.",
                    buttonText = "Read Terms of Use",
                    onClick = {
                        activeDocument = LegalRepository.getDocument(LegalDocType.TERMS_OF_USE)
                    },
                    testTag = "terms_of_use_card"
                )

                Spacer(modifier = Modifier.height(48.dp))

                // Footer
                Text(
                    text = "© 2026 Pikone. All rights reserved.",
                    color = PikoneTextMuted,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.testTag("legal_center_footer")
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Reader Overlay Modal
            AnimatedVisibility(
                visible = activeDocument != null,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                activeDocument?.let { doc ->
                    DocumentReaderSheet(
                        document = doc,
                        onDismiss = { activeDocument = null },
                        modifier = Modifier.testTag("document_reader_modal")
                    )
                }
            }
        }
    }
}
