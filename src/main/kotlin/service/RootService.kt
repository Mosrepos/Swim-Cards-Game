package service
import entity.SwimApp

/**
 * this class connects the entity layer with the service layer
 * [RootService] knows the [swimApp] , the [PlayerService] and the [swimService]
 *
 * @param [swimApp] is the data class for the game
 * @param [swimService] is the service that creates or starts the game
 * @param [PlayerService] is the service that handles the players actions
 *
 */
class RootService(val swimApp: SwimApp, val swimService: SwimService, val PlayerService: PlayerService)