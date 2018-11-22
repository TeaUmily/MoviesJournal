package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_title_and_runtime

class TitleAndRuntimeHolderData(var title: String?, var runtime: Int?) {

    fun getRuntimeAsString(): String {
        var hours = runtime?.div(60)
        var minutes = runtime?.rem(60)
        return hours.toString() + "h " + minutes.toString() + "min"
    }
}