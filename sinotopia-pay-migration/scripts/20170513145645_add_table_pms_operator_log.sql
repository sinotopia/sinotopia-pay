--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // add table pms_operator_log
-- Migration SQL that makes the change goes here.
CREATE TABLE `pms_operator_log`
(
  id            BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  version       BIGINT       NOT NULL,
  creator       VARCHAR(50)  NOT NULL
  COMMENT '创建人',
  create_time   DATETIME     NOT NULL
  COMMENT '创建时间',
  editor        VARCHAR(50) COMMENT '修改人',
  edit_time     DATETIME COMMENT '修改时间',
  status        VARCHAR(20)  NOT NULL,
  remark        VARCHAR(300),
  operator_id   BIGINT       NOT NULL,
  operator_name VARCHAR(50)  NOT NULL,
  operate_type  VARCHAR(50)  NOT NULL
  COMMENT '操作类型（1:增加，2:修改，3:删除，4:查询）',
  ip            VARCHAR(100) NOT NULL,
  content       VARCHAR(3000),
  PRIMARY KEY (id)
)
  AUTO_INCREMENT = 1000;

ALTER TABLE `pms_operator_log`
  COMMENT '权限_操作员操作日志表';

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE IF EXISTS `pms_operator_log`;

