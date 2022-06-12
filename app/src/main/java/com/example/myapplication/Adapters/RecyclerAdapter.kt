package com.example.myapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ActivityFragment
import com.example.myapplication.Detalizations.MyDetalizationFragment
import com.example.myapplication.Detalizations.UsersDetalizationFragment
import com.example.myapplication.ListItem
import com.example.myapplication.R

var globalId: Int = 1

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val DATE_VIEW_TYPE = 1
        private const val CARD_VIEW_TYPE = 2
    }

    private val data: MutableList<ListItem> = mutableListOf()

    override fun getItemViewType(position: Int): Int = when(data[position]) {
        is ListItem.Date -> DATE_VIEW_TYPE
        is ListItem.Card -> CARD_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DATE_VIEW_TYPE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_date, parent, false)
            DateViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card, parent, false)
            val text = view.findViewById<TextView>(R.id.userText)
            view.setOnClickListener {
                if(text.text == ""){
                    findNavController(view).navigate(R.id.action_tabsFragment_to_myDetalizationFragment,
                        bundleOf(MyDetalizationFragment.KEY_NAME to view.id))
                }else{
                    findNavController(view).navigate(R.id.action_tabsFragment_to_usersDetalizationFragment,
                        bundleOf(UsersDetalizationFragment.KEY_NAME to view.id))
                }
            }
            CardViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = data[position]){
            is ListItem.Date -> (holder as DateViewHolder).bind(item)
            is ListItem.Card -> (holder as CardViewHolder).bind(item, position)
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(data: List<ListItem>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class DateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val dateText = itemView.findViewById<TextView>(R.id.dateText)

        fun bind (date: ListItem.Date){
            dateText.text = date.date
        }
    }

    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val distanceText = itemView.findViewById<TextView>(R.id.distanceText)
        private val userText = itemView.findViewById<TextView>(R.id.userText)
        private val timeText = itemView.findViewById<TextView>(R.id.timeText)
        private val movingByText = itemView.findViewById<TextView>(R.id.movingByText)
        private val dateText = itemView.findViewById<TextView>(R.id.dateText)

        fun bind (card: ListItem.Card, position: Int){
            itemView.id = position

            distanceText.text = card.distance
            userText.text = card.user
            timeText.text = card.time
            movingByText.text = card.moveBy
            dateText.text = card.date
        }
    }
}