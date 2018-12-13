package com.medicalrep.doctorrep.view.search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.database.*
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.model.Medicine
import kotlin.collections.ArrayList

class SearchFragment : Fragment() {

    var results: ArrayList<Medicine>? = ArrayList()
    private var mMedicineListener: ValueEventListener? = null
    private var mDatabase: DatabaseReference? = null
    private var mMedicineReference: DatabaseReference? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val listView: ListView = view.findViewById(R.id.search_listview)
        val etSearch: EditText = view.findViewById(R.id.et_search)


        //init firebase
        mDatabase = FirebaseDatabase.getInstance().reference
        mMedicineReference = FirebaseDatabase.getInstance().getReference("medicine")

        //seta adpater
        val adapter: BaseAdapter = ListViewAdapter(this.context!!, this.results!!)
        listView.adapter = adapter


        //list all medicinie in start
        val medicineListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (ds in dataSnapshot.children) {
                        val medicine: Medicine = ds.getValue(Medicine::class.java)!!
                        results!!.add(medicine)
                    }
                    adapter.notifyDataSetChanged()


                }
            }

            override fun onCancelled(dataSnapshot: DatabaseError) {

            }
        }

        mMedicineReference!!.addValueEventListener(medicineListener)

        // copy for removing at onStop()
        mMedicineListener = medicineListener


        //actions
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val searchWord: String = etSearch.text.toString()

                //create query with search word
                val searchQuery: Query =
                    FirebaseDatabase.getInstance()//database
                        .getReference("medicine")// table
                        .orderByChild("name")// column
                        .startAt(searchWord).endAt(searchWord+"\uf8ff")//condition

                //consider data as ref and elect data from it
                searchQuery.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (medicineSnapshot in dataSnapshot.children) {
                            val medicine: Medicine = medicineSnapshot.getValue(Medicine::class.java)!!
                            results!!.add(medicine)
                        }
                        adapter.notifyDataSetChanged()

                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                results!!.clear()
                adapter.notifyDataSetChanged()

            }
        })
        return view
    }


    override fun onStop() {
        super.onStop()
        if (mMedicineListener != null) {
            mMedicineReference!!.removeEventListener(mMedicineListener!!)
        }
    }

}
