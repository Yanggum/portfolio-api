package com.tia.portfolio.api.profile.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/pp/")
public class TestController {
    final int pageSize = 10;

//    @Autowired
//    NovelService ns;

    @PostMapping(value="/get-potf-info")
    public String getNovelList() throws Exception {
//        NovelReq   list        = new NovelReq();
        var result       = new JsonObject();
        Gson gson        = new Gson();

        // populate your list
//        JsonElement element = gson.toJsonTree(ns.listBy(list), new TypeToken<List<CHMap>>() {}.getType());

//        if (!element.isJsonArray()) {
//            throw new Exception();
//        }

        JsonArray jsonArray = new JsonArray();//element.getAsJsonArray();

        result.add("novelList", jsonArray);
        result.addProperty("respCode", "00000");
        result.addProperty("respMsg", "성공");

        return gson.toJson(result).toString();
    }
}
