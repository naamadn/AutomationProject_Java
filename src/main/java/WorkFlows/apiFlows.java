package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get User From Grafana")
    public static String getUserProperty(String jPath)
    {
         Response response = apiActions.get("/api/users/");
        return apiActions.extractFromJSON(response, jPath);
    }


    @Step("Create New User To Grafana")
    public static void postUser(String name, String email, String login, String password)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        requestParams.put("login", login);
        requestParams.put("password", password);
        apiActions.post(requestParams, "/api/admin/users");
    }


    @Step("update User details")
    public static void updateUser(String id, String name, String email, String login)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        requestParams.put("login", login);
        apiActions.put(requestParams, "/api/users/"+id);
    }

    @Step("Delete User From Grafana")
    public static void deleteUser(String id)
    {
        apiActions.delete(id);
    }

}
