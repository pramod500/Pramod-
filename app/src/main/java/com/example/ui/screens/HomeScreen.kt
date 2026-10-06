package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Engineering
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.OpportunityCategory
import com.example.model.OpportunityItem
import com.example.model.OpportunityStatus
import com.example.ui.components.OfficialNoticeDisclaimer
import com.example.ui.components.OpportunityCard
import com.example.ui.components.VisualCareerFlowchart
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.RoyalPurple
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    onNavigateToCategory: (OpportunityCategory) -> Unit,
    onNavigateToQuiz: () -> Unit,
    onNavigateToOfficialLinks: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val searchQuery by viewModel.searchQuery.collectAsState()
    val items by viewModel.items.collectAsState()

    var updateTabFilter by remember { mutableIntStateOf(0) }
    val updateTabs = if (isMarathi) {
        listOf("सर्व अपडेट्स", "🔴 शासकीय नोकऱ्या", "🔵 प्रवेश २०२६", "🟠 शिष्यवृत्ती", "🟡 स्पर्धा परीक्षा", "🇮🇳 संरक्षण")
    } else {
        listOf("All Updates", "🔴 Govt Jobs", "🔵 Admissions", "🟠 Scholarships", "🟡 Exams", "🇮🇳 Defence")
    }

    val liveUpdates = items.filter { item ->
        when (updateTabFilter) {
            1 -> item.category == OpportunityCategory.GOVT_JOB
            2 -> item.category == OpportunityCategory.ADMISSION
            3 -> item.category == OpportunityCategory.SCHOLARSHIP
            4 -> item.category == OpportunityCategory.COMPETITIVE_EXAM
            5 -> item.category == OpportunityCategory.DEFENCE
            else -> item.status == OpportunityStatus.NEW || item.status == OpportunityStatus.CLOSING_SOON || item.status == OpportunityStatus.ACTIVE
        }
    }.take(8)

    val quickChips = listOf(
        "10th pass",
        "12th Science",
        "B.Sc Agriculture",
        "Diploma",
        "Police Bharti",
        "MPSC",
        "MahaDBT",
        "ITI Electrician",
        "Engineering"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen_scroll"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        // Hero Tagline Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DeepNavy)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(SaffronOrange)
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = if (isMarathi) "महाराष्ट्र करिअर व शिक्षण दालन" else "Maharashtra Education & Career Portal",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        TextButton(
                            onClick = onNavigateToOfficialLinks,
                            colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFFBBDEFB))
                        ) {
                            Text(
                                text = if (isMarathi) "🌐 अधिकृत पोर्टल्स" else "🌐 Official Portals",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isMarathi)
                            "१० वी नंतर योग्य शिक्षण, योग्य करिअर आणि योग्य संधी शोधा"
                        else
                            "Find the Right Education, Right Career & Right Opportunities",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 26.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isMarathi)
                            "तुमच्या भविष्यासाठी योग्य मार्ग शोधा • शासकीय नोकऱ्या, प्रवेश, शिष्यवृत्ती व कॉलेजेस"
                        else
                            "All-in-one guidance for 10th/12th students, job seekers, and parents",
                        color = Color(0xFFE2E8F0),
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Universal Super Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { viewModel.setSearchQuery(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .testTag("home_search_field"),
                        placeholder = {
                            Text(
                                text = if (isMarathi)
                                    "Job / Course / College / Exam / Training शोधा..."
                                else
                                    "Search Job, Course, College, Exam, Admission...",
                                fontSize = 13.sp,
                                color = Color.Gray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = NavyBlue
                            )
                        },
                        trailingIcon = {
                            if (searchQuery.isNotBlank()) {
                                IconButton(onClick = { viewModel.setSearchQuery("") }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = SaffronOrange,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Quick Search Suggestion Chips
                    Text(
                        text = if (isMarathi) "लोकप्रिय शोध (Quick Search):" else "Popular Searches:",
                        fontSize = 11.sp,
                        color = Color(0xFFCBD5E1),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(quickChips) { chip ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color.White.copy(alpha = 0.15f))
                                    .clickable { viewModel.setSearchQuery(chip) }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = chip,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }

        // Official notice disclaimer
        item {
            OfficialNoticeDisclaimer(
                isMarathi = isMarathi,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }

        // Interactive Visual Career Flowchart Section
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isMarathi) "📊 १० वी नंतर करिअर फ्लोचार्ट" else "📊 Career Pathways Flow",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    TextButton(onClick = onNavigateToQuiz) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = null,
                            tint = SaffronOrange,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isMarathi) "करिअर मार्गदर्शक चाचणी" else "Career Quiz",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronOrange
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                VisualCareerFlowchart(
                    isMarathi = isMarathi,
                    onNodeClick = { onNavigateToCategory(it) }
                )
            }
        }

        // Quick Category Navigation Cards Grid
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = if (isMarathi) "📌 सर्व संधी विभाग (All Opportunities)" else "📌 All Opportunity Sectors",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(12.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 3
                ) {
                    CategoryTile(
                        icon = Icons.Default.School,
                        title = if (isMarathi) "११ वी - १२ वी" else "11th - 12th",
                        badge = "४ शाखा",
                        color = NavyBlue,
                        onClick = { onNavigateToCategory(OpportunityCategory.STREAMS) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Engineering,
                        title = if (isMarathi) "डिप्लोमा" else "Diploma",
                        badge = "३ वर्षे",
                        color = ForestGreen,
                        onClick = { onNavigateToCategory(OpportunityCategory.DIPLOMA) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Handyman,
                        title = if (isMarathi) "आय.टी.आय." else "ITI Trades",
                        badge = "थेट रोजगार",
                        color = SaffronOrange,
                        onClick = { onNavigateToCategory(OpportunityCategory.ITI) },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 3
                ) {
                    CategoryTile(
                        icon = Icons.Default.AccountBalance,
                        title = if (isMarathi) "शासकीय नोकऱ्या" else "Govt Jobs",
                        badge = "MPSC/SSC",
                        color = DeepNavy,
                        onClick = { onNavigateToCategory(OpportunityCategory.GOVT_JOB) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.BusinessCenter,
                        title = if (isMarathi) "खाजगी नोकऱ्या" else "Private Jobs",
                        badge = "IT / MIDC",
                        color = ForestGreen,
                        onClick = { onNavigateToCategory(OpportunityCategory.PVT_JOB) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Apartment,
                        title = if (isMarathi) "कॉलेज शोधक" else "Colleges",
                        badge = "शासकीय/खाजगी",
                        color = RoyalPurple,
                        onClick = { onNavigateToCategory(OpportunityCategory.COLLEGE) },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 3
                ) {
                    CategoryTile(
                        icon = Icons.Default.AssignmentTurnedIn,
                        title = if (isMarathi) "प्रवेश २०२६-२७" else "Admissions",
                        badge = "CAP फेऱ्या",
                        color = NavyBlue,
                        onClick = { onNavigateToCategory(OpportunityCategory.ADMISSION) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Savings,
                        title = if (isMarathi) "शिष्यवृत्ती" else "Scholarships",
                        badge = "MahaDBT",
                        color = SaffronOrange,
                        onClick = { onNavigateToCategory(OpportunityCategory.SCHOLARSHIP) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Security,
                        title = if (isMarathi) "संरक्षण दले" else "Defence",
                        badge = "NDA / सैन्य",
                        color = ForestGreen,
                        onClick = { onNavigateToCategory(OpportunityCategory.DEFENCE) },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 3
                ) {
                    CategoryTile(
                        icon = Icons.Default.EmojiEvents,
                        title = if (isMarathi) "स्पर्धा परीक्षा" else "Exams",
                        badge = "UPSC/CET",
                        color = DeepNavy,
                        onClick = { onNavigateToCategory(OpportunityCategory.COMPETITIVE_EXAM) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.Psychology,
                        title = if (isMarathi) "कौशल्य प्रशिक्षण" else "Training",
                        badge = "PMKVY/MSCIT",
                        color = RoyalPurple,
                        onClick = { onNavigateToCategory(OpportunityCategory.TRAINING) },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryTile(
                        icon = Icons.Default.TrendingUp,
                        title = if (isMarathi) "व्यवसाय / उद्योग" else "Business",
                        badge = "स्वयंरोजगार",
                        color = SaffronOrange,
                        onClick = { onNavigateToCategory(OpportunityCategory.BUSINESS) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Live Style "Latest Updates" Section
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isMarathi) "🔔 ताज्या घडामोडी व भरती अपडेट्स" else "🔔 Latest Opportunities & Recruitment",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                ScrollableTabRow(
                    selectedTabIndex = updateTabFilter,
                    edgePadding = 0.dp,
                    containerColor = Color.Transparent,
                    divider = {}
                ) {
                    updateTabs.forEachIndexed { index, tabName ->
                        Tab(
                            selected = updateTabFilter == index,
                            onClick = { updateTabFilter = index },
                            text = {
                                Text(
                                    text = tabName,
                                    fontSize = 12.sp,
                                    fontWeight = if (updateTabFilter == index) FontWeight.Bold else FontWeight.Normal,
                                    color = if (updateTabFilter == index) NavyBlue else Color.Gray
                                )
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // List of filtered live updates
        items(liveUpdates) { opportunity ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                OpportunityCard(
                    item = opportunity,
                    language = language,
                    onCardClick = { viewModel.selectOpportunity(opportunity) },
                    onBookmarkToggle = { viewModel.toggleBookmark(opportunity.id) }
                )
            }
        }
    }
}

@Composable
fun CategoryTile(
    icon: ImageVector,
    title: String,
    badge: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { onClick() }
            .testTag("category_tile_${title}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Text(
                text = badge,
                fontSize = 10.sp,
                color = color,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}
