package com.waqarinstitute.app.parent

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class ParentRoute(val route: String) {
    data object Dashboard : ParentRoute("parent_dashboard")
    data object GateAlerts : ParentRoute("parent_gate")
    data object ExamResults : ParentRoute("parent_exam_results")
    data object Receipts : ParentRoute("parent_receipts")
    data object Chat : ParentRoute("parent_chat")
    data object Ptm : ParentRoute("parent_ptm")
    data object Consent : ParentRoute("parent_consent")
}

@Composable
fun ParentPortal() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = ParentRoute.Dashboard.route) {
        composable(ParentRoute.Dashboard.route) { ParentDashboardScreen(nav) }
        composable(ParentRoute.GateAlerts.route) { ParentGateAlertsScreen(nav) }
        composable(ParentRoute.ExamResults.route) { ParentExamResultsScreen(nav) }
        composable(ParentRoute.Receipts.route) { ParentReceiptsScreen(nav) }
        composable(ParentRoute.Chat.route) { ParentChatScreen(nav) }
        composable(ParentRoute.Ptm.route) { ParentPtmScreen(nav) }
        composable(ParentRoute.Consent.route) { ParentConsentScreen(nav) }
    }
}