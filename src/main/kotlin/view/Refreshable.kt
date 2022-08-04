package view

/**
 * [Refreshable] is the interface that sets the refresh functions
 */
interface Refreshable {

    /**
     * refreshes the game after it starts
     */
    fun refreshAfterStartGame() {}

    /**
     * refreshes the game after it ends
     */
    fun refreshAfterEndGame() {}

    /**
     * refreshes the game after a swap is done
     */
    fun refreshAfterSwap() {}

    /**
     * refreshes the game after a player changes
     */
    fun refreshAfterPlayerChange() {}
}