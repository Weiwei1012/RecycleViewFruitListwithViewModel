package com.example.recycleviewballlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewballlist.databinding.MyLayoutBinding

class BallAdapter: ListAdapter<Balls, BallAdapter.ViewHolder>(BallDiffCallback()) {

    class BallDiffCallback : DiffUtil.ItemCallback<Balls>() {
        override fun areItemsTheSame(oldItem: Balls, newItem: Balls): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Balls, newItem: Balls): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(val binding: MyLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MyLayoutBinding.inflate(layoutInflater, parent, false)
        val viewHolder = ViewHolder(binding)
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(parent.context, getItem(viewHolder.bindingAdapterPosition).name, Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

//    override fun getItemCount(): Int {
//        return ballList.size
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ball = getItem(position)
        holder.binding.ball = ball
        holder.binding.executePendingBindings()
    }
}


