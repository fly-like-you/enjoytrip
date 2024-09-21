package test;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.service.AttractionService;
import com.ssafy.attraction.service.AttractionServiceImpl;
import java.util.List;

public class AttractionDaoTest {
    static AttractionService attractionService = AttractionServiceImpl.getBoardService();
    public static void main(String[] args) {

        모두찾기테스트();
    }

    // 모든 관광지의 정보를 불러오는 테스트
    private static void 모두찾기테스트() {
        List<AttractionDto> list = attractionService.searchAttractionsAll();

        System.out.println("********** 글목록(전체) **********");
        for(AttractionDto attr : list) {
            System.out.println(attr);
        }
    }

}
