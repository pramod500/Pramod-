package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AltRoute
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.AppLanguage
import com.example.model.OpportunityCategory
import com.example.ui.components.AdminAddOpportunityDialog
import com.example.ui.components.OpportunityDetailSheet
import com.example.ui.screens.CareerFinderScreen
import com.example.ui.screens.CategorySectionScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.OfficialLinksScreen
import com.example.ui.screens.SavedScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

enum class NavigationTab {
    HOME,
    FLOW,
    SEARCH,
    JOBS,
    UPDATES,
    OFFICIAL_LINKS,
    SAVED,
    CAREER_QUIZ,
    CATEGORY_SECTION
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppContainer()
            }
        }
    }
}

@Composable
fun MainAppContainer(viewModel: MainViewModel = viewModel()) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val bookmarkedItems by viewModel.bookmarkedItems.collectAsState()
    val selectedOpportunity by viewModel.selectedOpportunity.collectAsState()

    var currentTab by remember { mutableStateOf(NavigationTab.HOME) }
    var currentCategory by remember { mutableStateOf(OpportunityCategory.STREAMS) }
    var showAdminDialog by remember { mutableStateOf(false) }

    // Back handling to return to home if on a sub-screen
    if (currentTab != NavigationTab.HOME) {
        BackHandler {
            currentTab = NavigationTab.HOME
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppHeaderBar(
                isMarathi = isMarathi,
                bookmarkedCount = bookmarkedItems.size,
                onToggleLanguage = { viewModel.toggleLanguage() },
                onOpenSaved = { currentTab = NavigationTab.SAVED },
                onOpenOfficialPortals = { currentTab = NavigationTab.OFFICIAL_LINKS },
                onOpenAdmin = { showAdminDialog = true }
            )
        },
        bottomBar = {
            AppBottomNavigationBar(
                currentTab = currentTab,
                isMarathi = isMarathi,
                onTabSelect = { tab ->
                    currentTab = tab
                }
            )
        },
        floatingActionButton = {
            if (currentTab == NavigationTab.HOME || currentTab == NavigationTab.FLOW) {
                ExtendedFloatingActionButton(
                    onClick = { currentTab = NavigationTab.CAREER_QUIZ },
                    containerColor = SaffronOrange,
                    contentColor = Color.White,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Career Quiz",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    text = {
                        Text(
                            text = if (isMarathi) "माझे करिअर शोधा" else "Career Advisor",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .testTag("floating_career_advisor")
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentTab) {
                NavigationTab.HOME -> {
                    HomeScreen(
                        viewModel = viewModel,
                        onNavigateToCategory = { cat ->
                            currentCategory = cat
                            currentTab = NavigationTab.CATEGORY_SECTION
                        },
                        onNavigateToQuiz = { currentTab = NavigationTab.CAREER_QUIZ },
                        onNavigateToOfficialLinks = { currentTab = NavigationTab.OFFICIAL_LINKS }
                    )
                }
                NavigationTab.FLOW -> {
                    CategorySectionScreen(
                        category = OpportunityCategory.STREAMS,
                        viewModel = viewModel,
                        onNavigateBack = { currentTab = NavigationTab.HOME }
                    )
                }
                NavigationTab.SEARCH -> {
                    SearchScreen(viewModel = viewModel)
                }
                NavigationTab.JOBS -> {
                    CategorySectionScreen(
                        category = OpportunityCategory.GOVT_JOB,
                        viewModel = viewModel,
                        onNavigateBack = { currentTab = NavigationTab.HOME }
                    )
                }
                NavigationTab.UPDATES -> {
                    CategorySectionScreen(
                        category = OpportunityCategory.ADMISSION,
                        viewModel = viewModel,
                        onNavigateBack = { currentTab = NavigationTab.HOME }
                    )
                }
                NavigationTab.CATEGORY_SECTION -> {
                    CategorySectionScreen(
                        category = currentCategory,
                        viewModel = viewModel,
                        onNavigateBack = { currentTab = NavigationTab.HOME }
                    )
                }
                NavigationTab.CAREER_QUIZ -> {
                    CareerFinderScreen(viewModel = viewModel)
                }
                NavigationTab.OFFICIAL_LINKS -> {
                    OfficialLinksScreen(viewModel = viewModel)
                }
                NavigationTab.SAVED -> {
                    SavedScreen(viewModel = viewModel)
                }
            }
        }
    }

    // Detail Bottom Sheet
    selectedOpportunity?.let { opp ->
        OpportunityDetailSheet(
            item = opp,
            language = language,
            onDismiss = { viewModel.selectOpportunity(null) },
            onBookmarkToggle = { viewModel.toggleBookmark(opp.id) }
        )
    }

    // Admin Add Dialog
    if (showAdminDialog) {
        AdminAddOpportunityDialog(
            isMarathi = isMarathi,
            onDismiss = { showAdminDialog = false },
            onSave = { title, titleMr, cat, subCat, desc, descMr, qual, qualMr, elig, eligMr, dur, age, vac, last, loc, url, st ->
                viewModel.addOpportunity(
                    title = title,
                    titleMr = titleMr,
                    category = cat,
                    subCategory = subCat,
                    description = desc,
                    descriptionMr = descMr,
                    qualification = qual,
                    qualificationMr = qualMr,
                    eligibility = elig,
                    eligibilityMr = eligMr,
                    duration = dur,
                    ageLimit = age,
                    vacancies = vac,
                    lastDate = last,
                    location = loc,
                    officialUrl = url,
                    status = st
                )
            }
        )
    }
}

@Composable
fun AppHeaderBar(
    isMarathi: Boolean,
    bookmarkedCount: Int,
    onToggleLanguage: () -> Unit,
    onOpenSaved: () -> Unit,
    onOpenOfficialPortals: () -> Unit,
    onOpenAdmin: () -> Unit
) {
    Surface(
        color = DeepNavy,
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // App Branding & Title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(SaffronOrange),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = if (isMarathi) "शिक्षण • करिअर" else "Education • Career",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (isMarathi) "नोकरी • प्रवेश • संधी" else "Jobs • Admissions • Opportunities",
                        color = Color(0xFFCBD5E1),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Action buttons
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Language Switcher Badge Button
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.15f))
                        .clickable { onToggleLanguage() }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .testTag("language_switch_button"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isMarathi) "मराठी | EN" else "EN | मराठी",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))

                // Portals directory shortcut
                IconButton(
                    onClick = onOpenOfficialPortals,
                    modifier = Modifier.size(36.dp).testTag("official_portals_shortcut")
                ) {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = "Official Portals",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Saved Opportunities Icon with Badge
                IconButton(
                    onClick = onOpenSaved,
                    modifier = Modifier.size(36.dp).testTag("saved_items_shortcut")
                ) {
                    BadgedBox(
                        badge = {
                            if (bookmarkedCount > 0) {
                                Badge(
                                    containerColor = SaffronOrange,
                                    contentColor = Color.White
                                ) {
                                    Text(text = bookmarkedCount.toString())
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Saved",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // Admin Add Opportunity
                IconButton(
                    onClick = onOpenAdmin,
                    modifier = Modifier.size(36.dp).testTag("admin_add_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Opportunity",
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AppBottomNavigationBar(
    currentTab: NavigationTab,
    isMarathi: Boolean,
    onTabSelect: (NavigationTab) -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .testTag("app_bottom_nav"),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        NavigationBarItem(
            selected = currentTab == NavigationTab.HOME,
            onClick = { onTabSelect(NavigationTab.HOME) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = {
                Text(
                    text = if (isMarathi) "मुखपृष्ठ" else "Home",
                    fontSize = 10.sp,
                    fontWeight = if (currentTab == NavigationTab.HOME) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavyBlue,
                selectedTextColor = NavyBlue,
                indicatorColor = Color(0xFFDBEAFE)
            )
        )

        NavigationBarItem(
            selected = currentTab == NavigationTab.FLOW,
            onClick = { onTabSelect(NavigationTab.FLOW) },
            icon = { Icon(Icons.Default.AltRoute, contentDescription = "Flow") },
            label = {
                Text(
                    text = if (isMarathi) "करिअर मार्ग" else "Flow",
                    fontSize = 10.sp,
                    fontWeight = if (currentTab == NavigationTab.FLOW) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavyBlue,
                selectedTextColor = NavyBlue,
                indicatorColor = Color(0xFFDBEAFE)
            )
        )

        NavigationBarItem(
            selected = currentTab == NavigationTab.SEARCH,
            onClick = { onTabSelect(NavigationTab.SEARCH) },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = {
                Text(
                    text = if (isMarathi) "सर्च" else "Search",
                    fontSize = 10.sp,
                    fontWeight = if (currentTab == NavigationTab.SEARCH) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavyBlue,
                selectedTextColor = NavyBlue,
                indicatorColor = Color(0xFFDBEAFE)
            )
        )

        NavigationBarItem(
            selected = currentTab == NavigationTab.JOBS,
            onClick = { onTabSelect(NavigationTab.JOBS) },
            icon = { Icon(Icons.Default.Work, contentDescription = "Jobs") },
            label = {
                Text(
                    text = if (isMarathi) "नोकऱ्या" else "Jobs",
                    fontSize = 10.sp,
                    fontWeight = if (currentTab == NavigationTab.JOBS) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavyBlue,
                selectedTextColor = NavyBlue,
                indicatorColor = Color(0xFFDBEAFE)
            )
        )

        NavigationBarItem(
            selected = currentTab == NavigationTab.UPDATES,
            onClick = { onTabSelect(NavigationTab.UPDATES) },
            icon = { Icon(Icons.Default.Notifications, contentDescription = "Updates") },
            label = {
                Text(
                    text = if (isMarathi) "अपडेट्स" else "Updates",
                    fontSize = 10.sp,
                    fontWeight = if (currentTab == NavigationTab.UPDATES) FontWeight.Bold else FontWeight.Normal
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavyBlue,
                selectedTextColor = NavyBlue,
                indicatorColor = Color(0xFFDBEAFE)
            )
        )
    }
}
