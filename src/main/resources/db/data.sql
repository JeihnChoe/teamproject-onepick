-- user_tb 더미데이터--------------------------------------

-- 개인
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('ssar', '1234', '쌀킴','ssar@nate.com', '부산시', '부산진구', '010-1234-5677', '1997-02', null, 1);
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('cos', '1234', '코드킴','cos@nate.com', '서울시', '광진구', '010-1234-5678', '1997-03', null, 1);
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('love', '1234', '쌀킴','love@nate.com', '부산시', '부산진구', '010-1234-5677', '1997-02', null, 1);

-- 회사
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('samsung', '1234', '담당자1','samsung@nate.com', '부산시', '부산진구', '010-1234-5677', '1997-02', '삼성', 2);
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('lg', '1234', '담당자2','lg@nate.com', '부산시', '부산진구', '010-1234-5677', '1997-02', '엘지', 2);
insert into user_tb(login_id, password, username, email, address, address2, tel, birth, bizname, usercode) 
values('kakao', '1234', '담당자3','kakao@nate.com', '부산시', '부산진구', '010-1234-5677', '1997-02', '카카오', 2);


-- resume_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into resume_tb(title, semi_content, content, education, school, major, career1, career_periods1, career_periode1, career2, career_periods2, career_periode2, career3, career_periods3, career_periode3, open, etc1, etc2, etc3, etc_period1, etc_period2, etc_period3, link1, link2, link3, work_field, user_id) 
values('이력서타이틀1번유저', '간단 소개글입니다.', '안녕하십니까, 저는 동의대학교를 졸업하였고, 경력은 없으며 나이는 28세 입니다. 비록 비전공자이지만 동영상 강의로 이론을 배우고, 인터넷으로 스터디를 모집하여서 프로젝트를 통해 직접 코딩을 해볼 수 있었습니다. 저는 정말 착하고 순하며, 하라는 일은 모두 다 할수있습니다. 저를 뽑아주세요ㅎㅎ', '대학교 졸업', '동의대학교', '컴퓨터공학과', '신입', null, null, null, null, null, null, null, null, 'off', '없음', '없음', '없음', null, null, null,'http://www.naver.com', null, null, '백엔드 개발자', 1);
insert into resume_tb(title, semi_content, content, education, school, major, career1, career_periodS1, career_periodE1, career2, career_periodS2, career_periodE2, career3, career_periodS3, career_periodE3, open, etc1, etc_period1, etc2, etc_period2, etc3, etc_period3, link1, link2, link3, work_field, user_id) 
values('저는 학점이 4.5인 만점자입니다!', '간단한닥나단', '안녕하십니까, 저는 동의대학교 광고홍보학과를 졸업하여 광고를 제작하고 싶습니다. 이론은 물론이거와 독특한 생각들과 창의적인 아이디어로 이제껏 낸 프로젝트들이 수없이 많습니다. 제 git주소로 들어가보시면 많은 결과물을 보실 수 있을 것입니다.', '대학교 졸업', '동의대학교', '광고홍보학과', '네이버', '2020-05-05', '2022-01-05', '배달의 민족', '2018-06-01', '2019-07-11', null, null, null, 'off', '광고부문 우수상', '2021-04-30', null, null, null, null,'http://www.nancheonjae.com' ,'http://www.블로그광고.com', null, '앱 개발자', 1);
insert into resume_tb(title, semi_content, content, education, school, major, career1, career_periods1, career_periode1, career2, career_periods2, career_periode2, career3, career_periods3, career_periode3, open, etc1, etc2, etc3, etc_period1, etc_period2, etc_period3, link1, link2, link3, work_field, user_id) 
values('내일부터 당장 일할 수 있습니다!', '간단 소개글입니다.', '안녕하십니까, 저는 동의대학교를 졸업하였고, 경력은 없으며 나이는 28세 입니다. 비록 비전공자이지만 동영상 강의로 이론을 배우고, 인터넷으로 스터디를 모집하여서 프로젝트를 통해 직접 코딩을 해볼 수 있었습니다. 저는 정말 착하고 순하며, 하라는 일은 모두 다 할수있습니다. 저를 뽑아주세요ㅎㅎ', '대학교 졸업', '동의대학교', '컴퓨터공학과', '신입', null, null, null, null, null, null, null, null, 'off', '없음', '없음', '없음', null, null, null,'http://www.naver.com', null, null, '백엔드 개발자', 2);
insert into resume_tb(title, semi_content, content, education, school, major, career1, career_periodS1, career_periodE1, career2, career_periodS2, career_periodE2, career3, career_periodS3, career_periodE3, open, etc1, etc_period1, etc2, etc_period2, etc3, etc_period3, link1, link2, link3, work_field, user_id) 
values('저는 학점이 4.5인 만점자입니다!', '간단한닥나단', '안녕하십니까, 저는 동의대학교 광고홍보학과를 졸업하여 광고를 제작하고 싶습니다. 이론은 물론이거와 독특한 생각들과 창의적인 아이디어로 이제껏 낸 프로젝트들이 수없이 많습니다. 제 git주소로 들어가보시면 많은 결과물을 보실 수 있을 것입니다.', '대학교 졸업', '동의대학교', '광고홍보학과', '네이버', '2020-05-05', '2022-01-05', '배달의 민족', '2018-06-01', '2019-07-11', null, null, null, 'off', '광고부문 우수상', '2021-04-30', null, null, null, null,'http://www.nancheonjae.com' ,'http://www.블로그광고.com', null, '앱 개발자', 3);


