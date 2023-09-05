-- user_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>

insert into user_tb(login_id, password, email, username, address, tel, birth) values('ssar', '1234', 'ssar@nate.com', '김쌀', '부산광역시 부산진구 부전동', '010-1234-5677', 1997);
insert into user_tb(login_id, password, email, username, address, tel, birth) values('ssar', '1234', 'ssar@nate.com', '김쌀', '부산광역시 부산진구 부전동', '010-1234-5677', 1997);
insert into user_tb(login_id, password, email, username, address, tel, birth) values('ssar', '1234', 'ssar@nate.com', '김쌀', '부산광역시 부산진구 부전동', '010-1234-5677', 1997);


-- biz_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into biz_tb(login_id, password, bizname, manager_name, manager_tel, manager_email, address) 
values('samsung', '1234',  '삼성', '최제인', '010-1234-5678','ss@naver.com', '수원 영통구');

-- notice_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into notice_tb(open, user_img, semi_title, semi_content, work_field, biz_name, user_address, career, education, main_content, dead_line, user_id) values('ublic','베이직2.jpg','백엔드대모집','모집모집 노예모집', '백엔드','그린','대전','신입','고졸','많은 사람들을 모집합니다','2023-10-05','null')