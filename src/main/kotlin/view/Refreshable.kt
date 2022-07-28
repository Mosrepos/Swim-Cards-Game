package view

interface Refreshable {

    /**
     *
     *
     */
    fun refreshAfterStartGame() {}

    /**
     *
     *
     */

    fun refreshAfterEndGame() {}

    /**
     *
     *
     */

    fun refreshAfterSwap() {}

    /**
     *
     *
     */

    fun refreshAfterPlayerChange() {}
}