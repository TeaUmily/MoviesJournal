package hr.ferit.tumiljanovic.moviesjournal.base.base_recycler.view_holders.movie_rating_stars

class RatingStarsHolderData(var averageScore: Float, var numberOfVotes: Int) {


    fun getNumberOfVotesAsString(): String{
        return numberOfVotes.toString() + " VOTES"
    }

}