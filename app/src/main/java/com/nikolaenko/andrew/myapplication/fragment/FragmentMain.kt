package com.nikolaenko.andrew.myapplication.fragment


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.nikolaenko.andrew.myapplication.adapter.CurrencyAdapter
import com.nikolaenko.andrew.myapplication.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.onUiThread


class FragmentMain : BaseFragment() {

    private var disposable: Disposable? = null
    private lateinit var adapter: CurrencyAdapter

    override fun onStart() {
        super.onStart()

        getList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCurrency.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        rvCurrency.itemAnimator = DefaultItemAnimator()

        adapter = CurrencyAdapter()

        rvCurrency.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainActivity.setSupportActionBar(toolbar)
        mainActivity.supportActionBar!!.title = null

        val t = object : Thread() {
            override fun run() {
                while (!isInterrupted) {
                    try {
                        Thread.sleep(15000)

                        onUiThread {
                            getList()
                        }

                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }
        }

        t.start()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.update_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_item_update -> {

                getList()

                return true
            }
        }
        return false
    }

    private fun getList(){

        showProgress(true)

        disposable = apiPublicService.value.getList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t ->

                    adapter.setList(t.data!!.toMutableList())

                    showProgress(false)

                }, { e ->
                    e.printStackTrace()
                    showProgress(false)
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
        Thread.interrupted()
    }
}
