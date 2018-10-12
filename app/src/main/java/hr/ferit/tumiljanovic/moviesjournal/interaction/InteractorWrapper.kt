package hr.ferit.tumiljanovic.moviesjournal.interaction

class InteractorWrapper {

    private var data: Any? = null

    private var type: String = ""

    constructor(data: Any){
        this.data = data
    }

    constructor(data: Any, type: String) {
        this.data = data
        this.type = type
    }

}