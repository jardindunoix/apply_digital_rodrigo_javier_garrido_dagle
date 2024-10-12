package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.navigationimport androidx.compose.runtime.Composableimport androidx.compose.ui.Modifierimport androidx.navigation.NavTypeimport androidx.navigation.compose.NavHostimport androidx.navigation.compose.composableimport androidx.navigation.compose.rememberNavControllerimport androidx.navigation.navArgumentimport cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.MainViewModelimport cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model.Hitimport cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens.DetailScreenimport cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens.MainListScreen@Composablefun AppNavigation(    viewModel: MainViewModel, hits: List<Hit>) {    val navController = rememberNavController()    NavHost(        navController = navController,        startDestination = AppScreens.MainListScreen.route    ) {        composable(AppScreens.MainListScreen.route) {            MainListScreen(                navController, viewModel,                Modifier, hits            )        }        composable(            AppScreens.DetailScreen.route,            arguments = listOf(navArgument("url") {                type = NavType.StringType            })        ) {            DetailScreen(                navController = navController,                viewModel = viewModel,                args = it.arguments?.getString("url")            )        }    }}