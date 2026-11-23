package com.waqarinstitute.app.teacher

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class TeacherRoute(val route: String) {
    data object Dashboard : TeacherRoute("teacher_dashboard")
    data object CheckIn : TeacherRoute("teacher_checkin")
    data object ExamUpload : TeacherRoute("teacher_exam_upload")
    data object Proctoring : TeacherRoute("teacher_proctoring")
    data object Analytics : TeacherRoute("teacher_analytics")
    data object Attendance : TeacherRoute("teacher_attendance")
    data object Exercises : TeacherRoute("teacher_exercises")
    data object Messages : TeacherRoute("teacher_messages")
}

@Composable
fun TeacherPortal() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = TeacherRoute.Dashboard.route) {
        composable(TeacherRoute.Dashboard.route) { TeacherDashboardScreen(nav) }
        composable(TeacherRoute.CheckIn.route) { TeacherCheckInScreen(nav) }
        composable(TeacherRoute.ExamUpload.route) { TeacherExamUploadScreen(nav) }
        composable(TeacherRoute.Proctoring.route) { TeacherProctoringScreen(nav) }
        composable(TeacherRoute.Analytics.route) { TeacherAnalyticsScreen(nav) }
        composable(TeacherRoute.Attendance.route) { TeacherAttendanceScreen(nav) }
        composable(TeacherRoute.Exercises.route) { TeacherExercisesScreen(nav) }
        composable(TeacherRoute.Messages.route) { TeacherMessagesScreen(nav) }
    }
}