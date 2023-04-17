package com.orafaelsc.composeplayground.navigation


object AuthGraph{
    const val ROOT = "auth_graph"
    const val TO_LOGIN = "login"
    const val TO_SIGN_UP = "sign_up"
    const val TO_FORGOT_PASSWORD = "forgot_password"
}

object DetailsGraph {
    const val ROOT = "details_graph"
    const val TO_HELP= "help"
    const val TO_FAQ = "faq"
    const val TO_DISCLAIMER = "disclaimer"
}

object HomeGraph {
    const val ROOT = "home_graph"
    const val TO_HOME = "home"
    const val TO_PROFILE = "profile"
    const val TO_SETTINGS = "settings"
}

object RootGraph {
    const val ROOT = "root_graph"
}

object AppGraph {
    val auth = AuthGraph
    val details = DetailsGraph
    val home = HomeGraph
    val initial = RootGraph
}