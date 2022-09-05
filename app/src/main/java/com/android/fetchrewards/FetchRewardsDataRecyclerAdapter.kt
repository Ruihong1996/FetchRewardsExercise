package com.android.fetchrewards
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fetch_data.view.*

class FetchRewardsDataRecyclerAdapter : RecyclerView.Adapter<FetchRewardsDataRecyclerAdapter.ViewHolder>()
{
    private var items:List<FetchRewardsModel> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fetch_data, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun populate(dataList: List<FetchRewardsModel>){
        items = dataList
    }

    class ViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val id = itemView.id_text
        private val listId = itemView.listId_text
        val name = itemView.name_text!!

        fun bind(dataModel: FetchRewardsModel){
            id.text = dataModel.id
            listId.text = dataModel.listId
            name.text = dataModel.name
        }
    }

}