-- notice_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드', '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드', '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드', '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드', '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드', '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('삼성', 'on', '/samsung.png', '[삼성] 백엔드 개발자 구합니다.', '세미컨텐츠','프론트', '부산', '부산진구', '경력', '교육', '메인컨텐츠','종료일',4);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('엘지', 'on', '/lg.png', '[엘지] 앱 개발자 구합니다.', '세미컨텐츠','앱개발', '부산', '동래구', '경력', '교육', '메인컨텐츠','종료일',5);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line, user_id) 
values('엘지', 'on', '/lg.png', '[엘지] 백엔드 구합니다.','백엔드하실 노예들 모집합니다. 돈 버실분 급전필요하신분 야근 가능하신분 야식지원 없습니다. 주말출근 필수 포괄임금제입니다.', '백엔드', '부산', '서면', '신입', '대졸이상', '평생노예하실 구직자를 찾습니다. 지원없음','2023-09-15',5);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('카카오', 'on', '/kakao.png', '[카카오] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드',  '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',6);
insert into notice_tb(biz_name,open, user_img, semi_title, semi_content, work_field,  address, address2, career, education, main_content, dead_line,user_id)  
values('카카오', 'off', '/kakao.png', '[카카오] 백엔드 개발자 구합니다.', '세미컨텐츠','백엔드',  '서울', '광진구', '경력', '교육', '메인컨텐츠','종료일',6);


-- tech_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into tech_tb(techname) values('Python');
insert into tech_tb(techname) values('Spring Framework');
insert into tech_tb(techname) values('AWS');
insert into tech_tb(techname) values('Android');
insert into tech_tb(techname) values('Git');
insert into tech_tb(techname) values('IOS');
insert into tech_tb(techname) values('HTML');
insert into tech_tb(techname) values('JAVA');
insert into tech_tb(techname) values('JavaScript');
insert into tech_tb(techname) values('MySQL');
insert into tech_tb(techname) values('SQL');
insert into tech_tb(techname) values('Linux');
insert into tech_tb(techname) values('Kotlin');
insert into tech_tb(techname) values('C/C++');
insert into tech_tb(techname) values('React');
insert into tech_tb(techname) values('Docker');
insert into tech_tb(techname) values('JPA');
insert into tech_tb(techname) values('C#');

-- tech_notice_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into tech_notice_tb(notice_id, tech_id) values(10, 2);
insert into tech_notice_tb(notice_id, tech_id) values(10, 4);
insert into tech_notice_tb(notice_id, tech_id) values(10, 6);


-- tech_resume_tb 더미데이터------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into tech_resume_tb(resume_id, tech_id) values(1, 1);
insert into tech_resume_tb(resume_id, tech_id) values(1, 2);
insert into tech_resume_tb(resume_id, tech_id) values(2, 1);
insert into tech_resume_tb(resume_id, tech_id) values(2, 2);
insert into tech_resume_tb(resume_id, tech_id) values(2, 3);
insert into tech_resume_tb(resume_id, tech_id) values(3, 4);

