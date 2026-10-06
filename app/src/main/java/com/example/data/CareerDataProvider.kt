package com.example.data

import com.example.model.CareerQuizState
import com.example.model.CareerRoadmapResult
import com.example.model.OfficialPortal
import com.example.model.OpportunityCategory
import com.example.model.OpportunityItem
import com.example.model.OpportunityStatus

object CareerDataProvider {

    val officialPortals: List<OfficialPortal> = listOf(
        OfficialPortal(
            id = "gov_mh",
            name = "Government of Maharashtra",
            nameMr = "महाराष्ट्र शासन अधिकृत पोर्टल",
            authority = "Government of Maharashtra",
            url = "https://maharashtra.gov.in/",
            category = "Government Portal",
            descriptionMr = "सर्व शासन निर्णय, परिपत्रके आणि भरती विषयक अधिकृत माहिती",
            descriptionEn = "Official state resolutions, notifications and announcements"
        ),
        OfficialPortal(
            id = "dte_mh",
            name = "Directorate of Technical Education (DTE)",
            nameMr = "तंत्र शिक्षण संचालनालय, महाराष्ट्र",
            authority = "DTE Maharashtra",
            url = "https://dte.maharashtra.gov.in/",
            category = "Technical Education",
            descriptionMr = "डिप्लोमा, पदवी तंत्रशिक्षण प्रवेश व मान्यता विषयक अधिकृत संकेतस्थळ",
            descriptionEn = "Polytechnic, Engineering, Pharmacy centralized admission portal"
        ),
        OfficialPortal(
            id = "mahadbt",
            name = "MahaDBT Scholarship Portal",
            nameMr = "महाडीबीटी शिष्यवृत्ती पोर्टल",
            authority = "Government of Maharashtra",
            url = "https://mahadbt.maharashtra.gov.in/",
            category = "Scholarships",
            descriptionMr = "राज्यातील सर्व शैक्षणिक शिष्यवृत्ती व फी सवलत योजनांचे केंद्रीय पोर्टल",
            descriptionEn = "Direct Benefit Transfer portal for education scholarships & fee waivers"
        ),
        OfficialPortal(
            id = "cet_cell",
            name = "State Common Entrance Test Cell",
            nameMr = "राज्य सामाईक प्रवेश परीक्षा कक्ष",
            authority = "CET Cell Maharashtra",
            url = "https://cetcell.mahacet.org/",
            category = "Entrance Exams",
            descriptionMr = "MHT-CET, MBA, MCA, Law, B.Ed आणि इतर व्यावसायिक अभ्यासक्रम परीक्षा",
            descriptionEn = "Conducts state entrance tests and Centralized Admission Process (CAP)"
        ),
        OfficialPortal(
            id = "dvet",
            name = "Directorate of Vocational Education & Training (DVET)",
            nameMr = "व्यवसाय शिक्षण व प्रशिक्षण संचालनालय (ITI)",
            authority = "DVET Maharashtra",
            url = "https://admission.dvet.gov.in/",
            category = "Vocational & ITI",
            descriptionMr = "शासकीय व खाजगी औद्योगिक प्रशिक्षण संस्था (ITI) केंद्रीभूत प्रवेश",
            descriptionEn = "Official portal for Maharashtra ITI admissions and trade counseling"
        ),
        OfficialPortal(
            id = "mpsc",
            name = "Maharashtra Public Service Commission (MPSC)",
            nameMr = "महाराष्ट्र लोकसेवा आयोग (MPSC)",
            authority = "MPSC",
            url = "https://mpsc.gov.in/",
            category = "State Recruitment",
            descriptionMr = "राज्यसेवा, संयुक्त गट ब व क, पोलीस उपनिरीक्षक व इतर शासकीय भरती",
            descriptionEn = "State civil services examinations, PSI, STI, and class I/II recruitment"
        ),
        OfficialPortal(
            id = "upsc",
            name = "Union Public Service Commission (UPSC)",
            nameMr = "केंद्रीय लोकसेवा आयोग (UPSC)",
            authority = "UPSC Govt of India",
            url = "https://upsc.gov.in/",
            category = "National Civil Services",
            descriptionMr = "IAS, IPS, IFS, NDA, CDS राष्ट्रीय स्तरावरील सर्वोच्च स्पर्धा परीक्षा",
            descriptionEn = "National premier civil services, defence entrance and officer exams"
        ),
        OfficialPortal(
            id = "ssc",
            name = "Staff Selection Commission (SSC)",
            nameMr = "कर्मचारी निवड आयोग (SSC)",
            authority = "SSC Govt of India",
            url = "https://ssc.gov.in/",
            category = "Central Recruitment",
            descriptionMr = "SSC CGL, CHSL, MTS, GD Constable केंद्र सरकारी नोकरभरती",
            descriptionEn = "Central ministries, departments and sub-ordinate offices recruitment"
        ),
        OfficialPortal(
            id = "join_army",
            name = "Join Indian Army (NDA & Agniveer)",
            nameMr = "भारतीय लष्कर भरती अधिकृत पोर्टल",
            authority = "Ministry of Defence",
            url = "https://joinindianarmy.nic.in/",
            category = "Defence",
            descriptionMr = "अग्निवीर, एनडीए व भारतीय सैन्य अधिकारी भरती अधिकृत नोंदणी",
            descriptionEn = "Officer commissioning, NDA entry and Agniveer rally admissions"
        ),
        OfficialPortal(
            id = "apprenticeship",
            name = "National Apprenticeship Promotion Scheme (NAPS)",
            nameMr = "राष्ट्रीय शिकाऊ उमेदवारी पोर्टल",
            authority = "Ministry of Skill Development",
            url = "https://www.apprenticeshipindia.gov.in/",
            category = "Apprenticeship",
            descriptionMr = "ITI व पदविकाधारकांसाठी स्टायपेंडसह कारखान्यांमध्ये प्रत्यक्ष प्रशिक्षण",
            descriptionEn = "Industry apprenticeship vacancies with government monthly stipend"
        )
    )

