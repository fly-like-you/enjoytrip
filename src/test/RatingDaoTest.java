package test;

import com.ssafy.rating.dao.RatingDao;
import com.ssafy.rating.dao.RatingDaoImpl;
import com.ssafy.rating.model.RatingDto;
import com.ssafy.rating.model.RatingsDto;
import util.TestUtil;
public class RatingDaoTest {
    private static final RatingDao ratingDao = RatingDaoImpl.getInstance();
    private static Integer tempMemberId;
    private static Integer tempAttractionId;

    public static void main(String[] args) {
        System.out.println("테스트에 필요한 더미 데이터를 생성합니다.");
        tempMemberId = TestUtil.createTempUser();
        tempAttractionId = TestUtil.createTempAttraction();
        System.out.println("------------ F15. 관광지 DAO CRUD 테스트를 시작합니다. ------------");

        /*            CREATE           */
        Integer ratingId = 평점_생성하기();

        /*            READ           */
        평점_id로_가져오기(ratingId);
        평점_memberId로_가져오기(tempMemberId);
        평점_attractionId로_가져오기(tempAttractionId);
        평점_memberId와_attractionId로_가져오기(tempMemberId, tempAttractionId);

        /*            UPDATE           */
        평점_수정하기(ratingId);

        /*            DELETE           */
        평점_삭제하기(ratingId);

        System.out.println("------------ F15. 관광지 DAO CRUD 테스트를 종료합니다. ------------");
        System.out.println("더미 데이터를 제거합니다.");
        TestUtil.deleteTempUser(tempMemberId);
        TestUtil.deleteTempAttraction(tempAttractionId);
    }

    // 평점 생성하기 테스트
    public static Integer 평점_생성하기() {
        RatingDto ratingDto = new RatingDto();
        ratingDto.setMemberId(tempMemberId);
        ratingDto.setAttractionId(tempAttractionId);
        ratingDto.setRate(5);  // 평점 5로 설정

        Integer ratingId = ratingDao.createRating(ratingDto);
        System.out.println("평점이 성공적으로 생성되었습니다. Rating ID: " + ratingId);
        return ratingId;
    }

    // 평점 ID로 조회 테스트
    public static void 평점_id로_가져오기(Integer ratingId) {
        RatingDto ratingDto = ratingDao.searchRatingById(ratingId);
        if (ratingDto != null) {
            System.out.println("평점을 성공적으로 가져왔습니다: " + ratingDto.getRate());
        } else {
            System.out.println("평점을 찾을 수 없습니다. ID: " + ratingId);
        }
    }

    // 특정 회원의 평점 조회 테스트
    public static void 평점_memberId로_가져오기(Integer memberId) {
        RatingsDto ratingsDto = ratingDao.searchRatingsByMemberId(memberId);
        if (ratingsDto != null && !ratingsDto.getRatings().isEmpty()) {
            System.out.println("해당 회원의 평점을 성공적으로 가져왔습니다. 총 " + ratingsDto.getRatings().size() + "개의 평점이 있습니다.");
        } else {
            System.out.println("해당 회원의 평점을 찾을 수 없습니다. Member ID: " + memberId);
        }
    }

    // 특정 관광지의 평점 조회 테스트
    public static void 평점_attractionId로_가져오기(Integer attractionId) {
        RatingsDto ratingsDto = ratingDao.searchRatingsByAttractionId(attractionId);
        if (ratingsDto != null && !ratingsDto.getRatings().isEmpty()) {
            System.out.println("해당 관광지의 평점을 성공적으로 가져왔습니다. 총 " + ratingsDto.getRatings().size() + "개의 평점이 있습니다.");
        } else {
            System.out.println("해당 관광지의 평점을 찾을 수 없습니다. Attraction ID: " + attractionId);
        }
    }

    // 특정 회원과 특정 관광지에 대한 평점 조회 테스트
    public static void 평점_memberId와_attractionId로_가져오기(Integer memberId, Integer attractionId) {
        RatingDto ratingDto = ratingDao.searchRatingByMemberIdAndAttractionId(memberId, attractionId);
        if (ratingDto != null) {
            System.out.println("해당 회원과 관광지의 평점을 성공적으로 가져왔습니다: " + ratingDto.getRate());
        } else {
            System.out.println("해당 회원과 관광지의 평점을 찾을 수 없습니다.");
        }
    }

    // 평점 수정하기 테스트
    public static void 평점_수정하기(Integer ratingId) {
        RatingDto ratingDto = ratingDao.searchRatingById(ratingId);
        if (ratingDto != null) {
            ratingDto.setRate(4);  // 평점을 4로 수정
            ratingDao.modifyRating(ratingDto);
            System.out.println("평점이 성공적으로 수정되었습니다. 새로운 평점: " + ratingDto.getRate());
        } else {
            System.out.println("수정할 평점을 찾을 수 없습니다. ID: " + ratingId);
        }
    }

    // 평점 삭제하기 테스트
    public static void 평점_삭제하기(Integer ratingId) {
        ratingDao.deleteRating(ratingId);
        System.out.println("평점이 성공적으로 삭제되었습니다. Rating ID: " + ratingId);
    }
}
