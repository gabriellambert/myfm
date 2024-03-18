package com.gapps.myfm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gapps.myfm.PlayersListViewHolder
import com.gapps.myfm.databinding.PlayerListItemBinding
import com.gapps.player_center.model.Player

class PlayersListAdapter(
    private val context: Context,
    private val playersList: List<Player>,
    private val callback: (Player) -> Unit
) : RecyclerView.Adapter<PlayersListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersListViewHolder {
        val binding: PlayerListItemBinding = PlayerListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        val vh = PlayersListViewHolder(binding)
        vh.itemView.setOnClickListener {
            val player = playersList[vh.adapterPosition]
            callback(player)
        }
        return vh
    }

    override fun onBindViewHolder(holder: PlayersListViewHolder, position: Int) {
        holder.bind(playersList[position])
    }

    override fun getItemCount(): Int {
        return playersList.size
    }
}