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

-- // add table rp_account_check_batch
-- Migration SQL that makes the change goes here.

CREATE TABLE `rp_account_check_batch`
(
  id                      VARCHAR(50)  NOT NULL,
  version                 INT UNSIGNED NOT NULL,
  create_time             DATETIME     NOT NULL,
  editor                  VARCHAR(100) COMMENT '修改者',
  creator                 VARCHAR(100) COMMENT '创建者',
  edit_time               DATETIME COMMENT '最后修改时间',
  status                  VARCHAR(30)  NOT NULL,
  remark                  VARCHAR(500),
  batch_no                VARCHAR(30)  NOT NULL,
  bill_date               DATE         NOT NULL,
  bill_type               VARCHAR(30),
  handle_status           VARCHAR(10),
  bank_type               VARCHAR(30),
  mistake_count           INT(8),
  unhandle_mistake_count  INT(8),
  trade_count             INT(8),
  bank_trade_count        INT(8),
  trade_amount            DECIMAL(20, 6),
  bank_trade_amount       DECIMAL(20, 6),
  refund_amount           DECIMAL(20, 6),
  bank_refund_amount      DECIMAL(20, 6),
  bank_fee                DECIMAL(20, 6),
  org_check_file_path     VARCHAR(500),
  release_check_file_path VARCHAR(500),
  release_status          VARCHAR(15),
  check_fail_msg          VARCHAR(300),
  bank_err_msg            VARCHAR(300),
  PRIMARY KEY (id)
)
  COMMENT = 'account_check_batch';

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE IF EXISTS `rp_account_check_batch`;

