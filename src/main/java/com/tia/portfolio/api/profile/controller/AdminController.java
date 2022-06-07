package com.tia.portfolio.api.profile.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tia.portfolio.api.PfLandUserProfileRepository;
import com.tia.portfolio.api.common.util.TiMap;
import com.tia.portfolio.api.profile.entity.PfLandUserProfile;
import com.tia.portfolio.api.profile.entity.PfLandUserProjectList;
import com.tia.portfolio.api.profile.entity.PfLandUserSkill;
import com.tia.portfolio.api.profile.entity.PfLandUserTaskList;
import com.tia.portfolio.api.profile.model.Profile;
import com.tia.portfolio.api.profile.model.ProfileReq;
import com.tia.portfolio.api.profile.repository.PfLandUserProjectListRepository;
import com.tia.portfolio.api.profile.repository.PfLandUserSkillRepository;
import com.tia.portfolio.api.profile.repository.PfLandUserTaskListRepository;
import com.tia.portfolio.api.profile.service.ProfileService;
import com.tia.portfolio.api.profile.service.ProjectService;
import com.tia.portfolio.api.profile.service.SkillService;
import com.tia.portfolio.api.profile.service.TaskService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    // Mybatis
    @Autowired
    ProfileService ps;
    @Autowired
    ProjectService pjs;
    @Autowired
    SkillService ss;
    @Autowired
    TaskService ts;

    // JPA

    @Autowired
    PfLandUserProfileRepository pfLandUserProfileRepository;

    @Autowired
    PfLandUserSkillRepository pfLandUserSkillRepository;

    @Autowired
    PfLandUserProjectListRepository pfLandUserProjectListRepository;

    @Autowired
    PfLandUserTaskListRepository pfLandUserTaskListRepository;


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

    @PutMapping(value="/put-potf-info")
    public String setProfileInfo(@RequestBody TiMap req) throws Exception{
        JsonObject result      = new JsonObject();
        Gson gson        = new Gson();

        try {
            PfLandUserProfile profile = pfLandUserProfileRepository.save(gson.fromJson(gson.toJson(req, new TypeToken<TiMap>() {}.getType()), PfLandUserProfile.class));

            // 스킬
            PfLandUserSkill pfTemp1 = new PfLandUserSkill();
            pfTemp1.setUpno(profile.getId());
            Example<PfLandUserSkill> example1 = Example.of(pfTemp1);
            pfLandUserSkillRepository.deleteAll(pfLandUserSkillRepository.findAll(example1));
            List<PfLandUserSkill> temp = gson.fromJson(gson.toJsonTree(gson.fromJson(gson.toJson(req.get("skillList"), new TypeToken<List<TiMap>>() {}.getType()), new TypeToken<List<TiMap>>() {}.getType())), new TypeToken<List<PfLandUserSkill>>() {}.getType());

            for (PfLandUserSkill skill : temp) {
                skill.setUpno(profile.getId());
            }

            pfLandUserSkillRepository.saveAll(temp);

            // 프로젝트
            PfLandUserProjectList pfTemp2 = new PfLandUserProjectList();
            pfTemp2.setUpno(profile.getId());
            Example<PfLandUserProjectList> example2 = Example.of(pfTemp2);
            pfLandUserProjectListRepository.deleteAll(pfLandUserProjectListRepository.findAll(example2));

            List<PfLandUserProjectList> temp2 = gson.fromJson(gson.toJsonTree(gson.fromJson(gson.toJson(req.get("projectList"), new TypeToken<List<TiMap>>() {}.getType()), new TypeToken<List<TiMap>>() {}.getType())), new TypeToken<List<PfLandUserProjectList>>() {}.getType());

            for (PfLandUserProjectList project : temp2) {
                project.setUpno(profile.getId());
            }

            pfLandUserProjectListRepository.saveAll(temp2);


            // 태스크 리스트
            PfLandUserTaskList pfTemp3 = new PfLandUserTaskList();
            pfTemp3.setUpno(profile.getId());
            Example<PfLandUserTaskList> example3 = Example.of(pfTemp3);
            pfLandUserTaskListRepository.deleteAll(pfLandUserTaskListRepository.findAll(example3));

            List<PfLandUserTaskList> temp3 = gson.fromJson(gson.toJsonTree(gson.fromJson(gson.toJson(req.get("taskList"), new TypeToken<List<TiMap>>() {}.getType()), new TypeToken<List<TiMap>>() {}.getType())), new TypeToken<List<PfLandUserTaskList>>() {}.getType());

            for (PfLandUserTaskList task : temp3) {
                task.setUpno(profile.getId());
            }

            pfLandUserTaskListRepository.saveAll(temp3);

            result.addProperty("respCode", "00000");
            result.addProperty("respMsg", "성공");
        } catch (Exception e) {
            throw e;
        }

        return gson.toJson(result).toString();
    }

    @DeleteMapping(value="/delete-potf-info")
    public String deleteProfileInfo(@RequestBody TiMap req, Model model) throws Exception {
        Gson gson              = new Gson();
        JsonObject result      = new JsonObject();

        try {
            pfLandUserProfileRepository.delete(gson.fromJson(gson.toJson(req, new TypeToken<TiMap>() {}.getType()), PfLandUserProfile.class));
            int Id = Integer.parseInt(req.get("id").toString());

            // 스킬
            PfLandUserSkill pfTemp1 = new PfLandUserSkill();
            pfTemp1.setUpno(Id);
            Example<PfLandUserSkill> example1 = Example.of(pfTemp1);
            pfLandUserSkillRepository.deleteAll(pfLandUserSkillRepository.findAll(example1));

            // 프로젝트
            PfLandUserProjectList pfTemp2 = new PfLandUserProjectList();
            pfTemp2.setUpno(Id);
            Example<PfLandUserProjectList> example2 = Example.of(pfTemp2);
            pfLandUserProjectListRepository.deleteAll(pfLandUserProjectListRepository.findAll(example2));


            // 태스크 리스트
            PfLandUserTaskList pfTemp3 = new PfLandUserTaskList();
            pfTemp3.setUpno(Id);
            Example<PfLandUserTaskList> example3 = Example.of(pfTemp3);
            pfLandUserTaskListRepository.deleteAll(pfLandUserTaskListRepository.findAll(example3));

            result.addProperty("respCode", "00000");
            result.addProperty("respMsg", "성공");
        } catch (Exception e) {
            throw e;
        }

        return gson.toJson(result).toString();
    }

}
