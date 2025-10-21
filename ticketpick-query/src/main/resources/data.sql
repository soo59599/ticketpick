-- 야구 경기 데이터
INSERT INTO game (home_team, away_team, game_date, stadium) VALUES
('두산 베어스', 'LG 트윈스', '2025-05-15 18:30:00', '잠실야구장'),
('삼성 라이온즈', 'KIA 타이거즈', '2025-05-15 18:30:00', '대구 삼성 라이온즈 파크'),
('한화 이글스', 'SSG 랜더스', '2025-05-16 18:30:00', '대전 한화생명 이글스파크');

-- 경기 1번 좌석
INSERT INTO seat (game_id, section, seat_number, price, is_reserved) VALUES
(1, '1루 테이블석', 'A-01', 45000, false),
(1, '1루 테이블석', 'A-02', 45000, false),
(1, '3루 테이블석', 'B-01', 45000, false),
(1, '외야 자유석', 'D-01', 15000, false),
(1, '외야 자유석', 'D-02', 15000, false);

-- 경기 2번 좌석
INSERT INTO seat (game_id, section, seat_number, price, is_reserved) VALUES
(2, '1루 테이블석', 'A-01', 40000, false),
(2, '외야 자유석', 'D-01', 12000, false);
