package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get Data From Server")
    public static Response get(String paramValues)
    {
        response = httpRequest.get(paramValues);
        return response;
    }
    @Step("Post Data To Server")
    public static void post(JSONObject params, String resource)
    {
       httpRequest.header("Content-Type", "application/json");
       httpRequest.body(params.toJSONString());
       response = httpRequest.post(resource);
    }

    @Step("Update Data In Server")
    public static void put(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    @Step("Delete Data From Server")
    public static void delete(String id)
    {
        response = httpRequest.delete("/api/admin/users/"+id);
    }


    @Step("Extract Data From JSON Format")
    public static String extractFromJSON(Response response, String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();

    }
}
