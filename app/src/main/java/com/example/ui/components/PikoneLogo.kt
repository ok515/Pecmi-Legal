package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.PikoneCardBorder
import com.example.ui.theme.PikonePrimary
import com.example.ui.theme.PikonePrimaryLight
import com.example.ui.theme.PikoneTextPrimary

@Composable
fun PikoneLogo(
    modifier: Modifier = Modifier,
    sizeDp: Int = 88
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .shadow(
                    elevation = 24.dp,
                    shape = RoundedCornerShape(26.dp),
                    spotColor = PikonePrimary,
                    ambientColor = PikonePrimaryLight
                )
                .size(sizeDp.dp)
                .clip(RoundedCornerShape(26.dp))
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF26134D),
                            Color(0xFF140C2E),
                            Color(0xFF0F0B1F)
                        )
                    )
                )
                .border(
                    width = 1.5.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            PikonePrimaryLight,
                            PikoneCardBorder,
                            Color(0x227C3AED)
                        )
                    ),
                    shape = RoundedCornerShape(26.dp)
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.pikone_logo_1785808421457),
                contentDescription = "Pikone Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size((sizeDp * 0.85).dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Brand Logotype Text
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0x227C3AED))
                .border(0.5.dp, Color(0x55A855F7), CircleShape)
                .padding(horizontal = 14.dp, vertical = 4.dp)
        ) {
            Text(
                text = "PIKONE",
                color = PikoneTextPrimary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.5.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}
