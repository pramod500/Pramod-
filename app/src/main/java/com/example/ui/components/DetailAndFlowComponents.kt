package com.example.ui.components

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.model.AppLanguage
import com.example.model.OpportunityCategory
import com.example.model.OpportunityItem
import com.example.model.OpportunityStatus
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.LightAmberBg
import com.example.ui.theme.LightBlueBg
import com.example.ui.theme.LightGreenBg
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.RoyalPurple
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.SoftPurpleBg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpportunityDetailSheet(
    item: OpportunityItem,
    language: AppLanguage,
    onDismiss: () -> Unit,
    onBookmarkToggle: () -> Unit
) {
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val isMarathi = language == AppLanguage.MARATHI

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Header row with category and actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(NavyBlue.copy(alpha = 0.1f))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = item.subCategory,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyBlue
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    StatusBadgeView(status = item.status, isMarathi = isMarathi)
                    Spacer(modifier = Modifier.width(6.dp))
                    IconButton(onClick = onBookmarkToggle) {
                        Icon(
                            imageVector = if (item.isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (item.isBookmarked) SaffronOrange else Color.Gray
                        )
                    }
                    IconButton(onClick = { shareOpportunity(context, item, isMarathi) }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = if (isMarathi) item.titleMr else item.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 26.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Verified Badge
            if (item.isVerified) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(LightGreenBg)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Verified",
                        tint = ForestGreen,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isMarathi) "अधिकृत व पडताळणी केलेली माहिती (Verified Source)" else "Verified Government / Official Source",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ForestGreen
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Description
            Text(
                text = if (isMarathi) item.descriptionMr else item.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Key Info Cards Grid
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                InfoRow(
                    label = if (isMarathi) "शैक्षणिक पात्रता" else "Qualification",
                    value = if (isMarathi) item.qualificationMr else item.qualification
                )
                if (item.eligibility.isNotBlank() || item.eligibilityMr.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "सविस्तर निकष / वयोमर्यादा" else "Detailed Eligibility / Age",
                        value = if (isMarathi) item.eligibilityMr else item.eligibility
                    )
                }
                if (item.duration.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "कालावधी" else "Duration",
                        value = item.duration
                    )
                }
                if (item.vacancies.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "एकूण उपलब्ध जागा" else "Total Vacancies",
                        value = item.vacancies
                    )
                }
                if (item.fees.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "अंदाजे फी / वेतन" else "Approx Fees / Salary",
                        value = item.fees
                    )
                }
                if (item.lastDate.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "शेवटची तारीख (Last Date)" else "Last Date",
                        value = item.lastDate
                    )
                }
                if (item.location.isNotBlank()) {
                    InfoRow(
                        label = if (isMarathi) "स्थान / कार्यक्षेत्र" else "Location",
                        value = item.location
                    )
                }
            }

            // Exam pattern & syllabus
            if (item.examPattern.isNotBlank() || item.syllabus.isNotBlank()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (isMarathi) "परीक्षेचे स्वरूप व अभ्यासक्रम (Exam Pattern & Syllabus)" else "Exam Pattern & Syllabus",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (item.examPattern.isNotBlank()) {
                    Text(
                        text = "📝 ${item.examPattern}",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                }
                if (item.syllabus.isNotBlank()) {
                    Text(
                        text = "📚 ${item.syllabus}",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Top colleges
            if (item.topColleges.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (isMarathi) "प्रमुख महाविद्यालये / संस्था (Top Colleges / Institutes)" else "Top Colleges / Institutes",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )
                Spacer(modifier = Modifier.height(6.dp))
                item.topColleges.forEach { college ->
                    Row(
                        modifier = Modifier.padding(vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "🏫", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = college,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Career paths
            if (item.careerPaths.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (isMarathi) "भविष्यातील करिअर व नोकरीच्या संधी (Career Pathways)" else "Future Career Pathways",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = ForestGreen
                )
                Spacer(modifier = Modifier.height(6.dp))
                item.careerPaths.forEach { path ->
                    Row(
                        modifier = Modifier.padding(vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = ForestGreen,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = path,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            OfficialNoticeDisclaimer(isMarathi = isMarathi)

            Spacer(modifier = Modifier.height(20.dp))

            // Action button
            if (item.officialUrl.isNotBlank()) {
                Button(
                    onClick = { openWebUrl(context, item.officialUrl) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("modal_apply_button"),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
                ) {
                    Text(
                        text = if (isMarathi) "अधिकृत वेबसाइटवर जा व अर्ज करा" else "Open Official Portal & Apply",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.OpenInNew,
                        contentDescription = "External link",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(0.6f)
        )
    }
}

/**
 * Interactive Visual Career Flowchart reproducing the uploaded poster's exact architecture.
 */
@Composable
fun VisualCareerFlowchart(
    isMarathi: Boolean,
    onNodeClick: (OpportunityCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = if (isMarathi) {
        listOf("१. ११वी - १२वी", "२. डिप्लोमा (पॉलिटेक्निक)", "३. आय.टी.आय. (ITI)", "४. करिअर ध्येय")
    } else {
        listOf("1. 11th - 12th", "2. Diploma", "3. ITI Trades", "4. Career Goals")
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("career_flowchart_card"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Master Header Flow Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(DeepNavy)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = if (isMarathi) "🎓 १० वी नंतर करिअर दिशादर्शक (Master Career Flow)" else "🎓 Career Roadmap After 10th Standard",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (isMarathi) "१० वी पास → ११वी-१२वी / डिप्लोमा / ITI → पदवी/कौशल्य → नोकरी/व्यवसाय" else "10th Pass → Junior College / Diploma / ITI → Degree / Skills → Jobs / Business",
                        color = Color(0xFFBBDEFB),
                        fontSize = 11.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 10th SSC Node
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(LightBlueBg)
                    .border(1.dp, NavyBlue.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isMarathi) "🎯 १० वी उत्तीर्ण (SSC Board Pass)" else "🎯 10th Standard Pass (SSC)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = NavyBlue
                )
            }

            // Downward arrow
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDownward,
                    contentDescription = null,
                    tint = SaffronOrange,
                    modifier = Modifier.size(20.dp)
                )
            }

            // 3 Major Branch Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FlowBranchCard(
                    title = if (isMarathi) "११वी - १२वी" else "11th - 12th",
                    subtitle = if (isMarathi) "कला / वाणिज्य\nविज्ञान / कृषी" else "Arts / Comm\nScience / Agri",
                    color = NavyBlue,
                    bgColor = LightBlueBg,
                    isSelected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    modifier = Modifier.weight(1f)
                )

                FlowBranchCard(
                    title = if (isMarathi) "डिप्लोमा" else "Diploma",
                    subtitle = if (isMarathi) "पॉलिटेक्निक\n(३ वर्षे)" else "Polytechnic\n(3 Years)",
                    color = ForestGreen,
                    bgColor = LightGreenBg,
                    isSelected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    modifier = Modifier.weight(1f)
                )

                FlowBranchCard(
                    title = if (isMarathi) "आय.टी.आय." else "ITI Trades",
                    subtitle = if (isMarathi) "कौशल्य ट्रेड\n(१ ते २ वर्षे)" else "Craft Trades\n(1-2 Years)",
                    color = SaffronOrange,
                    bgColor = LightAmberBg,
                    isSelected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Dynamic Stream Details inside selected branch
            when (selectedTab) {
                0 -> {
                    // Junior College streams
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        StreamRow(
                            stream = if (isMarathi) "कला (Arts)" else "Arts Stream",
                            path = "B.A. → M.A.",
                            career = if (isMarathi) "MPSC / UPSC, स्पर्धा परीक्षा, विधी (Law), पत्रकारिता, शिक्षक" else "UPSC/MPSC, Law (LLB), Teaching, Journalism",
                            onClick = { onNodeClick(OpportunityCategory.STREAMS) }
                        )
                        StreamRow(
                            stream = if (isMarathi) "वाणिज्य (Commerce)" else "Commerce Stream",
                            path = "B.Com → M.Com",
                            career = if (isMarathi) "बँकिंग, CA / CS, कर सल्लागार, फायनान्स, कॉर्पोरेट" else "Banking, CA/CS, Tax Consultant, Finance",
                            onClick = { onNodeClick(OpportunityCategory.STREAMS) }
                        )
                        StreamRow(
                            stream = if (isMarathi) "विज्ञान (Science)" else "Science Stream",
                            path = "B.Sc. → M.Sc. / B.Tech / MBBS",
                            career = if (isMarathi) "इंजिनिअरिंग, डॉक्टर, फार्मसी, संशोधन, संरक्षण, IT" else "Engineering, Medical, Pharmacy, Research, Defence",
                            onClick = { onNodeClick(OpportunityCategory.STREAMS) }
                        )
                        StreamRow(
                            stream = if (isMarathi) "कृषी (Agriculture)" else "Agriculture Stream",
                            path = "B.Sc. (Agri) → M.Sc. (Agri)",
                            career = if (isMarathi) "कृषी अधिकारी, मृद शास्त्रज्ञ, बियाणे/खत उद्योग, ऍग्री बिझनेस" else "Agri Officer, Soil Scientist, Agri-Business",
                            onClick = { onNodeClick(OpportunityCategory.DEGREE) }
                        )
                    }
                }
                1 -> {
                    // Diploma details
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(LightGreenBg)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = if (isMarathi) "⚙️ ३ वर्षे तंत्रशिक्षण पदविका (Polytechnic)" else "⚙️ 3-Year Polytechnic Engineering",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = ForestGreen
                        )
                        Text(
                            text = if (isMarathi)
                                "• शाखा: कॉम्प्युटर, मेकॅनिकल, सिव्हिल, इलेक्ट्रॉनिक्स, इलेक्ट्रिकल\n• पदवीनंतर संधी: थेट २ऱ्या वर्ष बी.ई./बी.टेक. मध्ये प्रवेश (Direct 2nd Year B.Tech)\n• नोकऱ्या: कनिष्ठ अभियंता (Junior Engineer), सुपरवायझर, रेल्वे/महावितरण"
                            else
                                "• Branches: Computer, Mechanical, Civil, Electrical, Electronics\n• Further: Direct Lateral Entry to 2nd-Year B.E. / B.Tech\n• Jobs: Junior Engineer, PWD/WRD, Railway, MSEDCL",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 18.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
                2 -> {
                    // ITI details
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(LightAmberBg)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = if (isMarathi) "🛠 औद्योगिक प्रशिक्षण संस्था (ITI Crafts)" else "🛠 ITI Industrial Trade Courses",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronOrange
                        )
                        Text(
                            text = if (isMarathi)
                                "• प्रमुख ट्रेड्स: इलेक्ट्रिशियन, फिटर, वेल्डर, डिझेल मेकॅनिक, वायरमन\n• प्रत्यक्ष अनुभव: राष्ट्रीय शिकाऊ उमेदवारी (Apprenticeship with Stipend)\n• नोकऱ्या: भारतीय रेल्वे टेक्निशियन, ऑर्डनन्स फॅक्टरी, महावितरण, स्वतःचा व्यवसाय"
                            else
                                "• Top Trades: Electrician, Fitter, Welder, Diesel Mechanic, Wireman\n• Experience: National Apprenticeship with monthly stipend\n• Jobs: Railway Technician, MSEDCL, Ordnance Factory, Self Employment",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 18.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Career Endpoints Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF1F5F9))
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CareerPill("🏛️ शासकीय नोकऱ्या", "Govt Jobs", isMarathi)
                    CareerPill("🏢 खाजगी कंपन्या", "Private Jobs", isMarathi)
                    CareerPill("🚀 स्वतःचा व्यवसाय", "Business", isMarathi)
                }
            }
        }
    }
}

@Composable
fun FlowBranchCard(
    title: String,
    subtitle: String,
    color: Color,
    bgColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) color else bgColor)
            .clickable { onClick() }
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 10.dp, horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else color
            )
            Text(
                text = subtitle,
                fontSize = 10.sp,
                color = if (isSelected) Color.White.copy(alpha = 0.9f) else Color.DarkGray,
                lineHeight = 13.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
fun StreamRow(
    stream: String,
    path: String,
    career: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFF8FAFC))
            .clickable { onClick() }
            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(6.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stream,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = NavyBlue
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "($path)",
                    fontSize = 11.sp,
                    color = SaffronOrange,
                    fontWeight = FontWeight.Medium
                )
            }
            Text(
                text = career,
                fontSize = 11.sp,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = NavyBlue,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun CareerPill(titleMr: String, titleEn: String, isMarathi: Boolean) {
    Text(
        text = if (isMarathi) titleMr else titleEn,
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        color = DeepNavy
    )
}

/**
 * Admin Panel Add Opportunity Dialog
 */
@Composable
fun AdminAddOpportunityDialog(
    isMarathi: Boolean,
    onDismiss: () -> Unit,
    onSave: (
        title: String,
        titleMr: String,
        category: OpportunityCategory,
        subCategory: String,
        description: String,
        descriptionMr: String,
        qualification: String,
        qualificationMr: String,
        eligibility: String,
        eligibilityMr: String,
        duration: String,
        ageLimit: String,
        vacancies: String,
        lastDate: String,
        location: String,
        officialUrl: String,
        status: OpportunityStatus
    ) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var titleMr by remember { mutableStateOf("") }
    var subCategory by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var qualification by remember { mutableStateOf("") }
    var vacancies by remember { mutableStateOf("") }
    var lastDate by remember { mutableStateOf("") }
    var officialUrl by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(OpportunityCategory.GOVT_JOB) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isMarathi) "नवीन संधी जोडा (Admin)" else "Add Opportunity (Admin)",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = DeepNavy
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title (English)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = titleMr,
                    onValueChange = { titleMr = it },
                    label = { Text("शीर्षक (मराठीत)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = subCategory,
                    onValueChange = { subCategory = it },
                    label = { Text("Sub-Category (उदा. MPSC / Banking / IT)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = qualification,
                    onValueChange = { qualification = it },
                    label = { Text("पात्रता (उदा. 10th / 12th / Degree)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = vacancies,
                    onValueChange = { vacancies = it },
                    label = { Text("जागा संख्या / Vacancies (उदा. 250 पदे)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = lastDate,
                    onValueChange = { lastDate = it },
                    label = { Text("शेवटची तारीख (उदा. 30 नोव्हेंबर 2026)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = officialUrl,
                    onValueChange = { officialUrl = it },
                    label = { Text("अधिकृत लिंक / Official URL") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("माहिती / Description") },
                    minLines = 3,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(if (isMarathi) "रद्द करा" else "Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (title.isNotBlank() || titleMr.isNotBlank()) {
                                onSave(
                                    title.ifBlank { titleMr },
                                    titleMr.ifBlank { title },
                                    selectedCategory,
                                    subCategory.ifBlank { "General" },
                                    description,
                                    description,
                                    qualification,
                                    qualification,
                                    "",
                                    "",
                                    "",
                                    "",
                                    vacancies,
                                    lastDate,
                                    "महाराष्ट्र",
                                    officialUrl,
                                    OpportunityStatus.NEW
                                )
                                onDismiss()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
                    ) {
                        Text(if (isMarathi) "जतन करा" else "Save Opportunity")
                    }
                }
            }
        }
    }
}
