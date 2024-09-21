package test;

import com.ssafy.trip.dao.TripDao;
import com.ssafy.trip.dao.TripDaoImpl;
import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;
import java.sql.Date;
import java.util.List;

public class TripDaoTest {
    static final TripDao tripDao = TripDaoImpl.getTripDao();

    public static void main(String[] args) {
        System.out.println("------------ F01. 여행 계획 CRUD 테스트를 시작합니다. ------------");
        여행계획_생성하기();
        여행계획_모두_가져오기();
        여행계획_pk로_가져오기();
        여행계획_유저id로_가져오기();
        여행계획_수정하기();
        // 여행계획_제거하기();
        System.out.println("------------ F01. 여행 계획 테스트가 종료되었습니다. ------------");

    }

    private static void 여행계획_생성하기() {
        TripDto trip = new TripDto("temp", 1,
                new Date(2024 - 1900, 9, 18),
                new Date(2024 - 1900, 9, 20),
                new Date(System.currentTimeMillis()));

        tripDao.createTrip(trip);
    }

    private static void 여행계획_모두_가져오기() {
        System.out.println();
        List<TripDto> tripsDto = tripDao.searchTripsAll().getTrips();
        tripsDto.iterator().forEachRemaining(System.out::println);
    }

    private static void 여행계획_pk로_가져오기() {
        System.out.println();
        TripDto tripDto = tripDao.findById(1);
        System.out.println(tripDto);
    }

    private static void 여행계획_유저id로_가져오기() {
        System.out.println();
        TripsDto tripsDto = tripDao.findByMemberId(1);
        tripsDto.getTrips().iterator().forEachRemaining(System.out::println);
    }



    private static void 여행계획_수정하기() {
        TripDto tripDto = tripDao.findById(1);

        System.out.println("수정 전 여행 이름: " + tripDto.getName());

        tripDto.setName("수정된 여행계획 1");
        tripDao.modifyTrip(tripDto);

        TripDto modified = tripDao.findById(1);
        System.out.println("수정 후 여행 이름: " + modified.getName());
    }
    private static void 여행계획_제거하기() {
        tripDao.deleteTrip(1);

    }

}
