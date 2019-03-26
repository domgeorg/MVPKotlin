package gr.mobile.mvp.kotlin.common

class Definitions {

    private constructor()

    companion object {
        //Permission Requests
        const val REQUEST_RUNTIME_LOCATION = 1

        //Fragment backstack values
        const val BACKSTACK_GLOBAL = "backstack_global"

        const val DOMAIN = "https://www.ant1.com.cy/"

        const val URL_LEAD = DOMAIN + "sys/MobileApp/ArticleLeads"
        const val URL_CATEGORIES = DOMAIN + "sys/MobileApp/Categories";

        const val CLIENT_TIMEOUT_IN_SECONDS: Long = 120

        const val ARTICLE_DETAILS_DATE = "dd-MM-yyyy HH:mm"
    }
}