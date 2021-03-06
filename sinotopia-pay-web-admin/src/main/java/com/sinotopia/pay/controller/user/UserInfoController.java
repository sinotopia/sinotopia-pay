/*
 * Copyright 2015-2102 RonCoo(http://www.sinotopia.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sinotopia.pay.controller.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinotopia.pay.common.core.dwz.DWZ;
import com.sinotopia.pay.common.core.dwz.DwzAjax;
import com.sinotopia.pay.common.core.pagination.PageBean;
import com.sinotopia.pay.common.core.pagination.PageParam;
import com.sinotopia.pay.user.entity.RpUserInfo;
import com.sinotopia.pay.user.service.RpUserInfoService;

/**
 * 用户信息
 * www.sinotopia.com
 *
 * @author：sinotopia
 */
@Controller
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private RpUserInfoService rpUserInfoService;

    /**
     * 函数功能说明 ： 查询用户信息
     *
     * @return String
     * @throws
     * @参数： @return
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(RpUserInfo rpUserInfo, PageParam pageParam, Model model) {
        PageBean pageBean = rpUserInfoService.listPage(pageParam, rpUserInfo);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("rpUserInfo", rpUserInfo);
        return "user/info/list";
    }

    /**
     * 函数功能说明 ：跳转添加
     *
     * @return String
     * @throws
     * @参数： @return
     */
    @RequiresPermissions("user:userInfo:add")
    @RequestMapping(value = "/addUI", method = RequestMethod.GET)
    public String addUI() {

        return "user/info/add";
    }

    /**
     * 函数功能说明 ： 保存
     *
     * @return String
     * @throws
     * @参数： @return
     */
    @RequiresPermissions("user:userInfo:add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam("userName") String userName, @RequestParam("mobile") String mobile, @RequestParam("password") String password, DwzAjax dwz) {
        rpUserInfoService.registerOffline(userName, mobile, password);
        dwz.setStatusCode(DWZ.SUCCESS);
        dwz.setMessage(DWZ.SUCCESS_MSG);
        model.addAttribute("dwz", dwz);
        return DWZ.AJAX_DONE;
    }

    /**
     * 函数功能说明 ： 查询用户信息 查找带回
     *
     * @return String
     * @throws
     * @参数： @return
     */
    @RequestMapping(value = "/lookupList", method = {RequestMethod.POST, RequestMethod.GET})
    public String lookupList(RpUserInfo rpUserInfo, PageParam pageParam, Model model) {
        PageBean pageBean = rpUserInfoService.listPage(pageParam, rpUserInfo);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("pageParam", pageParam);
        model.addAttribute("rpUserInfo", rpUserInfo);
        return "user/info/lookupList";
    }

}
