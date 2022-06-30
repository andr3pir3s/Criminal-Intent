package com.example.criminalintent

// CrimeFragment is a controller that interacts with model and view objects
// Its job is to present the details of a specific crime and update those details
// as the user changes them.

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment: Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        dateButton.apply{
            text = crime.date.toString()
            isEnabled = false
        }
        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                Start: Int,
                count: Int,
                after: Int
            ){
                //This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                Start: Int,
                count: Int,
                after: Int
            ){
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?){
                //this one too
            }
        }
        titleField.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener{ _, isChecked ->
                crime.isSolved = isChecked
            }
        }
    }
}

/* observations

You do not inflate the fragment’s view inside Fragment.onCreate(Bundle?). You configure the
fragment instance in Fragment.onCreate(Bundle?) , but you create and configure the
fragment’s view in another fragment lifecycle function:
onCreateView(LayoutInflater, ViewGroup?, Bundle?).

 */