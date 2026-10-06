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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.ui.components.OfficialNoticeDisclaimer
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.LightAmberBg
import com.example.ui.theme.LightBlueBg
import com.example.ui.theme.LightGreenBg
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CareerFinderScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val quiz by viewModel.careerQuiz.collectAsState()
    val roadmap by viewModel.careerRoadmap.collectAsState()

    val educationOptions = listOf(
        Pair("10th", if (isMarathi) "१० वी (SSC)" else "10th Standard"),
        Pair("12th Science", if (isMarathi) "१२ वी सायन्स" else "12th Science"),
        Pair("12th Commerce", if (isMarathi) "१२ वी कॉमर्स" else "12th Commerce"),
        Pair("12th Arts", if (isMarathi) "१२ वी आर्ट्स" else "12th Arts"),
        Pair("12th Agri", if (isMarathi) "१२ वी कृषी" else "12th Agriculture"),
        Pair("Diploma", if (isMarathi) "डिप्लोमा (Polytechnic)" else "Diploma"),
        Pair("ITI", if (isMarathi) "आय.टी.आय. (ITI)" else "ITI"),
        Pair("Graduate", if (isMarathi) "पदवीधर (Graduate)" else "Graduate")
    )

    val interestOptions = listOf(
        Pair("Tech", if (isMarathi) "इंजिनिअरिंग / IT / सॉफ्टवेअर" else "Engineering & IT"),
        Pair("Medical", if (isMarathi) "वैद्यकीय / नर्सिंग / फार्मसी" else "Medical & Healthcare"),
        Pair("Agriculture", if (isMarathi) "कृषी / शेती व्यवसाय" else "Agriculture & Allied"),
        Pair("Commerce", if (isMarathi) "बँकिंग / CA / फायनान्स" else "Banking, CA & Finance"),
        Pair("Govt", if (isMarathi) "MPSC / UPSC नागरी सेवा" else "UPSC & MPSC Services"),
        Pair("Defence", if (isMarathi) "पोलीस / सैन्य / NDA" else "Police, Army & NDA"),
        Pair("Trade", if (isMarathi) "तांत्रिक ट्रेड / फिटर / वायरमन" else "Technical Trade Skills")
    )

    val preferenceOptions = listOf(
        Pair("Government Job", if (isMarathi) "शासकीय नोकरी" else "Government Job"),
        Pair("Private Job", if (isMarathi) "खाजगी कंपनी नोकरी" else "Private Company"),
        Pair("Business", if (isMarathi) "स्वतःचा व्यवसाय" else "Self Employment"),
        Pair("Higher Study", if (isMarathi) "उच्च शिक्षण / संशोधन" else "Higher Studies")
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("career_finder_screen"),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 90.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Header
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = DeepNavy),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(SaffronOrange),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (isMarathi) "स्मार्ट करिअर मार्गदर्शक (Career Finder)" else "Smart Career Finder & Advisor",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = if (isMarathi) "तुमच्या आवडीनुसार वैयक्तिक करिअर रोडमॅप तयार करा" else "Generate personalized roadmap based on your choices",
                                fontSize = 11.sp,
                                color = Color(0xFFE2E8F0)
                            )
                        }
                    }
                }
            }
        }

        // Question 1: Current Education
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (isMarathi) "१. तुमचे सध्याचे शिक्षण काय आहे?" else "1. What is your current education?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyBlue
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        educationOptions.forEach { (key, label) ->
                            val isSelected = quiz.currentEducation == key
                            QuizChip(
                                label = label,
                                isSelected = isSelected,
                                onClick = { viewModel.updateQuiz { copy(currentEducation = key) } }
                            )
                        }
                    }
                }
            }
        }

        // Question 2: Interest / Stream
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (isMarathi) "२. तुमचा मुख्य कल / आवड कोणत्या क्षेत्रात आहे?" else "2. What is your primary field of interest?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = ForestGreen
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        interestOptions.forEach { (key, label) ->
                            val isSelected = quiz.streamInterest == key
                            QuizChip(
                                label = label,
                                isSelected = isSelected,
                                onClick = { viewModel.updateQuiz { copy(streamInterest = key) } }
                            )
                        }
                    }
                }
            }
        }

        // Question 3: Goal preference
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (isMarathi) "३. तुमचे अंतिम ध्येय काय आहे?" else "3. What is your career preference?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronOrange
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        preferenceOptions.forEach { (key, label) ->
                            val isSelected = quiz.jobPreference == key
                            QuizChip(
                                label = label,
                                isSelected = isSelected,
                                onClick = { viewModel.updateQuiz { copy(jobPreference = key) } }
                            )
                        }
                    }
                }
            }
        }

        // Generated Personalized Roadmap Result Card
        roadmap?.let { res ->
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = ForestGreen,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isMarathi) res.primaryHeadingMr else res.primaryHeadingEn,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = DeepNavy
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Step by step pathway nodes
                        Text(
                            text = if (isMarathi) "🗺️ शिफारस केलेला टप्पा-निहाय मार्ग (Recommended Path):" else "🗺️ Step-by-Step Recommended Path:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        res.recommendedPath.forEachIndexed { idx, step ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(26.dp)
                                        .clip(CircleShape)
                                        .background(NavyBlue),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = step,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Recommended Courses & Exams
                        RoadmapDetailSection(
                            heading = if (isMarathi) "📚 योग्य अभ्यासक्रम (Recommended Courses):" else "📚 Recommended Courses:",
                            items = res.recommendedCourses,
                            color = NavyBlue
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        RoadmapDetailSection(
                            heading = if (isMarathi) "🏆 लक्ष्य स्पर्धा परीक्षा (Target Exams):" else "🏆 Target Competitive Exams:",
                            items = res.targetExams,
                            color = SaffronOrange
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        RoadmapDetailSection(
                            heading = if (isMarathi) "💼 संभाव्य नोकरी पदे (Target Careers / Jobs):" else "💼 Eligible Job Opportunities:",
                            items = res.targetJobs,
                            color = ForestGreen
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Expert Advice Card
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(LightGreenBg)
                                .padding(12.dp)
                        ) {
                            Column {
                                Text(
                                    text = if (isMarathi) "💡 तज्ज्ञ करिअर सल्ला (Expert Advice):" else "💡 Expert Career Guidance:",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = ForestGreen
                                )
                                Text(
                                    text = res.adviceMr,
                                    fontSize = 12.sp,
                                    color = Color(0xFF065F46),
                                    lineHeight = 17.sp,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            OfficialNoticeDisclaimer(isMarathi = isMarathi)
        }
    }
}

@Composable
fun QuizChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) NavyBlue else MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) NavyBlue else Color(0xFFCBD5E1),
                RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun RoadmapDetailSection(heading: String, items: List<String>, color: Color) {
    Column {
        Text(
            text = heading,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Spacer(modifier = Modifier.height(4.dp))
        items.forEach { itm ->
            Text(
                text = "• $itm",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = 6.dp, top = 2.dp)
            )
        }
    }
}
