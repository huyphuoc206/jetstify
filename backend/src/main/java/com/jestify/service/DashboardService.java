package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.payload.DashboardResponse;
import com.jestify.repository.SongRepository;
import com.jestify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM")
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter();
    public List<DashboardResponse> searchUsersChart(String fromMonth, String toMonth) {
        LocalDate localFromMonth = LocalDate.parse(fromMonth, formatter);
        LocalDate localToMonth = LocalDate.parse(toMonth, formatter);
        List<DashboardResponse> results = new ArrayList<>();
        for (LocalDate date = localFromMonth; date.isBefore(localToMonth.plusMonths(1)); date = date.plusMonths(1)) {
            long count = userRepository.countActiveUsersByMonthYearRole(date.getMonthValue(), date.getYear(), AppConstant.CUSTOMER_ROLE);
            results.add(DashboardResponse.builder()
                    .key(date.getYear() + "-" + date.getMonth())
                    .value(count).build());
        }
        return results;
    }

    public Object searchSongsChart(String fromMonth, String toMonth) {
        LocalDate localFromMonth = LocalDate.parse(fromMonth, formatter);
        LocalDate localToMonth = LocalDate.parse(toMonth, formatter);
        List<DashboardResponse> results = new ArrayList<>();
        for (LocalDate date = localFromMonth; date.isBefore(localToMonth.plusMonths(1)); date = date.plusMonths(1)) {
            long count = songRepository.countSongsByMonthYear(date.getMonthValue(), date.getYear());
            results.add(DashboardResponse.builder()
                    .key(date.getYear() + "-" + date.getMonth())
                    .value(count).build());
        }
        return results;
    }
}
