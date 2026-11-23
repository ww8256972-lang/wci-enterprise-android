package com.waqarinstitute.app.student

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class StudentRoute(val route: String) {
    data object Dashboard : StudentRoute("student_dashboard")
    data object ExamArena : StudentRoute("student_exam_arena")
    data object Results : StudentRoute("student_results")
    data object CodingSandbox : StudentRoute("student_coding")
    data object TallySimulator : StudentRoute("student_tally")
    data object AiTutor : StudentRoute("student_aitutor")
    data object QrId : StudentRoute("student_qrid")
    data object Profile : StudentRoute("student_profile")
}

@Composable
fun StudentPortal() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = StudentRoute.Dashboard.route) {
        composable(StudentRoute.Dashboard.route) { StudentDashboardScreen(nav) }
        composable(StudentRoute.ExamArena.route) { StudentExamArenaScreen(nav) }
        composable(StudentRoute.Results.route) { StudentResultsScreen(nav) }
        composable(StudentRoute.CodingSandbox.route) { StudentCodingSandboxScreen(nav) }
        composable(StudentRoute.TallySimulator.route) { StudentTallySimulatorScreen(nav) }
        composable(StudentRoute.AiTutor.route) { StudentAiTutorScreen(nav) }
        composable(StudentRoute.QrId.route) { StudentQrIdScreen(nav) }
        composable(StudentRoute.Profile.route) { StudentProfileScreen(nav) }
    }
}