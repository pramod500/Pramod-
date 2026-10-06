package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.OfficialPortal
import com.example.ui.components.OfficialNoticeDisclaimer
import com.example.ui.components.openWebUrl
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

@Composable
fun OfficialLinksScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val portals by viewModel.officialPortals.collectAsState()
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("official_links_screen"),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = DeepNavy),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isMarathi) "महत्त्वाची अधिकृत शासकीय संकेतस्थळे" else "Important Official Government Portals",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = if (isMarathi)
                            "विद्यार्थी व पालकांसाठी सर्व अधिकृत भरती, प्रवेश व शिष्यवृत्ती पोर्टल्सची पडताळणी केलेली यादी."
                        else
                            "Verified directory of official state & national recruitment, admission and scholarship portals.",
                        color = Color(0xFFE2E8F0),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        item {
            OfficialNoticeDisclaimer(isMarathi = isMarathi)
        }

        items(portals, key = { it.id }) { portal ->
            OfficialPortalCard(
                portal = portal,
                isMarathi = isMarathi,
                onOpen = { openWebUrl(context, portal.url) }
            )
        }
    }
}

@Composable
fun OfficialPortalCard(
    portal: OfficialPortal,
    isMarathi: Boolean,
    onOpen: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(NavyBlue.copy(alpha = 0.1f))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = portal.category,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyBlue
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Official",
                        tint = ForestGreen,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isMarathi) "अधिकृत संकेतस्थळ" else "Official Website",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = ForestGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = if (isMarathi) portal.nameMr else portal.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "प्राधिकरण: ${portal.authority}",
                fontSize = 12.sp,
                color = SaffronOrange,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = if (isMarathi) portal.descriptionMr else portal.descriptionEn,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = portal.url,
                    fontSize = 11.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = onOpen,
                    colors = ButtonDefaults.buttonColors(containerColor = NavyBlue),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = if (isMarathi) "पोर्टल उघडा" else "Open Portal",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.OpenInNew,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}
