/*
 *
 *  * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *  *
 *
 */

package com.hms.tictactoe.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hms.tictactoe.base.BaseViewModel
import com.hms.tictactoe.data.model.GameAreaStatus
import com.hms.tictactoe.data.model.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
/**
 * ViewModel class for Game Fragment
 */
@HiltViewModel
class GameViewModel @Inject constructor() : BaseViewModel() {

    var isASRActive: Boolean = false

    var completedMove: Int = 0

    private val _isListening = MutableLiveData(false)
    val isListening: LiveData<Boolean> = _isListening

    var gameArea = mutableListOf(
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY,
        GameAreaStatus.EMPTY
    )

    private val _whoseTurn = MutableLiveData(Player.PLAYER_BLACK)
    val whoseTurn: LiveData<Player> = _whoseTurn

    fun setListeningVisibility(isListeningNow: Boolean) {
        _isListening.value = isListeningNow
    }

    fun setWhosePlayer(player: Player) {
        _whoseTurn.value = player
    }

}