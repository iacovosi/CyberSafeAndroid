package cy.cybersafety.cybersafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeFragment extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(cy.cybersafety.cybersafe.R.layout.home, container, false);

        // Initialize WebView
        webView = view.findViewById(R.id.webview);

        // Enable JavaScript and other necessary settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage if the website needs it

        // Enable zoom controls and pinch-to-zoom functionality
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false); // Set to true if you want zoom controls to be visible
        webSettings.setSupportZoom(true); // Ensure zooming is supported

        // Set the initial scale to 90%
        webView.setInitialScale(90);

        // Enable horizontal and vertical scrollbars
        webView.setScrollbarFadingEnabled(false); // Keeps scrollbars visible
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        // Ensure that the WebView opens URLs inside the app
        webView.setWebViewClient(new WebViewClient());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Load the default URL
        webView.loadUrl("https://cybersafety.cy/");
    }

    @Override
    public void onDestroyView() {
        // Clean up resources when the view is destroyed
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }
}
