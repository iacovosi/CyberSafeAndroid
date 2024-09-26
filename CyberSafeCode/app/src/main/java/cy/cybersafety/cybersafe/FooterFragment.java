package cy.cybersafety.cybersafe;

import android.support.v4.app.Fragment;  // Use the support library Fragment, not android.app.Fragment
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FooterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(cy.cybersafety.cybersafe.R.layout.fragment_footer, container, false);
    }
}
