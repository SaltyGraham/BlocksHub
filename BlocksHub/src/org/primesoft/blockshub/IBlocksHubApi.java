/*
 * BlocksHub a library plugin providing easy access to block loggers 
 * and block access controllers.
 * Copyright (c) 2013, SBPrime <https://github.com/SBPrime/>
 * Copyright (c) BlocksHub contributors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted free of charge provided that the following 
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution,
 * 3. Redistributions of source code, with or without modification, in any form 
 *    other then free of charge is not allowed,
 * 4. Redistributions in binary form in any form other then free of charge is 
 *    not allowed.
 * 5. Any derived work based on or containing parts of this software must reproduce 
 *    the above copyright notice, this list of conditions and the following 
 *    disclaimer in the documentation and/or other materials provided with the 
 *    derived work.
 * 6. The original author of the software is allowed to change the license 
 *    terms or the entire license of the software as he sees fit.
 * 7. The original author of the software is allowed to sublicense the software 
 *    or its parts using any license terms he sees fit.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.primesoft.blockshub;

import java.util.UUID;
import org.primesoft.blockshub.api.IAccessController;
import org.primesoft.blockshub.api.IBlockLogger;
import org.bukkit.Location;
import org.bukkit.World;
import org.primesoft.blockshub.platform.api.IPlayer;

/**
 *
 * @author SBPrime
 */
public interface IBlocksHubApi {
    /**
     * Get the current version of BlocksHub API
     *
     * @return
     */
    double getVersion();
    
    
    /**
     * Is the api initialized
     * @return 
     */
    boolean isInitialized();
        
    /**
     * Register blocks logger class
     * @param blocksLogger
     * @return 
     */
    boolean registerBlocksLogger(IBlockLogger blocksLogger);
    
    
    /**
     * Register blocks access controller
     * @param accessController
     * @return 
     */
    boolean registerAccessController(IAccessController accessController);
    
    /**
     * Remove blocks logger class
     * @param blocksLogger
     * @return 
     */
    boolean removeBlocksLogger(IBlockLogger blocksLogger);
    
    
    /**
     * Remove blocks access controller
     * @param accessController
     * @return 
     */
    boolean removeAccessController(IAccessController accessController);
    
    
    /**
     * List all registered loggers
     * @return 
     */
    IBlockLogger[] getRegisteredLoggers();
    
    /**
     * List all registered access controllers
     * @return 
     */
    IAccessController[] getRegisteredAccessControllers();

    /**
     * Log block using all the enabled block loggers
     * @param location
     * @param player
     * @param world
     * @param oldBlockType
     * @param oldBlockData
     * @param newBlockType
     * @param newBlockData
     */
    void logBlock(String player, World world, Location location, 
                  int oldBlockType, byte oldBlockData,
                  int newBlockType, byte newBlockData);
    
    
    /**
     * Check if a player can place a block
     * @param player
     * @param world
     * @param location
     * @return 
     */
    boolean canPlace(String player, World world, Location location);
    

    /**
     * Gets the special blocks hub player instance
     * @param name
     * @return 
     */
    IPlayer getPlayer(String name);
    
    /**
     * Gets the special blocks hub player instance
     * @param uuid 
     * @return 
     */
    IPlayer getPlayer(UUID uuid);
}