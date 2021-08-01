package com.shinasto.routingdatasource.common.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DanjiRoutingDataSource extends AbstractRoutingDataSource {

  private static final int MOD = 2;
  private static List<String> DATASOURCE_NAME;
  private static final AtomicInteger atomicInteger = new AtomicInteger(0);

  public DanjiRoutingDataSource(HikariDataSource master, DataSource slave) {
    super.setDefaultTargetDataSource(master);

    Map<Object, Object> targetDataSource = Map.of("master", master, "slave", slave);
    DATASOURCE_NAME = List.of("master", "slave");
    super.setTargetDataSources(targetDataSource);
  }

  @Override
  protected Object determineCurrentLookupKey() {

//    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//    if (request.getRequestURI().startsWith("/master")) {

    return DATASOURCE_NAME.get(atomicInteger.getAndIncrement() % MOD);
  }
}