    fun getInitialOpportunities(): List<OpportunityItem> = listOf(
        // ==================== CAREER FLOW NODES (10th pass) ====================
        OpportunityItem(
            id = "flow_junior_college",
            title = "11th - 12th (Junior College)",
            titleMr = "११ वी - १२ वी (कनिष्ठ महाविद्यालय)",
            category = OpportunityCategory.STREAMS,
            subCategory = "10th Pathways",
            description = "Traditional 2-year higher secondary schooling offering Arts, Commerce, Science and Agriculture streams leading to Degree courses.",
            descriptionMr = "१० वी नंतर २ वर्षांचे उच्च माध्यमिक शिक्षण. यामध्ये कला (Arts), वाणिज्य (Commerce), विज्ञान (Science) आणि कृषी (Agriculture) या प्रमुख शाखा उपलब्ध आहेत.",
            qualification = "10th Pass (SSC)",
            qualificationMr = "१० वी उत्तीर्ण",
            eligibility = "Minimum 35% in 10th standard; Science stream often requires 40% in Science subject.",
            eligibilityMr = "किमान ३५% गुण. सायन्स शाखेसाठी विज्ञानात किमान ४०% गुण आवश्यक.",
            duration = "2 Years (२ वर्षे)",
            officialUrl = "https://11thadmission.org.in/",
            status = OpportunityStatus.ACTIVE,
            careerPaths = listOf("B.A. / M.A.", "B.Com / CA", "B.Sc. / M.Sc.", "B.E. / B.Tech", "MBBS / BDS", "B.Sc. Agri", "UPSC / MPSC"),
            tags = listOf("10th pass", "11th", "12th", "Arts", "Commerce", "Science", "Agri")
        ),
        OpportunityItem(
            id = "flow_diploma",
            title = "Diploma in Engineering (Polytechnic)",
            titleMr = "डिप्लोमा (पॉलिटेक्निक - ३ वर्षे)",
            category = OpportunityCategory.DIPLOMA,
            subCategory = "Technical Pathway",
            description = "3-year practical technical program in Mechanical, Civil, Computer, Electrical, Electronics. Direct Lateral Entry to 2nd year B.E./B.Tech.",
            descriptionMr = "१० वी नंतर ३ वर्षांचे प्रात्यक्षिक तंत्रशिक्षण. मेकॅनिकल, कॉम्प्युटर, सिव्हिल, इलेक्ट्रिकल आदी शाखा. पूर्ण झाल्यावर पदवीच्या थेट द्वितीय वर्षात (Direct 2nd Year) प्रवेश मिळतो.",
            qualification = "10th Pass with Math & Science",
            qualificationMr = "१० वी गणित व विज्ञान विषयासह उत्तीर्ण",
            eligibility = "Minimum 35% aggregate in SSC with Mathematics and Science subjects.",
            eligibilityMr = "१० वी मध्ये किमान ३५% गुण (गणित व विज्ञान विषयासह).",
            duration = "3 Years (३ वर्षे)",
            officialUrl = "https://dte.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            topColleges = listOf("Govt Polytechnic Pune", "Govt Polytechnic Mumbai", "Govt Polytechnic Nagpur", "C.W.I.T Pune"),
            careerPaths = listOf("Junior Engineer (JE)", "Plant Supervisor", "Direct 2nd Year B.E. / B.Tech", "Govt PWD / WRD Jobs", "Technical Entrepreneurship"),
            tags = listOf("10th pass", "Diploma", "Polytechnic", "Engineering", "Technical")
        ),
        OpportunityItem(
            id = "flow_iti",
            title = "Industrial Training Institute (ITI)",
            titleMr = "आय.टी.आय. (औद्योगिक प्रशिक्षण संस्था - १ ते २ वर्षे)",
            category = OpportunityCategory.ITI,
            subCategory = "Skill Pathway",
            description = "Job-oriented craft trade training for immediate employment in industries, Railways, Mahavitaran, or self-employment workshops.",
            descriptionMr = "उद्योगधंद्यांमध्ये तातडीने रोजगारासाठी कौशल्याधारित प्रशिक्षण. वायरमन, इलेक्ट्रिशियन, फिटर, वेल्डर, डिझेल मेकॅनिक. रेल्वे व महावितरण भरतीसाठी अतिशय उपयुक्त.",
            qualification = "10th Pass / 8th Pass for select trades",
            qualificationMr = "१० वी उत्तीर्ण (काही ट्रेडसाठी ८ वी)",
            eligibility = "10th standard pass or appeared as per DVET norms. Age 14 years and above.",
            eligibilityMr = "किमान वय १४ वर्षे पूर्ण. १० वी उत्तीर्ण किंवा समकक्ष.",
            duration = "1 to 2 Years (१ ते २ वर्षे)",
            officialUrl = "https://admission.dvet.gov.in/",
            status = OpportunityStatus.ACTIVE,
            topColleges = listOf("Govt ITI Aundh Pune", "Govt ITI Thane", "Govt ITI Nagpur", "Govt ITI Nashik"),
            careerPaths = listOf("Railway Technician", "Mahavitaran Lineman / Technician", "Govt Ordnance Factory Jobs", "Apprenticeship with Stipend", "Electrical / Welding Workshop"),
            tags = listOf("10th pass", "ITI", "Electrician", "Fitter", "Welder", "Skill", "Railway")
        ),

        // ==================== 11th - 12th STREAMS DETAIL ====================
        OpportunityItem(
            id = "stream_arts",
            title = "Arts Stream (कला शाखा)",
            titleMr = "कला शाखा (Arts Stream - B.A. → M.A.)",
            category = OpportunityCategory.STREAMS,
            subCategory = "Higher Secondary",
            description = "Liberal arts pathway focusing on History, Political Science, Economics, Psychology, Languages and Sociology.",
            descriptionMr = "इतिहास, राज्यशास्त्र, अर्थशास्त्र, समाजशास्त्र, मानसशास्त्र आणि भाषा. स्पर्धा परीक्षा (MPSC/UPSC), विधी (Law), पत्रकारिता आणि शिक्षकी पेशासाठी सर्वोत्तम शाखा.",
            qualification = "10th Pass",
            qualificationMr = "१० वी उत्तीर्ण",
            eligibility = "Minimum 35% in SSC.",
            eligibilityMr = "१० वी किमान ३५% गुणांसह उत्तीर्ण.",
            duration = "2 Years (11th + 12th)",
            careerPaths = listOf("B.A. → M.A.", "Civil Services (UPSC / MPSC)", "Law (3yr / 5yr LLB)", "Journalism & Mass Media", "Social Work (BSW/MSW)", "Teaching (D.El.Ed / B.Ed)"),
            tags = listOf("Arts", "UPSC", "MPSC", "B.A.", "Law", "Teaching")
        ),
        OpportunityItem(
            id = "stream_commerce",
            title = "Commerce Stream (वाणिज्य शाखा)",
            titleMr = "वाणिज्य शाखा (Commerce Stream - B.Com → M.Com)",
            category = OpportunityCategory.STREAMS,
            subCategory = "Higher Secondary",
            description = "Business fundamentals, Accountancy, Economics, Commercial Law, Taxation, and Secretarial Practice.",
            descriptionMr = "हिशेबशास्त्र (Accountancy), अर्थशास्त्र, बँकिंग, कर प्रणाली व व्यवसाय संघटन. बँकिंग, सीए (CA), कंपनी सेक्रेटरी (CS), कॉस्ट अकाउंटंट आणि फायनान्स क्षेत्रासाठी आदर्श.",
            qualification = "10th Pass",
            qualificationMr = "१० वी उत्तीर्ण",
            eligibility = "Minimum 35% in SSC.",
            eligibilityMr = "१० वी किमान ३५% गुणांसह उत्तीर्ण.",
            duration = "2 Years (11th + 12th)",
            careerPaths = listOf("B.Com → M.Com", "Chartered Accountant (CA)", "Company Secretary (CS)", "Banking Officer / PO", "Tax Consultant / Auditor", "BBA / MBA Finance"),
            tags = listOf("Commerce", "B.Com", "CA", "Banking", "Finance", "Accounts")
        ),
        OpportunityItem(
            id = "stream_science",
            title = "Science Stream (विज्ञान शाखा)",
            titleMr = "विज्ञान शाखा (Science Stream - B.Sc. → M.Sc. / Engg / Medical)",
            category = OpportunityCategory.STREAMS,
            subCategory = "Higher Secondary",
            description = "Physics, Chemistry, Mathematics, Biology (PCMB / PCM / PCB). Foundation for Engineering, Medical, Research, and Tech degrees.",
            descriptionMr = "भौतिकशास्त्र, रसायनशास्त्र, गणित आणि जीवशास्त्र. इंजिनिअरिंग (JEE/CET), मेडिकल (NEET), फार्मसी, कॉम्प्युटर ऍप्लिकेशन, संशोधन व संरक्षण क्षेत्रासाठी आवश्यक.",
            qualification = "10th Pass with Science & Math",
            qualificationMr = "१० वी विज्ञान व गणितासह उत्तीर्ण",
            eligibility = "Minimum 40% in Science in SSC exam.",
            eligibilityMr = "१० वी विज्ञानात किमान ४०% गुण.",
            duration = "2 Years (11th + 12th)",
            careerPaths = listOf("Engineering (B.E. / B.Tech)", "Medical (MBBS, BDS, BAMS)", "Pharmacy (B.Pharm)", "B.Sc. Research / IT", "NDA Defence Officer", "MHT-CET / JEE / NEET"),
            tags = listOf("Science", "PCM", "PCB", "Engineering", "Medical", "JEE", "NEET", "CET")
        ),
        OpportunityItem(
            id = "stream_agri",
            title = "Agriculture Stream (कृषी शाखा)",
            titleMr = "कृषी शाखा (Agriculture Stream - 12th Agri → B.Sc. Agri)",
            category = OpportunityCategory.STREAMS,
            subCategory = "Higher Secondary",
            description = "Crop science, Animal husbandry, Soil science, Farm machinery, and Agro-business management fundamentals.",
            descriptionMr = "पीक उत्पादन, मृद विज्ञान, पशुसंवर्धन, कृषी अवजारे व कृषी अर्थशास्त्र. कृषी पदवी (B.Sc. Agriculture), कृषी अधिकारी, बियाणे व खत कंपन्या आणि ऍग्री-बिझनेससाठी उत्कृष्ट मार्ग.",
            qualification = "10th Pass",
            qualificationMr = "१० वी उत्तीर्ण (शेतकरी पाल्यांना अतिरिक्त वेटेज गुण)",
            eligibility = "SSC pass with science or vocational agriculture subjects.",
            eligibilityMr = "१० वी उत्तीर्ण. कृषी पदवी प्रवेशात ७/१२ उतारा असल्यास अतिरिक्त १२ गुण मिळतात.",
            duration = "2 Years (11th + 12th)",
            careerPaths = listOf("B.Sc. Agriculture", "Agriculture Officer (Class I & II)", "Horticulture / Dairy Tech", "Soil & Fertilizer Analyst", "Agri-Tech Startup / Nursery"),
            tags = listOf("Agriculture", "B.Sc Agri", "Krishi", "Farmer", "Agri Officer")
        ),

        // ==================== DEGREE COURSES - AGRICULTURE & ALLIED ====================
        OpportunityItem(
            id = "deg_bsc_agri",
            title = "B.Sc. (Honours) Agriculture",
            titleMr = "बी.एस्सी. (कृषी) - B.Sc. Agriculture",
            category = OpportunityCategory.DEGREE,
            subCategory = "Agriculture & Allied",
            description = "4-year professional undergraduate degree covering Agronomy, Plant Breeding, Soil Science, Agricultural Entomology, and Extension Education.",
            descriptionMr = "४ वर्षांची व्यावसायिक कृषी पदवी. यामध्ये पीक लागवड, मृद विज्ञान, कीटकशास्त्र, वनस्पती रोगशास्त्र आणि ग्रामीण कृषी अनुभव कार्यक्रम (RAWE) समाविष्ट असतो.",
            qualification = "12th Science (PCB / PCMB / Agri)",
            qualificationMr = "१२ वी सायन्स (PCB / PCMB किंवा कृषी विषय)",
            eligibility = "MHT-CET (PCB/PCM) with minimum 50% marks in 12th. Extra weightage for 7/12 landholder certificate.",
            eligibilityMr = "MHT-CET परीक्षा उत्तीर्ण. शेतकरी दाखला / ७-१२ उतारा असल्यास प्रवेशात १२ अतिरिक्त गुण.",
            duration = "4 Years (४ वर्षे)",
            fees = "₹35,000 - ₹85,000 प्रति वर्ष (MahaDBT सवलत लागू)",
            officialUrl = "https://cetcell.mahacet.org/",
            status = OpportunityStatus.ACTIVE,
            topColleges = listOf("College of Agriculture Pune (MPKV)", "PKV Akola", "VNMKV Parbhani", "DBSKKV Dapoli"),
            careerPaths = listOf("Agriculture Field Officer (IBPS AFO)", "Taluka Agriculture Officer (MPSC Agri)", "Seed & Pesticide MNC Officer", "Agri Business Manager", "NABARD Officer"),
            tags = listOf("B.Sc Agriculture", "Agri", "MCAER", "MHT-CET", "MPKV", "AFO")
        ),
        OpportunityItem(
            id = "deg_food_tech",
            title = "B.Tech. Food Technology",
            titleMr = "बी.टेक. अन्न तंत्रज्ञान (Food Technology)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Agriculture & Allied",
            description = "Processing, preservation, packaging, quality control and distribution of food products and value-added agri commodities.",
            descriptionMr = "अन्न प्रक्रिया, साठवणूक, पॅकेजिंग आणि गुणवत्ता नियंत्रण. एफएमसीजी (FMCG) कंपन्या, डेअरी उद्योग आणि सरकारी अन्न सुरक्षा विभागात मोठी मागणी.",
            qualification = "12th Science (PCM / PCMB)",
            qualificationMr = "१२ वी सायन्स (PCM / PCMB)",
            eligibility = "MHT-CET or JEE Main score with 50% in 12th standard.",
            eligibilityMr = "MHT-CET / JEE गुणांच्या आधारे केंद्रीय प्रवेश (CAP).",
            duration = "4 Years (४ वर्षे)",
            fees = "₹45,000 - ₹1,20,000 प्रति वर्ष",
            officialUrl = "https://cetcell.mahacet.org/",
            topColleges = listOf("ICT Mumbai", "MIT-WPU Pune", "VNMKV Parbhani Food Tech College", "Dr. BSKKV Dapoli"),
            careerPaths = listOf("Food Quality Manager", "FSSAI Food Safety Officer", "Production Supervisor (Amul, Nestlé, Britannia)", "R&D Food Technologist"),
            tags = listOf("Food Tech", "B.Tech", "Dairy", "Processing", "FSSAI")
        ),
        OpportunityItem(
            id = "deg_horticulture",
            title = "B.Sc. Horticulture",
            titleMr = "बी.एस्सी. फलोत्पादन (Horticulture)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Agriculture & Allied",
            description = "Specialized cultivation of fruits, vegetables, flowers, spices, aromatic plants and landscape gardening.",
            descriptionMr = "फळे, फुले, भाजीपाला, औषधी वनस्पती आणि हरितगृह (Greenhouse) शेतीचे आधुनिक तंत्रज्ञान.",
            qualification = "12th Science (PCB / PCMB)",
            qualificationMr = "१२ वी सायन्स (PCB / PCMB)",
            eligibility = "MHT-CET / Agriculture CAP Round eligibility.",
            eligibilityMr = "MHT-CET परीक्षा व कृषी विद्यापीठ गुणवत्ता यादी.",
            duration = "4 Years (४ वर्षे)",
            topColleges = listOf("College of Horticulture Pune", "DBSKKV Dapoli", "PKV Akola"),
            careerPaths = listOf("Horticulture Officer", "Greenhouse Consultant", "Floriculture Exporter", "Landscape Architect"),
            tags = listOf("Horticulture", "Fruits", "Floriculture", "Polyhouse", "Agri")
        ),

        // ==================== DEGREE COURSES - MEDICAL & HEALTH ====================
        OpportunityItem(
            id = "deg_mbbs",
            title = "MBBS (Bachelor of Medicine & Surgery)",
            titleMr = "एम.बी.बी.एस. (MBBS - ॲलोपॅथी वैद्यकीय पदवी)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Medical & Health Sciences",
            description = "Premier 5.5-year medical degree including 1-year rotatory clinical internship. Leads to Registered Medical Practitioner.",
            descriptionMr = "सर्वोच्च ॲलोपॅथी वैद्यकीय पदवी. साडेपाच वर्षांचा अभ्यासक्रम (४.५ वर्षे कॉलेज + १ वर्ष अनिवार्य इंटर्नशिप). पूर्ण झाल्यावर डॉक्टर म्हणून नोंदणी.",
            qualification = "12th Science (PCB - Physics, Chem, Biology)",
            qualificationMr = "१२ वी सायन्स (भौतिकशास्त्र, रसायनशास्त्र, जीवशास्त्र)",
            eligibility = "NEET-UG qualification with minimum 50th percentile (40th for reserved categories) and 50% in PCB in 12th.",
            eligibilityMr = "NEET-UG राष्ट्रीय परीक्षेत गुणवत्ता. १२ वी PCB मध्ये किमान ५०% गुण (राखीव वर्गासाठी ४०%).",
            duration = "5.5 Years (साडेपाच वर्षे)",
            fees = "शासकीय: ₹1,15,000/वर्ष | खाजगी: ₹8 ते ₹16 लाख/वर्ष (MahaDBT सवलत उपलब्ध)",
            officialUrl = "https://cetcell.mahacet.org/",
            status = OpportunityStatus.ACTIVE,
            topColleges = listOf("Grant Govt Medical College Mumbai", "BJ Govt Medical College Pune", "GMC Nagpur", "GSMC KEM Mumbai", "GMC Aurangabad"),
            careerPaths = listOf("Medical Officer (Class I Govt)", "Postgraduate Specialization (MD / MS)", "Hospital Consultant", "Army Medical Corps (AMC)", "Private Clinic / Hospital"),
            tags = listOf("MBBS", "Doctor", "NEET", "Medical", "GMC", "Hospital")
        ),
        OpportunityItem(
            id = "deg_bams",
            title = "BAMS (Ayurvedic Medicine & Surgery)",
            titleMr = "बी.ए.एम.एस. (BAMS - आयुर्वेद वैद्यकीय पदवी)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Medical & Health Sciences",
            description = "Traditional Indian medicine coupled with modern anatomy, physiology and surgical principles. Highly popular in Maharashtra.",
            descriptionMr = "प्राचीन आयुर्वेद चिकित्सा पद्धती व आधुनिक वैद्यकशास्त्राचा संगम. महाराष्ट्रात स्वतःची प्रॅक्टिस किंवा शासकीय वैद्यकीय अधिकारी म्हणून उत्तम संधी.",
            qualification = "12th Science (PCB)",
            qualificationMr = "१२ वी सायन्स (PCB)",
            eligibility = "NEET-UG exam merit through Maharashtra State AYUSH Counselling.",
            eligibilityMr = "NEET-UG परीक्षेतील गुणांच्या आधारे आयुष (AYUSH) केंद्रीय प्रवेश प्रक्रिया.",
            duration = "5.5 Years (४.५ वर्षे + १ वर्ष इंटर्नशिप)",
            topColleges = listOf("RA Podar Ayurved College Mumbai", "Govt Ayurved College Nanded", "Tilak Ayurved Mahavidyalaya Pune", "Govt Ayurved College Osmanabad"),
            careerPaths = listOf("Ayurvedic Medical Officer", "Panchakarma Specialist", "Clinical Practice", "Ayurvedic Pharma R&D"),
            tags = listOf("BAMS", "Ayurveda", "NEET", "Doctor", "Panchakarma")
        ),
        OpportunityItem(
            id = "deg_bpharm",
            title = "B.Pharmacy (Bachelor of Pharmacy)",
            titleMr = "बी.फार्मसी (औषधनिर्माण शास्त्र पदवी)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Medical & Health Sciences",
            description = "Drug formulation, chemical synthesis, pharmacology, clinical trials, and drug regulatory affairs with registered pharmacist license.",
            descriptionMr = "औषध निर्मिती, क्लिनिकल ट्रायल्स, आणि औषध प्रशासन. पूर्ण झाल्यावर अधिकृत मेडिकल स्टोअर परवाना (Drug License) आणि फार्मा कंपन्यांमध्ये संधी.",
            qualification = "12th Science (PCB or PCM)",
            qualificationMr = "१२ वी सायन्स (PCB किंवा PCM)",
            eligibility = "MHT-CET or NEET score with minimum 45% aggregate in 12th standard.",
            eligibilityMr = "MHT-CET / NEET गुण व १२ वी मध्ये किमान ४५% गुण (राखीव वर्गासाठी ४०%).",
            duration = "4 Years (४ वर्षे)",
            officialUrl = "https://cetcell.mahacet.org/",
            topColleges = listOf("ICT Mumbai", "Govt College of Pharmacy Karad", "Govt College of Pharmacy Amravati", "Poona College of Pharmacy"),
            careerPaths = listOf("Drug Inspector (MPSC Class II)", "Pharma QC / QA Chemist", "Medical Store Owner (Retail/Wholesale)", "Clinical Research Associate"),
            tags = listOf("Pharmacy", "B.Pharm", "MHT-CET", "Drug License", "Pharma")
        ),
        OpportunityItem(
            id = "deg_nursing",
            title = "B.Sc. Nursing",
            titleMr = "बी.एस्सी. नर्सिंग (B.Sc. Nursing)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Medical & Health Sciences",
            description = "Professional nursing care, emergency life support, critical care, and community healthcare with worldwide high demand.",
            descriptionMr = "रुग्णसेवा, अतिदक्षता विभाग (ICU) आणि शस्त्रक्रिया गृहातील प्रशिक्षित परिचारिका. परदेशात (UK, Germany, Gulf, USA) प्रचंड मागणी व भरघोस पगार.",
            qualification = "12th Science (PCB)",
            qualificationMr = "१२ वी सायन्स (PCB)",
            eligibility = "MH-B.Sc. Nursing CET conducted by State CET Cell Maharashtra.",
            eligibilityMr = "महाराष्ट्र राज्य CET सेलतर्फे घेण्यात येणारी B.Sc. Nursing CET परीक्षा.",
            duration = "4 Years (४ वर्षे)",
            officialUrl = "https://cetcell.mahacet.org/",
            topColleges = listOf("College of Nursing GMC Mumbai", "BJMC College of Nursing Pune", "AFMC Nursing College Pune"),
            careerPaths = listOf("Staff Nurse (Govt / AIIMS / Military)", "Nursing Superintendent", "International Nurse (OET / NCLEX)", "Tutor in Nursing Colleges"),
            tags = listOf("Nursing", "B.Sc Nursing", "Healthcare", "Hospital", "Jobs Abroad")
        ),

        // ==================== DEGREE COURSES - ENGINEERING & TECHNOLOGY ====================
        OpportunityItem(
            id = "deg_be_tech",
            title = "B.E. / B.Tech (Engineering & Technology)",
            titleMr = "बी.ई. / बी.टेक. (इंजिनिअरिंग व तंत्रज्ञान)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Engineering & Technology",
            description = "4-year professional engineering degree across Computer Science, AI & Data Science, Mechanical, Civil, Electrical, and ENTC branches.",
            descriptionMr = "कॉम्प्युटर सायन्स, कृत्रिम बुद्धिमत्ता (AI), मेकॅनिकल, सिव्हिल, इलेक्ट्रॉनिक्स आणि इलेक्ट्रिकल इंजिनिअरिंग. जागतिक आयटी व उद्योग क्षेत्रातील सर्वोच्च करिअर संधी.",
            qualification = "12th Science (PCM) OR Diploma Lateral Entry",
            qualificationMr = "१२ वी सायन्स (PCM) किंवा पॉलिटेक्निक डिप्लोमा",
            eligibility = "MHT-CET or JEE Main score with 45% in PCM in 12th. Diploma holders get direct 2nd-year admission via CAP.",
            eligibilityMr = "MHT-CET / JEE Main परीक्षा. पॉलिटेक्निक पदविकाधारकांना थेट दुसऱ्या वर्षात (DSE) प्रवेश.",
            duration = "4 Years (डिप्लोमानंतर ३ वर्षे)",
            fees = "शासकीय: ₹85,000/वर्ष | खाजगी: ₹1.2 ते ₹2.5 लाख/वर्ष (MahaDBT सवलत लागू)",
            officialUrl = "https://dte.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            topColleges = listOf("COEP Tech University Pune", "VJTI Mumbai", "ICT Mumbai", "Walchand College Sangli", "Govt College of Engg Aurangabad/Karad"),
            careerPaths = listOf("Software Developer / AI Engineer", "Govt Junior / Assistant Engineer (PWD, WRD, MSEDCL)", "ISRO / DRDO Scientist", "Data Scientist", "IES / UPSC Engineering Services"),
            tags = listOf("Engineering", "B.Tech", "Computer", "AI", "MHT-CET", "COEP", "VJTI")
        ),

        // ==================== DEGREE COURSES - HOSPITALITY & HOTEL MANAGEMENT ====================
        OpportunityItem(
            id = "deg_bhm",
            title = "Bachelor of Hotel Management (BHM)",
            titleMr = "बॅचलर ऑफ हॉटेल मॅनेजमेंट (BHM - हॉटेल व हॉस्पिटॅलिटी)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Hospitality & Hotel Management",
            description = "Culinary arts, food & beverage service, front office operations, luxury tourism, cruise line operations, and event management.",
            descriptionMr = "आंतरराष्ट्रीय पंचतारांकित हॉटेल्स, क्रूझ लाइनर्स, विमान कंपन्या आणि इव्हेंट मॅनेजमेंटमधील उच्च व्यवस्थापकीय करिअर.",
            qualification = "12th Any Stream (Arts / Commerce / Science)",
            qualificationMr = "१२ वी कोणत्याही शाखेतून उत्तीर्ण",
            eligibility = "NCHMCT JEE or MAH-B.HMCT CET entrance exam.",
            eligibilityMr = "MAH-B.HMCT CET किंवा NCHMCT JEE राष्ट्रीय प्रवेश परीक्षा.",
            duration = "3 to 4 Years (३ ते ४ वर्षे)",
            topColleges = listOf("IHM Mumbai (Dadar)", "MS Ramaiah BHM", "Bharati Vidyapeeth IHMCT Pune", "Dr. D.Y. Patil IHMCT Pune"),
            careerPaths = listOf("Executive Chef", "Food & Beverage Manager", "Luxury Cruise Line Hospitality Officer", "Airlines Cabin Crew / Ground Staff", "Resort General Manager"),
            tags = listOf("Hotel Management", "BHM", "Chef", "Cruise", "Tourism", "Hospitality")
        ),

        // ==================== DEGREE COURSES - PARAMEDICAL & LAB ====================
        OpportunityItem(
            id = "deg_dmlt_bmlt",
            title = "B.Sc. Medical Laboratory Technology (BMLT / DMLT)",
            titleMr = "बी.एस्सी. मेडिकल लॅब टेक्नॉलॉजी (B.Sc. MLT / DMLT)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Lab & Paramedical",
            description = "Diagnostic lab investigations, hematology, clinical biochemistry, microbiology, and pathology lab setup.",
            descriptionMr = "रक्त, मूत्र व इतर वैद्यकीय चाचण्यांचे तंत्रज्ञान. पॅथॉलॉजी लॅब, हॉस्पिटल्स आणि डायग्नोस्टिक सेंटर्समध्ये स्वतःची लॅब किंवा तंत्रज्ञ म्हणून काम.",
            qualification = "12th Science (PCB/PCMB) or 10th for DMLT",
            qualificationMr = "१२ वी सायन्स (PCB/PCMB) किंवा १० वी नंतर DMLT",
            eligibility = "Merit in 12th standard Science stream or entrance test.",
            eligibilityMr = "१२ वी विज्ञान गुणांच्या आधारे गुणवत्ता यादी.",
            duration = "3 Years (Degree) / 2 Years (Diploma)",
            topColleges = listOf("Armed Forces Medical College (AFMC) Pune", "Tata Memorial Centre Mumbai", "MUHS Nashik affiliated centres"),
            careerPaths = listOf("Pathology Lab Technician", "Govt Hospital Lab Officer", "Private Diagnostic Lab Owner", "Bio-medical Research Assistant"),
            tags = listOf("MLT", "DMLT", "Pathology", "Blood Test", "Paramedical")
        ),

        // ==================== OTHER PROFESSIONAL DEGREES ====================
        OpportunityItem(
            id = "deg_law",
            title = "B.A. LL.B. / 3-Year LL.B. (Law)",
            titleMr = "विधी पदवी - B.A. LL.B. (५ वर्षे) / LL.B. (३ वर्षे)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Other Degree & Professional Courses",
            description = "Constitutional law, criminal law, civil procedure, corporate compliance, and judiciary examinations.",
            descriptionMr = "वकिली, न्यायालयीन सेवा, सरकारी वकील आणि कॉर्पोरेट कायदेशीर सल्लागार. १२ वी नंतर ५ वर्षांचा इंटिग्रेटेड कोर्स किंवा पदवीनंतर ३ वर्षांचा कोर्स.",
            qualification = "12th Pass (5-yr) OR Any Graduation (3-yr)",
            qualificationMr = "१२ वी उत्तीर्ण (५ वर्षांसाठी) किंवा कोणत्याही शाखेची पदवी (३ वर्षांसाठी)",
            eligibility = "MAH-LL.B. CET (5-Year / 3-Year) conducted by State CET Cell.",
            eligibilityMr = "महाराष्ट्र राज्य CET सेलची MAH-LL.B. CET परीक्षा.",
            duration = "5 Years after 12th / 3 Years after Graduation",
            officialUrl = "https://cetcell.mahacet.org/",
            topColleges = listOf("ILS Law College Pune", "Government Law College (GLC) Mumbai", "DES Navalmal Firodia Law College Pune"),
            careerPaths = listOf("Advocate / High Court & District Court Lawyer", "Civil Judge Junior Division (JMFC)", "Public Prosecutor (सरकारी वकील)", "Corporate Legal Counsel"),
            tags = listOf("Law", "LLB", "Advocate", "Judge", "CET", "Legal")
        ),
        OpportunityItem(
            id = "deg_bca_mca",
            title = "BCA / MCA (Computer Applications)",
            titleMr = "बी.सी.ए. / एम.सी.ए. (BCA / MCA - संगणक अनुप्रयोग)",
            category = OpportunityCategory.DEGREE,
            subCategory = "Other Degree & Professional Courses",
            description = "Software development, database management, cloud computing, mobile applications and full-stack engineering without requiring 12th PCM.",
            descriptionMr = "कोणत्याही शाखेतील विद्यार्थ्यांसाठी संगणक सॉफ्टवेअर, वेब डेव्हलपमेंट, ॲप डेव्हलपमेंट आणि आयटी कंपनीत करिअर करण्याची उत्तम संधी.",
            qualification = "12th Pass (Any stream with English/Math preference)",
            qualificationMr = "१२ वी कोणत्याही शाखेतून उत्तीर्ण",
            eligibility = "MAH-BCA/BBA/BMS CET entrance score.",
            eligibilityMr = "महाराष्ट्र शासनाची MAH-BCA CET परीक्षा.",
            duration = "3 Years (BCA) + 2 Years (MCA)",
            topColleges = listOf("Symbiosis Institute of Computer Studies Pune", "Modern College Pune", "Bharati Vidyapeeth Pune"),
            careerPaths = listOf("Full Stack Software Engineer", "Mobile App Developer", "Cloud Administrator", "System Analyst"),
            tags = listOf("BCA", "MCA", "Coding", "Software", "IT", "Computers")
        ),

        // ==================== GOVERNMENT JOBS ====================
        OpportunityItem(
            id = "job_mpsc_rajyaseva",
            title = "MPSC State Services (महाराष्ट्र राज्यसेवा)",
            titleMr = "MPSC राज्यसेवा (उपजिल्हाधिकारी, तहसीलदार, उपविभागीय अधिकारी)",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "MPSC / State Services",
            description = "Maharashtra's top administrative civil service exam for Class-A and Class-B administrative gazetted posts.",
            descriptionMr = "महाराष्ट्र शासनातील सर्वोच्च वर्ग-१ व वर्ग-२ प्रशासकीय राजपत्रित पदांसाठीची परीक्षा. उपजिल्हाधिकारी, डीवायएसपी (DYSP), तहसीलदार आणि गटविकास अधिकारी (BDO).",
            qualification = "Any Degree (कोणतीही पदवी)",
            qualificationMr = "मान्यताप्राप्त विद्यापीठाची कोणतीही पदवी (कला, वाणिज्य, विज्ञान, इंजिनिअरिंग, कृषी, इत्यादी)",
            eligibility = "Age 19 to 38 years (43 years for reserved categories). Marathi language proficiency mandatory.",
            eligibilityMr = "किमान वय १९ वर्षे, कमाल ३८ वर्षे (मागासवर्गीयांसाठी ४३ वर्षे).",
            duration = "Pre + Mains + Interview (पूर्व + मुख्य + मुलाखत)",
            vacancies = "२५०+ पदे (दरवर्षी भरती)",
            lastDate = "जाहिरात प्रसिद्धीनुसार (MPSC कॅलेंडर पहा)",
            officialUrl = "https://mpsc.gov.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "पूर्व परीक्षा (२ पेपर - ४०० गुण) + मुख्य परीक्षा (वर्णनात्मक पद्धत - १७५० गुण) + मुलाखत (२७५ गुण)",
            syllabus = "इतिहास, भूगोल, राज्यशास्त्र, अर्थव्यवस्था, चालू घडामोडी, निबंध, सामान्य अध्ययन पेपर १ ते ४ व पर्यायी विषय",
            careerPaths = listOf("Deputy Collector (उपजिल्हाधिकारी)", "Deputy Superintendent of Police (DYSP)", "Tahsildar (तहसीलदार)", "Block Development Officer (BDO)"),
            tags = listOf("MPSC", "Rajyaseva", "Collector", "DYSP", "Govt Job", "Class 1")
        ),
        OpportunityItem(
            id = "job_mpsc_combine",
            title = "MPSC Combined Group B & C (संयुक्त पूर्व परीक्षा)",
            titleMr = "MPSC संयुक्त गट-ब व गट-क (PSI / STI / ASO / कर सहाय्यक / लिपिक)",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "MPSC / State Services",
            description = "Huge recruitment drive for Police Sub-Inspector (PSI), State Tax Inspector (STI), Assistant Section Officer (ASO), and Clerk-Typist.",
            descriptionMr = "पोलीस उपनिरीक्षक (PSI), राज्य कर निरीक्षक (STI), मंत्रालय सहाय्यक कक्ष अधिकारी (ASO) आणि दुय्यम निबंधक पदांसाठीची सर्वात लोकप्रिय परीक्षा.",
            qualification = "Any Degree (पदवीधर)",
            qualificationMr = "कोणत्याही शाखेतील पदवीधर (PSI साठी शारीरिक पात्रता आवश्यक)",
            eligibility = "PSI Age: 19 to 31 years. Height: Men 165 cm, Women 157 cm. STI/ASO Age: 19 to 38 years.",
            eligibilityMr = "PSI साठी किमान उंची पुरुष १६५ सेमी, महिला १५७ सेमी. वय १९ ते ३१ वर्षे.",
            duration = "Pre Exam + Mains + Physical (for PSI)",
            vacancies = "८०००+ पदे (नियमित मोठी भरती)",
            lastDate = "अधिकृत नोटिफिकेशननुसार",
            officialUrl = "https://mpsc.gov.in/",
            status = OpportunityStatus.NEW,
            examPattern = "संयुक्त पूर्व परीक्षा (१०० प्रश्न - १०० गुण) + मुख्य परीक्षा (पेपर १ भाषा व पेपर २ सामान्य क्षमता चाचणी)",
            careerPaths = listOf("Police Sub-Inspector (PSI)", "State Tax Inspector (STI)", "Assistant Section Officer (ASO - मंत्रालय)", "Tax Assistant"),
            tags = listOf("MPSC", "PSI", "STI", "ASO", "Combine", "Police Sub-Inspector")
        ),
        OpportunityItem(
            id = "job_maha_police",
            title = "Maharashtra Police Bharti (महाराष्ट्र पोलीस भरती)",
            titleMr = "महाराष्ट्र पोलीस शिपाई भरती (Police Constable / चालक / SRPF)",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "Police",
            description = "Statewide recruitment for Police Constable, Police Driver, and State Reserve Police Force (SRPF) jawans.",
            descriptionMr = "महाराष्ट्र पोलीस दलात पोलीस शिपाई, चालक पोलीस शिपाई आणि एसआरपीएफ (SRPF) जवान पदांसाठी राज्यव्यापी मेगा भरती.",
            qualification = "12th Standard Pass (१२ वी उत्तीर्ण)",
            qualificationMr = "१२ वी (HSC) कोणत्याही शाखेतून उत्तीर्ण",
            eligibility = "Age 18 to 28 years (open), 33 years (reserved). Height: Men 165 cm, Women 158 cm. Chest (men): 79-84 cm.",
            eligibilityMr = "वय १८ ते २८ वर्षे (मागासवर्गीय ३३ वर्षे). पुरुष उंची किमान १६५ सेमी, छाती ७९ ते ८४ सेमी. महिला उंची १५८ सेमी.",
            duration = "Physical Test (मैदानी ५० गुण) + Written Test (लेखी १०० गुण)",
            vacancies = "१७,४००+ पदे (जिल्हानिहाय पदे)",
            lastDate = "अधिकृत प्रसिद्धीनुसार",
            officialUrl = "https://policerecruitment2024.mahait.org/",
            status = OpportunityStatus.CLOSING_SOON,
            examPattern = "मैदानी चाचणी (धावणे, गोळाफेक - ५० गुण) + लेखी परीक्षा (अंकगणित, बुद्धिमत्ता, मराठी व्याकरण, सामान्य ज्ञान - १०० गुण)",
            careerPaths = listOf("Police Constable (पोलीस शिपाई)", "Head Constable (हवालदार)", "Assistant Police Sub-Inspector (ASI)", "Police Sub-Inspector (PSI Promotion)"),
            tags = listOf("Police Bharti", "12th Pass", "Constable", "Maha Police", "Govt Job")
        ),
        OpportunityItem(
            id = "job_railway_tech",
            title = "Railway Recruitment Board (RRB) Technician & ALP",
            titleMr = "रेल्वे भरती - असिस्टंट लोको पायलट (ALP) व टेक्निशियन",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "Railway",
            description = "Central Government railway jobs in Indian Railways for train drivers and maintenance technicians with high job security.",
            descriptionMr = "भारतीय रेल्वेमध्ये रेल्वे चालक (ALP) आणि विविध वर्कशॉपमध्ये तंत्रज्ञ (Technician). केंद्र शासनाचे उत्तम वेतन, भत्ते आणि मोफत रेल्वे पास सुविधा.",
            qualification = "10th Pass + ITI OR Diploma in Engg",
            qualificationMr = "१० वी + ITI (संबंधित ट्रेड) किंवा मेकॅनिकल/इलेक्ट्रिकल डिप्लोमा",
            eligibility = "Age 18 to 30 years (relaxation for SC/ST/OBC). Strict medical vision standards for ALP.",
            eligibilityMr = "वय १८ ते ३० वर्षे. डोळ्यांची दृष्टी ६/६ असणे आवश्यक (लोको पायलटसाठी).",
            vacancies = "१८,७००+ पदे (अखिल भारतीय)",
            officialUrl = "https://www.rrbmumbai.gov.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "CBT-1 (गणित, सामान्य विज्ञान, बुद्धिमत्ता - ७५ गुण) + CBT-2 (तांत्रिक ट्रेड विषय) + CBAT सायको टेस्ट",
            careerPaths = listOf("Assistant Loco Pilot (ALP)", "Loco Pilot (Goods / Express Train)", "Railway Senior Technician", "Junior Engineer (JE Railways)"),
            tags = listOf("Railway", "RRB", "ALP", "Technician", "ITI Jobs", "Central Govt")
        ),
        OpportunityItem(
            id = "job_ssc_cgl",
            title = "SSC CGL (Staff Selection Commission Combined Graduate Level)",
            titleMr = "SSC CGL (केंद्रीय मंत्रालयात इन्स्पेक्टर, कर सहाय्यक व अधिकारी)",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "SSC",
            description = "Group B & C officer posts in Central Ministries, CBI, Enforcement Directorate (ED), Income Tax, GST and Customs.",
            descriptionMr = "केंद्रीय मंत्रालये, इन्कम टॅक्स इन्स्पेक्टर, जीएसटी इन्स्पेक्टर, सीबीआय (CBI) सब-इन्स्पेक्टर, अंमलबजावणी संचालनालय (ED) आणि ऑपरेटर पदे.",
            qualification = "Any Graduation (कोणतीही पदवी)",
            qualificationMr = "कोणत्याही शाखेतील पदवीधर",
            eligibility = "Age 18 to 30/32 years depending on post.",
            eligibilityMr = "वय १८ ते ३०/३२ वर्षे.",
            vacancies = "१४,०००+ पदे",
            officialUrl = "https://ssc.gov.in/",
            status = OpportunityStatus.NEW,
            examPattern = "Tier 1 (रीझनिंग, गणित, इंग्रजी, सामान्य ज्ञान - २०० गुण) + Tier 2 (कॉम्प्युटर व डेटा एंट्रीसह)",
            careerPaths = listOf("Income Tax Inspector", "Central Excise / GST Inspector", "CBI Sub-Inspector", "Assistant Audit Officer (CAG)"),
            tags = listOf("SSC", "CGL", "Inspector", "Income Tax", "Central Govt", "Degree")
        ),
        OpportunityItem(
            id = "job_banking_ibps",
            title = "IBPS PO & Clerk (Nationalized Bank Recruitment)",
            titleMr = "बँक भरती - IBPS PO, लिपिक आणि SBI अधिकारी",
            category = OpportunityCategory.GOVT_JOB,
            subCategory = "Banking",
            description = "Probationary Officers and Clerks across Bank of Baroda, Canara Bank, Union Bank, PNB and SBI.",
            descriptionMr = "सर्व राष्ट्रीयीकृत बँकांमध्ये प्रोबेशनरी ऑफिसर (PO) व लिपिक भरती. सन्मानजनक नोकरी, वेळेवर पगार आणि भरघोस सुविधा.",
            qualification = "Any Graduation",
            qualificationMr = "कोणत्याही शाखेतील पदवीधर (कॉम्प्युटरचे मूलभूत ज्ञान आवश्यक)",
            eligibility = "PO Age: 20 to 30 years. Clerk Age: 20 to 28 years.",
            eligibilityMr = "वय २० ते ३० वर्षे (पीओ) / २० ते २८ वर्षे (क्लर्क).",
            vacancies = "९,५००+ पदे",
            officialUrl = "https://www.ibps.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "Pre Exam (इंग्रजी, ॲप्टिट्यूड, रीझनिंग - १०० गुण) + Mains Exam (डेटा इंटरप्रिटेशन, बँकिंग अवेयरनेस) + मुलाखत (PO साठी)",
            careerPaths = listOf("Bank PO", "Assistant Branch Manager", "Chief Manager", "General Manager Banking"),
            tags = listOf("Banking", "IBPS", "SBI", "Bank PO", "Clerk", "Commerce")
        ),

        // ==================== PRIVATE JOBS ====================
        OpportunityItem(
            id = "pvt_software_dev",
            title = "Junior Software Developer / Full-Stack Engineer",
            titleMr = "सॉफ्टवेअर डेव्हलपर / वेब व ॲप इंजिनिअर (IT Jobs)",
            category = OpportunityCategory.PVT_JOB,
            subCategory = "IT / Software",
            description = "Design, code and test frontend and backend applications using Java, Python, React, Kotlin or Flutter for leading IT companies.",
            descriptionMr = "टीसीएस (TCS), इन्फोसिस (Infosys), विप्रो (Wipro), टेक महिंद्रा व नामांकित आयटी कंपन्यांमध्ये सॉफ्टवेअर आणि ॲप्लिकेशन डेव्हलपर.",
            qualification = "B.E. / B.Tech / BCA / MCA / B.Sc. IT",
            qualificationMr = "इंजिनिअरिंग (CS/IT/ENTC) किंवा BCA / MCA / B.Sc. IT",
            eligibility = "Proficiency in at least one programming language (Java, Python, JS, C++), Data Structures, and basic database SQL.",
            eligibilityMr = "प्रोग्रामिंग भाषेचे ज्ञान, लॉजिकल थिंकिंग आणि प्रोजेक्ट्स.",
            location = "पुणे, मुंबई, बेंगळुरू, नागपूर, नाशिक",
            fees = "वेतन: ₹3.5 लाख ते ₹8.5 लाख प्रति वर्ष",
            officialUrl = "https://www.naukri.com/",
            status = OpportunityStatus.ACTIVE,
            careerPaths = listOf("Junior Developer", "Senior Software Engineer", "Tech Lead", "Software Architect", "Engineering Director"),
            tags = listOf("IT Jobs", "Software", "Pune IT", "B.Tech", "BCA", "Coding")
        ),
        OpportunityItem(
            id = "pvt_mechanical_design",
            title = "Mechanical Design & Production Engineer",
            titleMr = "मेकॅनिकल डिझाईन व उत्पादन इंजिनिअर (ऑटोमोबाईल व मॅन्युफॅक्चरिंग)",
            category = OpportunityCategory.PVT_JOB,
            subCategory = "Engineering & Manufacturing",
            description = "AutoCAD, SolidWorks, Catia modeling, CNC programming and quality assurance in Pune & Aurangabad auto clusters (Tata Motors, Bajaj, Bharat Forge).",
            descriptionMr = "टाटा मोटर्स, बजाज, भारत फोर्ज, महिंद्रा व नामांकित उत्पादन उद्योगांमध्ये डिझाईन व क्वालिटी सुपरवायझर.",
            qualification = "Diploma OR B.E. in Mechanical / Automobile",
            qualificationMr = "मेकॅनिकल किंवा ऑटोमोबाईल डिप्लोमा / बी.ई.",
            eligibility = "Knowledge of CAD software (AutoCAD / SolidWorks / NX) and manufacturing processes.",
            eligibilityMr = "कॅड (CAD) सॉफ्टवेअरचे ज्ञान आणि उत्पादन प्रक्रियेची माहिती.",
            location = "पुणे (चाकण/भोसरी), छत्रपती संभाजीनगर, नाशिक",
            fees = "वेतन: ₹2.8 लाख ते ₹5.5 लाख प्रति वर्ष",
            officialUrl = "https://www.linkedin.com/",
            careerPaths = listOf("Design Trainee", "Production Engineer", "Quality Assurance Manager", "Plant Head"),
            tags = listOf("Mechanical", "AutoCAD", "Chakan MIDC", "Diploma", "B.E.", "Production")
        ),

        // ==================== SCHOLARSHIPS (MahaDBT & Central) ====================
        OpportunityItem(
            id = "sch_mahadbt_shahu",
            title = "Rajarshi Chhatrapati Shahu Maharaj Tuition Fee Scheme (EBC)",
            titleMr = "राजर्षी छत्रपती शाहू महाराज शिक्षण शुल्क शिष्यवृत्ती योजना (EBC सवलत)",
            category = OpportunityCategory.SCHOLARSHIP,
            subCategory = "MahaDBT State Scheme",
            description = "50% tuition and examination fee reimbursement for students belonging to Economically Backward Class (EBC) in Higher & Technical courses.",
            descriptionMr = "इंजिनिअरिंग, मेडिकल, फार्मसी, कृषी आणि सर्व व्यावसायिक पदवी/डिप्लोमा अभ्यासक्रमात ५०% शिक्षण शुल्क आणि परीक्षा फी माफी.",
            qualification = "Admission through Centralized Admission Process (CAP)",
            qualificationMr = "शासनाच्या अधिकृत कॅप (CAP) फेरीतून प्रवेश घेतलेला असावा",
            eligibility = "Annual family income up to ₹8,00,000. Domicile of Maharashtra. Applicable to Open / EWS / General category.",
            eligibilityMr = "कुटुंबाचे वार्षिक उत्पन्न ₹८ लाखांपेक्षा कमी असणे आवश्यक. महाराष्ट्राचा रहिवासी दाखला.",
            vacancies = "अमर्याद पात्र विद्यार्थ्यांना लाभ",
            lastDate = "महाडीबीटी पोर्टलच्या वार्षिक वेळापत्रकानुसार",
            officialUrl = "https://mahadbt.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            syllabus = "आवश्यक कागदपत्रे: १. उत्पन्नाचा दाखला (तहासीलदार), २. अधिवास दाखला (Domicile), ३. CAP अलॉटमेंट लेटर, ४. १० वी व १२ वी गुणपत्रिका, ५. आधार लिंक बँक खाते.",
            careerPaths = listOf("50% Fee Waiver in Engineering", "50% Fee Waiver in Medical", "50% Fee Waiver in Polytechnic", "Zero burden on middle-class families"),
            tags = listOf("MahaDBT", "Scholarship", "EBC", "Fee Waiver", "College Fees")
        ),
        OpportunityItem(
            id = "sch_post_matric_sc_st",
            title = "MahaDBT Post-Matric Scholarship (SC / ST / VJNT / OBC / SBC)",
            titleMr = "महाडीबीटी मॅट्रिकोत्तर शिष्यवृत्ती (SC / ST / VJNT / OBC / SBC समाजकल्याण)",
            category = OpportunityCategory.SCHOLARSHIP,
            subCategory = "Social Justice Department",
            description = "100% Tuition & Exam fee waiver for SC/ST, and up to 100% for VJNT/SBC/OBC categories plus monthly maintenance allowance.",
            descriptionMr = "मागासवर्गीय विद्यार्थ्यांसाठी १००% पर्यंत फी माफी, परीक्षा फी माफी आणि दरमहा निर्वाह भत्ता (Maintenance Allowance).",
            qualification = "Post 10th (11th, 12th, ITI, Diploma, Degree, PG)",
            qualificationMr = "१० वी नंतरचे सर्व शिक्षण (११ वी, १२ वी, ITI, डिप्लोमा, पदवी, पदव्युत्तर)",
            eligibility = "Caste Certificate and Caste Validity Certificate. Income limit: SC/ST up to ₹2.5 Lakh; OBC up to ₹1.5 to ₹8 Lakh.",
            eligibilityMr = "जात प्रमाणपत्र व जात पडताळणी (Caste Validity) अनिवार्य.",
            officialUrl = "https://mahadbt.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            tags = listOf("MahaDBT", "SC Scholarship", "OBC Scholarship", "Samaj Kalyan", "Free Education")
        ),
        OpportunityItem(
            id = "sch_panjabrao_hostel",
            title = "Dr. Panjabrao Deshmukh Hostel Maintenance Allowance Scheme",
            titleMr = "डॉ. पंजाबराव देशमुख वसतिगृह निर्वाह भत्ता योजना",
            category = OpportunityCategory.SCHOLARSHIP,
            subCategory = "Hostel & Living Allowance",
            description = "Monthly allowance for children of registered marginal farmers and registered agricultural laborers residing in private hostels/rented rooms.",
            descriptionMr = "शेतकरी व शेतमजूर पाल्यांना वसतिगृहात राहण्यासाठी दरमहा ₹२,००० ते ₹३,००० (वार्षिक ₹२०,००० ते ₹३०,०००) थेट बँक खात्यात निर्वाह भत्ता.",
            qualification = "Pursuing Professional Higher Education",
            qualificationMr = "व्यावसायिक शिक्षण घेत असलेला विद्यार्थी",
            eligibility = "Child of registered marginal farmer (अल्पभूधारक शेतकरी) or registered construction worker/agricultural laborer.",
            eligibilityMr = "अल्पभूधारक शेतकरी दाखला किंवा नोंदणीकृत मजूर प्रमाणपत्र.",
            officialUrl = "https://mahadbt.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            tags = listOf("Hostel Allowance", "Panjabrao Deshmukh", "MahaDBT", "Farmer Child")
        ),

        // ==================== DEFENCE CAREERS ====================
        OpportunityItem(
            id = "def_nda",
            title = "National Defence Academy (NDA) - Army, Navy, Air Force",
            titleMr = "राष्ट्रीय संरक्षण प्रबोधिनी (NDA - तिन्ही दलात थेट कमिशन्ड ऑफिसर)",
            category = OpportunityCategory.DEFENCE,
            subCategory = "NDA & Officer Entry",
            description = "Premier joint training academy for Indian Armed Forces officers located at Khadakwasla, Pune. Leads to Lieutenant, Flying Officer or Sub-Lieutenant.",
            descriptionMr = "खडकवासला, पुणे येथील जगातील सर्वोत्तम संरक्षण संस्था. १२ वी नंतर थेट भारतीय लष्करात लेफ्टनंट, हवाई दलात फ्लाईंग ऑफिसर किंवा नौदलात सब-लेफ्टनंट म्हणून नियुक्ती.",
            qualification = "12th Standard Pass / Appearing",
            qualificationMr = "१२ वी उत्तीर्ण किंवा १२ वीत शिकत असलेले विद्यार्थी (हवाई दल व नौदलासाठी गणित व भौतिकशास्त्र आवश्यक)",
            eligibility = "Age 16.5 to 19.5 years. Unmarried male and female candidates. Strict medical and physical fitness.",
            eligibilityMr = "किमान वय १६.५ ते कमाल १९.५ वर्षे. अविवाहित मुले व मुली.",
            duration = "3 Years NDA Khadakwasla + 1 Year IMA / AFA / INA",
            vacancies = "४०० पदे (वर्षातून २ वेळा NDA 1 व NDA 2)",
            officialUrl = "https://upsc.gov.in/",
            status = OpportunityStatus.NEW,
            examPattern = "UPSC Written Exam (गणित ३०० गुण + सामान्य क्षमता चाचणी ६०० गुण = एकूण ९०० गुण) + ५ दिवसांची सर्व्हिस सिलेक्शन बोर्ड (SSB) मुलाखत (९०० गुण)",
            syllabus = "गणित (११ वी व १२ वी स्तर), इंग्रजी, भौतिकशास्त्र, रसायनशास्त्र, सामान्य विज्ञान, इतिहास, भूगोल आणि चालू घडामोडी",
            careerPaths = listOf("NDA Cadet (Khadakwasla)", "IMA / Air Force Academy / Naval Academy", "Commissioned Officer (Lieutenant / Flying Officer)", "Colonel / Brigadier / General"),
            tags = listOf("NDA", "Defence", "Army", "Navy", "Air Force", "Khadakwasla", "Officer")
        ),
        OpportunityItem(
            id = "def_agniveer_army",
            title = "Indian Army Agniveer Rally (भारतीय सैन्य अग्निवीर भरती)",
            titleMr = "भारतीय सैन्य अग्निवीर भरती (General Duty, Technical, Clerk, Tradesman)",
            category = OpportunityCategory.DEFENCE,
            subCategory = "Agniveer Scheme",
            description = "4-year military service under Agnipath scheme with opportunities for permanent cadre absorption, Seva Nidhi package of ₹11.71 Lakh.",
            descriptionMr = "अग्निपथ योजनेअंतर्गत भारतीय सैन्यात भरती. ४ वर्षांची सेवा, आकर्षक वेतन, जोखीम भत्ते आणि पूर्ण झाल्यावर ₹११.७१ लाखांचे सेवा निधी पॅकेज.",
            qualification = "10th Pass (GD) / 12th Science (Tech) / 12th Any (Clerk)",
            qualificationMr = "१० वी किमान ४५% गुणांसह (GD) / १२ वी सायन्स PCM (टेक्निकल)",
            eligibility = "Age 17.5 to 21 years. Physical fitness: 1.6 km run in 5.5 minutes, 10 pull-ups, 9 feet ditch jump.",
            eligibilityMr = "वय १७.५ ते २१ वर्षे. १.६ किमी धावणे (५ मि. ३० सेकंद), १० बीम्स/पुलअप्स.",
            duration = "4 Years (with 25% absorbed in Regular Army Cadre)",
            officialUrl = "https://joinindianarmy.nic.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "Common Entrance Exam (CEE Online) + Physical Fitness Test (PFT) + Medical Test",
            careerPaths = listOf("Agniveer Soldier", "Regular Army Permanent Soldier (top 25%)", "State Police & Paramilitary Reservation", "Corporate Security Officer"),
            tags = listOf("Agniveer", "Army", "Indian Army", "Defence", "10th pass", "Fitness")
        ),
        OpportunityItem(
            id = "def_coast_guard",
            title = "Indian Coast Guard (Navik General Duty & Yantrik)",
            titleMr = "भारतीय तटरक्षक दल (Indian Coast Guard - नाविक व यांत्रिक)",
            category = OpportunityCategory.DEFENCE,
            subCategory = "Maritime Defence",
            description = "Protecting India's vast maritime boundary, search and rescue at sea, and coastal security operations.",
            descriptionMr = "भारताच्या सागरी सीमांचे रक्षण, समुद्रातील सुरक्षा आणि सागरी बचाव कार्य. केंद्र सरकारी नोकरीचे सर्व लाभ.",
            qualification = "12th Science (Maths & Physics) / 10th + Diploma for Yantrik",
            qualificationMr = "१२ वी सायन्स (गणित व भौतिकशास्त्र) किंवा १० वी + मेकॅनिकल/इलेक्ट्रिकल डिप्लोमा",
            eligibility = "Age 18 to 22 years. Male candidates.",
            eligibilityMr = "वय १८ ते २२ वर्षे.",
            officialUrl = "https://joinindiancoastguard.cdac.in/",
            status = OpportunityStatus.ACTIVE,
            tags = listOf("Coast Guard", "Navy", "Defence", "12th Science", "Navik")
        ),

        // ==================== COMPETITIVE EXAMS ====================
        OpportunityItem(
            id = "exam_upsc_cse",
            title = "UPSC Civil Services Examination (IAS / IPS / IFS)",
            titleMr = "UPSC नागरी सेवा परीक्षा (IAS, IPS, IFS - केंद्रीय नागरी सेवा)",
            category = OpportunityCategory.COMPETITIVE_EXAM,
            subCategory = "National Exam",
            description = "India's most prestigious competitive exam for Indian Administrative Service, Indian Police Service, and Indian Foreign Service.",
            descriptionMr = "भारतातील सर्वोच्च प्रशासकीय परीक्षा. जिल्हाधिकारी, पोलीस आयुक्त, राजदूत आणि केंद्रीय सचिव पदांसाठी निवड.",
            qualification = "Any Graduation",
            qualificationMr = "कोणत्याही मान्यताप्राप्त शाखेतील पदवीधर",
            eligibility = "Age 21 to 32 years (Relaxation for OBC 3 yrs, SC/ST 5 yrs). Number of attempts: General 6, OBC 9, SC/ST unlimited.",
            eligibilityMr = "किमान वय २१ वर्षे. पदवीच्या शेवटच्या वर्षातील विद्यार्थी अर्ज करू शकतात.",
            officialUrl = "https://upsc.gov.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "Prelims (GS + CSAT) + Mains (9 Papers - 1750 marks) + Personality Test (Interview - 275 marks)",
            syllabus = "भारतीय इतिहास, जगाचा व भारताचा भूगोल, राज्यघटना व शासन, अर्थव्यवस्था, पर्यावरण, आंतरराष्ट्रीय संबंध, नीतीशास्त्र आणि पर्यायी विषय",
            tags = listOf("UPSC", "IAS", "IPS", "Civil Services", "Degree Exam")
        ),
        OpportunityItem(
            id = "exam_mht_cet",
            title = "MHT-CET (Maharashtra Health and Technical Common Entrance Test)",
            titleMr = "MHT-CET (इंजिनिअरिंग, फार्मसी व कृषी पदवी सामाईक प्रवेश परीक्षा)",
            category = OpportunityCategory.COMPETITIVE_EXAM,
            subCategory = "State Entrance Exam",
            description = "State-level gateway test for admission to B.E./B.Tech, B.Pharmacy, Pharm.D, and B.Sc. Agriculture in Maharashtra.",
            descriptionMr = "महाराष्ट्रातील सरकारी व खाजगी महाविद्यालयांमध्ये इंजिनिअरिंग, फार्मसी आणि कृषी पदवी प्रवेशासाठी अनिवार्य परीक्षा.",
            qualification = "12th Science Appearing or Passed",
            qualificationMr = "१२ वी सायन्स (PCM किंवा PCB ग्रुप)",
            eligibility = "Minimum 45% marks in 12th Science.",
            eligibilityMr = "१२ वी विज्ञान शाखेत किमान ४५% गुण (राखीव वर्गासाठी ४०%).",
            duration = "Online Computer Based Test (CBT - ३ तास)",
            officialUrl = "https://cetcell.mahacet.org/",
            status = OpportunityStatus.CLOSING_SOON,
            examPattern = "PCM ग्रुप: गणित (१०० गुण) + भौतिकशास्त्र व रसायनशास्त्र (१०० गुण) = २०० गुण. निगेटिव्ह मार्किंग नाही!",
            syllabus = "महाराष्ट्र राज्य पाठ्यपुस्तक मंडळाच्या ११ वीच्या २०% आणि १२ वीच्या संपूर्ण अभ्यासक्रमावर आधारित",
            tags = listOf("MHT-CET", "Engineering Entrance", "Pharmacy", "CET Cell", "12th Science")
        ),
        OpportunityItem(
            id = "exam_neet_ug",
            title = "NEET-UG (National Eligibility cum Entrance Test)",
            titleMr = "NEET-UG (वैद्यकीय प्रवेश परीक्षा - MBBS / BDS / BAMS / BHMS)",
            category = OpportunityCategory.COMPETITIVE_EXAM,
            subCategory = "Medical Entrance",
            description = "All-India single entrance exam for admission to all medical and dental colleges across India.",
            descriptionMr = "भारतातील सर्व सरकारी व खाजगी वैद्यकीय महाविद्यालयांमध्ये डॉक्टरकीच्या अभ्यासक्रमांसाठीची एकमेव अधिकृत प्रवेश परीक्षा.",
            qualification = "12th Science (PCB)",
            qualificationMr = "१२ वी सायन्स (Physics, Chemistry, Biology)",
            eligibility = "Minimum 17 years of age. Minimum 50% in PCB in 12th standard.",
            eligibilityMr = "किमान वय १७ वर्षे पूर्ण. १२ वी PCB मध्ये ५०% गुण.",
            duration = "Pen & Paper OMR Test (३ तास २० मिनिटे)",
            officialUrl = "https://neet.nta.nic.in/",
            status = OpportunityStatus.ACTIVE,
            examPattern = "१८० प्रश्न सोडवणे (भौतिकशास्त्र ४५, रसायनशास्त्र ४५, जीवशास्त्र ९० प्रश्न) = एकूण ७२० गुण. बरोबर उत्तराला +४, चुकीच्या उत्तराला -१.",
            tags = listOf("NEET", "MBBS Entrance", "Doctor", "Medical", "NTA")
        ),

        // ==================== TRAINING & SKILL DEVELOPMENT ====================
        OpportunityItem(
            id = "trn_mscit",
            title = "MS-CIT & Advanced Digital Office Skills",
            titleMr = "MS-CIT व प्रगत डिजिटल संगणक कौशल्य",
            category = OpportunityCategory.TRAINING,
            subCategory = "Computer Training",
            description = "Maharashtra Knowledge Corporation Limited (MKCL) certified IT literacy course essential for government jobs and office operations.",
            descriptionMr = "महाराष्ट्र शासनाच्या सर्व नोकऱ्यांसाठी अनिवार्य असलेला अधिकृत संगणक साक्षरता कोर्स. एमएस वर्ड, एक्सेल, पॉवरपॉइंट, इंटरनेट आणि एआय टूल्स.",
            qualification = "Open for all students (8th / 10th / 12th)",
            qualificationMr = "सर्व विद्यार्थ्यांसाठी खुला (८ वी / १० वी / १२ वी)",
            eligibility = "Basic literacy. Conducted at authorized MKCL learning centres across every village and city in Maharashtra.",
            eligibilityMr = "राज्यातील कोणत्याही अधिकृत एमकेसीएल केंद्रावर प्रवेश उपलब्ध.",
            duration = "2 Months (२ महिने - १२० तास)",
            fees = "₹4,500 - ₹5,000",
            officialUrl = "https://mscit.mkcl.org/",
            status = OpportunityStatus.ACTIVE,
            tags = listOf("MS-CIT", "MKCL", "Computer Course", "Office Skills", "Govt Mandatory")
        ),
        OpportunityItem(
            id = "trn_tally_gst",
            title = "Tally Prime with GST & e-Filing",
            titleMr = "टॅली प्राईम विथ जीएसटी (Tally Prime + GST & e-Filing)",
            category = OpportunityCategory.TRAINING,
            subCategory = "Finance & Accounts",
            description = "Business accounting, inventory management, Goods and Services Tax (GST) calculation, TDS, and balance sheet preparation.",
            descriptionMr = "व्यापारी हिशेब, जीएसटी रिटर्न भरणे, टीडीएस, पगार पत्रके आणि बॅलन्स शीट तयार करण्याचे प्रात्यक्षिक प्रशिक्षण. त्वरित नोकरी मिळवून देणारा कोर्स.",
            qualification = "10th / 12th / Commerce Students",
            qualificationMr = "१० वी / १२ वी / बी.कॉम व इतर पदवीधर",
            eligibility = "Basic accounting awareness preferred.",
            eligibilityMr = "कोणत्याही शाखेतील विद्यार्थ्यांसाठी उपलब्ध.",
            duration = "2 to 3 Months (२ ते ३ महिने)",
            fees = "₹6,000 - ₹12,000",
            careerPaths = listOf("Accountant in CA Firm", "Billing & GST Executive in Stores", "Accounts Executive in Private Firms", "Independent GST Return Filing"),
            tags = listOf("Tally", "GST", "Accounts", "Finance", "Commerce", "Office Jobs")
        ),
        OpportunityItem(
            id = "trn_electrician_solar",
            title = "Electrician Trade & Solar Rooftop Installation",
            titleMr = "इलेक्ट्रिशियन व सोलर पॅनेल तंत्रज्ञ प्रशिक्षण",
            category = OpportunityCategory.TRAINING,
            subCategory = "Technical Skill",
            description = "Domestic and industrial wiring, motor winding, solar panel installation, inverter maintenance and battery storage.",
            descriptionMr = "घरगुती व औद्योगिक वायरिंग, सोलर रूफटॉप इन्स्टॉलेशन, इन्व्हर्टर दुरुस्ती आणि वीज उपकरणांची देखभाल. पंतप्रधान सूर्यघर योजनेमुळे प्रचंड संधी.",
            qualification = "10th Pass",
            qualificationMr = "१० वी उत्तीर्ण",
            eligibility = "Minimum age 16 years. Free government PMKVY batches also conducted.",
            eligibilityMr = "वय किमान १६ वर्षे.",
            duration = "3 to 6 Months (३ ते ६ महिने)",
            fees = "शासकीय PMKVY अंतर्गत मोफत / खाजगी ₹8,000",
            officialUrl = "https://www.pmkvyofficial.org/",
            status = OpportunityStatus.ACTIVE,
            careerPaths = listOf("Licensed Electrical Contractor", "Solar Technician (PM Surya Ghar)", "Maintenance Electrician in MIDC", "Self-employment Workshop"),
            tags = listOf("Electrician", "Solar", "PMKVY", "Wiring", "Self Employment")
        ),

        // ==================== ADMISSIONS 2026-27 ====================
        OpportunityItem(
            id = "adm_fyjc_11th",
            title = "FYJC 11th Centralized Online Admission 2026-27",
            titleMr = "११ वी ऑनलाईन प्रवेश प्रक्रिया २०२६-२७ (FYJC Centralized Admission)",
            category = OpportunityCategory.ADMISSION,
            subCategory = "Junior College Admission",
            description = "Centralized admission for Arts, Commerce, Science and Bifocal streams across Mumbai, Pune, Nagpur, Nashik and Amravati divisions.",
            descriptionMr = "मुंबई, पुणे, नागपूर, नाशिक, अमरावती महानगर क्षेत्रातील कनिष्ठ महाविद्यालयांमध्ये ११ वी प्रवेशासाठीची अधिकृत राज्यस्तरीय ऑनलाईन प्रणाली.",
            qualification = "10th SSC Pass",
            qualificationMr = "१० वी उत्तीर्ण (राज्य मंडळ / CBSE / ICSE)",
            eligibility = "Passed 10th standard in 2026 or earlier.",
            eligibilityMr = "१० वी उत्तीर्ण विद्यार्थी. भाग १ (नोंदणी) व भाग २ (कॉलेज पसंतीक्रम) भरणे अनिवार्य.",
            lastDate = "१० वी निकालानंतर तातडीने सुरू",
            officialUrl = "https://11thadmission.org.in/",
            status = OpportunityStatus.NEW,
            syllabus = "फेऱ्या: कॅप फेरी १, कॅप फेरी २, कॅप फेरी ३ आणि विशेष फेरी (Special Round). गुणवत्ता यादीनुसार प्रवेश वाटप.",
            tags = listOf("11th Admission", "FYJC", "Online Admission", "Pune 11th", "Mumbai 11th")
        ),
        OpportunityItem(
            id = "adm_polytechnic_cap",
            title = "Maharashtra Post SSC Diploma CAP Rounds 2026-27",
            titleMr = "पॉलिटेक्निक डिप्लोमा ऑनलाईन प्रवेश २०२६-२७ (DTE CAP Rounds)",
            category = OpportunityCategory.ADMISSION,
            subCategory = "Diploma Admission",
            description = "Directorate of Technical Education (DTE) centralized admission for 3-year Engineering and Technology diploma courses.",
            descriptionMr = "तंत्रशिक्षण संचालनालय (DTE) मार्फत राज्यातील सर्व शासकीय व खाजगी पॉलिटेक्निक महाविद्यालयांमध्ये पदविका प्रवेश प्रक्रिया.",
            qualification = "10th Pass with Math & Science",
            qualificationMr = "१० वी गणित व विज्ञानासह किमान ३५% गुणांनी उत्तीर्ण",
            eligibility = "Aggregate minimum 35% in SSC.",
            eligibilityMr = "१० वी मध्ये किमान ३५% गुण.",
            officialUrl = "https://dte.maharashtra.gov.in/",
            status = OpportunityStatus.ACTIVE,
            syllabus = "दस्तऐवज पडताळणी (E-Scrutiny / Physical Scrutiny) → तात्पुरती गुणवत्ता यादी → अंतिम गुणवत्ता यादी → कॅप राऊंड १, २, ३.",
            tags = listOf("Diploma Admission", "DTE CAP", "Polytechnic 2026", "10th Admission")
        ),
        OpportunityItem(
            id = "adm_dvet_iti",
            title = "DVET Maharashtra ITI Online Admission 2026-27",
            titleMr = "महाराष्ट्र आय.टी.आय. ऑनलाईन प्रवेश प्रक्रिया २०२६-२७ (DVET ITI)",
            category = OpportunityCategory.ADMISSION,
            subCategory = "ITI Admission",
            description = "Directorate of Vocational Education and Training centralized portal for admission to over 80 engineering and non-engineering ITI trades.",
            descriptionMr = "राज्यातील सर्व ४१७ शासकीय आणि ५००+ खाजगी औद्योगिक प्रशिक्षण संस्थांमध्ये (ITI) विविध ट्रेड्ससाठी एकाच अर्जावर प्रवेश.",
            qualification = "10th Pass / 8th Pass for select trades",
            qualificationMr = "१० वी उत्तीर्ण (काही ट्रेड्ससाठी ८ वी उत्तीर्ण)",
            eligibility = "Candidate must have passed qualifying examination. Reservation as per Maharashtra Government norms.",
            eligibilityMr = "महाराष्ट्र शासनाच्या नियमांनुसार आरक्षण व जिल्हास्तरावर प्राधान्य.",
            officialUrl = "https://admission.dvet.gov.in/",
            status = OpportunityStatus.NEW,
            tags = listOf("ITI Admission", "DVET", "Trade Admission", "Vocational")
        ),

        // ==================== COLLEGES ====================
        OpportunityItem(
            id = "col_coep",
            title = "COEP Technological University, Pune",
            titleMr = "सीओईपी तंत्रज्ञान विद्यापीठ, पुणे (COEP Tech)",
            category = OpportunityCategory.COLLEGE,
            subCategory = "Engineering College (Govt)",
            description = "One of India's oldest and most prestigious engineering institutions (Est. 1854) offering world-class B.Tech and M.Tech degrees.",
            descriptionMr = "भारतातील सर्वात प्रतिष्ठित आणि जुने सरकारी स्वायत्त अभियांत्रिकी विद्यापीठ (स्थापना १८५४). उत्कृष्ट कॅम्पस प्लेसमेंट आणि दर्जेदार शिक्षण.",
            qualification = "MHT-CET / JEE Main (Merit based)",
            qualificationMr = "MHT-CET / JEE मेन गुणवत्ता यादी",
            eligibility = "Top percentiles in MHT-CET (98+ percentile for CS/IT).",
            eligibilityMr = "MHT-CET मध्ये उच्च गुणवत्ता (CS/IT साठी ९८+ पर्सेंटाईल).",
            location = "शिवाजीनगर, पुणे, महाराष्ट्र",
            fees = "₹85,000 - ₹1,05,000 प्रति वर्ष (MahaDBT सवलत लागू)",
            officialUrl = "https://www.coep.org.in/",
            status = OpportunityStatus.ACTIVE,
            careerPaths = listOf("Avg Placement: ₹11.5 LPA", "Highest Placement: ₹50+ LPA", "Companies: Google, Microsoft, Tata Motors, Bajaj"),
            tags = listOf("COEP", "Pune", "Top College", "Govt College", "Engineering", "B.Tech")
        ),
        OpportunityItem(
            id = "col_grant_medical",
            title = "Grant Government Medical College & Sir J.J. Group of Hospitals, Mumbai",
            titleMr = "ग्रँट शासकीय वैद्यकीय महाविद्यालय व जे.जे. रुग्णालय, मुंबई",
            category = OpportunityCategory.COLLEGE,
            subCategory = "Medical College (Govt)",
            description = "Premier government medical college in Maharashtra offering MBBS, MD, MS and super-specialty medical training with extensive clinical exposure.",
            descriptionMr = "महाराष्ट्रातील सर्वोच्च शासकीय वैद्यकीय महाविद्यालय. प्रचंड रुग्णसंख्या असल्यामुळे वैद्यकीय विद्यार्थ्यांना उत्कृष्ट प्रत्यक्ष वैद्यकीय अनुभव मिळतो.",
            qualification = "NEET-UG Top Rank",
            qualificationMr = "NEET-UG परीक्षेतील सर्वोच्च गुणवत्ता",
            eligibility = "High NEET-UG All-India and State Rank.",
            eligibilityMr = "NEET-UG राज्य गुणवत्ता यादीनुसार प्रवेश.",
            location = "भायखळा, मुंबई, महाराष्ट्र",
            fees = "₹1,20,000 प्रति वर्ष (शासकीय अनुदानित दर)",
            officialUrl = "https://ggmcjjh.com/",
            tags = listOf("Medical College", "MBBS", "Mumbai", "Grant Medical", "Govt Doctor")
        ),
        OpportunityItem(
            id = "col_mpkv_rahuri",
            title = "Mahatma Phule Krishi Vidyapeeth (MPKV), Rahuri",
            titleMr = "महात्मा फुले कृषी विद्यापीठ (MPKV), राहुरी (अहमदनगर / पुणे)",
            category = OpportunityCategory.COLLEGE,
            subCategory = "Agriculture University (Govt)",
            description = "Premier agricultural university governing prestigious colleges including College of Agriculture Pune (Shivajinagar).",
            descriptionMr = "महाराष्ट्रातील आघाडीचे कृषी विद्यापीठ. या अंतर्गत पुणे कृषी महाविद्यालय, धुळे, कोल्हापूर कृषी महाविद्यालये येतात. कृषी संशोधनात अग्रेसर.",
            qualification = "MHT-CET (PCB / PCM) with 12th Science",
            qualificationMr = "१२ वी सायन्स + MHT-CET",
            eligibility = "Centralized admission via MCAER / State CET Cell.",
            eligibilityMr = "राज्य सामाईक प्रवेश परीक्षा कक्षामार्फत प्रवेश.",
            location = "राहुरी, जि. अहिल्यानगर / पुणे कॅम्पस",
            fees = "₹35,000 - ₹50,000 प्रति वर्ष",
            officialUrl = "https://mpkv.ac.in/",
            tags = listOf("MPKV", "Agri University", "Pune Agri College", "Rahuri", "B.Sc Agri")
        ),
        OpportunityItem(
            id = "col_gp_pune",
            title = "Government Polytechnic, Pune",
            titleMr = "शासकीय तंत्रनिकेतन, पुणे (Government Polytechnic Pune)",
            category = OpportunityCategory.COLLEGE,
            subCategory = "Polytechnic (Govt)",
            description = "Premier government polytechnic institute in Maharashtra (Est. 1957) known for top-tier diploma education and campus placements.",
            descriptionMr = "महाराष्ट्रातील प्रथम क्रमांकाचे शासकीय पॉलिटेक्निक. कॉम्प्युटर, मेकॅनिकल, सिव्हिल, इलेक्ट्रॉनिक्स व इलेक्ट्रिकल शाखांमध्ये अव्वल निकाल.",
            qualification = "10th SSC Pass",
            qualificationMr = "१० वी किमान ३५% गुणांसह उत्तीर्ण",
            eligibility = "Admission via DTE CAP rounds based on SSC marks.",
            eligibilityMr = "१० वी गुणांच्या आधारे तंत्रशिक्षण संचालनालयामार्फत थेट प्रवेश.",
            location = "विद्यापीठ रस्ता, शिवाजीनगर, पुणे",
            fees = "₹7,500 - ₹12,000 प्रति वर्ष (अत्यल्प शासकीय फी)",
            officialUrl = "https://www.gppune.ac.in/",
            tags = listOf("Govt Polytechnic", "GP Pune", "Diploma", "Polytechnic College")
        ),

        // ==================== BUSINESS & SELF EMPLOYMENT ====================
        OpportunityItem(
            id = "biz_agri_dairy",
            title = "Modern Dairy Farming & Milk Processing Unit",
            titleMr = "आधुनिक दुग्धव्यवसाय व प्रक्रिया उद्योग (Dairy & Milk Processing)",
            category = OpportunityCategory.BUSINESS,
            subCategory = "Agri-Business",
            description = "High-yield dairy cattle management, automated milking, fodder preservation (silage), and value-added milk products (paneer, ghee, curd).",
            descriptionMr = "दुग्धव्यवसाय, गोकुळ/अमुल पुरवठादार किंवा स्वतःचा ब्रँड तयार करून पनीर, तूप, खवा विक्री. नाबार्ड (NABARD) व अण्णासाहेब पाटील महामंडळाकडून कर्ज व सबसिडी उपलब्ध.",
            qualification = "Any qualification (Training recommended)",
            qualificationMr = "१० वी / १२ वी किंवा कोणतीही पदवी (कृषी किंवा डेअरी प्रशिक्षण फायदेशीर)",
            eligibility = "Land for cattle shed and green fodder cultivation.",
            eligibilityMr = "जनावरांचा गोठा व चारा लागवडीसाठी जागा.",
            officialUrl = "https://www.nabard.org/",
            status = OpportunityStatus.ACTIVE,
            careerPaths = listOf("Daily cash flow business", "NABARD 25% to 33% capital subsidy", "Annasaheb Patil Mahamandal interest-free loan up to ₹15 Lakh"),
            tags = listOf("Business", "Dairy", "Self Employment", "Loan", "Agri Business", "NABARD")
        ),
        OpportunityItem(
            id = "biz_digital_services",
            title = "Aaple Sarkar Seva Kendra & CSC Digital Citizen Services",
            titleMr = "आपले सरकार सेवा केंद्र व सीएससी डिजिटल सेवा (CSC Center)",
            category = OpportunityCategory.BUSINESS,
            subCategory = "Service Business",
            description = "Providing citizen services like 7/12 extracts, caste certificates, income certificates, PAN card, Aadhaar updates, and online forms.",
            descriptionMr = "गावात किंवा शहरात आपले सरकार सेवा केंद्र सुरू करून नागरिकांना दाखले, शासकीय योजनांचे फॉर्म, पॅन कार्ड, आणि ऑनलाईन अर्ज भरून देणे.",
            qualification = "10th / 12th Pass with MS-CIT",
            qualificationMr = "१० वी / १२ वी उत्तीर्ण + MS-CIT संगणक प्रमाणपत्र",
            eligibility = "Computer setup with printer, scanner, and internet connectivity.",
            eligibilityMr = "संगणक, प्रिंटर, स्कॅनर आणि इंटरनेट जोडणी.",
            officialUrl = "https://aaplesarkar.mahaonline.gov.in/",
            careerPaths = listOf("Monthly earning ₹25,000 - ₹75,000", "Zero inventory risk", "Direct government citizen service franchise"),
            tags = listOf("CSC", "Aaple Sarkar", "Digital Seva", "Computer Center", "Self Employment")
        )
    ) + CoursesDataset.getCourses() + JobsDataset.getJobs() + CollegesAndAdmissionsDataset.getItems() + ExamsDefenceSkillsDataset.getItems()

