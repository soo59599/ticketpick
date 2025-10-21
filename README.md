# 🎫 Ticketpick - 티켓 예매 플랫폼

MSA + CQRS 아키텍처 기반 야구 경기 티켓 예매 시스템

## 🏗️ 아키텍처

- **MSA**: 멀티 모듈 구조
- **CQRS**: Command/Query 분리
- **API Gateway**: Spring Cloud Gateway
- **모니터링**: Prometheus + Grafana
- **컨테이너화**: Docker Compose

## 🚀 실행 방법

### Docker로 실행
```bash
docker-compose up -d
```

### 접속
```
http://localhost:8080/api/games
```

## 📊 서비스 구성

| 서비스 | 포트 | 역할 |
|--------|------|------|
| Gateway | 8080 | API Gateway |
| Command | 8081 | 예매/취소 (쓰기) |
| Query | 8082 | 조회 (읽기) |
| Prometheus | 9090 | 메트릭 수집 |
| Grafana | 3000 | 대시보드 |

## 🎯 API 엔드포인트

### 경기 조회
```bash
GET /api/games
GET /api/games/{id}
```

### 좌석 조회
```bash
GET /api/seats?gameId={id}
```

### 예매
```bash
POST /api/reservations
{
  "seatId": 1,
  "customerName": "홍길동",
  "phoneNumber": "010-1234-5678"
}
```

### 예매 취소
```bash
DELETE /api/reservations/{id}
```

## 🛠️ 기술 스택

- Java 21
- Spring Boot 3.3.5
- Spring Cloud Gateway
- Spring Data JPA
- H2 Database
- Prometheus
- Grafana
- Docker & Docker Compose

## 📈 모니터링

- Prometheus: http://localhost:9090
- Grafana: http://localhost:3000 (admin/admin)