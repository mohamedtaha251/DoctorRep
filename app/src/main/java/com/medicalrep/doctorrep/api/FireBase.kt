package com.medicalrep.doctorrep.api

import com.google.firebase.database.*

class FireBase {

    private var mDatabase: DatabaseReference? = null
    private var mMedicineReference: DatabaseReference? = null

    constructor() {
        mDatabase = FirebaseDatabase.getInstance().reference
        mMedicineReference = FirebaseDatabase.getInstance().getReference("medicine")
    }

    fun readData() {
        val medicineListner = object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        }

        mMedicineReference!!.addValueEventListener(medicineListner)
    }


    fun presistLocally() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        FirebaseDatabase.getInstance().getReference("disconnectmessage").onDisconnect().setValue("I disconnected!")


    }
}