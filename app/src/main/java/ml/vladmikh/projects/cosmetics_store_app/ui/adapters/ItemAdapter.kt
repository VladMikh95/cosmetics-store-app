package ml.vladmikh.projects.cosmetics_store_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import ml.vladmikh.projects.cosmetics_store_app.data.network.model.Item
import ml.vladmikh.projects.hotel_app.databinding.CatalogItemBinding

class ItemAdapter(private val onItemClicked: (Item) -> Unit) : ListAdapter<Item, ItemAdapter.ItemViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(
            CatalogItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //Возвращаем в фрагмент данные комнаты которой выбрали
        holder.buttonAdd.setOnClickListener {
            onItemClicked((getItem(position)))
        }

        holder.bind(getItem(position))
    }

    class ItemViewHolder(private var binding: CatalogItemBinding): RecyclerView.ViewHolder(binding.root) {


        val buttonAdd = binding.buttonAdd


        fun bind(item: Item) {

            val adapter = ViewPagerAdapter()
            binding.viewPager.adapter = adapter

            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            }.attach()
            adapter.submitList(item.image_urls)

            binding.textViewLastPrice.text = "${item.price.price} ${item.price.unit}"
            binding.textViewPrice.text = "${item.price.priceWithDiscount} ${item.price.unit}"
            binding.textViewDiscount.text = "-${item.price.discount}%"
            binding.textViewName.text = item.title
            binding.textViewDescription.text = item.subtitle

            if (item.feedback == null) {
                binding.imageViewStar.visibility = View.GONE
                binding.textViewFeedback.visibility = View.GONE
                binding.textViewFeedbackCount.visibility = View.GONE
            } else {
                binding.imageViewStar.visibility = View.VISIBLE
                binding.textViewFeedback.visibility = View.VISIBLE
                binding.textViewFeedbackCount.visibility = View.VISIBLE

                binding.textViewFeedback.text = item.feedback.rating.toString()
                binding.textViewFeedbackCount.text = "(${item.feedback.count})"
            }

        }


    }
}