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
package com.sinotopia.pay.permission.service;

/**
 * 菜单角色service接口
 * <p>
 * www.sinotopia.com
 *
 * @author：sinotopia
 */
public interface PmsMenuRoleService {

    /**
     * 根据角色ID统计关联到此角色的菜单数.
     *
     * @param roleId 角色ID.
     * @return count.
     */
    int countMenuByRoleId(Long roleId);

    /**
     * 根据角色id，删除该角色关联的所有菜单权限
     *
     * @param roleId
     */
    void deleteByRoleId(Long roleId);

    /**
     * @param roleId
     * @param roleMenuStr
     */
    void saveRoleMenu(Long roleId, String roleMenuStr);

}
