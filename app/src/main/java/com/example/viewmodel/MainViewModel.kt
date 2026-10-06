package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CareerDataProvider
import com.example.model.AppLanguage
import com.example.model.CareerQuizState
import com.example.model.CareerRoadmapResult
import com.example.model.OfficialPortal
import com.example.model.OpportunityCategory
import com.example.model.OpportunityItem
import com.example.model.OpportunityStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel : ViewModel() {

    private val _language = MutableStateFlow(AppLanguage.MARATHI)
    val language: StateFlow<AppLanguage> = _language.asStateFlow()

    private val _items = MutableStateFlow<List<OpportunityItem>>(CareerDataProvider.getInitialOpportunities())
    val items: StateFlow<List<OpportunityItem>> = _items.asStateFlow()

    private val _officialPortals = MutableStateFlow<List<OfficialPortal>>(CareerDataProvider.officialPortals)
    val officialPortals: StateFlow<List<OfficialPortal>> = _officialPortals.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<OpportunityCategory?>(null)
    val selectedCategory: StateFlow<OpportunityCategory?> = _selectedCategory.asStateFlow()

    private val _qualificationFilter = MutableStateFlow("ALL")
    val qualificationFilter: StateFlow<String> = _qualificationFilter.asStateFlow()

    private val _selectedOpportunity = MutableStateFlow<OpportunityItem?>(null)
    val selectedOpportunity: StateFlow<OpportunityItem?> = _selectedOpportunity.asStateFlow()

    // Career Quiz & Roadmap
    private val _careerQuiz = MutableStateFlow(CareerQuizState(currentEducation = "10th", streamInterest = "Science", age = "16", jobPreference = "Government Job"))
    val careerQuiz: StateFlow<CareerQuizState> = _careerQuiz.asStateFlow()

    private val _careerRoadmap = MutableStateFlow<CareerRoadmapResult?>(
        CareerDataProvider.getCareerRoadmap(CareerQuizState(currentEducation = "10th", streamInterest = "Science", age = "16", jobPreference = "Government Job"))
    )
    val careerRoadmap: StateFlow<CareerRoadmapResult?> = _careerRoadmap.asStateFlow()

    // Filtered items based on query and filters
    val filteredItems: StateFlow<List<OpportunityItem>> = combine(
        _items,
        _searchQuery,
        _selectedCategory,
        _qualificationFilter
    ) { allItems, query, category, qualFilter ->
        allItems.filter { item ->
            val matchesCategory = category == null || item.category == category
            val matchesQual = when (qualFilter) {
                "10th" -> item.qualification.contains("10", ignoreCase = true) || item.qualificationMr.contains("१०")
                "12th" -> item.qualification.contains("12", ignoreCase = true) || item.qualificationMr.contains("१२")
                "Degree" -> item.qualification.contains("Graduat", ignoreCase = true) || item.qualification.contains("Degree", ignoreCase = true) || item.qualificationMr.contains("पदवी")
                "Diploma" -> item.qualification.contains("Diploma", ignoreCase = true) || item.qualificationMr.contains("डिप्लोमा")
                "ITI" -> item.qualification.contains("ITI", ignoreCase = true) || item.qualificationMr.contains("आय.टी.आय")
                else -> true
            }
            val matchesQuery = if (query.isBlank()) {
                true
            } else {
                val q = query.trim().lowercase()
                item.title.lowercase().contains(q) ||
                        item.titleMr.contains(q) ||
                        item.description.lowercase().contains(q) ||
                        item.descriptionMr.contains(q) ||
                        item.subCategory.lowercase().contains(q) ||
                        item.location.lowercase().contains(q) ||
                        item.tags.any { it.lowercase().contains(q) } ||
                        item.qualification.lowercase().contains(q)
            }
            matchesCategory && matchesQual && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, _items.value)

    // Bookmarked items
    val bookmarkedItems: StateFlow<List<OpportunityItem>> = combine(_items) { array ->
        array.first().filter { it.isBookmarked }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleLanguage() {
        _language.value = if (_language.value == AppLanguage.MARATHI) AppLanguage.ENGLISH else AppLanguage.MARATHI
    }

    fun setLanguage(lang: AppLanguage) {
        _language.value = lang
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: OpportunityCategory?) {
        _selectedCategory.value = category
    }

    fun setQualificationFilter(filter: String) {
        _qualificationFilter.value = filter
    }

    fun selectOpportunity(item: OpportunityItem?) {
        _selectedOpportunity.value = item
    }

    fun toggleBookmark(itemId: String) {
        _items.value = _items.value.map { item ->
            if (item.id == itemId) {
                item.copy(isBookmarked = !item.isBookmarked)
            } else {
                item
            }
        }
        // Update selected if needed
        if (_selectedOpportunity.value?.id == itemId) {
            _selectedOpportunity.value = _items.value.firstOrNull { it.id == itemId }
        }
    }

    fun updateQuiz(update: CareerQuizState.() -> CareerQuizState) {
        val newState = _careerQuiz.value.update()
        _careerQuiz.value = newState
        _careerRoadmap.value = CareerDataProvider.getCareerRoadmap(newState)
    }

    fun addOpportunity(
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
    ) {
        val newItem = OpportunityItem(
            id = "custom_" + UUID.randomUUID().toString().take(8),
            title = title,
            titleMr = titleMr.ifBlank { title },
            category = category,
            subCategory = subCategory,
            description = description,
            descriptionMr = descriptionMr.ifBlank { description },
            qualification = qualification,
            qualificationMr = qualificationMr.ifBlank { qualification },
            eligibility = eligibility,
            eligibilityMr = eligibilityMr.ifBlank { eligibility },
            duration = duration,
            ageLimit = ageLimit,
            vacancies = vacancies,
            lastDate = lastDate,
            location = location.ifBlank { "महाराष्ट्र" },
            officialUrl = officialUrl,
            status = status,
            isVerified = true,
            isUserAdded = true,
            tags = listOf(category.name, subCategory, qualification)
        )
        _items.value = listOf(newItem) + _items.value
    }
}
