package com.example

import com.example.data.CareerDataProvider
import com.example.model.CareerQuizState
import com.example.model.OpportunityCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun initialOpportunities_isNotEmpty() {
        val list = CareerDataProvider.getInitialOpportunities()
        assertTrue("Opportunity list should not be empty", list.isNotEmpty())
        assertTrue("Should have government jobs", list.any { it.category == OpportunityCategory.GOVT_JOB })
        assertTrue("Should have 10th pathways", list.any { it.category == OpportunityCategory.STREAMS })
        assertTrue("Should have scholarships", list.any { it.category == OpportunityCategory.SCHOLARSHIP })
        assertTrue("Should have defence careers", list.any { it.category == OpportunityCategory.DEFENCE })
    }

    @Test
    fun officialPortals_containsMaharashtraGovtAndMahaDBT() {
        val portals = CareerDataProvider.officialPortals
        assertTrue("Portals should have MahaDBT", portals.any { it.url.contains("mahadbt") })
        assertTrue("Portals should have DTE", portals.any { it.url.contains("dte.maharashtra.gov.in") })
    }

    @Test
    fun careerRoadmap_generatesDiplomaPath_for10thPolytechnic() {
        val quiz = CareerQuizState(currentEducation = "10th", streamInterest = "Diploma", age = "16", jobPreference = "Government Job")
        val roadmap = CareerDataProvider.getCareerRoadmap(quiz)
        assertNotNull(roadmap)
        assertTrue(roadmap.recommendedPath.isNotEmpty())
    }
}
