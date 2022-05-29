package com.tia.portfolio.api.profile.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import com.tia.portfolio.api.profile.service.ProfileService;
import com.tia.portfolio.api.profile.service.ProjectService;
import com.tia.portfolio.api.profile.service.SkillService;
import com.tia.portfolio.api.profile.service.TaskService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/admin/")
public class AdminController {
    final int pageSize = 10;

    @Autowired
    ProfileService ps;
    @Autowired
    ProjectService pjs;
    @Autowired
    SkillService ss;
    @Autowired
    TaskService ts;

    @PostMapping(value="/get-potf-list")
    public String getProfileList(@RequestBody TiMap req, Model model) throws Exception {

        TiMap list        = new TiMap();
        JsonObject result      = new JsonObject();
        Gson gson        = new Gson();

        list.put("page", req.get("page"));
        list.put("size", pageSize);

        // populate your list
        JsonElement element = gson.toJsonTree(ps.listBy(list), new TypeToken<PageInfo<TiMap>>() {}.getType());

        JsonArray jsonArray = element.getAsJsonObject().get("list").getAsJsonArray();

        result.add("profileList", jsonArray);
        result.addProperty("respCode", "00000");
        result.addProperty("respMsg", "성공");

        return gson.toJson(result).toString();
    }

    @PostMapping(value="/get-potf-info")
    public String getProfileInfo(@RequestBody TiMap req, Model model) throws Exception {
        JsonObject result      = new JsonObject();
        Gson gson        = new Gson();

        // populate your list
        JsonElement element = gson.toJsonTree(ps.itemBy(req));

        JsonElement tsElement = gson.toJsonTree(ts.listBy(req), new TypeToken<List<TiMap>>() {}.getType());
        JsonElement ssElement = gson.toJsonTree(ss.listBy(req), new TypeToken<List<TiMap>>() {}.getType());
        JsonElement pjsElement = gson.toJsonTree(pjs.listBy(req), new TypeToken<List<TiMap>>() {}.getType());

        element.getAsJsonObject().add("taskList", tsElement);
        element.getAsJsonObject().add("skillList", ssElement);
        element.getAsJsonObject().add("projectList", pjsElement);

        result.add("profileInfo", element);
        result.addProperty("respCode", "00000");
        result.addProperty("respMsg", "성공");

        return gson.toJson(result).toString();
    }
}
