package com.plznoanr.data.model.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plznoanr.domain.model.Summoner
import kotlinx.parcelize.Parcelize

@Entity
data class SummonerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String, // 소환사 이름
    val level: String, // 레벨
    val icon: String, // 소환사 아이콘
    val tier: String, // 티어 (GOLD)
    val leaguePoints: Int, // 점수
    val rank: String, // 랭크 (I)
    val wins: Int, // 승리
    val losses: Int, // 패배
    val miniSeries: MiniSeries?, // 승급전
    val isPlaying: Boolean,
) {
    data class MiniSeries(
        val losses: Int,
        val target: Int,
        val wins: Int,
        val progress: String
    ) {
        fun toDomain() = Summoner.MiniSeries(
            losses = losses,
            target = target,
            wins = wins,
            progress = progress
        )
    }

    fun toDomain() = Summoner(
        name = name,
        level = level,
        icon = icon,
        tier = tier,
        leaguePoints = leaguePoints,
        rank = rank,
        wins = wins,
        losses = losses,
        miniSeries = miniSeries?.toDomain(),
        isPlaying = isPlaying
    )

}
