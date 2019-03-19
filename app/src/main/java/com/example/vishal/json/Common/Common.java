package com.example.vishal.json.Common;

import com.example.vishal.json.Remote.IMyAPI;
import com.example.vishal.json.RetrofitClient;

public class Common {
    public static final String Base_Url="http://tkns.housing-buddy.com/user_login_webservices.php";
    public static IMyAPI getAPI()
    {
        return RetrofitClient.getClient(Base_Url).create(IMyAPI.class);
    }
}
