package tlossen;

//import co.paralleluniverse.fibers.okhttp3.OkHttpClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Demo
{
    public static class Call
    {
        Request _request;

        public Call(final String url) {
            _request = new Request.Builder().url(url).build();
        }

        public int execute() {
            try {
                OkHttpClient client = new OkHttpClient();
                Response response = client.newCall(_request).execute();
                return response.code();
            } catch (IOException e) {
                return 500;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            Call call = new Call("http://example.org");
            System.out.println(call.execute());
        }
    }
}

