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
            //입력 순서: ["gender", "age", "hypertension", "heart_disease", "ever_married", "work_type", "residence_type", 
            //"avg_glucose_level", "bmi", "smoking_status"]
            String json = "{"
                        + "\"gender\": 1,"              // 0 : Female | 1 : Male
                        + "\"age\": 65,"    
                        + "\"hypertension\": 1,"
                        + "\"heart_disease\": 1,"
                        + "\"ever_married\": 1,"        // 1: Yes | 0: NO
                        + "\"work_type\": 2,"           // 0 : Govt_job | 1: Private | 2: Self_employed | 3: Children
                        + "\"residence_type\": 1,"      // 0: Rural | 1: Urban
                        + "\"avg_glucose_level\": 86.4,"
                        + "\"bmi\": 38.1,"
                        + "\"smoking_status\": 3"       // 0: Unknown | 1: fomerly smoked | 2: never smoked | 3: smokes
                        + "}";
            StringEntity entity = new StringEntity(json, "UTF-8");
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
