//건들지 마쇼
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class StrokePredictionClient {
    public static void main(String[] args) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            //api 주소
            HttpPost request = new HttpPost("http://localhost:5000/predict");

            //api에 넘겨줄 정보 userinfo 가져와서 넣으면 됨.
            String json = "{\"gender\": \"Male\", \"smoking_status\": \"formerly smoked\", ...}";
            StringEntity entity = new StringEntity(json);
            request.setEntity(entity);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            CloseableHttpResponse response = client.execute(request);

            // 검사 결과
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("Prediction Response: " + result);
        }
    }
}
