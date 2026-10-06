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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.model.OpportunityCategory
import com.example.ui.components.OpportunityCard
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.NavyBlue
import com.example.ui.theme.SaffronOrange
import com.example.viewmodel.MainViewModel

@Composable
fun SearchScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val qualFilter by viewModel.qualificationFilter.collectAsState()
    val filteredItems by viewModel.filteredItems.collectAsState()

    val qualOptions = listOf(
        Pair("ALL", if (isMarathi) "सर्व पात्रता" else "All Qualifications"),
        Pair("10th", if (isMarathi) "१० वी (10th)" else "10th Pass"),
        Pair("12th", if (isMarathi) "१२ वी (12th)" else "12th Pass"),
        Pair("Diploma", if (isMarathi) "डिप्लोमा" else "Diploma"),
        Pair("ITI", if (isMarathi) "ITI" else "ITI Trades"),
        Pair("Degree", if (isMarathi) "पदवी (Degree)" else "Graduation")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp)
            .testTag("search_screen")
    ) {
        // Search Input Header
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.setSearchQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("search_screen_input"),
                placeholder = {
                    Text(
                        text = if (isMarathi)
                            "नोकरी, अभ्यासक्रम, कॉलेज, परीक्षा शोधा..."
                        else
                            "Search Job, Course, College, Exam, Admission...",
                        fontSize = 13.sp
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
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NavyBlue,
                    unfocusedBorderColor = Color(0xFFCBD5E1)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Qualification filter chips
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(qualOptions) { (key, label) ->
                    val isSelected = qualFilter == key
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSelected) NavyBlue else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { viewModel.setQualificationFilter(key) }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = label,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Category Filter Row
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    val isAll = selectedCategory == null
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isAll) SaffronOrange else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { viewModel.selectCategory(null) }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = if (isMarathi) "सर्व कॅटेगरीज" else "All Categories",
                            fontSize = 11.sp,
                            fontWeight = if (isAll) FontWeight.Bold else FontWeight.Medium,
                            color = if (isAll) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                items(OpportunityCategory.entries.toTypedArray()) { cat ->
                    val isSelected = selectedCategory == cat
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSelected) SaffronOrange else MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { viewModel.selectCategory(cat) }
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = if (isMarathi) cat.titleMr else cat.titleEn,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Count label
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${if (isMarathi) "एकूण निकाल:" else "Results found:"} ${filteredItems.size}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
                if (selectedCategory != null || qualFilter != "ALL" || searchQuery.isNotBlank()) {
                    Text(
                        text = if (isMarathi) "फिल्टर रीसेट करा" else "Reset Filters",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronOrange,
                        modifier = Modifier.clickable {
                            viewModel.selectCategory(null)
                            viewModel.setQualificationFilter("ALL")
                            viewModel.setSearchQuery("")
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Results List
        if (filteredItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(54.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = if (isMarathi) "कोणतेही निकाल आढळले नाहीत" else "No matching results found",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (isMarathi) "कृपया इतर शब्द किंवा फिल्टर वापरून शोधा" else "Try searching with different keywords or reset filters",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp, top = 6.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
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
}
