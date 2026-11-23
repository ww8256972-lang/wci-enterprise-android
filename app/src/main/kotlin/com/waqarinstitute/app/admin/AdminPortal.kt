package com.waqarinstitute.app.admin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class AdminRoute(val route: String) {
    data object Dashboard : AdminRoute("admin_dashboard")
    data object Students : AdminRoute("admin_students")
    data object Courses : AdminRoute("admin_courses")
    data object Fees : AdminRoute("admin_fees")
    data object Faculty : AdminRoute("admin_faculty")
    data object Attendance : AdminRoute("admin_attendance")
    data object Exams : AdminRoute("admin_exams")
    data object Certificates : AdminRoute("admin_certificates")
    data object Inventory : AdminRoute("admin_inventory")
    data object Library : AdminRoute("admin_library")
    data object Security : AdminRoute("admin_security")
    data object Automation : AdminRoute("admin_automation")
}

@Composable
fun AdminPortal() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = AdminRoute.Dashboard.route) {
        composable(AdminRoute.Dashboard.route) { AdminDashboardScreen(nav) }
        composable(AdminRoute.Students.route) { AdminStudentsScreen(nav) }
        composable(AdminRoute.Courses.route) { AdminCoursesScreen(nav) }
        composable(AdminRoute.Fees.route) { AdminFeesScreen(nav) }
        composable(AdminRoute.Faculty.route) { AdminFacultyScreen(nav) }
        composable(AdminRoute.Attendance.route) { AdminAttendanceScreen(nav) }
        composable(AdminRoute.Exams.route) { AdminExamsScreen(nav) }
        composable(AdminRoute.Certificates.route) { AdminCertificatesScreen(nav) }
        composable(AdminRoute.Inventory.route) { AdminInventoryScreen(nav) }
        composable(AdminRoute.Library.route) { AdminLibraryScreen(nav) }
        composable(AdminRoute.Security.route) { AdminSecurityScreen(nav) }
        composable(AdminRoute.Automation.route) { AdminAutomationScreen(nav) }
    }
}