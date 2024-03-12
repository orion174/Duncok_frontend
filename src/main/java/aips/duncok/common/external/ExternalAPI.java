package aips.duncok.common.external;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class ExternalAPI {

    public boolean checkToken(HttpServletRequest request, String backendUrl) {
        // 토큰 검증 로직
        HttpSession session = request.getSession(true);
        Object token = session.getAttribute("accessToken");

        if(Objects.isNull(token)) {
            return false;

        }else {
            token = token.toString();
            String url = backendUrl + "/user/check/not-expired";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            headers.set("Authorization", "Bearer " + token);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            try {
                // 현재 토큰 검사 (API 서버와 통신)
                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<String> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
                );

                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(responseEntity.getBody());

                // 토큰 검증 결과가 data 안에 boolean으로 나옴
                return (Boolean) jsonObject.get("data");

            }catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
