package com.example.model

enum class AppLanguage {
    MARATHI,
    ENGLISH
}

enum class OpportunityCategory(
    val titleMr: String,
    val titleEn: String,
    val iconName: String
) {
    FLOW("१० वी करिअर मार्ग", "10th Career Flow", "AltRoute"),
    STREAMS("११ वी - १२ वी शाखा", "Junior College Streams", "School"),
    DIPLOMA("डिप्लोमा (पॉलिटेक्निक)", "Diploma (Polytechnic)", "Engineering"),
    ITI("आय.टी.आय. (ITI)", "ITI Trade Courses", "Handyman"),
    DEGREE("पदवी व उच्च शिक्षण", "Degree & Higher Education", "WorkspacePremium"),
    GOVT_JOB("शासकीय नोकऱ्या", "Government Jobs", "AccountBalance"),
    PVT_JOB("खाजगी नोकऱ्या", "Private Jobs", "BusinessCenter"),
    COLLEGE("कॉलेज शोधक", "College Finder", "Apartment"),
    ADMISSION("प्रवेश २०२६-२७", "Admissions 2026-27", "AssignmentTurnedIn"),
    TRAINING("कौशल्य प्रशिक्षण", "Skill Training", "Psychology"),
    SCHOLARSHIP("शिष्यवृत्ती योजना", "Scholarships", "Savings"),
    COMPETITIVE_EXAM("स्पर्धा परीक्षा", "Competitive Exams", "EmojiEvents"),
    DEFENCE("संरक्षण दले", "Defence Careers", "Security"),
    APPRENTICESHIP("शिकाऊ उमेदवारी", "Apprenticeship", "Handshake"),
    BUSINESS("व्यवसाय व स्वयंरोजगार", "Business & Self Employment", "TrendingUp")
}

enum class OpportunityStatus(val labelMr: String, val labelEn: String) {
    NEW("नवीन (NEW)", "NEW"),
    ACTIVE("सुरू आहे (ACTIVE)", "ACTIVE"),
    CLOSING_SOON("मुदत संपत आहे", "CLOSING SOON"),
    CLOSED("मुदत संपली", "CLOSED")
}

data class OpportunityItem(
    val id: String,
    val title: String,
    val titleMr: String,
    val category: OpportunityCategory,
    val subCategory: String,
    val description: String,
    val descriptionMr: String,
    val qualification: String,
    val qualificationMr: String,
    val eligibility: String,
    val eligibilityMr: String,
    val duration: String = "",
    val ageLimit: String = "",
    val vacancies: String = "",
    val lastDate: String = "",
    val location: String = "महाराष्ट्र / भारत",
    val fees: String = "",
    val officialUrl: String = "",
    val status: OpportunityStatus = OpportunityStatus.ACTIVE,
    val isVerified: Boolean = true,
    val syllabus: String = "",
    val examPattern: String = "",
    val topColleges: List<String> = emptyList(),
    val careerPaths: List<String> = emptyList(),
    val tags: List<String> = emptyList(),
    val isBookmarked: Boolean = false,
    val isUserAdded: Boolean = false
)

data class OfficialPortal(
    val id: String,
    val name: String,
    val nameMr: String,
    val authority: String,
    val url: String,
    val category: String,
    val descriptionMr: String,
    val descriptionEn: String
)

data class CareerQuizState(
    val currentEducation: String = "",
    val streamInterest: String = "",
    val age: String = "",
    val jobPreference: String = "", // Govt, Private, Business, Higher Study
    val topSkill: String = "",
    val locationPreference: String = "Maharashtra"
)

data class CareerRoadmapResult(
    val primaryHeadingMr: String,
    val primaryHeadingEn: String,
    val recommendedPath: List<String>,
    val recommendedCourses: List<String>,
    val recommendedColleges: List<String>,
    val targetExams: List<String>,
    val targetJobs: List<String>,
    val targetScholarships: List<String>,
    val adviceMr: String
)
