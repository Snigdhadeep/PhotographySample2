package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbegin.jsonparsetutorial3.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Aboutme_newfrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Aboutme_newfrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Aboutme_newfrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "ARG_PAGE";
    private static final String ARG_PARAM2 = "ARG_PARAM2";

    // TODO: Rename and change types of parameters
   private int mParam1;
    private int mParam2;

    private OnFragmentInteractionListener mListener;

    public Aboutme_newfrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param page Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Aboutme_newfrag.
     */
    // TODO: Rename and change types and number of parameters
    public static Aboutme_newfrag newInstance(int page,int param2) {
        Aboutme_newfrag fragment = new Aboutme_newfrag();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1,2);
           mParam2 = getArguments().getInt(ARG_PARAM2,1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aboutme_newfrag, container, false);
    }

  // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
