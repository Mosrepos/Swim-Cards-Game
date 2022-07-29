package serviceTest

import view.Refreshable

/**
 * [Refreshable] implementation that refreshes nothing, but remembers
 * if a refresh method has been called (since last [reset])
 */
class RefreshablesTest : Refreshable {

    var refreshAfterStartGameCalled: Boolean = false
        private set

    var refreshAfterEndGameCalled: Boolean = false
        private set

    var refreshAfterSwapCalled: Boolean = false
        private set

    var refreshAfterPlayerChangeCalled: Boolean = false
        private set


    /**
     * resets all *Called properties to false
     */
    fun reset() {
        refreshAfterStartGameCalled = false
        refreshAfterEndGameCalled = false
        refreshAfterSwapCalled = false
        refreshAfterPlayerChangeCalled = false
    }


    /**
     *
     * overrides the properties to true
     */
    override fun refreshAfterStartGame() {
        refreshAfterStartGameCalled = true
    }

    override fun refreshAfterEndGame() {
        refreshAfterEndGameCalled = true
    }

    override fun refreshAfterSwap() {
        refreshAfterSwapCalled = true
    }

    override fun refreshAfterPlayerChange() {
        refreshAfterPlayerChangeCalled = true
    }
}