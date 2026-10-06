package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.OpportunityCategory
import com.example.ui.components.OfficialNoticeDisclaimer
import com.example.ui.components.OpportunityCard
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

@Composable
fun CategorySectionScreen(
    category: OpportunityCategory,
    viewModel: MainViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val allItems by viewModel.items.collectAsState()

    val categoryItems = allItems.filter { it.category == category }
    val subCategories = listOf(if (isMarathi) "सर्व" else "All") + categoryItems.map { it.subCategory }.distinct()

    var selectedSubCatIndex by remember { mutableIntStateOf(0) }

    val filteredItems = if (selectedSubCatIndex == 0) {
        categoryItems
    } else {
        val selectedSubCat = subCategories[selectedSubCatIndex]
        categoryItems.filter { it.subCategory == selectedSubCat }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("category_section_screen")
    ) {
        // Category Header Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(DeepNavy)
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Column {
                Text(
                    text = if (isMarathi) category.titleMr else category.titleEn,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "${if (isMarathi) "एकूण उपलब्ध पर्याय:" else "Available options:"} ${categoryItems.size}",
                    fontSize = 12.sp,
                    color = Color(0xFFCBD5E1),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }

        // Subcategory tabs if more than 1
        if (subCategories.size > 2) {
            ScrollableTabRow(
                selectedTabIndex = selectedSubCatIndex,
                edgePadding = 16.dp,
                containerColor = MaterialTheme.colorScheme.surface,
                divider = {}
            ) {
                subCategories.forEachIndexed { index, subCat ->
                    Tab(
                        selected = selectedSubCatIndex == index,
                        onClick = { selectedSubCatIndex = index },
                        text = {
                            Text(
                                text = subCat,
                                fontSize = 12.sp,
                                fontWeight = if (selectedSubCatIndex == index) FontWeight.Bold else FontWeight.Medium,
                                color = if (selectedSubCatIndex == index) NavyBlue else Color.Gray
                            )
                        }
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 90.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                OfficialNoticeDisclaimer(isMarathi = isMarathi)
            }

            items(filteredItems, key = { it.id }) { item ->
                OpportunityCard(
                    item = item,
                    language = language,
                    onCardClick = { viewModel.selectOpportunity(item) },
                    onBookmarkToggle = { viewModel.toggleBookmark(item.id) }
                )
            }
        }
    }
}
