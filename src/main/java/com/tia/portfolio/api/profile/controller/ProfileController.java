package com.tia.portfolio.api.profile.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import com.tia.portfolio.api.profile.service.ProfileService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/pc/")
public class ProfileController {
    final int pageSize = 10;

    @Autowired
    ProfileService ps;

    @PostMapping(value="/get-potf-list")
    public String getProfileList(Model model) throws Exception {

        ProfileReq list        = new ProfileReq();
        JsonObject result      = new JsonObject();
        Gson gson        = new Gson();

        // populate your list
        JsonElement element = gson.toJsonTree(ps.listBy(list), new TypeToken<List<TiMap>>() {}.getType());

        if (!element.isJsonArray()) {
            throw new Exception();
        }

        JsonArray jsonArray = new JsonArray();//element.getAsJsonArray();

        result.add("novelList", jsonArray);
        result.addProperty("respCode", "00000");
        result.addProperty("respMsg", "성공");

        return gson.toJson(result).toString();
    }

    @PostMapping(value="/get-potf-info")
    public String getProfileInfo(@RequestBody TiMap req) throws Exception {
        JsonObject result      = new JsonObject();
        Gson gson        = new Gson();

        // populate your list
        JsonElement element = gson.toJsonTree(ps.itemBy(req));

//        if (!element.isJsonArray()) {
//            throw new Exception();
//        }
//
//        JsonArray jsonArray = new JsonArray();//element.getAsJsonArray();

        result.add("profileInfo", element);
        result.addProperty("respCode", "00000");
        result.addProperty("respMsg", "성공");

        return gson.toJson(result).toString();
    }
}
