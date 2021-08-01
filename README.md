# routingdatasource
Spring JPA RoutingDataSource 를 사용한 Master/Slave DB 연동

Master, Slave 형태의 두 DB 연동이 필요한 경우, RoutingDataSource 를 활용할 수 있다.
AbstractRoutingDataSource르 상속받아 TargetDataSource로 Master, Slave의 Datasource를 등록하고
determinCurrentLookupKey를 오버라이드 해서, RoundRobin 또는 원하는 형태로 연동하려는 DB를 선택할 수 있다.
