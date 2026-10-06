package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.ui.components.OpportunityCard
import com.example.ui.theme.NavyBlue
import com.example.viewmodel.MainViewModel

@Composable
fun SavedScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.language.collectAsState()
    val isMarathi = language == AppLanguage.MARATHI
    val bookmarkedItems by viewModel.bookmarkedItems.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 12.dp)
            .testTag("saved_screen")
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = if (isMarathi) "🔖 माझ्या सेव्ह केलेल्या संधी (Saved Opportunities)" else "🔖 My Saved Opportunities",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = NavyBlue
            )
            Text(
                text = "${if (isMarathi) "एकूण जतन केलेल्या:" else "Total Saved:"} ${bookmarkedItems.size}",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (bookmarkedItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.BookmarkBorder,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(54.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = if (isMarathi) "कोणतीही संधी सेव्ह केलेली नाही" else "No saved opportunities yet",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (isMarathi)
                            "कोणत्याही नोकरी किंवा कोर्सच्या कार्डवर 🔖 चिन्हावर क्लिक करून सेव्ह करा"
                        else
                            "Click the bookmark icon on any card to save it for later review",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 90.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(bookmarkedItems, key = { it.id }) { item ->
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
