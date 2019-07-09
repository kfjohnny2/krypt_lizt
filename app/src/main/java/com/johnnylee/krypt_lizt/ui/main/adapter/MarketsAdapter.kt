package com.johnnylee.krypt_lizt.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.johnnylee.krypt_lizt.R
import com.johnnylee.krypt_lizt.databinding.ItemMarketBinding
import com.johnnylee.krypt_lizt.model.Market
import com.johnnylee.krypt_lizt.util.helpers.AdapterItemsContract

class MarketsAdapter(private var markets: MutableList<Market>) : RecyclerView.Adapter<MarketsAdapter.MarketsViewHolder>(), AdapterItemsContract {

    override fun replaceItems(list: List<*>) {
        if (markets.isNullOrEmpty()) {
            markets = list as MutableList<Market>
        } else {
            markets.addAll(list as MutableList<Market>)
        }
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMarketBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_market, parent, false)

        return MarketsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketsViewHolder, position: Int) {
        holder.bind(markets[position])
    }

    override fun getItemCount(): Int {
        return markets.size
    }
    class MarketsViewHolder(val binding: ItemMarketBinding) : RecyclerView.ViewHolder(binding.root) {
        private val marketViewModel = MarketItemViewModel()
        fun bind(market: Market) {
            marketViewModel.bind(market)
            binding.marketViewModel = marketViewModel
            binding.executePendingBindings()
        }

    }
}