    fun getCareerRoadmap(quiz: CareerQuizState): CareerRoadmapResult {
        val edu = quiz.currentEducation.lowercase()
        val stream = quiz.streamInterest.lowercase()
        val jobPref = quiz.jobPreference.lowercase()

        return when {
            edu.contains("10") || edu.contains("ssc") -> {
                when {
                    stream.contains("tech") || stream.contains("poly") || stream.contains("diploma") -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१० वी नंतर पॉलिटेक्निक डिप्लोमा मार्ग (Polytechnic Engineering)",
                            primaryHeadingEn = "Diploma in Engineering Pathway After 10th",
                            recommendedPath = listOf(
                                "१० वी उत्तीर्ण (SSC)",
                                "३ वर्षे पॉलिटेक्निक डिप्लोमा (कॉम्प्युटर / मेकॅनिकल / सिव्हील)",
                                "थेट द्वितीय वर्ष बी.ई./बी.टेक. (DSE) किंवा कनिष्ठ अभियंता नोकरी",
                                "शासकीय जलसंपदा/पीडब्ल्यूडी जे.ई. किंवा बहुराष्ट्रीय कंपनीत अभियंता"
                            ),
                            recommendedCourses = listOf("Diploma in Computer Engg", "Diploma in Mechanical Engg", "Diploma in Electrical Engg"),
                            recommendedColleges = listOf("Govt Polytechnic Pune", "Govt Polytechnic Mumbai", "C.W.I.T Pune"),
                            targetExams = listOf("DTE CAP Merit Rounds", "SSC JE (Junior Engineer)", "RRB JE", "MahaGenco / MahaTransco AE"),
                            targetJobs = listOf("Junior Engineer (PWD / WRD)", "MSEDCL Technician", "AutoCAD Design Engineer"),
                            targetScholarships = listOf("MahaDBT Rajarshi Shahu Maharaj EBC", "Social Justice Post-Matric Scholarship"),
                            adviceMr = "पॉलिटेक्निक डिप्लोमा हा थेट प्रात्यक्षिक ज्ञानाचा मार्ग आहे. ३ वर्षांनंतर तुम्हाला पदवीच्या थेट दुसऱ्या वर्षात प्रवेश मिळतो, ज्यामुळे १२ वी न करताही इंजिनिअर होता येते."
                        )
                    }
                    stream.contains("iti") || stream.contains("trade") -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१० वी नंतर आय.टी.आय. (ITI) व थेट रोजगाराचा मार्ग",
                            primaryHeadingEn = "ITI Craft Trades & Fast Track Job Pathway",
                            recommendedPath = listOf(
                                "१० वी उत्तीर्ण",
                                "१ ते २ वर्षे ITI ट्रेड (इलेक्ट्रिशियन / फिटर / वेल्डर)",
                                "१ वर्ष कारखान्यात किंवा रेल्वेत शिकाऊ उमेदवारी (Apprenticeship)",
                                "रेल्वे, महावितरण किंवा स्वतःचा वर्कशॉप / व्यवसाय"
                            ),
                            recommendedCourses = listOf("ITI Electrician", "ITI Fitter", "ITI Diesel Mechanic", "ITI Wireman"),
                            recommendedColleges = listOf("Govt ITI Aundh Pune", "Govt ITI Thane", "Govt ITI Nagpur"),
                            targetExams = listOf("RRB ALP & Technician", "Mahavitaran Lineman Bharti", "Ordnance Factory Trade Test"),
                            targetJobs = listOf("Railway Technician", "Mahavitaran Lineman", "Industrial Electrician", "Automobile Workshop Owner"),
                            targetScholarships = listOf("DVET Stipend Scheme", "MahaDBT Post-Matric Scholarship"),
                            adviceMr = "कमी कालावधीत आणि अल्प खर्चात स्वतःच्या पायावर उभे राहण्यासाठी ITI हा सर्वोत्तम पर्याय आहे. अप्रेंटिसशिप पूर्ण केल्यास रेल्वे व सरकारी उपक्रमांमध्ये प्राधान्य मिळते."
                        )
                    }
                    else -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१० वी नंतर ११ वी - १२ वी (कनिष्ठ महाविद्यालयीन शाखा)",
                            primaryHeadingEn = "Junior College (11th-12th) Foundation Pathway",
                            recommendedPath = listOf(
                                "१० वी उत्तीर्ण",
                                "११ वी - १२ वी (कला / वाणिज्य / विज्ञान / कृषी शाखा)",
                                "व्यावसायिक प्रवेश परीक्षा (MHT-CET / NEET / JEE / Law CET)",
                                "पदवी अभ्यासक्रम (Degree) व उच्च करिअर"
                            ),
                            recommendedCourses = listOf("11th-12th Science (PCM/PCB)", "11th-12th Commerce", "11th-12th Arts", "11th-12th Agriculture"),
                            recommendedColleges = listOf("Fergusson College Pune", "Sydenham College Mumbai", "Ruparel College Mumbai"),
                            targetExams = listOf("MHT-CET 2026", "NEET-UG", "JEE Main", "NDA 1 & 2"),
                            targetJobs = listOf("NDA Defence Officer", "Bank PO", "MPSC Administrative Officer", "Software Engineer"),
                            targetScholarships = listOf("MahaDBT Rajarshi Shahu Maharaj Scholarship", "Dr. Panjabrao Deshmukh Hostel Scheme"),
                            adviceMr = "१२ वी केल्यामुळे तुमच्यासाठी डॉक्टर, इंजिनिअर, चार्टर्ड अकाउंटंट, वकील, प्रशासकीय अधिकारी आणि कृषी तज्ज्ञ बनण्याचे सर्व मार्ग खुले राहतात."
                        )
                    }
                }
            }
            edu.contains("12") || edu.contains("hsc") -> {
                when {
                    stream.contains("agri") -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१२ वी नंतर कृषी शिक्षण व शासकीय अधिकारी मार्ग",
                            primaryHeadingEn = "Agricultural Degree & Agro-Officer Pathway",
                            recommendedPath = listOf(
                                "१२ वी सायन्स / कृषी उत्तीर्ण",
                                "MHT-CET कृषी प्रवेश परीक्षा",
                                "४ वर्षे बी.एस्सी. कृषी (B.Sc. Agriculture)",
                                "MPSC कृषी सेवा परीक्षा किंवा कृषी क्षेत्रात व्यवसाय"
                            ),
                            recommendedCourses = listOf("B.Sc. Agriculture", "B.Tech Food Technology", "B.Sc. Horticulture"),
                            recommendedColleges = listOf("College of Agriculture Pune (MPKV)", "PKV Akola", "VNMKV Parbhani"),
                            targetExams = listOf("MHT-CET (PCB/PCM)", "MPSC Maharashtra Agri Services", "IBPS AFO (Agriculture Field Officer)"),
                            targetJobs = listOf("Taluka Agriculture Officer (वर्ग २)", "Bank Agriculture Field Officer", "Fertilizer / Seed MNC Executive"),
                            targetScholarships = listOf("MahaDBT Agriculture Fee Scheme", "Panjabrao Deshmukh Hostel Allowance"),
                            adviceMr = "महाराष्ट्रात कृषी पदवीधरांसाठी IBPS AFO आणि MPSC कृषी सेवेत विशेष राखीव पदे असतात. शेतकरी पाल्यांना प्रवेशात अतिरिक्त १२ गुण मिळतात."
                        )
                    }
                    stream.contains("med") || stream.contains("bio") -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१२ वी नंतर वैद्यकीय व आरोग्य सेवा मार्ग (Medical & Health)",
                            primaryHeadingEn = "Medical & Healthcare Professional Pathway",
                            recommendedPath = listOf(
                                "१२ वी सायन्स (PCB)",
                                "NEET-UG राष्ट्रीय परीक्षा",
                                "MBBS / BAMS / B.Sc. Nursing / B.Pharm",
                                "हॉस्पिटल इंटर्नशिप व डॉक्टर / आरोग्य तज्ज्ञ म्हणून प्रॅक्टिस"
                            ),
                            recommendedCourses = listOf("MBBS", "BAMS (Ayurveda)", "B.Sc. Nursing", "B.Pharmacy", "B.Sc. MLT"),
                            recommendedColleges = listOf("Grant Govt Medical College Mumbai", "BJMC Pune", "GMC Nagpur", "Govt College of Pharmacy Karad"),
                            targetExams = listOf("NEET-UG", "MH-B.Sc. Nursing CET", "MHT-CET Pharmacy"),
                            targetJobs = listOf("Medical Officer (Govt Hospital)", "Registered Pharmacist", "Staff Nurse in AIIMS", "Private Clinic Owner"),
                            targetScholarships = listOf("MahaDBT Medical Fee Reimbursement", "Samaj Kalyan Medical Scholarship"),
                            adviceMr = "NEET च्या गुणांनुसार MBBS, BAMS व्यतिरिक्त फिजिओथेरपी (BPT) आणि B.Sc. नर्सिंगमध्येही देश-विदेशात अत्यंत सन्मानजनक रोजगाराच्या संधी आहेत."
                        )
                    }
                    else -> {
                        CareerRoadmapResult(
                            primaryHeadingMr = "१२ वी नंतर तंत्रज्ञान, व्यवस्थापन व स्पर्धा परीक्षा मार्ग",
                            primaryHeadingEn = "Engineering, Management & Civil Services Pathway",
                            recommendedPath = listOf(
                                "१२ वी उत्तीर्ण (Science / Commerce / Arts)",
                                "पदवी अभ्यासक्रम (B.Tech / B.Com / B.A. / BCA / BBA / LLB)",
                                "अभ्यासक्रमासोबत स्पर्धा परीक्षा (MPSC / UPSC / Banking) तयारी",
                                "प्रथम श्रेणी अधिकारी किंवा कॉर्पोरेट लीडर"
                            ),
                            recommendedCourses = listOf("B.E. Computer / AI", "B.Com + CA", "B.A. LL.B. (5 Years Law)", "BCA / MCA"),
                            recommendedColleges = listOf("COEP Tech Pune", "VJTI Mumbai", "ILS Law College Pune", "BMCC Pune"),
                            targetExams = listOf("MHT-CET", "UPSC Civil Services", "MPSC Combined Exam", "IBPS PO", "MAH-LL.B. CET"),
                            targetJobs = listOf("Software Engineer", "MPSC Deputy Collector / PSI", "Bank PO", "High Court Advocate"),
                            targetScholarships = listOf("MahaDBT EBC 50% Fee Waiver", "Central Sector Merit Scholarship"),
                            adviceMr = "पदवीच्या पहिल्या वर्षापासूनच अभ्यासाचे नियोजन करा. तंत्रज्ञान किंवा व्यवस्थापनातील पदवी सोबत शासकीय स्पर्धा परीक्षांची तयारी तुम्हाला दुहेरी सुरक्षितता देते."
                        )
                    }
                }
            }
            else -> {
                // Graduate / Others
                CareerRoadmapResult(
                    primaryHeadingMr = "पदवीनंतर शासकीय नोकरी, करिअर व उच्च शिक्षणाचा मार्ग",
                    primaryHeadingEn = "Graduate Career Advancement & Recruitment Pathway",
                    recommendedPath = listOf(
                        "कोणत्याही शाखेतील पदवी उत्तीर्ण",
                        "ध्येय निश्चिती: स्पर्धा परीक्षा (MPSC/UPSC/Banking) किंवा व्यावसायिक नोकरी",
                        "सखोल अभ्यास, टेस्ट सिरीज व मुलाखत तयारी",
                        "राजपत्रित अधिकारी, बँक अधिकारी किंवा उच्च व्यवस्थापन"
                    ),
                    recommendedCourses = listOf("M.Tech / M.E.", "MBA (Finance/Marketing)", "M.A. / M.Sc.", "3-Year LL.B. Law"),
                    recommendedColleges = listOf("IIM Nagpur", "PUMBA Pune", "Symbiosis Institute", "Government Law College Mumbai"),
                    targetExams = listOf("MPSC Rajyaseva", "UPSC CSE", "MPSC Combine (PSI/STI)", "IBPS PO / Clerk", "SSC CGL"),
                    targetJobs = listOf("Deputy Collector / Tahsildar", "Police Sub-Inspector (PSI)", "Bank Branch Manager", "Income Tax Inspector"),
                    targetScholarships = listOf("MahaDBT Post-Graduate Fee Scheme", "BARTI / SARTHI / MAHAJYOTI Competitive Exam Stipend"),
                    adviceMr = "महाराष्ट्रातील पदवीधरांसाठी बार्टी (BARTI), सारथी (SARTHI) आणि महाज्योती (MAHAJYOTI) मार्फत स्पर्धा परीक्षांसाठी दरमहा ₹१०,००० ते ₹१३,००० विद्यावेतन दिले जाते. याचा अवश्य लाभ घ्या."
                )
            }
        }
    }
}
