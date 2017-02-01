package com.example.tp;

/**
 * Created by uday on 12/28/2016.
 */
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;

import java.util.List;



public class MessageLoader extends AsyncTaskLoader<List<Message>> {
    /** Tag for log messages */
    private static final String LOG_TAG = MessageLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link MessageLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public MessageLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {


    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Message> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        String token = credential.getToken();

        HttpRequestFactory factory = HTTP_TRANSPORT.createRequestFactory();
        GoogleUrl url = new GoogleUrl("https://accounts.google.com/o/oauth2/revoke?token=" + token);
        HttpRequest request = factory.buildGetRequest(url);
        HttpResponse response = request.execute();
        forceLoad();

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Message> earthquakes = QueryUtils.fetchMessageData(mUrl);
        return earthquakes;
    }

}
