package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.OpportunityCategory
import com.example.model.OpportunityItem
import com.example.model.OpportunityStatus
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.StatusActive
import com.example.ui.theme.StatusClosing
import com.example.ui.theme.StatusNew

fun openWebUrl(context: Context, url: String) {
    if (url.isBlank()) {
        Toast.makeText(context, "अधिकृत लिंक उपलब्ध नाही (Official link unavailable)", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        val uri = if (url.startsWith("http://") || url.startsWith("https://")) {
            Uri.parse(url)
        } else {
            Uri.parse("https://$url")
        }
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "वेबसाइट उघडताना त्रुटी (Error opening URL)", Toast.LENGTH_SHORT).show()
    }
}

fun shareOpportunity(context: Context, item: OpportunityItem, isMarathi: Boolean) {
    val title = if (isMarathi) item.titleMr else item.title
    val desc = if (isMarathi) item.descriptionMr else item.description
    val shareText = """
        🎓 $title
        📌 ${item.subCategory}
        📝 पात्रता: ${if (isMarathi) item.qualificationMr else item.qualification}
        ${if (item.vacancies.isNotBlank()) "👥 जागा: ${item.vacancies}" else ""}
        ${if (item.lastDate.isNotBlank()) "⏰ शेवटची तारीख: ${item.lastDate}" else ""}
        🔗 अधिकृत लिंक: ${item.officialUrl}
        
        शिक्षण व करिअर मार्गदर्शक ॲपवरून शेअर केले
    """.trimIndent()

    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareText)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "शेअर करा (Share Opportunity)")
    context.startActivity(shareIntent)
}

@Composable
fun StatusBadgeView(status: OpportunityStatus, isMarathi: Boolean) {
    val (bgColor, textColor, text) = when (status) {
        OpportunityStatus.NEW -> Triple(Color(0xFFFEE2E2), StatusNew, if (isMarathi) "नवीन" else "NEW")
        OpportunityStatus.ACTIVE -> Triple(Color(0xFFDCFCE7), StatusActive, if (isMarathi) "सुरू आहे" else "ACTIVE")
        OpportunityStatus.CLOSING_SOON -> Triple(Color(0xFFFEF3C7), StatusClosing, if (isMarathi) "मुदत संपत आहे" else "CLOSING SOON")
        OpportunityStatus.CLOSED -> Triple(Color(0xFFF1F5F9), Color(0xFF64748B), if (isMarathi) "मुदत संपली" else "CLOSED")
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun OpportunityCard(
    item: OpportunityItem,
    language: AppLanguage,
    onCardClick: () -> Unit,
    onBookmarkToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isMarathi = language == AppLanguage.MARATHI
    val title = if (isMarathi) item.titleMr else item.title
    val desc = if (isMarathi) item.descriptionMr else item.description
    val qual = if (isMarathi) item.qualificationMr else item.qualification

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .testTag("opportunity_card_${item.id}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(NavyBlue.copy(alpha = 0.1f))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = item.subCategory,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = NavyBlue
                        )
                    }
                    if (item.isVerified) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Verified",
                            tint = ForestGreen,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = if (isMarathi) "अधिकृत" else "Verified",
                            fontSize = 10.sp,
                            color = ForestGreen,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    StatusBadgeView(status = item.status, isMarathi = isMarathi)
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = onBookmarkToggle,
                        modifier = Modifier.size(36.dp).testTag("bookmark_button_${item.id}")
                    ) {
                        Icon(
                            imageVector = if (item.isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Save",
                            tint = if (item.isBookmarked) SaffronOrange else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = desc,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Details pill row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Qualification
                if (qual.isNotBlank()) {
                    Text(
                        text = "🎓 $qual",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = DeepNavy,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Vacancies or Duration
                if (item.vacancies.isNotBlank()) {
                    Text(
                        text = "👥 ${item.vacancies}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ForestGreen
                    )
                } else if (item.duration.isNotBlank()) {
                    Text(
                        text = "⏱ ${item.duration}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ForestGreen
                    )
                }
            }

            if (item.lastDate.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = "Last Date",
                        tint = SaffronOrange,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${if (isMarathi) "शेवटची तारीख:" else "Last Date:"} ${item.lastDate}",
                        fontSize = 11.sp,
                        color = SaffronOrange,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onCardClick,
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(36.dp).testTag("view_details_${item.id}")
                ) {
                    Text(
                        text = if (isMarathi) "सविस्तर माहिती" else "View Details",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Row {
                    IconButton(
                        onClick = { shareOpportunity(context, item, isMarathi) },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    if (item.officialUrl.isNotBlank()) {
                        Button(
                            onClick = { openWebUrl(context, item.officialUrl) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = NavyBlue),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                            modifier = Modifier.height(36.dp).testTag("apply_link_${item.id}")
                        ) {
                            Text(
                                text = if (isMarathi) "अधिकृत लिंक" else "Apply Link",
                                fontSize = 12.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = "External link",
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OfficialNoticeDisclaimer(isMarathi: Boolean, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF3C7)),
        shape = RoundedCornerShape(10.dp),
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFF59E0B)))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "⚠️",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Column {
                Text(
                    text = if (isMarathi)
                        "महत्त्वाची सूचना (मार्गदर्शन पोर्टल):"
                    else
                        "Important Notice (Guidance Portal):",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                )
                Text(
                    text = if (isMarathi)
                        "ही माहिती केवळ विद्यार्थी व पालकांच्या मार्गदर्शनासाठी आहे. अर्ज करण्यापूर्वी संबंधित अधिकृत संकेतस्थळावरील अधिकृत जाहिरात/नोटिफिकेशन काळजीपूर्वक तपासा."
                    else
                        "This portal is for student guidance only. Always verify notifications on respective official government portals before applying.",
                    fontSize = 11.sp,
                    color = Color(0xFF78350F),
                    lineHeight = 15.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}
