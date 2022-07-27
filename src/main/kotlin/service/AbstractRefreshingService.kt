package service

import javax.security.auth.Refreshable

/**
 * class that implements the functionality for the abstract refreshing service
 */
class AbstractRefreshingService(rootService: PlayerService) {

    /**
     *
     *
     */
    public fun addRefreshable(newRefreshable: Refreshable): Unit {

    }

    /**
     *
     *
     */
    public fun onAllRefreshables(method: Refreshable.() -> Unit): Unit {

    }
}