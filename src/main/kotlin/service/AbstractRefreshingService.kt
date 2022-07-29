package service

import view.Refreshable

/**
 * class that implements the functionality for the abstract refreshing service
 */
open class AbstractRefreshingService {

    private val refreshables = mutableListOf<Refreshable>()

    /**
     * adds a [Refreshable] to the list that gets called
     * whenever [onAllRefreshables] is used.
     */
    fun addRefreshable(newRefreshable: Refreshable) {
        refreshables += newRefreshable
    }

    /**
     * Executes the passed method (usually a lambda) on all
     * [Refreshable]s registered with the service class that
     * extends this [AbstractRefreshingService]
     */
    fun onAllRefreshables(method: Refreshable.() -> Unit) =
        refreshables.forEach { it.method() }

}