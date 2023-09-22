package top.umair.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import top.umair.jetweatherforecast.screens.main.MainScreen
import top.umair.jetweatherforecast.screens.WeatherSplashScreen
import top.umair.jetweatherforecast.screens.about.AboutScreen
import top.umair.jetweatherforecast.screens.favorites.FavoriteScreen
import top.umair.jetweatherforecast.screens.main.MainViewModel
import top.umair.jetweatherforecast.screens.search.SearchScreen
import top.umair.jetweatherforecast.screens.settings.Settings

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name ){
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController)
        }

        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}",
        arguments = listOf(
            navArgument(name = "city"){
                type = NavType.StringType
            }
        )
        ){navBack->
            navBack.arguments?.getString("city").let {city->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController,mainViewModel,city=city,
                )
            }

        }
        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController)
        }
        composable(WeatherScreens.AboutScreen.name){
            AboutScreen(navController)
        }
        composable(WeatherScreens.FavoriteScreen.name){
            FavoriteScreen(navController)
        }
        composable(WeatherScreens.SettingsScreen.name){
            Settings(navController)
        }
    }


}